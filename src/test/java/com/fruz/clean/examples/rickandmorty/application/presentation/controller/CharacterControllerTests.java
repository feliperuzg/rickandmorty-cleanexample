package com.fruz.clean.examples.rickandmorty.application.presentation.controller;

import com.fruz.clean.examples.rickandmorty.application.character.domain.model.CharacterInfo;
import com.fruz.clean.examples.rickandmorty.application.character.domain.model.FirstAppearance;
import com.fruz.clean.examples.rickandmorty.application.character.domain.usecase.CharacterInfoUseCase;
import com.fruz.clean.examples.rickandmorty.application.character.presentation.body.CharacterInfoBody;
import com.fruz.clean.examples.rickandmorty.application.character.presentation.controller.Character;
import com.fruz.clean.examples.rickandmorty.application.character.presentation.controller.CharacterController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
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
  private final String DATA_EPISODE_CODE = "S01E10";

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

    FirstAppearance firstAppearance = new FirstAppearance();
    firstAppearance.code = DATA_EPISODE_CODE;
    firstAppearance.name = DATA_EPISODE_NAME;
    characterInfo.firstAppearance = firstAppearance;
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
    Assert.assertEquals(DATA_EPISODE_CODE ,characterInfo.firstAppearance.code);
    Assert.assertEquals(DATA_EPISODE_NAME ,characterInfo.firstAppearance.name);
  }

  @Test(expected = MethodArgumentNotValidException.class)
  public void shouldThrowMethodArgumentNotValidException_WhenCharacterInfoBodyHasNoCode() {
    CharacterInfoBody characterInfoBody1 = new CharacterInfoBody();
    characterController.info(characterInfoBody1);
  }
}
