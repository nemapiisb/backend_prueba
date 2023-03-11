package com.nema.backend.controller;

import com.nema.backend.dto.AnuncioDto;
import com.nema.backend.entity.Anuncio;
import com.nema.backend.exception.NullContenidoException;
import com.nema.backend.exception.ResourceNotFoundException;
import com.nema.backend.service.AnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 4800)
@RequestMapping("/anuncios")
public class AnuncioController {

    @Autowired
    AnuncioService anuncioService;


    //Mapeo GET => Devuelve todos los anuncios
    @GetMapping()
    public ResponseEntity<List<Anuncio>> getAll(){
        return ResponseEntity.ok(anuncioService.getAll());
    }
    
    //Mapeo GET => Devuelve anuncio pasando id
    @GetMapping("/{id}")
    public ResponseEntity<Anuncio> getOne(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(anuncioService.getOne(id));
    }

    //Mapeo POST crear usuario => devuelve anuncio creado

    @PostMapping()
    public ResponseEntity<Anuncio> save(@RequestBody AnuncioDto dto) throws NullContenidoException {
        return ResponseEntity.ok(anuncioService.save(dto));
    }

    //Mapeo PUT update usuario

    @PutMapping("/{id}")
    public ResponseEntity<Anuncio> update(@PathVariable("id") int id, @RequestBody AnuncioDto dto) throws ResourceNotFoundException {
        return ResponseEntity.ok(anuncioService.update(id,dto));
    }

    //Mapeo DELETE borrar anuncio
    @DeleteMapping("/{id}")
    public ResponseEntity<Anuncio> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(anuncioService.delete(id));
    }

}
