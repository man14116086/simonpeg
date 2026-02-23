package com.simonpeg.dao;

import com.simonpeg.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    @Query("""
			SELECT COUNT(acc.username)
			FROM Account AS acc
			WHERE acc.username = :username	""")
    public Long countAccount(@Param("username") String username);

	Optional<Account> findByUsername(String username);

	@Query("""
            SELECT COUNT(acc.username)
            FROM Account AS acc
            WHERE acc.username = :username
            """)
	public Long getUsername(@Param("username") String username);

	@Query("""
            SELECT acc
            FROM Account AS acc
            WHERE acc.username = :username
            """)
	public Account Account(@Param("username") String username);
}
