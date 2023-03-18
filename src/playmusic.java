package src;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

class playmusic {
    Clip clip;
    public void Playmusic(String location){
        try{
            File music=new File(location);
            if(music.exists()){
                AudioInputStream audioinput=AudioSystem.getAudioInputStream(music);
                clip = AudioSystem.getClip();
                clip.open(audioinput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }else{
                System.out.println("can't play");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}