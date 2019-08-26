package com.fruz.clean.examples.rickandmorty.application.character.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OriginEntity {
  @JsonProperty
  public String name;
  @JsonProperty
  public String url;
}