package Informatorio.TPFinal.Services;

import Informatorio.TPFinal.Models.EmprendimientoModel;
import Informatorio.TPFinal.Models.TagModel;
import Informatorio.TPFinal.Models.UsuarioModel;
import Informatorio.TPFinal.Repositories.EmprendimientoRepository;
import Informatorio.TPFinal.Repositories.TagRepository;
import Informatorio.TPFinal.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
public class EmprendimientoService {
    private final EmprendimientoRepository emprendimientoRepository;
    private final UsuarioRepository usuarioRepository;
    private final TagRepository tagRepository;
    @Autowired
    public EmprendimientoService(EmprendimientoRepository emprendimientoRepository,
                                 UsuarioRepository usuarioRepository,
                                 TagRepository tagRepository) {
        this.emprendimientoRepository = emprendimientoRepository;
        this.usuarioRepository = usuarioRepository;
        this.tagRepository = tagRepository;
    }

    public EmprendimientoModel guardar(Long usuarioId, EmprendimientoModel emprendimiento) {
        UsuarioModel usuario = usuarioRepository.getById(usuarioId);
        emprendimiento.setCreador(usuario);
        return emprendimientoRepository.save(emprendimiento);
    }
    public EmprendimientoModel eliminar(Long id, EmprendimientoModel emprendimiento) {
        EmprendimientoModel emprendimientoEliminado = emprendimientoRepository.getById(id);
        emprendimientoEliminado.setActivo(false);
        return emprendimientoRepository.save(emprendimientoEliminado);
    }
    public EmprendimientoModel modificar(Long id, EmprendimientoModel emprendimiento) {
        EmprendimientoModel emprendimientoModificado = emprendimientoRepository.getById(id);
        if (!emprendimiento.getNombre().trim().isEmpty()) {
            emprendimientoModificado.setNombre(emprendimiento.getNombre()); }
        if (!emprendimiento.getDescripcion().trim().isEmpty()) {
            emprendimientoModificado.setDescripcion(emprendimiento.getDescripcion()); }
        if (!emprendimiento.getContenido().trim().isEmpty()) {
            emprendimientoModificado.setContenido(emprendimiento.getContenido()); }
        if (emprendimiento.getObjetivo() != null && emprendimiento.getObjetivo() > 0) {
            emprendimientoModificado.setObjetivo(emprendimiento.getObjetivo()); }
        if (emprendimiento.isPublicado() != true) { emprendimientoModificado.setPublicado(false); }
        if (emprendimiento.isPublicado() != false) { emprendimientoModificado.setPublicado(true); }
        if (emprendimiento.getUrl() != null) { emprendimientoModificado.setUrl(emprendimiento.getUrl()); }
        if (emprendimiento.getTags() != null) { emprendimientoModificado.setTags(emprendimiento.getTags()); }
        emprendimientoModificado.setUltimaModificacion(LocalDateTime.now());
        return emprendimientoRepository.save(emprendimientoModificado);
    }
    public List<EmprendimientoModel> obtenerTodos(String nombre) {
        if (nombre != null) { TagModel tag = tagRepository.findByNombre(nombre);
            return tag.getEmprendimientos();
        } else { return emprendimientoRepository.findAll(); }
    }
    public Stream<EmprendimientoModel> obtenerNoPublicados() {
        return emprendimientoRepository.findAll().stream()
            .filter(Predicate.not(EmprendimientoModel::isPublicado));
    }
}