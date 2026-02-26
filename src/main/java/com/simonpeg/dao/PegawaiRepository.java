package com.simonpeg.dao;

import com.simonpeg.entity.Pegawai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PegawaiRepository extends JpaRepository<Pegawai, Long> {

	@Query("""
			SELECT COUNT(*) FROM Pegawai
			""")
    public Long totalSeluruhPegawai();

    @Query("""
			SELECT COUNT(*)
			FROM Pegawai
			WHERE unit_kerja_id = 1
			""")
    public Long totalPegawaiKanwil();

	@Query("""
			SELECT COUNT(DISTINCT unit_kerja_id)
			FROM Pegawai """)
	public Long totalSatker();

    @Query("""
			SELECT COUNT(*)
			FROM Pegawai
			WHERE unit_kerja_id != 1
			""")
    public Long totalPegawaiUPT();
}
