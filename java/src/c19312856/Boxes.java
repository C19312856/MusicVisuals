package c19312856;

import processing.core.*;

public class Boxes{

    JohnsVisual jv;

    float angle = 0;

    public Boxes(JohnsVisual jv)
    {
        this.jv = jv;
    }

    public void render()
    {
        //Set colours and weights
        jv.lights();
        jv.strokeWeight(2);
        float c = PApplet.map(jv.getSmoothedAmplitude(), 0, 1, 0, 255);
        jv.stroke(c, 255, 255);
        jv.noFill();
        //fill(100, 255, 255);
        angle += 0.01f;
        float s = 100 + (100 * jv.getSmoothedAmplitude() * 10);
            
        //Create Cube 1
            jv.pushMatrix();
            jv.translate(jv.width / 4, jv.height / 2, 0);
            jv.rotateY(angle);
            jv.rotateX(angle);
            jv.box(s);
            jv.popMatrix();

        //Create Cube 2
            jv.pushMatrix();
            jv.translate(jv.width * 0.75f, jv.height / 2, 0);
            jv.rotateY(angle);
            jv.rotateX(angle);
            jv.box(s);
            jv.popMatrix();
    }
}
