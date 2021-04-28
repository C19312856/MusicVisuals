package c19312856;

import ie.tudublin.*;
import processing.core.*;

// This is an example of a visual that renders the waveform
public class WaveForm
{
    JohnsVisual mv;
    float cy = 0;
    float cx = 0;
    

    public WaveForm(JohnsVisual mv)
    {
        this.mv = mv;
        cy = this.mv.height;
        cx = this.mv.height / 2;
    }

    public void render()
    {
        mv.colorMode(PApplet.HSB);
        for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
        {
            mv.stroke(
                PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );
            mv.ellipse(cy, cx, 500 * mv.getAudioBuffer().get(i), 500 * mv.getAudioBuffer().get(i));

            mv.line(i, cx, i, cx + cx * mv.getAudioBuffer().get(i));
        }
    }
}
