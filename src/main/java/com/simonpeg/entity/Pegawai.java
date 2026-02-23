package com.simonpeg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Pegawai")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pegawai {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long idPegawai;

    @Column(name="nip")
    private String nip;

    @Column(name="nama")
    private String nama;

    @Column(name="jenis_kelamin")
    private String jenisKelamin;

    @Column(name="tanggal_lahir")
    private LocalDate tanggalLahir;

    @Column(name="email")
    private String email;

    @Column(name="unit_kerja_id")
    private Long unitKerjaId;
}
