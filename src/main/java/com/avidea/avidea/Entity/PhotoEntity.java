package com.avidea.avidea.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name = "photo")
@NoArgsConstructor
@AllArgsConstructor

public class PhotoEntity {
    @Id
    @Column(name="id_photo")
    @GeneratedValue
    private int id_photo;


    @Column(name = "photo", length = 1000)
    private byte[]  photo;

    @Column(name = "id_sinistre")
    private int idSinistre;

}
