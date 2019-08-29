package com.fruz.clean.examples.rickandmorty.application.data.episode.datasource;

import com.fruz.clean.examples.rickandmorty.application.data.episode.entity.EpisodeEntity;

public interface EpisodeDatasource {
  EpisodeEntity findBy(String id);
}
