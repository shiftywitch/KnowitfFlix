package no.knowit.knowitflix.service;

import lombok.AllArgsConstructor;
import no.knowit.knowitflix.repository.KnowitFlixRepository;
import no.knowit.knowitflix.database.Database;
import no.knowit.knowitflix.domain.Kunde;
import no.knowit.knowitflix.domain.Serie;
import no.knowit.knowitflix.enums.Sjanger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class KnowitFlixService {


    private final KnowitFlixRepository knowitFlixRepository;

    //Lage ny serie
    public Integer nySerie(String navn, Sjanger... sjangere) {
        boolean definerteSjangere = Arrays
                .stream(sjangere)
                .findFirst()
                .isPresent();

        if (definerteSjangere) {
            Serie serie = new Serie(
                    Database.genererSerieId(),
                    navn,
                    new ArrayList<>(Arrays.asList(sjangere))
            );

            return knowitFlixRepository.nySerie(serie);
        }

        throw new RuntimeException("Ingen sjanger er definert for serien");
    }


    public Serie getSerieById(Integer id) {
        return knowitFlixRepository.getSerieById(id)
                .orElseThrow(() -> new RuntimeException("Serie med id: " + id + " ikke funnet."));
    }

    public void leggTilSerieSjanger(Integer id, Sjanger... sjangere) {
        Serie serie = getSerieById(id);
        Arrays.stream(sjangere).forEach(s -> serie.getSjanger().add(s));
    }

    public void fjernSjangerFraSerie(Integer id, Sjanger... sjangere) {
        Serie serie = getSerieById(id);
        Arrays.stream(sjangere)
                .filter(s -> serie.getSjanger().contains(s))
                .forEach(s -> serie.getSjanger().remove(s))
        ;
    }

    //Lage ny kunde
    public Integer nyKunde(String navn, Date registrert) {
        Kunde kunde = new Kunde(
                Database.genererKundeId(),
                navn,
                registrert,
                new ArrayList<>()
        );
        return knowitFlixRepository.nyKunde(kunde);
    }

    public Kunde getKundeById(Integer id) {
        return knowitFlixRepository.getKundeById(id)
                .orElseThrow(() -> new RuntimeException("Kunde med id: " + id + " ikke funnet"));
    }

    public void leggTilSjangerInteresseForKunde(Integer id, Sjanger... sjangere) {
        Kunde kunde = getKundeById(id);
        Arrays.stream(sjangere).forEach(s -> kunde.getSjangere().add(s));
    }

    public void fjernSjangerInteresseForKunde(Integer id, Sjanger... sjangere) {
        Kunde kunde = getKundeById(id);
        Arrays.stream(sjangere)
                .filter(s -> kunde.getSjangere().contains(s))
                .forEach(s -> kunde.getSjangere().remove(s));
    }



    /*public List<Kunde> getKunderInteressertISerie(Integer id) {
        Serie serie = getSerieById(id);
        Database.kunder.stream()
                .filter(k -> {
                    k.getSjangere()
                            .stream()
                            .map(k::g)
                })
    }*/
}
