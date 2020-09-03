package br.com.doliversilva.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class AccountEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;
}
