package com.avidea.avidea.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@Table(name = "contrat")
@NoArgsConstructor
@AllArgsConstructor
public class ContratEntity {
    @Id
    @Column(name="id_contrat")
    @GeneratedValue
    private int id_contrat;

    @Column(name = "numero_contrat")
    private String numero_contrat;

    @Column(name = "datedebut")
    private Date datedebut;

    @Column(name = "datefin")
    private Date datefin;

    @Column(name = "nom_assure")
    private String nom_assure;

    @Column(name = "numero_immatriculation")
    private String numero_immatriculation;


}


