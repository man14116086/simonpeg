package com.simonpeg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PangkatDTO {
    private String nip;
    private String riwayatPangkat;
    private LocalDate tmtPangkat;
    private Long jumlah;
    private String nomorSK;

    public PangkatDTO(String riwayatPangkat, Long jumlah) {
        this.riwayatPangkat = riwayatPangkat;
        this.jumlah = jumlah;
    }
}
