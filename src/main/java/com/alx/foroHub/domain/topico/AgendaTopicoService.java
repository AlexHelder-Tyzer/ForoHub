package com.alx.foroHub.domain.topico;

import com.alx.foroHub.domain.usuario.UsuarioRepository;
import com.alx.foroHub.infra.errors.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AgendaTopicoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public DatosDetalleTopico registrar(DatosRegistroTopico datosRegistroTopico){
        if (!usuarioRepository.findById(datosRegistroTopico.idUsuario()).isPresent()){
            throw new ValidacionDeIntegridad("Este usuario no se encuentra registrado");
        }

        var usuario = usuarioRepository.findById(datosRegistroTopico.idUsuario()).get();
        Topico topico = new Topico(
                datosRegistroTopico.titulo(),
                datosRegistroTopico.mensaje(),
                LocalDateTime.now(),
                usuario);

        topicoRepository.save(topico);
        return new DatosDetalleTopico(topico);
    }
}
