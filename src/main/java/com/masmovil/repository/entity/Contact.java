package com.masmovil.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "contacto")
public class Contact implements Serializable {

    @Id
    @Column(name = "ID_CONTACTO")
    private Long contactId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CUENTA")
    private Account accountId;

    @Column(name = "TIPO_DOCUMENTO")
    private String documentType;

    @Column(name = "DOCUMENTO")
    private String document;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "APELLIDO")
    private String surname;

    @Column(name = "TELEFONO")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TIPO")
    private String type;

    @Column(name = "APODERADO")
    private boolean manager;

}
