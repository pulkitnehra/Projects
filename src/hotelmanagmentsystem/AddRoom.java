/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagmentsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author nehra
 */
public class AddRoom extends JFrame implements ActionListener{
    private JPanel contentPane;
    private JTextField t2,t4;
    private JComboBox comboBox,  comboBox_2, comboBox_3;
    JButton b1,b2;
    

    public AddRoom()  {
        
        setBounds(450, 200, 1000, 450);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        JLabel l10 = new JLabel("Add Rooms");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
	l10.setBounds(194, 10, 120, 22);
	contentPane.add(l10);
        
	
        
	JLabel l1 = new JLabel("Room Number");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(64, 70, 102, 22);
	contentPane.add(l1);
        
        
        t4 = new JTextField();
	t4.setBounds(174, 70, 156, 20);
	contentPane.add(t4);
        

	JLabel l2 = new JLabel("Availability");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(64, 110, 102, 22);
	contentPane.add(l2);
        
        comboBox = new JComboBox(new String[] { "Available", "Occupied" });
	comboBox.setBounds(176, 110, 154, 20);
	contentPane.add(comboBox);


	JLabel l3 = new JLabel("Cleaning Status");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(64, 150, 102, 22);
	contentPane.add(l3);
        
        comboBox_2 = new JComboBox(new String[] { "Cleaned", "Dirty" });
	comboBox_2.setBounds(176, 150, 154, 20);
	contentPane.add(comboBox_2);

	JLabel l4 = new JLabel("Price");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(64, 190, 102, 22);
	contentPane.add(l4);
        
        t2 = new JTextField();
	t2.setBounds(174, 190, 156, 20);
	contentPane.add(t2);

        JLabel l5 = new JLabel("Bed Type");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(64, 230, 102, 22);
	contentPane.add(l5);


        comboBox_3 = new JComboBox(new String[] { "Single Bed", "Double Bed"});
	comboBox_3.setBounds(176, 230, 154, 20);
	contentPane.add(comboBox_3);
	

	b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBounds(64, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(198, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	
        contentPane.setBackground(Color.WHITE);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Images/twelve.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400,20,500,370);
        add(l15);
        
        
        setBounds(450, 200, 1000, 450);
        setVisible(true);
        setLayout(null);
    }
    
    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String rno =    t4.getText();
        String avail = (String)comboBox.getSelectedItem();
        String clean = (String)comboBox_2.getSelectedItem();
        String price = t2.getText();
        String bed = (String)comboBox_3.getSelectedItem();
        
        
        
        if(ae.getSource()==b1)
        {
            try {
                
                if(t4.getText()=="")
                {
                    JOptionPane.showMessageDialog(null, "Please enter all the values");
                
                }else{
                Conn c1 = new Conn();
                String qr = "insert into room values ('"+rno+"', '"+avail+"', '"+clean+"', '"+price+"', '"+bed+"'); ";
                c1.s.executeUpdate(qr);
                
                JOptionPane.showMessageDialog(null, "Room Info Added Successfully");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        }
        else if(ae.getSource()==b2)
        {
            setVisible(false);
        }
       
    }
    
    
}
