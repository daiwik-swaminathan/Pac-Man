package pacMan;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;

import jrJava.brickBuster.BrickManager;
import resources.DrawingBoard;
import resources.SoundPlayer;
import resources.Timer;

public class Coordinator {

	public static int screenWidth = 1400;
	public static int screenHeight = 680; 
	public static int pauseTime = 17;
	public static final String RESOURCE_PATH = "pacMan/imagesAndSounds/";
	public static boolean canPause = true;
	public static int firstPause = 4000;
	public static SoundPlayer bgSound;
	public static SoundPlayer ghostDangerBG;
	public static SoundPlayer nextLevel;
	public static int deadCounter = 0;
	public static int gameOverCounter = 0;
	public static int pinkyCounter = 0;
	public static int inkyCounter = 0;
	public static int clydeCounter = 0;
	public static int blueGhostCounter = 0;
	public static boolean blinkyBypass = false;
	public static boolean blinkyRandomBypass = false;
	public static boolean pinkyBypass = false;
	public static boolean pinkyRandomBypass = false;
	public static boolean inkyBypass = false;
	public static boolean inkyRandomBypass = false;
	public static boolean clydeBypass = false;
	public static boolean clydeRandomBypass = false;
	public static int blinkyFirstBypass = 0;
	public static boolean firstPlayed = true;
	public static boolean firstEatPauseBlinky = true;
	public static boolean firstEatPauseClyde = true;
	public static boolean firstEatPauseInky = true;
	public static boolean firstEatPausePinky = true;
	public static boolean firstEatPauseShrek = true;
	public static boolean firstCaught = true;
	public static int winCount;
	public static int levelCount;
	
	public static void main(String[] args) {
		DrawingBoard board = new DrawingBoard(screenWidth, screenHeight);
		Graphics2D canvas = board.getCanvas();
		Timer timer = new Timer();
		WallArray array = new WallArray();
		//200, 40
		Pacman pacman = new Pacman();
		Wall wall = new Wall();
		
		SoundPlayer siren = new SoundPlayer();
		siren.load(RESOURCE_PATH + "siren.wav");
		
		ghostDangerBG = new SoundPlayer();
		ghostDangerBG.load(RESOURCE_PATH + "ghostDangerBG.wav");
		
		nextLevel = new SoundPlayer();
		nextLevel.load(RESOURCE_PATH + "nextLevel.wav");
		
		bgSound = new SoundPlayer();
		bgSound.load(RESOURCE_PATH + "Pacman_Sound_effect.wav");
		
		SoundPlayer caughtByPacmanBG = new SoundPlayer();
		caughtByPacmanBG.load(RESOURCE_PATH + "caughtByPacmanBG.wav");
		
		Blinky blinky = new Blinky(Color.red, Color.white, Color.blue);
		
		Pinky pinky = new Pinky(Color.pink, Color.white, Color.blue);
		Inky inky = new Inky(Color.cyan, Color.white, Color.blue);
		Clyde clyde = new Clyde(Color.orange, Color.white, Color.blue);
		Shrek shrek = new Shrek(Color.green, Color.white, Color.blue);
		
		board.getJFrame().addKeyListener(pacman);
		//!Pacman.isDead
		while(true){
			//System.out.println(Long.MAX_VALUE);
			
			board.clear();
			if(pacman.isDead){
				siren.stop();
				timer.pause(500);
				//timer.
				pacman.death.play();
				
				for(int i=0; i<=150; i = i + 3){//2
				
				board.clear();
				
				wall.draw(board);
				//if(levelCount==1) array.draw(board);
				//else WallArray.draw(board);
				array.draw(board);
			//	pacman.draw(board);
				if(gameOverCounter>1){
			   // blinky.draw(board);
			    //pinky.draw(board);
				 //   pinky.move(pacman); 
				  //  inky.draw(board);
				   // inky.move(pacman);
				   // clyde.draw(board);
				   // clyde.move(pacman);
				}
				//System.out.println(i);
				canvas.setColor(Color.yellow);
				canvas.fillArc(pacman.x, pacman.y, pacman.radius*2, pacman.radius*2, 120+i, 150-i);
				canvas.fillArc(pacman.x, pacman.y, pacman.radius*2, pacman.radius*2, 270, 150-i);
				board.repaint();
				timer.pause(9);//9
				}
				//System.out.println("hbhjv");
				deadCounter++;
				pacman.moveAfterDeath = true;
				pacman.x = 600;
				pacman.y = 340;
				pacman.oldx = pacman.x; 
				pacman.oldy = pacman.y;
				pacman.realX = pacman.y - 40;
				pacman.realY = pacman.x - 200;
				pacman.updatedX = pacman.realX;
				pacman.updatedY = pacman.realY;
				array.canHaveCherry = true;
				array.canIncrementCherry = true;
				array.cherryCount = 0;
				array.cherryCounter = 0;
				
				blinky.x = 600;
				blinky.y = 280;
				blinky.realX = blinky.y - 40;
				blinky.realY = blinky.x - 200;
				blinky.updatedX = blinky.realX;
				blinky.updatedY = blinky.realY;
				blinky.rightCount = 0;
				blinky.leftCount = 0;
				blinky.downCount = 0;
				blinky.upCount = 0;
				blinky.firstMovement = 0;
				blinky.shouldLeave = true;
				blinky.canSkip = false;
				blinky.shouldReturn = false;
				blinky.canMove = true;
				blinky.movingDown = false;
				blinky.movingUp = false;
				blinky.movingLeft = false;
				blinky.movingRight = false;
				blinky.canBypassMovingUp = true;
				
				pinky.x = 620;
				pinky.y = 300;
				pinky.realX = pinky.y - 40;
				pinky.realY = pinky.x - 200;
				pinky.updatedX = pinky.realX;
				pinky.updatedY = pinky.realY;
				pinky.rightCount = 0;
				pinky.leftCount = 0;
				pinky.downCount = 0;
				pinky.upCount = 0;
				pinky.pinkyfirstMovement = 0;
				pinky.pinkysecondMovement = 0;
				pinky.firstMovement = 0;
				pinky.shouldLeave = true;
				pinky.canSkip = false;
				pinky.shouldReturn = false;
				pinky.canMove = true;
				pinky.movingDown = false;
				pinky.movingUp = false;
				pinky.movingLeft = false;
				pinky.movingRight = false;
				pinky.canBypassMovingUp = true;
				
				inky.x = 580;
				inky.y = 300;
				inky.realX = inky.y - 40;
				inky.realY = inky.x - 200;
				inky.updatedX = inky.realX;
				inky.updatedY = inky.realY;
				inky.rightCount = 0;
				inky.leftCount = 0;
				inky.downCount = 0;
				inky.upCount = 0;
				inky.inkyFirstMove = 0;
				inky.firstMovement = 0;
				inky.shouldLeave = true;
				inky.canSkip = false;
				inky.shouldReturn = false;
				inky.canMove = true;
				inky.movingDown = false;
				inky.movingUp = false;
				inky.movingLeft = false;
				inky.movingRight = false;
				inky.canBypassMovingUp = true;
				
				clyde.x = 600;
				clyde.y = 300;
				clyde.realX = clyde.y - 40;
				clyde.realY = clyde.x - 200;
				clyde.updatedX = clyde.realX;
				clyde.updatedY = clyde.realY;
				clyde.shouldLeave = true;
				clyde.canSkip = false;
				clyde.shouldReturn = false;
				clyde.canMove = true;
				clyde.movingDown = false;
				clyde.movingUp = false;
				clyde.movingLeft = false;
				clyde.movingRight = false;
				clyde.canBypassMovingUp = true;
				
				shrek.x = 640;
				shrek.y = 300;
				shrek.realX = shrek.y - 40;
				shrek.realY = shrek.x - 200;
				shrek.updatedX = shrek.realX;
				shrek.updatedY = shrek.realY;
				shrek.rightCount = 0;
				shrek.leftCount = 0;
				shrek.downCount = 0;
				shrek.upCount = 0;
				shrek.shrekfirstMovement = 0;
				shrek.shreksecondMovement = 0;
				shrek.firstMovement = 0;
				shrek.shouldLeave = true;
				shrek.canSkip = false;
				shrek.shouldReturn = false;
				shrek.canMove = true;
				shrek.movingDown = false;
				shrek.movingUp = false;
				shrek.movingLeft = false;
				shrek.movingRight = false;
				shrek.canBypassMovingUp = true;
				pinkyCounter = 0;
				inkyCounter = 0;
				clydeCounter = 0;
				pacman.isDead = false;
				gameOverCounter++;
			}
			
			
			if(gameOverCounter>=3) {
				//System.out.println(gameOverCounter);
				break;
			}
			
			pinkyCounter++;
			inkyCounter++;
			clydeCounter++;
			
			wall.draw(board);
		//	if(levelCount==1) array.draw(board);
			//else WallArray.draw(board);
			array.draw(board);
			pacman.draw(board);
			
		    blinky.draw(board);
		    if(pacman.isToEatBlinky && firstEatPauseBlinky) {
		    	timer.pause(500);
		    	firstEatPauseBlinky = false;
		    }
		    if(pacman.isToEatClyde && firstEatPauseClyde) {
		    	timer.pause(500);
		    	firstEatPauseClyde = false;
		    }
		    if(pacman.isToEatInky && firstEatPauseInky) {
		    	timer.pause(500);
		    	firstEatPauseInky = false;
		    }
		    if(pacman.isToEatPinky && firstEatPausePinky) {
		    	timer.pause(500);
		    	firstEatPausePinky = false;
		    }
		    if(pacman.isToEatShrek && firstEatPauseShrek) {
		    	timer.pause(500);
		    	firstEatPauseShrek = false;
		    }
		    if(pacman.isToEatBlinky){
		    	blinky.x = 600;
		    	blinky.y = 280;
		    }
		    if(pacman.isToEatClyde){
		    	clyde.x = 600;
		    	clyde.y = 300;
		    }
		    if(pacman.isToEatInky){
		    	inky.x = 580;
		    	inky.y = 300;
		    }
		    if(pacman.isToEatPinky){
		    	pinky.x = 620;
		    	pinky.y = 300;
		    }
		    if(pacman.isToEatShrek){
		    	shrek.x = 640;
		    	shrek.y = 300;
		    }
		    pinky.draw(board);
			 //   pinky.move(pacman); 
			    inky.draw(board);
			   // inky.move(pacman);
			    clyde.draw(board);
			   // clyde.move(pacman);
			    if(levelCount>0)shrek.draw(board);
			    if(deadCounter>0){
			    	timer.pause(500);
			    	//deadCounter = 0;
			    	
			    }
			
			if(canPause==true) {
				board.clear();
				wall.draw(board);
				//if(levelCount==1) array.draw(board);
				//else WallArray.draw(board);
				array.draw(board);
				pacman.draw(board);
				   
			    blinky.draw(board);
			    pinky.draw(board);
				 //   pinky.move(pacman); 
				    inky.draw(board);
				   // inky.move(pacman);
				    clyde.draw(board);
				    if(levelCount>0)shrek.draw(board);
				   // clyde.move(pacman);
				    board.repaint();
				if(levelCount==0) {//CHANGE
				bgSound.play();
				timer.pause(firstPause);
				}
				else {
					timer.pause(2000);
					pacman.dotCount = 0;
				}
				playSiren(siren);
			}
			
			canPause = false;
			if(pacman.ghostDanger && firstPlayed){
				ghostDangerBG.playLoop();
				firstPlayed = false;
				siren.stop();
			}
			if(pacman.isToEatBlinky && firstCaught){
				ghostDangerBG.stop();
				caughtByPacmanBG.playLoop();
				firstCaught = false;
			}
			if(pacman.isToEatClyde && firstCaught){
				ghostDangerBG.stop();
				caughtByPacmanBG.playLoop();
				firstCaught = false;
			}
			if(pacman.isToEatInky && firstCaught){
				ghostDangerBG.stop();
				caughtByPacmanBG.playLoop();
				firstCaught = false;
			}
			if(pacman.isToEatPinky && firstCaught){
				ghostDangerBG.stop();
				caughtByPacmanBG.playLoop();
				firstCaught = false;
			}
			if(pacman.isToEatShrek && firstCaught){
				ghostDangerBG.stop();
				caughtByPacmanBG.playLoop();
				firstCaught = false;
			}
			if(pacman.ghostDanger){
				blueGhostCounter++;
				if(blueGhostCounter>200 && blueGhostCounter<210){
					pacman.aboutToFinishGD = true;
				}
				else if(blueGhostCounter>220 && blueGhostCounter<230){
					pacman.aboutToFinishGD = true;
				}
				else if(blueGhostCounter>240 && blueGhostCounter<250){
					pacman.aboutToFinishGD = true;
				}
				else if(blueGhostCounter>260 && blueGhostCounter<270){
					pacman.aboutToFinishGD = true;
				}
				else if(blueGhostCounter>280 && blueGhostCounter<290){
					pacman.aboutToFinishGD = true;
				}
				else pacman.aboutToFinishGD = false;
				if(blueGhostCounter>300){
					pacman.ghostDanger = false;
					pacman.ghostEatCounter = 0;
					blueGhostCounter = 0;	
					if(levelCount==0){
						if(!pacman.isToEatBlinky || !pacman.isToEatClyde || !pacman.isToEatInky || !pacman.isToEatPinky) ghostDangerBG.stop();
						if(pacman.isToEatBlinky || pacman.isToEatClyde || pacman.isToEatInky || pacman.isToEatPinky) caughtByPacmanBG.stop();
					}
					if(levelCount==1){
						if(!pacman.isToEatBlinky || !pacman.isToEatClyde || !pacman.isToEatInky || !pacman.isToEatPinky
								|| !pacman.isToEatShrek) ghostDangerBG.stop();
						if(pacman.isToEatBlinky || pacman.isToEatClyde || pacman.isToEatInky || pacman.isToEatPinky
								|| pacman.isToEatShrek) caughtByPacmanBG.stop();
					}
					playSiren(siren);
					firstPlayed = true;
					firstCaught = true;
					if(pacman.isToEatBlinky){
						blinky.x = 600;
						blinky.y = 280;
						blinky.realX = blinky.y - 40;
						blinky.realY = blinky.x - 200;
						blinky.updatedX = blinky.realX;
						blinky.updatedY = blinky.realY;
						blinky.rightCount = 0;
						blinky.leftCount = 0;
						blinky.downCount = 0;
						blinky.upCount = 0;
						blinky.firstMovement = 0;
						blinky.shouldLeave = true;
						blinky.canSkip = false;
						blinky.shouldReturn = false;
						blinky.canMove = true;
						blinky.movingDown = false;
						blinky.movingUp = false;
						blinky.movingLeft = false;
						blinky.movingRight = false;
						blinky.canBypassMovingUp = true;
					}
					if(pacman.isToEatClyde){
						clyde.x = 600;
						clyde.y = 300;
						clyde.realX = clyde.y - 40;
						clyde.realY = clyde.x - 200;
						clyde.updatedX = clyde.realX;
						clyde.updatedY = clyde.realY;
						clyde.rightCount = 0;
						clyde.leftCount = 0;
						clyde.downCount = 0;
						clyde.upCount = 0;
						clyde.firstMovement = 0;
						clyde.shouldLeave = true;
						clyde.canSkip = false;
						clyde.shouldReturn = false;
						clyde.canMove = true;
						clyde.movingDown = false;
						clyde.movingUp = false;
						clyde.movingLeft = false;
						clyde.movingRight = false;
						clyde.canBypassMovingUp = true;
					}
					if(pacman.isToEatInky){
						inky.x = 580;
						inky.y = 300;
						inky.realX = inky.y - 40;
						inky.realY = inky.x - 200;
						inky.updatedX = inky.realX;
						inky.updatedY = inky.realY;
						inky.rightCount = 0;
						inky.leftCount = 0;
						inky.downCount = 0;
						inky.upCount = 0;
						inky.inkyFirstMove = 0;
						inky.firstMovement = 0;
						inky.shouldLeave = true;
						inky.canSkip = false;
						inky.shouldReturn = false;
						inky.canMove = true;
						inky.movingDown = false;
						inky.movingUp = false;
						inky.movingLeft = false;
						inky.movingRight = false;
						inky.canBypassMovingUp = true;
					}
					if(pacman.isToEatPinky){
						pinky.x = 620;
						pinky.y = 300;
						pinky.realX = pinky.y - 40;
						pinky.realY = pinky.x - 200;
						pinky.updatedX = pinky.realX;
						pinky.updatedY = pinky.realY;
						pinky.rightCount = 0;
						pinky.leftCount = 0;
						pinky.downCount = 0;
						pinky.upCount = 0;
						pinky.pinkyfirstMovement = 0;
						pinky.pinkysecondMovement = 0;
						pinky.firstMovement = 0;
						pinky.shouldLeave = true;
						pinky.canSkip = false;
						pinky.shouldReturn = false;
						pinky.canMove = true;
						pinky.movingDown = false;
						pinky.movingUp = false;
						pinky.movingLeft = false;
						pinky.movingRight = false;
						pinky.canBypassMovingUp = true;
					}
					if(pacman.isToEatShrek){
						shrek.x = 640;
						shrek.y = 300;
						shrek.realX = shrek.y - 40;
						shrek.realY = shrek.x - 200;
						shrek.updatedX = shrek.realX;
						shrek.updatedY = shrek.realY;
						shrek.rightCount = 0;
						shrek.leftCount = 0;
						shrek.downCount = 0;
						shrek.upCount = 0;
						shrek.shrekfirstMovement = 0;
						shrek.shreksecondMovement = 0;
						shrek.firstMovement = 0;
						shrek.shouldLeave = true;
						shrek.canSkip = false;
						shrek.shouldReturn = false;
						shrek.canMove = true;
						shrek.movingDown = false;
						shrek.movingUp = false;
						shrek.movingLeft = false;
						shrek.movingRight = false;
						shrek.canBypassMovingUp = true;
					}
					pacman.isToEatBlinky = false;
					pacman.isToEatClyde = false;
					pacman.isToEatInky = false;
					pacman.isToEatPinky = false;
					pacman.isToEatShrek = false;
					firstEatPauseBlinky = true;
					firstEatPauseClyde = true;
					firstEatPauseInky = true;
					firstEatPausePinky = true;
					firstEatPauseShrek = true;
					
				}
			}
			
			if(pacman.movingRight){
		    	pacman.movingRight();
		    }
		    
		    else if(pacman.movingLeft){
		    	pacman.movingLeft();
		    }
			
		    else if(pacman.movingDown){
		    	pacman.movingDown();
		    }
			
		    else if(pacman.movingUp){
		    	pacman.movingUp();
		    }
			if(!pacman.isToEatBlinky){
			if(blinky.movingRight){
				
		    	blinky.movingRight();
		    }
		    
			else if(blinky.movingLeft){
		    
		    	blinky.movingLeft();
		    }
			
			else if(blinky.movingDown){
		    	
		    	blinky.movingDown();
		    }
			
			else if(blinky.movingUp){
		    	
		    	blinky.movingUp();
		    }
			}
		    if(blinky.canMove==true && pacman.ghostDanger==false && !pacman.isToEatBlinky) {
		    
			blinky.move(pacman);
		    }
		    
		    else if(blinky.canMove==true){
		    	blinky.moveRandom();
		    }
		    
			
		  if(pinkyCounter>10){			 
				   
			 
		    if(pinky.movingRight){
				
		    	pinky.movingRight();
		    }
		    
			else if(pinky.movingLeft){
		    
				pinky.movingLeft();
		    }
			
			else if(pinky.movingDown){
		    	
				pinky.movingDown();
		    }
			
			else if(pinky.movingUp){
		    	
				pinky.movingUp();
		    }
		    if(pinky.canMove==true) {
			    
		    	pinky.move(pacman);
		    }
		    
		    else if(pinky.canMove==true){
		    	pinky.moveRandom();
		    }
		  
		  }
		  if(clydeCounter>100){
		    
		    if(clyde.movingDown){
		    	clyde.movingDown();
		    }
		    else if(clyde.movingUp){
		    	clyde.movingUp();
		    }
		    else if(clyde.movingRight){
		    	clyde.movingRight();
		    }
		    else if(clyde.movingLeft){
		    	clyde.movingLeft();
		    }
		    
		    if(clyde.canMove==true){
		    	clyde.move(pacman);
		    }
		  
		  }
		  if(inkyCounter>50){
			 
			  
		    if(inky.movingRight){
				
		    	inky.movingRight();
		    }
		    
			else if(inky.movingLeft){
		    
		    	inky.movingLeft();
		    }
			
			else if(inky.movingDown){
		    	
		    	inky.movingDown();
		    }
			
			else if(inky.movingUp){
		    	
		    	inky.movingUp();
		    }
		    
		    if(inky.canMove==true) {
		    
			inky.move(pacman);
		    }
		    
		    else if(inky.canMove==true){
		    	inky.moveRandom();
		    }
		  
		  }
		  if(levelCount>0){
			  if(!pacman.isToEatShrek){
					if(shrek.movingRight){
						
						shrek.movingRight();
				    }
				    
					else if(shrek.movingLeft){
				    
						shrek.movingLeft();
				    }
					
					else if(shrek.movingDown){
				    	
						shrek.movingDown();
				    }
					
					else if(shrek.movingUp){
				    	
						shrek.movingUp();
				    }
					}
				    if(shrek.canMove==true && pacman.ghostDanger==false && !pacman.isToEatShrek) {
				    
				    	shrek.move(pacman);
				    }
				    
				    else if(shrek.canMove==true){
				    	shrek.moveRandom();
				    }
		  }
		  canvas.setPaint(Color.yellow);
		 
		  
		//  System.out.println(pacman.dotCount);
		 // pacman.dotCount = 401;
		  if(pacman.dotCount==401){ 
			  winCount++;
			  if(winCount==10){
				  if(pacman.ghostDanger) ghostDangerBG.stop();
				  siren.stop();
				  nextLevel.play();
				  timer.pause(1000);
				  array = new WallArray();
				  levelCount++;
				  winCount = 0;
				  pacman.dotCount = 0;
				  canPause = true;
				  pacman.ghostDanger = false;
				  pacman.isToEatBlinky = false;
					pacman.isToEatClyde = false;
					pacman.isToEatInky = false;
					pacman.isToEatPinky = false;
					pacman.isToEatShrek = false;
					firstEatPauseBlinky = true;
					firstEatPauseClyde = true;
					firstEatPauseInky = true;
					firstEatPausePinky = true;
					firstEatPauseShrek = true;
				    pacman.x = 600;
					pacman.y = 340;
					pacman.oldx = pacman.x; 
					pacman.oldy = pacman.y;
					pacman.realX = pacman.y - 40;
					pacman.realY = pacman.x - 200;
					pacman.updatedX = pacman.realX;
					pacman.updatedY = pacman.realY;
					array.canHaveCherry = true;
					array.canIncrementCherry = true;
					array.cherryCount = 0;
					array.cherryCounter = 0;
					pacman.canSkip = false;
					pacman.shouldReturn = false;
					pacman.canComeBackTL = true;
					pacman.canComeBackBL = true;
					pacman.canComeBackBR = true;
					pacman.canComeBackTR = true;
					
					array.canFlashTL = true;
					array.canFlashTR = true;
					array.canFlashBL = true;
					array.canFlashBR = true;
					
					blinky.x = 600;
					blinky.y = 280;
					blinky.realX = blinky.y - 40;
					blinky.realY = blinky.x - 200;
					blinky.updatedX = blinky.realX;
					blinky.updatedY = blinky.realY;
					blinky.rightCount = 0;
					blinky.leftCount = 0;
					blinky.downCount = 0;
					blinky.upCount = 0;
					blinky.firstMovement = 0;
					blinky.shouldLeave = true;
					blinky.canSkip = false;
					blinky.shouldReturn = false;
					blinky.canMove = true;
					blinky.movingDown = false;
					blinky.movingUp = false;
					blinky.movingLeft = false;
					blinky.movingRight = false;
					blinky.canBypassMovingUp = true;
					
					pinky.x = 620;
					pinky.y = 300;
					pinky.realX = pinky.y - 40;
					pinky.realY = pinky.x - 200;
					pinky.updatedX = pinky.realX;
					pinky.updatedY = pinky.realY;
					pinky.rightCount = 0;
					pinky.leftCount = 0;
					pinky.downCount = 0;
					pinky.upCount = 0;
					pinky.pinkyfirstMovement = 0;
					pinky.pinkysecondMovement = 0;
					pinky.firstMovement = 0;
					pinky.shouldLeave = true;
					pinky.canSkip = false;
					pinky.shouldReturn = false;
					pinky.canMove = true;
					pinky.movingDown = false;
					pinky.movingUp = false;
					pinky.movingLeft = false;
					pinky.movingRight = false;
					pinky.canBypassMovingUp = true;
					
					inky.x = 580;
					inky.y = 300;
					inky.realX = inky.y - 40;
					inky.realY = inky.x - 200;
					inky.updatedX = inky.realX;
					inky.updatedY = inky.realY;
					inky.rightCount = 0;
					inky.leftCount = 0;
					inky.downCount = 0;
					inky.upCount = 0;
					inky.inkyFirstMove = 0;
					inky.firstMovement = 0;
					inky.shouldLeave = true;
					inky.canSkip = false;
					inky.shouldReturn = false;
					inky.canMove = true;
					inky.movingDown = false;
					inky.movingUp = false;
					inky.movingLeft = false;
					inky.movingRight = false;
					inky.canBypassMovingUp = true;
					
					clyde.x = 600;
					clyde.y = 300;
					clyde.realX = clyde.y - 40;
					clyde.realY = clyde.x - 200;
					clyde.updatedX = clyde.realX;
					clyde.updatedY = clyde.realY;
					clyde.shouldLeave = true;
					clyde.canSkip = false;
					clyde.shouldReturn = false;
					clyde.canMove = true;
					clyde.movingDown = false;
					clyde.movingUp = false;
					clyde.movingLeft = false;
					clyde.movingRight = false;
					clyde.canBypassMovingUp = true;
					
					shrek.x = 640;
					shrek.y = 300;
					shrek.realX = shrek.y - 40;
					shrek.realY = shrek.x - 200;
					shrek.updatedX = shrek.realX;
					shrek.updatedY = shrek.realY;
					shrek.rightCount = 0;
					shrek.leftCount = 0;
					shrek.downCount = 0;
					shrek.upCount = 0;
					shrek.shrekfirstMovement = 0;
					shrek.shreksecondMovement = 0;
					shrek.firstMovement = 0;
					shrek.shouldLeave = true;
					shrek.canSkip = false;
					shrek.shouldReturn = false;
					shrek.canMove = true;
					shrek.movingDown = false;
					shrek.movingUp = false;
					shrek.movingLeft = false;
					shrek.movingRight = false;
					shrek.canBypassMovingUp = true;
					pinkyCounter = 0;
					inkyCounter = 0;
					clydeCounter = 0;
					
					pacman.isDead = false;
					
			  }
		  }
		  
		    board.repaint();
		    timer.pause(pauseTime);
		    
		    if(deadCounter>0){
		    	timer.pause(2000);
		    	deadCounter = 0;
		    	playSiren(siren);
		    }
		    
		}
		
		Image gameOverBanner = new ImageIcon(RESOURCE_PATH + "gameOverImage.png").getImage();
		board.getCanvas().drawImage(gameOverBanner, 305, 103, board);
		board.repaint();

	}

	public static void playSiren(SoundPlayer siren){
		siren.playLoop();
	}

}


