package c19312856;

import ie.tudublin.*;
import processing.core.*;

// This is an example of a visual that renders the waveform
public class WaveForm
{
    JohnsVisual jv;
    float cy = 0;
    float cx = 0;
    float ca = 0;
    

    public WaveForm(JohnsVisual jv)
    {
        this.jv = jv;
        cy = this.jv.height;
        cx = this.jv.height / 2;
        ca = this.jv.width;
    }

    public void render()
    {
        jv.colorMode(PApplet.HSB);
        for(int i = 0 ; i < jv.getAudioBuffer().size() ; i ++)
        {
            jv.stroke(
                PApplet.map(i, 0, jv.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );
            //jv.ellipse(cy, cx, 500 * jv.getAudioBuffer().get(i), 500 * jv.getAudioBuffer().get(i));

            jv.line(i, cx, i, cx + cx * jv.getAudioBuffer().get(i));
            jv.line(ca - i, cx, ca - i, (cx + cx * jv.getAudioBuffer().get(i)));
        }
    }
}
