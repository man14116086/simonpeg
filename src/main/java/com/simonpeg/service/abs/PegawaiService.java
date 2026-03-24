package com.simonpeg.service.abs;

import com.simonpeg.dto.PegawaiDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PegawaiService {
    public Long getCountPage(String nip, String nama, String namaJabatan);

    public List<PegawaiDTO> getAll(String nip, String nama, String namaJabatan, Integer page);
    public Long totalSeluruhPegawai();
    public Long totalPegawaiKanwil();
    public Long totalSatker();
    public Long totalPegawaiUPT();
}
