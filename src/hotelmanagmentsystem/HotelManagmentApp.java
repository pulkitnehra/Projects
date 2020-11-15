/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagmentsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author nehra
 */
public class HotelManagmentApp extends JFrame{

    public HotelManagmentApp()  {
        
        
        setBounds(300,200,1366,565);
        setVisible(true);
        setLocation(600, 150);
        setLayout(null);
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Images/first.jpg"));
        
        JLabel l1 = new JLabel(ic);
        l1.setBounds(0, 0, 1366, 565);
        add(l1);
        
        JLabel l2 = new JLabel("Hotel Managment System");
        l2.setBounds(20, 420, 1000, 90);
        l2.setForeground(Color.PINK);
        l2.setFont(new Font("serif", Font.PLAIN, 70));
        l1.add(l2);
        
        JButton b1 = new JButton("Next");
        b1.setBackground(Color.WHITE);              
        b1.setForeground(Color.BLACK);
        b1.setBounds(940, 450, 150, 50);
        l1.add(b1);
          b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
            }
        });
        
//        for the conitnuous glow of the text
        while (true) {
            l2.setVisible(false);
            try {
                Thread.sleep(600);
            } catch (Exception e) {
                
            }
            l2.setVisible(true);
            try{
            
            Thread.sleep(600);
            
            }catch(Exception ex)
            {
            
            }
            
            
        }
        
      
        
        
        
    
    }

    
    
    
    
    
    public static void main(String[] args) {
        new HotelManagmentApp().setVisible(true);
    }
    
}
