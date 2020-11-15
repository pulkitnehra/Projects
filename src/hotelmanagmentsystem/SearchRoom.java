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

import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author nehra
 */
public class SearchRoom extends JFrame {
    
    Choice c1;
    JCheckBox ch1;
    JButton btnSearch, btnExit;
    JTable t1;
    JPanel contentPane;
    public SearchRoom()  {
        
                setBounds(530, 200, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                setVisible(true);
		
		JLabel lblSearchForRoom = new JLabel("Search For Room");
		lblSearchForRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchForRoom.setBounds(250, 11, 186, 31);
		contentPane.add(lblSearchForRoom);
		
		JLabel lblRoomAvailable = new JLabel("Room Bed Type:");
		lblRoomAvailable.setBounds(50, 73, 96, 14);
		contentPane.add(lblRoomAvailable);
		
		JLabel lblRoomType = new JLabel("Room Number");
		lblRoomType.setBounds(23, 162, 96, 14);
		contentPane.add(lblRoomType);
		
		JLabel lblRoomAvailable_1 = new JLabel("Availability");
		lblRoomAvailable_1.setBounds(175, 162, 120, 14);
		contentPane.add(lblRoomAvailable_1);
		
		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setBounds(458, 162, 46, 14);
		contentPane.add(lblPrice_1);
                
                JLabel l1 = new JLabel("Bed Type");
		l1.setBounds(580, 162, 96, 14);
		contentPane.add(l1);
		
		JCheckBox checkRoom = new JCheckBox("Only display Available");
		checkRoom.setBounds(400, 69, 205, 23);
                checkRoom.setBackground(Color.WHITE);
		contentPane.add(checkRoom);
                
            
        
                c1 = new Choice();
                c1.add("Single Bed");
                c1.add("Double Bed");
                c1.setBounds(153, 70, 120, 20);
		contentPane.add(c1);
                
                btnSearch = new JButton("Search");
                btnSearch.setBounds(200, 400, 120, 30);
                btnSearch.setBackground(Color.BLACK);
                btnSearch.setForeground(Color.WHITE);
		contentPane.add(btnSearch);
                btnSearch.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String roomType = c1.getSelectedItem();
                String st1 = "select *from room where bed_type = '"+roomType+"'";
                String st2 = "select *from room where availability = 'Available' and bed_type = '"+roomType+"'";
                try {
                    Conn con = new Conn();
                    ResultSet rs = con.s.executeQuery(st1);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                    
                    if(checkRoom.isSelected())
                    {
                        rs = con.s.executeQuery(st2);
                        t1.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                    
            }
        });
                
                
                
                
                btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(380, 400, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                
                t1 = new JTable();
		t1.setBounds(0, 187, 700, 300);
		contentPane.add(t1);
		
		JLabel lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(306, 162, 96, 14);
		contentPane.add(lblCleanStatus);

    
    }
    
    public static void main(String[] args) {
        new SearchRoom().setVisible(true);
    }
}
