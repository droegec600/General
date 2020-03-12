package w04t2_radio_split_scroll_list_dozent;

import java.awt.Component;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PanelListe extends JScrollPane
{

    private JScrollPane scrollerList;
    private JList liste;
    private Vector<String> v;
    private JTextArea area;

    // ==============================================================
    private class MyLiSeLi implements ListSelectionListener
    {

        @Override
        public void valueChanged(ListSelectionEvent lse)
        {
            if (lse.getValueIsAdjusting())
            {
                JList sender = (JList) lse.getSource();
                int index = sender.getSelectedIndex();
                area.append(v.get(index) + "\n");
            }
        }
    }

    // ==============================================================
    public PanelListe(JTextArea area)
    {
        this.area = area;
        liste = new JList();
        this.setViewportView(liste);

        v = new Vector<>();

        for (int i = 1; i <= 100; i++)
        {
            v.add("Zeile " + i);
        }

        liste.setListData(v);
        liste.addListSelectionListener(new MyLiSeLi());
    }

    // --------------------------------------------------------------
}
