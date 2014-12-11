package com.ExTankGame;

/**
 * Created by kevin on 12/7/14.
 */
public class ExTank {
}

class Tank
{
    int x;  //横坐标
    int y;  //纵坐标
    int speed; //速度
    int direction; //方向


    public Tank(int x, int y, int speed, int direction)
    {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}

class bullet
{
    int x;
    int y;
    int speed;

    public bullet(int x, int y, int speed)
    {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

class MyTank extends Tank
{
    public MyTank(int x, int y)
    {
        super(x,y,1,0);
    }
    public MyTank(int x, int y, int speed, int direction)
    {
        super(x,y,speed,direction);
    }

}