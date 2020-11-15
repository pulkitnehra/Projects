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
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author nehra
 */
public class Employee extends JFrame {

     JTable t1;
     JButton b1,b2;
     JPanel cp;
     JLabel name,age, job, salary, gender, phone, adhar, gmail;
    
    
    public Employee()  {
        cp = new JPanel();
        cp.setBorder(new EmptyBorder(5, 5, 5, 5));
        cp.setLayout(null);
        setContentPane(cp);
    
        t1 = new JTable();
        t1.setBounds(0, 40, 1000, 450);
        cp.add(t1);
        
        
        
        b1 = new JButton("Load Data");
        b1.setBounds(300, 520, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        cp.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c1 = new Conn();
                    String sql = "select *from employee";
                    ResultSet rs = c1.s.executeQuery(sql);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        b2 = new JButton("Back");
        b2.setBounds(500, 520, 120, 30);
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
        
         
         name = new JLabel("Name");
         name.setBounds(41, 11, 46, 14);
         cp.add(name);
         age = new JLabel("Age");
         age.setBounds(159, 11, 46, 14);
         cp.add(age);
         gender = new JLabel("Gender");
         gender.setBounds(273, 11, 46, 14);
         cp.add(gender);
         job = new JLabel("Job");
         job.setBounds(416, 11, 46, 14);
         cp.add(job);
         salary = new JLabel("Salary");
         salary.setBounds(536, 11, 46, 14);
         cp.add(salary);
         phone = new JLabel("Phone");
         phone.setBounds(656, 11, 46, 14);
         cp.add(phone);
         adhar = new JLabel("Aadhar");
         adhar.setBounds(786, 11, 46, 14);
         cp.add(adhar);
         gmail = new JLabel("Gmail");
         gmail.setBounds(896, 11, 46, 14);
         cp.add(gmail);
         
        
        
        setSize(1000, 600);
        setLayout(null);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new Employee().setVisible(true);
    }
 
    
}
