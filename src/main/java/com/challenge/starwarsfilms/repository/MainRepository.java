package com.challenge.starwarsfilms.repository;

import com.challenge.starwarsfilms.model.TbStarWarsMovies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends JpaRepository<TbStarWarsMovies, Integer> {
}
