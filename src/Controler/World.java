package Controler;

import java.awt.Dimension;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JButton;

import View.ButtonPlay;
import View.ButtonSmile;
import View.GamePanel;
import View.LabelNumber;

@SuppressWarnings("unused")
public class World {
	private Random rd;
	
	private ButtonPlay[][] arrbtn;
	
	private ButtonSmile buttonsmile;
	
	private LabelNumber lbTime, lbBoom; //min = -1
	
	private int  arrmin[][];
	
	private boolean arrcheck[][];
	
	private boolean emplement, isEnd;
	
	private boolean arrco[][];
	
	private boolean comin;
	
	private int co = 0;
	

	private int boom;

	private int w, h;
	
	private GamePanel game;
	
	public World(int boom, int w, int h, GamePanel game) {
		this.game = game;
		arrbtn = new ButtonPlay[w][h];
		arrmin = new int [w][h];
		arrcheck = new boolean[w][h];
		arrco = new boolean[w][h];
		this.boom = boom;
		CreateMin(boom, w, h);
		dienso();
		System.out.println(boom);
		for (int i = 0; i < arrmin.length; i++) {
			for (int j = 0; j < arrmin[i].length; j++) {
				System.out.print(arrmin[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean open(int i, int j) {
		if(!emplement) {
			if(!arrcheck[i][j] ) {
				if(arrmin[i][j] == 0) {
					arrcheck[i][j] = true;
					arrbtn[i][j].setNumber(0);
					arrbtn[i][j].repaint();
					if(CheckWin(boom)) {
						isEnd = true;
						return false;
					}
					for (int l = i - 1; l <= i + 1; l++) {
						for (int k = j - 1; k <= j + 1; k++) {
							if(l >= 0 && l <= arrmin.length - 1 && k >= 0 && k <= arrmin[i].length - 1) {
								if(!arrcheck[l][k]) open(l, k);
							}
						}
				}
				}else {
					arrcheck[i][j] = true;
					int number = arrmin[i][j];
					
					if(number != -1) {
						arrbtn[i][j].setNumber(number);
						arrbtn[i][j].repaint();
						if(CheckWin(boom)) {
							isEnd = true;
							return false;
						}
						return true;
					}
			}
			if(arrmin[i][j] == -1) {
				arrbtn[i][j].setNumber(11);
				arrbtn[i][j].repaint();
				emplement = true;
				//hien min khi gap
				/*
				 * for (int j2 = 0; j2 < arrcheck.length; j2++) { for (int k = 0; k <
				 * arrcheck[j2].length; k++) { if(arrmin[j2][k] == -1 && !arrcheck[j2][k]) {
				 * arrbtn[j2][k].setNumber(10); arrbtn[j2][k].repaint(); } } }
				 */
				return false;
			}
			else return true;
		}
			return false;
		}
		return false;
	}
	// hien min khoang rong
	/*public boolean ClickDouble(int i, int j) {
		comin = false;
			for (int l = i - 1; l <= i + 1; l++) {
				for (int k = j - 1; k <= j + 1; k++) {
					if(l >= 0 && l <= arrmin.length - 1 && k >= 0 && k <= arrmin[i].length - 1) {
						if (!arrco[l][k]) {
							if(arrmin[l][k] == -1) {
								comin = true;
								arrbtn[l][k].setNumber(11);
								arrbtn[l][k].repaint();
								arrcheck[l][k] = true;
							}else {
								arrbtn[l][k].setNumber(arrmin[l][k]);
								arrbtn[l][k].repaint();
								arrcheck[l][k] = true;
							}
						}
					}
				}
			}
			if (comin) {
				for (int j2 = 0; j2 < arrcheck.length; j2++) {
					for (int k2 = 0; k2 < arrcheck[j2].length; k2++) {
						if(arrmin[j2][k2] == -1 && !arrcheck[j2][k2]) {
							arrbtn[j2][k2].setNumber(10); arrbtn[j2][k2].repaint(); 
						 } 
					} 
				}
				return false;
			}
			return true;
		}	
	*/
	
	public void CamCo(int i, int j) {
		if(!arrcheck[i][j]) {
			if(arrco[i][j]) {
				co--;
				arrco[i][j] = false;
				arrbtn[i][j].setNumber(-1);
				arrbtn[i][j].repaint();
				game.getP1().updateLbNumber();
			}else if(co < boom){
				co++;
				arrco[i][j] = true;
				arrbtn[i][j].setNumber(9);
				arrbtn[i][j].repaint();
				game.getP1().updateLbNumber();
			}
		}
	}
	
	public int getBoom() {
		return boom;
	}

	public void setBoom(int boom) {
		this.boom = boom;
	}

	public boolean CheckWin(int boom) {
		int count = 0;
		for (int i = 0; i < arrcheck.length; i++) {
			for (int j = 0; j < arrcheck[i].length; j++) {
				if(!arrcheck[i][j]) count++;
			}
		}
		if(count == boom) return true;
		return false;
	}
	
	public void FullTrue() {
		for (int i = 0; i < arrcheck.length; i++) {
			for (int j = 0; j < arrcheck.length; j++) {
				arrcheck[i][j] = true;
			}
		}
		emplement = true;
	}
	
	public boolean[][] getArrco() {
		return arrco;
	}

	public void setArrco(boolean[][] arrco) {
		this.arrco = arrco;
	}

	public void CreateMin(int boom, int w, int h) {
		rd = new Random();
		while(boom > 0 && boom < w * h) {
			int  x = rd.nextInt(w);
			int  y = rd.nextInt(h);
			if(arrmin[x][y] != -1) {
				arrmin[x][y] = -1;
				boom--;
			}
		}
	}
	
	public void dienso() {
		for (int i = 0;  i < arrmin.length; i++) {
			for (int j = 0; j < arrmin[i].length; j++) {
				int count = 0;
				if(arrmin[i][j] == 0) {
					for (int l = i - 1; l <= i + 1; l++) {
						for (int k = j - 1; k <= j + 1; k++) {
							if(l >= 0 && l <= arrmin.length - 1 && k >= 0 && k <= arrmin[i].length - 1) {
								if(arrmin[l][k] == -1) count++;
							}
						}
					}
					arrmin[i][j] = count;
				}
			}
		}
	}

	public boolean isEmplement() {
		return emplement;
	}

	public void setEmplement(boolean emplement) {
		this.emplement = emplement;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}
	
	public ButtonPlay[][] getArrbtn() {
		return arrbtn;
	}

	public void setArrbtn(ButtonPlay[][] arrbtn) {
		this.arrbtn = arrbtn;
	}

	public ButtonSmile getButtonsmile() {
		return buttonsmile;
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

	public boolean[][] getArrcheck() {
		return arrcheck;
	}

	public void setArrcheck(boolean[][] arrcheck) {
		this.arrcheck = arrcheck;
	}

	public int getCo() {
		return co;
	}

	public void setCo(int co) {
		this.co = co;
	}

	
	
	
	}
