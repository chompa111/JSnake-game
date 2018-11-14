package x2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class cobra extends JButton implements KeyListener {
	public static cobra instancia= new cobra();
	
	LinkedList <parte> corpo= new LinkedList<parte>(); 
	int velx=1;
	int vely=0;
	boolean temquecrescer=false;
	private cobra(){
		parte cabeca =new parte();
		cabeca.x=10;
		cabeca.y=10;
		
		corpo.add(cabeca);
		this.addKeyListener(this);
	}
	public static cobra getinstancia(){
		return instancia;
	}
	//------------------
	void mover(){
		int futurox=corpo.element().x+velx;
		int futuroy=corpo.element().y+vely;
		int presentex;
		int presentey;
		parte bunda=new parte();
		bunda.x=corpo.getLast().x;
		bunda.y=corpo.getLast().y;
		int bunday=corpo.getLast().y;
		for(parte p:corpo ){
			presentex=p.x;
			presentey=p.y;
			p.x=futurox;
			p.y=futuroy;
			futurox=presentex;
			futuroy=presentey;
		}
		if(temquecrescer){
			temquecrescer  =false;
			corpo.add(bunda);
			
		}
	}
	void mostrarposicoes(){
		for(parte p:corpo ){
			System.out.println(p.x+"coisas");
			System.out.println(p.y);
			
		}	
	}
	boolean temcobraaqui(int X,int Y){
		for(parte p:corpo ){
			if(p.x==X && p.y==Y)return true;
			
		}
		return false;
	}
	int contaconflitos(int X,int Y){
		int resp=0;
		for(parte p:corpo ){
			if(p.x==X && p.y==Y)resp++;
			
		}
		return resp;
	}
	//--------------------
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("perto");
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && velx!=-1){
			
			System.out.println("direita");
			velx=1;
			vely=0;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT && velx!=1){
			velx=-1;
			vely=0;
			
			System.out.println("esquerda");
		}
		if(e.getKeyCode() == KeyEvent.VK_UP && vely!=1){
			velx=0;
			vely=-1;
			
			System.out.println("cima");
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN && vely!=-1){
			velx=0;
			vely=1;
			System.out.println("baixo");
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
