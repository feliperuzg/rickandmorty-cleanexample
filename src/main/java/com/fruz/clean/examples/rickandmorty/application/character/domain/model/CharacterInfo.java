package com.fruz.clean.examples.rickandmorty.application.character.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CharacterInfo {
  @JsonProperty
  public String name;
  @JsonProperty
  public String status;
  @JsonProperty
  public String species;
  @JsonProperty
  public String gender;
  @JsonProperty
  public List<Episode> episodes;
}
