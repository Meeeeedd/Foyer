package org.esprim.tp1.controllers;

import org.esprim.tp1.entity.Bloc;
import org.esprim.tp1.entity.Etudiant;
import org.esprim.tp1.services.BlocServiceImpl;
import org.esprim.tp1.services.IBlocService;
import org.esprim.tp1.services.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blocs")
public class BlocController {
    @Autowired
    private BlocServiceImpl blocService;

    public BlocController(BlocServiceImpl blocService) {
        this.blocService = blocService;
    }

    // GET /api/etudiants
    @GetMapping
    public List<Bloc> getAllBlocs() {
        return blocService.retrieveAllBlocs();
    }

    // GET /api/etudiants/{id}
    @GetMapping("/{id}")
    public Bloc getBloc(@PathVariable("id") Long id) {
        return blocService.retrieveBloc(id);
    }

    // POST /api/etudiants
    @PostMapping
    public Bloc addBloc(@RequestBody Bloc b) {
        return blocService.addBloc(b);
    }

    // PUT /api/etudiants/{id}
    @PutMapping("/{id}")
    public Bloc updateBloc(@PathVariable("idBloc") Long id, @RequestBody Bloc b) {
        return blocService.updateBloc(b);
    }

    // DELETE /api/etudiants/{id}
    @DeleteMapping("/{id}")
    public void deleteBloc(@PathVariable("id") Long id) {
        blocService.removeBloc(id);
    }
}
