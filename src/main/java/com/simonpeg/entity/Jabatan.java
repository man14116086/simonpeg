package com.simonpeg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Jabatan")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Jabatan {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nip")
    private String nip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nip", insertable = false, updatable = false)
    private Pegawai pegawai;

    @Column(name="namaJabatan")
    private String namaJabatan;

    @Column(name="tmtJabatan")
    private LocalDate tmtJabatan;

    @Column(name="nomorSK")
    private String nomorSK;

    public Jabatan(Long id, String nip, String namaJabatan, LocalDate tmtJabatan, String nomorSK) {
        this.id = id;
        this.nip = nip;
        this.namaJabatan = namaJabatan;
        this.tmtJabatan = tmtJabatan;
        this.nomorSK = nomorSK;
    }

}
