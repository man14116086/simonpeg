package com.simonpeg.service.implementasi;

import com.simonpeg.dao.PegawaiRepository;
import com.simonpeg.service.abs.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PegawaiServiceImpl implements PegawaiService {

    @Autowired
    private PegawaiRepository pegawaiRepository;

    @Override
    public Long totalSeluruhPegawai() {
        return pegawaiRepository.totalSeluruhPegawai();
    }

    @Override
    public Long totalPegawaiKanwil() {
        return pegawaiRepository.totalPegawaiKanwil();
    }

    @Override
    public Long totalSatker() {
        return pegawaiRepository.totalSatker();
    }

    @Override
    public Long totalPegawaiUPT() {
        return pegawaiRepository.totalPegawaiUPT();
    }
}
