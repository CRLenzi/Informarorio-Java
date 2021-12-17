package Informatorio.TPFinal.Repositories;

import Informatorio.TPFinal.Models.EventoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<EventoModel, Long> {
}