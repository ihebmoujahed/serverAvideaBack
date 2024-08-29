package com.avidea.avidea.Repository;
import com.avidea.avidea.Entity.PhotoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Integer> {
    List<PhotoEntity> findByIdSinistre(int idSinistre);

    @Modifying
    @Transactional
    @Query("Delete From PhotoEntity p WHERE p.idSinistre = ?1")
    void deleteByIdSinistre(int id_sinistre);
}
