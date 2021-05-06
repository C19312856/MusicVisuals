package c19312856;

import processing.core.*;

public class Pyramid {
    JohnsVisual jv;
    float ca;
    float cy;
    float cx;
    float[] lerpedBuffer;

    public Pyramid(JohnsVisual jv)
    {
        this.jv = jv; 
        cy = this.jv.height;
        cx = this.jv.height / 2;
        ca = this.jv.width;
        lerpedBuffer = new float[jv.width];
    }

    float angle = 0;
  
    float length = 0;

    public void render()
    {
        //Set weights and colours
        jv.colorMode(PApplet.HSB);
        jv.lights();
        jv.noFill();
        jv.strokeWeight(4);
        float c = 30 + PApplet.map(jv.getSmoothedAmplitude(), 0, 1, 0, 255);
        jv.stroke(c, 255, 255);

        length = 30 + (500 * jv.getSmoothedAmplitude());

        //Generate waveforms on top and bottom of screen
        for(int i = 0 ; i < jv.getAudioBuffer().size() ; i ++)
        {
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], jv.getAudioBuffer().get(i), 0.1f);
            jv.line(i, 0 - lerpedBuffer[i] * ca, i, 0 + lerpedBuffer[i] * ca );
            jv.line(ca - i, 0 - lerpedBuffer[i] * ca, ca - i, 0 + lerpedBuffer[i] * ca );
            jv.line(i, cy - lerpedBuffer[i] * ca, i, cy + lerpedBuffer[i] * ca);
            jv.line(ca - i, cy - lerpedBuffer[i] * ca, ca - i, cy + lerpedBuffer[i] * ca);
        } 
        

        //Place pyramid in the center of the screen
        jv.translate(cy, cx);


        //Rotation for the pyramid
        jv.rotateX(angle);
        jv.rotateZ(angle);

        //Code to make Pyramid
        jv.beginShape();

        //Side 1
        jv.vertex(-length, -length, -length);
        jv.vertex(length, -length, -length);
        jv.vertex(   0,    0,  length);

        //Side 2
        jv.vertex( length, -length, -length);
        jv.vertex( length,  length, -length);
        jv.vertex(   0,    0,  length);
   
        //Side 3
        jv.vertex( length, length, -length);
        jv.vertex(-length, length, -length);
        jv.vertex(   0,   0,  length);
     
        //Side 4
        jv.vertex(-length,  length, -length);
        jv.vertex(-length, -length, -length);
        jv.vertex(   0,    0,  length);

        //Side 5
        jv.vertex(-length,  length, -length);
        jv.vertex(-length, -length, -length);
        jv.vertex(   0,    0,  length);
        jv.endShape();

        angle += 0.01f;
    }
}
