import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class MyPanel extends JPanel implements ActionListener, KeyListener {

	Painter floor, floor2, floor3, floor4, floor5;
	Painter hill, hill2, hill3, hill4;
	
	Enemy c1, c2;
	Timer t;	
	int time = 8;
	
	Ball player;
	
	int maxEnemies = 30;
	Enemy [] enemies = new Enemy[maxEnemies];
	
	Sprite s;
	
	static int score = 0;
	
	static int width, height;
	
	public MyPanel() {
		
		s = new Sprite("98465342.png");
		
		floor = new Painter("graf.png", 0, 640, 48, 0, 287, 94);
		floor.vx = -1.4f;
		floor2 =  new Painter("graf.png", 0+287, 640, 48, 0, 287, 94);
		floor2.vx = -1.4f;
		floor3 =  new Painter("graf.png", 0+287*2, 640, 48, 0, 287, 94);
		floor3.vx = -1.4f;
		floor4 =  new Painter("graf.png", 0+287*3, 640, 48, 0, 287, 94);
		floor4.vx = -1.4f;
		floor5 =  new Painter("graf.png", 0+287*4, 640, 48, 0, 287, 94);
		floor5.vx = -1.4f;
		hill =  new Painter("graf.png", 0, 640 - 46, 0, 145, 336, 46);
		hill.vx = -0.4f;
		hill2 =  new Painter("graf.png", 0+336, 640 - 46, 0, 145, 336, 46);
		hill2.vx = -0.4f;
		hill3 =  new Painter("graf.png", 0+336*2, 640 - 46, 0, 145, 336, 46);
		hill3.vx = -0.4f;
		hill4 =  new Painter("graf.png", 0+336*3, 640 - 46, 0, 145, 336, 46);
		hill4.vx = -0.4f;
		
		
		
		for (int i = 0; i < maxEnemies; i++) {
			enemies[i] = new Enemy(1500 + i*200, 60, Color.GREEN, -2, 0);
		}
	    
		player = new Ball(250, 600, Color.RED, 0, 0);
		
		c1 = new Enemy (800, 600, Color.YELLOW, -3, 0);
		c2 = new Enemy(1200, 600, Color.BLUE, -2, 0);
		//c2.move(100, 250);
		
		t = new Timer(time, this);
		t.start();
		
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		width = getWidth();
		height = getHeight();
		
		Color black = new Color(52, 176, 218);
		g.setColor(black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		hill.paint(g);
		hill2.paint(g);
		hill3.paint(g);
		hill4.paint(g);
		c1.paint(g);
		c2.paint(g);
		//player.paint(g);
		
		for (int i = 0; i < maxEnemies; i++) {
			enemies[i].paint(g);
		}
		
		
		s.paint(g);
		g.drawLine(0, 640, 1500, 640);
		
		
		g.setFont(new Font("Calibri", 1, 32));
		g.setColor(Color.WHITE);
		g.drawString("Очки: "+score, 10, 40);
		
		floor.paint(g);
		floor2.paint(g);
		floor3.paint(g);
		floor4.paint(g);
		floor5.paint(g);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	
		floor.update(time);
		floor2.update(time);
		floor3.update(time);
		floor4.update(time);
		floor5.update(time);
		hill.update(time);
		hill2.update(time);
		hill3.update(time);
		hill4.update(time);
		c1.update();
		c2.update();
		player.update();
		
		for (int i = 0; i < maxEnemies; i++) {
			enemies[i].update();
			player.intersects(enemies[i]);
		}
		
		player.intersects(c1);
		player.intersects(c2);
		
		s.update();
	
		
		repaint();
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		player.jump();
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
