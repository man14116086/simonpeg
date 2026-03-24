package com.simonpeg.controller;

import com.simonpeg.service.abs.PegawaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pegawai")
public class PegawaiController {

    @Autowired
    private PegawaiService pegawaiService;

    @GetMapping("/index")
    public String indexPegawai(Model model, @RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "") String nip,
                               @RequestParam(defaultValue = "") String nama,
                               @RequestParam(defaultValue = "") String namaJabatan) {
        model.addAttribute("listPegawai", pegawaiService.getAll(nip, nama, namaJabatan, page));
        long totalPage = pegawaiService.getCountPage(nip, nama, namaJabatan);
        if(totalPage == 0){
            totalPage = 1;
            page = 1;
        }
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", totalPage);

        return "pegawai/index";
    }
}
