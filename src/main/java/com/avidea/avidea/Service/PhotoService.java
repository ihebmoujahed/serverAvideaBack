package com.avidea.avidea.Service;

import com.avidea.avidea.Entity.PhotoEntity;
import com.avidea.avidea.Repository.PhotoRepository;
import com.avidea.avidea.Repository.SinistreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private SinistreRepository sinistreRepository;

    public PhotoEntity savePhoto(MultipartFile file, Integer idSinistre) throws IOException {
        PhotoEntity photo = new PhotoEntity();
        photo.setPhoto(file.getBytes());
        photo.setIdSinistre(idSinistre);
        return photoRepository.save(photo);
    }

    public List<PhotoEntity> getPhotosBySinistre(Integer idSinistre) {
        return photoRepository.findByIdSinistre(idSinistre);
    }

    public void deletePhoto(Integer idPhoto) {

        photoRepository.deleteById(idPhoto);
    }
    public void deletePhotoBySinistre(int id_sinistre) {
        photoRepository.deleteByIdSinistre(id_sinistre);
    }
}

