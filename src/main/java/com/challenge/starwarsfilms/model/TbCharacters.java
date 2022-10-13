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
@Table(name = "TB_CHARACTERS")
public class TbCharacters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String url;

    @ManyToMany(mappedBy = "tbCharacters")
    private List<TbStarWarsMovies> tbStarWarsMovies;
    TbCharacters(String url) {
        this.url = url;
    }

}
