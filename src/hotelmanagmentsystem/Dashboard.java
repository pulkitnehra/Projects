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
import javax.swing.*;

/**
 *
 * @author nehra
 */
public class Dashboard extends JFrame {

    JLabel icon, title;
    JMenuBar mb;
    JMenu hotelservices, admin;
    JMenuItem reception, addemp, addroom, adddriver;
    public Dashboard()  {
    
        super("HOTEL MANAGMENT SYSTEM");
        
        
        icon = new JLabel("");
        icon.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/third.jpg")));
        icon.setBounds(0, 0, 1950, 1000);
        add(icon);
        
        title = new JLabel("WELCOME TO HOTEL MOUNT VIEW");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Tahoma", Font.PLAIN, 36));
        title.setBounds(450, 60, 1920, 85);
        icon.add(title);
        
        mb = new JMenuBar();
        hotelservices = new JMenu("HOTEL SERVICES");
        hotelservices.setForeground(Color.BLUE);
        reception = new JMenuItem("RECEPTION");
        setJMenuBar(mb);
        mb.add(hotelservices);
        hotelservices.add(reception);
        admin = new JMenu("ADMIN");
        admin.setForeground(Color.red);
        addemp = new JMenuItem("ADD_EMPLOYEE");
        addroom = new JMenuItem("ADD_ROOM");
        adddriver = new JMenuItem("ADD_DRIVER");
        admin.add(addemp);
        admin.add(addroom);
        admin.add(adddriver);
        mb.add(admin);
        
//        Add events

        reception.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                
            }
        } );
        
        addemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new AddEmployee().setVisible(true);
            }
        });
        
        
         addroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new AddRoom().setVisible(true);
            }
        });
         
         
          adddriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new AddDriver().setVisible(true);
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        setSize(1950, 1090);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
    }
    
    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
    
    
    
}
