package com.app.fontexplorer.Controller;

import com.app.fontexplorer.Entities.Fuente;
import com.app.fontexplorer.Repositories.FuenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fuentes")
public class FuenteController {
    @Autowired
    private FuenteRepository fuenteRepository;

    // Obtener todas las fuentes
    @GetMapping("")
    public List<Fuente> getAllFuentes() {
        return fuenteRepository.findAll();
    }

    // Obtener una fuente específica por su id
    @GetMapping("/{id}")
    public ResponseEntity<Fuente> getFuenteById(@PathVariable(value = "id") Long fuenteId) {
        Fuente fuente = fuenteRepository.findById(fuenteId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fuente no encontrada con id: " + fuenteId));
        return ResponseEntity.ok().body(fuente);
    }

    // Crear una nueva fuente
    @PostMapping("")
    public Fuente createFuente(@RequestBody Fuente fuente) {
        return fuenteRepository.save(fuente);
    }

    // Actualizar una fuente existente por su id
    @PutMapping("/{id}")
    public ResponseEntity<Fuente> updateFuente(@PathVariable(value = "id") Long fuenteId, @RequestBody Fuente fuenteDetails) {
        Fuente fuente = fuenteRepository.findById(fuenteId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fuente no encontrada con id: " + fuenteId));

        fuente.setNombre(fuenteDetails.getNombre());
        fuente.setDescripcion(fuenteDetails.getDescripcion());
        fuente.setLatitud(fuenteDetails.getLatitud());
        fuente.setLongitud(fuenteDetails.getLongitud());

        final Fuente updatedFuente = fuenteRepository.save(fuente);
        return ResponseEntity.ok(updatedFuente);
    }

    // Eliminar una fuente existente por su id
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteFuente(@PathVariable(value = "id") Long fuenteId) {
        Fuente fuente = fuenteRepository.findById(fuenteId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fuente no encontrada con id: " + fuenteId));

        fuenteRepository.delete(fuente);
        Map<String, Boolean> response = new HashMap<>();
        response.put("eliminado", Boolean.TRUE);
        return response;
    }
}
