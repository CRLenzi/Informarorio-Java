package Informatorio.TPFinal.Repositories;

import Informatorio.TPFinal.Models.TagModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagModel, Long> {
    TagModel findByNombre(String nombre);
}