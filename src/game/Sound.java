package game;

/*import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;*/
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.*;

import java.io.File;
import java.net.URL;



public class Sound extends JFXPanel {
	 
	MediaPlayer buttonsound;
	
	public Sound(){
		
		Media media = new Media(new File("clickButton.mp3").toURI().toString());
		buttonsound = new MediaPlayer(media);
	}
	public void buttonclick(){
		this.buttonsound.stop();
		this.buttonsound.play();
	}
	
}
