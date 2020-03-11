package w03t2_maps_dozent;

/**
 * Das Interface "Comparable" ist wegen der TreeMap noetig.
 */
public class Person implements Comparable<Person>
{

    public String vorname, nachname;

    // --------------------------------------------------------------
    public Person(String vorname, String nachname)
    {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    // --------------------------------------------------------------
    @Override
    public String toString()
    {
        return vorname + " " + nachname;
    }

    // --------------------------------------------------------------

    @Override
    public int hashCode()
    {
        return (toString() + super.hashCode()).hashCode();
    }
    
    // --------------------------------------------------------------
    @Override
    public int compareTo(Person p)
    {
        Person p1 = this;
        Person p2 = p;

        return p1.toString().compareTo(p2.toString());
    }

    // --------------------------------------------------------------
}
