package com.simonpeg.service.implementasi;

import com.simonpeg.dao.PangkatRepository;
import com.simonpeg.dto.PangkatDTO;
import com.simonpeg.service.abs.PangkatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PangkatServiceImplementation implements PangkatService {
    @Autowired
    private PangkatRepository pangkatRepository;

    @Override
    public Map<String, Long> getPegawaiPerGolongan() {

        List<PangkatDTO> result = pangkatRepository.countPegawaiPerGolongan();

        Map<String, Long> data = new LinkedHashMap<>();

        for (PangkatDTO obj : result) {
            data.put(obj.getRiwayatPangkat(), obj.getJumlah());
        }

        return data;
    }
}
