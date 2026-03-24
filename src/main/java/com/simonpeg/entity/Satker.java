package com.simonpeg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Satker")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Satker {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="namaUnitKerja")
    private String namaUnitKerja;
}
