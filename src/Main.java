import utill.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

import static utill.Map.*;


public class Main extends JPanel
{
    public static double frameRate = 24;
    public static int screen_size_x = 1280;
    public static int screen_size_y = 720;

    private static Player player  = new Player();

    private static Map map = new Map();
    private static KeyHandler KH = new KeyHandler();
    public static JFrame frame = new JFrame();
    public static JPanel panel = new JPanel();


    public static void main(String[] args)
    {

        Map.BuildMap();

        Start();

//https://stackoverflow.com/questions/63515194/how-to-run-a-code-60-times-per-second-in-java
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / frameRate;
        double delta = 0;
        float deltatime = (float) (1/frameRate);
        while(true){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                Update(deltatime);
                delta--;
            }
        }
    }


    public static void Start()
    {


        initialise_window(screen_size_x,screen_size_y);

        player.setSpeed(80);
        player.setPos(screen_size_x/2,screen_size_y/2);




    }
    public static void Update(double DeltaTime)
    {
        if(KH.isKeyDown_W){player.Move(0,-1,DeltaTime);}
        if(KH.isKeyDown_S){player.Move(0,1,DeltaTime);}
        if(KH.isKeyDown_D){player.Move(1,0,DeltaTime);}
        if(KH.isKeyDown_A){player.Move(-1,0,DeltaTime);}

        if(KH.isKeyDown_Right){player.Rotate(-1,DeltaTime);}
        if(KH.isKeyDown_Left){player.Rotate(1,DeltaTime);}







    }


    public static void initialise_window(int x, int y)
    {
        final int width = x;
        final int hight = y;
        final String title = "2DRayCastRenderer";
        frame.setTitle(title);
        frame.setSize(width,hight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(KH);

        panel.setSize(width,hight);
        frame.add(panel);
        frame.getContentPane().add(new Main());



    }





        public void paint(Graphics g)
        {
            repaint();
            super.paint(g);
            g.drawOval((int) (player.pos_x-2.5f), (int) (player.pos_y - 2.5f),5,5);

            for (int x = 0; x < map.map_x_resolution ; x++)
            {
                for (int y = 0; y < map.map_y_resolution ; y++)
                {
                    if(map.isFilled(x, y) == true)
                    {
                        g.drawRect(map.map_draw_translator_x(x,screen_size_x),map.map_draw_translator_y(y,screen_size_y),map.square_size,map.square_size);
                    }
                }
            }

            for (int a = 0; a < player.numRays ; a++)
            {
                float angle_step = player.field_of_view/player.numRays;
                float current_angle = (player.cam_angle + angle_step * a)  + 135;
                float ray_end_x = RayCastCalc.point_Circle_from_x(player.pos_x,player.rayLength,current_angle);
                float ray_end_y = RayCastCalc.point_Circle_from_y(player.pos_y,player.rayLength,current_angle);

                float intersectionX = ray_end_x;
                float intersectionY = ray_end_y;

                for (int x = 0; x < map.map_x_resolution; x++)
                {
                    for (int y = 0; y < map.map_y_resolution; y++)
                    {

                        if(map.isFilled(x,y) == true)
                        {

                            if(RayCastCalc.is_colliding(player.pos_x,player.pos_y,ray_end_x,ray_end_y,map.map_Translator_x(x,screen_size_x),map.map_Translator_y(y,screen_size_y),map.square_size,player.rayLength)==true);
                            {
                                intersectionX = RayCastCalc.intersectionX(player.pos_x,player.pos_y,ray_end_x,ray_end_y,map.map_Translator_x(x,screen_size_x),map.map_Translator_y(y,screen_size_y),map.square_size,player.rayLength);
                                intersectionY = RayCastCalc.intersectionY(player.pos_x,player.pos_y,ray_end_x,ray_end_y,map.map_Translator_x(x,screen_size_x),map.map_Translator_y(y,screen_size_y),map.square_size,player.rayLength);
                                g.drawLine((int) player.pos_x, (int) player.pos_y, (int) intersectionX, (int) intersectionY);

                            }
                        }
                    }
                }
            }
        }
}

