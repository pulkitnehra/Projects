/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagmentsystem;


import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;


import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author nehra
 */
public class CheckOut extends JFrame {

        private JPanel contentPane;
	private JTextField t1;
        Choice c1;
    public CheckOut()  {
    
        setBounds(530, 200, 800, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Images/sixth.jpg"));
                Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(300,0,500,225);
                add(l1);
		
		JLabel lblCheckOut = new JLabel("Check Out ");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckOut.setBounds(70, 11, 140, 35);
		contentPane.add(lblCheckOut);
		
		JLabel lblName = new JLabel("Number :");
		lblName.setBounds(20, 85, 80, 14);
		contentPane.add(lblName);
                
                c1 = new Choice();
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(130, 82, 150, 20);
		contentPane.add(c1);
                
                JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setBounds(20, 132, 86, 20);
		contentPane.add(lblRoomNumber);
                
                ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Images/tick.png"));
                Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
                ImageIcon i6 = new ImageIcon(i5);
                JButton l2 = new JButton(i6);
                l2.setBounds(290,82,20,20);
                add(l2);
                
                t1 = new JTextField();
                t1.setBounds(130, 132, 150, 20);
		contentPane.add(t1);
                
                l2.addActionListener(new ActionListener() {
                @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    Conn con = new Conn();
                    String se2 = c1.getSelectedItem();
                    String rx = "select *from customer where number = '"+se2+"'";
                    ResultSet rs = con.s.executeQuery(rx);
                    if(rs.next())
                    {
                        t1.setText(rs.getString("room_number"));
                    }
                    
                } catch (Exception ex) {
                }
                
            }
        });
                
                
        JButton btnCheckout = new JButton("Check out");
        btnCheckout.setBounds(50, 200, 100, 25);
        btnCheckout.setBackground(Color.BLACK);
        btnCheckout.setForeground(Color.WHITE);
        contentPane.add(btnCheckout);
        
        btnCheckout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String id = c1.getSelectedItem();
                    String room = t1.getText();
                    String cstdelete = "delete from customer where number = '"+id+"';";
                    String roomdelete = "update room set availability = 'Available'  where room_number = '"+room+"';";
                    
                    try {
                        Conn con = new Conn();
                        con.s.executeUpdate(cstdelete);
                        con.s.executeUpdate(roomdelete);
                        JOptionPane.showMessageDialog(null, "Checkout Successfull");
                        new Reception().setVisible(true);
                } catch (Exception ex2) {
                    ex2.printStackTrace();
                }
                
            }
        });
        
        
        JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(160, 200, 100, 25);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
        
        
        
    
    }
    
    
    public static void main(String[] args) {
        new CheckOut().setVisible(true);
    }
    
    
    
}
