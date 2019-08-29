package com.fruz.clean.examples.rickandmorty.application.domain.usecase;

import com.fruz.clean.examples.rickandmorty.application.domain.model.CharacterInfo;
import com.fruz.clean.examples.rickandmorty.application.domain.repository.CharacterRepository;

public class CharacterInfoUseCase {

  private final CharacterRepository characterRepository;

  public CharacterInfoUseCase(CharacterRepository characterRepository) {
    this.characterRepository = characterRepository;
  }

  public CharacterInfo executeWith(String code) {
    return characterRepository.getInfo(code);
  }
}
