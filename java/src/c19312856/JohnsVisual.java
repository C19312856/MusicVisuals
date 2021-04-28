package c19312856;

import ie.tudublin.*;

public class JohnsVisual extends Visual
{    
    WaveForm wf;
    AudioBandsVisual abv;
    Circle c;
    MouseCircles mc;
    Eye eye;
    Boxes b;
    Sphere s;
    Bands band;
    Floral f;
    Pyramid p;

    float halfWidth = 0;

    public void settings()
    {
        size(1024, 500, P3D);
        
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
        mc = new MouseCircles(this);
        eye = new Eye(this);
        b = new Boxes(this);
        s = new Sphere(this);
        band = new Bands(this);
        f = new Floral(this);
        p = new Pyramid(this);

        surface.setResizable(true);
    }

    public void keyPressed()
    {
        if (keyCode >= '0' && keyCode <= '9') {
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

    private float angle = 0;

    public void draw()
    {
        background(0);
        surface.setResizable(true);
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
                abv.render();
                controls();
                break;
            }
            case 1:
            {
                wf.render();
                break;
            }
            case 2:
            {
                c.render();
                putMeFirst();
                break;
            }
            case 3:
            {
                f.render();
                break;
            }
            case 4:
            {
                fill(0);
                eye.render();
                break;
            }
            case 5:
            {
                b.render();
                break;
            }
            case 6:
            {
                s.render();
                break;
            }
            case 7:
            {
                if (key == 's' || key == 'S')
                {
                    s.render();
                }
                wf.render();
                c.render();
                eye.render();
                b.render();
                break;
            }
            case 8:
            {
                p.render();
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
        textSize(20);
        fill(255);
        text("Controls: \n\tSPACEBAR:\tStart/Pause Music\n\tR:\tRestart Music", 10, 20);
    }

    public void putMeFirst()
    {
        halfWidth = (width / 2) - (1750 * getSmoothedAmplitude());
        for(int i = 0 ; i < getAudioBuffer().size() ; i ++)
        {
            fill(255);
                if (getSmoothedAmplitude() < 10)
                {
                    textSize(500 * getSmoothedAmplitude());
                }
                else
                {
                    textSize(10);
                }
                text("PUT ME FIRST", halfWidth, 80);
        }
    }
}

