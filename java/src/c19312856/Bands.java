package c19312856;

import processing.core.*;

public class Bands {
    JohnsVisual jv;

    public Bands(JohnsVisual jv) 
    {
        this.jv = jv;
    }
    public void band1()
    {
        float gap = jv.width / (float) jv.getBands().length;
        jv.strokeWeight(5);
        for(int i = 0 ; i < jv.getBands().length ; i ++)
        {
            jv.fill(PApplet.map(i, 0,160, 255, 255), 0, 130);
            jv.rect(i * gap, jv.height, 50,-jv.getSmoothedBands()[i]+4); 
        }
    }
    public void band2()
    { 
        jv.colorMode(PApplet.HSB);
        float cy = 0;
        cy = jv.height;
        for(int i = 0 ; i < jv.getAudioBuffer().size() ; i ++)
        {
            jv.stroke(
                PApplet.map(i, 0, jv.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );

            jv.line(i,cy, i, cy+ cy * jv.getAudioBuffer().get(i));
        }
    }
}



