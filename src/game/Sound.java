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
	 
	//button click sound
	private MediaPlayer buttonsound;
	//background sound
	private MediaPlayer backgroundsound;
	//ball get out of game sound
	private MediaPlayer[] explosion;
	private int th;//just a variable make the explosion sound smooth
	//turn on or off sound
	private boolean soundon;
	//ThreadPlayer buttonclick;
	//ThreadPlayer explosion;
	
	public Sound(){
		soundon=true;
		Media media = new Media(new File("clickButton.mp3").toURI().toString());
		buttonsound = new MediaPlayer(media);
		
		media = new Media(new File("src\\gamesound\\readygo.mp3").toURI().toString());
		backgroundsound = new MediaPlayer(media);
		this.backgroundsound.setCycleCount(this.backgroundsound.INDEFINITE);
		
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
	public void BGsound(){
		if(this.soundon){
			ThreadPlayer thread = new ThreadPlayer(backgroundsound);
			thread.start();
		}
	}
	
	public void stopBGsound(){
		if(this.backgroundsound.getStatus().equals(MediaPlayer.Status.PLAYING)){
				this.backgroundsound.stop();
		}
	}
	
	public void Explosion(){
		
		if(this.soundon){
			ThreadPlayer thread = new ThreadPlayer(explosion[th]);
			thread.start();
			if(th==3)
				th=0;
			else th++;
		}
			
		//this.explosion.getMediaPlayer().stop();
		//this.explosion.getMediaPlayer().play();
	}
	
	public void ButtonClick(){
		if(this.soundon){
			ThreadPlayer thread = new ThreadPlayer(buttonsound);
			thread.start();
		}
		
	}	
	public void Off(){
		this.soundon=false;
		this.backgroundsound.stop();
		this.buttonsound.stop();
		this.explosion[0].stop();
		this.explosion[1].stop();
		this.explosion[2].stop();
		this.explosion[3].stop();
	}
	public void On(){
		this.soundon=true;
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
