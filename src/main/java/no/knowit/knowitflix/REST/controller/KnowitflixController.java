package no.knowit.knowitflix.REST.controller;

import no.knowit.knowitflix.REST.dto.LagBrukerDto;
import no.knowit.knowitflix.domain.Serie;
import no.knowit.knowitflix.enums.Sjanger;
import no.knowit.knowitflix.service.KnowitFlixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KnowitflixController {

    @Autowired
    KnowitFlixService knowitFlixService;

    @GetMapping(path = "/serie/{id}")
    public ResponseEntity<Serie> getSerieById(@PathVariable Integer id) {
        Serie serie = knowitFlixService.getSerieById(id);
        return new ResponseEntity<Serie>(serie, HttpStatus.OK);
    }

    @PostMapping(path = "/nySerie")
    public ResponseEntity<Integer> nySerie(@PathVariable String tittel,
                                           @PathVariable Sjanger[] sjangere) {

        Integer result = knowitFlixService.nySerie(tittel, sjangere);
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }
}
