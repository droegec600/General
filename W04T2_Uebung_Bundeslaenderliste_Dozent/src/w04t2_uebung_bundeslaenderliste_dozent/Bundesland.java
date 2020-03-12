package w04t2_uebung_bundeslaenderliste_dozent;

public class Bundesland
{

    private String land, stadt;
    private static char sortierung;

    // --------------------------------------------------------------
    public Bundesland(String land, String stadt)
    {
        this.land = land;
        this.stadt = stadt;
        sortierung = 'l';
    }

    // --------------------------------------------------------------
    public String getLand()
    {
        return land;
    }

    // --------------------------------------------------------------
    public String getStadt()
    {
        return stadt;
    }

    // --------------------------------------------------------------
    public static void setSortierung(char sort)
    {
        sortierung = sort;
    }

    // --------------------------------------------------------------
    @Override
    public String toString()
    {
        String back = "";

        if (sortierung == 'l')
        {
            back = land;
        } else
        {
            back = stadt;
        }

        return back;
    }

    // --------------------------------------------------------------
}
