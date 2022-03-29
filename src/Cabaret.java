import java.sql.Array;
import java.util.ArrayList;

public class Cabaret {
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name)
    {
        this.name = name;
        performers = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Performer> getPerformers()
    {
        return performers;
    }

    public boolean addPerformer(Performer performer)
    {
        if (performers.indexOf(performer) == -1) {
            performers.add(performer);
            return true;
        }
        return false;
    }

    public boolean removePerformer(Performer performer)
    {
        if (performers.indexOf(performer) != -1)
        {
            performers.remove(performers.indexOf(performer));
            return true;
        }
        return false;
    }

    public double averagePerformerAge()
    {
        int size = performers.size();
        int age = 0;
        for (Performer obj : performers)
        {
            age += obj.getAge();
        }
        return (double) age / size;
    }

    public ArrayList<Performer> performersOverAge(int age)
    {
        ArrayList<Performer> overAge = new ArrayList<>();
        for (Performer obj : performers) {
            if (obj.getAge() >= age)
            {
                overAge.add(obj);
            }
        }
        return overAge;
    }

    public void groupRehearsal()
    {
        for (Performer performer : performers)
        {
            System.out.println("REHEARSAL CALL! " + performer.getName());
            if (performer instanceof Comedian)
            {
                Comedian temp = (Comedian) performer;
                temp.rehearse(false);
            }
            else
            {
                performer.rehearse();
            }
        }
    }

    public void cabaretShow()
    {
        for (Performer performer : performers)
        {
            System.out.println("Welcome to the cabaret! Next act up... " + performer.getName());
            if (performer instanceof Dancer)
            {
                Dancer temp = (Dancer) performer;
                temp.pirouette(2);
            }
            performer.perform();
        }
    }
}
