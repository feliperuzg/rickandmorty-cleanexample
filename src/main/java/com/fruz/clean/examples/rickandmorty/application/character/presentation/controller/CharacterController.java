package com.fruz.clean.examples.rickandmorty.application.character.presentation.controller;

import com.fruz.clean.examples.rickandmorty.application.character.domain.model.CharacterInfo;
import com.fruz.clean.examples.rickandmorty.application.character.domain.usecase.CharacterInfoUseCase;
import com.fruz.clean.examples.rickandmorty.application.character.presentation.body.CharacterInfoBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CharacterController implements Character {

  private final CharacterInfoUseCase characterInfoUseCase;

  public CharacterController(CharacterInfoUseCase characterInfoUseCase) {
    this.characterInfoUseCase = characterInfoUseCase;
  }

  @Override public ResponseEntity<CharacterInfo> info(CharacterInfoBody characterInfoBody) {
    CharacterInfo characterInfo = characterInfoUseCase.executeWith(characterInfoBody.code);
    return new ResponseEntity<>(characterInfo, HttpStatus.OK);
  }
}