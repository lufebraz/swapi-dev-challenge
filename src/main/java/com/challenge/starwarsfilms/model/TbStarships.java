package com.challenge.starwarsfilms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_starships")
public class TbStarships {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String url;

    @ManyToOne
    @JoinColumn
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private TbStarWarsMovies tbStarWarsMovies;

    TbStarships(String url) {
        this.url = url;
    }
}