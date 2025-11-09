package org.esprim.tp1.controllers;

import org.esprim.tp1.entity.Chambre;
import org.esprim.tp1.services.IChambreService;
import lombok.AllArgsConstructor;
import org.esprim.tp1.services.ChambreServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambres")
public class ChambreController {
    private ChambreServiceImpl chambreService;

    public ChambreController(ChambreServiceImpl chambreService) {
        this.chambreService = chambreService;
    }

    // http://localhost:8081/tpfoyer/chambre/retrieve-all-chambres
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.retrieveAllChambres();
        return listChambres;
    }
    // http://localhost:8081/tpfoyer/chambre/retrieve-chambre/8
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.retrieveChambre(chId);
        return chambre;
    }

    // http://localhost:8089/tpfoyer/chambre/add-chambre
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }
    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }
}