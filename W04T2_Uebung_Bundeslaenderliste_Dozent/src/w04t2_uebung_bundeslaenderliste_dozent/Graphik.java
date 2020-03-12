package w04t2_uebung_bundeslaenderliste_dozent;

import MyTools.MyFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;
import javafx.scene.control.RadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class Graphik
{

    private MyFrame frame;
    private JRadioButton rbStadt, rbLand;
    private JPanel pnlRadio;
    private JList liste;
    private JScrollPane scrollerListe;
    private JLabel lbl;
    private ButtonGroup gruppe;
    private Vector<Bundesland> vecLaender;

    // ==============================================================
    private class MyRBAL implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae)
        {
            JRadioButton rb = (JRadioButton) ae.getSource();

            if (rb == rbLand)
            {
                Bundesland.setSortierung('l');
                Collections.sort(vecLaender, new Landvergleicher('l'));
            } else
            {
                Bundesland.setSortierung('s');
                Collections.sort(vecLaender, new Landvergleicher('s'));
            }

            liste.setListData(vecLaender);
        }
    }

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
                Bundesland bl = vecLaender.get(index);
                lbl.setText(String.format("%s (%s)",
                        bl.getLand(), bl.getStadt()));
            }
        }
    }

    // ==============================================================
    public Graphik()
    {
        vecLaender = new Vector<>();

        vecLaender.add(new Bundesland("Schleswíg-Holstein", "Kiel"));
        vecLaender.add(new Bundesland("Niedersachsen", "Hannover"));
        vecLaender.add(new Bundesland("Mecklenburg-Vorpommern", "Schwerin"));
        vecLaender.add(new Bundesland("Brandenburg", "Potsdam"));
        vecLaender.add(new Bundesland("Nordrhein-Westfalen", "Düsseldorf"));
        vecLaender.add(new Bundesland("Hessen", "Wiesbaden"));
        vecLaender.add(new Bundesland("Thüringen", "Erfurt"));
        vecLaender.add(new Bundesland("Sachsen-Anhalt", "Magdeburg"));
        vecLaender.add(new Bundesland("Sachsen", "Dresden"));
        vecLaender.add(new Bundesland("Hamburg", "Hamburg"));
        vecLaender.add(new Bundesland("Bremen", "Bremen"));
        vecLaender.add(new Bundesland("Berlin", "Berlin"));
        vecLaender.add(new Bundesland("Rheinland-Pfalz", "Mainz"));
        vecLaender.add(new Bundesland("Saarland", "Saarbrücken"));
        vecLaender.add(new Bundesland("Baden-Württemberg", "Stuttgart"));
        vecLaender.add(new Bundesland("Bayern", "München"));

        frame = new MyFrame("W04T2U");
        rbStadt = new JRadioButton("Hauptstadt");
        rbLand = new JRadioButton("Bundesland");
        pnlRadio = new JPanel();
        liste = new JList();
        scrollerListe = new JScrollPane(liste);
        gruppe = new ButtonGroup();
        lbl = new JLabel("---");
    }

    // --------------------------------------------------------------
    public void start()
    {
        frame.setLayout(new BorderLayout());

        // - - - - - - - - - - - - - - - -
        BoxLayout bl = new BoxLayout(pnlRadio, BoxLayout.PAGE_AXIS);
        pnlRadio.setLayout(bl);

        MyRBAL rbal = new MyRBAL();

        pnlRadio.add(rbLand);
        rbLand.addActionListener(rbal);
        rbStadt.addActionListener(rbal);
        gruppe.add(rbLand);

        pnlRadio.add(rbStadt);
        gruppe.add(rbStadt);

        frame.add(scrollerListe, BorderLayout.CENTER);

        frame.add(lbl, BorderLayout.PAGE_END);

        frame.add(pnlRadio, BorderLayout.LINE_START);

        rbLand.setSelected(true);

        Bundesland.setSortierung('l');
        Collections.sort(vecLaender, new Landvergleicher('l'));
        liste.setListData(vecLaender);

        liste.addListSelectionListener(new MyLiSeLi());

        // - - - - - - - - - - - - - - - -
        frame.show(800, 600);
    }

    // --------------------------------------------------------------
}
