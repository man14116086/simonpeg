package com.simonpeg.service.abs;

import com.simonpeg.dto.AccountUpsertDto;
import com.simonpeg.entity.Account;

import java.util.Optional;

public interface AccountService {
    public Boolean checkExistingAccount(String username);

    public Account getAccount(String username);

    public Optional<Account> findByUsername(String username);

    public void registerAccount(AccountUpsertDto dtoAccount);

}
