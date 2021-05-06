package c19312856;

import processing.core.*;

public class Circle {
    JohnsVisual jv;
    float cy = 0;
    float cx = 0;
    float ca = 0;

    public Circle(JohnsVisual jv)
    {
        this.jv = jv;
        cy = this.jv.height;
        cx = this.jv.height / 2;
        ca = this.jv.width;
    }

    public void render()
    {
        //Change colours for shapes
        jv.colorMode(PApplet.HSB);
        for(int i = 0 ; i < jv.getAudioBuffer().size() ; i ++)
        {
            jv.stroke(
                PApplet.map(i, 0, jv.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );
            //Create Ellipse
            jv.ellipse(cy, cx, 500 * jv.getAudioBuffer().get(i), 500 * jv.getAudioBuffer().get(i));
        }
    }
}
