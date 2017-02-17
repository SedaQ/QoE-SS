package com.seda.qoe.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.seda.qoe.config.BeanMappingConfiguration;
import com.seda.qoe.dto.mos.MosDTO;
import com.seda.qoe.dto.scenario.ScenarioDTO;
import com.seda.qoe.dto.video.VideoDTO;
import com.seda.qoe.entity.Mos;
import com.seda.qoe.entity.Scenario;
import com.seda.qoe.entity.Video;

import static org.testng.Assert.*;

@ContextConfiguration(classes = BeanMappingConfiguration.class)
public class BeanMappingTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private BeanMapping beanMapping;

	@BeforeClass
	public void beforeClass() {
	}

	@Test
	public void testVideoMapEntityToDTO() {
//		Video video = new Video();
//		video.setId(4L);
//		video.setName("video2");
//		video.setVideoSource();
//
//		//Mos mos = new Mos();
//		Scenario scenario1 = new Scenario();
//		Scenario scenario2 = new Scenario();
//		scenario2.setScenario("laaazzyyy loading");
//
//		//video.setMos(mos);
//		video.addScenarion(scenario1);
//		video.addScenarion(scenario2);
//
//		VideoDTO videoDTO = beanMapping.mapTo(video, VideoDTO.class);
//		assertEquals(videoDTO.getName(), video.getName());
//		assertEquals(videoDTO.getId(), video.getId());
//		assertEquals(videoDTO.getVideoSource(), video.getVideoSource());
//		assertEquals(videoDTO.getScenario().size(), video.getScenarions()
//				.size());
	}

	@Test
	public void testVideoMapDTOToEntity() {
//		VideoDTO videoDTO = new VideoDTO();
//		videoDTO.setId(5L);
//		videoDTO.setName("Video1");
//		videoDTO.setVideoSource("mp4/aspen.mp4");
//
//		MosDTO mosDTO = new MosDTO();
//		ScenarioDTO scenarioDTO1 = new ScenarioDTO();
//		ScenarioDTO scenarioDTO2 = new ScenarioDTO();
//		scenarioDTO2.setScenario("layz loading");
//
//		//videoDTO.setMos(mosDTO);
//		videoDTO.addScenario(scenarioDTO1);
//		videoDTO.addScenario(scenarioDTO2);
//
//		Video video = beanMapping.mapTo(videoDTO, Video.class);
//		assertEquals(video.getName(), videoDTO.getName());
//		assertEquals(video.getId(), videoDTO.getId());
//		assertEquals(video.getVideoSource(), videoDTO.getVideoSource());
//		assertEquals(video.getScenarions().size(), videoDTO.getScenario()
//				.size());
	}

}
