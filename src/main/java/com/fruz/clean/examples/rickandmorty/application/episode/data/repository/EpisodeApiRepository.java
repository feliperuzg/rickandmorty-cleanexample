package com.fruz.clean.examples.rickandmorty.application.episode.data.repository;

import com.fruz.clean.examples.rickandmorty.application.episode.data.datasource.EpisodeDatasource;
import com.fruz.clean.examples.rickandmorty.application.episode.domain.model.Episode;
import com.fruz.clean.examples.rickandmorty.application.episode.domain.repository.EpisodeRepository;

public class EpisodeApiRepository implements EpisodeRepository {

  private final EpisodeDatasource episodeDatasource;

  public EpisodeApiRepository(EpisodeDatasource episodeDatasource) {
    this.episodeDatasource = episodeDatasource;
  }

  @Override public Episode findBy(String id) {
    return null;
  }
}
