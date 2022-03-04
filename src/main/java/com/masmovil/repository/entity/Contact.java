package com.masmovil.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "contacto")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTACTO")
    private Long contactId;

    @Column(name = "ID_CUENTA")
    private Long accountId;

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
