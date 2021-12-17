package Informatorio.TPFinal.Repositories;

import Informatorio.TPFinal.Models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    List<UsuarioModel> findByCiudad(String ciudad);
    @Query("from UsuarioModel where fechaDeCreacion >= ?1T00:00:00")
    List<UsuarioModel> findByFechaDeCreacion(LocalDateTime fechaDeCreacion);
}