package no.knowit.knowitflix.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import no.knowit.knowitflix.enums.Sjanger;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class Serie {
    private Integer id;
    private String tittel;
    private ArrayList<Sjanger> sjanger;

}
