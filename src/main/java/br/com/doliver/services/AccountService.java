package br.com.doliver.services;

import br.com.doliver.entities.AccountEntity;
import br.com.doliver.forms.AccountForm;
import br.com.doliver.repositories.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Slf4j
@Repository
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public AccountForm create(AccountForm form) {
        AccountEntity account = AccountEntity.builder()
                .accountType(form.getAccountType())
                .alias(form.getAlias())
                .balance(BigDecimal.ZERO)
                .createdAt(Calendar.getInstance())
                .updatedAt(Calendar.getInstance())
                .build();
        account = repository.save(account);
        log.info(String.format("New account registered. account{id:%d, alias:%s, account_type:%s}", account.getAccountID(), account.getAlias(), account.getAccountType()));
        return AccountForm.builder()
                .accountId(account.getAccountID())
                .alias(account.getAlias())
                .accountType(account.getAccountType())
                .build();
    }

    public List<AccountForm> listAll() {
        List<AccountEntity> accounts = repository.findAll();
        List<AccountForm> response = new ArrayList<>();
        accounts.forEach(it -> {
            response.add(AccountForm.builder()
                    .accountId(it.getAccountID())
                    .accountType(it.getAccountType())
                    .alias(it.getAlias())
                    .balance(it.getBalance())
                    .build());
        });
        return response;
    }
}
