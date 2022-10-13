package com.challenge.starwarsfilms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

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
    private Long Id;
    private String url;

    @ManyToOne
    @JoinColumn
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private TbStarWarsMovies tbStarWarsMovies;

    TbCharacters(String url) {
        this.url = url;
    }

}
