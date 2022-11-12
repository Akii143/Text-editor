import javax.swing.*;
import java.awt.*;
import  javax.swing.plaf.metal.*;//theam file
import javax.swing.text.*;
import  java.awt.event.*;
import java.io.*;

class editor extends JFrame implements ActionListener{// action listioner work on our click and provide the rigtt o/p
    //creating the text area
    JTextArea T;// it like a notepad where we type anything
    //creating the frame to accomadate thr text area and menubar
    JFrame f;// creation of frame of the app name is f

    editor(){
        //initionalising the frame
        f=new JFrame("TextEdit");
        //setting the overall them of thr application
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.metal.metallicLookandFeel");
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        }
        catch (Exception e){

        }
        // initailising the text area
        JTextArea t;
        t=new JTextArea();
        //initialising file menebar
        JMenuBar m= new JMenuBar();
        //initialising of the file menu

        JMenu f1=new JMenu("File");
        //creating the individual menu items
        JMenuItem m1= new JMenuItem("New");
        JMenuItem m2= new JMenuItem("Open");
        JMenuItem m3= new JMenuItem("Save");
        JMenuItem m4= new JMenuItem("Print");

        //adding  the actionListener
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);
        //adding the menuitems to the file menu

        f1.add(m1);
        f1.add(m2);
        f1.add(m3);
        f1.add(m4);

        JMenu f2=new JMenu("Edit");
        JMenuItem m5=new JMenuItem("Cut");
        JMenuItem m6=new JMenuItem("Copy");
        JMenuItem m7=new JMenuItem("Paste");

        m5.addActionListener(this);
        m6.addActionListener(this);
        m7.addActionListener(this);

        f2.add(m5);
        f2.add(m6);
        f2.add(m7);

        JMenuItem c=new JMenuItem("Exit");
        c.addActionListener(this);
        //adding the all button to menubar
        m.add(f1);
        m.add(f2);
        m.add(c);
        //adding of menu button and menubar to frame
        f.add(t);
        f.setJMenuBar(m);// for adding the menubar to the frame follow are inbult function
        f.setSize(500,500);
        f.show();

    }
    public void actionPerformed(ActionEvent e){

        String s = e.getActionCommand();
        JTextArea t;
        t=new JTextArea();

        if(s.equals("New")){

            t.setText(" ");

        }
        else if(s.equals("Open")){
            JFileChooser j=new JFileChooser("d:");// getting the file in the dekstop
            int r=j.showOpenDialog(null);

            if(r == JFileChooser.APPROVE_OPTION){// CHECK IF USER CLIC THE FILE OR NOT AND RETURN THE VALUE
                File fi=new File(j.getSelectedFile().getAbsolutePath());//getting the name and the path of the file
                try {// trying the copy the info in the file
                    String s1="",s2="";
                    FileReader fr =new FileReader(fi);//chosed file
                    BufferedReader br=new BufferedReader(fr);

                    s2=br.readLine();//storing in string
                    while ((s1=br.readLine())!=null){
                        s2=s2 + "\n" + s1;

                    }

                    t.setText(s2);

                }
                catch (Exception et){
                    JOptionPane.showMessageDialog(f,et.getMessage());// pop up showing there is no exit

                }

            }
            else
                JOptionPane.showMessageDialog(f,"opration cancell");

        }
        else if(s.equals("Save")){
            JFileChooser j=new JFileChooser("d:");// getting the file in the dekstop
            int r=j.showOpenDialog(null);

            if(r==JFileChooser.APPROVE_OPTION) {// CHECK IF USER CLIC THE FILE OR NOT AND RETURN THE VALUE
                File fi = new File(j.getSelectedFile().getAbsolutePath());
                try {
                    FileWriter wr = new FileWriter(fi);
                    BufferedWriter bw = new BufferedWriter(wr);

                    bw.write(t.getText());

                    bw.flush();
                    bw.close();
                } catch (Exception et) {
                    JOptionPane.showMessageDialog(f, et.getMessage());// pop up showing there is no exit

                }

            }
            else
                JOptionPane.showMessageDialog(f,"opration cancell");



        }
        else if(s.equals("Print")){
            try{
                t.print();

            }
            catch (Exception et){
                JOptionPane.showMessageDialog(f,et.getMessage());

            }


        }
        else if(s.equals("Cut")){
            t.cut();

        }
        else if(s.equals("Copy")){
            t.copy();

        }
        else if(s.equals("paste")){
            t.paste();

        }
        else if(s.equals("Exit")){
            f.setVisible(false);

        }



    }
    public static void main(String arge[]){
        editor e=new editor();
    }
}