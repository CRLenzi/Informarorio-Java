package Informatorio.TPFinal.Controllers;

import Informatorio.TPFinal.Models.UsuarioModel;
import Informatorio.TPFinal.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "api/v1/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<?>crearUsuario(@Valid @RequestBody UsuarioModel usuario) {
        return new ResponseEntity<>(usuarioService.guardar(usuario), HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}/quitar")
    public UsuarioModel eliminarUsuario(@PathVariable("id") Long id, UsuarioModel usuario) {
        return this.usuarioService.eliminar(id, usuario);
    }
    @PutMapping(value = "/{id}")
    public UsuarioModel modificarUsuario(@PathVariable("id") Long id, @Valid @RequestBody UsuarioModel usuario) {
        return this.usuarioService.modificar(id, usuario);
    }
    @GetMapping
    public ResponseEntity<?> obtenerTodosLosUsuarios(@RequestParam(name = "fecha", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaDeCreacion,
            @RequestParam(name = "ciudad", required = false) String ciudad) {
        return new ResponseEntity<>(usuarioService.obtenerTodos(fechaDeCreacion, ciudad), HttpStatus.OK);
    }
}