package com.avidea.avidea.Service;

import com.avidea.avidea.Entity.SinistreEntity;
import com.avidea.avidea.Repository.SinistreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SinistreService {
    @Autowired
    private SinistreRepository sinistreRepository;

    public List<SinistreEntity> getAllSinistre() {
        return sinistreRepository.findAll();
    }

    public SinistreEntity saveSinistre(SinistreEntity sinistreEntity) {
        return sinistreRepository.save(sinistreEntity);
    }

    public List<SinistreEntity> getSinistreByIdContrat(int id_contrat) {
        return sinistreRepository.findByIdContrat(id_contrat);
    }
    public Optional<SinistreEntity> getSinistreById(int id_sinistre) {
        return sinistreRepository.findById(id_sinistre);
    }
    public void deleteSinistreById(int id_sinistre) {
        sinistreRepository.deleteById(id_sinistre);
    }
    public SinistreEntity updateSinistre(SinistreEntity sinistreEntity) {
        if(sinistreRepository.findById(sinistreEntity.getId_sinistre()).isPresent()) {
            return sinistreRepository.save(sinistreEntity);
        }
        return null;
    }
    public void deleteSinistreByIdContrat(int id_contrat) {
        sinistreRepository.deleteByIdContrat(id_contrat);
    }

}
