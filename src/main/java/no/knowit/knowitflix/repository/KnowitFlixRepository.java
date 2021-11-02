package no.knowit.knowitflix.repository;

import lombok.AllArgsConstructor;
import no.knowit.knowitflix.database.Database;
import no.knowit.knowitflix.domain.Kunde;
import no.knowit.knowitflix.domain.Serie;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class KnowitFlixRepository {

    public Integer nySerie(Serie serie) {
        Database.serier.add(serie);
        return serie.getId();
    }

    public Optional<Serie> getSerieById(Integer id) {
        return Database
                .serier
                .stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    public Integer nyKunde(Kunde kunde) {
        Database.kunder.add(kunde);
        return kunde.getId();
    }

    public Optional<Kunde> getKundeById(Integer id) {
        return Database.kunder
                .stream()
                .filter(k -> k.getId().equals(id))
                .findFirst();
    }
}
