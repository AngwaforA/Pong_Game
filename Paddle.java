package ballpackage;


import processing.core.PApplet;
import processing.core.PGraphics;

public class Paddle extends PApplet {
    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "" }, new Paddle(50,100));
    }
    int xP;
    int yP;
    int speed;
    int fillColor;
    int size = 100;

    public  Paddle(int xP, int yP){
        this.xP = xP;
        this.yP = yP;
        speed = 10;
        fillColor = (255);
    }
    public void keyPressed(char key){
        if(key == CODED) {
            if (keyCode == UP) {
                if (yP < 0) {
                    yP += speed;
                }
                yP -= speed;
            }
            if (keyCode == DOWN) {
                yP += speed;
                if (yP > height - size) {
                    yP -= speed;

                }

            }
        }

    }

    void draw(PGraphics g){
        g.fill(this.fillColor);
        g.rect(this.xP, this.yP, size/2, size);
    }

}
