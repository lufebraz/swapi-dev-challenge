package com.challenge.starwarsfilms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_planets")
public class TbPlanets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String url;

    @ManyToMany(mappedBy = "tbPlanets")
    private List<TbStarWarsMovies> tbStarWarsMovies;
    TbPlanets(String url) {
        this.url = url;
    }
}