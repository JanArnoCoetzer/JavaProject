package utill;

public class Player
{
    public float pos_x = 0;
    public float pos_y = 0;
    public float cam_angle = 0;
    public float field_of_view = 90;
    public float speed = 1;
    public float rotation_speed = 50;

    public int numRays = 45;
    public int rayLength = 150;

    public void Player(){this.pos_x = 0; this.pos_y = 0; this.cam_angle = 0;}
    public void Player(float x,float y, float angle){this.pos_x = x; this.pos_y = y; this.cam_angle = angle;}

    public void setPos(float x, float y){this.pos_x = x; this.pos_y = y;}
    public void setSpeed(float speed){this.speed = speed;}

    public void Move(float x_velocity ,float y_velocity,double Delta)
    {
        this.pos_x = (float) ((pos_x) + (x_velocity *speed* Delta));
        this.pos_y = (float) ((pos_y) + (y_velocity *speed * Delta));
    }

    public  void Rotate(float direction,double Delta)
    {
       this.cam_angle = (float) (cam_angle + direction*rotation_speed*Delta);
       if(this.cam_angle > 360){cam_angle = 0;}
       if(this.cam_angle < 0){cam_angle = 360;}
    }


}
