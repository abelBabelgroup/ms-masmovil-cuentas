package com.masmovil.repository;

import com.masmovil.repository.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    List<Cuenta> findAllByIdPropietario(String idPropietario);
    List<Cuenta> findAllByIdPropietarioAndNombre(String idPropietario, String nombre);
    List<Cuenta> findAllByIdPropietarioAndNombreAndCif(String idPropietario, String nombre, String cif);
}
