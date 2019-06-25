package cal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
public class Standard extends JPanel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton b[] = new JButton[12];
	JButton addition,substract,multiply,divide,equal;
	JButton c,ce,backspace;
	JButton mod,root,square,oneByX;
	int x=0,y=156;
	URL url;
	String str2="";
	Standard()
	{
		setLayout(null);
		Font f = new Font("Arial",Font.PLAIN,30);
		
		
		/* creating button 1 to 12
		 * 
		 * where 0-10 button is numerical
		 * &
		 * b[11] button for point
		 * 
		 */
		
		for(int i = 0; i < 12; i++)
		{
			
			
			b[i] = new JButton("surl");
			if(i == 9)
			b[i] = new JButton(new ImageIcon("images\\Webp.net-resizeimage.png"));
			
			if(i < 9) {
				b[i].setText(String.valueOf(i+1));
				
			}
			b[i].setLocation(x,y);
			x += 72;
			if((i+1) % 3 == 0) {
				x = 0;
				y +=52;
			}
			b[i].setFont(f);
			b[i].setSize(70,50);
			b[i].setBackground(new Color(247, 249, 244));
			b[i].setFocusable(false);
			b[i].setBorder(null);
			b[i].addMouseListener(this);
			add(b[i]);
			
		}
		//b[9].setText("0");
		b[10].setText("0");
		b[11].setText(".");
		
		/* creating button for opcode
		 * i.e.
		 * addition
		 * substraction
		 * multiply
		 * divide
		 * &
		 * equal buttom
		 * 
		 * 
		 */
		
		addition = new JButton("+");
		substract = new JButton("-");
		multiply = new JButton("x");
		divide = new JButton("/");
		equal = new JButton("=");
		/*addtion button creation and edition
		 * 
		 */
		addition.setBounds(216,156,70,50);
		addition.setFocusable(false);
		addition.setBorder(null);
		addition.setBackground(new Color(210, 212, 216));
		addition.setFont(f);
		addition.addMouseListener(this);
		add(addition);
		
		/*substraction button creation and edition
		 * 
		 */
		
		substract.setBounds(216,208,70,50);
		substract.setFocusable(false);
		substract.setBorder(null);
		substract.setBackground(new Color(210,212,216));
		substract.setFont(f);
		substract.addMouseListener(this);
		add(substract);
		
		/*multiply buttom creation and edition
		 * 
		 */
		multiply.setBounds(216,260,70,50);
		multiply.setFocusable(false);
		multiply.setBorder(null);
		multiply.setBackground(new Color(210,212,216));
		multiply.setFont(f);
		multiply.addMouseListener(this);
		add(multiply);
		
		/*divide button creation edition
		 * 
		 */
		divide.setBounds(216,104,70,50);
		divide.setFocusable(false);
		divide.setBorder(null);
		divide.setBackground(new Color(210,212,216));
		divide.setFont(f);
		divide.addMouseListener(this);
		add(divide);
		
		/*equal button creation and modification
		 * 
		 */
		equal.setBounds(216,312,70,50);
		equal.setFocusable(false);
		equal.setBorder(null);
		equal.setBackground(new Color(210,212,216));
		equal.setFont(f);
		equal.addMouseListener(this);
		add(equal);
		
		
		c = new JButton("C");
		c.setBounds(0,104,70,50);
		c.setFocusable(false);
		c.setBorder(null);
		c.setBackground(new Color(210,212,216));
		c.addMouseListener(this);
		c.setFont(f);
		add(c);
		
		ce = new JButton("CE");
		ce.setBounds(72, 104, 70, 50);
		ce.setFocusable(false);
		ce.setBorder(null);
		ce.setBackground(new Color(210,212,216));
		ce.addMouseListener(this);
		ce.setFont(f);
		add(ce);
		
		backspace = new JButton(new ImageIcon("images\\Webp.net-resizeimage(1).png"));
		backspace.setBounds(144,104,70,50);
		backspace.setFocusable(false);
		backspace.setBorder(null);
		backspace.setBackground(new Color(210,212,216));
		backspace.addMouseListener(this);
		backspace.setFont(f);
		add(backspace);
		
		mod = new JButton("%");
		mod.setBounds(0,52,70,50);
		mod.setFocusable(false);
		mod.setBorder(null);
		mod.setBackground(new Color(210,212,216));
		mod.setFont(f);
		mod.addMouseListener(this);
		add(mod);
		
		root = new JButton(new ImageIcon("images\\root.png"));
		root.setBounds(72,52,70,50);
		root.setFocusable(false);
		root.setBorder(null);
		root.setBackground(new Color(210,212,216));
		root.addMouseListener(this);
		add(root);
		
		square = new JButton(new ImageIcon("images\\square.png"));
		square.setBounds(144,52,70,50);
		square.setFocusable(false);
		square.setBorder(null);
		square.setBackground(new Color(210,212,216));
		square.addMouseListener(this);
		add(square);
		
		oneByX = new JButton(new ImageIcon("images\\1byx.png"));
		oneByX.setBounds(216,52,70,50);
		oneByX.setFocusable(false);
		oneByX.setBorder(null);
		oneByX.setBackground(new Color(210,212,216));
		oneByX.addMouseListener(this);
		add(oneByX);
		
	}

	@Override
	public void mouseExited(MouseEvent me) {
		for(int i = 0; i < 12; i++)
		{
			if(me.getSource() == b[i])
			{
				b[i].setBackground(new Color(247, 249, 244));
			}
		}
		if(me.getSource() == addition)
		{
			addition.setBackground(new Color(210, 212, 216));
		}
		if(me.getSource() == substract)
		{
			substract.setBackground(new Color(210,212,216));
		}
		if(me.getSource() == multiply)
		{
			multiply.setBackground(new Color(210,212,216));
		}
		if(me.getSource() == divide)
		{
			divide.setBackground(new Color(210,212,216));
		}
		if(me.getSource() == equal)
		{
			equal.setBackground(new Color(210,212,216));
		}
		if(me.getSource() == c)
		{
			c.setBackground(new Color(210,212,216));
		}
		if(me.getSource() == ce)
		{
			ce.setBackground(new Color(210,212,216));
		}
		if(me.getSource() == backspace)
		{
			backspace.setBackground(new Color(210,212,216));
		}
		if(me.getSource() == mod)
		{
			mod.setBackground(new Color(210,212,216));
		}
		if(me.getSource() == square)
		{
			square.setBackground(new Color(210,212,216));
		}
		if(me.getSource() == root)
		{
			root.setBackground(new Color(210,212,216));
		}
		if(me.getSource() == oneByX)
		{
			oneByX.setBackground(new Color(210,212,216));
		}



	}
	@Override
	public void mouseEntered(MouseEvent me) {
		for(int i = 0; i < 12; i++)
		{
			if(me.getSource() == b[i])
			{
				b[i].setBackground(new Color(189,195,204));
			}
		}
		if(me.getSource() == addition)
		{
			addition.setBackground(new Color(99, 134, 206));
		}
		if(me.getSource() == substract)
		{
			substract.setBackground(new Color(99,134,206));
		}
		if(me.getSource() == multiply)
		{
			multiply.setBackground(new Color(99,134,206));
		}
		if(me.getSource() == divide)
		{
			divide.setBackground(new Color(99,134,206));
		}
		if(me.getSource() == equal)
		{
			equal.setBackground(new Color(99,134,206));
		}
		if(me.getSource() == ce)
		{
			ce.setBackground(new Color(99,134,206));
		}
		if(me.getSource() == c)
		{
			c.setBackground(new Color(99,134,206));
		}
		if(me.getSource() == backspace)
		{
			backspace.setBackground(new Color(99,134,206));
		}
		if(me.getSource() == mod)
		{
			mod.setBackground(new Color(99,134,206));
		}
		if(me.getSource() == root)
		{
			root.setBackground(new Color(99,134,206));
		}
		if(me.getSource() == square)
		{
			square.setBackground(new Color(99,134,206));
		}
		if(me.getSource() == oneByX)
		{
			oneByX.setBackground(new Color(99,134,206));
		}
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}


}
