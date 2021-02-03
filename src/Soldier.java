/**
 * creates soldier object with an id number
 * @author ahuvacheifetz
 */
public class Soldier
{
    private int idNum;


    public Soldier(int num)
    {
        idNum = num;
    }

    public int getIdNum()
    {
        return idNum;
    }
    @Override
    public String toString()
    {
        return idNum+"";
    }


}

