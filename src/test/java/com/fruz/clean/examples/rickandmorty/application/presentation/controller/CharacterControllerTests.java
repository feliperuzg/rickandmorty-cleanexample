package com.fruz.clean.examples.rickandmorty.application.presentation.controller;

import com.fruz.clean.examples.rickandmorty.application.character.domain.model.CharacterInfo;
import com.fruz.clean.examples.rickandmorty.application.character.domain.model.Episode;
import com.fruz.clean.examples.rickandmorty.application.character.domain.usecase.CharacterInfoUseCase;
import com.fruz.clean.examples.rickandmorty.application.character.presentation.body.CharacterInfoBody;
import com.fruz.clean.examples.rickandmorty.application.character.presentation.controller.Character;
import com.fruz.clean.examples.rickandmorty.application.character.presentation.controller.CharacterController;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@BootstrapWith(SpringBootTestContextBootstrapper.class)
public class CharacterControllerTests {

  private CharacterController characterController;
  private CharacterInfo characterInfo;
  private CharacterInfoBody characterInfoBody;

  private final String DATA_CHARACTER_CODE = "1";
  private final String DATA_CHARACTER_NAME = "character name";
  private final String DATA_CHARACTER_STATUS = "status";
  private final String DATA_CHARACTER_SPECIES = "species";
  private final String DATA_CHARACTER_GENDER = "gender";
  private final String DATA_EPISODE_NAME = "Episode name";
  private final String DATA_EPISODE_CODE = "10";

  @Mock
  CharacterInfoUseCase characterInfoUseCase;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);

    characterController = new CharacterController(characterInfoUseCase);

    characterInfoBody = new CharacterInfoBody();
    characterInfoBody.code = DATA_CHARACTER_CODE;

    characterInfo = new CharacterInfo();
    characterInfo.name = DATA_CHARACTER_NAME;
    characterInfo.status = DATA_CHARACTER_STATUS;
    characterInfo.species = DATA_CHARACTER_SPECIES;
    characterInfo.gender = DATA_CHARACTER_GENDER;

    List<Episode> episodes = new ArrayList<>();
    Episode episode = new Episode();
    episode.code = DATA_EPISODE_CODE;
    episode.name = DATA_EPISODE_NAME;
    episodes.add(episode);
    characterInfo.episodes = episodes;
  }

  @Test
  public void shouldReturnValidInstanceOfCharacter_WhenCreated() {
    Assert.assertThat(characterController, instanceOf(Character.class));
  }

  @Test
  public void shouldReturnValidCharacterInfoModel_WhenCalledWithValidParameters() {
    when(characterInfoUseCase.executeWith(DATA_CHARACTER_CODE)).thenReturn(characterInfo);

    CharacterInfo characterInfo = characterController.info(characterInfoBody).getBody();

    Assert.assertEquals(DATA_CHARACTER_NAME, characterInfo.name);
    Assert.assertEquals(DATA_CHARACTER_GENDER, characterInfo.gender);
    Assert.assertEquals(DATA_CHARACTER_SPECIES, characterInfo.species);
    Assert.assertEquals(DATA_CHARACTER_STATUS, characterInfo.status);
    Assert.assertEquals(1, characterInfo.episodes.size());
    Assert.assertEquals(DATA_EPISODE_CODE ,characterInfo.episodes.get(0).code);
    Assert.assertEquals(DATA_EPISODE_NAME ,characterInfo.episodes.get(0).name);
  }

  @Test(expected = MethodArgumentNotValidException.class)
  public void shouldThrowMethodArgumentNotValidException_WhenCharacterInfoBodyHasNoCode() {
    CharacterInfoBody characterInfoBody1 = new CharacterInfoBody();
    characterController.info(characterInfoBody1);
  }
}-…
