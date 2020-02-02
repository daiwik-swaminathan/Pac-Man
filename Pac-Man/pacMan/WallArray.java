package pacMan;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import resources.DrawingBoard;
import resources.SoundPlayer;

public class WallArray {
	
	public static boolean allowMovement[][];
	//public static boolean //hasDot[][];
	public static boolean hasBigSpot[][];
	public static int rowNumber;
	public static int columnNumber;
	public static Color color = Color.WHITE;
	public static int radius = 1;
	public static int bigBoyRadius = 5;
	public static int i,j;
	public static int bigBoyFlash = 0;
	public static int bigBoyFlashCounter = 0;
	public static boolean canFlashTL = true;
	public static boolean canFlashTR = true;
	public static boolean canFlashBL = true;
	public static boolean canFlashBR = true;
	public static Image cherry;
	public static Image strawberry;
	public static boolean canHaveCherry = true;
	public static boolean canIncrementCherry = true;
	public static int cherryCounter, cherryCount; 
	public static String scoreText;
	public static String scoreLabel = "Score";
	public static SoundPlayer eatCherry;
	public static SoundPlayer extraLife;
	public static boolean allDotsGone;
	public static boolean canIncreaseLives = true;
		
	public WallArray() {
		cherry = new ImageIcon(Coordinator.RESOURCE_PATH + "cherry2.png").getImage();
		strawberry = new ImageIcon(Coordinator.RESOURCE_PATH + "strawberry.png").getImage();
		eatCherry = new SoundPlayer();
		eatCherry.load(Coordinator.RESOURCE_PATH + "eatCherry.wav");
		extraLife = new SoundPlayer();
		extraLife.load(Coordinator.RESOURCE_PATH + "extraLife.wav");
	//28 by 41 (27 by 40)
	allowMovement = new boolean[28][41];
	////hasDot = new boolean[28][41];
	hasBigSpot = new boolean[28][41];
	
	allowMovement[0][0] = true;
	allowMovement[12][20] = true;
	
	for(int i=0; i<20; i++){
		allowMovement[0][i] = true;
		////hasDot[0][i] = true;
		}
	
	for(int i=21; i<41; i++){
		allowMovement[0][i] = true;
		////hasDot[0][i] = true;
		}
	
	for(int i=0; i<10; i++){
		allowMovement[i][0] = true;
		allowMovement[i][40] = true;
		////hasDot[i][0] = true;
		////hasDot[i][40] = true;
		}
	
	for(int i=0; i<5; i++){
		allowMovement[i][7] = true;
		allowMovement[i][19] = true;
		allowMovement[i][21] = true;
		allowMovement[i][32] = true;
		////hasDot[i][7] = true;
		////hasDot[i][19] = true;
		////hasDot[i][21] = true;
		////hasDot[i][32] = true;
		}
	
	for(int i=0; i<40; i++){
		allowMovement[5][i] = true;
		////hasDot[5][i] = true;
		}
	
	for(int i=0; i<25; i++){
		allowMovement[i][7] = true;
		allowMovement[i][32] = true;
		////hasDot[i][7] = true;
		////hasDot[i][32] = true;
		}
	
	for(int i=0; i<8; i++){
		allowMovement[9][i] = true;
		////hasDot[9][i] = true;
		}
	
	for(int i=32; i<41; i++){
		allowMovement[9][i] = true;
		////hasDot[9][i] = true;
		}
	
	for(int i=5; i<9; i++){
		allowMovement[i][15] = true;
		allowMovement[i][25] = true;
		////hasDot[i][15] = true;
		////hasDot[i][25] = true;
		}
	
	for(int i=15; i<20; i++){
		allowMovement[8][i] = true;
		//hasDot[8][i] = true;
		}
	
	for(int i=21; i<26; i++){
		allowMovement[8][i] = true;
		//hasDot[8][i] = true;
		}
	
	for(int i=8; i<11; i++){
		allowMovement[i][19] = true;
		allowMovement[i][21] = true;
		//hasDot[i][19] = true;
		//hasDot[i][21] = true;
		}
	
	for(int i=15; i<26; i++){
		allowMovement[11][i] = true;
		allowMovement[15][i] = true;
		//hasDot[11][i] = true;
		//hasDot[15][i] = true;
		}
	
	for(int i=11; i<18; i++){
		allowMovement[i][15] = true;
		allowMovement[i][25] = true;
		//hasDot[i][15] = true;
		//hasDot[i][25] = true;
		}
	
	for(int i=0; i<16; i++){
		allowMovement[13][i] = true;
		//hasDot[13][i] = true;
		}
	
	for(int i=25; i<41; i++){
		allowMovement[13][i] = true;
		//hasDot[13][i] = true;
		}
	
	for(int i=0; i<20; i++){
		allowMovement[18][i] = true;
		//hasDot[18][i] = true;
		}
	
	for(int i=21; i<41; i++){
		allowMovement[18][i] = true;
		//hasDot[18][i] = true;
		}
	
	for(int i=18; i<22; i++){
		allowMovement[i][0] = true;
		allowMovement[i][19] = true;
		allowMovement[i][21] = true;
		allowMovement[i][40] = true;
		//hasDot[i][0] = true;
		//hasDot[i][19] = true;
		//hasDot[i][21] = true;
		//hasDot[i][40] = true;
		}
	
	for(int i=7; i<33; i++){
		allowMovement[21][i] = true;
		//hasDot[21][i] = true;
		}
	
	for(int i=0; i<4; i++){
		allowMovement[21][i] = true;
		//hasDot[21][i] = true;
		}
	
	for(int i=36; i<41; i++){
		allowMovement[21][i] = true;
		//hasDot[21][i] = true;
		}
	
	for(int i=21; i<25; i++){
		allowMovement[i][3] = true;
		allowMovement[i][15] = true;
		allowMovement[i][25] = true;
		allowMovement[i][36] = true;
		//hasDot[i][3] = true;
		//hasDot[i][15] = true;
		//hasDot[i][25] = true;
		//hasDot[i][36] = true;
		}
	
	for(int i=0; i<8; i++){
		allowMovement[24][i] = true;
		//hasDot[24][i] = true;
		}
	
	for(int i=32; i<41; i++){
		allowMovement[24][i] = true;
		//hasDot[24][i] = true;
		}
	
	for(int i=21; i<26; i++){
		allowMovement[24][i] = true;
		//hasDot[24][i] = true;
		}
	
	for(int i=15; i<20; i++){
		allowMovement[24][i] = true;
		//hasDot[24][i] = true;
		}
	
	for(int i=24; i<28; i++){
		allowMovement[i][0] = true;
		allowMovement[i][19] = true;
		allowMovement[i][21] = true;
		allowMovement[i][40] = true;
		//hasDot[i][0] = true;
		//hasDot[i][19] = true;
		//hasDot[i][21] = true;
		//hasDot[i][40] = true;
		}
	
	for(int i=0; i<41; i++){
		allowMovement[27][i] = true;
		//hasDot[27][i] = true;
		}
	
	//20, 15
	//hasDot[15][20] = false;
	//big dot spots
	
	//hasDot[0][0] = true;
	//hasDot[0][40] = true;
	//hasDot[27][0] = true;
	//hasDot[27][40] = true;
	//big dots here
	hasBigSpot[0][0] = true;
	hasBigSpot[0][40] = true;
	hasBigSpot[27][0] = true;
	hasBigSpot[27][40] = true;
	//ghost box area dots
	hasBigSpot[12][20] = true;
	hasBigSpot[13][20] = true;
	hasBigSpot[13][19] = true;
	hasBigSpot[13][21] = true;
	hasBigSpot[13][22] = true;
	hasBigSpot[13][18] = true;
	//pacman spawn spot
	hasBigSpot[15][20] = true;
	/*
	if(//hasDot[0][0]==false) hasBigSpot[0][0] = false;
	if(//hasDot[0][40]==false) hasBigSpot[0][40] = false;
	if(//hasDot[27][0]==false) hasBigSpot[27][0] = false;
	if(//hasDot[27][40]==false) hasBigSpot[27][40] = false;
	*/
	//column number first, then row number 
	 for(int i=0; i<28; i++){
			for(int j=0; j<41; j++){
			//System.out.print("(" + allowMovement[i][j]+" " + i + ',' + j + ")");
				}
		//System.out.println();
			} 
	 /*
	 for(int i=0; i<28; i++){
			for(int j=0; j<41; j++){
			System.out.print("(" + //hasDot[i][j]+" " + i + ',' + j + ")");
				}
		System.out.println();
			} 
	*/
	}
	
	public static void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(Color.BLACK);
		canvas.fillRect(1050, 40, 286, 561);
		canvas.setColor(color);
		if(bigBoyFlash%10==0 && bigBoyFlashCounter<5){
			bigBoyFlashCounter++;
		}
		else {
			bigBoyFlash++;
			bigBoyFlashCounter = 0;
		}
		
		 for(i=0; i<28; i++){
				for(j=0; j<41; j++){
					//System.out.println("canFlash is " + canFlash);
					if(i==0 && j==0 && hasBigSpot[i][j]==true && bigBoyFlash%10==0 && canFlashTL){
						//System.out.println("now in the block, canFlash is " + canFlash);
						canvas.fillOval(j*20+200+5, i*20+40+5, 2*bigBoyRadius, 2*bigBoyRadius);
					}
					//System.out.println("canFlashTR is " + canFlashTR);
					if(i==0 && j==40 && hasBigSpot[i][j]==true && bigBoyFlash%10==0 && canFlashTR){
						//System.out.println("now in the block, canFlash is " + canFlashTR);
						canvas.fillOval(j*20+200+5, i*20+40+5, 2*bigBoyRadius, 2*bigBoyRadius);
					}
					
					if(i==27 && j==0 && hasBigSpot[i][j]==true && bigBoyFlash%10==0 && canFlashBL){
						canvas.fillOval(j*20+200+5, i*20+40+5, 2*bigBoyRadius, 2*bigBoyRadius);
					}
					
					if(i==27 && j==40 && hasBigSpot[i][j]==true && bigBoyFlash%10==0 && canFlashBR){
						canvas.fillOval(j*20+200+5, i*20+40+5, 2*bigBoyRadius, 2*bigBoyRadius);
					}
					
					
					/*
					if(//hasDot[i][j]==true) {
						canvas.fillOval(j*20+200+9, i*20+40+9, 2*radius, 2*radius);
					}
				*/
					if(hasBigSpot[i][j]==false) {
						canvas.fillOval(j*20+200+9, i*20+40+9, 2*radius, 2*radius);
					}
					}
			
				} 
		 if(Pacman.score>=10000 && canIncreaseLives) {
			 extraLife.play();
			 Coordinator.gameOverCounter--;
			 canIncreaseLives = false;
		 }
		
		 if(Coordinator.levelCount==0)board.getCanvas().drawImage(cherry, 1170, 380, 40, 40, board);
		 if(Coordinator.levelCount==1)board.getCanvas().drawImage(strawberry, 1170, 380, 40, 40, board);
		 	scoreText += Pacman.score;
			canvas.setPaint(Color.YELLOW);
			canvas.setFont(new Font("TimesRoman", Font.PLAIN, 30)); //20
			if(Coordinator.gameOverCounter==0){
				canvas.fillArc(1150, 290, 30, 30, 30, 300);
				canvas.fillArc(1205, 290, 30, 30, 30, 300);
			}
			if(Coordinator.gameOverCounter==1){
				canvas.fillArc(1150, 290, 30, 30, 30, 300);
			}
			//if(Coordinator.levelCount==0) canvas.drawString("Level 1", 1150, 150);
			//if(Coordinator.levelCount==1) canvas.drawString("Level 2", 1150, 150);
			canvas.drawString("Level "+(Coordinator.levelCount+1), 1150, 150);
			canvas.drawString("Lives", 1160, 250);
			canvas.drawString(scoreLabel, 1130, 500);//Change
			canvas.drawString(scoreText, 1220, 500);//Change
			scoreText = "";
			if(canHaveCherry){
				if(cherryCount==0 && cherryCounter==0){
					cherryCounter = (int)(Math.random()*1000+1000);
				}
				if(cherryCount!=cherryCounter && canIncrementCherry) cherryCount++;
				if(cherryCount==cherryCounter) {
					canIncrementCherry = false;
					if(Coordinator.levelCount==0)board.getCanvas().drawImage(cherry, 600, 340, 20, 20, board);
					if(Coordinator.levelCount==1)board.getCanvas().drawImage(strawberry, 600, 340, 20, 20, board);
					if(Pacman.x==580 && Pacman.y==340 && Pacman.movingRight){
						eatCherry.play();
						if(Coordinator.levelCount==0)Pacman.score += 100;
						if(Coordinator.levelCount==1)Pacman.score += 300;
						canHaveCherry = false;
					}
					if(Pacman.x==620 && Pacman.y==340 && Pacman.movingLeft){
						eatCherry.play();
						if(Coordinator.levelCount==0)Pacman.score += 100;
						if(Coordinator.levelCount==1)Pacman.score += 300;
						canHaveCherry = false;
					}
				}
			}
			
			
				} 
			
		}
	
	
	 
	

