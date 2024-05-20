package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controler.World;

public class GamePanel extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private World world;
	
	private int w, h, boom;
	
	private PanelPlayer p2;
	
	private PanelNotification p1;
	
	private GameFrame gameframe;
	
	public GamePanel(int w, int h,int boom, GameFrame gameframe) {
		this.w = w;
		this.h = h;
		this.boom = boom;
		this.gameframe = gameframe;
		world = new World(boom, w, h, this);
		setLayout(new BorderLayout());
		
		add(p1 = new PanelNotification(this), BorderLayout.NORTH);
		
		//tao pannel center 
		add(this.p2 = new PanelPlayer(this), BorderLayout.CENTER);
		p2.setBorder(BorderFactory.createLoweredBevelBorder());
		//ban do tro choi
		
	}


	public GameFrame getGameframe() {
		return gameframe;
	}


	public void setGameframe(GameFrame gameframe) {
		this.gameframe = gameframe;
	}


	public World getWorld() {
		return world;
	}


	public void setWorld(World world) {
		this.world = world;
	}


	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		ButtonPlay[][] arrbtn = p2.getArrbtn();
		for (int i = 0; i < arrbtn.length; i++) {
			for (int j = 0; j < arrbtn[i].length; j++) {
				if(e.getButton() == 1 && e.getSource() == arrbtn[i][j] && !world.getArrco()[i][j]) {
					if(!getP1().getTime().isRunning()) {
						getP1().getTime().start();
					}
					
					if(!world.open(i, j)) {
						if(world.isEmplement()) {
							getP1().getTime().stop();
							int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn chơi lại không!", getName(), JOptionPane.YES_NO_OPTION);
							if(option == JOptionPane.YES_OPTION) {
								getP1().getTime().restart();
								gameframe.setVisible(false);
								new GameFrame(w, h, boom);
							}else {
								world.FullTrue();
							}
						}else if (world.isEnd()) {
							getP1().getTime().stop();
							int option = JOptionPane.showConfirmDialog(this, "Bạn đã thắng!Bạn có muốn chơi lại không!", getName(), JOptionPane.YES_NO_OPTION);
							if(option == JOptionPane.YES_OPTION) {
								getP1().getTime().restart();
								gameframe.setVisible(false);
								new GameFrame(w, h, boom);
							}else {
								world.FullTrue();
							}
						}
						/*
						if (e.getClickCount() == 2 && e.getSource() == arrbtn[i][j] && world.getArrcheck()[i][j]) {
							if(!world.ClickDouble(i, j)) {
								int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn chơi lại không!", getName(), JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION) {
									gameframe.setVisible(false);
									new GameFrame(w, h, boom);
								}else {
									world.FullTrue();
								}
							}
						}
						*/
					}
				}
				//cam co khi nhan chuot phai
				
				else if(e.getButton() == 3 && e.getSource() == arrbtn[i][j]) {
				   	world.CamCo(i, j);
				 }
				 
			}
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public PanelPlayer getP2() {
		return p2;
	}


	public void setP2(PanelPlayer p2) {
		this.p2 = p2;
	}


	public PanelNotification getP1() {
		return p1;
	}


	public void setP1(PanelNotification p1) {
		this.p1 = p1;
	}


	public int getBoom() {
		return boom;
	}


	public void setBoom(int boom) {
		this.boom = boom;
	}
	
	
}
