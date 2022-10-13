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
@Table(name = "tb_vehicles")
public class TbVehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String url;

    @ManyToMany(mappedBy = "tbVehicles")
    private List<TbStarWarsMovies> tbStarWarsMovies;
    TbVehicles(String url) {
        this.url = url;
    }
}