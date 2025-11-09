package org.esprim.tp1.controllers;

import org.esprim.tp1.entity.Universite;
import org.esprim.tp1.services.IUniversiteService;
import lombok.AllArgsConstructor;
import org.esprim.tp1.services.UniversiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universites")  // base URL pour les universités
public class UniversiteController {

    @Autowired
    private UniversiteServiceImpl universiteService;

    public UniversiteController(UniversiteServiceImpl universiteService) {
        this.universiteService = universiteService;
    }

    // GET /api/universites → récupère toutes les universités
    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteService.retrieveAllUniversites();
    }

    // GET /api/universites/{id} → récupère une université par ID
    @GetMapping("/{id}")
    public Universite getUniversite(@PathVariable("id") Long id) {
        return universiteService.retrieveUniversite(id);
    }

    // POST /api/universites → ajoute une nouvelle université
    @PostMapping
    public Universite addUniversite(@RequestBody Universite u) {
        return universiteService.addUniversite(u);
    }

    // PUT /api/universites/{id} → met à jour une université
    @PutMapping("/{id}")
    public Universite updateUniversite(@PathVariable("id") Long id, @RequestBody Universite u) {
        return universiteService.updateUniversite(u);
    }

    // DELETE /api/universites/{id} → supprime une université
    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable("id") Long id) {
        universiteService.removeUniversite(id);
    }
}
