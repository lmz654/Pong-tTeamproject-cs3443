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
	 
	private MediaPlayer buttonsound;
	private MediaPlayer backgroundsound;
	private MediaPlayer[] explosion;
	private int th;
	//ThreadPlayer buttonclick;
	//ThreadPlayer explosion;
	
	public Sound(){
		
		Media media = new Media(new File("clickButton.mp3").toURI().toString());
		buttonsound = new MediaPlayer(media);
		
		/*media = new Media(new File("backgroundsound.mp3").toURI().toString());
		backgroundsound = new MediaPlayer(media);
		this.backgroundsound.setCycleCount(this.backgroundsound.INDEFINITE);*/
		th=0;
		explosion = new MediaPlayer[4];
		media = new Media(new File("explosion.mp3").toURI().toString());
		explosion[0] = new MediaPlayer(media);
		media = new Media(new File("explosion.mp3").toURI().toString());
		explosion[1] = new MediaPlayer(media);
		media = new Media(new File("explosion.mp3").toURI().toString());
		explosion[2] = new MediaPlayer(media);
		media = new Media(new File("explosion.mp3").toURI().toString());
		explosion[3] = new MediaPlayer(media);
		
		
		
	}
	
	public void Explosion(){
		
		ThreadPlayer thread = new ThreadPlayer(explosion[th]);
		thread.start();
		if(th==3)
			th=0;
		else th++;
			
		//this.explosion.getMediaPlayer().stop();
		//this.explosion.getMediaPlayer().play();
	}
	
	public void ButtonClick(){
		
		ThreadPlayer thread = new ThreadPlayer(buttonsound);
		thread.start();
		
	}	
	public void Off(){
		
	}
	public void On(){
		
	}
	
public class ThreadPlayer extends Thread{
		
		private MediaPlayer mediaplayer;
		
		public ThreadPlayer(MediaPlayer mediaplayer){
			this.mediaplayer=mediaplayer;
		}
		public void run(){
			this.mediaplayer.stop();
			this.mediaplayer.play();
		}
		
	}
}
