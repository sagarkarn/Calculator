package cal;
import javax.swing.*;
import cal.Standard;

import java.awt.*;
import java.awt.event.*;
public class CalculatorMenu extends JPanel implements MouseListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton standard,scientific,programmer,dataCalculation;
	JButton menu;
	JLabel label;
	Font f;
	Standard s;
	CalculatorMenu() {
		s = new Standard();
		setLayout(null);
		f = new Font("Arial",Font.PLAIN,30);
		menu = new JButton(new ImageIcon("C:\\Users\\sagar\\Downloads\\rsz_1rsz_menu.png"));
		menu.setBounds(0, 0, 50, 50);
		menu.setBorder(null);
		add(menu);
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
			}
		});
		
		menu.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me) {
				menu.setBackground(new Color(200,200,216));
			}
			public void mouseExited(MouseEvent me) {
				menu.setBackground(new Color(210, 212, 216));
			}
		});
		
		
		
		
		standard = new JButton("Standard");
		scientific = new JButton("Scientific");
		programmer = new JButton("Data Calculation");
		standard.setBounds(0,55,230,152);
		scientific.setBounds(0,207,230,152);
		programmer.setBounds(0,359,230,154);
		standard.setFocusable(false);
		scientific.setFocusable(false);
		programmer.setFocusable(false);
		standard.setBackground(new Color(210, 212, 216));
		scientific.setBackground(new Color(210, 212, 216));
		programmer.setBackground(new Color(210, 212, 216));
		programmer.setBorder(null);
		standard.setBorder(null);
		scientific.setBorder(null);
		standard.addMouseListener(this);
		scientific.addMouseListener(this);
		programmer.addMouseListener(this);
		standard.setFont(f);
		scientific.setFont(f);
		programmer.setFont(f);
		standard.addActionListener(this);
		scientific.addActionListener(this);
		programmer.addActionListener(this);
		add(standard);
		add(scientific);
		add(programmer);
		this.setBackground(new Color(210, 212, 216));
		
		label = new JLabel("Standard");
		label.setBounds(50,0,180,50);
		label.setFont(new Font("Arial",Font.PLAIN,20));
		add(label);
		
	}
	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub
		if(me.getSource() == standard)
			standard.setBackground(new Color(200,200,216));
		if(me.getSource() == scientific)
			scientific.setBackground(new Color(200,200,216));
		if(me.getSource() == programmer)
			programmer.setBackground(new Color(200,200,216));
	}
	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		if(me.getSource() == standard)
			standard.setBackground(new Color(210, 212, 216));
		if(me.getSource() == scientific)
			scientific.setBackground(new Color(210, 212, 216));
		if(me.getSource() == programmer)
			programmer.setBackground(new Color(210, 212, 216));
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == standard) {
			s.setVisible(true);
			setVisible(false);
		}
	}

}
