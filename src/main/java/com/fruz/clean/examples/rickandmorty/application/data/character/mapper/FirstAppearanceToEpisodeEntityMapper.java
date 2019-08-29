package com.fruz.clean.examples.rickandmorty.application.data.character.mapper;

import com.fruz.clean.examples.rickandmorty.application.domain.model.FirstAppearance;
import com.fruz.clean.examples.rickandmorty.common.mapper.Mapper;
import com.fruz.clean.examples.rickandmorty.application.data.episode.entity.EpisodeEntity;

public class FirstAppearanceToEpisodeEntityMapper extends Mapper<FirstAppearance, EpisodeEntity> {

  @Override public EpisodeEntity map(FirstAppearance value) {
    return null;
  }

  @Override public FirstAppearance reverseMap(EpisodeEntity value) {
    FirstAppearance firstAppearance = new FirstAppearance();
    firstAppearance.name = value.name;
    firstAppearance.code = value.episode;
    return firstAppearance;
  }
}
