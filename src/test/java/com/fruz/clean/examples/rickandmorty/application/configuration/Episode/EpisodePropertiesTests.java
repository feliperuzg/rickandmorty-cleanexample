package com.fruz.clean.examples.rickandmorty.application.configuration.Episode;

import com.fruz.clean.examples.rickandmorty.configuration.episode.EpisodeProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class EpisodePropertiesTests {

  private EpisodeProperties episodeProperties;

  private final static String DATA_EPISODE_ID = "123";
  private final static String DATA_BASEURL = "https://rickandmortyapi.com/api/";
  private final static String DATA_EPISODE_ENDPOINT = "episode/{episodeId}";
  private final static String DATA_EPISODES_ENDPOINT = "episode";
  private final static String DATA_EPISODE_FULL_URL = "https://rickandmortyapi.com/api/episode/123";

  @Before
  public void setUp() {
    episodeProperties = new EpisodeProperties();
    ReflectionTestUtils.setField(episodeProperties, "baseURL", DATA_BASEURL);
    ReflectionTestUtils.setField(episodeProperties, "episodeEndpoint", DATA_EPISODE_ENDPOINT);
    ReflectionTestUtils.setField(episodeProperties, "episodesEndpoint", DATA_EPISODES_ENDPOINT);
  }

  @Test
  public void shouldReturnAValidEpisodesURL() {
    Assert.assertNotNull(episodeProperties.getEpisodesURL());
  }

  @Test
  public void shouldReturnAValidEpisodeURL() {
    Assert.assertNotNull(episodeProperties.getEpisodeURL(DATA_EPISODE_ID));
    Assert.assertEquals(episodeProperties.getEpisodeURL(DATA_EPISODE_ID), DATA_EPISODE_FULL_URL);
  }
}
