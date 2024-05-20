package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("unused")
public class PanelPlayer extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final LayoutManager BorderLayout = null;
	
	private GamePanel game;
	
	private ButtonPlay[][] arrbtn;
	
	public PanelPlayer(GamePanel game) {
		this.game = game;
		
		setLayout(new GridLayout(game.getW(), game.getH()));
		setBorder(BorderFactory.createLoweredBevelBorder());
		
		arrbtn = game.getWorld().getArrbtn();
		for (int i = 0; i < arrbtn.length; i++) {
			for (int j = 0; j < arrbtn.length; j++) {
				add(arrbtn[i][j] = new ButtonPlay(this));
				arrbtn[i][j].addMouseListener(game);
			}
		}
		
	}

	public ButtonPlay[][] getArrbtn() {
		return arrbtn;
	}

	public void setArrbtn(ButtonPlay[][] arrbtn) {
		this.arrbtn = arrbtn;
	}

	public GamePanel getGame() {
		return game;
	}

	public void setGame(GamePanel game) {
		this.game = game;
	}
}
