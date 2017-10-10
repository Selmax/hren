import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Painter {

	Image body;
	float x = 100, y = 100;
	float vx = -1;
	
	Rectangle frame;
	
	int timePerFrame = 50;
	int time = 0;
	
	public void update(int ms) {
		
		x = x + vx;
		
		if (x <= -frame.getWidth()) {
			x = 1024;
		}
	
	}	
	public void paint (Graphics g) {
	
		g.drawImage(	body,
						(int)x,
						(int)y,
						(int)(x + frame.getWidth()),
						(int)(y + frame.getHeight()),
						(int)frame.getX(),
						(int)frame.getY(),
						(int)(frame.getX() + frame.getWidth()),
						(int)(frame.getY() + frame.getHeight()),
				
						null);
	}
	
	public Painter (String name, float X, float Y, int b, int c,  int width, int height) {
		
		frame = new Rectangle(b, c, width, height);
		
		x = X;
		y = Y;
		
		File f = new File (name);
		try {
			body = ImageIO.read(f );
		} catch (IOException e) {
			System.out.println("Ошибка загрузки картинки");
		}
		
	}
	
	
}
