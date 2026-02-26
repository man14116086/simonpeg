package com.simonpeg.controller;

import com.simonpeg.service.abs.PegawaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class DashboardController {

    @Autowired
    private final PegawaiService pegawaiService;
    //private final NotifikasiRepository notifRepo;

    @GetMapping("/index")
    public String dashboard(Model model) {

        model.addAttribute("totalSeluruhPegawai", pegawaiService.totalSeluruhPegawai());
        model.addAttribute("totalPegawaiKanwil", pegawaiService.totalPegawaiKanwil());
        model.addAttribute("totalSatker", pegawaiService.totalSatker());
        model.addAttribute("totalPegawaiUPT", pegawaiService.totalPegawaiUPT());
//        model.addAttribute("akanPensiun", pegawaiService.totalPegawaiAkanPensiun());

        return "home/index";
    }
}
