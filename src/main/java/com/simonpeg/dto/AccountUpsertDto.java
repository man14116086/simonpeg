package com.simonpeg.dto;

import com.simonpeg.validation.CheckPassword;
import com.simonpeg.validation.CheckUsername;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@CheckPassword(password = "password", passwordConfirm = "passwordConfirm", message = "Password tidak sama")
public class AccountUpsertDto {

    @NotBlank(message = "Username wajib diisi")
    @CheckUsername(message = "Username sudah terdaftar")
    @Size(min = 6, max = 20, message = "Username tidak boleh lebih dari 20 karakter")
    private String username;

    @NotBlank(message = "Password wajib diisi")
    @Size(min = 8, max = 200, message = "Password tidak boleh lebih dari 200 karakter")
    private String password;

    @NotBlank(message = "Password wajib diisi")
    @Size(min = 8, max = 200, message = "Password tidak boleh lebih dari 200 karakter")
    private String passwordConfirm;

    public AccountUpsertDto(String username, String password){
        this.username = username;
        this.password = password;
    }
}
