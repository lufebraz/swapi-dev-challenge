package com.challenge.starwarsfilms.model;

import com.challenge.starwarsfilms.dto.ResultClientResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @ManyToMany
    @JoinColumn(name = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<TbCharacters> tbCharacters = new ArrayList<>();

    @ManyToMany
    @JoinColumn(name = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<TbPlanets> tbPlanets = new ArrayList<>();

    @ManyToMany
    @JoinColumn(name = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<TbStarships> tbStarships = new ArrayList<>();

    @ManyToMany
    @JoinColumn(name = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<TbVehicles> tbVehicles = new ArrayList<>();

    @ManyToMany
    @JoinColumn(name = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<TbSpecies> tbSpecies = new ArrayList<>();

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
        this.tbCharacters = result.getCharacters().stream().map(TbCharacters::new).collect(Collectors.toList());
        this.tbPlanets = result.getPlanets().stream().map(TbPlanets::new).collect(Collectors.toList());
        this.tbStarships = result.getStarships().stream().map(TbStarships::new).collect(Collectors.toList());
        this.tbVehicles = result.getVehicles().stream().map(TbVehicles::new).collect(Collectors.toList());
        this.tbSpecies = result.getSpecies().stream().map(TbSpecies::new).collect(Collectors.toList());
    }


}
