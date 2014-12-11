package MyTankGame;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by kevin on 12/7/14.
 */
public class ExMember {
}




class Tank
{
    int x;  //横坐标
    int y;  //纵坐标
    int speed; //速度
    int direction; //方向
    Color color;  //颜色，指明是自己坦克还是敌方坦克

    boolean isLive = true;

    public Tank(int x, int y, int speed, int direction, Color color)
    {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
        this.color = color;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}

class Bullet implements Runnable
{
    int x;
    int y;
    int direction;
    int speed;

    boolean isLive=true;

    public Bullet(int x, int y, int direction)
    {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.speed = 2;
    }

    public Bullet(int x, int y, int direction, int speed)
    {
        this.x = x;
        this.y = y;
        this.direction = direction;
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(50);
            } catch (Exception e) {
                // TODO: handle exception
            }

            switch (direction) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }

            //	System.out.println("x="+x+" y="+y);

            if (x < 0 || x > 400 || y < 0 || y > 300) {
                this.isLive = false;
                break;
            }
        }
    }
}

class MyTank extends Tank
{
    Vector<Bullet> ss=new Vector<Bullet>();
    Bullet s=null;


    public MyTank(int x, int y, int speed, int direction)
    {
        super(x,y,speed,direction,Color.cyan);
    }


    public void moveUp()
    {
        y-=speed;
    }
    public void moveRight()
    {
        x+=speed;
    }
    public void moveDown()
    {
        y+=speed;
    }
    public void moveLeft()
    {
        x-=speed;
    }

    public void shotEnemy()
    {


        switch(this.direction)
        {
            case 0:
                s=new Bullet(x+10,y,0);
                ss.add(s);
                break;
            case 1:
                s=new Bullet(x+30,y+10,1);
                ss.add(s);
                break;
            case 2:
                s=new Bullet(x+10,y+30,2);
                ss.add(s);
                break;
            case 3:
                s=new Bullet(x,y+10,3);
                ss.add(s);
                break;

        }

        Thread t=new Thread(s);
        t.start();

    }


}

class EnemyTank extends Tank implements Runnable
{
    int times=0;
    //Enemy tanks collection
    Vector<EnemyTank> ets=new Vector<EnemyTank>();
    Vector<Bullet> ss=new Vector<Bullet>();

    public EnemyTank(int x, int y, int speed, int direction)
    {
        super(x,y,speed,direction,Color.yellow);
    }

    public void setEts(Vector<EnemyTank> vv)
    {
        this.ets=vv;
    }

    public boolean isTouchOtherEnemy()
    {
        boolean b=false;


        switch(this.direction)
        {
            case 0:
                for(int i=0;i<ets.size();i++)
                {
                    EnemyTank et=ets.get(i);
                    if(et!=this)
                    {
                        if(et.direction==0||et.direction==2)
                        {
                            if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
                            {
                                return true;
                            }
                            if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
                            {
                                return true;
                            }
                        }
                        if(et.direction==3||et.direction==1)
                        {
                            if(this.x>=et.x&&this.x<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
                            {
                                return true;
                            }
                            if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
                            {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                for(int i=0;i<ets.size();i++)
                {
                    EnemyTank et=ets.get(i);
                    if(et!=this)
                    {
                        if(et.direction==0||et.direction==2)
                        {
                            if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
                            {
                                return true;
                            }
                            if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+30)
                            {
                                return true;
                            }
                        }
                        if(et.direction==3||et.direction==1)
                        {
                            if(this.x+30>=et.x&&this.x+30<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
                            {
                                return true;
                            }
                            if(this.x+30>=et.x&&this.x+30<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
                            {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2:
                for(int i=0;i<ets.size();i++)
                {
                    EnemyTank et=ets.get(i);
                    if(et!=this)
                    {
                        if(et.direction==0||et.direction==2)
                        {
                            if(this.x>=et.x&&this.x<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
                            {
                                return true;
                            }
                            if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
                            {
                                return true;
                            }
                        }
                        if(et.direction==3||et.direction==1)
                        {
                            if(this.x>=et.x&&this.x<=et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20)
                            {
                                return true;
                            }

                            if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20)
                            {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3:
                for(int i=0;i<ets.size();i++)
                {
                    EnemyTank et=ets.get(i);
                    if(et!=this)
                    {
                        if(et.direction==0||et.direction==2)
                        {
                            if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
                            {
                                return true;
                            }
                            if(this.x>=et.x&&this.x<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+30)
                            {
                                return true;
                            }
                        }
                        if(et.direction==3||et.direction==1)
                        {
                            if(this.x>=et.x&&this.x<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
                            {
                                return true;
                            }
                            if(this.x>=et.x&&this.x<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
                            {
                                return true;
                            }
                        }
                    }
                }
                break;
        }


        return b;
    }


    public void run() {
        while(true)
        {
            switch(this.direction)
            {
                case 0:
                    for(int i=0;i<30;i++)
                    {
                        if(y>0&&!this.isTouchOtherEnemy())
                        {
                            y-=speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                            // TODO: handle exception
                        }
                    }
                    break;
                case 1:
                    for(int i=0;i<30;i++)
                    {
                        if(x<400&&!this.isTouchOtherEnemy())
                        {
                            x+=speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                            // TODO: handle exception
                        }
                    }
                    break;
                case 2:
                    for(int i=0;i<30;i++)
                    {
                        if(y<300&&!this.isTouchOtherEnemy())
                        {
                            y+=speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                            // TODO: handle exception
                        }
                    }
                    break;
                case 3:
                    for(int i=0;i<30;i++)
                    {
                        if(x>0&&!this.isTouchOtherEnemy())
                        {
                            x-=speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                            // TODO: handle exception
                        }
                    }
                    break;

            }

            this.times++;

            if(times%2==0)
            {
                if(isLive)
                {
                    if(ss.size()<5)
                    {
                        //System.out.println("et.ss.size()<5="+et.ss.size());
                        Bullet s=null;
                        switch(direction)
                        {
                            case 0:
                                s=new Bullet(x+10,y,0);
                                ss.add(s);
                                break;
                            case 1:
                                s=new Bullet(x+30,y+10,1);
                                ss.add(s);
                                break;
                            case 2:
                                s=new Bullet(x+10,y+30,2);
                                ss.add(s);
                                break;
                            case 3:
                                s=new Bullet(x,y+10,3);
                                ss.add(s);
                                break;
                        }

                        Thread t=new Thread(s);
                        t.start();
                    }
                }
            }


            this.direction=(int)(Math.random()*4);

            if(this.isLive==false)
            {
                break;
            }

        }

    }


}

class Bomb
{
    int x,y;
    int life=9;
    boolean isLive=true;
    public Bomb(int x,int y)
    {
        this.x=x;
        this.y=y;
    }

    public void lifeDown()
    {
        if(life>0)
        {
            life--;
        }else{
            this.isLive=false;
        }

    }

}

class AePlayWave extends Thread {

    private String filename;
    public AePlayWave(String wavfile) {
        filename = wavfile;

    }

    public void run() {

        File soundFile = new File(filename);

        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e1) {
            e1.printStackTrace();
            return;
        }

        AudioFormat format = audioInputStream.getFormat();
        SourceDataLine auline = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

        try {
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        auline.start();
        int nBytesRead = 0;

        byte[] abData = new byte[512];

        try {
            while (nBytesRead != -1) {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0)
                    auline.write(abData, 0, nBytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } finally {
            auline.drain();
            auline.close();
        }

    }


}