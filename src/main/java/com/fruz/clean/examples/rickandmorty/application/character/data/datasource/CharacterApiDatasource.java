package com.fruz.clean.examples.rickandmorty.application.character.data.datasource;

import com.fruz.clean.examples.rickandmorty.application.character.data.entity.CharacterEntity;
import org.springframework.web.client.RestOperations;

public class CharacterApiDatasource implements CharacterDatasource {
  private final String characterUrl = "https://rickandmortyapi.com/api/character/";
  private final RestOperations restOperations;

  public CharacterApiDatasource(RestOperations restOperations) {
    this.restOperations = restOperations;
  }

  @Override public CharacterEntity getCharacter(String code) {
    return restOperations.getForObject(characterUrl.concat(code), CharacterEntity.class);
  }
}
