package com.challenge.starwarsfilms.dto;

import com.challenge.starwarsfilms.model.TbStarWarsMovies;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SWListAllResponse {

    private Integer id;
    private String title;
    private Integer episodeId;
    private Integer version;
    public SWListAllResponse(TbStarWarsMovies tbStarWarsMovies) {
        this.title = tbStarWarsMovies.getTitle();
        this.episodeId = tbStarWarsMovies.getEpisodeId();
        this.version = tbStarWarsMovies.getVersion();
        this.id = tbStarWarsMovies.getId();
    }
}
