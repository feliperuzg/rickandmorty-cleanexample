package com.fruz.clean.examples.rickandmorty.application.data.episode.datasource;

import com.fruz.clean.examples.rickandmorty.application.data.episode.entity.EpisodeEntity;
import org.springframework.web.client.RestOperations;

public class EpisodeApiDatasource implements EpisodeDatasource {

  private final RestOperations restOperations;
  private final String episodeUrl = "https://rickandmortyapi.com/api/episode/";

  public EpisodeApiDatasource(RestOperations restOperations) {
    this.restOperations = restOperations;
  }

  @Override public EpisodeEntity findBy(String id) {
    return restOperations.getForObject(episodeUrl.concat(id), EpisodeEntity.class);
  }
}
