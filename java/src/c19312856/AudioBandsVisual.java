package c19312856;

import processing.core.*;

// This is an example of a visual that uses the audio bands
public class AudioBandsVisual
{
    JohnsVisual jv;

    public AudioBandsVisual(JohnsVisual jv)
    {
        this.jv = jv; 
    }

    public void render()
    {
        //Change colours and create audio bands
        jv.colorMode(PApplet.HSB);
        float gap = jv.width / (float) jv.getBands().length;
        jv.noStroke();
        for(int i = 0 ; i < jv.getBands().length ; i ++)
        {
            jv.fill(PApplet.map(i, 0, jv.getBands().length, 255, 0), 255, 255);
            jv.rect(i * gap, jv.height, gap,-jv.getSmoothedBands()[i] * 0.2f); 
        }
    }
}
