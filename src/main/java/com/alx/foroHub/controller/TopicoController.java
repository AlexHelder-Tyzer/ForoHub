package com.alx.foroHub.controller;

import com.alx.foroHub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
// colocar bearer key
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private AgendaTopicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity registrarTopico(@RequestBody @Valid
            DatosRegistroTopico datosRegistroTopico){
        var response = service.registrar(datosRegistroTopico);
        return ResponseEntity.ok(response);
//        Topico topico = new Topico(datosRegistroTopico);
//        topicoRepository.save(topico);
//
//        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
//        return ResponseEntity.created(uri).body(new DatosRespuestaTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaTopico>> listaTopicos(@PageableDefault(size=10, sort={"fechaCreacion"})Pageable paginacion){
        var page = topicoRepository.findAll(paginacion).map(DatosListaTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity retornarDetalleTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }
}
