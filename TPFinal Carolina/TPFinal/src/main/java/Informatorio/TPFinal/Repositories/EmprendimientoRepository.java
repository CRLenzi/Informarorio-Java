package Informatorio.TPFinal.Repositories;

import Informatorio.TPFinal.Models.EmprendimientoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprendimientoRepository extends JpaRepository<EmprendimientoModel, Long> {
}