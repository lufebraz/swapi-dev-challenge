package com.challenge.starwarsfilms.dto;

import com.challenge.starwarsfilms.model.TbStarWarsMovies;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public SWFilmDetailsResponse(TbStarWarsMovies film) {
        this.episodeId = film.getEpisodeId();
        this.title = film.getTitle();
        this.openingCrawl = film.getOpeningCrawl().replace("\r\n", " ");
        this.director = film.getDirector();
        this.producer = film.getProducer();
        this.releaseDate = film.getReleaseDate();
        this.version = film.getVersion();
    }
}
