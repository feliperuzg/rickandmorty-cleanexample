package com.fruz.clean.examples.rickandmorty.application.data.character.datasource;

import com.fruz.clean.examples.rickandmorty.application.data.character.entity.CharacterEntity;

public interface CharacterDatasource {
  CharacterEntity getCharacter(String code);
}
