import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Ball {
// dad
	
	int hp;
	float x, y;
	float vx, vy;
	float ay = 0;
	
	float k = 0.25f; // коэффициент потери скорости
	
	int r;
	boolean visible;
	Color c;
	// skjdkka
	public Rectangle getCollider () {
		return new Rectangle((int)x, (int)y, 2 * r, 2 * r);
		
	}
	
	public void intersects (Enemy c) {
		
		Rectangle p = getCollider();
		Rectangle enemy = c.getCollider();
		
		if (p.intersects(enemy)) {
			
			if (vy > 1) {
				
				c.splash();
				MyPanel.score +=(int)vy;
				vy = -vy *0.8f;

			}
			else {
				vy = -2;
				vx = -6;
				MyPanel.score +=(int)vy*20;
				c.respawn();
			}
		}
		
	}
	
	
	
	public void update () {
		y = y + vy;
		vy = vy + ay;
		x = x + vx;
		
		if (y > 640-2*r) {
			y = 640-2*r;
			vy = -vy * k;
		}
		
		if (x > MyPanel.width-2*r) {
			x =  MyPanel.width-2*r;
			vx = -vx * k;
		}
		
		if (x < 0) {
			x = 0;
			vx = -vx * k;
		}
		
	}
	
	public void jump () {
		vy = -9;
		vx = 0.1f;
		ay = 0.32f;
	}
	
	public Ball (int x, int y, Color color, int vx, int vy) {
		
		this.vx = vx;
		this.vy = vy;
		
		this.x = x;
		this.y = y;
		
		this.c = color; 

		r = 30;
		visible = true;
		hp  = 100;
	}

	public void paint (Graphics g) {
		g.setColor(c);
		g.fillOval((int)x, (int)y, r * 2, r * 2);
	}
	
	
}
