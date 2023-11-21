package com.administracion.repository;

import com.administracion.entity.Tabla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablaRepository extends JpaRepository<Tabla, Integer> {
}
