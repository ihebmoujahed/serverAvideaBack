package com.avidea.avidea.Controller;
import com.avidea.avidea.Entity.PhotoEntity;
import com.avidea.avidea.Service.PhotoService;
import com.avidea.avidea.Repository.PhotoRepository;
import org.springframework.core.io.ByteArrayResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/photo")

public class PhotoController {
    @Autowired
    private PhotoService photoService;
    @Autowired
    private PhotoRepository photoRepository;

    @PostMapping("/addPhotoSinistre")
    public ResponseEntity<?> uploadPhoto(@RequestParam("file") MultipartFile file, @RequestParam("id_sinistre") Integer idSinistre) {
        try {
            byte[] photoBytes = file.getBytes();

            PhotoEntity photo = new PhotoEntity();
            photo.setPhoto(photoBytes);
            photo.setIdSinistre(idSinistre);

            photoRepository.save(photo);

            return ResponseEntity.ok("Photo uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading photo");
        }
    }
    @GetMapping("/getPhotosBySinistre")
    public ResponseEntity<List<PhotoEntity>> getPhotosBySinistre(@RequestParam("id_sinistre") Integer idSinistre) {
        List<PhotoEntity> photos = photoService.getPhotosBySinistre(idSinistre);
        if (photos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(photos);
    }

    @GetMapping("/photo/{id}")
    public ResponseEntity<ByteArrayResource> getPhoto(@PathVariable Integer id) {
        Optional<PhotoEntity> photoOpt = photoRepository.findById(id);
        if (photoOpt.isPresent()) {
            PhotoEntity photo = photoOpt.get();
            return ResponseEntity.ok()
                    .contentType(org.springframework.http.MediaType.IMAGE_JPEG)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=photo.jpg")
                    .body(new ByteArrayResource(photo.getPhoto()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @DeleteMapping("/deletePhoto/{id}")
    public ResponseEntity<?> deletePhoto(@PathVariable Integer id) {
        Optional<PhotoEntity> photoOpt = photoRepository.findById(id);
        if (photoOpt.isPresent()) {
            photoService.deletePhoto(id);
            return ResponseEntity.ok("Photo deleted successfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/DeletePhotoByidSinistre/{id_sinistre}")
    public ResponseEntity<Void> deletePhotoByidSinistre(@PathVariable int id_sinistre) {
        photoService.deletePhotoBySinistre(id_sinistre);
        return ResponseEntity.noContent().build();
    }

}
