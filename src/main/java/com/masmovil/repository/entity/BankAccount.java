package com.masmovil.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cuentas_bancarias")
public class BankAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CUENTA_BANCARIA")
    private Long bankAccountId;

    @Column(name = "ID_CUENTA")
    private Long accountId;

    @Column(name = "NUMERO_CUENTA")
    private Long accountNumber;
}
