package w05t4_file_dozent;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class W05T4_File_Dozent
{

    private static class MyFileFilter implements FileFilter
    {

        @Override
        public boolean accept(File file)
        {
            System.out.println(file.getAbsolutePath());
            return file.isFile();
        }

    }

    public static void main(String[] args) throws Exception
    {
        File f = new File("C:/Users/droeg/OneDrive/Dokumente/NetBeansProjects/W05T2_DateienV1_Dozent");

        System.out.println("f.canExecute() = " + f.canExecute());
        System.out.println("f.canRead() = " + f.canRead());
        System.out.println("f.canWrite() = " + f.canWrite());

        System.out.println("f.getAbsolutePath() = " + f.getAbsolutePath());
        System.out.println("f.getCanonicalPath() = " + f.getCanonicalPath());

        for (int i = 1; i <= 10; i++)
        {
            f = new File("C:/Users/droeg/OneDrive/Dokumente/NetBeansProjects/W05T2_DateienV1_Dozent/datei_" + i + ".txt");

            if (!f.exists())
            {
                f.createNewFile();
            }

            if (f.exists())
            {
                f.delete();
            }
        }

        f = new File("C:/temp");
        System.out.println(f.getParentFile());

        Date d = new Date(f.lastModified());
        System.out.println(d);

        f = new File("C:/Users/droeg/OneDrive/Dokumente/NetBeansProjects/W05T2_DateienV1_Dozent//NeuesVerzeichnis");
        // f.mkdir();

        // File f1 = new File("C:/temp/NeuesVerzeichnis/test.txt");
        // f1.createNewFile();
        f.delete();

        System.out.println("----------------------");

        f = new File("C:/Users/droeg/OneDrive/Dokumente/NetBeansProjects/W05T2_DateienV1_Dozent/");
        File[] fileArr = f.listFiles(new MyFileFilter());

        for (File file : fileArr)
        {
            System.out.println(file.getName());
        }


        System.out.println("----------------------");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setVisible(true);
        
        JFileChooser fc = new JFileChooser(f);
        int resultat = fc.showOpenDialog(frame);
        if (resultat == JFileChooser.APPROVE_OPTION)
        {
            System.out.println("Ausgewaehlt: " + fc.getSelectedFile().getCanonicalPath());
        }
    }

}
