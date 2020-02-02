package pacMan;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;

public class Shrek {
	
	public static int x = 640;
	public static int y = 300;
	private static int height;
	private static int width;
	private static int height2;
	private Color bodyColor, eyeColor, pupilColor;
	private static int eyeRadius;
	private static int feetWidth;
	private static int feetHeight;
	private static int pupilRadius;
	private static int blueEyeRadius;
	private Pacman pacman;
	public boolean movingDown, movingUp, movingLeft, movingRight;
	public static int realX = y - 40;
	public static int realY = x - 200;
	public static int updatedX = realX;
	public static int updatedY = realY;
	public boolean canMove = true;
	public int firstMovement = 0;
	public int shrekfirstMovement = 0;
	public int shreksecondMovement = 0;
	public boolean shouldLeave = true;
	public boolean canSkip = false;
	public boolean shouldReturn = false;
	public int leftCount = 0;
	public int downCount = 0;
	public int rightCount = 0;
	public int upCount = 0;
	public boolean canMoveRandom = false;
	public boolean canBypassMovingUp = true;
	public static int smartCount;
	
	static{
		width = 20;
		height = 14;
		eyeRadius = (int) 2.5;
		pupilRadius = 1;
		blueEyeRadius = 3;
		height2 = 10;
		feetWidth = 5;
		feetHeight = 10;
	}
	
	public Shrek(Color _bodyColor, Color _eyeColor, Color _pupilColor){
		bodyColor = _bodyColor;
		eyeColor = _eyeColor;
		pupilColor = _pupilColor;
	}
	
	public static int getX(){return x;}
	public static int getY(){return y;}
	
	public void move(Pacman pacman){
		if(Coordinator.levelCount==0) smartCount = 15;
		if(Coordinator.levelCount==1) smartCount = 10;
		if(shrekfirstMovement<20){
			x = x - 2;
			shrekfirstMovement++;
			return;
		}
		
		if(shreksecondMovement<10){
			y = y - 2;
			shreksecondMovement++;
			return;
		}
		
		if(firstMovement<10){
			y = y - 2;
			firstMovement++;
			return;
	    }
		
		realX = y - 40;
		realY = x - 200;
		updatedX = realX;
		updatedY = realY;
		
	   if(pacman.y>y && shouldLeave == false ){
		   
					movingRight = false;
					movingLeft = false;
					movingUp = false;
					movingDown = true;
					
					
					
					 downCount++;
					if(downCount>smartCount) downCount = 0;
					   if(downCount>=1){
						   movingDown = false;
						   moveRandom();
						   return;
					   }
		}
	    
	    else if(pacman.y<y ){
	    	upCount++;
	    	if(upCount>smartCount) upCount = 0;
	    	if(upCount>=5){
	    		moveRandom();
	    		return;
	    	}
	    		movingRight = false;
				movingLeft = false;
				movingDown = false;
				movingUp = true;
				shouldLeave = false;
	    }
		
	    else if(pacman.x<=x ){
	    	leftCount++;
	    	if(leftCount>smartCount) leftCount = 0;
	    	if(leftCount>=5){
	    		moveRandom();
	    		return;
	    	}
					movingRight = false;
					movingDown = false;
					movingUp = false;
					movingLeft = true;
					realX = y - 40;
					realY = x - 200;
					updatedX = realX;
					updatedY = realY;
		}
		else if(pacman.x>=x){
			rightCount++;
			if(rightCount>smartCount) rightCount = 0;
			if(rightCount>=5){
				moveRandom();
				return;
			}
					movingLeft = false;
					movingDown = false;
					movingUp = false;
					movingRight = true;
					shouldLeave = false;
					realX = y - 40;
					realY = x - 200;
					updatedX = realX;
					updatedY = realY;			
	    }
	}
	
	public void moveRandom(){
		
		double whereToMove = Math.random();
		
    	if(whereToMove<0.25){
    		movingRight = false;
			movingLeft = false;
			movingDown = false;
			movingUp = true;
		}
	
    	else if(whereToMove>0.25 && whereToMove<0.50){
				movingRight = false;
				movingLeft = false;
				movingUp = false;
				movingDown = true;
    	}
	
    	else if(whereToMove>0.50 && whereToMove<0.75){
				movingRight = false;
				movingDown = false;
				movingUp = false;
				movingLeft = true;
    	}
    	
    	else if(whereToMove>0.75){
				movingLeft = false;
				movingDown = false;
				movingUp = false;
				movingRight = true;
	}	
	
	}
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(bodyColor);
		//x-width/2, y-height+1
		if(pacman.isToEatShrek){
			canvas.setColor(eyeColor);
			canvas.fillOval(x+4, y+7, 2*eyeRadius, 2*eyeRadius);
			canvas.fillOval(x+12, y+7, 2*eyeRadius, 2*eyeRadius);
			
			canvas.setColor(pupilColor);
			//canvas.fillOval(x-width/6-eyeRadius, y-height*3/4, 2*pupilRadius, 2*pupilRadius);//when moving up
			canvas.fillOval(x+5, y+8, 2*pupilRadius, 2*pupilRadius);//when moving down left eye
			canvas.fillOval(x+13, y+8, 2*pupilRadius, 2*pupilRadius);//when moving down right eye
			//canvas.fillOval(x-width/6-eyeRadius, y-height*3/5-2, 2*pupilRadius, 2*pupilRadius);//left eye normal
			//canvas.fillOval(x-width/6+14-eyeRadius, y-height*3/5-2, 2*pupilRadius, 2*pupilRadius);//right eye normal
			return;
		}
		if(Pacman.ghostDanger && pacman.isToEatShrek==false){
			if(pacman.aboutToFinishGD) canvas.setColor(Color.WHITE);
			else canvas.setColor(Color.BLUE);
			canvas.fillArc(x, y, 20, 14, 360, 180);//180 and 180 is upside down this is the head
			
			canvas.fillRect(x, y+5, 20, 10); // this is the body
			// these are the feet
			
			canvas.fillArc(x, y+10, feetWidth, feetHeight, 180, 180);
			canvas.fillArc(x+feetWidth, y+10, feetWidth, feetHeight, 180, 180);
			canvas.fillArc(x+feetWidth*2, y+10, feetWidth, feetHeight, 180, 180);
			canvas.fillArc(x+feetWidth*3, y+10, feetWidth, feetHeight, 180, 180);
			
			if(pacman.aboutToFinishGD) canvas.setColor(Color.RED);
			else canvas.setColor(eyeColor);
			canvas.fillRect(x+4, y+5, blueEyeRadius, blueEyeRadius);
			canvas.fillRect(x+12, y+5, blueEyeRadius, blueEyeRadius);
			
			if(pacman.aboutToFinishGD) canvas.setColor(Color.RED);
			else canvas.setColor(Color.WHITE);
			canvas.drawLine(x+3, y+13, x+5, y+11);
			canvas.drawLine(x+5, y+11, x+7, y+13);
			canvas.drawLine(x+7, y+13, x+9, y+11);
			canvas.drawLine(x+9, y+11, x+11, y+13);
			canvas.drawLine(x+11, y+13, x+13, y+11);
			canvas.drawLine(x+13, y+11, x+15, y+13);
			return;
		}
		canvas.fillArc(x, y, 20, 14, 360, 180);//180 and 180 is upside down this is the head
		
		canvas.fillRect(x, y+5, 20, 10); // this is the body
		// these are the feet
		
		canvas.fillArc(x, y+10, feetWidth, feetHeight, 180, 180);
		canvas.fillArc(x+feetWidth, y+10, feetWidth, feetHeight, 180, 180);
		canvas.fillArc(x+feetWidth*2, y+10, feetWidth, feetHeight, 180, 180);
		canvas.fillArc(x+feetWidth*3, y+10, feetWidth, feetHeight, 180, 180);
		
		canvas.setColor(eyeColor);
		canvas.fillOval(x+4, y+5, 2*eyeRadius, 2*eyeRadius);
		canvas.fillOval(x+12, y+5, 2*eyeRadius, 2*eyeRadius);
		
		canvas.setColor(pupilColor);
		if(movingUp || canBypassMovingUp){
			canvas.fillOval(x+5, y+5, 2*pupilRadius, 2*pupilRadius);//left eye up
			canvas.fillOval(x+13, y+5, 2*pupilRadius, 2*pupilRadius);//right eye up
		}
		if(movingLeft){
			canBypassMovingUp = false;
			canvas.fillOval(x+4, y+6, 2*pupilRadius, 2*pupilRadius);//left eye left
			canvas.fillOval(x+12, y+6, 2*pupilRadius, 2*pupilRadius);//right eye left
		}
		if(movingRight){
			canBypassMovingUp = false;
			canvas.fillOval(x+6, y+6, 2*pupilRadius, 2*pupilRadius);//left eye right
			canvas.fillOval(x+14, y+6, 2*pupilRadius, 2*pupilRadius);//right eye right
		}
		if(movingDown){
			canBypassMovingUp = false;
			canvas.fillOval(x+5, y+7, 2*pupilRadius, 2*pupilRadius);//left eye down
			canvas.fillOval(x+13, y+7, 2*pupilRadius, 2*pupilRadius);//right eye down
		}
		 
		 

}
	
	public void movingRight() {
		
		if(x==pacman.x && y!=pacman.y && x % 20 == 0 && y % 20 == 0 && pacman.ghostDanger==false){
			movingRight = false;
			canSkip = false;
			canMove = true;
			return;
			
		}
		
		if(realY>800) return;
		
				
		if(x % 20 != 0 && canSkip==true){
			
				x = x + 2;
				shouldReturn = true;
				
		}
		
		else {
			shouldReturn = false;
		}
		
		if(shouldReturn==true) {
			return;
		}
		
		canSkip = false;
		
		if(x==1000 && y==300){	
			x = 200;
			realY = x - 200;
			updatedY = realY;
		}
		
		if(x==1000){
			
				updatedY = realY;
				movingRight = false;
				canSkip = false;
				canMove = true;
				return;
			
			
		}
		
		if(updatedY==800) return;
		
		realY = x - 200;
		updatedY = realY + 20;
	
		if(WallArray.allowMovement[(int)updatedX/20][(int)updatedY/20]==true && this.x <= 1000 && canSkip == false && 
				x % 20 == 0 && y % 20 == 0) {			
			x = x + 2;
			realY = updatedY;
			canMove = false;
			canSkip = true;
		}
		else {
			updatedY = realY;
			movingRight = false;
			canSkip = false;
			canMove = true;
		}
		
	}

	public void movingLeft() {
		
		if(realY<0) return;
		
		if(x==pacman.x && y!=pacman.y && shouldLeave==false && x % 20 == 0 && y % 20 == 0 && pacman.ghostDanger==false) {
			
			movingLeft = false;
			canSkip = false;
			canMove = true;
			return;
		}
		
		if(x % 20 != 0 && canSkip==true){
			x = x - 2;
			shouldReturn = true;
			
	}
	
	else {
		shouldReturn = false;
	}
	
	if(shouldReturn==true) {
		return;
	}
	
	canSkip = false;
	
	if(x==200 && y==300){
		x = 1000;
		realY = x - 200;
		updatedY = realY;
	}
	
	if(x==200) {
		updatedY = realY;
		movingLeft = false;
		canSkip = false;
		canMove = true;
		return;
	}
		
		if(updatedY==0) return;
		
		
		
		realY = x - 200;
		
		updatedY = realY;
		
		if(x==200) {
			updatedY = realY;
			movingLeft = false;
			canSkip = false;
			canMove = true;
			return;
		}
		updatedY = realY - 20;
		
		if(WallArray.allowMovement[(int)updatedX/20][(int)updatedY/20]==true && this.x >= 201 && updatedY>=0 && canSkip==false && 
				x % 20 == 0 && y % 20 == 0){
			x = x - 2;
			realY = updatedY;
			canMove = false;
			canSkip = true;
			canMoveRandom = false;
			
		}
		else {
			updatedY = realY;
			movingLeft = false;
			canSkip = false;
			canMove = true;
			shouldLeave = false;
			canMoveRandom = true;
		}
		
	}

	public void movingDown() {
		movingLeft = false;
		movingUp = false;
		movingRight = false;
		//System.out.println("moving down");
		if(y==pacman.y && x!=pacman.x && x % 20 == 0 && y % 20 == 0 && pacman.ghostDanger==false){
			//System.out.println("haha: " + x + " " + y);
			//System.out.println("glitch");
			movingDown = false;
			canSkip = false;
			canMove = true;
			return;
			
		}
		
		
		
		if(y % 20 != 0 && canSkip==true){
				y = y + 2;
				shouldReturn = true;
				
		}
		
		else {
			shouldReturn = false;
		}
		
		if(shouldReturn==true) {
			
			return;
		}
		
		canSkip = false;
		
		if(y==580){
			updatedX = realX;
			movingDown = false;
			canSkip = false;
			canMove = true;
			return;
		}
		
		if(realX==540){
			return;
		}
		if(y==580) return;
		realX = y - 40;
		updatedX = realX + 20;

		if(WallArray.allowMovement[(int)updatedX/20][(int)updatedY/20]==true && this.y <= 580 && canSkip == false && 
				x % 20 == 0 && y % 20 == 0) {
			
			y = y + 2;
			realX = updatedX;
			canSkip = true;
			canMove = false;
			canMoveRandom = false;
		}
		else {
			
			
			updatedX = realX;
			movingDown = false;
			canSkip = false;
			canMove = true;
			canMoveRandom = true;
			
		}
	}
	
	public void movingUp() {
		
		//System.out.println("moving up");
		
		if(y==pacman.y && x!=pacman.x && x % 20 == 0 && y % 20 == 0 && pacman.ghostDanger==false){
			movingDown = false;
			canSkip = false;
			canMove = true;
			return;
		}
		
		
		
		if(y % 20 != 0 && x % 20 == 0 && canSkip==true){
			//System.out.println("going to cheat: " + y);
			y = y - 2;
			shouldReturn = true;
	}
	
	else {
		shouldReturn = false;
	}
	
	if(shouldReturn==true) {
		return;
	}
	
	canSkip = false;
		
	if(y==40){
		updatedX = realX;
		movingDown = false;
		canSkip = false;
		canMove = true;
		return;
	}
	
		
		
		realX = y - 40;
		
		updatedX = realX;
	
		if(y==40) return;
	
		updatedX = realX - 20;

		if(WallArray.allowMovement[(int)updatedX/20][(int)updatedY/20]==true && this.y >= 40 && updatedX>=0 && canSkip==false
				&& x % 20 == 0 && y % 20 == 0){
						y = y - 2;
			realX = updatedX;
			canMove = false;
			canSkip = true;
			canMoveRandom = false;
			
		}
		else {
			
			updatedX = realX;
			movingUp = false;
			canSkip = false;
			canMove = true;
			canMoveRandom = true;
			
		}
		
	}
}


