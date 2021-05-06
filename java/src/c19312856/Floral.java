package c19312856;

import processing.core.*;

public class Floral {
    JohnsVisual jv;

    public Floral(JohnsVisual jv)
    {
        this.jv = jv; 
    }

    public void render()
    {
        //variables
        int numofEll;
        float x1,y1,x2,y2;
        //values
        x1 = 1000;
        y1 = 500;
        x2 = 0;
        y2 = 0 ;
        numofEll= 8;
        //centre
        jv.translate(jv.width / 2, jv.height / 2);
        jv.strokeWeight(2);
        float c = 30 + PApplet.map(jv.getSmoothedAmplitude(), 0, 1, 0, 255);
        //Create Ellipses
        for (int i = 0; i < 4; i++) 
        {
            jv.fill(c, c + 50, c + 30);
            x1 = jv.getSmoothedBands()[4 - i - 1] * 0.6f;
            for (int j = 0; j < numofEll; j++) 
            {
                jv.ellipse(x2, y2, x1, y1);
                jv.rotate(JohnsVisual.TWO_PI / numofEll);
            }
            c = c + 20;
        }
    }
}
