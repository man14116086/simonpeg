package com.simonpeg.dao;

import com.simonpeg.dto.PegawaiDTO;
import com.simonpeg.entity.Pegawai;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PegawaiRepository extends JpaRepository<Pegawai, Long> {

	@Query("""
            SELECT COUNT(pgw.nip) 
            FROM Pegawai AS pgw
            JOIN Jabatan AS jb ON pgw.nip = jb.nip
			WHERE pgw.nip LIKE %:nip% AND pgw.nama LIKE %:nama% AND jb.namaJabatan LIKE %:namaJabatan%
			ORDER BY unitKerjaId
			""")
	public Long getCount(@Param("nip") String nip, @Param("nama") String nama, @Param("namaJabatan") String namaJabatan);

	@Query("""
            SELECT new com.simonpeg.dto.PegawaiDTO 
            		(pgw.nip, pgw.nama, pgw.jenisKelamin, pgw.tanggalLahir, pgw.email, jb.namaJabatan, st.namaUnitKerja) 
            FROM Pegawai AS pgw
            JOIN Jabatan AS jb ON pgw.nip = jb.nip
            JOIN Satker AS st ON pgw.unitKerjaId = st.id
			WHERE pgw.nip LIKE %:nip% AND pgw.nama LIKE %:nama% AND jb.namaJabatan LIKE %:namaJabatan%
			ORDER BY unitKerjaId
            """)
	public List<PegawaiDTO> getAll(@Param("nip") String nip, @Param("nama") String nama, @Param("namaJabatan") String namaJabatan, Pageable pagination);
	@Query("""
			SELECT COUNT(*) FROM Pegawai
			""")
    public Long totalSeluruhPegawai();

    @Query("""
			SELECT COUNT(*)
			FROM Pegawai
			WHERE unitKerjaId = 1
			""")
    public Long totalPegawaiKanwil();

	@Query("""
			SELECT COUNT(DISTINCT unitKerjaId)
			FROM Pegawai """)
	public Long totalSatker();

    @Query("""
			SELECT COUNT(*)
			FROM Pegawai
			WHERE unitKerjaId != 1
			""")
    public Long totalPegawaiUPT();
}
