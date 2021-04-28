package c19312856;

import processing.core.*;

public class Circle {
    JohnsVisual jv;
    float cy = 0;
    float cx = 0;

    public Circle(JohnsVisual jv)
    {
        this.jv = jv;
        cy = this.jv.height;
        cx = this.jv.height / 2;
    }

    public void render()
    {
        jv.colorMode(PApplet.HSB);
        for(int i = 0 ; i < jv.getAudioBuffer().size() ; i ++)
        {
            jv.ellipse(cy, cx, 500 * jv.getAudioBuffer().get(i), 500 * jv.getAudioBuffer().get(i));
        }
    }
}
