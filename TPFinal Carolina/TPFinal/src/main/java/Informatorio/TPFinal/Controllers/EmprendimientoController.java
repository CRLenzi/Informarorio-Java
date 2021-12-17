package Informatorio.TPFinal.Controllers;


import Informatorio.TPFinal.Dto.EventoDto;
import Informatorio.TPFinal.Models.EmprendimientoModel;
import Informatorio.TPFinal.Repositories.EmprendimientoRepository;
import Informatorio.TPFinal.Repositories.EventoRepository;
import Informatorio.TPFinal.Services.EmprendimientoService;
import Informatorio.TPFinal.Services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class EmprendimientoController {
    private final EmprendimientoRepository emprendimientoRepository;
    private final EmprendimientoService emprendimientoService;
    private final EventoRepository eventoRepository;
    private final EventoService eventoService;
    @Autowired
    public EmprendimientoController(EmprendimientoRepository emprendimientoRepository,
                                    EmprendimientoService emprendimientoService,
                                    EventoRepository eventoRepository,
                                    EventoService eventoService) {
        this.emprendimientoRepository = emprendimientoRepository;
        this.emprendimientoService = emprendimientoService;
        this.eventoRepository = eventoRepository;
        this.eventoService = eventoService;
    }

    @PostMapping(value = "/api/v1/usuarios/{id}/emprendimientos")
    public ResponseEntity<?> crearEmprendimiento(@PathVariable("id") Long usuarioId,
                                                 @Valid @RequestBody EmprendimientoModel emprendimientoModel) {
        return new ResponseEntity<>(emprendimientoService.guardar(usuarioId, emprendimientoModel), HttpStatus.CREATED);
    }
    @PutMapping(value = "/api/v1/emprendimientos/{id}/quitar")
    public EmprendimientoModel eliminarEmprendimiento(@PathVariable("id") Long id, EmprendimientoModel emprendimientoModel) {
        return this.emprendimientoService.eliminar(id,  emprendimientoModel);
    }
    @PutMapping(value = "/api/v1/emprendimientos/{id}")
    public EmprendimientoModel modificarEmprendimiento(@PathVariable("id") Long id,
                                                       @Valid @RequestBody EmprendimientoModel emprendimientoModel) {
        return this.emprendimientoService.modificar(id, emprendimientoModel);
    }
    @GetMapping(value = "/ap1/v1/emprendimientos")
    public ResponseEntity<?> obtenerTodosLosEmprendimientos(
            @RequestParam(name = "nombre", required = false) String nombre) {
        return new ResponseEntity<>(emprendimientoService.obtenerTodos(nombre) ,HttpStatus.OK);
    }
    @GetMapping(value = "/api/v1/emprendimientos/no_publicados")
    public ResponseEntity<?> obtenerEmprendimientosNoPublicados() {
        return new ResponseEntity<>(emprendimientoService.obtenerNoPublicados(), HttpStatus.OK);
    }
    @PostMapping(value = "/api/v1/emprendimientos/{emprendimientoId}/eventos/{eventoId}")
    public ResponseEntity<?> registrarEvento(@PathVariable("emprendimientoId") Long emprendimientoId,
                                             @PathVariable("eventoId") Long eventoId, EventoDto eventoDTO) {
        emprendimientoRepository.findById(emprendimientoId);
        eventoRepository.findById(eventoId);
        return new ResponseEntity<>(eventoService.registrar(emprendimientoId, eventoId, eventoDTO), HttpStatus.CREATED);
    }
}