package com.fruz.clean.examples.rickandmorty.configuration.character;

import com.fruz.clean.examples.rickandmorty.application.data.character.datasource.CharacterApiDatasource;
import com.fruz.clean.examples.rickandmorty.application.data.character.datasource.CharacterDatasource;
import com.fruz.clean.examples.rickandmorty.application.data.character.entity.CharacterEntity;
import com.fruz.clean.examples.rickandmorty.application.data.character.mapper.CharacterInfoToCharacterEntityMapper;
import com.fruz.clean.examples.rickandmorty.application.data.character.mapper.FirstAppearanceToEpisodeEntityMapper;
import com.fruz.clean.examples.rickandmorty.application.data.character.repository.CharacterApiRepository;
import com.fruz.clean.examples.rickandmorty.application.domain.model.CharacterInfo;
import com.fruz.clean.examples.rickandmorty.application.domain.model.FirstAppearance;
import com.fruz.clean.examples.rickandmorty.application.domain.repository.CharacterRepository;
import com.fruz.clean.examples.rickandmorty.application.domain.usecase.CharacterInfoUseCase;
import com.fruz.clean.examples.rickandmorty.application.presentation.controller.Character;
import com.fruz.clean.examples.rickandmorty.application.presentation.controller.CharacterController;
import com.fruz.clean.examples.rickandmorty.common.mapper.Mapper;
import com.fruz.clean.examples.rickandmorty.application.data.episode.datasource.EpisodeApiDatasource;
import com.fruz.clean.examples.rickandmorty.application.data.episode.datasource.EpisodeDatasource;
import com.fruz.clean.examples.rickandmorty.application.data.episode.entity.EpisodeEntity;
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
    return new CharacterApiRepository(
        characterDatasource(),
        episodeDatasource(),
        characterInfoToCharacterEntityMapper(),
        firstAppearanceToEpisodeEntityMapper()
    );
  }

  @Bean
  EpisodeDatasource episodeDatasource() {
    return new EpisodeApiDatasource(restOperations());
  }

  @Bean
  Mapper<CharacterInfo, CharacterEntity> characterInfoToCharacterEntityMapper() {
    return new CharacterInfoToCharacterEntityMapper();
  }

  @Bean
  Mapper<FirstAppearance, EpisodeEntity> firstAppearanceToEpisodeEntityMapper() {
    return new FirstAppearanceToEpisodeEntityMapper();
  }

  @Bean
  CharacterDatasource characterDatasource() {
    return new CharacterApiDatasource(restOperations());
  }

  @Bean
  RestOperations restOperations() {
    return new RestTemplate();
  }
}
