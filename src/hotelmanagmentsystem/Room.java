/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagmentsystem;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author nehra
 */
public class Room extends JFrame {
    
    JPanel cp;
    JLabel  lblAvailability, lblCleanStatus, lblPrice, lblBed, lblroomno;
    JTable t1;
    JButton b1,b2;

    public Room()  {
        
        cp = new JPanel();
        cp.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(cp);
        cp.setLayout(null);
        
        t1 = new JTable();
        t1.setBounds(0, 40, 500, 400);
        cp.add(t1);
        
        b1 = new JButton("Load Data");
        b1.setBounds(50, 520, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        cp.add(b1);
         b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c1 = new Conn();
                    String sql = "select *from room";
                    ResultSet rs = c1.s.executeQuery(sql);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        b2 = new JButton("Back");
        b2.setBounds(250, 520, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        cp.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        
         lblroomno = new JLabel("Room No");
         lblroomno.setBounds(12, 11, 66, 14);
         cp.add(lblroomno);
         lblAvailability = new JLabel("Avaialability");
         lblAvailability.setBounds(109, 11, 76, 14);
         cp.add(lblAvailability);
         lblCleanStatus = new JLabel("Clean Status");
         lblCleanStatus.setBounds(216, 11, 76, 14);
         cp.add(lblCleanStatus);
         lblPrice = new JLabel("Price");
         lblPrice.setBounds(330, 11, 46, 14);
         cp.add(lblPrice);
         lblBed = new JLabel("Bed Type");
         lblBed.setBounds(417, 11, 76, 14);
         cp.add(lblBed);
       
        
//         Adding image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(500, 0, 600, 600);
        add(img);
         
        setSize(1100, 600);
        setLayout(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Room().setVisible(true);
    }
    
    
}
