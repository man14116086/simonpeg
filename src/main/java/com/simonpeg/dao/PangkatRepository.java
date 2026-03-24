package com.simonpeg.dao;

import com.simonpeg.dto.PangkatDTO;
import com.simonpeg.entity.Pangkat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PangkatRepository extends JpaRepository<Pangkat, Long> {
    @Query("""
            SELECT new com.simonpeg.dto.PangkatDTO (p.riwayatPangkat, COUNT(p.nip) as jumlah)
            FROM Pangkat p
            WHERE p.tmtPangkat = (
                SELECT MAX(p2.tmtPangkat)
                FROM Pangkat p2
                WHERE p2.nip = p.nip
            )
            GROUP BY p.riwayatPangkat
            ORDER BY p.riwayatPangkat 
            """)
    public List<PangkatDTO> countPegawaiPerGolongan();
}
