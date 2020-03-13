package w05t4_uebung_simplerexplorer_dozent;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MyTableModel implements TableModel
{
    private File aktuellesVerzeichnis;
    private File[]liste;
    private String[] ueberschriften;

    //---------------------------------------------------------------
    public MyTableModel(File aktuellesVerzeichnis)
    {
        this.aktuellesVerzeichnis = aktuellesVerzeichnis;
        liste = aktuellesVerzeichnis.listFiles();
        ueberschriften = new String[]
        {
            "Name", "Datum", "Größe", "Verzeichnis"
        };
    }

    //---------------------------------------------------------------
  
    
    public File getAtuellesVerzeichnis()
    {
        return aktuellesVerzeichnis;
    }
    
    //---------------------------------------------------------------
   
    public File[] getFiles()
    {
        return liste;
    }
    
    //---------------------------------------------------------------
   
    @Override
    public int getRowCount()
    {
        int back =0;
        
        if (liste !=  null)
            back = liste.length;
    
        return back;
    }

    //---------------------------------------------------------------
    @Override
    public int getColumnCount()
    {
        return 4;
    }

    //---------------------------------------------------------------
    @Override
    public String getColumnName(int i)
    {
        return ueberschriften[i];
    }

    //---------------------------------------------------------------
    @Override
    public Class<?> getColumnClass(int i)
    {
        return String.class;
    }

    //---------------------------------------------------------------
    @Override
    public boolean isCellEditable(int i, int i1)
    {
        return false;
    }

    //---------------------------------------------------------------
    @Override
    public Object getValueAt(int y, int x)
    {
        String back = "";
        File f = liste[y];

        switch (x)
        {
            case 0:
                back = f.getName();
                break;
            case 1:
                //back = String.format ("%d", );
                 // Format format = new SimpleDateFormat("DD-MM-YYYY hh:mm:ss");
                 // back =format.format(new Date(f.lastModified()));
                // back = (new Date(f.lastModified())).toString();
                 
                    //print the original last modified date
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    back =  sdf.format(f.lastModified());
                
                
                
                
                 // Format format = new SimpleDateFormat("DD-MM-YYYY hh:mm:ss");
                 
                 // Date d = new Date();
                // format.format(d);
                // long mod = f.lastModified();
                 //d.setTime(mod);
                 // back =  d.toString(); 
                 // back = format.format(d);
                break;
            case 2:
                if (f.isFile())
                    back = "" + f.length();
                break;
            case 3:
                back = (f.isFile()) ? "Datei" : "Verzeichnis";
                break;
        }
        return back;
    }

    //---------------------------------------------------------------
    @Override
    public void setValueAt(Object o, int i, int i1)
    {
    }

    //---------------------------------------------------------------
    @Override
    public void addTableModelListener(TableModelListener tl)
    {
    }

    //---------------------------------------------------------------
    @Override
    public void removeTableModelListener(TableModelListener tl)
    {
    }

    //---------------------------------------------------------------
}
