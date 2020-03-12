package w04t2_radio_split_scroll_list_dozent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class PanelRadio extends JPanel
{

    private JTextArea area;
    private JRadioButton[] radio;
    private ButtonGroup gruppe;

    // ==============================================================
    private class MyRadioAL implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae)
        {
            JRadioButton sender = (JRadioButton) ae.getSource();

            if (sender == radio[3])
            {
                area.append("Hurra --- Radio3 \n");
            } else
            {
                area.append(sender.getText() + "\n");
            }
        }
    }

    // ==============================================================
    public PanelRadio(JTextArea area)
    {

        gruppe = new ButtonGroup();

        this.setLayout(null);

        this.area = area;
        radio = new JRadioButton[5];

        MyRadioAL al = new MyRadioAL();

        for (int i = 0; i < radio.length; i++)
        {
            radio[i] = new JRadioButton("RadioButton " + i);
            radio[i].setBounds(10, 10 + i * 40, 200, 30);
            radio[i].addActionListener(al);
            this.add(radio[i]);
            gruppe.add(radio[i]);
        }

    }

}
