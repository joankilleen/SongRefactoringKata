package com.killeen.song;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class SongTest {
	private static String FILEPATH_SONG1 = "song/song1.txt";
	private static String correctSong = getSongCorrectVersion();

	private static String getSongCorrectVersion(){
		String song1 = null;
		InputStream inputStream = SongTest.class.getClassLoader().getResourceAsStream(FILEPATH_SONG1);
		assertNotNull(inputStream);
		try {
			song1 = IOUtils.toString(inputStream, StandardCharsets.UTF_8).replaceAll("\\s", "");
		} catch (IOException e){
			System.out.println("Song file could not be loaded");
		}
		return song1;
	}

	@Test
	public void testSong(){
		String song = new Song().getSong().replaceAll("\\s","");
		assertEquals(correctSong, song);
	}
    @Test
	public void testDynamicSong(){
		String song = new DynamicSong().construct().replaceAll("\\s","");
		assertEquals(correctSong, song);
	}



}

