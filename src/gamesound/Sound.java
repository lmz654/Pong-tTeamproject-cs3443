package gamesound;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	public static final AudioClip BACKGROUND = Applet.newAudioClip(Sound.class.getResource(""));
	public static final AudioClip CLICK = Applet.newAudioClip(Sound.class.getResource("clickButton.mp3"));
	public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource(""));
	
}
