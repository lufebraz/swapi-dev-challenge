package com.challenge.starwarsfilms.service;

import com.challenge.starwarsfilms.dto.SWFilm;
import com.challenge.starwarsfilms.dto.SWFilmDetailsResponse;
import com.challenge.starwarsfilms.dto.SWFilmsResponse;
import com.challenge.starwarsfilms.dto.SWListAllResponse;
import com.challenge.starwarsfilms.model.TbStarWarsMovies;
import com.challenge.starwarsfilms.repository.MainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MainService {

    private static final Logger log = LoggerFactory.getLogger(MainService.class);

    @Value("${star-wars.api.url}")
    private String swApiUrl;
    @Autowired
    MainRepository mainRepository;
    RestTemplate restTemplate;

    public MainService(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    private void init() {
        if (restTemplate == null){
            this.restTemplate = new RestTemplate();
        }
    }

    public void initialSave() {
        init();
        SWFilmsResponse response = restTemplate.getForEntity(
                swApiUrl,
                SWFilmsResponse.class).getBody();

        mainRepository.saveAll(
                response.getResults().stream()
                        .map(TbStarWarsMovies::new)
                        .collect(Collectors.toList()));

        log.info("JUST SAVED LOTS OF INTERGALACTIC MOVIES!!");
    }


    public ResponseEntity<Object> findAll() {
        Optional<List<TbStarWarsMovies>> filmsList = Optional.of(mainRepository.findAll());
        if (filmsList.get().size() > 0) {
            return ResponseEntity.ok(
                    filmsList.get().stream()
                            .map(SWListAllResponse::new)
                            .collect(Collectors.toList()));
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Object> findOne(Integer id) {
        Optional<TbStarWarsMovies> film = findFilmById(id);
        if (film.isPresent()) {
            SWFilmDetailsResponse filmResponse = new SWFilmDetailsResponse(film.get());
            return ResponseEntity.ok(filmResponse);
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Object> editDescription(Integer id, String description) {
        Optional<TbStarWarsMovies> film = findFilmById(id);
        if (film.isPresent()) {
            TbStarWarsMovies movieDB = film.get();
            movieDB.setOpeningCrawl(description);
            movieDB.setVersion(movieDB.getVersion() + 1);
            mainRepository.save(movieDB);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    private Optional<TbStarWarsMovies> findFilmById(Integer id) {
        Optional<TbStarWarsMovies> film = mainRepository.findById(id);
        return film;
    }
}
