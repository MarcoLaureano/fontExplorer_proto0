package com.app.fontexplorer.Controller;


import com.app.fontexplorer.Entities.EstadistiquesFont;
import com.app.fontexplorer.Repositories.EstadistiquesFontRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/estadisticas")
public class EstadistiquesFontController {
    @Autowired
    private EstadistiquesFontRepository fuenteRepository;

    @GetMapping("")
    public List<EstadistiquesFont> getAllFuentes() {
        return fuenteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadistiquesFont> getFuenteById(@PathVariable(value = "id") Long fuenteId) {
        EstadistiquesFont fuente = fuenteRepository.findById(fuenteId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estadistica no encontrada con id: " + fuenteId));
        return ResponseEntity.ok().body(fuente);
    }

    @PostMapping("/registerReview")
    public EstadistiquesFont createFuente(@RequestBody EstadistiquesFont fuente) {
        return fuenteRepository.save(fuente);
    }


    @PutMapping("/{id}")
    public ResponseEntity<EstadistiquesFont> updateFuente(@PathVariable(value = "id") Long fuenteId, @RequestBody EstadistiquesFont fuenteDetails) {
        EstadistiquesFont fuente = fuenteRepository.findById(fuenteId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estadistica no encontrada con id: " + fuenteId));

        fuente.setFuente(fuenteDetails.getFuente());
        fuente.setCalificacion(fuenteDetails.getCalificacion());
        fuente.setComentarios(fuenteDetails.getComentarios());

        final EstadistiquesFont updatedFuente = fuenteRepository.save(fuente);
        return ResponseEntity.ok(updatedFuente);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteFuente(@PathVariable(value = "id") Long fuenteId) {
        EstadistiquesFont fuente = fuenteRepository.findById(fuenteId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estadistica no encontrada con id: " + fuenteId));

        fuenteRepository.delete(fuente);
        Map<String, Boolean> response = new HashMap<>();
        response.put("eliminado", Boolean.TRUE);
        return response;
    }
}
