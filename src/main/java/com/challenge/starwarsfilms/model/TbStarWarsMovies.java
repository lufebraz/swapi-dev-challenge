package com.challenge.starwarsfilms.model;

import com.challenge.starwarsfilms.dto.SWFilm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_STAR_WARS_MOVIES")
public class TbStarWarsMovies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer episodeId;
    private String title;
    @Column(length = 600)
    private String openingCrawl;
    private String director;
    private String producer;
    private String releaseDate;
    private Integer version;

    public TbStarWarsMovies(SWFilm swFilm) {
        this.title = swFilm.getTitle();
        this.episodeId = swFilm.getEpisodeId();
        this.director = swFilm.getDirector();
        this.openingCrawl = swFilm.getOpeningCrawl();
        this.producer = swFilm.getProducer();
        this.releaseDate = swFilm.getReleaseDate();
        this.version = 1;
    }


}
