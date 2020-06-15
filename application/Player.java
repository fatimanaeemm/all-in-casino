package application;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;

public class Player extends Login{
	
	public void updateCash(int newCash)
	{
		totalCash+=newCash;
	}
	public void betWon(int bet){
        totalCash += bet;
    }
    
    public void betLost(int bet){
        totalCash -= bet;
    }
    
    public void playSound (String fileName, boolean stop) throws UnsupportedAudioFileException, 
    IOException, LineUnavailableException, InterruptedException {
		URL url = this.getClass().getResource("/sounds/" + fileName + ".wav");
        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
        Clip clip = (Clip) AudioSystem.getLine(info);
        clip.open(ais);
        clip.start();
        if (stop) {
            Thread.sleep(2300);
            clip.close();
        }
	}
    
    
}



