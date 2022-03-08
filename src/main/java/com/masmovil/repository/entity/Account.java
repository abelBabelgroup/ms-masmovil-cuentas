package com.masmovil.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cuenta")
public class Account implements Serializable {

    @Id
    @Column(name = "id_cuenta")
    private Long accountId;

    private String cif;

    @Column(name = "nombre")
    private String name;

    @Column(name = "sitio_web")
    private String webSite;

    @Column(name = "id_propietario")
    private String ownerId;

    @Column(name = "fec_inicio_propiedad")
    private LocalDate startDateOwnership;

    @Column(name = "fec_fin_propiedad")
    private LocalDate endDateOwnership;

    @Column(name = "marcas")
    private String brands;

    @Column(name = "canal")
    private String channel;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta")
    private List<Contact> contacts;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cuenta")
    private List<Address> addresses;

    public static Account from(String ownerId, String name, String cif) {
        Account account = new Account();
        account.setOwnerId(ownerId);
        account.setName(name);
        account.setCif(cif);
        return account;
    }
}
