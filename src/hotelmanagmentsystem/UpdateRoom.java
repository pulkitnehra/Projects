/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagmentsystem;


import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

/**
 *
 * @author nehra
 */
public class UpdateRoom extends JFrame {
        Connection conn = null;
        PreparedStatement pst = null;
	private JTextField txt_Ava;
	private JTextField txt_Status;
	private JTextField txt_Room;

        Choice c1;
        JLabel title, gid, avail, cleanstat, roomno;
        
        JPanel cp;
    public UpdateRoom()   {
        
        cp = new JPanel();
        cp.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(cp);
        cp.setLayout(null);
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Images/seventh.jpg"));
        Image i3 = i1.getImage().getScaledInstance(550, 250,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(400,80,600,250);
        add(l1);
        
        JLabel lblUpdateRoomStatus = new JLabel("Update Room Status");
        lblUpdateRoomStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUpdateRoomStatus.setBounds(85, 11, 206, 34);
        cp.add(lblUpdateRoomStatus);
        
        JLabel lblRoomId = new JLabel("Room Number:");
	lblRoomId.setBounds(27, 133, 100, 14);
	cp.add(lblRoomId);
        
        JLabel lblNewLabel = new JLabel("Guest ID:");
        lblNewLabel.setBounds(27, 87, 90, 14);
        cp.add(lblNewLabel);
        c1 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from customer;");
            while(rs.next())
            {
                c1.add(rs.getString("number"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
         c1.setBounds(160, 84, 140, 20);
         cp.add(c1);
        
        JLabel lblID = new JLabel("Guest ID:");
        lblID.setBounds(27, 87, 90, 14);
        cp.add(lblID);
        JLabel lblAvailable = new JLabel("Availability:");
        lblAvailable.setBounds(27, 187, 90, 14);
        cp.add(lblAvailable);
        JLabel lblCleanStat = new JLabel("Clean Status:");
        lblCleanStat.setBounds(27, 240, 90, 14);
        cp.add(lblCleanStat);
        
        txt_Ava = new JTextField();
        txt_Ava.setBounds(160, 184, 140, 20);
        cp.add(txt_Ava);
        txt_Ava.setColumns(10);
        txt_Status = new JTextField();
        txt_Status.setBounds(160, 237, 140, 20);
        cp.add(txt_Status);
        txt_Status.setColumns(10);
        txt_Room = new JTextField();
        txt_Room.setBounds(160, 130, 140, 20);
        cp.add(txt_Room);
        txt_Room.setColumns(10);
        
        
        JButton b1 = new JButton("Update");
        b1.setBounds(60, 355, 89, 23);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        cp.add(b1);
        b1.addActionListener(new ActionListener() {
           @Override
    public void actionPerformed(ActionEvent ae) {
        try {
        Conn cs = new Conn();
        String sql = "update room set clean_status = '"+txt_Status.getText()+"' where room_number = '"+txt_Room.getText()+"' ;";
        cs.s.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Status Updated Successfully");
        
        } catch (Exception e) {
        e.printStackTrace();
        }       
            }
        });
        
        
        JButton b2 = new JButton("Check");
        b2.setBounds(120, 315, 89, 23);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        cp.add(b2);
        b2.addActionListener(new ActionListener() {
           @Override
    public void actionPerformed(ActionEvent ae) {
        try {
        Conn    cs = new Conn();
        String s1 = c1.getSelectedItem();
        ResultSet rs = cs.s.executeQuery("select *from customer where number = "+s1);
        while(rs.next())
        {
            txt_Room.setText(rs.getString("room_number"));
        }
        
        
        } catch (Exception ex) {
        ex.printStackTrace();
        }
        
        
         try{
                                Conn c  = new Conn();
                                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = "+txt_Room.getText());
                                while(rs2.next()){
                                    txt_Ava.setText(rs2.getString("availability")); 
                                    txt_Status.setText(rs2.getString("clean_status"));
                                }
                            }catch(Exception ee){
                                ee.printStackTrace();
        }
        }
        });
        
        
         JButton btnExit = new JButton("Back");
         btnExit.setBounds(180, 355, 89, 23);
        btnExit.setForeground(Color.WHITE);
        btnExit.setBackground(Color.BLACK);
        cp.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
        
        
        
                
                
        setSize(1000, 450);
        setLayout(null);
        setVisible(true);
       
    }
    
    public static void main(String[] args) {
        new UpdateRoom().setVisible(true);
    }
    
    
}
