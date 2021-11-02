package no.knowit.knowitflix;

import no.knowit.knowitflix.domain.Serie;
import no.knowit.knowitflix.enums.Sjanger;
import no.knowit.knowitflix.repository.KnowitFlixRepository;
import no.knowit.knowitflix.service.KnowitFlixService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class KnowitFlixServiceTest {

    private static Serie testSerie;
    private static KnowitFlixService service = new KnowitFlixService(new KnowitFlixRepository());

    @BeforeAll
    public static void setup() {
        testSerie = service.getSerieById(service.nySerie("Test1", Sjanger.DOKUMENTAR, Sjanger.HUMOR));
    }

    @Test
    void nySerie() {
        Integer nySerieId = service.nySerie("TestSerie", Sjanger.ANIMASJON, Sjanger.DRAMA);
        Serie serie = service.getSerieById(nySerieId);

        assertThat(nySerieId).isEqualTo(serie.getId());
        assertThat(serie.getTittel()).isEqualTo("TestSerie");
        assertThat(serie.getSjanger()).containsExactly(Sjanger.ANIMASJON, Sjanger.DRAMA);
    }

    @Test
    void skalLeggeTilSjanger() {
        service.leggTilSerieSjanger(testSerie.getId(), Sjanger.GAMESHOW);
        assertThat(testSerie.getSjanger()).contains(Sjanger.GAMESHOW);
    }

    @Test
    void skalFjerneSjanger() {
        service.fjernSjangerFraSerie(testSerie.getId(), Sjanger.GAMESHOW);
        assertThat(testSerie.getSjanger()).doesNotContain(Sjanger.GAMESHOW);
    }

}