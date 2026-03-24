package com.simonpeg.controller;

import com.simonpeg.service.abs.PangkatService;
import com.simonpeg.service.abs.PegawaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class DashboardController {

    @Autowired
    private final PegawaiService pegawaiService;

    @Autowired
    private final PangkatService pangkatService;

    @GetMapping("/index")
    public String dashboard(Model model) {

        model.addAttribute("totalSeluruhPegawai", pegawaiService.totalSeluruhPegawai());
        model.addAttribute("pegawaiKanwil", pegawaiService.totalPegawaiKanwil());
        model.addAttribute("totalSatker", pegawaiService.totalSatker());
        model.addAttribute("totalPegawaiUPT", pegawaiService.totalPegawaiUPT());
//        model.addAttribute("akanPensiun", pegawaiService.totalPegawaiAkanPensiun());

        Map<String, Long> chartData = pangkatService.getPegawaiPerGolongan();

        model.addAttribute("labels", chartData.keySet());
        model.addAttribute("values", chartData.values());

        return "home/index";
    }
}
