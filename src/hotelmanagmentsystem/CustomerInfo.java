/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagmentsystem;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author nehra
 */
public class CustomerInfo extends JFrame {
    
    JTable table;
    JLabel id, number, name, gender, country, room, checkstat, deposit;
    JPanel cp;
    JButton load, exit;

    public CustomerInfo()  {
        
        cp = new JPanel();
        setContentPane(cp);
        cp.setBorder(new EmptyBorder(5, 5, 5, 5));
        cp.setLayout(null);
        
         table = new JTable();
         table.setBounds(0, 40, 900, 450);
         cp.add(table);
         id = new JLabel("ID");
         id.setBounds(31, 11, 46, 14);
         cp.add(id);
         number = new JLabel("Number");
         number.setBounds(150, 11, 46, 14);
         cp.add(number);
         name = new JLabel("Name");
         name.setBounds(270, 11, 65, 14);
         cp.add(name);
         gender = new JLabel("Gender");
         gender.setBounds(360, 11, 46, 14);
         cp.add(gender);
         country = new JLabel("Country");
         country.setBounds(480, 11, 46, 14);
         cp.add(country);
         room = new JLabel("Room");
         room.setBounds(600, 11, 46, 14);
         cp.add(room);
         checkstat = new JLabel("Check-in-status");
         checkstat.setBounds(680, 11, 100, 14);
         cp.add(checkstat);
         deposit = new JLabel("Deposit");
         deposit.setBounds(800, 11, 100, 14);
         cp.add(deposit);
        
         load  = new JButton("Load Data");
         load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    Conn c1 = new Conn();
                    String sql = "select *from customer;";
                    ResultSet rs = c1.s.executeQuery(sql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
            }
        });
         load.setBounds(200, 510, 120, 30);
         load.setBackground(Color.BLACK);
         load.setForeground(Color.WHITE);
         cp.add(load);
         
         exit  = new JButton("Exit");
         exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
         
         exit.setBounds(500, 510, 120, 30);
         exit.setBackground(Color.BLACK);
         exit.setForeground(Color.WHITE);
         cp.add(exit);
         
        
        
         
    
        setSize(900, 600);
        setVisible(true);
        
        
    
    }
    
    public static void main(String[] args) {
        new CustomerInfo().setVisible(true);
    }
    
}
