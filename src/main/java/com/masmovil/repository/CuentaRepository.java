package com.masmovil.repository;

import com.masmovil.repository.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    List<Cuenta> findByIdPropietario(String idPropietario);

    List<Cuenta> findByIdPropietarioAndNombreOrCif(String idPropietario, String nombre, String cif);
}
