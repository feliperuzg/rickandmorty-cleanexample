package com.fruz.clean.examples.rickandmorty.application.character.data.mapper;

import com.fruz.clean.examples.rickandmorty.application.character.domain.model.Episode;
import com.fruz.clean.examples.rickandmorty.application.common.mapper.Mapper;
import com.sun.xml.internal.xsom.impl.scd.Iterators;

public class EpisodeStringMapper extends Mapper<Episode, String> {
  @Override public String map(Episode value) {
    return null;
  }

  @Override public Episode reverseMap(String value) {
    String[] splitedUrl = value.split("/");
    String episodeCode = splitedUrl[splitedUrl.length-1];
    Episode episode = new Episode();
    episode.name = "";
    episode.code = episodeCode;
    return episode;
  }
}
