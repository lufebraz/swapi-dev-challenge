package com.challenge.starwarsfilms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultClientResponse {
    @JsonProperty("episode_id")
    private Integer episodeId;
    private String title;
    @JsonProperty("opening_crawl")
    private String openingCrawl;
    private String director;
    private String producer;
    @JsonProperty("release_date")
    private String releaseDate;
    private String created;
    private String edited;
    private String url;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
}
