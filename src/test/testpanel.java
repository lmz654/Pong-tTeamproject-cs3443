package test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

/*import java.applet.Applet;
import java.applet.AudioClip;*/
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
//import javafx.stage.Stage;
//import javafx.application.Application;

import MVC.action.InstructionsMenu;
import MVC.action.PauseMenu;
import MVC.action.SetupMenu;
import MVC.action.TitleMenu;
import MVC.side.PlayerPanel;
import game.math.structures.Vector;

/*import javax.media.*;
import java.net.*;
import java.io.*;
import java.util.*;*/


public class testpanel {

	public static void main(String[] args) {
		for(int i=0;i<50;i++){
			System.out.println(Vector.getRand(5,10));
		}
		/*File f = new File("clickButton.mp3");
		URL url;*/
		/*try {
			url = new URL ("file:thuthoi.wav");
			
			AudioClip clip = Applet.newAudioClip(url);
			clip.play();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//try {
			//url = new URL("file:clickButton.mp3");
		/*JFrame frame = new JFrame("trying");
		frame.setSize(400,400);
			JFXPanel fxp= new javafx.embed.swing.JFXPanel();
			
		//frame.add(fxp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
			Media hit = new Media(f.toURI().toString());
			MediaPlayer p = new MediaPlayer(hit);
			p.play();
			p.stop();
			p.play();
			p.stop();
			p.play();
*/
			
			//p.stop();
			//final Player p=Manager.createRealizedPlayer(f.toURI().toURL());
			
			/*} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		/*JFrame frame = new JFrame("trying");
		frame.setSize(400,400);
		//frame.add(new PauseMenu()); // menu when user hits the pause button
		//frame.add(new TitleMenu()); // menu when the user first starts the game
		frame.add(new SetupMenu()); // sub menu of main menu that lets user customize settings
		//frame.add(new InstructionsMenu()); // sub menu of main menu that explains the rules of the game to the player
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);*/
	}

	

}
