package ballpackage;

import processing.core.PApplet;



public class ProcessingObj extends PApplet {

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "" }, new ProcessingObj());
    }
    Ball b;
    Paddle p1;
    Paddle p2;
    int started = 1;
    int win;

    public void settings() {
        size(1000, 600);
    }

    @Override
    public void setup(){
        background(0);
        b = new Ball(width/2, height/2, 2, 1, width, height);
        p1 = new Paddle(0, height/2);
        p2 = new Paddle(width-50, height/2);
        if(started == 1){
            background(0);
            fill(255);
            textSize(60);
            textAlign(CENTER);
            text("**Welcome to Pong Game**\n Press Enter Key To Start", width / 2, height / 2);
        }

    }

    public int score(){
        if(gameOver()){
            if(b.counter1 > b.counter2){
                win = b.counter1;
            } else if (b.counter2 == b.counter1) {
                win = b.counter1;

            }
            else win = b.counter2;
        }
        return win;
    }

    public String toString(){
        String s = "";
        if(gameOver()){
            if(b.counter1 > b.counter2){
                s += "Player1";
            } else if (b.counter2 == b.counter1) {
                s += "Player1 and Player2";

            }
            else s += "Player2";
        }
        return  s;
    }
    public boolean gameOver(){
        if(b.counter1 == 100 || b.counter2 == 100) {
            started = 4;
        }
        return true;
    }

    @Override
    public void keyPressed(){
        if(keyCode == UP) {
            if( p1.yP < 60){
                p1.yP += p1.speed;
            }
            p1.yP -=  p1.speed;
        }
        if(keyCode == DOWN) {
            p1.yP += p1.speed;
            if (p1.yP > height - 100 ) {
                p1.yP -= p1.speed;
            }

        }
        if(keyCode == LEFT) {
            p2.yP += p2.speed;
            if (p2.yP > height - 100 ) {
                p2.yP -= p2.speed;
            }

        }
        if(keyCode == RIGHT) {
            if( p2.yP < 60){
                p2.yP += p2.speed;
            }
            p2.yP -=  p2.speed;
        }
       /* if(keyCode == 32){
            started = 2;
            draw();
        }*/
        if(keyCode == ENTER)started = 2;
        if(keyCode == 49 ) started = 3;
        else if (keyCode == 50) {
            b.xSpeed = 5;
            b.ySpeed = 2;
            started = 3;
        }
        if(keyCode == 51) {
            b.xSpeed = 10;
            b.ySpeed = 4;
            started= 3;
        }

    }


    public void ballCollidePaddel1(){

        if(dist(b.x,b.y, p2.xP, p2.yP) <= 45){
            b.xSpeed *= -1;
        }
        else if((p1.yP + b.y < 70))b.xSpeed *= -1;
        if((p2.yP + b.y <= 70))b.xSpeed *= -1;
        if((p1.xP + b.x <= 65) )b.xSpeed *= -1;
        if((p2.xP + b.x <= 45) )b.xSpeed *= -1;
    }

    @Override
    public void draw() {
        if(started == 3) {
            background(0);
            b.draw(g);
            p1.draw(g);
            p2.draw(g);
            p1.keyPressed(key);
            p2.keyPressed(key);
            textSize(60);
            textAlign(LEFT);
            text(b.counter1, p1.size / 2 - 40, 60);
            textAlign(RIGHT);
            text(b.counter2, width - 10, 60);
            line(0, 60, width, 60);
            ballCollidePaddel1();
            score();
        }
        else if(started == 2){
            background(0);
            fill(255);
            textSize(60);
            textAlign(CENTER);
            text("Choose Game Level\n Press 1 For Easy\n \t2 For Normal\n \t3 For Difficult", width/2, height/2);
        }
        else if (started == 4) {
            background(0);
            fill(255);
            textSize(60);
            textAlign(CENTER);
            text("**" + this +" You won**\n Score: " + score() + "\nTo Restart Press Spacebar", width / 2, height / 2);

        }


    }
}
