package com.fruz.clean.examples.rickandmorty.application.character.data.datasource;

import com.fruz.clean.examples.rickandmorty.application.character.data.entity.CharacterEntity;

public interface CharacterDatasource {
  CharacterEntity getCharacter(String code);
}
