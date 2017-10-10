import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Enemy { //fsdfs

	int hp;
	int x, y;
	int vx, vy;
	int size;
	float h, w;
	boolean visible;
	Color c;
	
	public void update () {
		
		y = (int)(640 - h);
		
		w = w - 0.9f;
		if (w < size) {
			w = size;
		}
		h = h + 0.9f;
		if (h > size) {
			h = size;
		}
		
		
		move(vx, vy);
		mirror();
	}
	
	public void respawn () {
		x = 1200 + new Random().nextInt(400);
		size = 30 + new Random().nextInt(20);
		y = 640 - size;
		h = size;
		w = size;
		visible = true;
		hp  = 100;
	}
	
	public Rectangle getCollider () {
		return new Rectangle(x, y, size, size);
		
	}
	
	public void splash () {
		h = (int)(size / 1.5);
		w = (int)(size * 1.5);
		x = x - size/4;
		
	}
	
	
	
	public void mirror() {
		int width = MyPanel.width, height = MyPanel.height;
		
		if (x < - 2 * size) {
			respawn();
		}
		/*
		if (y < 0) {
			y = 0;
			vy = -vy;
		}
		if ((y + 2 * r )> height) {
			y = height - 2 * r;
			vy = -vy;
		}
		if ((x + 2 * r )> width) {
			x = width - 2 * r;
			vx = -vx;
		}*/
		
		
	}
	
	public Enemy (int x, int y, Color color, int vx, int vy) {
		
		this.vx = vx;
		this.vy = vy;
		
		
		this.y = y;
		
		this.c = color; 

		respawn();
		
		this.x = x;
	
	}
	
	public void move (int deltaX, int deltaY) {
		x = x + deltaX;
		y = y + deltaY;
	}
	
	public void paint (Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, (int)w, (int)h);
	}
	
	
}
