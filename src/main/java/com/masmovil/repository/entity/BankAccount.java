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
@Table(name = "cuenta_bancaria")
public class BankAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta_bancaria")
    private Long bankAccountId;

    @Column(name = "id_cuenta")
    private Long accountId;

    @Column(name = "numero_cuenta")
    private Long accountNumber;
}
