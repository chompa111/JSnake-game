package x2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class pixel extends JButton implements ActionListener {
	ImageIcon padrao,cobra,maca;
	int x,y;
	public pixel(int i,int j){
		padrao=new ImageIcon("padrao.png");
		cobra=new ImageIcon("cobra.png");
		maca=new ImageIcon("maca.png");
		x=i;
		y=j;
		setIcon( padrao);
		this.addActionListener(this);
	}
	void setMaca(){
		setIcon(maca);
	}
	void setCobra(){
		setIcon(cobra);
	}
	void setPadrao(){
		setIcon(padrao);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("pixel");
		
	}

}
