package com.challenge.starwarsfilms.dto;

import com.challenge.starwarsfilms.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SWFilmDetailsResponse {

    private Integer episodeId;
    private String title;
    private String openingCrawl;
    private String director;
    private String producer;
    private String releaseDate;
    private Integer version;
    private String created;
    private String edited;
    private String url;

    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
    public SWFilmDetailsResponse(TbStarWarsMovies film) {
        this.episodeId = film.getEpisodeId();
        this.title = film.getTitle();
        this.openingCrawl = film.getOpeningCrawl().replace("\r\n", " ");
        this.director = film.getDirector();
        this.producer = film.getProducer();
        this.releaseDate = film.getReleaseDate();
        this.version = film.getVersion();
        this.created = film.getCreated();
        this.edited = film.getEdited();
        this.url = film.getUrl();
        this.characters = film.getTbCharacters().stream().map(this::charactersMapper).collect(Collectors.toList());
        this.planets = film.getTbPlanets().stream().map(this::planetsMapper).collect(Collectors.toList());
        this.starships = film.getTbStarships().stream().map(this::starshipsMapper).collect(Collectors.toList());
        this.vehicles = film.getTbVehicles().stream().map(this::vehiclesMapper).collect(Collectors.toList());
        this.species = film.getTbSpecies().stream().map(this::speciesMapper).collect(Collectors.toList());
    }
    String charactersMapper(TbCharacters tb) {
        return tb.getUrl();
    }
    String planetsMapper(TbPlanets tb) {
        return tb.getUrl();
    }
    String starshipsMapper(TbStarships tb) {
        return tb.getUrl();
    }
    String vehiclesMapper(TbVehicles tb) {
        return tb.getUrl();
    }
    String speciesMapper(TbSpecies tb) {
        return tb.getUrl();
    }
}
