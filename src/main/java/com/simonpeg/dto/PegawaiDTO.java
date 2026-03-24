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
public class PegawaiDTO {

    private String nip;
    private String nama;
    private String jenisKelamin;
    private LocalDate tanggalLahir;
    private String email;
    private String namaJabatan;
    private String namaUnitKerja;

}
