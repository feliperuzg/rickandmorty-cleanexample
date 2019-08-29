package com.fruz.clean.examples.rickandmorty.application.domain.repository;

import com.fruz.clean.examples.rickandmorty.application.domain.model.CharacterInfo;

public interface CharacterRepository {
  CharacterInfo getInfo(String code);
}
