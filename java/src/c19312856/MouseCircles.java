package c19312856;

import processing.core.*;

public class MouseCircles extends PApplet{
    JohnsVisual jv;
    float cy = 0;
    float cx = 0;

    public MouseCircles(JohnsVisual jv)
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
        int numCircles = (int) mouseX / 10;
        float cgap = 255 / (float) numCircles;
        float gap = width / (float) numCircles;
        float w = width;
        for(int i = numCircles ; i >= 1 ; i --)
        {
            fill(i * cgap, 255, 255);
            w = i * gap;
            ellipse(cx, cy, w, w);
                    
        } 
        
        /*
        //variables
        int numofEll;
        float x1,y1,x2,y2,r,g,b;
        //values
        x1= 1000;
        y1 = 500;
        x2 = 0;
        y2 = y1/2;
        r =150;
        g=204;
        b=255;
        numofEll= 32;
        //centre
        jv.translate(jv.width / 2, jv.height / 2);
        jv.strokeWeight(2);
        for (int i = 0; i < 4; i++) 
        {
            jv.fill(r, g, b);
            y1 = JohnsVisual.map(jv.getSmoothedBands()[i], 0, 500, jv.height/118, jv.height / 4);
            for (int j = 0; j < numofEll; j++) 
            {
                jv.ellipse(x2, y2, x1, y1);
                jv.rotate(JohnsVisual.TWO_PI / numofEll);
            }
            r=(r/100);
            g=(g/2);
            b=(b/200);
        }*/

        /*
        int numofEll ;
        float x1,y1,x2,y2;
        x1 = 10;
        y1 = 100;
        x2 = 0;
        y2 = 0;
        numofEll=4;
        jv.translate(jv.width / 2, jv.height / 2);
        jv.noStroke();
        for (int i = 0; i < 9; i++) {
            jv.fill(0, 0, 255);
            y1 = JohnsVisual.map(jv.getSmoothedBands()[i], 0, 1000, jv.height / 6, jv.height / 1);
            for (int j = 0; j < numofEll; j++) {
                jv.ellipse(x2, y2 + y1 / 2, x1, y1);
                jv.rotate(JohnsVisual.TWO_PI / numofEll);
            }   
        }*/

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
