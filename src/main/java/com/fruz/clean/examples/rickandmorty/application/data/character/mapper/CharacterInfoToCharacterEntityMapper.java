package com.fruz.clean.examples.rickandmorty.application.data.character.mapper;

import com.fruz.clean.examples.rickandmorty.application.data.character.entity.CharacterEntity;
import com.fruz.clean.examples.rickandmorty.application.domain.model.CharacterInfo;
import com.fruz.clean.examples.rickandmorty.common.mapper.Mapper;

public class CharacterInfoToCharacterEntityMapper extends Mapper<CharacterInfo, CharacterEntity> {

  @Override public CharacterEntity map(CharacterInfo value) {
    return null;
  }

  @Override public CharacterInfo reverseMap(CharacterEntity value) {
    CharacterInfo characterInfo = new CharacterInfo();
    characterInfo.name = value.name;
    characterInfo.gender = value.gender;
    characterInfo.species = value.species;
    characterInfo.status = value.status;
    return characterInfo;
  }
}
