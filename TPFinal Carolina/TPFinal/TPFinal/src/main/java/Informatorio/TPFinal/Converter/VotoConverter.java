package Informatorio.TPFinal.Converter;

import Informatorio.TPFinal.Dto.VotoDto;
import Informatorio.TPFinal.Models.VotoModel;
import Informatorio.TPFinal.Repositories.EmprendimientoRepository;
import Informatorio.TPFinal.Repositories.UsuarioRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VotoConverter implements Converter<VotoDto, VotoModel> {
    public VotoConverter(EmprendimientoRepository emprendimientoRepository,
                         UsuarioRepository usuarioRepository) {
    }
    @Override
    public VotoModel convert(VotoDto votoDto) {
        VotoModel voto = new VotoModel();
        voto.setGenerado(votoDto.getGenerado());
        voto.setUsuarioId(votoDto.getUsuarioId());
        voto.setEmprendimientoId(votoDto.getEmprendimientoId());
        voto.setFechaDeCreacion(LocalDateTime.now());
        return voto;
    }
}