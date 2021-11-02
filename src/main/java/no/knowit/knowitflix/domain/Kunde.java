package no.knowit.knowitflix.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import no.knowit.knowitflix.enums.Sjanger;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@Data
public class Kunde {
    private Integer id;
    private String navn;
    private Date registrert;
    private ArrayList<Sjanger> sjangere;
}
