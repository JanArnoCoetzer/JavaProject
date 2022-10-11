package utill;

public class RayCastCalc
{

    public static float distance(float x1, float y1, float x2, float y2)
    {
        float dist = (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        dist = (float) Math.sqrt(dist*dist);
        return dist;
    }

    public static boolean is_colliding(float px, float py,float px2,float py2, float bx,float by,float b_size, float ray_length)
    {

        boolean ray_above_square = false;
        boolean ray_Right_of_square = false;
        boolean ray_Under_square = false;
        boolean ray_Left_of_square = false;

        boolean player_above_square = false;
        boolean player_Right_of_square = false;
        boolean player_Under_square = false;
        boolean player_Left_of_square = false;

        if(py2 <  by - b_size/2)
        {
            ray_above_square = true;

        }
        if(px2 > bx + b_size/2)
        {
            ray_Right_of_square = true;

        }
        if(py2 > by + b_size/2)
        {
            ray_Under_square = true;

        }
        if(px2 < bx -b_size/2)
        {
            ray_Left_of_square = true;

        }

        if(py <  by - b_size/2)
        {
            ray_above_square = true;

        }
        if(px > bx + b_size/2)
        {
            player_Right_of_square = true;

        }
        if(py > by + b_size/2)
        {
            player_Under_square = true;

        }
        if(px< bx -b_size/2)
        {
            player_Left_of_square = true;

        }


        if(ray_above_square && player_Right_of_square && !ray_Right_of_square)
        {
        return true;
        }
        return false;

    }




    public static float intersectionX(float px, float py,float px2,float py2, float bx,float by,float b_size, float ray_length)
{
    //p1(bx1,by1)  p2(bx2by2)
    //        center
    //p3(bx3,by3)  p4(bx4,by4)
    float bx1,by1,bx2,by2,bx3,by3,bx4,by4;

    //p1
    bx1 = bx - b_size/2;
    by1 = by - b_size/2;
    //p2
    bx2 = bx + b_size/2;
    by2 = by - b_size/2;
    //p3
    bx3 = bx - b_size/2;
    by3 = by + b_size/2;
    //p4
    bx4 = bx + b_size/2;
    by4 = by + b_size/2;

    // lines of the box                                                       where they intersect with the given ray

    //top
    //bx1,by1 --> bx2,by2 = L1 intersect_y(bx1,by1,bx2,by2,px,py,px2,py2); = y
    //                         intersect_x(bx1,by1,bx2,by2,px,py,px2,py2); = x

    //right
    //bx2,by2 --> bx4,by4 = L2 intersect_y(bx2,by2,bx4,by4,px,py,px2,py2); = y
    //                         intersect_x(bx1,by1,bx2,by2,px,py,px2,py2); = x

    //bottom
    //bx4,by4 --> bx3,by3 = L3 intersect_y(bx4,by4,bx3,by3,px,py,px2,py2); = y
    //                         intersect_x(bx1,by1,bx2,by2,px,py,px2,py2); = x

    //left
    //bx3,by3 --> bx1,by1 = L4 intersect_y(bx3,by3,bx1,by1,px,py,px2,py2); = y
    //                         intersect_y(bx3,by3,bx1,by1,px,py,px2,py2); = x

    //where the ray intersects with L1
    float L1_intersected_at_x = intersect_x(bx1,by1,bx2,by2,px,py,px2,py2);
    float L1_intersected_at_y = intersect_y(bx1,by1,bx2,by2,px,py,px2,py2);
    // ray intersection distance from ray start for L1
    float L1_distance = distance(L1_intersected_at_x,L1_intersected_at_y,px,py);
    // has ray collided with L1
    boolean L1_collision = L1_distance < ray_length ;

    //where the ray intersects with L2
    float L2_intersected_at_x = intersect_x(bx2,by2,bx4,by4,px,py,px2,py2);
    float L2_intersected_at_y = intersect_y(bx2,by2,bx4,by4,px,py,px2,py2);
    // ray intersection distance from ray start for L2
    float L2_distance = distance(L2_intersected_at_x,L2_intersected_at_y,px,py);
    // has ray collided with L2
    boolean L2_collision = L2_distance < ray_length;

    //where the ray intersects with L3
    float L3_intersected_at_x = intersect_x(bx4,by4,bx3,by3,px,py,px2,py2);
    float L3_intersected_at_y = intersect_y(bx4,by4,bx3,by3,px,py,px2,py2);
    // ray intersection distance from ray start for L3
    float L3_distance = distance(L3_intersected_at_x,L3_intersected_at_y,px,py);
    // has ray collided with L3
    boolean L3_collision = L3_distance < ray_length;

    //where the ray intersects with L4
    float L4_intersected_at_x = intersect_x(bx3,by3,bx1,by1,px,py,px2,py2);
    float L4_intersected_at_y = intersect_y(bx3,by3,bx1,by1,px,py,px2,py2);
    // ray intersection distance from ray start for L4
    float L4_distance = distance(L4_intersected_at_x,L4_intersected_at_y,px,py);
    // has ray collided with L4
    boolean L4_collision = L4_distance < ray_length;

    boolean above_square = false;
    boolean Right_of_square = false;
    boolean Under_square = false;
    boolean Left_of_square = false;

    if(py <  by - b_size/2)
    {
        above_square = true;

    }
    if(px > bx + b_size/2)
    {
        Right_of_square = true;

    }
     if(py > by + b_size/2)
    {
        Under_square = true;

    }
     if(px< bx -b_size/2)
    {
        Left_of_square = true;

    }



    if(above_square && !Right_of_square && !Left_of_square)
    {
        return L1_intersected_at_x;
    }
    if(above_square && Right_of_square)
    {
        if(L1_distance < L2_distance){return L1_intersected_at_x;}
        else return L2_intersected_at_x;
    }
    if(Right_of_square && !above_square && !Under_square)
    {
        return L2_intersected_at_x;
    }
    if(Right_of_square && Under_square)
    {
        if(L2_distance < L3_distance){return L2_intersected_at_x;}
        else return L3_intersected_at_x;
    }
    if(Under_square && !Right_of_square && !Left_of_square)
    {

        return L3_intersected_at_x;
    }
    if(Under_square && Left_of_square)
    {
        if(L3_distance < L4_distance){return L3_intersected_at_x;}
        else return L4_intersected_at_x;
    }
    if (Left_of_square && !above_square && !Under_square)
    {

        return L4_intersected_at_x;
    }
    if(Left_of_square && above_square)
    {
        if(L4_distance < L1_distance){return L4_intersected_at_x;}
        else return L1_intersected_at_x;
    }

    else return px2;
}


    public static float intersectionY(float px, float py,float px2,float py2, float bx,float by,float b_size, float ray_length)
    {
        //p1(bx1,by1)  p2(bx2,by2)
        //     center
        //p3(bx3,by3)  p4(bx4,by4)
        float bx1,by1,bx2,by2,bx3,by3,bx4,by4;

        //p1
        bx1 = bx - b_size/2;
        by1 = by - b_size/2;
        //p2
        bx2 = bx + b_size/2;
        by2 = by - b_size/2;
        //p3
        bx3 = bx - b_size/2;
        by3 = by + b_size/2;
        //p4
        bx4 = bx + b_size/2;
        by4 = by + b_size/2;

        // lines of the box                                                       where they intersect with the given ray

        //top
        //bx1,by1 --> bx2,by2 = L1 intersect_y(bx1,by1,bx2,by2,px,py,px2,py2); = y
        //                         intersect_x(bx1,by1,bx2,by2,px,py,px2,py2); = x

        //right
        //bx2,by2 --> bx4,by4 = L2 intersect_y(bx2,by2,bx4,by4,px,py,px2,py2); = y
        //                         intersect_x(bx1,by1,bx2,by2,px,py,px2,py2); = x

        //bottom
        //bx4,by4 --> bx3,by3 = L3 intersect_y(bx4,by4,bx3,by3,px,py,px2,py2); = y
        //                         intersect_x(bx1,by1,bx2,by2,px,py,px2,py2); = x

        //left
        //bx3,by3 --> bx1,by1 = L4 intersect_y(bx3,by3,bx1,by1,px,py,px2,py2); = y
        //                         intersect_y(bx3,by3,bx1,by1,px,py,px2,py2); = x

                            //where the ray intersects with L1
        float L1_intersected_at_x = intersect_x(bx1,by1,bx2,by2,px,py,px2,py2);
        float L1_intersected_at_y = intersect_y(bx1,by1,bx2,by2,px,py,px2,py2);
        // ray intersection distance from ray start for L1
            float L1_distance = distance(L1_intersected_at_x,L1_intersected_at_y,px,py);
        // has ray collided with L1
            boolean L1_collision = L1_distance < ray_length;

                            //where the ray intersects with L2
        float L2_intersected_at_x = intersect_x(bx2,by2,bx4,by4,px,py,px2,py2);
        float L2_intersected_at_y = intersect_y(bx2,by2,bx4,by4,px,py,px2,py2);
        // ray intersection distance from ray start for L2
            float L2_distance = distance(L2_intersected_at_x,L2_intersected_at_y,px,py);
        // has ray collided with L2
        boolean L2_collision = L2_distance < ray_length;

                             //where the ray intersects with L3
        float L3_intersected_at_x = intersect_x(bx4,by4,bx3,by3,px,py,px2,py2);
        float L3_intersected_at_y = intersect_y(bx4,by4,bx3,by3,px,py,px2,py2);
        // ray intersection distance from ray start for L3
            float L3_distance = distance(L3_intersected_at_x,L3_intersected_at_y,px,py);
        // has ray collided with L3
        boolean L3_collision = L3_distance < ray_length;

                            //where the ray intersects with L4
        float L4_intersected_at_x = intersect_x(bx3,by3,bx1,by1,px,py,px2,py2);
        float L4_intersected_at_y = intersect_y(bx3,by3,bx1,by1,px,py,px2,py2);
        // ray intersection distance from ray start for L4
            float L4_distance = distance(L4_intersected_at_x,L4_intersected_at_y,px,py);
        // has ray collided with L4
        boolean L4_collision = L4_distance < ray_length;

        boolean above_square = false;
        boolean Right_of_square = false;
        boolean Under_square = false;
        boolean Left_of_square = false;

        if(py <  by - b_size/2)
        {
            above_square = true;
        }
         if(px > bx + b_size/2)
        {
            Right_of_square = true;
        }
         if(py > by + b_size/2)
        {
            Under_square = true;
        }
         if(px< bx -b_size/2)
        {
            Left_of_square = true;
        }


        if(above_square && !Right_of_square && !Left_of_square)
        {

            //System.out.println("above");
            return L1_intersected_at_y;
        }
        if(above_square && Right_of_square)
        {

            //System.out.println("top right");
            if(L1_distance < L2_distance){return L1_intersected_at_y;}
            else return L2_intersected_at_y;
        }
        if(Right_of_square && !above_square && !Under_square)
        {

            //System.out.println("right ");
            return L2_intersected_at_y;
        }
        if(Right_of_square && Under_square)
        {
            //System.out.println("bottom right");
            if(L2_distance < L3_distance){return L2_intersected_at_y;}
            else return L3_intersected_at_y;
        }
        if(Under_square && !Right_of_square && !Left_of_square)
        {
            //System.out.println(" bottom");
            return L3_intersected_at_y;
        }
        if(Under_square && Left_of_square)
        {
            //System.out.println("bottom left");
            if(L3_distance < L4_distance){return L3_intersected_at_y;}
            else return L4_intersected_at_y;
        }
        if (Left_of_square && !above_square && !Under_square)
        {
            //System.out.println(" left ");
            return L4_intersected_at_y;
        }
        if(Left_of_square && above_square)
        {

            //System.out.println("top left");
            if(L4_distance < L1_distance){return L4_intersected_at_y;}
            else return L1_intersected_at_y;
        }


        else return py2;

    }



    private static float intersect_x(float x1, float y1 , float x2, float y2,float x3, float y3 , float x4, float y4)
    {
        x1 = Math.round(x1);
        y1 = Math.round(y1);
        x2 = Math.round(x2);
        y2 = Math.round(y2);
        x3 = Math.round(x3);
        y3 = Math.round(y3);
        x4 = Math.round(x4);
        y4 = Math.round(y4);



        float intX;
        intX = ((x1*y2-y1*x2)*(x3-x4)-(x1-x2)*(x3*x4-y3*x4))/(((x1-x2)*(y3-y4))-((y1-y2)*(x3-x4)));

        return intX;
    }
    private static float intersect_y(float x1, float y1 , float x2, float y2,float x3, float y3 , float x4, float y4)
    {
        x1 = Math.round(x1);
        y1 = Math.round(y1);
        x2 = Math.round(x2);
        y2 = Math.round(y2);
        x3 = Math.round(x3);
        y3 = Math.round(y3);
        x4 = Math.round(x4);
        y4 = Math.round(y4);

        float intY;

        intY = ((x1*y2-y1*x2)*(y3-y4)-(y1-y2)*(x3*y4-y3*x4))/(((x1-x2)*(y3-y4))-((y1-y2)*(x3-x4)));

        return intY;
    }

    public static float point_Circle_from_x(float x, float radius , float angle)
    {
        float result = x + (float) ( radius * Math.sin(Math.PI * 2 * angle / 360));
        return result;
    }
    public static float point_Circle_from_y(float y, float radius , float angle)
    {
        float result = (float) (y + radius * Math.cos(Math.PI * 2 * angle / 360));;
        return result;
    }

    public static void test()
    {
        float x,y;

        x = intersect_x(2,0,2,5,-2,5,2,5);
        y = intersect_y(2,0,2,5,-2,5,2,5);
        System.out.println(x + ":" + y);
    }




}
