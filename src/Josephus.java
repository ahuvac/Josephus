/**
 * Implements a user-specified amount of soldiers which are stored in a circular
 * linked list. When the user inputs a number,the soldiers are killed off at
 * that interval.
 * @author ahuvacheifetz
 */
public class Josephus {


    public static void main(String[] args) {

        doJosephus();


    }

    private static void doJosephus() {
        int num_sold = UI.getInt(UI.Source.SCANNER, "How many soldiers?", 3);
        int interval = UI.getInt(UI.Source.SCANNER, "Countdown number:", 1);


        GCLL<Soldier> soldiers = new GCLL<>();

        for (int ix = num_sold; ix > 0; --ix) {
            soldiers.add(new Soldier(ix));
        }

        System.out.println(soldiers);
        execute(soldiers, interval);
    }


    public static void execute(GCLL<Soldier> list, int interval) {


        int length = list.getLength();
        if (list.getFirst() == null) {
            System.out.println("empty");
        }

        list.advance(interval);


        while (list.getLength() > 1) {

            Soldier curr = list.getFirst();
            System.out.println(curr + " has been executed");
            list.remove(curr);
            list.advance(interval - 1);

        }

        System.out.println("survivor " + list.getFirst().getIdNum());

    }

}

