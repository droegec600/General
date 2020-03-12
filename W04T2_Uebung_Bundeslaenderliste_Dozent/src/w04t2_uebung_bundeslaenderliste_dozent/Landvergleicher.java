package w04t2_uebung_bundeslaenderliste_dozent;

import java.util.Comparator;

public class Landvergleicher implements Comparator<Bundesland>
{

    private char sortierung;

    // --------------------------------------------------------------
    public Landvergleicher(char sortierung)
    {
        this.sortierung = sortierung;
    }

    // --------------------------------------------------------------
    @Override
    public int compare(Bundesland b1, Bundesland b2)
    {
        int back = 0;

        if (sortierung == 'l')
        {
            back = b1.getLand().compareTo(b2.getLand());
        } else
        {
            back = b1.getStadt().compareTo(b2.getStadt());
        }

        return back;
    }
    // --------------------------------------------------------------
}
