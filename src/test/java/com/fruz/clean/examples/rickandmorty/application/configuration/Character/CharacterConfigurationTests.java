package com.fruz.clean.examples.rickandmorty.application.configuration.Character;

import com.fruz.clean.examples.rickandmorty.application.data.character.datasource.CharacterDataSource;
import com.fruz.clean.examples.rickandmorty.application.data.character.entity.CharacterEntity;
import com.fruz.clean.examples.rickandmorty.application.data.episode.entity.EpisodeEntity;
import com.fruz.clean.examples.rickandmorty.application.domain.model.CharacterInfo;
import com.fruz.clean.examples.rickandmorty.application.domain.model.FirstAppearance;
import com.fruz.clean.examples.rickandmorty.application.domain.repository.CharacterRepository;
import com.fruz.clean.examples.rickandmorty.application.domain.usecase.CharacterInfoUseCase;
import com.fruz.clean.examples.rickandmorty.application.presentation.controller.Character;
import com.fruz.clean.examples.rickandmorty.common.mapper.Mapper;
import com.fruz.clean.examples.rickandmorty.configuration.character.CharacterConfiguration;
import com.fruz.clean.examples.rickandmorty.configuration.character.CharacterProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestOperations;

import static org.hamcrest.Matchers.instanceOf;

@RunWith(SpringJUnit4ClassRunner.class)
public class CharacterConfigurationTests {

  private CharacterConfiguration characterConfiguration;

  @Mock
  private RestOperations restOperations;

  @Mock
  private CharacterProperties characterProperties;

  @Mock
  private CharacterDataSource characterDataSource;

  @Mock
  private CharacterRepository characterRepository;

  @Mock
  private Character character;

  @Mock
  private Mapper<FirstAppearance, EpisodeEntity> firstAppearanceEpisodeEntityMapper;

  @Mock
  private Mapper<CharacterInfo, CharacterEntity> characterInfoCharacterEntityMapper;

  @Mock
  private CharacterInfoUseCase characterInfoUseCase;



  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);

    characterConfiguration = new CharacterConfiguration();
  }

  @Test
  public void shouldReturnValidInstanceOfCharacter() {
    Assert.assertThat(characterConfiguration.character(characterInfoUseCase), instanceOf(Character.class));
  }
}
