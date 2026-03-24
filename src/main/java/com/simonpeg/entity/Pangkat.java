package com.simonpeg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Pangkat")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pangkat {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nip")
    private String nip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nip", insertable = false, updatable = false)
    private Pegawai pegawai;

    @Column(name="riwayatPangkat")
    private String riwayatPangkat;

    @Column(name="tmtPangkat")
    private LocalDate tmtPangkat;

    @Column(name="nomorSK")
    private String nomorSK;

    public Pangkat(Long id, String nip, String riwayatPangkat, LocalDate tmtPangkat, String nomorSK) {
        this.id = id;
        this.nip = nip;
        this.riwayatPangkat = riwayatPangkat;
        this.tmtPangkat = tmtPangkat;
        this.nomorSK = nomorSK;
    }
}
