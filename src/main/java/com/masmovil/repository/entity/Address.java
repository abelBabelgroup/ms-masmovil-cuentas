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
@Table(name = "sede")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede")
    private Long addressId;

    @Column(name = "id_cuenta")
    private Long accountId;

    private boolean principal;

    private String provincia;

    private String municipio;

    @Column(name = "cod_postal")
    private String postalCode;

    @Column(name = "tipo_via")
    private String streetType;

    @Column(name = "calle")
    private String street;

    @Column(name = "numero")
    private String number;

    @Column(name = "bloque")
    private String block;

    private String portal;

    @Column(name = "planta")
    private String floor;

    @Column(name = "letra")
    private String letter;

}
