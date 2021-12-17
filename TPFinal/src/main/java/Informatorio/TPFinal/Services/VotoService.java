package Informatorio.TPFinal.Services;


import Informatorio.TPFinal.Dto.VotoDto;
import Informatorio.TPFinal.Models.EmprendimientoModel;
import Informatorio.TPFinal.Models.VotoModel;
import Informatorio.TPFinal.Repositories.EmprendimientoRepository;
import Informatorio.TPFinal.Repositories.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotoService {
    private final EmprendimientoRepository emprendimientoRepository;
    private final Converter<VotoDto, VotoModel> votoConverter;
    private final VotoRepository votoRepository;
    @Autowired
    public VotoService(EmprendimientoRepository emprendimientoRepository, 
                       Converter<VotoDto, VotoModel> VotoConverter,
                       VotoRepository votoRepository) {
        this.emprendimientoRepository = emprendimientoRepository; 
        this.votoConverter = VotoConverter;
        this.votoRepository = votoRepository;
    }
    public boolean chequearVoto(VotoDto votoDTO){
        VotoModel voto = votoConverter.convert(votoDTO);
        return votoRepository.findAll().stream().anyMatch(v -> {
            assert voto != null;
            return v.getUsuarioId().equals(voto.getUsuarioId()) && v.getEmprendimientoId().equals(voto.getEmprendimientoId());
        });
    }
    public Boolean crearVoto(VotoDto votoDTO) {
        VotoModel voto = votoConverter.convert(votoDTO);
        if(!chequearVoto(votoDTO)){
            assert voto != null;
            EmprendimientoModel emprendimiento = emprendimientoRepository.getById(voto.getEmprendimientoId());
            emprendimiento.setContadorDeVotos(emprendimiento.getContadorDeVotos()+1);
            emprendimientoRepository.save(emprendimiento);
            votoRepository.save(voto);
            return true;
        }
        return false;
    }
    public List<VotoModel> obtenerVotos(Long usuarioId) {
        return votoRepository.findByUsuarioId(usuarioId);
    }   
}