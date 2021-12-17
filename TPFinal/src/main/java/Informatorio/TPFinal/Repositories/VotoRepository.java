package Informatorio.TPFinal.Repositories;

import Informatorio.TPFinal.Models.VotoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotoRepository extends JpaRepository<VotoModel, Long> {
    List<VotoModel> findByUsuarioId(Long usuarioId);
}