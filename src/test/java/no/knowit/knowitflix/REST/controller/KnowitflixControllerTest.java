package no.knowit.knowitflix.REST.controller;

import no.knowit.knowitflix.domain.Serie;
import no.knowit.knowitflix.enums.Sjanger;
import no.knowit.knowitflix.service.KnowitFlixService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class KnowitflixControllerTest {

    @MockBean
    public KnowitFlixService service;

    @LocalServerPort
    public int port;

    @Autowired
    public TestRestTemplate testRestTemplate;

    static Serie expected;


    @BeforeAll
    static void setup() {
        expected = new Serie(
                1,
                "TestSerie",
                new ArrayList<>(Arrays.asList(Sjanger.DRAMA, Sjanger.GAMESHOW))
        );
    }

    @Test
    void getSerieById() {
        Mockito.when(service.getSerieById(1)).thenReturn(expected);
        ResponseEntity<Serie> responseEntity = testRestTemplate.getForEntity("/serie/1", Serie.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().toString()).isEqualTo(expected.toString());
    }

    @Test
    void nySerie() {
    }
}