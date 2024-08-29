package com.avidea.avidea.Service;

import com.avidea.avidea.Entity.ContratEntity;
import com.avidea.avidea.Repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratService {
    @Autowired
    private ContratRepository contratRepository;

    public ContratEntity saveDetails(ContratEntity contrat) {
        return contratRepository.save(contrat);
    }

    public List<ContratEntity> getAllContrat() {
        return contratRepository.findAll();
    }

    public Optional<ContratEntity> getContratById(int id_contrat) {
        return contratRepository.findById(id_contrat);
    }

    public void deleteContratById(int id_contrat) {
        contratRepository.deleteById(id_contrat);
    }

    public ContratEntity updateContratById(ContratEntity contrat) {
        if (contratRepository.existsById(contrat.getId_contrat())) {
            return contratRepository.save(contrat);
        }
        return null;
    }
}
