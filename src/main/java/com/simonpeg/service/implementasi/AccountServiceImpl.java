package com.simonpeg.service.implementasi;

import com.simonpeg.dao.AccountRepository;
import com.simonpeg.dto.AccountDTO;
import com.simonpeg.dto.AccountUpsertDto;
import com.simonpeg.entity.Account;
import com.simonpeg.service.abs.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Boolean checkExistingAccount(String username) {
        Long totalUser = accountRepository.countAccount(username);
        return (totalUser > 0) ? true : false;
    }

    @Override
    public Account getAccount(String username) {
        return accountRepository.Account(username);
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    public void registerAccount(AccountUpsertDto dtoAccount) {
        if(checkExistingAccount(dtoAccount.getUsername())){
            throw new RuntimeException("Username already exists");
        }
        String hashPassword = passwordEncoder.encode(dtoAccount.getPassword());
        Account account = new Account();
        account.setUsername(dtoAccount.getUsername());
        account.setPassword(hashPassword);
        accountRepository.save(account);
    }
}
