/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagmentsystem;

;import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author nehra
 */
public class AddDriver extends JFrame implements ActionListener{
    
    private JPanel contentPane;
    private JTextField t1,t2,t3,t4, t5;
    private JComboBox comboBox, comboBox_1;
    JButton b1,b2,b3;

    public AddDriver()  {
        setBounds(450, 200, 1000, 500);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        setVisible(true);
        setLayout(null);
        
         ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Images/eleven.jpg"));
         Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
         ImageIcon i2 = new ImageIcon(i3);
         JLabel l15 = new JLabel(i2);
         l15.setBounds(400,30,500,370);
         add(l15);
        
        JLabel l10 = new JLabel("Add Drivers");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
	l10.setBounds(194, 10, 120, 22);
	contentPane.add(l10);
        
	
        
	JLabel l1 = new JLabel("Name");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(64, 70, 102, 22);
	contentPane.add(l1);
        
        
        t1 = new JTextField();
	t1.setBounds(174, 70, 156, 20);
	contentPane.add(t1);
        

	JLabel l2 = new JLabel("Age");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(64, 110, 102, 22);
	contentPane.add(l2);
        
        t2 = new JTextField();
	t2.setBounds(174, 110, 156, 20);
	contentPane.add(t2);


	JLabel l3 = new JLabel("Gender");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(64, 150, 102, 22);
	contentPane.add(l3);
        
        comboBox = new JComboBox(new String[] { "Male", "Female" });
	comboBox.setBounds(176, 150, 154, 20);
	contentPane.add(comboBox);

	JLabel l4 = new JLabel("Car Company");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(64, 190, 102, 22);
	contentPane.add(l4);
        
        t3 = new JTextField();
	t3.setBounds(174, 190, 156, 20);
	contentPane.add(t3);

        JLabel l5 = new JLabel("Car Brand");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(64, 230, 102, 22);
	contentPane.add(l5);


        t4 = new JTextField();
	t4.setBounds(174, 230, 156, 20);
	contentPane.add(t4);

	
        JLabel l6 = new JLabel("Available");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(64, 270, 102, 22);
	contentPane.add(l6);


        comboBox_1 = new JComboBox(new String[] { "Yes", "No" });
	comboBox_1.setBounds(176, 270, 154, 20);
	contentPane.add(comboBox_1);

        
        JLabel l7 = new JLabel("Location");
	l7.setForeground(new Color(25, 25, 112));
	l7.setFont(new Font("Tahoma", Font.BOLD, 14));
	l7.setBounds(64, 310, 102, 22);
	contentPane.add(l7);


        t5 = new JTextField();
	t5.setBounds(174, 310, 156, 20);
	contentPane.add(t5);
        
	

	b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBounds(64, 360, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(198, 360, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);
        
	b3 = new JButton("Clear");
	b3.addActionListener(this);
	b3.setBounds(130, 410, 111, 33);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
	contentPane.add(b3);

	
        contentPane.setBackground(Color.WHITE);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String nam = t1.getText();
        String age = t2.getText();
        String gender = (String)comboBox.getSelectedItem();
        String carc = t3.getText();
        String carb = t4.getText();
        String avail = (String)comboBox_1.getSelectedItem();
        String loc = t5.getText();
        if(ae.getSource()==b1)
        {
            try {
                
            
                Conn c1 = new Conn();
                String qr = "insert into driver values ('"+nam+"', '"+age+"', '"+gender+"', '"+carc+"', '"+carb+"', '"+avail+"', '"+loc+"'); ";
                c1.s.executeUpdate(qr);
                JOptionPane.showMessageDialog(null, "Driver Info Added Successfully");
                 }
             catch (Exception e) {
                e.printStackTrace();
            }
        
        }
        else if(ae.getSource()==b2)
        {
            new Reception().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==b3)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            
        }
       
    }
    
    public static void main(String[] args) {
     
        new AddDriver().setVisible(true);
    }
    
    
    
}
