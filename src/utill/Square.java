package utill;

public class Square
{
    private int posX;
    private int posY;
    private Boolean filled;




    public Square()
    {
        this.posX = 0;
        this.posY = 0;
        this.filled = false;
    }

    public Square(int x , int y , boolean filled)
    {
        this.posX = x;
        this.posY = y;
        this.filled = filled;
    }

    public int getPosX()
    {
        return this.posX;
    }

    public  int getPosY()
    {
        return  this.posY;
    }

    public boolean get_filled()
    {
        return this.filled;
    }
}
