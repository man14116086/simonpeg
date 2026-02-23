package com.simonpeg.service.abs;

import org.springframework.stereotype.Service;

@Service
public interface PegawaiService {
    public Long totalSeluruhPegawai();
    public Long totalPegawaiKanwil();
    public Long totalSatker();
}
