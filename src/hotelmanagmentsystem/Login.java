/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagmentsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author nehra
 */
public class Login extends JFrame implements ActionListener{
    
    
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    ResultSet rs;
    public Login()  {
       super("Login");

        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);
 
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
         l3 = new JLabel(i3);
        l3.setBounds(350,10,150,150);
        add(l3);
        

        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        b2.addActionListener(this);
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
        setSize(600,300);
        setLocation(600,350);
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b2){       
            System.exit(0);
        }
        
        else if(ae.getSource()==b1){
            try {
                String usr = t1.getText();
                String pass = t2.getText();
                Conn c1  = new Conn();
                String qr = "select *from login where username like '"+usr+"' and password like '"+pass+"'";
                rs = c1.s.executeQuery(qr);
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(null, "Login Successfull");
                    new Dashboard().setVisible(true);
                    setVisible(false);
                }else{
                
                    JOptionPane.showMessageDialog(null, "Invalid Login Credentials");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public static void main(String[] args) {
        new Login().setVisible(true);
    }
    
   
}
