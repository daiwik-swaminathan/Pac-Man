package pacMan;
import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;
import resources.DrawingBoard;
import theRealPacman.Block;

public class Wall {
	
	public static final int LEFT = 200;
	public static final int RIcanvasHT = 1020;
	public static final int TOP = 40;
	public static final int BOTTOM = 600;
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		
		//canvas.setColor(Color.black);
		
		//canvas.fillRect(200, 40, 900, 560);
		
		canvas.setColor(Color.BLACK);

		for(int x=LEFT+Block.SIZE; x<RIcanvasHT; x+=Block.SIZE){
			canvas.drawLine(x, TOP, x, BOTTOM);
		}
		
		for(int y=TOP+Block.SIZE; y<BOTTOM; y+=Block.SIZE){
			canvas.drawLine(LEFT, y, RIcanvasHT, y);
		}
		
		canvas.drawRect(LEFT, TOP, RIcanvasHT-LEFT, BOTTOM-TOP);
		
		//square 22
		
		canvas.fillRect(600, 300, Block.SIZE, Block.SIZE);
		//square 21
		
		canvas.fillRect(580, 300, Block.SIZE, Block.SIZE);
		//square 23
		
		canvas.fillRect(620, 300, Block.SIZE, Block.SIZE);
		
		//blinky square
		
		canvas.fillRect(600, 280, Block.SIZE, Block.SIZE);
		
		//shrek square
		
		canvas.fillRect(640, 300, Block.SIZE, Block.SIZE);
		
		//??? square
		
		canvas.fillRect(560, 300, Block.SIZE, Block.SIZE);
		
		//maze
		
		int x ;
		int y ;
		
		for(x=500; x<720; x = x + 20){
			canvas.fillRect(x, 260, Block.SIZE, Block.SIZE);
			canvas.fillRect(x, 340, Block.SIZE, Block.SIZE);
			
		}
		
		for(y=280; y<360; y = y + 20){
			canvas.fillRect(500, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(700, y, Block.SIZE, Block.SIZE);
		}
		
		for(x=480; x>180; x = x - 20){
			canvas.fillRect(x, 300, Block.SIZE, Block.SIZE);
		}
		
		for(x=720; x<1020; x = x + 20){
			canvas.fillRect(x, 300, Block.SIZE, Block.SIZE);
		}
		
		for(x=200; x<1020; x = x + 20){
			canvas.fillRect(x, 580, Block.SIZE, Block.SIZE);
		}
		
		for(y=560; y>500; y = y - 20){
			canvas.fillRect(200, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(1000, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(580, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(620, y, Block.SIZE, Block.SIZE);
		}
		
		for(x=200; x<360; x = x + 20){
			canvas.fillRect(x, 520, Block.SIZE, Block.SIZE);
		}
		
		for(x=860; x<1000; x = x + 20){
			canvas.fillRect(x, 520, Block.SIZE, Block.SIZE);
		}
		
		for(x=560; x>480; x = x - 20){
			canvas.fillRect(x, 520, Block.SIZE, Block.SIZE);
		}
		
		for(x=640; x<720; x = x + 20){
			canvas.fillRect(x, 520, Block.SIZE, Block.SIZE);
		}
		
		for(y=520; y>440; y = y - 20){
			canvas.fillRect(340, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(260, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(500, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(700, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(340, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(340, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(840, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(920, y, Block.SIZE, Block.SIZE);
		}
		
		for(x=340; x<860; x = x + 20){
			canvas.fillRect(x, 460, Block.SIZE, Block.SIZE);
		}
		
		for(y=440; y>20; y = y - 20){
			canvas.fillRect(340, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(840, y, Block.SIZE, Block.SIZE);
		}
		
		for(x=260; x>180; x = x - 20){
			canvas.fillRect(x, 460, Block.SIZE, Block.SIZE);
		}
		
		for(y=460; y>380; y = y - 20){
			canvas.fillRect(200, y, Block.SIZE, Block.SIZE);
		}
		
		for(x=200; x<600; x = x + 20){
			canvas.fillRect(x, 400, Block.SIZE, Block.SIZE);
		}
		
		for(y=400; y<460; y = y + 20){
			canvas.fillRect(580, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(620, y, Block.SIZE, Block.SIZE);
		}
		
		for(x=620; x<1020; x = x + 20){
			canvas.fillRect(x, 400, Block.SIZE, Block.SIZE);
		}
		
		for(x=920; x<1020; x = x + 20){
			canvas.fillRect(x, 460, Block.SIZE, Block.SIZE);
		}
		
		for(y=420; y<480; y = y + 20){
			canvas.fillRect(1000, y, Block.SIZE, Block.SIZE);
		}
		
		for(y=360; y<400; y = y + 20){
			canvas.fillRect(500, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(700, y, Block.SIZE, Block.SIZE);
		}
		
		for(x=200; x<600; x = x + 20){
			canvas.fillRect(x, 40, Block.SIZE, Block.SIZE);
		}
		
		for(x=620; x<1020; x = x + 20){
			canvas.fillRect(x, 40, Block.SIZE, Block.SIZE);
		}
		
		for(x=200; x<1020; x = x + 20){
			canvas.fillRect(x, 140, Block.SIZE, Block.SIZE);
		}
		
		for(y=40; y<140; y = y + 20){
			canvas.fillRect(580, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(620, y, Block.SIZE, Block.SIZE);
		}
		
		for(y=60; y<240; y = y + 20){
			canvas.fillRect(200, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(1000, y, Block.SIZE, Block.SIZE);
		}
		
		for(x=200; x<340; x = x + 20){
			canvas.fillRect(x, 220, Block.SIZE, Block.SIZE);
		}
		
		for(x=840; x<1020; x = x + 20){
			canvas.fillRect(x, 220, Block.SIZE, Block.SIZE);
		}
		
		for(y=200; y<260; y = y + 20){
			canvas.fillRect(580, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(620, y, Block.SIZE, Block.SIZE);
		}
		
		for(x=520; x<580; x = x + 20){
			canvas.fillRect(x, 200, Block.SIZE, Block.SIZE);
		}
		
		for(x=620; x<700; x = x + 20){
			canvas.fillRect(x, 200, Block.SIZE, Block.SIZE);
		}
		
		for(y=160; y<220; y = y + 20){
			canvas.fillRect(500, y, Block.SIZE, Block.SIZE);
			canvas.fillRect(700, y, Block.SIZE, Block.SIZE);
		}
		
	}
	
}
