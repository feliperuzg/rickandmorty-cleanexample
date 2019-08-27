package com.fruz.clean.examples.rickandmorty.application.episode.domain.repository;

import com.fruz.clean.examples.rickandmorty.application.episode.domain.model.Episode;

public interface EpisodeRepository {
  Episode findBy(String id);
}
