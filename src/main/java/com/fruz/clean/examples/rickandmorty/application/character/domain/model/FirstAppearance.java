package com.fruz.clean.examples.rickandmorty.application.character.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FirstAppearance {
  @JsonProperty
  public String name;
  @JsonProperty
  public String code;
}
