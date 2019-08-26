package com.fruz.clean.examples.rickandmorty.application.character.domain.usecase;

import com.fruz.clean.examples.rickandmorty.application.character.domain.model.CharacterInfo;
import com.fruz.clean.examples.rickandmorty.application.character.domain.repository.CharacterRepository;

public class CharacterInfoUseCase {

  private final CharacterRepository characterRepository;

  public CharacterInfoUseCase(CharacterRepository characterRepository) {
    this.characterRepository = characterRepository;
  }

  public CharacterInfo executeWith(String code) {
    return characterRepository.getInfo(code);
  }
}
