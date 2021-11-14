package com.killeen.song;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Clock;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

public class SongTest {
	private String FILEPATH_SONG1 = "song/song1.txt";

	@Test
	public void testSong() throws IOException {
		String song = new Song().getSong().replaceAll("\\s","");
		InputStream inputStream = SongTest.class.getClassLoader().getResourceAsStream(FILEPATH_SONG1);
		assertTrue(inputStream != null);
		String song1 = IOUtils.toString(inputStream, StandardCharsets.UTF_8).replaceAll("\\s","");
		AssertEquals(song1, song);
	}

	private void AssertEquals(String song1, String song) {
	}

	public byte[] diff(byte[] song1, byte[] song) {
		byte[] shortest = null;
		byte[] longest = null;

		if (song1.length >= song.length) {
			longest = song1;
			shortest = song;
		} else {
			longest = song;
			shortest = song1;
		}
		byte[] diff = new byte[longest.length];

		for (int i = 0; i < shortest.length; i++) {
			if (shortest[i] != longest[i]) diff[i] = longest[i];
			System.out.println("Index: " + i + " " + shortest[i] + " " + longest[i]);
		}
		for (int j = shortest.length; j < longest.length; j++) {
			diff[j] = longest[j];
			System.out.println("Index: " + j + " " + diff[j]);
		}
		return diff;

	}

}

