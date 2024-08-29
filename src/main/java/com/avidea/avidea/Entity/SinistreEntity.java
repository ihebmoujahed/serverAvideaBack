package com.avidea.avidea.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@Table(name = "sinistre")
@NoArgsConstructor
@AllArgsConstructor

public class SinistreEntity {
    @Id
    @Column(name="id_sinistre")
    @GeneratedValue
    private int id_sinistre;

    @Column(name = "numero_sinistre")
    private String numero_sinistre;

    @Column(name = "date_accident")
    private Date date_accident;

    @Column(name = "date_creation")
    private Date date_creation;

    @Column(name = "status")
    private String status;

    @Column(name = "id_contrat")
    private int idContrat;

}
