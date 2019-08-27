package com.fruz.clean.examples.rickandmorty.application.character.data.repository;

import com.fruz.clean.examples.rickandmorty.application.character.data.datasource.CharacterDatasource;
import com.fruz.clean.examples.rickandmorty.application.character.data.entity.CharacterEntity;
import com.fruz.clean.examples.rickandmorty.application.character.domain.model.CharacterInfo;
import com.fruz.clean.examples.rickandmorty.application.character.domain.model.FirstAppearance;
import com.fruz.clean.examples.rickandmorty.application.character.domain.repository.CharacterRepository;
import com.fruz.clean.examples.rickandmorty.application.common.mapper.Mapper;
import com.fruz.clean.examples.rickandmorty.application.episode.data.datasource.EpisodeDatasource;
import com.fruz.clean.examples.rickandmorty.application.episode.data.entity.EpisodeEntity;

public class CharacterApiRepository implements CharacterRepository {

  private final CharacterDatasource characterDatasource;
  private final EpisodeDatasource episodeDatasource;
  private final Mapper<CharacterInfo, CharacterEntity> characterInfoToCharacterEntityMapper;
  private final Mapper<FirstAppearance, EpisodeEntity> firstAppearanceToEpisodeEntityMapper;

  public CharacterApiRepository(
      CharacterDatasource characterDatasource,
      EpisodeDatasource episodeDatasource,
      Mapper<CharacterInfo, CharacterEntity> characterInfoToCharacterEntityMapper,
      Mapper<FirstAppearance, EpisodeEntity> firstAppearanceToEpisodeEntityMapper
  ) {
    this.characterDatasource = characterDatasource;
    this.episodeDatasource = episodeDatasource;
    this.characterInfoToCharacterEntityMapper = characterInfoToCharacterEntityMapper;
    this.firstAppearanceToEpisodeEntityMapper = firstAppearanceToEpisodeEntityMapper;
  }

  @Override public CharacterInfo getInfo(String code) {
    CharacterEntity characterEntity = characterDatasource.getCharacter(code);
    CharacterInfo characterInfo = characterInfoToCharacterEntityMapper.reverseMap(characterEntity);
    characterInfo.firstAppearance = getWith(characterEntity);
    return characterInfo;
  }

  private FirstAppearance getWith(CharacterEntity characterEntity) {
    String[] episodeUrlSplitted = characterEntity.episode.get(0).split("/");
    String episodeId = episodeUrlSplitted[episodeUrlSplitted.length - 1];
    EpisodeEntity episodeEntity = episodeDatasource.findBy(episodeId);
    return firstAppearanceToEpisodeEntityMapper.reverseMap(episodeEntity);
  }
}
