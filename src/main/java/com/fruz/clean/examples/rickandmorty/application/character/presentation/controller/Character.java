package com.fruz.clean.examples.rickandmorty.application.character.presentation.controller;

import com.fruz.clean.examples.rickandmorty.application.character.domain.model.CharacterInfo;
import com.fruz.clean.examples.rickandmorty.application.character.presentation.body.CharacterInfoBody;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/v1/character")
@RestController
public interface Character {
  @PostMapping(value = "/info", consumes = "application/json", produces = "application/json")
  ResponseEntity<CharacterInfo> info(@Valid @RequestBody CharacterInfoBody characterInfoBody);
}