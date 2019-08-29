package com.fruz.clean.examples.rickandmorty.application.presentation.controller.data.repository;

import com.fruz.clean.examples.rickandmorty.application.character.data.datasource.CharacterDatasource;
import com.fruz.clean.examples.rickandmorty.application.character.data.entity.CharacterEntity;
import com.fruz.clean.examples.rickandmorty.application.character.data.repository.CharacterApiRepository;
import com.fruz.clean.examples.rickandmorty.application.character.domain.model.CharacterInfo;
import com.fruz.clean.examples.rickandmorty.application.character.domain.model.FirstAppearance;
import com.fruz.clean.examples.rickandmorty.application.character.domain.repository.CharacterRepository;
import com.fruz.clean.examples.rickandmorty.application.common.mapper.Mapper;
import com.fruz.clean.examples.rickandmorty.application.episode.data.datasource.EpisodeDatasource;
import com.fruz.clean.examples.rickandmorty.application.episode.data.entity.EpisodeEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;

import static org.hamcrest.Matchers.instanceOf;

@RunWith(SpringJUnit4ClassRunner.class)
public class CharacterApiRepositoryTests {
  private CharacterApiRepository characterApiRepository;

  @Mock
  CharacterDatasource characterDatasource;
  @Mock
  EpisodeDatasource episodeDatasource;
  @Mock
  Mapper<CharacterInfo, CharacterEntity> characterInfoToCharacterEntityMapper;
  @Mock
  Mapper<FirstAppearance, EpisodeEntity> firstAppearanceToEpisodeEntityMapper;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);

    characterApiRepository = new CharacterApiRepository(
        characterDatasource,
        episodeDatasource,
        characterInfoToCharacterEntityMapper,
        firstAppearanceToEpisodeEntityMapper
    );
  }

  @Test
  public void shouldBeValidInstanceOfCharacterRepository_whenCreated() {
    Assert.assertThat(characterApiRepository, instanceOf(CharacterRepository.class));
  }
}
