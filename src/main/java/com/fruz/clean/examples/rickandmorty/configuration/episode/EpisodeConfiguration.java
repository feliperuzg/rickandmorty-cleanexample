package com.fruz.clean.examples.rickandmorty.configuration.episode;

import com.fruz.clean.examples.rickandmorty.application.episode.data.datasource.EpisodeApiDatasource;
import com.fruz.clean.examples.rickandmorty.application.episode.data.datasource.EpisodeDatasource;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

public class EpisodeConfiguration {
  @Bean
  EpisodeDatasource episodeDatasource() {
    return new EpisodeApiDatasource(restOperations());
  }

  @Bean
  RestOperations restOperations() {
    return new RestTemplate();
  }
}