import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class Sprite {
	double x = 500; // Что это?
	
	double y = 700;
	double speed=0.5;
	int vx = 1;
	int vy = 0;
	Image img;
   
	public Sprite(String fileName) {
		File f = new File(fileName);
		try {
			img = ImageIO.read(f);
		
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Êàðòèíêà "+fileName+"íåäîñòóïíà.\nÏðîãðàìà áóäåò çàêðûòà.");
		    System.exit(0);
		}
    }
	public void paint (Graphics canvas) {
		canvas.drawImage(img, (int)x, (int)y, null);
	}
    public void update () {
    	x = x + vx*speed;
    	y = y + vy*speed;
    }
    
}
