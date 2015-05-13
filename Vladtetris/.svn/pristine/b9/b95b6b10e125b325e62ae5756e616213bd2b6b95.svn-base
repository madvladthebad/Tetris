package view;

/*
 * Audio Clip Player
 * TCSS 305 - Autumn 2010 (Zimmerman)
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.pscode.xui.sound.bigclip.BigClip;

/**
 * A class to play audio clips. Caches previously-played clips,
 * allowing fast re-playback of previously played sounds.
 * 
 * @author Marty Stepp 
 * @author Daniel M. Zimmerman (code cleanup)
 * @author Anthony Sierra (BigClip modification)
 * @version 1.51
 */

public class SoundPlayer {
  /**
   * A cache of previously-played audio clips.
   */
    
  private final Map<String, Clip> my_clips = new HashMap<String, Clip>();

  /**
   * Plays the audio file with the given file name. This method 
   * returns instantly, without waiting for the clip to finish 
   * playing.
   * 
   * @param the_filename The name of the file (relative to the 
   * classpath) to play.
   * @return a Clip object representing the sound played. 
   * (for convenience; this result need not be used/stored).
   * @exception IllegalArgumentException if there is a problem reading
   * from the sound file.
   */
  
  public Clip play(final String the_filename) 
    throws IllegalArgumentException {
    return loop(the_filename, 1);
  }
    
  /** 
   * Plays the clip with the given file name in a continuous loop.
   * The clip keeps looping until it is later stopped by calling the 
   * stop() method. This function returns instantly
   *    
   * @param the_filename The name of the file (relative to the classpath) 
   * to play.
   * @return a Clip object representing the sound played. 
   * (for convenience; this result need not be used/stored).
   * @exception IllegalArgumentException if there is a problem reading
   * from the sound file.
   */
  
  public Clip loop(final String the_filename) 
    throws IllegalArgumentException {
    return loop(the_filename, Clip.LOOP_CONTINUOUSLY);
  }
    
    
  /** 
   * Plays the clip with the given file name in a loop.
   * The clip loops until it has played the specified number of 
   * times, or until it is later stopped by calling the stop() 
   * method. This function returns instantly, without waiting for
   * the clip to finish looping.
   *
   * @param the_filename The name of the file (relative to the 
   *  classpath) to play.
   * @param the_number_of_times The number of times to loop the clip.
   * @return a Clip object representing the sound played. 
   * (for convenience; this result need not be used/stored).
   * @exception IllegalArgumentException if there is a problem reading
   * from the sound file.
   */
   
  public Clip loop(final String the_filename, final int the_number_of_times) 
    throws IllegalArgumentException {
    final Clip clip = getClip(the_filename);
    
    if (clip != null) {
      clip.loop(the_number_of_times);
    }
    
    return clip;
  }
    
  /**
   * Pauses the clip with the given file name. If the clip is
   * later played, it will resume from where it was paused.
   * Calling this method does not resume a thread that is 
   * suspended on a playAndWait() or a loopAndWait().
   * 
   * If stop() is called on a paused clip, it will reset to the
   * beginning of the clip for the next play.
   * 
   * @param the_filename The name of the file (relative to the classpath)
   * to pause.
   * @exception IllegalArgumentException if there is a problem reading from 
   * or playing the sound file.
   */
  
  public void pause(final String the_filename) 
    throws IllegalArgumentException {
    final Clip clip = getClip(the_filename);
    
    if (clip != null) {
      final int pos = clip.getFramePosition();
      clip.stop();
      clip.setFramePosition(pos);
    }
  }
    
  /** 
   * Stops the clip with the specified filename (and wakes up 
   * any threads waiting for it to finish playing).
   * 
   * @param the_filename The name of the file (relative to the classpath)
   *  to stop.
   * @return a Clip object representing the sound stopped.
   * @exception IllegalArgumentException if there is a problem reading
   * from the sound file.
   */
  
  public Clip stop(final String the_filename) 
    throws IllegalArgumentException {
    final Clip clip = getClip(the_filename);
    stopClip(clip);
    
    return clip;
  }
    
  /** 
   * Stops all currently playing sound clips (and wakes up
   * the threads waiting for them to finish playing).
   */
 
  public void stopAll() {
    for (Clip clip : my_clips.values()) 
    {
      stopClip(clip);
    }
  }   

  /** 
   * Preloads the clip at the given file name. This means the
   * clip will be available faster, when requested for playing
   * the first time.
   * @param the_filename The name of the file (relative to the classpath)
   * to preload.
   * @return a Clip object representing the preloaded sound.
   * @exception IllegalArgumentException if there is a problem reading
   * from the sound file.
   */
   
  public Clip preLoad(final String the_filename) 
    throws IllegalArgumentException
  {
    return getClip(the_filename);
  }
    

  /**
   * Returns a Clip object for a filename, either by creating
   * a new one or loading it from the cache.
   * 
   * @param the_filename The name of the file (relative to the classpath)
   * to load.
   * @return a Clip object, or null if one is not found.
   * @exception IllegalArgumentException if there is a problem reading
   * from the sound file.
   */
  
  private Clip getClip(final String the_filename) 
    throws IllegalArgumentException
  {
    BigClip clip = null;
    AudioInputStream ais = null;
        
    if (my_clips.containsKey(the_filename)) 
    {
      clip = (BigClip) my_clips.get(the_filename);
    } 
    else 
    {
      // read audio file from disk
      try {
        ais = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource(the_filename));
        clip = new BigClip();
        clip.open(ais);
        clip.addLineListener(new LineListener() 
          {
            /** 
             * Responds to audio events generated by clips. 
             * 
             * @param the_event The event generated.
             */
             
            public void update(final LineEvent the_event) 
            {
              if (the_event.getType() == LineEvent.Type.STOP) 
              {
                // clip is done playing
                stopClip((Clip) the_event.getSource());
              }
            }
          });
        my_clips.put(the_filename, clip);
      } 
      catch (final UnsupportedAudioFileException uafe) 
      {
        throw new IllegalArgumentException
        ("Not a valid supported audio file: \"" + the_filename + "\"");
      } 
      catch (final LineUnavailableException lue) 
      {
        lue.printStackTrace();
        throw new IllegalArgumentException
        ("Line is not available to play sound \"" + the_filename + " \"");
      } 
      catch (final IOException ioe) 
      {
        throw new IllegalArgumentException
        ("I/O error while reading file: \"" + the_filename + "\" ");
      }
    }
        
    return clip;
  }
    
  /**
   * Stops the playing of the specified clip.
   * 
   * @param the_clip The clip.
   */
  
  private void stopClip(final Clip the_clip) 
  {
    if (the_clip != null) 
    {
      synchronized (the_clip) 
      {
        the_clip.stop();
        the_clip.setFramePosition(0);
        the_clip.notifyAll();  // awaken threads waiting for this Clip
      }
    }
  }
}

// end of class SoundPlayer
