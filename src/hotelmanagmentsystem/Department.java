/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagmentsystem;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author nehra
 */
public class Department extends JFrame {
        private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

    public Department()  {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(600, 200, 700, 500);
	setLocation(400, 100);
        contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
		
	table = new JTable();
	table.setBounds(0, 40, 700, 350);
	contentPane.add(table);
        
        JButton btnNewButton = new JButton("Load Data");
        btnNewButton.setBounds(170, 410, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select *from department;";
                try {
                    Conn con = new Conn();
                    ResultSet rs = con.s.executeQuery(sql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                        
            }
        });
    
        JButton btnback = new JButton("Back");
        btnback.setBounds(380, 410, 120, 30);
        btnback.setBackground(Color.BLACK);
        btnback.setForeground(Color.WHITE);
        contentPane.add(btnback);
        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new Reception().setVisible(true);
                    setVisible(false);
                          
            }
        });
    
        lblNewLabel = new JLabel("Department");
		lblNewLabel.setBounds(180, 11, 105, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Budget");
		lblNewLabel_1.setBounds(480, 11, 75, 14);
		contentPane.add(lblNewLabel_1);
                
                getContentPane().setBackground(Color.WHITE);
    
    
    }
    
    
    public static void main(String[] args) {
        new Department().setVisible(true);
    }
 
}
