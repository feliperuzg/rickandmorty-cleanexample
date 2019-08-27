package com.fruz.clean.examples.rickandmorty.application.character.data.mapper;

import com.fruz.clean.examples.rickandmorty.application.character.domain.model.FirstAppearance;
import com.fruz.clean.examples.rickandmorty.application.common.mapper.Mapper;
import com.fruz.clean.examples.rickandmorty.application.episode.data.entity.EpisodeEntity;

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
