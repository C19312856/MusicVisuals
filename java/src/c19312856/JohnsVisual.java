package c19312856;

import ie.tudublin.*;

public class JohnsVisual extends Visual
{    
    //Declare Classes
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

    //Variable for toggleable Pyramid Visual in option 8
    boolean pyramidVisual = false;


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
        //Alternate song
        //loadAudio("EDEN - rock and roll.mp3");   
        
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        //Instantiate Classes
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
        //Pause/Play Music
        if (keyCode == ' ') {
            if (getAudioPlayer().isPlaying()) {
                getAudioPlayer().pause();
            } else {
                getAudioPlayer().play();
            }
        }
        //Restart Music
        if (key == 'r' || key == 'R')
        {
            getAudioPlayer().rewind();
        }
        //Toggle for Pyramid Visual in Option 8
        if (key == 'p' || key == 'P')
        {
            if(pyramidVisual == true)
            {
                pyramidVisual = false;
            }
            else
            {
                pyramidVisual = true;
            }
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
                //Simple Audio Band Visual with controls
                abv.render();
                controls();
                break;
            }
            case 1:
            {
                //Simple waveform Visual
                wf.render();
                break;
            }
            case 2:
            {
                //Simple circle visual with Put Me First title
                c.render();
                putMeFirst();
                break;
            }
            case 3:
            {
                //Floral Visual
                f.render();
                break;
            }
            case 4:
            {
                //Eye Visual, change fill to black
                fill(0);
                eye.render();
                break;
            }
            case 5:
            {
                //Boxes visual
                b.render();
                break;
            }
            case 6:
            {
                //Sphere Visual
                s.render();
                break;
            }
            case 7:
            {
                //Pyramid Visual
                p.render();
                break;
            }
            case 8:
            {
                //Mix of Visuals with toggleable Pyramid Visual
                wf.render();
                c.render();
                eye.render();
                b.render();
                //Toggleable Pyramid Visual
                if (pyramidVisual == true)
                {
                    p.render();
                }
                break;
            }
            default:
            {
                //Show Controls
                controls();
            }
        }

        
                
    }
    //Method to display controls on first page (0)
    public void controls()
    {
        textSize(20);
        fill(255);
        text("Controls: \n\tSPACEBAR:\tStart/Pause Music\n\tR:\tRestart Music\n\t0:\tBasic Audio Band Visual/Show Controls\n\t1:\tBasic Waveform Visual\n\t2:\tBasic Ellipse and Title Visual\n\t3:\tFloral Visual\n\t4:\tEye Visual\n\t5:\tDual Box Visual\n\t6:\tSphere Visual\n\t7:\tPyramid Visual\n\t8:\tMix Visual with toggleable Pyramid Visual\n\t\t\t\tp/P:\tToggle Pyramid Visual On/Off", 10, 20);
    }

    //Method to display "Put Me First" Title in option 2
    public void putMeFirst()
    {
        halfWidth = (width / 2) - (1750 * getSmoothedAmplitude());
        for(int i = 0 ; i < getAudioBuffer().size() ; i ++)
        {
            //Set Colour as white and change text size in accordance to music Amplitude
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

