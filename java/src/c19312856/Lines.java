package c19312856;

import processing.core.*;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Lines extends JohnsVisual
{

    private float[] frequencies = {293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, 587.33f
        , 659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f, 1318.51f, 1479.98f, 1567.98f, 1760.00f, 1975.53f, 2217.46f, 2349.32f};
    String[] spellings = {"D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B","c", "d", "e", "f", "g", "a", "b", "c'", "d'", "e'", "f'", "g'", "a'", "b'", "c''", "d''"};

    public void draw() {
        background(0);
        stroke(255);

        float halfHeight = height / 2;
        for(int i = 0 ; i < getAudioBuffer().size() ; i ++)
        {
            stroke(map(i, 0, getAudioBuffer().size(), 0, 255), 255, 255);
            //line(i, halfHeight - (ab.get(i) * halfHeight), i, halfHeight + (ab.get(i) * halfHeight));
        }

        getFFT().window(FFT.HAMMING);
        getFFT().forward(getAudioBuffer());

        int highestBand = 0;
        for(int i = 0 ; i < getFFT().specSize() ; i ++)
        {
            stroke(map(i, 0, getFFT().specSize(), 0, 255), 255, 255);
            line(i, height, i, height - (getFFT().getBand(i) * halfHeight));
            if (getFFT().getBand(i) > getFFT().getBand(highestBand))
            {
                highestBand = i;
            }
        }

        float freq = getFFT().indexToFreq(highestBand);
        textSize(24);
        fill(255);
        text("Frequency: " + freq, 10, 50);
        text("Note: " + spell(freq), 10, 100);

        calculateFrequencyBands();

        
        float w = width / (float) getBands().length;
        for(int i = 0 ; i < getBands().length ; i ++)
        {
            float x = map(i, 0, getBands().length, 0, width);
            float c = map(i, 0, getBands().length, 0, 255);
            noStroke();
            fill(c, 255, 255);
            rect(x, height, w, -getSmoothedBands()[i]);
        }    
    }

    String spell(float freq)
    {
        // Return the element from the spellings array that freq is closest 
        // to in the frequency array

        int closestIndex = 0;
        float smalestGap = Float.MAX_VALUE;
        for(int i = 0 ; i < frequencies.length ; i ++)
        {
            float gap = abs(freq - frequencies[i]);
            if (gap < smalestGap)
            {
                smalestGap = gap;
                closestIndex = i;
            }            
        }
        return spellings[closestIndex];
    }
}
