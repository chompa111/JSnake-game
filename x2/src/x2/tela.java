package x2;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class tela extends JFrame {
	int macax=15;
	int macay=10;
	cobra cobrinha=cobra.getinstancia();
	public static tela instancia=new tela();
	public static final int ALTURA=40;
	public static final int LARGURA=40;
	pixel pixels [][] = new pixel[ALTURA][LARGURA];
	JPanel p1= new JPanel(new GridLayout(1,2));
	JPanel p2=new JPanel();
	JPanel p= new JPanel();
	public static tela getinstancia(){
		return instancia;
	}
	private tela(){
		
		 p.setLayout(new GridLayout(ALTURA,LARGURA));
		setSize(1600,800);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		 for(int i=0; i<LARGURA;i++){
			 for(int j=0;j<ALTURA;j++){
				pixels[i][j]= new pixel(i,j); 
			 }
		 }
		 
		 for(int i=0; i<LARGURA;i++){
			 for(int j=0;j<ALTURA;j++){
				p.add(pixels[j][i]); 
			 }
		 }
		 p1.add(p);
		 p2.add(cobrinha);
		 p1.add(p2);
		 add(p1);
		 setVisible(true);
	}
	void testamorte(){
		for(parte p:cobrinha.corpo ){
			if(cobrinha.contaconflitos(p.x, p.y)>1){
				JOptionPane.showMessageDialog(null, "perdeu, otario");
				System.exit(0);	
				
			}
		}
		
		
	}
	boolean comeu(){
		for(parte p:cobrinha.corpo ){
			if(p.y==macay && macax==p.x){
				cobrinha.temquecrescer=true;
				int randomx=(int)((LARGURA)*(Math.random()));
				int randomy=(int)((ALTURA)*(Math.random()));
				while(cobrinha.temcobraaqui(randomx, randomy)){
					 randomx=(int)((LARGURA)*(Math.random()));
					randomy=(int)((ALTURA)*(Math.random()));
				};
				macax=randomx;
				macay=randomy;
				return true;
			}
			
		}
		return false;
		
		
	}
	void mostramaca(){
		pixels[macax][macay].setMaca();
	}
	void mostracobra(){
		for(parte p:cobrinha.corpo ){
			try{
			pixels[p.x][p.y].setCobra();
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "perdeu, otario");
				System.exit(0);
			}
		}
	}
	void limpar(){
		for(int i=0; i<LARGURA;i++){
			 for(int j=0;j<ALTURA;j++){
				pixels[i][j].setPadrao(); 
			 }
		 }
		
	}
	 public static void main(String []coisas){
		 tela t=tela.getinstancia();
		 try{
			 Thread.sleep(5000);
			}catch(Exception e){}
		
		while(true){
		t.limpar();
		 t.mostramaca();
		t.mostracobra();
		try{
		 Thread.sleep(80);
		}catch(Exception e){}
		
		 t.cobrinha.mover();
		 t.comeu();
		 t.testamorte();
		 
		}

	 }
	
}
