package com.simonpeg.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pegawai")
public class PegawaiController {


    @GetMapping("/index")
    public String dashboard(Model model) {

        return "pegawai/pegawai";
    }
}
