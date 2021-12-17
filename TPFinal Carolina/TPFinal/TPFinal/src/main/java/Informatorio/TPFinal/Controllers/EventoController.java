package Informatorio.TPFinal.Controllers;

import Informatorio.TPFinal.Models.EventoModel;
import Informatorio.TPFinal.Services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/eventos")
public class EventoController {
    private final EventoService eventoService;
    @Autowired
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping
    public ResponseEntity<?> crearEvento(@Valid @RequestBody EventoModel evento) {
        return new ResponseEntity<>(eventoService.guardar(evento), HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}/eliminar")
    public EventoModel eliminarEvento(@PathVariable("id") Long id, EventoModel evento) {
        return this.eventoService.eliminar(id, evento);
    }
    @PutMapping(value = "/actualizar-estado")
    public void actualizarEvento() { this.eventoService.actualizar(); }

    @PutMapping(value = "/{id}/modificar")
    public EventoModel modificarEvento(@PathVariable("id") Long id, @Valid @RequestBody EventoModel evento) {
        return this.eventoService.modificar(id, evento);
    }

    @GetMapping(value = "/{id}/ranking")
    public ResponseEntity<?> rankingDelEvento(@PathVariable("id") Long id) {
        return new ResponseEntity<>(eventoService.rankear(id), HttpStatus.OK);
    }
}