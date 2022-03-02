package com.masmovil.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sedes")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SEDE")
    private Long addressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CUENTA")
    private Account accountId;

    private boolean principal;

    private String provincia;

    private String municipio;

    @Column(name = "COD_POSTAL")
    private String postalCode;

    @Column(name = "TIPO_VIA")
    private String streetType;

    private String street;

    private String number;

    private String block;

    private String portal;

    private String floor;

    private String letter;

}
