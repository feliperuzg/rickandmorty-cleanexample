package com.fruz.clean.examples.rickandmorty.application.character.data.repository;

import com.fruz.clean.examples.rickandmorty.application.character.data.datasource.CharacterDatasource;
import com.fruz.clean.examples.rickandmorty.application.character.data.entity.CharacterEntity;
import com.fruz.clean.examples.rickandmorty.application.character.domain.model.CharacterInfo;
import com.fruz.clean.examples.rickandmorty.application.character.domain.repository.CharacterRepository;
import com.fruz.clean.examples.rickandmorty.application.common.mapper.Mapper;

public class CharacterApiRepository implements CharacterRepository {

  private CharacterDatasource characterDatasource;
  private Mapper<CharacterInfo, CharacterEntity> characterInfoToCharacterEntityMapper;

  public CharacterApiRepository(CharacterDatasource characterDatasource, Mapper<CharacterInfo, CharacterEntity> characterInfoToCharacterEntityMapper) {
    this.characterDatasource = characterDatasource;
    this.characterInfoToCharacterEntityMapper = characterInfoToCharacterEntityMapper;
  }

  @Override public CharacterInfo getInfo(String code) {
    CharacterEntity characterEntity = characterDatasource.getCharacter(code);
    return characterInfoToCharacterEntityMapper.reverseMap(characterEntity);
  }
}
