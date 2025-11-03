package org.esprim.tp1.controllers;

import org.esprim.tp1.entity.Chambre;
import org.esprim.tp1.services.IChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chambre")
public class ChambreRestController {
    private final IChambreService chambreService;

    @Autowired
    public ChambreRestController(IChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Chambre";
    }

    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }

    @GetMapping("/retrieve-all-chambres")
    public Object getChambres() {
        return chambreService.retrieveAllChambres();
    }

    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chambreId) {
        Chambre chambre = chambreService.retrieveChambre(chambreId);
        return chambre;
    }

    @GetMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }
}
