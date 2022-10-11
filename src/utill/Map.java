package utill;

import java.util.ArrayList;
import java.util.List;

public class Map
{
    public static int map_x_resolution = 10;
    public static int map_y_resolution = 10;

    public static int num_Squares = 0;

    public static int square_size = 32;


    static List<Square> mapData = new ArrayList<>();


    public static void BuildMap()
    {
        for (int x = 0; x <= map_x_resolution -1  ; x++)
        {
            for (int y = 0; y <= map_y_resolution -1  ; y++)
            {
                   if (x==0 && y==0 && x == map_x_resolution && y ==map_y_resolution)
                   {
                       mapData.add(new Square(x,y,true));
                   }

                   else if(x == 4 && y == 4){mapData.add(new Square(x,y,true));}

                   else
                   {
                       mapData.add(new Square(x, y, false));
                   }

                   num_Squares++;
            }

        }

    }

    public static boolean isFilled(int posx, int posy)
    {
        if(posx > map_x_resolution    || posy > map_y_resolution  ){return false;}
        if(posx <= map_x_resolution    || posy <= map_y_resolution )
        {
            int index = 0;

            index = (int) map_x_resolution*posx+posy;

            Square curTile = mapData.get(index);
            boolean result = curTile.get_filled();
            return result;
        }
        else return false;
    }


    public int map_Translator_x(float x,float Screen_size_x)
    {
        return (int) ( ((Screen_size_x/2 - (map_x_resolution*square_size)/2) + x * square_size ) - square_size/2);
    }

    public int map_Translator_y(float y, float Screen_size_y)
    {
        return (int) (((Screen_size_y/2 - (map_y_resolution*square_size)/2) + y *square_size ) - square_size/2 );
    }

    public int map_draw_translator_x(float x,float Screen_size_x)
    {
        return (int) ( ((Screen_size_x/2 - (map_x_resolution*square_size)/2) + x * square_size )- square_size) ;
    }

    public int map_draw_translator_y(float y, float Screen_size_y)
    {
        return (int) (((Screen_size_y/2 - (map_y_resolution*square_size)/2) + y *square_size )- square_size);
    }
}
