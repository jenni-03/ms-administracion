package com.administracion.repository;

import com.administracion.dto.ProblemasXCategoriaProjection;
import com.administracion.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Query("SELECT c.tipo as categoria, COUNT(p.id) as cantidadProblemas " +
            "FROM Categoria c " +
            "LEFT JOIN Problema p ON c.id = p.categoria.id " +
            "GROUP BY c.tipo " +
            "ORDER BY cantidadProblemas DESC ")
    List<ProblemasXCategoriaProjection> findProblemasByCategoria();
}
