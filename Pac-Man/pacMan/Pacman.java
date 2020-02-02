package pacMan;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

import resources.DrawingBoard;
import resources.SoundPlayer;
import resources.Timer;

public class Pacman implements KeyListener {
	
	public static int x = 600;
	public static int y = 340;
	public int keyCode;
	public int oldKeyCode;
	public static int radius = 10;
	private Color color = Color.yellow;
	private static int skip = 5;
	Timer timer = new Timer();
	static boolean mouthopenflag = true;
	private int rows = 28;
	private int columns = 41;
	private boolean[][] cells = new boolean[columns][rows];
	public boolean movingDown, movingUp;
	public static boolean movingLeft;
	public static boolean movingRight;
	public static int score = 0;
	private SoundPlayer chomp;
	public SoundPlayer death;
	public SoundPlayer eatGhost;
	public Blinky blinky;
	public Pinky pinky;
	public Wall wall;
	public Inky inky;
	public Clyde clyde;
	public static boolean isToEatBlinky;
	public static boolean isToEatClyde;
	public static boolean isToEatInky;
	public static boolean isToEatPinky;
	public static boolean isToEatShrek;
	public static boolean aboutToFinishGD;
	public boolean canSkip = false;
	public boolean shouldReturn = false;
	public boolean canComeBackTL = true;
	public boolean canComeBackBL = true;
	public boolean canComeBackBR = true;
	public boolean canComeBackTR = true;
	public int canTeleportMROL;
	public int canTeleportMUOD;
	public int toAddToYROL;
	public int toADDToXUOD;
	public boolean wasMovingUp = false;
	public boolean wasMovingDown = false;
	public boolean wasMovingRight = false;
	public boolean wasMovingLeft = false;
	public static boolean isDead = false;
	public static boolean isToEat = false;
	public int oldx = this.x; 
	public int oldy = this.y;
	public static int realX = y - 40;
	public static int realY = x - 200;
	public static int updatedX = realX;
	public static int updatedY = realY;
	public boolean firstMovement = true;
	public boolean moveAfterDeath = false;
	public static boolean ghostDanger = false;
	public static int incrementAmount = 20;
	public static int id;
	public static int futureX;
	public static int futureY;
	public static boolean faceRight;
	public static boolean faceLeft;
	public static boolean faceUp;
	public static boolean faceDown;
	public static int movingUpCount, movingDownCount, movingLeftCount, movingRightCount;
	public static boolean allFour;
	public static int ghostEatCounter;
	public static int dotCount;
	
	public Pacman(){
		chomp = new SoundPlayer();
		chomp.load(Coordinator.RESOURCE_PATH + "chomp.wav"); 
		
		death = new SoundPlayer();
		death.load(Coordinator.RESOURCE_PATH + "Pacman-death-sound.wav");
		
		eatGhost = new SoundPlayer();
		eatGhost.load(Coordinator.RESOURCE_PATH + "eatGhost.wav");
	}

	public void draw(DrawingBoard board){
		//System.out.println("x and y: " + x + " " + y);
		Graphics2D canvas = board.getCanvas();
		
		//System.out.println("This is dotCount: "+dotCount);
		if(ghostDanger && Blinky.getX()>=x-20 && Blinky.getY()==y && Blinky.getX()<=x){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatBlinky = true;
			eatGhost.play();
		}
		
		else if(ghostDanger && Blinky.getX()<=x+20 && Blinky.getY()==y && Blinky.getX()>=x){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatBlinky = true;
			eatGhost.play();
		}
		
		else if(ghostDanger && Blinky.getX()==x && Blinky.getY()>=y-20 && Blinky.getY()<=y){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatBlinky = true;
			eatGhost.play();
		}
		
		else if(ghostDanger && Blinky.getX()==x && Blinky.getY()<=y+20 && Blinky.getY()>=y){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatBlinky = true;
			eatGhost.play(); 
		}
		
		//Clyde
		
		if(ghostDanger && Clyde.getX()>=x-20 && Clyde.getY()==y && Clyde.getX()<=x){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatClyde = true;
			eatGhost.play(); 
		}
		
		else if(ghostDanger && Clyde.getX()<=x+20 && Clyde.getY()==y && Clyde.getX()>=x){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatClyde = true;
			eatGhost.play(); 
		}
		
		else if(ghostDanger && Clyde.getX()==x && Clyde.getY()>=y-20 && Clyde.getY()<=y){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatClyde = true;
			eatGhost.play(); 
		}
		
		else if(ghostDanger && Clyde.getX()==x && Clyde.getY()<=y+20 && Clyde.getY()>=y){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatClyde = true;
			eatGhost.play(); 
		}
		
		//Inky
		
		if(ghostDanger && Inky.getX()>=x-20 && Inky.getY()==y && Inky.getX()<=x){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatInky = true;
			eatGhost.play();
		}
		
		else if(ghostDanger && Inky.getX()<=x+20 && Inky.getY()==y && Inky.getX()>=x){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatInky = true;
			eatGhost.play();
		}
		
		else if(ghostDanger && Inky.getX()==x && Inky.getY()>=y-20 && Inky.getY()<=y){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatInky = true;
			eatGhost.play();
		}
		
		else if(ghostDanger && Inky.getX()==x && Inky.getY()<=y+20 && Inky.getY()>=y){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatInky = true;
			eatGhost.play(); 
		}
		
		//Pinky
		
		if(ghostDanger && Pinky.getX()>=x-20 && Pinky.getY()==y && Pinky.getX()<=x){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatPinky = true;
			eatGhost.play();
		}
		
		else if(ghostDanger && Pinky.getX()<=x+20 && Pinky.getY()==y && Pinky.getX()>=x){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatPinky = true;
			eatGhost.play();
		}
		
		else if(ghostDanger && Pinky.getX()==x && Pinky.getY()>=y-20 && Pinky.getY()<=y){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatPinky = true;
			eatGhost.play();
		}
		
		else if(ghostDanger && Pinky.getX()==x && Pinky.getY()<=y+20 && Pinky.getY()>=y){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatPinky = true;
			eatGhost.play(); 
		}
		
		//Shrek
		
		if(ghostDanger && Shrek.getX()>=x-20 && Shrek.getY()==y && Shrek.getX()<=x){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatShrek = true;
			eatGhost.play();
		}
		
		else if(ghostDanger && Shrek.getX()<=x+20 && Shrek.getY()==y && Shrek.getX()>=x){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatShrek = true;
			eatGhost.play();
		}
		
		else if(ghostDanger && Shrek.getX()==x && Shrek.getY()>=y-20 && Shrek.getY()<=y){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatShrek = true;
			eatGhost.play();
		}
		
		else if(ghostDanger && Shrek.getX()==x && Shrek.getY()<=y+20 && Shrek.getY()>=y){
			ghostEatCounter++;
			if(ghostEatCounter==1) score += 200;
			if(ghostEatCounter==2) score += 400;
			if(ghostEatCounter==3) score += 800;
			if(ghostEatCounter==4) score += 1600;
			if(ghostEatCounter==5) score += 3200;
			isToEatShrek = true;
			eatGhost.play(); 
		}
		
		//Blinky
		if(!ghostDanger && Blinky.getX()>=x-20 && Blinky.getY()==y && Blinky.getX()<=x){
			isDead = true;
		}
		
		else if(!ghostDanger && Blinky.getX()<=x+20 && Blinky.getY()==y && Blinky.getX()>=x){
			isDead = true;
		}
		
		else if(!ghostDanger && Blinky.getX()==x && Blinky.getY()>=y-20 && Blinky.getY()<=y){
			isDead = true;
		}
		
		else if(!ghostDanger && Blinky.getX()==x && Blinky.getY()<=y+20 && Blinky.getY()>=y){
			isDead = true;
		}
		
		//Clyde
		
		if(!ghostDanger && Clyde.getX()>=x-20 && Clyde.getY()==y && Clyde.getX()<=x){
			isDead = true;
		}
		
		else if(!ghostDanger && Clyde.getX()<=x+20 && Clyde.getY()==y && Clyde.getX()>=x){
			isDead = true;
		}
		
		else if(!ghostDanger && Clyde.getX()==x && Clyde.getY()>=y-20 && Clyde.getY()<=y){
			isDead = true;
		}
		
		else if(!ghostDanger && Clyde.getX()==x && Clyde.getY()<=y+20 && Clyde.getY()>=y){
			isDead = true;
		}
		
		//Inky
		
		if(!ghostDanger && Inky.getX()>=x-20 && Inky.getY()==y && Inky.getX()<=x){
			isDead = true;
		}
		
		else if(!ghostDanger && Inky.getX()<=x+20 && Inky.getY()==y && Inky.getX()>=x){
			isDead = true;
		}
		
		else if(!ghostDanger && Inky.getX()==x && Inky.getY()>=y-20 && Inky.getY()<=y){
			isDead = true;
		}
		
		else if(!ghostDanger && Inky.getX()==x && Inky.getY()<=y+20 && Inky.getY()>=y){
			isDead = true;
		}
		
		//Pinky
		
		if(!ghostDanger && Pinky.getX()>=x-20 && Pinky.getY()==y && Pinky.getX()<=x){
			isDead = true;
		}
		
		else if(!ghostDanger && Pinky.getX()<=x+20 && Pinky.getY()==y && Pinky.getX()>=x){
			isDead = true;
		}
		
		else if(!ghostDanger && Pinky.getX()==x && Pinky.getY()>=y-20 && Pinky.getY()<=y){
			isDead = true;
		}
		
		else if(!ghostDanger && Pinky.getX()==x && Pinky.getY()<=y+20 && Pinky.getY()>=y){
			isDead = true;
		}
		
		//Shrek
		
		if(!ghostDanger && Shrek.getX()>=x-20 && Shrek.getY()==y && Shrek.getX()<=x){
			isDead = true;
		}
		
		else if(!ghostDanger && Shrek.getX()<=x+20 && Shrek.getY()==y && Shrek.getX()>=x){
			isDead = true;
		}
		
		else if(!ghostDanger && Shrek.getX()==x && Shrek.getY()>=y-20 && Shrek.getY()<=y){
			isDead = true;
		}
		
		else if(!ghostDanger && Shrek.getX()==x && Shrek.getY()<=y+20 && Shrek.getY()>=y){
			isDead = true;
		}
		
	
		canvas.setColor(color);
		
		
		
		
		//mouth on right when moving right
		
		if(firstMovement) {
			canvas.fillArc(x, y, radius*2, radius*2, 120, 300);
		}
		
		if(moveAfterDeath){
			canvas.setColor(color);
			//System.out.println("going to move again");
			canvas.fillArc(600, 340, radius*2, radius*2, 120, 300);
			//canvas.fillRect(300, 300, 50, 50);
			moveAfterDeath = false;
			return;
		}
		//System.out.println(keyCode);
		if(faceRight)
		if(mouthopenflag){
			firstMovement = false;
		  canvas.setColor(color);
	      canvas.fillArc(x, y, radius*2, radius*2, 30, 300);
	      if(skip >= 0)
	       skip = skip - 2;
	      else{
	       skip = 5;
	       mouthopenflag = false;
	      }
		} 
		else {
		   canvas.fillOval(x, y, radius*2, radius*2);
		   if(skip >= 0)
		     skip = skip - 2;
		   else{
		     skip = 5;
		     mouthopenflag = true;
		   }
		}
		// mouth on left when moving left
		if(faceLeft)
			if(mouthopenflag){
				firstMovement = false;
		      canvas.fillArc(x, y, radius*2, radius*2, 220, 280);
		      if(skip >= 0)
		       skip = skip - 2;
		      else{
		       skip = 5;
		       mouthopenflag = false;
		      }
			} 
			else {
			   canvas.fillOval(x, y, radius*2, radius*2);
			   if(skip >= 0)
			     skip = skip - 2;
			   else{
			     skip = 5;
			     mouthopenflag = true;
			   }
			}
		//mouth going up when moving up
		if(faceUp)
			if(mouthopenflag){
				firstMovement = false;
		      canvas.fillArc(x, y, radius*2, radius*2, 120, 300);
		      if(skip >= 0)
		       skip = skip - 2;
		      else{
		       skip = 5;
		       mouthopenflag = false;
		      }
			} 
			else {
			   canvas.fillOval(x, y, radius*2, radius*2);
			   if(skip >= 0)
			     skip = skip - 2;
			   else{
			     skip = 5;
			     mouthopenflag = true;
			   }
			}
		//mouth down when moving down
		if(faceDown)
			if(mouthopenflag){
				firstMovement = false;
		      canvas.fillArc(x, y, radius*2, radius*2, 300, 300);
		      if(skip >= 0)
		       skip = skip - 2;
		      else{
		       skip = 5;
		       mouthopenflag = false;
		      }
			} 
			else {
			   canvas.fillOval(x, y, radius*2, radius*2);
			   if(skip >= 0)
			     skip = skip - 2;
			   else{
			     skip = 5;
			     mouthopenflag = true;
			   }
			}
	}
	
	public void keyTyped(KeyEvent e){
			keyCode = e.getKeyCode();
	}
	
	public static int getX(){return x;}
	
	public static int getY(){return y;}

	public void keyPressed(KeyEvent e) {
		
		if(movingRight==false && movingLeft==false && movingUp==false && movingDown==false){
			
	    	if(e.getKeyCode() == KeyEvent.VK_UP){
	    		id=4;
	    		movingRight = false;
				movingLeft = false;
				movingDown = false;
				movingUp = true;
				
			}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
					id=3;
					movingRight = false;
					movingLeft = false;
					movingUp = false;
					movingDown = true;
					
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
					id=2;
					movingRight = false;
					movingDown = false;
					movingUp = false;
					movingLeft = true;
					
		}
	    if(e.getKeyCode() == KeyEvent.VK_RIGHT){
	    			id=1;
					movingLeft = false;
					movingDown = false;
					movingUp = false;
					movingRight = true;
					
		}	
		}
		
		else{
			
			if(e.getKeyCode() == KeyEvent.VK_UP){
				id = 4;
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT){
				id = 2;
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				id = 1;
			}
		    if(e.getKeyCode() == KeyEvent.VK_DOWN){
				id = 3;
			}
		}
		
	}
	
	public void movingUp(){
		//Keycode is 38
		
		if(id==3) {
			movingLeft=false;
			movingRight=false;
			movingUp=false;
			movingDown=true;
			return;
		}
		
		if(x-realY>200 && x-realY<205) {
			int canTeleportMU = x-realY;
			int toSUBToXU = canTeleportMU - 200;
			//System.out.println(x);
			x = x - toSUBToXU;
			//System.out.println("This is X, canTeleprtMU, and toSubToXU: " + x + " " + canTeleportMU + " " + toSUBToXU);
		}
		
		if(x-realY>195 && x-realY<200) {
			System.out.println(x-realY);
			int canTeleportMU = x-realY;
			int toADDToXU = 200 - canTeleportMU;
			//System.out.println(x);
			x = x + toADDToXU;
			//System.out.println("This is X, canTeleprtMU, and toADDToXU: " + x + " " + canTeleportMU + " " + toADDToXU);
		}
		if(realX<0) return;
		
		if(x<215 && y<55 && canComeBackTL==true) {
			//System.out.println("came");
			//chomp.play();
			score += 40;
		//	System.out.println(score);
			canComeBackTL = false;
			ghostDanger = true;
		}
		
		if(x>965 && y<55 && canComeBackTR==true) {
		//	System.out.println("came");
			//chomp.play();
			score += 40;
		//	System.out.println(score);
			canComeBackTR = false;
			ghostDanger = true;
		}
		//delete check
		if(y-40==realX+10 && WallArray.hasBigSpot[updatedX/20][updatedY/20]==false) {
			dotCount++;
			WallArray.hasBigSpot[updatedX/20][updatedY/20] = true;
			chomp.play();
			score = score + 10;
		//	System.out.println(score);
		}
		
		if(y-40==realX+10 && updatedX/20==0 && updatedY/20==0){
			//System.out.println("hey man");
			
			if(WallArray.canFlashTL){
				chomp.play();
				dotCount++;
			score = score + 10;
			}
			WallArray.canFlashTL = false;
		}
		//System.out.println("updatedX is " + updatedX + "and updatedY is " + updatedY);
		//System.out.println("y is " + y + " and realX is " + realX);
		if(y-40==realX+10 && updatedX/20==0 && updatedY/20==40){
			//System.out.println("hey man");
			
			if(WallArray.canFlashTR) {
			dotCount++;
			chomp.play();
			score = score + 10;
			}
			WallArray.canFlashTR = false;
		}
		
		
		//if(x==WallArray.j*20+200+5 && y==WallArray.i*20+40+5)
		
		if(x % 20 != 0 || y % 20 != 0) canSkip = true;
		
		if(y % 20 != 0 && canSkip==true){
			
			this.y = oldy - 2;
			shouldReturn = true;
			oldy = this.y;
			//System.out.println("UpdatedX and realX: " + updatedX + " " + realX);
			//System.out.println("Y: " + y);
	}
	
	else {
		shouldReturn = false;
	}
	
	if(shouldReturn==true) {
		return;
	}
	
	canSkip = false;
	
	if(id==1&& x < 1000){
		realY = x - 200;
		updatedY = realY;
		updatedY = realY + 20;
	
		if(WallArray.allowMovement[updatedX/20][updatedY/20]==true && x < 1000 && canSkip == false && 
				x % 20 == 0 && y % 20 == 0) {
			updatedY = realY;
			canSkip = false;
			movingRight = true;
			movingUp = false;
			return;
		}
		updatedY = realY;
	}
	if(id==2 && x>200 && updatedY>0){
		realY = x - 200;
		updatedY = realY;
		updatedY = realY - 20;
		
		if(WallArray.allowMovement[updatedX/20][updatedY/20]==true && this.x >= 201 && updatedY>0 && canSkip==false && 
				x % 20 == 0 && y % 20 == 0){
			updatedY = realY;
			canSkip = false;
			movingLeft = true;
			movingUp = false;
			return;
		}
		updatedY = realY;
	}
		
		if(updatedX==0) movingUp = false;
		
		realX = y - 40;
		
		updatedX = realX;
	
		if(y==40) movingUp = false;
	
		if(movingUp) updatedX = realX - 20;
	
		if(WallArray.allowMovement[(int)updatedX/20][(int)updatedY/20]==true && this.y >= 40 && updatedX>=0 && canSkip==false && 
				x % 20 == 0 && y % 20 == 0 && movingUp){
			faceRight = false;
			faceLeft = false;
			faceDown = false;
			faceUp = true;
			this.y = oldy - 2;
			oldy = this.y;
			realX = updatedX;
			canSkip = true;
			
		}
		else {
			updatedX = realX;
			movingUp = false;
			canSkip = false;
			if(id==3){
				movingDown = true;
				movingRight = false;
				movingLeft = false;
			}
			if(id==2){
				movingDown = false;
				movingRight = false;
				movingLeft = true;
			}
			if(id==1){
				movingDown = false;
				movingRight = true;
				movingLeft = false;
			}
		}
		
	}

	public void movingDown(){
		
		if(id==4) {
			movingLeft=false;
			movingRight=false;
			movingUp=true;
			movingDown=false;
			return;
		}
		
		movingLeft = false;
		movingUp = false;
		movingRight = false;
		
		
		
		if(x-realY>200 && x-realY<205) {
			int canTeleportMD = x-realY;
			int toSUBToXD = canTeleportMD - 200;
			x = x - toSUBToXD;
			//System.out.println("This is X, canTeleprtMDOWN, and toSubToXD: " + x + " " + canTeleportMD + " " + toSUBToXD);
		}
		
		if(x-realY>195 && x-realY<200) {
			int canTeleportMD = x-realY;
			int toADDToXD = 200 - canTeleportMD;
			x = x + toADDToXD;
			//System.out.println("This is X, canTeleprtMDOWN, and toAddToXU: " + x + " " + canTeleportMD + " " + toADDToXD);
		}
		
		if(x<215 && y>565 && canComeBackBL==true) {
		//	System.out.println("came");
			//chomp.play();
			score += 40;
			//System.out.println(score);
			canComeBackBL = false;
			ghostDanger = true;
		}
		
		if(x>975 && y>565 && canComeBackBR==true) {
		//	System.out.println("came");
			//chomp.play();
			score += 40;
		//	System.out.println(score);
			canComeBackBR = false;
			ghostDanger = true;
		}
		
		if(y-40==realX-10 && WallArray.hasBigSpot[updatedX/20][updatedY/20]==false) {
			WallArray.hasBigSpot[updatedX/20][updatedY/20] = true;
			dotCount++;
			chomp.play();
			score = score + 10;
		//	System.out.println(score);
		}
		
		if(y-40==realX-10 && updatedX/20==27 && updatedY/20==0){
			
			if(WallArray.canFlashBL){
				chomp.play();
				dotCount++;
			score = score + 10;
			}
			WallArray.canFlashBL = false;
		}
		
		if(y-40==realX-10 && updatedX/20==27 && updatedY/20==40){
			
			if(WallArray.canFlashBR){
				chomp.play();
				dotCount++;
			score = score + 10;
			}
			WallArray.canFlashBR = false;
		}
	
		if(x % 20 != 0 || y % 20 != 0) canSkip = true;
		
		if(y % 20 != 0 && canSkip==true){
				this.y = oldy + 2;
				shouldReturn = true;
				oldy = this.y;
		}
		
		else {
			shouldReturn = false;
		}
		
		if(shouldReturn==true) {
			return;
		}
		
		canSkip = false;
		if(id==1 && x < 1000){
			realY = x - 200;
			updatedY = realY;
			updatedY = realY + 20;
		
			if(WallArray.allowMovement[updatedX/20][updatedY/20]==true && x < 1000 && canSkip == false && 
					x % 20 == 0 && y % 20 == 0) {
				updatedY = realY;
				canSkip = false;
				movingRight = true;
				movingUp = false;
				return;
			}
			updatedY = realY;
		}
		if(id==2 && x>200 && updatedY>0){
			realY = x - 200;
			updatedY = realY;
			updatedY = realY - 20;
			
			if(WallArray.allowMovement[updatedX/20][updatedY/20]==true && this.x >= 201 && updatedY>0 && canSkip==false && 
					x % 20 == 0 && y % 20 == 0){
				updatedY = realY;
				canSkip = false;
				movingLeft = true;
				movingUp = false;
				return;
			}
			updatedY = realY;
		}
		if(realX==540){
			movingDown = false;
		}
		if(y==580) movingDown = false;
		realX = y - 40;
		if(movingDown) updatedX = realX + 20;

		if(WallArray.allowMovement[(int)updatedX/20][(int)updatedY/20]==true && this.y <= 580 && canSkip == false && 
				x % 20 == 0 && y % 20 == 0 && movingDown) {
			faceRight = false;
			faceUp = false;
			faceLeft = false;
			faceDown = true;
			this.y = oldy + 2;
			oldy = this.y;
			realX = updatedX;
			canSkip = true;
			//canMove = false;
		}
		else {
			updatedX = realX;
			movingDown = false;
			canSkip = false;
			wasMovingDown = true;
			if(id==4){
				movingUp = true;
				movingRight = false;
				movingLeft = false;
			}
			if(id==2){
				movingUp = false;
				movingRight = false;
				movingLeft = true;
			}
			if(id==1){
				movingUp = false;
				movingRight = true;
				movingLeft = false;
			}
		}
	}
	
	public void movingRight(){
		
		movingLeft = false;
		
		if(id==2) {
			movingLeft=true;
			movingRight=false;
			movingUp=false;
			movingDown=false;
			return;
		}
		
		if(y-realX>40 && y-realX<45) {
			int canTeleportMR = y-realX;
			int toSubToYR = canTeleportMR - 40;
			y = y - toSubToYR;
		}
		
		if(y-realX>35 && y-realX<40) {
			int canTeleportMR = y-realX;
			int toAddToYR = 40 - canTeleportMR;
			y = y + toAddToYR;
		}
		
		if(x>965 && y<55 && canComeBackTR==true) {
			//System.out.println("came");
			//chomp.play();
			score += 40;
			//System.out.println(score);
			canComeBackTR = false;
			ghostDanger = true;
		}
		
		if(x>975 && y>565 && canComeBackBR==true) {
		//	System.out.println("came");
			//chomp.play();
			score += 40;
			//System.out.println(score);
			canComeBackBR = false;
			ghostDanger = true;
		}
		
		if(x-200==realY-10 && WallArray.hasBigSpot[updatedX/20][updatedY/20]==false) {
			WallArray.hasBigSpot[updatedX/20][updatedY/20] = true;
			dotCount++;
			chomp.play();
			score = score + 10;
		}
		
		if(x-200==realY-10 && updatedX/20==0 && updatedY/20==40){
			
			if(WallArray.canFlashTR){
				chomp.play();
				dotCount++;
			score = score + 10;
			}
			WallArray.canFlashTR = false;
		}
		
		if(x-200==realY-10 && updatedX/20==27 && updatedY/20==40){
			
			if(WallArray.canFlashBR){
				chomp.play();
				dotCount++;
			score = score + 10;
			}
			WallArray.canFlashBR = false;
		}
		
		if(x==1000 && y==300){	
			x = 200;
			oldx = x;
			realY = x - 200;
			updatedY = realY;
			WallArray.hasBigSpot[13][0]=true;
		}
		if(realY>800) movingRight = false;
		
		if(x % 20 != 0) canSkip = true;
		
		if(x % 20 != 0 && canSkip==true){
				this.x = oldx + 2;
				shouldReturn = true;
				oldx = this.x;
		}
		
		else {
			shouldReturn = false;
		}
		
		if(shouldReturn==true) {
			return;
		}
		
		canSkip = false;
		
		if(id==4 && y > 40 && updatedX>0){
			realX = y - 40;
			updatedX = realX;
			updatedX = realX - 20;
		
			if(WallArray.allowMovement[updatedX/20][updatedY/20]==true && y > 40 && updatedX>0 && canSkip==false && 
					x % 20 == 0 && y % 20 == 0){
				updatedX = realX;
				canSkip = false;
				movingUp = true;
				movingRight = false;
				return;
			}
			updatedX = realX;
		}
		if(id==3 && y < 580 && realX<540){
			realX = y - 40;
			
			updatedX = realX;
		
			updatedX = realX + 20;
		
			if(WallArray.allowMovement[updatedX/20][updatedY/20]==true && y < 580 && realX<540 && canSkip==false && 
					x % 20 == 0 && y % 20 == 0){
				updatedX = realX;
				canSkip = false;
				movingDown = true;
				movingRight = false;
				return;
			}
			updatedX = realX;
		}
		
		if(x==1000) movingRight = false;
		
		if(updatedY==800) movingRight = false;
		
		realY = x - 200;
		if(movingRight) updatedY = realY + 20;
	
		if(WallArray.allowMovement[(int)updatedX/20][(int)updatedY/20]==true && this.x <= 1000 && canSkip == false && 
				x % 20 == 0 && y % 20 == 0 && movingRight) {
			faceUp = false;
			faceDown = false;
			faceLeft = false;
			faceRight = true;
			this.x = oldx + 2;
			oldx = this.x;
			realY = updatedY;
			canSkip = true;
		}
		else {
			updatedY = realY;
			movingRight = false;
			canSkip = false;
			if(id==4){
				movingUp = true;
				movingLeft = false;
				movingDown = false;
			}
			if(id==2){
				movingUp = false;
				movingLeft = true;
				movingDown = false;
			}
			if(id==3){
				movingUp = false;
				movingLeft = false;
				movingDown = true;
			}
		}
	}
	

	public void movingLeft(){
		
		if(id==1) {
			movingLeft=false;
			movingRight=true;
			movingUp=false;
			movingDown=false;
			return;
		}
		if(y-realX>40 && y-realX<45) {
			canTeleportMROL = y-realX;
			toAddToYROL = canTeleportMROL - 40;
			y = y - toAddToYROL;
		}
		
		if(y-realX>35 && y-realX<40) {
			canTeleportMROL = y-realX;
			toAddToYROL = 40 - canTeleportMROL;
			y = y + toAddToYROL;
		}
		
		if(x<215 && y<55 && canComeBackTL==true) {
		//	System.out.println("came");
		//	chomp.play();
			score += 40;
		//	System.out.println(score);
			canComeBackTL = false;
			ghostDanger = true;
		}
		
		if(x<215 && y>565 && canComeBackBL==true) {
		//	System.out.println("came");
		//	chomp.play();
			score += 40;
		//	System.out.println(score);
			canComeBackBL = false;
			ghostDanger = true;
		}
		
		if(x-200==realY+10 && WallArray.hasBigSpot[updatedX/20][updatedY/20]==false) {
			WallArray.hasBigSpot[updatedX/20][updatedY/20] = true;
			chomp.play();
			dotCount++;
			score = score + 10;
		//	System.out.println(score);
		}
		
		if(x-200==realY+10 && updatedX/20==0 && updatedY/20==0){
			
			if(WallArray.canFlashTL){
				chomp.play();
			dotCount++;
			score = score + 10;
			}
			WallArray.canFlashTL = false;
		}
		
		if(x-200==realY+10 && updatedX/20==27 && updatedY/20==0){
			
			if(WallArray.canFlashBL){
				chomp.play();
				dotCount++;
			score = score + 10;
			}
			WallArray.canFlashBL = false;
		}
		
		if(x==200 && y==300){
			x = 1000;
			oldx = x;
			realY = x - 200;
			updatedY = realY;
			WallArray.hasBigSpot[13][40]=true;
		}
		
		if(realY<0) movingLeft=false;
		
		if(x % 20 !=0 || y % 20 != 0) canSkip = true;
		
		if(x % 20 != 0 && canSkip==true){
			this.x = oldx - 2;
			shouldReturn = true;
			oldx = this.x;
	}
	
	else {
		shouldReturn = false;
	}
	
	if(shouldReturn==true) {
		return;
	}
	
	canSkip = false;
		
	if(id==4&& y > 40 && updatedX>0){
		realX = y - 40;
		
		updatedX = realX;
	
		updatedX = realX - 20;
	
		if(WallArray.allowMovement[updatedX/20][updatedY/20]==true && y > 40 && updatedX>0 && canSkip==false && 
				x % 20 == 0 && y % 20 == 0){
			updatedX = realX;
			canSkip = false;
			movingUp = true;
			movingLeft = false;
			return;
		}
		updatedX = realX;
	}
	if(id==3 && y < 580 && realX<540){
		realX = y - 40;
		updatedX = realX;
		updatedX = realX + 20;

		if(WallArray.allowMovement[updatedX/20][updatedY/20]==true && y < 580 && realX<540 && canSkip==false && 
				x % 20 == 0 && y % 20 == 0){
			updatedX = realX;
			canSkip = false;
			movingDown = true;
			movingLeft = false;
			return;
		}
		updatedX = realX;
	}
	
		if(updatedY==0) movingLeft=false;
		
		realY = x - 200;
		
		updatedY = realY;
		
		if(x==200) movingLeft=false;
		if(movingLeft) updatedY = realY - 20;
		
		if(WallArray.allowMovement[(int)updatedX/20][(int)updatedY/20]==true && this.x >= 201 && updatedY>=0 && canSkip==false && 
				x % 20 == 0 && y % 20 == 0 && movingLeft==true){
			faceUp = false;
			faceDown = false;
			faceRight = false;
			faceLeft = true;
			this.x = oldx - 2;
			oldx = this.x;
			realY = updatedY;
			//canMove = false;
			canSkip = true;
		}
		else {
			updatedY = realY;
			movingLeft = false;
			canSkip = false;
			if(id==1){
				movingUp = false;
				movingRight = true;
				movingDown = false;
			}
			if(id==4){
				movingUp = true;
				movingRight = false;
				movingDown = false;
			}
			if(id==3){
				movingUp = false;
				movingRight = false;
				movingDown = true;
			}
		}
		
	
		
	}

	public void keyReleased(KeyEvent e) {
		keyCode = e.getKeyCode();
	}
			
	public boolean moveLogic() {
		if(id==4){
			realX = y - 40;
			updatedX = realX;
			updatedX = realX - 20;
			if(WallArray.allowMovement[updatedX/20][updatedY/20]==true && this.y >= 40 && updatedX>=0  && 
					x % 20 == 0 && y % 20 == 0){
				realX = updatedX;
				return true;
			}
			else{
			updatedX = realX;
			return false;
			}
		}
		return false;
	}
}
	


	




