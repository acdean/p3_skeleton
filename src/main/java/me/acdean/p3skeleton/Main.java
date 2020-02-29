package me.acdean.p3skeleton;

import peasy.PeasyCam;
// these are only used for additive blending
import com.jogamp.opengl.GL;
import processing.core.PApplet;
import processing.opengl.PJOGL;

/*
** Main replaces the processing sketch file.
*/

public class Main extends PApplet {

    public PeasyCam cam;
    Baubles baubles = new Baubles(this);

    public static void main(String[] args) {
        PApplet.main("me.acdean.p3skeleton.Main");
    }

    @Override
    public void settings() {
        //fullScreen(P3D);
        size(1600, 800, P3D);
    }

    @Override
    public void setup() {

        // set up camera
        cam = new PeasyCam(this, 300);

        // just a grid of baubles
        baubles.init();
    }

    @Override
    public void draw() {
        background(0);

        // turn on additive blending, always fun
        additiveBlending();

        // draw all the baubles
        baubles.draw();
    }

    void additiveBlending() {
        GL gl = ((PJOGL)beginPGL()).gl.getGL();
        gl.glEnable(GL.GL_BLEND);
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE);
        gl.glDisable(GL.GL_DEPTH_TEST);
    }

    @Override
    public void keyPressed() {
        System.out.println("Saving frame");
        saveFrame("bauble_####.png");
    }
}
