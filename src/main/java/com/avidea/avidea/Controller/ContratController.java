package com.avidea.avidea.Controller;

import com.avidea.avidea.Entity.ContratEntity;
import com.avidea.avidea.Service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {

    @Autowired
    private ContratService contratService;

    @PostMapping("/addcontrat")
    public ResponseEntity<ContratEntity> postContrat(@RequestBody ContratEntity contrat) {
        ContratEntity savedContrat = contratService.saveDetails(contrat);
        return ResponseEntity.ok(savedContrat);
    }
    @GetMapping
    public List<ContratEntity> getAllContrat() {
        return contratService.getAllContrat();
    }
    @GetMapping("/{id_contrat}")
    public ResponseEntity<ContratEntity> getContratById(@PathVariable int id_contrat) {
        Optional<ContratEntity> contrat = contratService.getContratById(id_contrat);
        return contrat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/deleteContrat/{id_contrat}")
    public ResponseEntity<?> deleteContratById(@PathVariable int id_contrat) {
        Optional<ContratEntity> contrat = contratService.getContratById(id_contrat);
        if (contrat.isPresent()) {
            contratService.deleteContratById(id_contrat);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateContrat")
    public ResponseEntity<ContratEntity> updateContrat(@RequestBody ContratEntity contrat) {
        ContratEntity updatedContrat = contratService.updateContratById(contrat);
        if (updatedContrat != null) {
            return ResponseEntity.ok(updatedContrat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}