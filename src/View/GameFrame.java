package View;

import javax.swing.JFrame;

import Model.LoadData;

public class GameFrame extends JFrame {
	/**
	 * 
	 */
	private LoadData loaddt;
	private int w, h, boom;

	private GamePanel gamepn;
	private static final long serialVersionUID = 1L;

	public GameFrame(int w, int h, int boom) {
		this.w = w;
		this.h = h;
		this.boom = boom;
		loaddt = new LoadData();
		add(gamepn = new GamePanel(w, h, boom, this));
		setIconImage(loaddt.getListImage().get("Title"));
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		add(gamepn);
	}
	
	public static void main(String[] args) {
		new GameFrame(10, 10, 10);
	}
	
	public LoadData getLoaddt() {
		return loaddt;
	}

	public void setLoaddt(LoadData loaddt) {
		this.loaddt = loaddt;
	}
}
