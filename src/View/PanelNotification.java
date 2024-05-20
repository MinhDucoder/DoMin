package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelNotification extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel p11, p12, p13;
	
	private ButtonSmile btnSimle;
	private LabelNumber lbTime, lbBoom;
	private Timer time;
	
	private int Tnow;
	
	private GamePanel game;
	
	public PanelNotification(GamePanel game) {
		
		this.game = game;
		this.btnSimle = game.getWorld().getButtonsmile();
		this.lbTime = game.getWorld().getLbTime();
		this.lbBoom = game.getWorld().getLbBoom();
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLoweredBevelBorder());
		//them cac lable va btn icon
		add(p11 = new JPanel(), BorderLayout.WEST);
		add(p12 = new JPanel(), BorderLayout.EAST);
		add(p13 = new JPanel(), BorderLayout.CENTER);
		
		p11.add(lbBoom = new LabelNumber(this, "000"));
		updateLbNumber();
		p12.add(lbTime = new LabelNumber(this, "000"));
		time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tnow++;
                updateTnow();
            }
			});
		
		p13.add(btnSimle = new ButtonSmile(this));
		btnSimle.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				btnSimle.setTt(ButtonSmile.now);
				btnSimle.repaint();
				
				int option = JOptionPane.showConfirmDialog(null, "Are you play new game!", "You can try!", JOptionPane.YES_NO_CANCEL_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					getGame().getGameframe().setVisible(false);
					new GameFrame(game.getW(), game.getH(), game.getBoom());
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btnSimle.setTt(ButtonSmile.press);
				btnSimle.repaint();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
    	}
	
	public void updateTnow() {
		if(Tnow > 999) {
			lbTime.setNumber("vocung");
		}else {
			String t = String.valueOf(Tnow);
			if(t.length() == 1) {
				lbTime.setNumber("00"  + t);
				
			}else if(t.length() == 2) {
				lbTime.setNumber("0"  + t);
			}else {
				lbTime.setNumber(t);
			}
			lbTime.repaint();
		}
	}
	
	public void updateLbNumber() {
		String boom = String.valueOf(game.getWorld().getBoom() - game.getWorld().getCo());
		if(boom.length() == 1) {
			lbBoom.setNumber("00"  + boom);
			
		}else if(boom.length() == 2) {
			lbBoom.setNumber("0"  + boom);
		}else {
			lbBoom.setNumber("0"  + boom);
		}
		lbBoom.repaint();
	}

	public GamePanel getGame() {
		return game;
	}

	public void setGame(GamePanel game) {
		this.game = game;
	}

	public JPanel getP11() {
		return p11;
	}

	public void setP11(JPanel p11) {
		this.p11 = p11;
	}

	public JPanel getP12() {
		return p12;
	}

	public void setP12(JPanel p12) {
		this.p12 = p12;
	}

	public JPanel getP13() {
		return p13;
	}

	public void setP13(JPanel p13) {
		this.p13 = p13;
	}

	public ButtonSmile getBtnSimle() {
		return btnSimle;
	}

	public void setBtnSimle(ButtonSmile btnSimle) {
		this.btnSimle = btnSimle;
	}

	public LabelNumber getLbTime() {
		return lbTime;
	}

	public void setLbTime(LabelNumber lbTime) {
		this.lbTime = lbTime;
	}

	public LabelNumber getLbBoom() {
		return lbBoom;
	}

	public void setLbBoom(LabelNumber lbBoom) {
		this.lbBoom = lbBoom;
	}

	public Timer getTime() {
		return time;
	}

	public void setTime(Timer time) {
		this.time = time;
	}

	public int getTnow() {
		return Tnow;
	}

	public void setTnow(int tnow) {
		Tnow = tnow;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
