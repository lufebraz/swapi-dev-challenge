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
@Table(name = "tb_species")
public class TbSpecies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String url;

    @ManyToMany(mappedBy = "tbSpecies")
    private List<TbStarWarsMovies> tbStarWarsMovies;
    TbSpecies(String url) {
        this.url = url;
    }
}