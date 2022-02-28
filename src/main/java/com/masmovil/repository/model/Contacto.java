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

    private String documento;

    private String nombre;

    private String apellidos;

    private String telefono;

    private String email;

    private String tipo;

    private boolean apoderado;

}
