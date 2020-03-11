package w03t5_uebung_tictactoe_dozent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graphik
{

    private MyFrame frame;
    private JPanel pnlGross, pnlSpielfeld;
    private JButton[][] feld;
    private JLabel lbl;
    private char aktuellerSpieler;
    private int anzahlZuege;

    // ==============================================================
    private class MyTTTAL implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae)
        {
            // Referenz auf den gedrueckten Button
            JButton sender = (JButton) ae.getSource();

            sender.setText("" + aktuellerSpieler);
            sender.setEnabled(false);
            anzahlZuege++;

            if (!gewonnenOderUnentschieden())
            {
                aktuellerSpieler = (aktuellerSpieler == 'X') ? 'O' : 'X';
                computerzug();
            }
        }
    }

    // ==============================================================
    public Graphik()
    {
        frame = new MyFrame("TicTacToe");
        pnlGross = new JPanel();
        pnlSpielfeld = new JPanel();
        lbl = new JLabel("---");
        feld = new JButton[3][3];
        aktuellerSpieler = 'X';
        anzahlZuege = 0;
    }

    // --------------------------------------------------------------
    private byte getBit()
    {
        return (byte) (Math.random() * 2);
    }

    // --------------------------------------------------------------
    private void computerzug()
    {
        int x, y;

        do
        {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);

        } while (feld[x][y].getText().length() != 0);

        feld[x][y].setText("" + aktuellerSpieler);
        feld[x][y].setEnabled(false);
        anzahlZuege++;

        if (!gewonnenOderUnentschieden())
        {
            aktuellerSpieler = (aktuellerSpieler == 'X') ? 'O' : 'X';
        }
    }

    // --------------------------------------------------------------
    private boolean eq(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        JButton b1 = feld[x1][y1];
        JButton b2 = feld[x2][y2];
        JButton b3 = feld[x3][y3];

        boolean back = b1.getText().equals("" + aktuellerSpieler)
                && (b1.getText().equals(b2.getText()))
                && (b1.getText().equals(b3.getText()));

        if (back)
        {
            b1.setBackground(Color.RED);
            b2.setBackground(Color.RED);
            b3.setBackground(Color.RED);
        }

        return back;
    }

    // --------------------------------------------------------------
    private boolean gewonnenOderUnentschieden()
    {
        boolean gewonnen
                = eq(0, 0, 1, 0, 2, 0) // Zeile 0
                || eq(0, 1, 1, 1, 2, 1) // Zeile 1
                || eq(0, 2, 1, 2, 2, 2)// Zeile 2
                || eq(0, 0, 0, 1, 0, 2) // Spalte 0
                || eq(1, 0, 1, 1, 1, 2) // Spalte 1
                || eq(2, 0, 2, 1, 2, 2) // Spalte 2
                || eq(0, 0, 1, 1, 2, 2) // Diagonale '\'
                || eq(2, 0, 1, 1, 0, 2); // Diagonale '/'

        boolean unentschieden = false;

        if (gewonnen)
        {
            lbl.setText("Glueckwunsch, " + aktuellerSpieler + " hat gewonnen!");
        } else
        {
            if (anzahlZuege == 9)
            {
                lbl.setText("Unentschieden");
                unentschieden = true;
            }
        }

        if (gewonnen || unentschieden)
        {
            for (int y = 0; y <= 2; y++)
            {
                for (int x = 0; x <= 2; x++)
                {
                    feld[x][y].setEnabled(false);
                }
            }
        }

        return gewonnen || unentschieden;
    }

    // --------------------------------------------------------------
    public void start()
    {
        pnlGross.setLayout(new BorderLayout());
        frame.add(pnlGross);

        pnlGross.add(lbl, BorderLayout.PAGE_END);
        pnlGross.add(pnlSpielfeld, BorderLayout.CENTER);

        pnlSpielfeld.setLayout(new GridLayout(3, 3, 10, 10));

        MyTTTAL al = new MyTTTAL();

        for (int y = 0; y <= 2; y++)
        {
            for (int x = 0; x <= 2; x++)
            {
                feld[x][y] = new JButton();
                feld[x][y].addActionListener(al);
                pnlSpielfeld.add(feld[x][y]);
            }

        }

        frame.show(800, 600);

        if (getBit() == 0)
        {
            computerzug();
        }
    }

    // --------------------------------------------------------------
}
