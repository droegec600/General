package w04t2_radio_split_scroll_list_dozent;

import MyTools.MyFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Graphik
{

    private MyFrame frame;
    private JTabbedPane tabbedPane;
    private JSplitPane splitPane;
    private JTextArea area;
    private JScrollPane scrollerArea;
    private JPanel pnlRechts;
    private JButton btnLoeschen;

    // ==============================================================
    private class MyLoeschenAL implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae)
        {
            area.setText("");
        }
    }

    // ==============================================================
    public Graphik()
    {
        frame = new MyFrame("W04T2");
        tabbedPane = new JTabbedPane();
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        area = new JTextArea();

        scrollerArea = new JScrollPane(area);

        pnlRechts = new JPanel();
        btnLoeschen = new JButton("Area löschen");
    }

    // --------------------------------------------------------------
    public void start()
    {
        frame.add(splitPane);

        btnLoeschen.addActionListener(new MyLoeschenAL());

        pnlRechts.setLayout(new BorderLayout());
        pnlRechts.add(scrollerArea, BorderLayout.CENTER);
        pnlRechts.add(btnLoeschen, BorderLayout.PAGE_END);

        splitPane.setLeftComponent(tabbedPane);
        splitPane.setRightComponent(pnlRechts);

        tabbedPane.setPreferredSize(new Dimension(400, 1));
        area.setEditable(false);
        tabbedPane.addTab("RadioButtons", new PanelRadio(area));
        tabbedPane.addTab("JList", new PanelListe(area));

        frame.show(900, 700);
    }

    // --------------------------------------------------------------
}
