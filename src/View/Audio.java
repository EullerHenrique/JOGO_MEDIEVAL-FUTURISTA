package View;

import javax.sound.sampled.*;
import java.io.File;
import java.util.ArrayList;

public class Audio {

    public static ArrayList<Clip> c = new ArrayList<>();

    public static synchronized void playSound(final String url){

        try {
            File file = new File(url);
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
            clip.open(inputStream);
            clip.addLineListener(new CloseClipWhenDone());
            clip.start();
            c.add(clip);
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static class CloseClipWhenDone implements LineListener {
        public void update(LineEvent event) {
            if (event.getType().equals(LineEvent.Type.STOP)) {
                Line soundClip = event.getLine();
                soundClip.close();

                //Just to prove that it is called...
                //System.out.println("Done playing " + soundClip.toString());
            }
        }
    }

}
