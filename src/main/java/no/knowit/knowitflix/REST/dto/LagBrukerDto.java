package no.knowit.knowitflix.REST.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Array;

@AllArgsConstructor
@Getter
public class LagBrukerDto {
    String tittel;
    Array[] sjangere;
}
