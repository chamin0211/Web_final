package com.example.demo.service;


import com.example.demo.dto.AccountDto;
import com.example.demo.entity.AccountEntity;
import com.example.demo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public boolean checkId(AccountDto dto){
        AccountDto pwd = accountRepository.findAccountByUsername(dto.getUsername()); // 여기 findby 하면
 // 아이디 비번 세트로 가져오고, 없으면 null
        if(pwd == null) {
            return false;
        }
        return dto.getPassword().equals(pwd.getPassword());
    }

    public AccountEntity createId(AccountDto dto) {
        AccountEntity account = AccountEntity.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();
        return accountRepository.save(account);   // save

    }
}
