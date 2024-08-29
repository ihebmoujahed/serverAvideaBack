package com.avidea.avidea.Controller;
import com.avidea.avidea.Entity.SinistreEntity;
import com.avidea.avidea.Service.SinistreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sinistre")

public class SinistreController {

    @Autowired
    private SinistreService sinistreService;

    @PostMapping("/addsinistre")
    public ResponseEntity<SinistreEntity> postSinistre(@RequestBody SinistreEntity sinistre){
        SinistreEntity savedSinistre = sinistreService.saveSinistre(sinistre);
        return ResponseEntity.ok(savedSinistre);
    }
    @GetMapping
    public List<SinistreEntity> getAllSinistre() {
        return sinistreService.getAllSinistre();
    }
    @GetMapping("/{id_contrat}")
    public List<SinistreEntity> getSinistreByIdContrat(@PathVariable int id_contrat) {
        return sinistreService.getSinistreByIdContrat(id_contrat);
    }
    @DeleteMapping("/deleteSinistre/{id_sinistre}")
    public ResponseEntity<SinistreEntity> deleteSinistre(@PathVariable int id_sinistre) {
        Optional <SinistreEntity> sinistre = sinistreService.getSinistreById(id_sinistre);
        if (sinistre.isPresent()) {
            sinistreService.deleteSinistreById(id_sinistre);
            return ResponseEntity.ok(sinistre.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/updateSinistre")
    public ResponseEntity updateSinistre(@RequestBody SinistreEntity sinistre) {
        SinistreEntity savedSinistre = sinistreService.updateSinistre(sinistre);
        if (savedSinistre != null) {
            return ResponseEntity.ok(savedSinistre);
        }
        else return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/deleteByContrat/{id_contrat}")
    public ResponseEntity<Void> deleteSinistreByIdContrat(@PathVariable int id_contrat) {
        sinistreService.deleteSinistreByIdContrat(id_contrat);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sinistreId/{id_sinistre}")
    public ResponseEntity <SinistreEntity> getSinistreById(@PathVariable int id_sinistre) {
        Optional <SinistreEntity> sinistre = sinistreService.getSinistreById(id_sinistre);
        return sinistre.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
