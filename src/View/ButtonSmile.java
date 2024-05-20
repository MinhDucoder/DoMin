package View;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class ButtonSmile extends JButton{
	
	/**
	 * 
	 */
	
	static final int win = 0;
	static final int lose = 1;
	static final int press = 2;
	static final int wow = 3 ;
	static final int now = 4;
	static final long serialVersionUID = 1L;
	private PanelNotification p;
	
	private int tt;
	
	public ButtonSmile(PanelNotification p) {
		this.p = p;
		setPreferredSize(new Dimension(50, 50));
		tt = now;
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		switch (tt) {
		case win:
			g.drawImage(p.getGame().getGameframe().getLoaddt().getListImage().get("Smilewin"),0, 0, getPreferredSize().width,  getPreferredSize().width, null);
			break;
		case lose:
			g.drawImage(p.getGame().getGameframe().getLoaddt().getListImage().get("Smilelose"),0, 0, getPreferredSize().width,  getPreferredSize().width, null);
			break;
		case press:
			g.drawImage(p.getGame().getGameframe().getLoaddt().getListImage().get("Smilepress"),0, 0, getPreferredSize().width,  getPreferredSize().width, null);
			break;
		case wow:
			g.drawImage(p.getGame().getGameframe().getLoaddt().getListImage().get("Smilewow"),0, 0, getPreferredSize().width,  getPreferredSize().width, null);
			break;
		case now:
			g.drawImage(p.getGame().getGameframe().getLoaddt().getListImage().get("Smile"),0, 0, getPreferredSize().width,  getPreferredSize().width, null);
			break;

		default:
			break;
		}
		
	}
	public int getTt() {
		return tt;
	}
	public void setTt(int tt) {
		this.tt = tt;
	}
	

}
