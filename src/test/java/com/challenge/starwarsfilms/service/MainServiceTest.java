package com.challenge.starwarsfilms.service;

import com.challenge.starwarsfilms.dto.SWFilmDetailsResponse;
import com.challenge.starwarsfilms.dto.RootClientResponse;
import com.challenge.starwarsfilms.model.TbStarWarsMovies;
import com.challenge.starwarsfilms.repository.MainRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MainServiceTest {

    @InjectMocks
    MainService service;

    @Mock
    MainRepository repository;

    @Mock
    RestTemplate rest;

    @Value("${star-wars.api.url}")
    private String swApiUrl;

// TODO
//    @Test
//    public void initialSaveSuccess() {
//        when(rest.getForEntity(swApiUrl, SWFilmsResponse.class))
//                .thenReturn(null);
//        service.initialSave();
//    }

    @Test
    public void findAllTest_NoContent() {
        List<TbStarWarsMovies> emptyList = new ArrayList<>();
        when(repository.findAll()).thenReturn(emptyList);
        assertEquals(204, service.findAll().getStatusCodeValue());
    }
    @Test
    public void findAllTest_Ok() {
        List<TbStarWarsMovies> fullList = getAllMovies();
        when(repository.findAll()).thenReturn(fullList);
        assertEquals(200, service.findAll().getStatusCodeValue());
    }

    @Test
    public void findOne_Ok() {
        when(repository.findById(anyInt())).thenReturn(Optional.of(getMovie()));
        assertEquals(200, service.findOne(anyInt()).getStatusCodeValue());
    }
    @Test
    public void findOne_NoContent() {
        Integer id = 1;
        when(repository.findById(id)).thenReturn(Optional.ofNullable(nullable(TbStarWarsMovies.class)));
        assertEquals(204, service.findOne(id).getStatusCodeValue());
    }

    @Test
    public void editDescriptionVersionCheck() {
        Integer id = 1;
        String newDescription = "THIS IS THE NEW DESCRIPTION";
        when(repository.findById(anyInt())).thenReturn(Optional.of(getMovie()));
        SWFilmDetailsResponse response = (SWFilmDetailsResponse) service.editDescription(id, newDescription).getBody();

        assertEquals(2, response.getVersion());
        assertEquals(newDescription, response.getOpeningCrawl());
    }

    @Test
    public void editDescription_NoContent() {
        Integer id = 1;
        String newDescription = "THIS IS THE NEW DESCRIPTION";
        when(repository.findById(id)).thenReturn(Optional.ofNullable(nullable(TbStarWarsMovies.class)));
        assertEquals(204, service.editDescription(id, newDescription).getStatusCodeValue());
    }

    public List<TbStarWarsMovies> getAllMovies() {
        List<TbStarWarsMovies> list = new ArrayList<>();
        TbStarWarsMovies movie = getMovie();
        list.add(movie);
        return list;
    }

    private TbStarWarsMovies getMovie() {
        TbStarWarsMovies movie = new TbStarWarsMovies();
        movie.setVersion(1);
        movie.setTitle("TITLE");
        movie.setOpeningCrawl("IT WAS A REALLY DARK TIME");
        movie.setDirector("TOM CRUISE");
        movie.setProducer("TOM HOLLAND");
        movie.setEpisodeId(1);
        return movie;
    }
}
