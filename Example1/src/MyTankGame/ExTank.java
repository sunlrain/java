package MyTankGame;

//Java绘图原理
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Vector;

/**
 * Created by kevin on 12/4/14.
 */
public class ExTank extends JFrame{
 //   ExMyPanelDemo mp = null; //一些画图示例
    ExMyPanelTank mp = null;  //画图坦克

    public static void main(String []args){
 //       URL uri = Thread.currentThread().getContextClassLoader().getResource("");   // 比如此时的uri为   file:///mnt/sdcard/external_sd/test.txt
 //       name = "";';'
 //       String path = new File(uri.getFile(), "../../../"+name).getCanonicalPath();
 //       File file = new File(new URI(uri.toString()));
        AePlayWave apw = new AePlayWave("/Users/kevin/JAVA/JAVA_Course/Example1/111.wav");
        apw.start();
//        System.out.println(uri.toString());
        ExTank ex = new ExTank();
    }

    public ExTank()
    {
//        mp = new ExMyPanelDemo();  //一些画图示例
        mp = new ExMyPanelTank();
        this.addKeyListener(mp);
        this.add(mp);

        Thread tmp = new Thread(mp);
        tmp.start();

        this.setSize(400,300);
        this.setLocation(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//我的Tank面板
class ExMyPanelTank extends JPanel implements KeyListener,Runnable
{
    MyTank tkMine = null;
 //   EnemyTank tkEnemy1 = null;   //敌方坦克1
 //   EnemyTank tkEnemy2 = null;   //敌方坦克2
 //   EnemyTank tkEnemy3 = null;   //敌方坦克3
    private boolean pressFlag = false;
    private KeyEvent key = null;
    Image image1=null;
    Image image2=null;
    Image image3=null;

    Vector<EnemyTank> ets=new Vector<EnemyTank>();
//    Vector<Node> nodes=new Vector<Node>();
    Vector<Bomb> bombs=new Vector<Bomb>();
    int enemyNum = 3;

    public ExMyPanelTank()
    {
        tkMine = new MyTank(100,100,4,0);
 //       tkEnemy1 = new EnemyTank(50,0,2,2);
 //       tkEnemy2 = new EnemyTank(150,0,2,2);
 //       tkEnemy3 = new EnemyTank(250,0,2,2);
        for(int i=0;i<enemyNum;i++)
        {
            EnemyTank et=new EnemyTank((i+1)*50,0,1,2);
 //           et.setColor(Color.yellow);
 //           et.setDirection(2);
            et.setEts(ets);

            Thread t=new Thread(et);
            t.start();
            Bullet s=new Bullet(et.x+10,et.y+30,2);
            et.ss.add(s);
            Thread t2=new Thread(s);
            t2.start();
            ets.add(et);
        }

        try {
            image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/MyTankGame/bomb_1.gif"));
            image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/MyTankGame/bomb_2.gif"));
            image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/MyTankGame/bomb_3.gif"));
//            image1=ImageIO.read(new File("//bomb_1.gif"));
//            image2=ImageIO.read(new File("//bomb_2.gif"));
//            image3=ImageIO.read(new File("//bomb_3.gif"));
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }


    }

    //重新Paint
    public void paint(Graphics g)
    {
        super.paint(g);

        g.fillRect(0,0,400,300);

        this.drawTank(tkMine.getX(),tkMine.getY(),g,tkMine.getDirection(),tkMine.getColor());
 //       this.drawTank(tkEnemy1.getX(),tkEnemy1.getY(),g,tkEnemy1.getDirection(),tkEnemy1.getColor());
//        this.drawTank(tkEnemy2.getX(),tkEnemy2.getY(),g,tkEnemy2.getDirection(),tkEnemy2.getColor());
 //       this.drawTank(tkEnemy3.getX(),tkEnemy3.getY(),g,tkEnemy3.getDirection(),tkEnemy3.getColor());

        for(int i=0;i<tkMine.ss.size();i++)
        {
            Bullet myShot=tkMine.ss.get(i);

            if(myShot!=null&&myShot.isLive==true)
            {
                g.draw3DRect(myShot.x, myShot.y, 1, 1,false);
            }
            if(myShot.isLive==false)
            {
                tkMine.ss.remove(myShot);
            }

        }

        for(int i=0;i<bombs.size();i++)
        {
    //        System.out.println("bombs.size()="+bombs.size());

            Bomb b=bombs.get(i);

            if(b.life>6)
            {
                g.drawImage(image1, b.x, b.y, 30, 30, this);
            }else if(b.life>3)
            {
                g.drawImage(image2, b.x, b.y, 30, 30, this);
            }else{
                g.drawImage(image3, b.x, b.y, 30, 30, this);
            }

            b.lifeDown();

            if(b.life==0)
            {
                bombs.remove(b);
            }
        }

        for(int i=0;i<ets.size();i++)
        {
            EnemyTank et=ets.get(i);

            if(et.isLive)
            {

                this.drawTank(et.getX(), et.getY(), g, et.getDirection(), et.getColor());
                for(int j=0;j<et.ss.size();j++)
                {
                    Bullet enemyShot=et.ss.get(j);
                    if(enemyShot.isLive)
                    {
                        g.draw3DRect(enemyShot.x, enemyShot.y, 1, 1,false);
                    }else{
                        et.ss.remove(enemyShot);
                    }
                }
            }
        }

    }

    //画出坦克
    public void drawTank(int x, int y, Graphics g, int direction, Color color) {

        g.setColor(color);

        //判断方向
        switch (direction) {
            //向上
            case 0:
                //画出左边矩形
                g.fill3DRect(x, y, 5, 30, false);
                //画出右边矩形
                g.fill3DRect(x + 15, y, 5, 30, false);
                //画出中间矩形
                g.fill3DRect(x + 5, y + 5, 10, 20, false);
                //画出圆形
                g.fillOval(x + 5, y + 10, 10, 10);
                //画出线:炮筒
                g.drawLine(x + 10, y + 15, x + 10, y);
                break;
            //向右
            case 1:
                //画出上边矩形
                g.fill3DRect(x, y, 30, 5, false);
                //画出下边矩形
                g.fill3DRect(x, y + 15, 30, 5, false);
                //画出中间矩形
                g.fill3DRect(x + 5, y + 5, 20, 10, false);
                //画出圆形
                g.fillOval(x + 10, y + 5, 10, 10);
                //画出线:炮筒
                g.drawLine(x + 15, y + 10, x + 30, y + 10);
                break;
            //向下
            case 2:
                //画出左边矩形
                g.fill3DRect(x, y, 5, 30, false);
                //画出右边矩形
                g.fill3DRect(x + 15, y, 5, 30, false);
                //画出中间矩形
                g.fill3DRect(x + 5, y + 5, 10, 20, false);
                //画出圆形
                g.fillOval(x + 5, y + 10, 10, 10);
                //画出线:炮筒
                g.drawLine(x + 10, y + 15, x + 10, y + 30);
                break;
            //向左
            case 3:
                //画出上矩形
                g.fill3DRect(x, y, 30, 5, false);
                //画出下边矩形
                g.fill3DRect(x, y + 15, 30, 5, false);
                //画出中间矩形
                g.fill3DRect(x + 5, y + 5, 20, 10, false);
                //画出圆形
                g.fillOval(x + 10, y + 5, 10, 10);
                //画出线:炮筒
                g.drawLine(x + 15, y + 10, x, y + 10);
                break;
        }
    }

    public void drawBullet(int x, int y, Graphics g)
    {
        g.setColor(Color.RED);
        g.fillOval(x,y,3,3);
    }


    public void hitMe()
    {
        for(int i=0;i<this.ets.size();i++)
        {
            EnemyTank et=ets.get(i);

            for(int j=0;j<et.ss.size();j++)
            {
                Bullet enemyShot=et.ss.get(j);
                if(tkMine.isLive)
                {
                    if(this.hitTank(enemyShot, tkMine))
                    {

                    }
                }
            }
        }
    }


    public void hitEnemyTank()
    {
        for(int i=0;i<tkMine.ss.size();i++)
        {
            Bullet myShot=tkMine.ss.get(i);
            if(myShot.isLive)
            {
                for(int j=0;j<ets.size();j++)
                {
                    EnemyTank et=ets.get(j);

                    if(et.isLive)
                    {
                        if(this.hitTank(myShot, et))
                        {
//                            Recorder.reduceEnNum();
//                            Recorder.addEnNumRec();
                        }
                    }

                }
            }
        }
    }

    public boolean hitTank(Bullet s,Tank et)
    {
        boolean b2=false;

        switch(et.direction)
        {
            case 0:
            case 2:
                if(s.x>et.x&&s.x<et.x+20&&s.y>et.y&&s.y<et.y+30)
                {
                    s.isLive=false;
                    et.isLive=false;
                    b2=true;
                    Bomb b=new Bomb(et.x,et.y);
                    bombs.add(b);

                }

                break;
            case 1:
            case 3:
                if(s.x>et.x&&s.x<et.x+30&&s.y>et.y&&s.y<et.y+20)
                {
                    s.isLive=false;
                    et.isLive=false;
                    b2=true;
                    Bomb b=new Bomb(et.x,et.y);
                    bombs.add(b);
                }
        }

        return b2;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(final KeyEvent e) {
        if(pressFlag){//这是一个成员变量，用以查看是否按下键
            return;
        }
//若没按下则处理：
        pressFlag=true;
        key = e;
        new Thread(){//
            public void run(){
                while(pressFlag){//只要一直按着就处理：
//添加你自己的代码：
                    keyPressedProcess();
//                    System.out.println("123");
                    try {
                        Thread.sleep(100);//不仅可以消除延迟，还可以控制延迟时间
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }.start();

        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressFlag = false;
        this.key = null;
    }

    public void keyPressedProcess()
    {
        if(this.key == null)
        {
            return;
        }

        if(this.key.getKeyCode()==KeyEvent.VK_W)
        {
//            System.out.println("Key W pressed");
            this.tkMine.setDirection(0);
            this.tkMine.moveUp();

        }else if(this.key.getKeyCode()==KeyEvent.VK_D)
        {
//            System.out.println("Key D pressed");
            this.tkMine.setDirection(1);
            this.tkMine.moveRight();
        }else if(this.key.getKeyCode()==KeyEvent.VK_S)
        {
//            System.out.println("Key S pressed");
            this.tkMine.setDirection(2);
            this.tkMine.moveDown();
        }else if(this.key.getKeyCode()==KeyEvent.VK_A)
        {
//            System.out.println("Key A pressed");
            this.tkMine.setDirection(3);
            this.tkMine.moveLeft();
        }
        if(this.key.getKeyCode()==KeyEvent.VK_J)
        {
            //System.out.println("this.hero.ss.size()="+this.hero.ss.size());
            if(this.tkMine.ss.size()<=4)
            {
                this.tkMine.shotEnemy();
            }

        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.hitEnemyTank();

            this.hitMe();

            this.repaint();
        }
    }
}
