package vid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;

public class notepad implements ActionListener {
	
	JFrame f = new JFrame("Notepad");
	JTextArea ta = new JTextArea();
	
	notepad()
	{
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("File");
		JMenuItem mi1 = new JMenuItem("New");
		JMenuItem mi2 = new JMenuItem("Open");
		JMenuItem mi3 = new JMenuItem("Save");
		JMenuItem mi4 = new JMenuItem("Print");
		
		JMenu m2 = new JMenu("Edit");
		JMenuItem mi5 = new JMenuItem("Cut");
		JMenuItem mi6 = new JMenuItem("Copy");
		JMenuItem mi7 = new JMenuItem("Paste");
		JMenuItem mc = new JMenuItem("Close");
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		m1.add(mi4);
		m2.add(mi5);
		m2.add(mi6);
		m2.add(mi7);
		mb.add(m1);
		mb.add(m2);
		mb.add(mc);
		
		
		mc.addActionListener(this);
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mi6.addActionListener(this);
		mi7.addActionListener(this);
		
		
		f.setJMenuBar(mb);
		f.add(ta);
		f.setVisible(true);
		f.setSize(500,500);
	}
	
	public static void main(String[] args) {
		notepad n = new notepad();
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		String s = arg0.getActionCommand();
		
		if(s.equals("New"))
		{
			ta.setText("");
		}
		else if(s.equals("Close"))
		{
			f.setVisible(false);
		}
		
		else if(s.equals("Cut"))
		{
			ta.cut();
		}
		else if(s.equals("Copy"))
		{
			ta.copy();
		}
		else if(s.equals("Paste"))
		{
			ta.paste();
		}
		else if(s.equals("Print"))
		{
			try {
				ta.print();
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(f, e.getMessage());
			}
			
		}
		
		else if(s.equals("Save"))
		{
			try {
				
				JFileChooser jf = new JFileChooser("d:");
				int r = jf.showSaveDialog(null);
				
				if(r == JFileChooser.APPROVE_OPTION)
				{
					File f1 = new File(jf.getSelectedFile().getAbsolutePath());
					try {
						FileWriter wr = new FileWriter(f1);
						BufferedWriter br = new BufferedWriter(wr);
						
						br.write(ta.getText());
						br.flush();
						br.close();
						
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(f, e.getMessage());
					}
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(f, e.getMessage());
			}
			
		}
		
		else if(s.equals("Open"))
		{
			try {
				
				JFileChooser jf = new JFileChooser("d:");
				int r = jf.showSaveDialog(null);
				
				if(r == JFileChooser.APPROVE_OPTION)
				{
					File f1 = new File(jf.getSelectedFile().getAbsolutePath());
					try {
						String s1 = "", s2 = "";
						FileReader wr = new FileReader(f1);
						BufferedReader br = new BufferedReader(wr);
						
						s2 = br.readLine();
						
						while((s1 = br.readLine())!=null)
						{
							s2 = s2 +"\n" +  s1;
						}
						
						ta.setText(s2);
						
						
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(f, e.getMessage());
					}
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(f, e.getMessage());
			}
			
		}
		
		
		
	}
}
