package no.knowit.knowitflix;

import no.knowit.knowitflix.domain.Serie;
import no.knowit.knowitflix.enums.Sjanger;
import no.knowit.knowitflix.repository.KnowitFlixRepository;
import no.knowit.knowitflix.service.KnowitFlixService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KnowitflixApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnowitflixApplication.class, args);
    }

    KnowitFlixService knowitFlixService = new KnowitFlixService(new KnowitFlixRepository());

    @Bean
    public void testing() {
        Integer serie1Id = knowitFlixService.nySerie("Kulserie", Sjanger.DRAMA, Sjanger.ANIMASJON);
        Serie serie1 = knowitFlixService.getSerieById(serie1Id);

        System.out.println(serie1.getTittel());
        serie1.getSjanger().forEach(System.out::println);

        knowitFlixService.fjernSjangerFraSerie(serie1.getId(), Sjanger.DRAMA);
        serie1.getSjanger().forEach(System.out::println);
    }
}
