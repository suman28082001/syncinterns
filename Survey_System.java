import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Survey_System extends JFrame implements ActionListener
{
    JLabel l;
    JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];
    Survey_System(String s)
    {
        super(s);
        l=new JLabel();
        add(l);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Next");
        b2=new JButton("Ignore");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);add(b2);
        set();
        l.setBounds(30,40,450,20);
        jb[0].setBounds(50,80,100,20);
        jb[1].setBounds(50,110,100,20);
        jb[2].setBounds(50,140,100,20);
        jb[3].setBounds(50,170,100,20);
        b1.setBounds(100,240,100,30);
        b2.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            if(check())
                count=count+1;
            current++;
            set();
            if(current==9)
            {
                b1.setEnabled(false);
                b2.setText("Finish");
            }
        }
        if(e.getActionCommand().equals("Ignore"))
        {
            JButton bk=new JButton("Ignore"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x]=current;
            x++;
            current++;
            set();
            if(current==9)
                b2.setText("Finish");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++)
        {
            if(e.getActionCommand().equals("Ignore"+y))
            {
                if(check())
                    count=count+1;
                now=current;
                current=m[y];
                set();
                ((JButton)e.getSource()).setEnabled(false);
                current=now;
            }
        }

        if(e.getActionCommand().equals("Finish"))
        {
            if(check())
                count=count+1;
            current++;
            //System.out.println("correct ans="+count);
            JOptionPane.showMessageDialog(this,"Thanks");
            System.exit(0);
        }
    }
    void set()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("Que1: Have you ever purchased a product or service from our website?");
            jb[0].setText("Yes");jb[1].setText("No");jb[2].setText("Maybe");jb[3].setText("Can't Remember");
        }
        if(current==1)
        {
            l.setText("Que2: How did you hear about our website?");
            jb[0].setText("Friends/Families");jb[1].setText("Unknown");jb[2].setText("Amazon");jb[3].setText("Flipkart");
        }
        if(current==2)
        {
            l.setText("Que3: Rate our product and service");
            jb[0].setText("Outstanding");jb[1].setText("Excellent");jb[2].setText("Good");jb[3].setText("Bad");
        }
        if(current==3)
        {
            l.setText("Que4: How likely is it that you would recommended this company to a friend or colleague");
            jb[0].setText("OK_OK");jb[1].setText("No");jb[2].setText("Yes");jb[3].setText("Extremely Likely");
        }
        if(current==4)
        {
            l.setText("Que5: I'm satisfied with the investment my organization makes in education:");
            jb[0].setText("Strongly agree");jb[1].setText("Disagree");jb[2].setText("Neither agree nor disagree");jb[3].setText(" Strongly Disagree");
        }
        if(current==5)
        {
            l.setText("Que6: Are you interest for others products and services? ");
            jb[0].setText("Yes");jb[1].setText("No");jb[2].setText("Still Thinking");jb[3].setText("Yes/No");
        }
        if(current==6)
        {
            l.setText("Que7: Which Product You Loved Most? ");
            jb[0].setText("HairGel");jb[1].setText("BeautyCream");jb[2].setText("Perfume");
            jb[3].setText("ShowerGel");
        }
        if(current==7)
        {
            l.setText("Que8: Which Service You Liked Most?");
            jb[0].setText("HomeTrial");jb[1].setText("Contactless Packaging");jb[2].setText("Easy Paying");
            jb[3].setText("Easy Return");
        }
        if(current==8)
        {
            l.setText("Que9: How many products are you buying?");
            jb[0].setText("One");jb[1].setText("Two");jb[2].setText("Three");jb[3].setText("Four");
        }
        if(current==9)
        {
            l.setText("Que10: For Which Service You Want To Repeat?");
            jb[0].setText("Hair Transplanting");jb[1].setText("Body Massage");jb[2].setText(" Facial Retro");
            jb[3].setText("Uv Treatment");
        }
        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
            jb[j].setBounds(50,80+i,200,20);
    }
    boolean check()
    {
        if(current==0)
            return(jb[1].isSelected());
        if(current==1)
            return(jb[2].isSelected());
        if(current==2)
            return(jb[3].isSelected());
        if(current==3)
            return(jb[0].isSelected());
        if(current==4)
            return(jb[2].isSelected());
        if(current==5)
            return(jb[2].isSelected());
        if(current==6)
            return(jb[1].isSelected());
        if(current==7)
            return(jb[3].isSelected());
        if(current==8)
            return(jb[1].isSelected());
        if(current==9)
            return(jb[2].isSelected());
        return false;
    }
    public static void main(String[] args)
    {
        new Survey_System("Survey System ");
    }
}