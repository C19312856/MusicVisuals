package c19312856;

import processing.core.*;

public class Sphere {
    JohnsVisual jv;

    float angle = 0;

    public Sphere(JohnsVisual jv)
    {
        this.jv = jv;
    }

    public void render()
    {
        jv.lights();
        jv.strokeWeight(2);
        float c = PApplet.map(jv.getSmoothedAmplitude(), 0, 1, 0, 255);
        jv.stroke(c, 255, 255);
        //jv.noFill();
        jv.fill(c + 100, 255, 255);
        angle += 0.01f;
        float s = 100 + (100 * jv.getSmoothedAmplitude() * 10);
        float small = 60 + (30 * jv.getSmoothedAmplitude() * 10);
                
            jv.pushMatrix();
            jv.translate(jv.width / 2, jv.height / 2, 0);
            jv.rotateY(angle);
            jv.rotateX(angle);
            jv.sphere(s);
            jv.popMatrix();

            //Top Left
            jv.pushMatrix();
            jv.translate(145, 115, 0);
            jv.rotateY(angle);
            jv.rotateX(angle);
            jv.sphere(small);
            jv.popMatrix();

            //Bottom Left
            jv.pushMatrix();
            jv.translate(145, jv.height - 115, 0);
            jv.rotateY(angle);
            jv.rotateX(angle);
            jv.sphere(small);
            jv.popMatrix();

            //Top Right
            jv.pushMatrix();
            jv.translate(jv.width - 145, 115, 0);
            jv.rotateY(angle);
            jv.rotateX(angle);
            jv.sphere(small);
            jv.popMatrix();

            //Bottom Right
            jv.pushMatrix();
            jv.translate(jv.width - 145, jv.height - 115, 0);
            jv.rotateY(angle);
            jv.rotateX(angle);
            jv.sphere(small);
            jv.popMatrix();

    }
}
