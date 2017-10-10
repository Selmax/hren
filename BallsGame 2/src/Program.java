import javax.swing.JFrame;


public class Program {

	public static void main(String[] args) {
		JFrame w;
		w = new JFrame("Проверка реакции");
		// 
		w.setSize(1024, 768);
		w.setLocation(0, 0);
		w.setVisible(true);
		//w.setResizable(false);
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		MyPanel p = new MyPanel();
		w.add(p);
		
		w.addKeyListener(p);
		w.revalidate();
		
	}

}
