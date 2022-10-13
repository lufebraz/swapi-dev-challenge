package com.challenge.starwarsfilms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SWFilmsResponse {
    private List<SWFilm> results;
}
