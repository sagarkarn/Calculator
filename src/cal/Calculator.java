package cal;
import cal.Standard;

import javax.swing.border.*;
import cal.CalculatorMenu;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame implements ActionListener, KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Standard s = null;
	CalculatorMenu cm;
	
	JLabel label;
	Font f;
	JButton calculatorMenu;
	Container c;
	JLabel l,l1;
	String result="";
	String str2;
	int o =0;
	Calculator() {
		setLayout(null);
		//s.addKeyListener(this);
		this.addKeyListener(this);
		System.out.println("constructor");
		
		cm = new CalculatorMenu();
		cm.setBounds(0,0,230,590);
		add(cm);
		cm.setVisible(false);
		calculatorMenu = new JButton(new ImageIcon("images\\rsz_1rsz_menu.png"));
		calculatorMenu.setBounds(0, 0, 50, 50);
		calculatorMenu.setFocusable(false);
	//	calculatorMenu.setContentAreaFilled(false);
		calculatorMenu.setBackground(new Color(239,239,239));
		calculatorMenu.setBorder(null);
		add(calculatorMenu);
		calculatorMenu.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me) {
				calculatorMenu.setBackground(new Color(200,200,216));
			}
			public void mouseExited(MouseEvent me) {
				calculatorMenu.setBackground(new Color(239,239,239));
			}
		});
		calculatorMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				cm.setVisible(true);
				
			}
		});
		
		
		
		Font f = new Font("Arial",Font.PLAIN,30);
		label = new JLabel("Standard");
		label.setFont(f);
		label.setBounds(50,0,210,50);
		add(label);
		s = new Standard();
		s.setBounds(0,150,310,402);
		s.setBackground(new Color(239,239,239));
		add(s);
		//pack();
		this.getContentPane().setBackground(new Color(239,239,239));
		setBounds(30,30,310,554);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		setResizable(false);
		
		
		
		/*
		 * 
		 * 
		 */
		l = new JLabel("",JLabel.RIGHT);
		l.setBounds(0,90,290,50);
		l.setFont(f);
		add(l);
		l1 = new JLabel("",JLabel.RIGHT);
		l1.setBounds(0, 40, 290, 50);
		add(l1);
		l.setBorder(new LineBorder(Color.BLUE, 1));
		for(int i = 0; i < 12; i++) {
			s.b[i].addActionListener(this);
		}
		s.backspace.addActionListener(this);
		s.c.addActionListener(this);
		s.ce.addActionListener(this);
		s.addition.addActionListener(this);
		s.substract.addActionListener(this);
		s.multiply.addActionListener(this);
		s.divide.addActionListener(this);
		s.equal.addActionListener(this);
		s.root.addActionListener(this);
		s.oneByX.addActionListener(this);
		s.mod.addActionListener(this);
		s.square.addActionListener(this);
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str1="";
		char ch='n';
		String str = l.getText();
		for(int i = 0; i < 9; i++)
		{
			if(ae.getSource() == s.b[i]) {
				if(str.length() < 16)
					l.setText(l.getText()+String.valueOf(i+1));
			}
		}
		
		if(ae.getSource() == s.b[9])
		{
			String str3 = l.getText();
			
			try {
				ch = str.charAt(0);
				if(ch == '-')
				{
					for(int i = 1; i < str3.length(); i++)
					{
						final char ch1 = str3.charAt(i);
						str1 = str1.concat(String.valueOf(ch1));
						
					}
					l.setText(str1);
				}
				else
				{
					l.setText("-" +str3);
				}
			}
			catch(Exception e) { System.out.println(e);
			}
			
			
		}
		if(ae.getSource() == s.b[10]) {
			l.setText(l.getText()+"0");
		}
		if(ae.getSource() == s.b[11]) {
			boolean bool = true;
			for(int i = 0; i < str.length(); i++) {
				final char ch1 = str.charAt(i);
				if(ch1 == '.') {
				bool = false;
				break;
				}
			}
			if(bool)
				l.setText(str+".");
		}
		if(ae.getSource() == s.addition) {
			input();
			o=1;
			l1.setText(result.concat("+"));
			
			
		}
		if(ae.getSource() == s.substract) {
			input();
			o=2;
			l1.setText(result .concat("-"));
		}
		if(ae.getSource() == s.multiply) {
			input();
			o = 3;
			l1.setText(result.concat("*"));
		}
		if(ae.getSource() == s.divide) {
			input();
			o=4;
			l1.setText(result.concat("/"));
		}
		if(ae.getSource() == s.equal) {
			try {
			str2 = l.getText();
			
			operation();
			l1.setText("");
			l.setText(result);
			o=5;
			}
			catch(Exception e) {}
		}
		if(ae.getSource() == s.backspace) {
			for(int i = 0; i < str.length() - 1; i++) {
				final char ch1 = str.charAt(i);
				str1 = str1.concat(String.valueOf(ch1));
			}
			l.setText(str1);
		}
		if(ae.getSource() == s.c) {
			l.setText("");
			l1.setText("");
			result = "";
			o = 0;
		}
		if(ae.getSource() == s.ce) {
			l.setText("");
		}
		if(ae.getSource() == s.root)
		{
			if(l.getText() != "")
			{
				double num1;
				int num2;
				num1 = Double.parseDouble(l.getText());
				num1 = Math.sqrt(num1);
				num2 = (int)num1;
				if(num1 == num2)
					l.setText(String.valueOf(num2));
				else
					l.setText(String.valueOf(num1));
				
			}
			
		}
		if(ae.getSource() == s.oneByX) {
			if(l.getText() != "")
			{
				double num1 = Double.parseDouble(l.getText());
				num1 = 1/num1;
				l.setText(String.valueOf(num1));
			}
		}
		if(ae.getSource() == s.square)
		{
			if(l.getText() != "")
			{
				double num1;
				int num2;
				num1 = Double.parseDouble(l.getText());
				num1 = num1 * num1;
				num2 = (int)num1;
				if(num1 == num2)
					l.setText(String.valueOf(num2));
				else
					l.setText(String.valueOf(num1));
				
			}
		}
	}
	public void input() {
		if(result == "") {
			result = l.getText();;
			l.setText("");
			
			
		}
		else {
			str2 = l.getText();
			l.setText("");
			operation();
		}
	}
	public void operation() {
		double num1 = Double.parseDouble(result);
		double num2 = Double.parseDouble(str2);
		try {
		switch(o) {
			case 1:
				num1 = num1+num2;
				break;
			case 2:
				num1 = num1-num2;
				break;
			case 3:
				num1 = num1*num2;
				break;
			case 4:
				num1 = num1/num2;
			default:
		}
		}
		catch (Exception e) {JOptionPane.showMessageDialog(this, "cant divide by 0");}
		int num1_1 = (int) num1;
		if(num1_1 == num1) {
			result = String.valueOf(num1_1);	
		}
		else
			result = String.valueOf(num1);
		
		
		
	}

	public static void main(String[] args) throws Exception {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				new Calculator();
			}
		});

	}
	@Override
	public void keyPressed(KeyEvent ke) {
		
		int code = ke.getKeyCode();
		System.out.println(code);
		switch(code) {
		case 49:
		case 50:
		case 51:
		case 52:
		case 53:
		case 54:
		case 55:
		case 56:
		case 57:
		case 48:
			if(l.getText().length() < 16)
			l.setText(l.getText()+(code-48));
			break;
		case 10:
		
			try {
				str2 = l.getText();
				
				operation();
				l1.setText("");
				l.setText(result);
				o=5;
				}
				catch(Exception e) {}
			break;
		case 45:
			input();
			o=2;
			l1.setText(result .concat("-"));
			break;
		case 61:
			input();
			o=1;
			l1.setText(result.concat("+"));
			break;
		case 8:
			String str1="";
			String str = l.getText();
			for(int i = 0; i < str.length() - 1; i++) {
				final char ch1 = str.charAt(i);
				str1 = str1.concat(String.valueOf(ch1));
			}
			l.setText(str1);
			break;
		//case
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent ke) {
		System.out.println(ke.getKeyCode());
		
	}
	void setResult(String str) {
		result="";
		for(int i = 0; i < 16; i++) {
			final char ch = str.charAt(i);
			result = result.concat(String.valueOf(ch));
			
		}
		l.setText(result);
	}

	
}
