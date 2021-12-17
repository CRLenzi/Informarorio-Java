package Informatorio.TPFinal.Controllers;

import Informatorio.TPFinal.Dto.VotoDto;
import Informatorio.TPFinal.Services.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/votos")
public class VotoController {
    private final VotoService votoService;
    @Autowired
    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @PostMapping
    public ResponseEntity<?> crearVoto(@Valid @RequestBody VotoDto votoDTO) {
        return new ResponseEntity<>(votoService.crearVoto(votoDTO), HttpStatus.CREATED);
    }
    @GetMapping(value = "/{usuarioId}")
    public ResponseEntity<?> obtenerLosVotosDeUnUsuario(@PathVariable("usuarioId") Long usuarioId) {
        return new ResponseEntity<>(votoService.obtenerVotos(usuarioId), HttpStatus.OK);
    }
} 