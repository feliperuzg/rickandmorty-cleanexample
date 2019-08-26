package com.fruz.clean.examples.rickandmorty.configuration.character;

import com.fruz.clean.examples.rickandmorty.application.character.data.datasource.CharacterApiDatasoruce;
import com.fruz.clean.examples.rickandmorty.application.character.data.datasource.CharacterDatasource;
import com.fruz.clean.examples.rickandmorty.application.character.data.entity.CharacterEntity;
import com.fruz.clean.examples.rickandmorty.application.character.data.mapper.CharacterInfoToCharacterEntityMapper;
import com.fruz.clean.examples.rickandmorty.application.character.data.mapper.EpisodeStringMapper;
import com.fruz.clean.examples.rickandmorty.application.character.data.repository.CharacterApiRepository;
import com.fruz.clean.examples.rickandmorty.application.character.domain.model.CharacterInfo;
import com.fruz.clean.examples.rickandmorty.application.character.domain.model.Episode;
import com.fruz.clean.examples.rickandmorty.application.character.domain.repository.CharacterRepository;
import com.fruz.clean.examples.rickandmorty.application.character.domain.usecase.CharacterInfoUseCase;
import com.fruz.clean.examples.rickandmorty.application.character.presentation.controller.Character;
import com.fruz.clean.examples.rickandmorty.application.character.presentation.controller.CharacterController;
import com.fruz.clean.examples.rickandmorty.application.common.mapper.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CharacterConfiguration {

  @Bean
  Character character() {
    return new CharacterController(characterInfoUseCase());
  }

  @Bean
  CharacterInfoUseCase characterInfoUseCase() {
    return new CharacterInfoUseCase(characterRepository());
  }

  @Bean
  CharacterRepository characterRepository() {
    return new CharacterApiRepository(characterDatasource(), characterInfoToCharacterEntityMapper());
  }

  @Bean
  Mapper<CharacterInfo, CharacterEntity> characterInfoToCharacterEntityMapper() {
    return new CharacterInfoToCharacterEntityMapper(episodeStringMapper());
  }

  @Bean
  Mapper<Episode, String> episodeStringMapper() {
    return new EpisodeStringMapper();
  }

  @Bean
  CharacterDatasource characterDatasource() {
    return new CharacterApiDatasoruce(restOperations());
  }

  @Bean
  RestOperations restOperations() {
    return new RestTemplate();
  }
}