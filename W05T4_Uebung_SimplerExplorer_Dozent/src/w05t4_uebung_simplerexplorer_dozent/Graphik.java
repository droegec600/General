package w05t4_uebung_simplerexplorer_dozent;

import MyTools.MyFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Graphik
{

    private MyFrame frame;
    private JButton btnBack;
    private JScrollPane scroller;
    private JTable tabelle;
    private File aktuellesVerzeichnis;

    // ==============================================================
    private class MyML implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent me)
        {
            JTable sender = (JTable) me.getSource();
            MyTableModel model = (MyTableModel) sender.getModel();
            File[] liste = model.getFiles();
            int x = sender.getSelectedColumn();
            int y = sender.getSelectedRow();

            if (x == 0)
            {
                File f = liste[y];
                if (f.isDirectory())
                {
                    try
                    {
                        tabelle.setModel(new MyTableModel(f));
                    } catch (Exception ex)
                    {
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent me)
        {
        }

        @Override
        public void mouseReleased(MouseEvent me)
        {
        }

        @Override
        public void mouseEntered(MouseEvent me)
        {
        }

        @Override
        public void mouseExited(MouseEvent me)
        {
        }

    }

    // ==============================================================
    private class MyAL implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae)
        {
            MyTableModel model = (MyTableModel) tabelle.getModel();

            File f = model.getAtuellesVerzeichnis();

            try
            {
                f = f.getParentFile();
                tabelle.setModel(new MyTableModel(f));
            } catch (Exception ex)
            {
            }
        }
    }

    // ==============================================================
    public Graphik()
    {
        frame = new MyFrame("Explorer");
        btnBack = new JButton("Ebene hoch");
        tabelle = new JTable();
        scroller = new JScrollPane(tabelle);
        aktuellesVerzeichnis = new File("C:/");
    }

    // --------------------------------------------------------------
    public void start()
    {
        frame.setLayout(new BorderLayout());
        frame.add(scroller, BorderLayout.CENTER);
        frame.add(btnBack, BorderLayout.PAGE_END);
        tabelle.setModel(new MyTableModel(aktuellesVerzeichnis));
        frame.show(900, 700);

        btnBack.addActionListener(new MyAL());
        tabelle.addMouseListener(new MyML());
    }

    // --------------------------------------------------------------
}
