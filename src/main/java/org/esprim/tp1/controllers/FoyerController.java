package org.esprim.tp1.controllers;

import org.esprim.tp1.entity.Foyer;
import org.esprim.tp1.services.FoyerServiceImpl;
import org.esprim.tp1.services.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyer")
public class FoyerController {
    @Autowired
    private FoyerServiceImpl foyerService;

    public FoyerController(FoyerServiceImpl foyerService) {
        this.foyerService = foyerService;
    }

    // GET /api/foyer
    @GetMapping
    public List<Foyer> getAllFoyer() {
        return foyerService.retrieveAllFoyers();
    }

    // GET /api/foyer/{id}
    @GetMapping("/{id}")
    public Foyer getFoyer(@PathVariable("id") Long id) {
        return foyerService.retrieveFoyer(id);
    }

    // POST /api/foyer
    @PostMapping
    public Foyer addupdateFoyer(@RequestBody Foyer f) {
        return foyerService.addFoyer(f);
    }

    // PUT /api/foyer/{id}
    @PutMapping("/{id}")
    public Foyer updateFoyer(@PathVariable("id") Long id, @RequestBody Foyer f) {
        return foyerService.updateFoyer(f);
    }

    // DELETE /api/foyer/{id}
    @DeleteMapping("/{id}")
    public void deleteFoyer(@PathVariable("id") Long id) {
        foyerService.removeFoyer(id);
    }
}
