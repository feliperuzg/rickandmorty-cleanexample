package com.fruz.clean.examples.rickandmorty.application.data.episode.datasource;

import com.fruz.clean.examples.rickandmorty.application.data.episode.entity.EpisodeEntity;

public interface EpisodeDataSource {
  EpisodeEntity findBy(String id);
}
