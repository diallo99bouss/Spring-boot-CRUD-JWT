package sn.isi.Emploi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.Emploi.model.Offres;
import sn.isi.Emploi.service.OffresService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/offres")
public class OffresController {
    @Autowired
    private OffresService offresService;

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody Offres offres) {
        Offres offres1 = offresService.add(offres);
        if (offres1 != null) {
            return new ResponseEntity<>(offres1, HttpStatus.OK);
        } else
            return new ResponseEntity<>(offres1, HttpStatus.BAD_REQUEST);
    }

    @GetMapping()
    public ResponseEntity<List<Offres>> getAll()
    {
        List<Offres> offres = offresService.getAll();
        if (offres != null) { return new ResponseEntity<>(offres,HttpStatus.OK); }
        else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offres> getOffres(@PathVariable Integer id) {
        Offres offres = offresService.getOffres(id);
        if (offres != null ) { return new ResponseEntity<>(offres, HttpStatus.OK); }
        else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Offres> deleteById(@PathVariable Integer id)
    {
        offresService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offres> fullUpdate(@Valid @RequestBody Offres offres, @PathVariable Integer id) {
        Offres oldOffre = offresService.getOffres(id);
        Offres newOffres = null;

        if (oldOffre != null){
            offres.setId(oldOffre.getId());
            newOffres = offresService.update(offres);

        }
        if (newOffres != null){
            return new ResponseEntity<>(newOffres, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
