package com.fruz.clean.examples.rickandmorty.application.presentation.controller.data.datasource;

import com.fruz.clean.examples.rickandmorty.application.character.data.datasource.CharacterApiDatasource;
import com.fruz.clean.examples.rickandmorty.application.character.data.datasource.CharacterDatasource;
import com.fruz.clean.examples.rickandmorty.application.character.data.entity.CharacterEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestOperations;

import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class CharacterApiDatasourceTests {

  CharacterApiDatasource characterApiDatasource;
  CharacterEntity characterEntity;

  @Mock
  RestOperations restOperations;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);

    characterApiDatasource = new CharacterApiDatasource(restOperations);
  }

  @Test
  public void shouldReturnValidIntanceOfCharacterDatasource_whenCreated() {
    Assert.assertThat(characterApiDatasource, instanceOf(CharacterDatasource.class));
  }

  @Test
  public void asdasd() {
    when(restOperations.getForObject("https://rickandmortyapi.com/api/character/1", CharacterEntity.class)).thenReturn(characterEntity);
  }
}
