/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagmentsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author nehra
 */
public class UpdateCheck extends JFrame {
    
        private JPanel contentPane;
	private JTextField txt_ID;
	private JTextField txt_Status;
	private JTextField txt_Date;
	private JTextField txt_Paid;
	private JTextField txt_Payment;

        Choice c1, c2;

    public UpdateCheck()  {
        
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 950, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                 getContentPane().setBackground(Color.WHITE);
		
		JLabel lblUpdateCheckStatus = new JLabel("Check-In Details");
		lblUpdateCheckStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateCheckStatus.setBounds(124, 11, 222, 25);
		contentPane.add(lblUpdateCheckStatus);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Images/nine.jpg"));
                JLabel l1 = new JLabel(i1);
                l1.setBounds(450,70,476,270);
                add(l1);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(25, 88, 46, 14);
		contentPane.add(lblNewLabel);
                
                c1 = new Choice();
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(248, 85, 140, 20);
		contentPane.add(c1);
		
		JLabel lblNewLabel_1 = new JLabel("Room Number :");
		lblNewLabel_1.setBounds(25, 129, 107, 14);
		contentPane.add(lblNewLabel_1);
                
               
		
		JLabel lblNewLabel_2 = new JLabel("Name : ");
		lblNewLabel_2.setBounds(25, 174, 97, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Checked-in :");
		lblNewLabel_3.setBounds(25, 216, 107, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Amount Paid (Rs) : ");
		lblNewLabel_4.setBounds(25, 261, 107, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Pending Amount (Rs) : ");
		lblNewLabel_5.setBounds(25, 302, 150, 14);
		contentPane.add(lblNewLabel_5);
                
                 
                txt_ID = new JTextField();
                txt_ID.setBounds(248, 126, 140, 20);
		contentPane.add(txt_ID);
		
		txt_Status = new JTextField();
		txt_Status.setBounds(248, 171, 140, 20);
		contentPane.add(txt_Status);
		txt_Status.setColumns(10);
		
		txt_Date = new JTextField();
		txt_Date.setBounds(248, 216, 140, 20);
		contentPane.add(txt_Date);
		txt_Date.setColumns(10);
		
		txt_Paid = new JTextField();
		txt_Paid.setBounds(248, 258, 140, 20);
		contentPane.add(txt_Paid);
		txt_Paid.setColumns(10);
		
		txt_Payment = new JTextField();
		txt_Payment.setBounds(248, 299, 140, 20);
		contentPane.add(txt_Payment);
		txt_Payment.setColumns(10);
                
                JButton btnCheck = new JButton("Check");
                btnCheck.setBounds(56, 378, 89, 23);
                btnCheck.setBackground(Color.BLACK);
                btnCheck.setForeground(Color.WHITE);
		contentPane.add(btnCheck);
                btnCheck.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     String price = null;
                     int amtPaid ;
                     String deposit = null;
                      Conn c = new Conn();
                     String id2 = c1.getSelectedItem();   
                     String rx = "select *from customer where number = '"+id2+"';";
                     ResultSet rs = c.s.executeQuery(rx);
                     
                     while(rs.next())
                     {
                         txt_ID.setText(rs.getString("room_number"));
                         txt_Status.setText(rs.getString("name"));
                         txt_Date.setText(rs.getString("status"));
                         txt_Paid.setText(rs.getString("deposit"));
                         deposit = rs.getString("deposit");
                     }
                     
                     ResultSet rs1 = c.s.executeQuery("select *from room where room_number = "+txt_ID.getText());
                         while (rs1.next()) {                             
                             price = rs1.getString("price");
                             amtPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                             txt_Payment.setText(Integer.toString(amtPaid));
                         }

                     
                     
                     
                     
                      } catch (Exception ex) {
                     ex.printStackTrace();
                 }
                                          
                     
                     
                
                 
             }
         });
                
                
                JButton btnUpdate = new JButton("Update");
                btnUpdate.setBounds(168, 378, 89, 23);
                btnUpdate.setBackground(Color.BLACK);
                btnUpdate.setForeground(Color.WHITE);
		contentPane.add(btnUpdate);
                btnUpdate.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 
                 try {
                     
                     Conn c = new Conn();
                     String id = c1.getSelectedItem();   
                     String s1 = c1.getSelectedItem();
				String s2 = txt_ID.getText(); //room_number;    
                                String s3 = txt_Status.getText(); //name    
                                String s4 = txt_Date.getText(); //status;    
                                String s5 = txt_Paid.getText(); //deposit    
				
                                c.s.executeUpdate("update customer set room_number = '"+s2+"', name = '"+s3+"', status = '"+s4+"', deposit = '"+s5+"' where number = '"+s1+"'");
                                
                                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                                new Reception().setVisible(true);
                                setVisible(false);
                    
                     
                 } catch (Exception ex) {
                 }
 
             }
         });
                
                
                
                JButton btnExit = new JButton("Exit");
                btnExit.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 new Reception().setVisible(true);
                 setVisible(false);
                 
             }
            });
                btnExit.setBounds(281, 378, 89, 23);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
    
    
    
    
    }
    
        
    public static void main(String[] args) {
        new UpdateCheck().setVisible(true);
    }
    
    
}
