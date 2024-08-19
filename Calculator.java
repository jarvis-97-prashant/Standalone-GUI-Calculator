import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Calculator
{
   JTextField tf1,tf2,tf3,tf;
   JButton plusbtn,subbtn,mbtn,dbtn,cbtn,dotbtn;

	Calculator()
	{
            JFrame f=new JFrame("Calculator");
          //  Image icon = Toolkit.getDefaultToolkit().getImage("D:\\PRIYANSHU\\Calculator-icon.png");
          //  f.setIconImage(icon);    
            f.setVisible(true);
            f.setSize(300,300);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel textpanel=new JPanel(new GridLayout(1,3));
            
            tf1=new JTextField();
            tf2=new JTextField();
            tf3=new JTextField();

            tf1.addMouseListener((MouseListener) new ListenMyMouse());
            tf2.addMouseListener(new ListenMyMouse());
            tf3.addMouseListener(new ListenMyMouse());

            textpanel.add(tf1);
            textpanel.add(tf2);
            textpanel.add(tf3);

            JPanel btnpanel=new JPanel(new GridLayout(5,3,10,10));
            JButton btn;
            for(int i=0; i<10; i++)
            {
                btn=new JButton(Integer.toString(i));
                btn.addActionListener(new Listenonbutton());
                btnpanel.add(btn);
            }
            
            plusbtn=new JButton("+");
            subbtn=new JButton("-");
            mbtn=new JButton("*");
            dbtn=new JButton("/");
            dotbtn=new JButton(".");
            cbtn=new JButton("c");
            
            plusbtn.addActionListener(new Listenonbutton());
            subbtn.addActionListener(new Listenonbutton());
            mbtn.addActionListener(new Listenonbutton());
            dbtn.addActionListener(new Listenonbutton());
            dotbtn.addActionListener(new Listenonbutton());
            cbtn.addActionListener(new Listenonbutton());

            btnpanel.add(plusbtn);
            btnpanel.add(subbtn);
            btnpanel.add(mbtn);
            btnpanel.add(dbtn);
            btnpanel.add(dotbtn);

            f.add(btnpanel,BorderLayout.CENTER);
            f.add(textpanel,BorderLayout.NORTH);
            f.add(cbtn,BorderLayout.SOUTH);
            
	}
	class ListenMyMouse implements MouseListener{
            public void mouseClicked(MouseEvent e)
            {
                if((JTextField)e.getSource()==tf1)
                {
                        tf=tf1;
                }
                else
                {
                        tf=tf2;
                }
            }
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {} 
        }

	class Listenonbutton implements ActionListener{
            JButton btn;
            @Override
            public void actionPerformed(ActionEvent e)
            {
                btn=(JButton)e.getSource();
                char ch=btn.getText().charAt(0);

                if(ch>='0' && ch<='9')
                {
                        String value=tf.getText()+ch;
                        tf.setText(value);
                }
                else if(ch=='+')
                {
                        int a=Integer.parseInt(tf1.getText());
                        int b=Integer.parseInt(tf2.getText());

                        int c=a+b;
                        tf3.setText(Integer.toString(c));
                }
                else if(ch=='-')
                {
                        int a=Integer.parseInt(tf1.getText());
                        int b=Integer.parseInt(tf2.getText());

                        int c=a-b;
                        tf3.setText(Integer.toString(c));
                }
                else if(ch=='*')
                {
                        int a=Integer.parseInt(tf1.getText());
                        int b=Integer.parseInt(tf2.getText());

                        int c=a*b;
                        tf3.setText(Integer.toString(c));
                }
                else if(ch=='/')
                {
                        int a=Integer.parseInt(tf1.getText());
                        int b=Integer.parseInt(tf2.getText());

                        int c=a/b;
                        tf3.setText(Double.toString(c));
                }
                else
                {
                        tf1.setText("");
                        tf2.setText("");
                        tf3.setText("");
                }
            }
	}
	public static void main(String ar[])
	{
		Calculator obj=new Calculator();
	}
}
