package ballpackage;

import processing.core.PApplet;
import processing.core.PGraphics;

public class Ball extends PApplet {
    float x;
    float y;
    float xSpeed;
    int ySpeed;
    int fillColor;
    int widthBound;
    int heightBound;
    int counter1 = 0;
    int counter2 = 0;


    public  Ball(int x, int y, int xSpeed, int ySpeed, int width, int height){
        this.x = x;
        this.y = y;
        this.widthBound = width;
        this.heightBound = height;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        fillColor = (255);
    }
    public void drawCircle(){
        x = x + xSpeed;
        y = y + ySpeed;
    }

    public void  updateSpeed(){
        if (x > widthBound-20) {
            x = (int) (widthBound / 2) + 20;
            counter1++;
            xSpeed *= -1;
        }
        if( x < 20) {
            x = (int)(widthBound/2)+20;
            counter2++;
            xSpeed *= -1;
        }

        if (y > heightBound-20 || y < 90) {
            ySpeed *= -1;
        }

    }



    public void draw(PGraphics g) {
        g.fill(fillColor);
        g.ellipse(x, y, 40, 40);
        drawCircle();
        updateSpeed();

    }
}
