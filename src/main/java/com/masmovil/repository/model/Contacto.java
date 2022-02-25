package com.masmovil.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "contacto")
public class Contacto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTACTO")
    private Long idContacto;

    @Column(name = "ID_CUENTA")
    private Integer idCuenta;

    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;

    @Column(name = "DOCUMENTO")
    private String documento;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDOS")
    private String apellidos;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "APODERADO")
    private boolean apoderado;

}
