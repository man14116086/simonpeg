package com.simonpeg.service.implementasi;

import com.simonpeg.dao.PegawaiRepository;
import com.simonpeg.dto.PegawaiDTO;
import com.simonpeg.service.abs.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PegawaiServiceImpl implements PegawaiService {

    @Autowired
    private PegawaiRepository pegawaiRepository;

    @Override
    public Long getCountPage(String nip, String nama, String namaJabatan) {
        var rowPerPage = 10;
        double totalData = (double) pegawaiRepository.getCount(nip, nama, namaJabatan);
        long totalPage = (long)(Math.ceil(totalData / rowPerPage));
        return totalPage;
    }

    @Override
    public List<PegawaiDTO> getAll(String nip, String nama, String namaJabatan, Integer page) {
        Integer getRowsPage = 10;
        Pageable pagination = PageRequest.of(page-1, getRowsPage, Sort.by("nip"));
        var result = pegawaiRepository.getAll(nip, nama, namaJabatan, pagination);
        return result;
    }

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
