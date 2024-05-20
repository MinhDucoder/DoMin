package View;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

public class LabelNumber extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PanelNotification p;
	
	private String number;

	public LabelNumber(PanelNotification p, String number) {
		this.p = p;
		this.number = number;
		setPreferredSize(new Dimension(78, 46));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(p.getGame().getGameframe().getLoaddt().getListImage().get(String.valueOf(number.charAt(0))), 0, 0, 26, 46, null);
		g.drawImage(p.getGame().getGameframe().getLoaddt().getListImage().get(String.valueOf(number.charAt(1))), 26, 0, 26, 46, null);
		g.drawImage(p.getGame().getGameframe().getLoaddt().getListImage().get(String.valueOf(number.charAt(2))), 52, 0, 26, 46, null);
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
