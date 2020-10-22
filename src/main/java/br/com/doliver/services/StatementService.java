package br.com.doliver.services;

import br.com.doliver.entities.AccountEntity;
import br.com.doliver.entities.StatementEntity;
import br.com.doliver.forms.AccountForm;
import br.com.doliver.forms.StatementForm;
import br.com.doliver.repositories.AccountRepository;
import br.com.doliver.repositories.StatementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StatementService {

    @Autowired
    private StatementRepository repository;

    @Autowired
    private AccountRepository accountRepository;

    private static final Logger logger = LoggerFactory.getLogger(StatementService.class);

    public StatementForm create(StatementForm form) throws Exception {
        final AccountEntity account = accountRepository.getOne(form.getAccount().getAccountId());
        StatementEntity statement = StatementEntity.builder()
                .account(account)
                .description(form.getDescription())
                .amount(form.getAmount())
                .category(form.getCategory())
                .createdAt(form.getCreatedAt())
                .build();
        statement = repository.save(statement);

        logger.info(String.format("New statement registered. statement { id: $d, description: %s, ammount: $d, category: %4}",
                statement.getStatementId(),
                statement.getDescription(),
                statement.getAmount(),
                statement.getCategory().name()));

        return builder(statement);
    }

    public List<StatementForm> listByAccountId(BigInteger accountId) throws Exception {
        final AccountEntity account = accountRepository.getOne(accountId);
        final List<StatementEntity> statements = repository.findByAccount(account);
        final List<StatementForm> forms = new ArrayList<>();
        statements.forEach(it -> forms.add(builder(it)));
        return forms;
    }

    private StatementForm builder(StatementEntity statement) {
        final AccountForm accountForm = AccountForm.builder()
                .accountId(statement.getAccount().getAccountID())
                .alias(statement.getAccount().getAlias())
                .accountType(statement.getAccount().getAccountType())
                .balance(statement.getAccount().getBalance())
                .build();

        return StatementForm.builder()
                .statementId(statement.getStatementId())
                .account(accountForm)
                .amount(statement.getAmount())
                .createdAt(statement.getCreatedAt())
                .description(statement.getDescription())
                .category(statement.getCategory())
                .build();
    }
}
