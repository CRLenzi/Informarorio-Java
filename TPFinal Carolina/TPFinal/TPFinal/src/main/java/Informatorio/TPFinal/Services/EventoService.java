package Informatorio.TPFinal.Services;

import Informatorio.TPFinal.Dto.EventoDto;
import Informatorio.TPFinal.Models.EmprendimientoModel;
import Informatorio.TPFinal.Models.EstadoModel;
import Informatorio.TPFinal.Models.EventoModel;
import Informatorio.TPFinal.Models.UsuarioModel;
import Informatorio.TPFinal.Repositories.EmprendimientoRepository;
import Informatorio.TPFinal.Repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Configuration
@EnableScheduling
public class EventoService {
    private final EmprendimientoRepository emprendimientoRepository;
    private final EventoRepository eventoRepository;
    @Autowired
    public EventoService(EmprendimientoRepository emprendimientoRepository,
                         EventoRepository eventoRepository) {
        this.emprendimientoRepository = emprendimientoRepository;
        this.eventoRepository = eventoRepository;
    }
    public EventoModel guardar(EventoModel evento) {
        return eventoRepository.save(evento);
    }
    public EventoModel eliminar(Long id, EventoModel evento) {
        EventoModel eventoEliminado = eventoRepository.getById(id);
        eventoEliminado.setActivo(false);
        return eventoRepository.save(eventoEliminado);
    }
    public void actualizarEstado(EventoModel evento, LocalDate ahora) {
        if (evento.getFechaDecierre().isBefore(ahora)) { evento.setEstado(EstadoModel.EN_CURSO); }
        if (evento.getFechaFinal().isBefore(ahora)) { evento.setEstado(EstadoModel.FINALIZADO); }
    }
    public void actualizar() {
        List<EventoModel> eventos = eventoRepository.findAll();
        LocalDate ahora = LocalDate.now();
        eventos.stream().forEach(evento -> actualizarEstado(evento, ahora));
        eventoRepository.saveAll(eventos);
        System.out.println("Estado del evento actualizado.");
    }
    public EmprendimientoModel registrar(Long emprendimientoId, Long eventoId, EventoDto eventoDTO) {
        EmprendimientoModel emprendimientoRegistrado = emprendimientoRepository.getById(emprendimientoId);
        EventoModel eventoRegistrado = eventoRepository.getById(eventoId);
        if (eventoRegistrado.getEstado() == EstadoModel.ABIERTO) { emprendimientoRegistrado.addEvento(eventoRegistrado);
            System.out.println("Suscripcion correcta");
        } else if (eventoRegistrado.getEstado() == EstadoModel.EN_CURSO) {
            System.out.println("Tiempo de suscripcion finalizado");
        } else { System.out.println("Evento finalizado."); }
        return emprendimientoRepository.save(emprendimientoRegistrado);
    }
    public EventoModel modificar(Long id, EventoModel e) {
        EventoModel eventoModificado = eventoRepository.getById(id);
        if (!e.getNombre().trim().isEmpty()) {
            eventoModificado.setNombre(e.getNombre());
        }
        if (!e.getDetalles().trim().isEmpty()) {
            eventoModificado.setDetalles(e.getDetalles());
        }
        if (e.getFechaDecierre() != null) {
            eventoModificado.setFechaDecierre(e.getFechaDecierre());
        }
        if (e.getFechaDeCreacion() != null ) {
            eventoModificado.setFechaDeCreacion(e.getFechaDeCreacion());
        }
        if (e.getPremio() > 0) {
            eventoModificado.setPremio(e.getPremio());
        }
        return eventoRepository.save(eventoModificado);
    }
    public Optional<EventoModel> rankear(Long id) {
        return eventoRepository.findById(id);
    }
}