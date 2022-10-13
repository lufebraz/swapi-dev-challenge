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
@Table(name = "tb_starships")
public class TbStarships {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String url;

    @ManyToMany(mappedBy = "tbStarships")
    private List<TbStarWarsMovies> tbStarWarsMovies;
    TbStarships(String url) {
        this.url = url;
    }
}