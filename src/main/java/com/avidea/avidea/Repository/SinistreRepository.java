package com.avidea.avidea.Repository;

import com.avidea.avidea.Entity.SinistreEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SinistreRepository extends JpaRepository<SinistreEntity, Integer> {
    List<SinistreEntity> findByIdContrat(int id_contrat);
    @Modifying
    @Transactional
    @Query("DELETE FROM SinistreEntity s WHERE s.idContrat = ?1")
    void deleteByIdContrat(int id_contrat);

}
