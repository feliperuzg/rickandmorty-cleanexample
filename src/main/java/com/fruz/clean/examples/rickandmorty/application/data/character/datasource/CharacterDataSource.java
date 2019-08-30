package com.fruz.clean.examples.rickandmorty.application.data.character.datasource;

import com.fruz.clean.examples.rickandmorty.application.data.character.entity.CharacterEntity;

public interface CharacterDataSource {
  CharacterEntity getCharacter(String code);
}
