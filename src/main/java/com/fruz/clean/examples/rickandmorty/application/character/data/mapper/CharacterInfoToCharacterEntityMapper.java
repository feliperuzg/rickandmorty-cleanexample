package com.fruz.clean.examples.rickandmorty.application.character.data.mapper;

import com.fruz.clean.examples.rickandmorty.application.character.data.entity.CharacterEntity;
import com.fruz.clean.examples.rickandmorty.application.character.domain.model.CharacterInfo;
import com.fruz.clean.examples.rickandmorty.application.common.mapper.Mapper;

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
