package no.knowit.knowitflix.database;

import lombok.Getter;
import lombok.Setter;
import no.knowit.knowitflix.domain.Kunde;
import no.knowit.knowitflix.domain.Serie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Database {
    private static AtomicInteger serieId = new AtomicInteger(0);
    private static AtomicInteger kundeId = new AtomicInteger(0);
    public static List<Serie> serier = new ArrayList<>();
    public static List<Kunde> kunder = new ArrayList<>();

    public static Integer genererSerieId() {
        return serieId.addAndGet(1);
    }

    public static Integer genererKundeId() {
        return kundeId.addAndGet(1);
    }
}
