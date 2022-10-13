package com.challenge.starwarsfilms.model;

import com.challenge.starwarsfilms.dto.ResultClientResponse;
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
    private String created;
    private String edited;
    private String url;

    public TbStarWarsMovies(ResultClientResponse result) {
        this.title = result.getTitle();
        this.episodeId = result.getEpisodeId();
        this.director = result.getDirector();
        this.openingCrawl = result.getOpeningCrawl();
        this.producer = result.getProducer();
        this.releaseDate = result.getReleaseDate();
        this.version = 1;
        this.created = result.getCreated();
        this.edited = result.getEdited();
        this.url = result.getUrl();
    }


}
