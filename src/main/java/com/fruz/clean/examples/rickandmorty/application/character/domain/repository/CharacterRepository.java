package com.fruz.clean.examples.rickandmorty.application.character.domain.repository;

import com.fruz.clean.examples.rickandmorty.application.character.domain.model.CharacterInfo;

public interface CharacterRepository {
  CharacterInfo getInfo(String code);
}
