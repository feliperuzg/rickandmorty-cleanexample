package com.fruz.clean.examples.rickandmorty.application.presentation.controller.data.datasource.episode;

import com.fruz.clean.examples.rickandmorty.application.data.episode.datasource.EpisodeApiDatasource;
import com.fruz.clean.examples.rickandmorty.application.data.episode.datasource.EpisodeDatasource;
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
public class EpisodeApiDatasourceTests {
  private EpisodeApiDatasource episodeApiDatasource;

  @Mock
  private RestOperations restOperations;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);

    episodeApiDatasource = new EpisodeApiDatasource(restOperations);
  }

  @Test
  public void shouldBeValidInstanceOfEpisodeDatasource_whenCreated() {
    Assert.assertThat(episodeApiDatasource, instanceOf(EpisodeDatasource.class));
  }
}
