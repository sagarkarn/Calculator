/**
this is for operation for calculator
 * 
 */
package cal;

/**
 * @author sagar
 *
 */
import cal.Standard;
import java.awt.event.*;
public class Calculation implements ActionListener {
	Standard sd;
	Calculation(){
		sd = new Standard();
		for(int i = 0; i < 9; i++) {
			sd.b[i].addActionListener(this);
		}
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		
	}
}