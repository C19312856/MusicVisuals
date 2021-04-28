package c19312856;

import ie.tudublin.*;

public class JohnsVisual extends Visual
{    
    WaveForm wf;
    AudioBandsVisual abv;
    Lines l;
    Circle c;

    float[] lerpedBuffer;

    public void settings()
    {
        size(1024, 500);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    int which = 0;

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("Witt Lowry - Put Me First (feat. Josh Golden) (Official Lyric Video).mp3");   

        
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
        c = new Circle(this);

    }

    public void keyPressed()
    {
        if (keyCode >= '0' && keyCode <= '6') {
            which = keyCode - '0';
        }
        if (keyCode == ' ') {
            if (getAudioPlayer().isPlaying()) {
                getAudioPlayer().pause();
            } else {
                getAudioPlayer().play();
            }
        }
        if (key == 'r' || key == 'R')
        {
            getAudioPlayer().rewind();
        }
    }


    public void draw()
    {
        background(0);

        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();        
        //wf.render();
        //abv.render();
        //l.render();

        switch (which)
        {
            case 0:
            {
                wf.render();
                controls();
                break;
            }
            case 1:
            {
                abv.render();
                controls();
                break;
            }
            case 2:
            {
                c.render();
                controls();
                break;
            }
            default:
            {
                controls();
            }
        }

        
                
    }

    public void controls()
    {
        text("Controls: \n\tSPACEBAR:\tStart/Pause Music\n\tR:\tRestart Music/Set background to display frequency and note of music", 10, 20);
    }
}

