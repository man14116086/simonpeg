package com.simonpeg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Pegawai")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pegawai {
    @Id
    @Column(name="nip")
    private String nip;

    @Column(name="nama")
    private String nama;

    @Column(name="jenisKelamin")
    private String jenisKelamin;

    @Column(name="tanggalLahir")
    private LocalDate tanggalLahir;

    @Column(name="email")
    private String email;

    @Column(name="unitKerjaId")
    private Long unitKerjaId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "nip", insertable = false, updatable = false)
    private List<Jabatan> jabatan;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "nip", insertable = false, updatable = false)
    private List<Pangkat> pangkat;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unitKerjaId", insertable = false, updatable = false)
    private Satker satker;

    public Pegawai(String nip, String nama, String jenisKelamin, LocalDate tanggalLahir, String email, Long unitKerjaId) {
        this.nip = nip;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tanggalLahir;
        this.email = email;
        this.unitKerjaId = unitKerjaId;
    }

}
