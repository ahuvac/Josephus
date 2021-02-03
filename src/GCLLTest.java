import org.junit.Test;
import static org.junit.Assert.*;

/** 
 * @author Katz9
 */
public class GCLLTest
{

    public GCLLTest()
    {
    }

    @Test
    public void testRemove()
    {
        System.out.println("remove");
        GCLL<Integer> instance = new GCLL<>();
        boolean expResult = false;
        boolean result = instance.remove(null);
        assertEquals(expResult, result);
        instance.add(1);
        result = instance.remove(1);
        assertTrue(result);
        assertEquals("first->", instance.toString());
        System.out.println("expecting empty instance: " + instance.toString());

        GCLL<Integer> cll = new GCLL<>();
        cll.add(1);
        cll.add(2);
        System.out.println("ready to remove |1| from " + cll.toString());
        result = cll.remove(1);
        assertTrue(result);
        System.out.println("removed |1|: " + cll.toString());
        result = cll.remove(2);
        assertTrue(result);
        System.out.println("removed |2|: " + cll.toString());

        cll = new GCLL<>();
        cll.add(1);
        cll.add(2);
        System.out.println("ready to remove |2| from " + cll.toString());
        result = cll.remove(2);
        assertTrue(result);
        System.out.println("removed |2|: " + cll.toString());
        result = cll.remove(1);
        assertTrue(result);
        System.out.println("removed |1|: " + cll.toString());

        cll = new GCLL<>();
        cll.add(1);
        cll.add(2);
        cll.add(3);
        System.out.println("ready to remove |2| from " + cll.toString());
        result = cll.remove(2);
        assertTrue(result);
        System.out.println("removed |2|: " + cll.toString());
        result = cll.remove(1);
        assertTrue(result);
        System.out.println("removed |1|: " + cll.toString());
    }
}
