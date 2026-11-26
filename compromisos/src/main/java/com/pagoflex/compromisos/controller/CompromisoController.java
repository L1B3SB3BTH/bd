package com.pagoflex.compromisos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagoflex.compromisos.dto.CompromisoRequestDTO;
import com.pagoflex.compromisos.dto.CompromisoResponseDTO;
import com.pagoflex.compromisos.service.CompromisoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/compromisos")
@RequiredArgsConstructor
@Tag(name = "Compromisos", description = "Gestión de compromisos de pago")
public class CompromisoController {
    private final CompromisoService service;

    @GetMapping
    @Operation(summary = "Listar todos los compromisos")
    public ResponseEntity<List<CompromisoResponseDTO>> listar(){
        return ResponseEntity.ok(service.listarCompromisos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar compromiso por ID")
    public ResponseEntity<CompromisoResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear un compromiso")
    public ResponseEntity<CompromisoResponseDTO> crear(@RequestBody CompromisoRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(request));
    }

    @PutMapping
    @Operation(summary = "Eliminar un compromiso")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
