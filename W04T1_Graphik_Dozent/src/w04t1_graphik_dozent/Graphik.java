package w04t1_graphik_dozent;

import MyTools.MyFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Graphik
{

    private MyFrame frame;
    private JPanel pnl;
    private JLabel lbl;
    private JSlider slider;
    private JCheckBox cb;
    private JPanel farbPanel;
    
    // ==============================================================
    
    private class MySliderCL implements ChangeListener
    {
        @Override
        public void stateChanged(ChangeEvent ce)
        {
            int wert = slider.getValue();
            
            lbl.setText("Slider: " + wert);
        }
    }
    
    // ==============================================================
       
    private class MyCheckboxAL implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if (cb.isSelected())
                lbl.setText("CheckBox ausgewaehlt");
            else
                lbl.setText("CheckBox nicht ausgewaehlt");
          }        
    }
    
    // ==============================================================
       
    public Graphik()
    {
        frame = new MyFrame();
        pnl=new JPanel();
        lbl = new JLabel();
        slider=new JSlider();
        cb = new JCheckBox();
        farbPanel = new JPanel();
    }

    // --------------------------------------------------------------
    
    public void start ()
    {
        pnl.setLayout(null);
        frame.add(pnl);
        
        lbl.setBounds(10, 10, 700, 30);
        pnl.add(lbl);
        
        // - - - - - - - - - - - - - - - - - - - - - - - -
        
        slider.setBounds(10, 50, 700, 90);
        slider.setMinimum(13);
        slider.setMaximum(113);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setMajorTickSpacing(25);
        slider.addChangeListener(new MySliderCL());
        pnl.add(slider);
        
        // - - - - - - - - - - - - - - - - - - - - - - - -
        
        cb.setBounds(10, 150, 700, 30);
        cb.setText("CheckBox");
        cb.addActionListener(new MyCheckboxAL());
        pnl.add(cb);
        
        // - - - - - - - - - - - - - - - - - - - - - - - -
        
        farbPanel.setBounds(10, 190, 700, 100);
        pnl.add(farbPanel);
        
        Color col = new Color(50, 150, 250); // r, g, b
        farbPanel.setBackground(col);
        
        // - - - - - - - - - - - - - - - - - - - - - - - -
        
        frame.show(800, 600);
    }

    // --------------------------------------------------------------
    
}
