package w03t2_maps_dozent;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * Eine Map gehoert zu den assoziativen Speichern, d.h. es wird nicht - wie bei
 * einem Array oder einer ArrayList - ein expliziter numerischer Index fuer den
 * Zugriff verwendet, sondern es werden zwei Objekte miteinander assoziiert.
 *
 * @author Alfa-Dozent
 */
public class W03T2_Maps_Dozent
{
    // --------------------------------------------------------------

    private static void treeMapDemo()
    {
        TreeMap<Person, String> tm = new TreeMap<Person, String>();

        Person p1 = new Person("Vorname_1", "Nachname_1");
        String a1 = "Musterstrasse 1, 12345 Musterhausen";

        Person p2 = new Person("Vorname_2", "Nachname_2");
        String a2 = "Musterstrasse 2, 12345 Musterhausen";

        Person p3 = new Person("Vorname_3", "Nachname_3");
        String a3 = "Musterstrasse 3, 12345 Musterhausen";

        // Die Schluessel muessen EINDEUTIG sein!
        tm.put(p3, a3);
        tm.put(p2, a2);
        // tm.put(p2, a1);
        tm.put(p1, a1);

        System.out.println("(1) tm.get (p2) = " + tm.get(p2));

        // Liefert eine Menge mit allen Schluesseln der Map
        Set<Person> personen = tm.keySet();
        System.out.println("(2) keySet = " + personen);

        // Schluessel beibehalten, Wert aendern
        tm.replace(p1, a3);

        /*
         * Die TreeSet-Methode "entrySet" liefert ein Set aller Wertpaare der
         * Map.
         */
        for (Entry<Person, String> kvp : tm.entrySet())
        {
            // Key (Person) und Wert (String) ausgeben
            System.out.println(kvp.getKey() + " --- " + kvp.getValue());
        }

        Person p2V2 = new Person("Vorname_2", "Nachname_2");

        System.out.println("(3) " + tm.containsKey(p2));
        System.out.println("(4) " + tm.containsKey(p2V2));

        System.out.println("(5) " + tm.containsValue(a3));
        String a4 = "XXX";
        System.out.println("(6) " + tm.containsValue(a4));
    }

    // --------------------------------------------------------------
    private static void hashMapDemo()
    {
        HashMap<Person, String> hm = new HashMap<Person, String>();

        Person p1 = new Person("Vorname_13", "Nachname_1");
        String a1 = "Musterstrasse 1, 12345 Musterhausen";

        Person p2 = new Person("Vorname_2", "Nachname_2");
        String a2 = "Musterstrasse 2, 12345 Musterhausen";

        Person p3 = new Person("Vorname_3", "Nachname_3");
        String a3 = "Musterstrasse 3, 12345 Musterhausen";

        Person p4 = new Person("Vorname_2", "Nachname_2");

        System.out.println("p1.hashCode() = " + p1.hashCode()); // 1829164700
        System.out.println("p2.hashCode() = " + p2.hashCode());
        System.out.println("p3.hashCode() = " + p3.hashCode());
        System.out.println("p4.hashCode() = " + p4.hashCode());

        // Die Schluessel muessen EINDEUTIG sein!
        hm.put(p3, a3);
        hm.put(p2, a2);
        hm.put(p1, a1);

        System.out.println("(1) hm.get (p2) = " + hm.get(p2));

        // Liefert eine Menge mit allen Schluesseln der Map
        Set<Person> personen = hm.keySet();
        System.out.println("(2) keySet = " + personen);

        // Schluessel beibehalten, Wert aendern
        hm.replace(p1, a3);

        /*
         * Die TreeSet-Methode "entrySet" liefert ein Set aller Wertpaare der
         * Map.
         */
        for (Entry<Person, String> kvp : hm.entrySet())
        {
            // Key (Person) und Wert (String) ausgeben
            System.out.println(kvp.getKey() + " --- " + kvp.getValue());
        }

        Person p2V2 = new Person("Vorname_2", "Nachname_2");

        System.out.println("(3) " + hm.containsKey(p2));
        System.out.println("(4) " + hm.containsKey(p2V2));

        System.out.println("(5) " + hm.containsValue(a3));
        String a4 = "XXX";
        System.out.println("(6) " + hm.containsValue(a4));
    }

    // --------------------------------------------------------------
    public static void main(String[] args)
    {
        treeMapDemo();
        hashMapDemo();

        Interface1.Interface2 interf;
    }

    // --------------------------------------------------------------
}
