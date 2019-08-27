package com.fruz.clean.examples.rickandmorty.application.episode.data.datasource;

import com.fruz.clean.examples.rickandmorty.application.episode.data.entity.EpisodeEntity;

public interface EpisodeDatasource {
  EpisodeEntity findBy(String id);
}
