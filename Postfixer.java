package Project;
import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import enigma.console.TextAttributes;
import java.awt.Color;
public class Postfixer {
	   public static int sas=0;
	   public static int sec=61;
	   public enigma.console.Console cn = Enigma.getConsole("Post-Fixer");
	   
	   public TextMouseListener tmlis; 
	   public KeyListener klis; 

	   // ------ Standard variables for mouse and keyboard ------
	   public int mousepr;          // mouse pressed?
	   public int mousex, mousey;   // mouse text coords.
	   public int keypr;   // key pressed?
	   public int rkey;    // key   (for press/release)
	   
	   boolean help = true;
	   // ----------------------------------------------------
	   public char entry=' ';
	   
	   Postfixer() throws Exception {   // --- Contructor
	                 
	      // ------ Standard code for mouse and keyboard ------ Do not change
	      tmlis=new TextMouseListener() {
	         public void mouseClicked(TextMouseEvent arg0) {}
	         public void mousePressed(TextMouseEvent arg0) {
	            if(mousepr==0) {
	               mousepr=1;
	               mousex=arg0.getX();
	               mousey=arg0.getY();
	            }
	         }
	         public void mouseReleased(TextMouseEvent arg0) {}
	      };
	      cn.getTextWindow().addTextMouseListener(tmlis);
	    
	      klis=new KeyListener() {
	         public void keyTyped(KeyEvent e) {}
	         public void keyPressed(KeyEvent e) {
	            if(keypr==0) {
	               keypr=1;
	               rkey=e.getKeyCode();
	            }
	         }
	         public void keyReleased(KeyEvent e) {}
	      };
	      cn.getTextWindow().addKeyListener(klis);
	      // ----------------------------------------------------
	      

	      int px=5,py=5;
	      cn.getTextWindow().setCursorType(0);
	        Start a1 = new Start();
	        int time =60;
	        String mode ="Free";
	        cn.getTextWindow().setCursorPosition(0, 0);	               
	        a1.queueFeeder();
	        a1.board();
	        Timer sayaç = new Timer();
	        TimerTask tt = new TimerTask() 
  	        {
  	            

  	            public void run() //timertask içindeki built in method
  	            {     	           
  	               if(sas==0) {
  	            	   sas=1;
  	                sec--;
  	                if (sec < 0) 
  	                {
  	                    sayaç.cancel();
  	                }
  	               }
  	            }
  	        };
  	      sayaç.schedule(tt, 0, 1000); 
	        while(true) {
	        	mode="Free";
	        	a1.boardfeeding();
	        	cn.getTextWindow().setCursorPosition(13, 7);
		        a1.feeder.display(a1.feeder);
	        	cn.getTextWindow().setCursorPosition(0, 0);
	        	a1.boardDisplay();
//	         if(mousepr==1) {  // if mouse button pressed
//	            cn.getTextWindow().output(mousex,mousey,'#');  // write a char to x,y position without changing cursor position
//	            px=mousex; py=mousey;
//	            
//	            mousepr=0;     // last action  
//	         }
	        
	         if(keypr==1) {    // if keyboard button pressed
	            if(rkey==KeyEvent.VK_LEFT&&px!=0) px--;   
	            if(rkey==KeyEvent.VK_RIGHT&&px!=9) px++; //OUT OF RANGE EXCEPTION
	            if(rkey==KeyEvent.VK_UP&&py!=0) py--;
	            if(rkey==KeyEvent.VK_DOWN&&py!=9) py++;
	            
	            //char rckey=(char)rkey;
	            //        left          right          up            down
	          //  if(rckey=='%' || rckey=='\'' || rckey=='&' || rckey=='(') cn.getTextWindow().output(px,py,'P'); // VK kullanmadan test teknigi
	          //  else cn.getTextWindow().output(rckey);
	            
	            if(rkey==KeyEvent.VK_SPACE) {
	               String str;         
	               str=cn.readLine();     // keyboardlistener running and readline input by using enter 
	               cn.getTextWindow().setCursorPosition(5, 20);
	               cn.getTextWindow().output(str);
	            }
	            
	            keypr=0;    // last action  
	         }
	         cn.getTextWindow().setCursorPosition(px, py);
	         
	         
	         Thread.sleep(20);
	         
//	         cn.getTextWindow().setCursorPosition(20, 0);
//	         System.out.println("X :"+ (px));
//	         cn.getTextWindow().setCursorPosition(25, 0);
//	         System.out.println("Y :"+ (py));
//	         cn.getTextWindow().setCursorPosition(30, 0);
//	         System.out.print("Board element : ");
	         int c1=26;  //expression coordinates
	         int c2 =9;
	         cn.getTextWindow().setCursorPosition(13, 6);
	         System.out.println("<<<<<<<<");
	         cn.getTextWindow().setCursorPosition(13, 7);
	         a1.feeder.display(a1.feeder);
	         cn.getTextWindow().setCursorPosition(13, 8);
	         System.out.println("<<<<<<<<");
	         cn.getTextWindow().setCursorPosition(25, 0);
	         System.out.println("Time : "+sec);
	         cn.getTextWindow().setCursorPosition(25, 1);
	         System.out.println("Score : "+a1.score);
	         cn.getTextWindow().setCursorPosition(25, 2);
	         System.out.println("Mode : "+mode + " Mode");
	         cn.getTextWindow().setCursorPosition(13, 9);
	         System.out.println("Expression :                         ");
	         cn.getTextWindow().setCursorPosition(50, 2);
	         System.out.println("|       |");
	         cn.getTextWindow().setCursorPosition(50, 3);
	         System.out.println("|       |");
	         cn.getTextWindow().setCursorPosition(50, 4);
	         System.out.println("|       |");
	         cn.getTextWindow().setCursorPosition(50, 5);
	         System.out.println("|       |");
	         cn.getTextWindow().setCursorPosition(50, 6);
	         System.out.println("|       |");
	         cn.getTextWindow().setCursorPosition(50, 7);
	         System.out.println("|       |");
	         cn.getTextWindow().setCursorPosition(50, 8);
	         System.out.println("+-------+");
	         
	         // take mode if'i burda olacak
	         
  	       
	         		
	         if(rkey==KeyEvent.VK_T) { //TAKE MODE
	        	 mode = "Take";
	        	 cn.getTextWindow().setCursorPosition(32, 2);
	        	 System.out.println("Take Mode");
	        	 keypr=0;
	        	 
     	       
	        	 
     	       
    	        
     	       
	        	 while(true) {
	        		 if (sas==1) {
	 					sas=0;
	 					cn.getTextWindow().setCursorPosition(32, 0);
	 					System.out.println(sec);
	 				}
	        		 
	        	if(rkey==KeyEvent.VK_LEFT&& keypr==1&& px!=0) {
	        		keypr=0;
	        	 while(true) {
	        		 keypr=0;
	        		 px--;
	        		 
	        		 cn.getTextWindow().setCursorPosition(px, py);
	        		 if (a1.take(px, py)!='.'&& px!=0) {           // PX = 0
	        			 
	        			 if(a1.take(px-1, py)=='.') {	       //ONE ELEMENTS CONTROL
	        				 cn.getTextWindow().setCursorPosition(c1, c2);
	        				 c1=c1+2;
	        				 System.out.println(a1.take(px, py));
	        				 a1.e.enqueue(a1.take(px, py)); //Enqueue for evaluation
	        				 a1.changeCoordinateToNull(px, py);
	        				 cn.getTextWindow().setCursorPosition(0, 0);
	        				 a1.boardDisplay();
	        				 
						 break;
	        			 }
	        			 	        			 
					}
	        		 
	        		 if(px !=0 && (a1.take(px, py)=='*' || a1.take(px, py)=='-' || a1.take(px, py)=='+' || a1.take(px, py)=='/') && a1.take(px-1, py)!='.' ) { //FIRST ELEMENT OPERATION CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+2;
        				 System.out.println(a1.take(px, py));
        				 a1.e.enqueue(a1.take(px, py)); //Enqueue for evaluation
	        			 a1.changeCoordinateToNull(px, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 
	        			 break;
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && px!=0 && (a1.take(px-1, py)=='*' || a1.take(px-1, py)=='-' || a1.take(px-1, py)=='+' || a1.take(px-1, py)=='/') ) { //FIRST NUMBER SECOND OPERATION CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+2;
        				 System.out.println(a1.take(px, py));
        				 a1.e.enqueue(a1.take(px, py)); //Enqueue for evaluation
	        			 a1.changeCoordinateToNull(px, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 
	        			 break;
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && px!=1 && px!=0 &&  a1.take(px-1, py)!='.' && (a1.take(px-2, py)=='*' || a1.take(px-2, py)=='-' || a1.take(px-2, py)=='+' || a1.take(px-2, py)=='/') ) { //FIRST 2 NUMBERS THIRD OPERATION CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+3;
        				 a1.twoConcatenater(a1.take(px-1, py),a1.take(px, py));
        				 a1.e.enqueue(a1.r1);
	        			 a1.changeCoordinateToNull(px, py);
	        			 a1.changeCoordinateToNull(px-1, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 px--;
	        			 break;
	        		 }
	        		 
	        		 
	        		 if (a1.take(px, py)!='.'&& px!=0 && px!=1) {  // PX = 1
	        			 
	        			 if(a1.take(px-1, py)!='.' && a1.take(px-2, py)=='.') {      //TWO ELEMENTS CONTROL
	        				 cn.getTextWindow().setCursorPosition(c1, c2);
	        				 c1=c1+3;
	        				 a1.twoConcatenater(a1.take(px-1, py),a1.take(px, py));
	        				 a1.e.enqueue(a1.r1);
        					 a1.changeCoordinateToNull(px, py);
        					 a1.changeCoordinateToNull(px-1, py);
        					 cn.getTextWindow().setCursorPosition(0, 0);
        					 a1.boardDisplay();
        					 px--;
        					 break;
        				 }
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && px!=0 && px!=1 && px !=2) { // PX = 2
	        			 
	        			 if (a1.take(px-1, py)!='.' && a1.take(px-2, py)!='.' && a1.take(px-3, py) == '.') { //THREE ELEMENTS CONTROL
	        				 cn.getTextWindow().setCursorPosition(c1, c2);
	        				 c1=c1+4;
	        				a1.threeConcatenater(a1.take(px-2, py), a1.take(px-1, py), a1.take(px, py));
	        				a1.e.enqueue(a1.r2);
							a1.changeCoordinateToNull(px, py);
							a1.changeCoordinateToNull(px-1, py);
							a1.changeCoordinateToNull(px-2, py);
							cn.getTextWindow().setCursorPosition(0, 0);
							a1.boardDisplay();
							px=px-2;
							break;
						}
	        		 }
	        		 if (a1.take(px, py)!='.'&& px!=0 && px!=1 && px!=2 && px!=3 ) {  // PX = 3
	        			 
	        			 if(a1.take(px-1, py)!='.' && a1.take(px-2, py)!='.' && a1.take(px-3, py)!='.' && a1.take(px-4, py)=='.') {      //FOUR ELEMENTS CONTROL
	        				 cn.getTextWindow().setCursorPosition(c1, c2);
	        				 c1=c1+5;
	        				 a1.fourConcatenater(a1.take(px-3, py), a1.take(px-2, py), a1.take(px-1, py), a1.take(px, py));
	        				 a1.e.enqueue(a1.r3);
        					 a1.changeCoordinateToNull(px, py);
        					 a1.changeCoordinateToNull(px-1, py);
        					 a1.changeCoordinateToNull(px-2, py);
        					 a1.changeCoordinateToNull(px-3, py);
        					 cn.getTextWindow().setCursorPosition(0, 0);
        					 a1.boardDisplay();
        					 px=px-3;
        					 break;
        				 }
	        		 }
	        		 
	        		 
	        		 if(a1.take(px, py)!='.' && px==0 && a1.take(px+1, py) == '.') { //PX = 0 CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+2;
        				 System.out.println(a1.take(px, py));
        				 a1.e.enqueue(a1.take(px, py));
	        			 a1.changeCoordinateToNull(px, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 break;
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && a1.take(px-1, py)!='.' && px ==1 && a1.take(px+1, py)=='.') { //PX = 1 CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+3;
	        			 a1.twoConcatenater(a1.take(px-1, py), a1.take(px, py));
	        			 a1.e.enqueue(a1.r1);
	        			 a1.changeCoordinateToNull(px, py);
	        			 a1.changeCoordinateToNull(px-1, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 px--;
	        			 break;
	        		 }
	        		 if(a1.take(px, py)!='.' && a1.take(px-1, py)!='.' && a1.take(px-2, py)!='.' && px==2 && a1.take(px+1, py)== '.') { //PX = 2 CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+4;
	        			 a1.threeConcatenater(a1.take(px-2, py), a1.take(px-1, py), a1.take(px, py));
	        			 a1.e.enqueue(a1.r2);
	        			 a1.changeCoordinateToNull(px, py);
	        			 a1.changeCoordinateToNull(px-1, py);
	        			 a1.changeCoordinateToNull(px-2, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 px=px-2;
	        			 break;
	        		 }
	        		 if(a1.take(px, py)!='.' && a1.take(px-1, py) != '.' && a1.take(px-2, py) !='.' && a1.take(px-3, py)!='.' && px==3 && a1.take(px+1, py)=='.') { //PX = 3 CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+5;
        				 a1.fourConcatenater(a1.take(px-3, py), a1.take(px-2, py), a1.take(px-1, py), a1.take(px, py));
        				 a1.e.enqueue(a1.r3);
        				 a1.changeCoordinateToNull(px, py);
        				 a1.changeCoordinateToNull(px-1, py);
        				 a1.changeCoordinateToNull(px-2, py);
        				 a1.changeCoordinateToNull(px-3, py);
        				 cn.getTextWindow().setCursorPosition(0, 0);
        				 a1.boardDisplay();
        				 px=px-3;
        				 break;
	        		 
	        		 }
	        		 else if(px==0) {
	        			 break;
	        		 }
	        		 keypr=0;
	        	 }
	        	keypr=0; 
	        	 
	        	 
	        	
	        	 
	         }
	         
	         
	         else if(rkey==KeyEvent.VK_RIGHT && keypr==1 && px!=10) {
	        	 keypr=0;
	        	 while(true) {
	        		 keypr=0;
	        		 
	        		 cn.getTextWindow().setCursorPosition(px, py);
	        		 
	   
	        		 if (a1.take(px, py)!='.'&& px!=9) {           // PX = 9
	        			 
	        			 if(a1.take(px+1, py)=='.') {	       //ONE ELEMENTS CONTROL
	        				 cn.getTextWindow().setCursorPosition(c1, c2);
	        				 c1=c1+2;
	        				 System.out.println(a1.take(px, py));
	        				 a1.e.enqueue(a1.take(px, py));
	        				 a1.changeCoordinateToNull(px, py);
	        				 cn.getTextWindow().setCursorPosition(0, 0);
	        				 a1.boardDisplay();
	        				 px++;
	        				 
						 break;
	        			 }
	        			 	        			 
					}
	        		 
	        		 if(px !=9 && (a1.take(px, py)=='*' || a1.take(px, py)=='-' || a1.take(px, py)=='+' || a1.take(px, py)=='/') && a1.take(px+1, py)!='.' ) { //FIRST ELEMENT OPERATION CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+2;
        				 System.out.println(a1.take(px, py));
        				 a1.e.enqueue(a1.take(px, py));
	        			 a1.changeCoordinateToNull(px, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 px++;
	        			 
	        			 break;
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && px!=9 && (a1.take(px+1, py)=='*' || a1.take(px+1, py)=='-' || a1.take(px+1, py)=='+' || a1.take(px+1, py)=='/') ) { //FIRST NUMBER SECOND OPERATION CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+2;
        				 System.out.println(a1.take(px, py));
        				 a1.e.enqueue(a1.take(px, py));
	        			 a1.changeCoordinateToNull(px, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 px++;
	        			 
	        			 break;
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && px!=8 && px!=9 &&  a1.take(px+1, py)!='.' && (a1.take(px+2, py)=='*' || a1.take(px+2, py)=='-' || a1.take(px+2, py)=='+' || a1.take(px+2, py)=='/') ) { //FIRST 2 NUMBERS THIRD OPERATION CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+3;
	        			 a1.twoConcatenater(a1.take(px+1, py), a1.take(px, py));
	        			 a1.e.enqueue(a1.r1);
	        			 a1.changeCoordinateToNull(px, py);
	        			 a1.changeCoordinateToNull(px+1, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 px=px+2;
	        			 break;
	        		 }
	        		 
	        		 if (a1.take(px, py)!='.'&& px!=9 && px!=8) {  // PX = 8
	        			 
	        			 if(a1.take(px+1, py)!='.' && a1.take(px+2, py)=='.') {      //TWO ELEMENTS CONTROL
	        				 cn.getTextWindow().setCursorPosition(c1, c2);
	        				 c1=c1+3;
		        			 a1.twoConcatenater(a1.take(px+1, py), a1.take(px, py));
		        			 a1.e.enqueue(a1.r1);
        					 a1.changeCoordinateToNull(px, py);
        					 a1.changeCoordinateToNull(px+1, py);
        					 cn.getTextWindow().setCursorPosition(0, 0);
        					 a1.boardDisplay();
        					 px=px+2;
        					 break;
        				 }
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && px!=9 && px!=8 && px !=7) { // PX = 7
	        			 
	        			 if (a1.take(px+1, py)!='.' && a1.take(px+2, py)!='.' && a1.take(px+3, py) == '.') { //THREE ELEMENTS CONTROL
	        				 cn.getTextWindow().setCursorPosition(c1, c2);
	        				c1=c1+4;
		        			a1.threeConcatenater(a1.take(px+2, py), a1.take(px+1, py), a1.take(px, py));
		        			a1.e.enqueue(a1.r2);
							a1.changeCoordinateToNull(px, py);
							a1.changeCoordinateToNull(px+1, py);
							a1.changeCoordinateToNull(px+2, py);
							cn.getTextWindow().setCursorPosition(0, 0);
							a1.boardDisplay();
							px=px+3;
							break;
						}
	        		 }
	        		 if (a1.take(px, py)!='.'&& px!=9 && px!=8 && px!=7 && px!=6 ) {  // PX = 6
	        			 
	        			 if(a1.take(px+1, py)!='.' && a1.take(px+2, py)!='.' && a1.take(px+3, py)!='.' && a1.take(px+4, py)=='.') {      //FOUR ELEMENTS CONTROL
	        				 cn.getTextWindow().setCursorPosition(c1, c2);
	        				 c1=c1+5;
	        				 a1.fourConcatenater(a1.take(px+3, py), a1.take(px+2, py), a1.take(px+1, py), a1.take(px, py));
	        				 a1.e.enqueue(a1.r3);
        					 a1.changeCoordinateToNull(px, py);
        					 a1.changeCoordinateToNull(px+1, py);
        					 a1.changeCoordinateToNull(px+2, py);
        					 a1.changeCoordinateToNull(px+3, py);
        					 cn.getTextWindow().setCursorPosition(0, 0);
        					 a1.boardDisplay();
        					 px=px+3;
        					 break;
        				 }
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && px==9 && a1.take(px-1, py) == '.') { //PX = 9 CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+2;
        				 System.out.println(a1.take(px, py));
        				 a1.e.enqueue(a1.take(px, py));
	        			 a1.changeCoordinateToNull(px, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 break;
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && a1.take(px+1, py)!='.' && px ==8 && a1.take(px-1, py)=='.') { //PX = 8 CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+3;
	        			 a1.twoConcatenater(a1.take(px+1, py), a1.take(px, py));
	        			 a1.e.enqueue(a1.r1);
	        			 a1.changeCoordinateToNull(px, py);
	        			 a1.changeCoordinateToNull(px+1, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 px++;
	        			 break;
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && a1.take(px+1, py)!='.' && a1.take(px+2, py)!='.' && px==7 && a1.take(px-1, py)== '.') { //PX = 7 CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+4;
	        			 a1.threeConcatenater(a1.take(px+2, py), a1.take(px+1, py), a1.take(px, py));
	        			 a1.e.enqueue(a1.r2);
	        			 a1.changeCoordinateToNull(px, py);
	        			 a1.changeCoordinateToNull(px+1, py);
	        			 a1.changeCoordinateToNull(px+2, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 px=px+2;
	        			 break;
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && a1.take(px+1, py) != '.' && a1.take(px+2, py) !='.' && a1.take(px+3, py)!='.' && px==6 && a1.take(px-1, py)=='.') { //PX = 6 CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+5;
        				 a1.fourConcatenater(a1.take(px+3, py), a1.take(px+2, py), a1.take(px+1, py), a1.take(px, py));
        				 a1.e.enqueue(a1.r3);
        				 a1.changeCoordinateToNull(px, py);
        				 a1.changeCoordinateToNull(px+1, py);
        				 a1.changeCoordinateToNull(px+2, py);
        				 a1.changeCoordinateToNull(px+3, py);
        				 cn.getTextWindow().setCursorPosition(0, 0);
        				 a1.boardDisplay();
        				 px=px+3;
        				 break;
	        		 
	        		 }
	        		 
	        		 
	        		 
	        		 else if(px==9) {
	        			 break;
	        		 }
	        		 px++;
	        		 keypr=0;
	        	 }
	        	 keypr=0;
	        	 
	        	  
	         }
	         else if(rkey==KeyEvent.VK_UP && keypr==1 && py!=0) {
	        	 keypr=0;
	        	 while(true) {
	        		 keypr=0;
	        		 py--;
	        		
	        		 cn.getTextWindow().setCursorPosition(px, py);
	        		 if (a1.take(px, py)!='.'&& py!=0) {           // PY = 0
	        			 
	        			 if(a1.take(px, py-1)=='.') {	       //ONE ELEMENTS CONTROL
	        				 cn.getTextWindow().setCursorPosition(c1, c2);
	        				 c1=c1+2;
	        				 System.out.println(a1.take(px, py));
	        				 a1.e.enqueue(a1.take(px, py));
	        				 a1.changeCoordinateToNull(px, py);
	        				 cn.getTextWindow().setCursorPosition(0, 0);
	        				 a1.boardDisplay();
	        				 
						 break;
	        			 }
	        			 	        			 
					}
	        		 
	        		 if(py !=0 && (a1.take(px, py)=='*' || a1.take(px, py)=='-' || a1.take(px, py)=='+' || a1.take(px, py)=='/') && a1.take(px, py-1)!='.' ) { //FIRST ELEMENT OPERATION CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+2;
        				 System.out.println(a1.take(px, py));
        				 a1.e.enqueue(a1.take(px, py));
	        			 a1.changeCoordinateToNull(px, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 
	        			 break;
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && py!=0 && (a1.take(px, py-1)=='*' || a1.take(px, py-1)=='-' || a1.take(px, py-1)=='+' || a1.take(px, py-1)=='/') ) { //FIRST NUMBER SECOND OPERATION CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+2;
        				 System.out.println(a1.take(px, py));
        				 a1.e.enqueue(a1.take(px, py));
	        			 a1.changeCoordinateToNull(px, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 
	        			 break;
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && py!=1 && py!=0 &&  a1.take(px, py-1)!='.' && (a1.take(px, py-2)=='*' || a1.take(px, py-2)=='-' || a1.take(px, py-2)=='+' || a1.take(px, py-2)=='/') ) { //FIRST 2 NUMBERS THIRD OPERATION CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+3;
	        			 a1.twoConcatenater(a1.take(px, py-1), a1.take(px, py));
	        			 a1.e.enqueue(a1.r1);
	        			 a1.changeCoordinateToNull(px, py);
	        			 a1.changeCoordinateToNull(px, py-1);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 py--;
	        			 break;
	        		 }
	        		 
	        		 
	        		 if (a1.take(px, py)!='.'&& py!=0 && py!=1) {  // PX = 1
	        			 
	        			 if(a1.take(px, py-1)!='.' && a1.take(px, py-2)=='.') {      //TWO ELEMENTS CONTROL
	        				 cn.getTextWindow().setCursorPosition(c1, c2);
	        				 c1=c1+3;
		        			 a1.twoConcatenater(a1.take(px, py-1), a1.take(px, py));
		        			 a1.e.enqueue(a1.r1);
        					 a1.changeCoordinateToNull(px, py);
        					 a1.changeCoordinateToNull(px, py-1);
        					 cn.getTextWindow().setCursorPosition(0, 0);
        					 a1.boardDisplay();
        					 py--;
        					 break;
        				 }
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && py!=0 && py!=1 && py !=2) { // PY = 2
	        			 
	        			 if (a1.take(px, py-1)!='.' && a1.take(px, py-2)!='.' && a1.take(px, py-3) == '.') { //THREE ELEMENTS CONTROL
	        				 cn.getTextWindow().setCursorPosition(c1, c2);
	        				 c1=c1+4;
		        			 a1.threeConcatenater(a1.take(px, py-2), a1.take(px, py-1), a1.take(px, py));
		        			 a1.e.enqueue(a1.r2);
							a1.changeCoordinateToNull(px, py);
							a1.changeCoordinateToNull(px, py-1);
							a1.changeCoordinateToNull(px, py-2);
							cn.getTextWindow().setCursorPosition(0, 0);
							a1.boardDisplay();
							py=py-2;
							break;
						}
	        		 }
	        		 if (a1.take(px, py)!='.'&& py!=0 && py!=1 && py!=2 && py!=3 ) {  // PY = 3
	        			 
	        			 if(a1.take(px, py-1)!='.' && a1.take(px, py-2)!='.' && a1.take(px, py-3)!='.' && a1.take(px, py-4)=='.') {      //FOUR ELEMENTS CONTROL
	        				 cn.getTextWindow().setCursorPosition(c1, c2);
	        				 c1=c1+5;
	        				 a1.fourConcatenater(a1.take(px, py-3), a1.take(px, py-2), a1.take(px, py-1), a1.take(px, py));
	        				 a1.e.enqueue(a1.r3);
        					 a1.changeCoordinateToNull(px, py);
        					 a1.changeCoordinateToNull(px, py-1);
        					 a1.changeCoordinateToNull(px, py-2);
        					 a1.changeCoordinateToNull(px, py-3);
        					 cn.getTextWindow().setCursorPosition(0, 0);
        					 a1.boardDisplay();
        					 py=py-3;
        					 break;
        				 }
	        		 }
	        		 
	        		 
	        		 if(a1.take(px, py)!='.' && py==0 && a1.take(px, py+1) == '.') { //PY = 0 CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+2;
	        			 System.out.println(a1.take(px, py));
	        			 a1.e.enqueue(a1.take(px, py));
	        			 a1.changeCoordinateToNull(px, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 break;
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && a1.take(px, py-1)!='.' && py ==1 && a1.take(px, py+1)=='.') { //PY = 1 CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+3;
	        			 a1.twoConcatenater(a1.take(px, py-1), a1.take(px, py));
	        			 a1.e.enqueue(a1.r1);
	        			 a1.changeCoordinateToNull(px, py);
	        			 a1.changeCoordinateToNull(px, py-1);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 py--;
	        			 break;
	        		 }
	        		 if(a1.take(px, py)!='.' && a1.take(px, py-1)!='.' && a1.take(px, py-2)!='.' && py==2 && a1.take(px, py+1)== '.') { //PY = 2 CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+4;
	        			 a1.threeConcatenater(a1.take(px, py-2), a1.take(px, py-1), a1.take(px, py));
	        			 a1.e.enqueue(a1.r2);
	        			 a1.changeCoordinateToNull(px, py);
	        			 a1.changeCoordinateToNull(px, py-1);
	        			 a1.changeCoordinateToNull(px, py-2);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 py=py-2;
	        			 break;
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && a1.take(px, py-1) != '.' && a1.take(px, py-2) !='.' && a1.take(px, py-3)!='.' && py==3 && a1.take(px, py+1)=='.') { //PY = 3 CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+5;
        				 a1.fourConcatenater(a1.take(px, py-3), a1.take(px, py-2), a1.take(px, py-1), a1.take(px, py));
        				 a1.e.enqueue(a1.r3);
        				 a1.changeCoordinateToNull(px, py);
        				 a1.changeCoordinateToNull(px, py-1);
        				 a1.changeCoordinateToNull(px, py-2);
        				 a1.changeCoordinateToNull(px, py-3);
        				 cn.getTextWindow().setCursorPosition(0, 0);
        				 a1.boardDisplay();
        				 py=py-3;
        				 break;
	        		 
	        		 }
	        		 
	        		 
	        		 else if(py==0) {
	        			 break;
	        		 }
	        		 keypr=0;
	        	 }
	        	 keypr=0;
	        	 
	        	  
	         }
	         else if(rkey==KeyEvent.VK_DOWN && keypr==1 && py!=9) {
	        	 keypr=0;
	        	 while(true) {
	        		 keypr=0;
	        		 py++;
	        		
	        		 cn.getTextWindow().setCursorPosition(px, py);
	        		 if (a1.take(px, py)!='.'&& py!=9) {           // PY = 9
	        			 
	        			 if(a1.take(px, py+1)=='.') {	       //ONE ELEMENTS CONTROL
	        				 cn.getTextWindow().setCursorPosition(c1, c2);
	        				 c1=c1+2;
	        				 System.out.println(a1.take(px, py));
	        				 a1.e.enqueue(a1.take(px, py));
	        				 a1.changeCoordinateToNull(px, py);
	        				 cn.getTextWindow().setCursorPosition(0, 0);
	        				 a1.boardDisplay();
	        				 
						 break;
	        			 }
	        			 	        			 
					}
	        		 
	        		 if(py !=9 && (a1.take(px, py)=='*' || a1.take(px, py)=='-' || a1.take(px, py)=='+' || a1.take(px, py)=='/') && a1.take(px, py+1)!='.' ) { //FIRST ELEMENT OPERATION CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+2;
        				 System.out.println(a1.take(px, py));
        				 a1.e.enqueue(a1.take(px, py));
	        			 a1.changeCoordinateToNull(px, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 
	        			 break;
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && py!=9 && (a1.take(px, py+1)=='*' || a1.take(px, py+1)=='-' || a1.take(px, py+1)=='+' || a1.take(px, py+1)=='/') ) { //FIRST NUMBER SECOND OPERATION CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+2;
        				 System.out.println(a1.take(px, py));
        				 a1.e.enqueue(a1.take(px, py));
	        			 a1.changeCoordinateToNull(px, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 
	        			 break;
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && py!=8 && py!=9 &&  a1.take(px, py+1)!='.' && (a1.take(px, py+2)=='*' || a1.take(px, py+2)=='-' || a1.take(px, py+2)=='+' || a1.take(px, py+2)=='/') ) { //FIRST 2 NUMBERS THIRD OPERATION CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+3;
	        			 a1.twoConcatenater(a1.take(px, py+1), a1.take(px, py));
	        			 a1.e.enqueue(a1.r1);
	        			 a1.changeCoordinateToNull(px, py);
	        			 a1.changeCoordinateToNull(px, py+1);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 py++;
	        			 break;
	        		 }
	        		 
	        		 
	        		 if (a1.take(px, py)!='.'&& py!=9 && py!=8) {  // PY = 8
	        			 
	        			 if(a1.take(px, py+1)!='.' && a1.take(px, py+2)=='.') {      //TWO ELEMENTS CONTROL
	        				 cn.getTextWindow().setCursorPosition(c1, c2);
	        				 c1=c1+3;
		        			 a1.twoConcatenater(a1.take(px, py+1), a1.take(px, py));
		        			 a1.e.enqueue(a1.r1);
        					 a1.changeCoordinateToNull(px, py);
        					 a1.changeCoordinateToNull(px, py+1);
        					 cn.getTextWindow().setCursorPosition(0, 0);
        					 a1.boardDisplay();
        					 py++;
        					 break;
        				 }
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && py!=9 && py!=8 && py !=7) { // PY = 7
	        			 
	        			 if (a1.take(px, py+1)!='.' && a1.take(px, py+2)!='.' && a1.take(px, py+3) == '.') { //THREE ELEMENTS CONTROL
	        				cn.getTextWindow().setCursorPosition(c1, c2);
	        				c1=c1+4;
		        			a1.threeConcatenater(a1.take(px, py+2), a1.take(px, py+1), a1.take(px, py));
		        			a1.e.enqueue(a1.r2);
							a1.changeCoordinateToNull(px, py);
							a1.changeCoordinateToNull(px, py+1);
							a1.changeCoordinateToNull(px, py+2);
							cn.getTextWindow().setCursorPosition(0, 0);
							a1.boardDisplay();
							py=py+2;
							break;
						}
	        		 }
	        		 if (a1.take(px, py)!='.'&& py!=9 && py!=8 && py!=7 && py!=6 ) {  // PY = 6
	        			 
	        			 if(a1.take(px, py+1)!='.' && a1.take(px, py+2)!='.' && a1.take(px, py+3)!='.' && a1.take(px, py+4)=='.') {      //FOUR ELEMENTS CONTROL
	        				 cn.getTextWindow().setCursorPosition(c1, c2);
	        				 c1=c1+5;
	        				 a1.fourConcatenater(a1.take(px, py+3), a1.take(px, py+2), a1.take(px, py+1), a1.take(px, py));
	        				 a1.e.enqueue(a1.r3);
        					 a1.changeCoordinateToNull(px, py);
        					 a1.changeCoordinateToNull(px, py+1);
        					 a1.changeCoordinateToNull(px, py+2);
        					 a1.changeCoordinateToNull(px, py+3);
        					 cn.getTextWindow().setCursorPosition(0, 0);
        					 a1.boardDisplay();
        					 py=py+3;
        					 break;
        				 }
	        		 }
	        		 
	        		 
	        		 if(a1.take(px, py)!='.' && py==9 && a1.take(px, py-1) == '.') { //PY = 9 CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+2;
        				 System.out.println(a1.take(px, py));
        				 a1.e.enqueue(a1.take(px, py));
	        			 a1.changeCoordinateToNull(px, py);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 break;
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && a1.take(px, py+1)!='.' && py ==8 && a1.take(px, py-1)=='.') { //PY = 8 CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+3;
	        			 a1.twoConcatenater(a1.take(px, py+1), a1.take(px, py));
	        			 a1.e.enqueue(a1.r1);
	        			 a1.changeCoordinateToNull(px, py);
	        			 a1.changeCoordinateToNull(px, py+1);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 py++;
	        			 break;
	        		 }
	        		 if(a1.take(px, py)!='.' && a1.take(px, py+1)!='.' && a1.take(px, py+2)!='.' && py==7 && a1.take(px, py-1)== '.') { //PY = 7 CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+4;
	        			 a1.threeConcatenater(a1.take(px, py+2), a1.take(px, py+1), a1.take(px, py));
	        			 a1.e.enqueue(a1.r2);
	        			 a1.changeCoordinateToNull(px, py);
	        			 a1.changeCoordinateToNull(px, py+1);
	        			 a1.changeCoordinateToNull(px, py+2);
	        			 cn.getTextWindow().setCursorPosition(0, 0);
	        			 a1.boardDisplay();
	        			 py=py+2;
	        			 break;
	        		 }
	        		 
	        		 if(a1.take(px, py)!='.' && a1.take(px, py+1) != '.' && a1.take(px, py+2) !='.' && a1.take(px, py+3)!='.' && py==3 && a1.take(px, py-1)=='.') { //PY = 6 CONTROL
	        			 cn.getTextWindow().setCursorPosition(c1, c2);
        				 c1=c1+5;
        				 a1.fourConcatenater(a1.take(px, py+3), a1.take(px, py+2), a1.take(px, py+1), a1.take(px, py));
        				 a1.e.enqueue(a1.r3);
        				 a1.changeCoordinateToNull(px, py);
        				 a1.changeCoordinateToNull(px, py+1);
        				 a1.changeCoordinateToNull(px, py+2);
        				 a1.changeCoordinateToNull(px, py+3);
        				 cn.getTextWindow().setCursorPosition(0, 0);
        				 a1.boardDisplay();
        				 py=py+3;
        				 break;
	        		 
	        		 }
 
	        		 else if(py==9) {
	        			 break;
	        		 }
	        		 keypr=0;
	        	 }
	        	 keypr=0;
	        	 
	        	  
	         }
	        	
	        	
	        	cn.getTextWindow().setCursorPosition(px, py);
	    
	         
	         if(rkey==KeyEvent.VK_F && keypr==1 ) {
	        	 break;
	         }
	         
	        	 }
	        	 
	        	 cn.getTextWindow().setCursorPosition(65, 0);
	        	 a1.scoreEvaluater(a1.e);
	        	 cn.getTextWindow().setCursorPosition(25, 2);
	        	 System.out.println("                    ");
	        	 cn.getTextWindow().setCursorPosition(25, 2);
	        	 System.out.println("Evaluation mode");
	        	 
	        	 if (a1.score==-20 ) {
					Thread.sleep(2000);
					cn.getTextWindow().setCursorPosition(65, 0);
					System.out.print("              ");
					help = false;
				}
	        	 if(help) {
	        	 a1.expressionScoreCalculation(a1.e);
	        	 cn.getTextWindow().setCursorPosition(25, 1);
		         System.out.println("Score : "+a1.score);
	        	 
	        	
	        	 keypr=0;
	        	 Stack s = new Stack(500);
	 			int coory = 6;
	 			int pasta =0;
	 			while(!a1.e.isEmpty()) {
	 				 if(rkey==KeyEvent.VK_SPACE && keypr==1) {
	 				if(!(a1.e.peek().toString().equalsIgnoreCase("/")) && !(a1.e.peek().toString().equalsIgnoreCase("+"))
	 						&& !(a1.e.peek().toString().equalsIgnoreCase("-")) && !(a1.e.peek().toString().equalsIgnoreCase("*"))){
	 							s.Push(a1.e.dequeue());
	 							cn.getTextWindow().setCursorPosition(54, coory);
	 							System.out.println(s.peek());
	 							coory--;
	 							pasta++;
	 						}
	 				else {
	 					
	 					int secondNumber= Integer.parseInt(s.Pop().toString());
						int firstNumber= Integer.parseInt(s.Pop().toString());
						String op = a1.e.dequeue().toString();
						int result;
						if(op.equalsIgnoreCase("+")) {
							result = firstNumber+secondNumber;
							s.Push(result);
							for (int i = 51; i <58 ; i++) { //clearing stack
								for (int j =7-pasta ; j > 5-pasta; j--) {
									cn.getTextWindow().setCursorPosition(i, j);
									System.out.print(" "); 
								}
							}
							cn.getTextWindow().setCursorPosition(54, 8-pasta);
							System.out.println(s.peek());
						}
						else if(op.equalsIgnoreCase("-")) {
							result =firstNumber-secondNumber;
							s.Push(result);
							for (int i = 51; i <58 ; i++) { //clearing stack
								for (int j =7-pasta ; j > 5-pasta; j--) {
									cn.getTextWindow().setCursorPosition(i, j);
									System.out.print(" "); 
								}
							}
							cn.getTextWindow().setCursorPosition(54, 8-pasta);
							System.out.println(s.peek());
						}
						else if(op.equalsIgnoreCase("/")) {
							result =firstNumber/secondNumber;
							s.Push(result);
							for (int i = 51; i <58 ; i++) { //clearing stack
								for (int j =7-pasta ; j > 5-pasta; j--) {
									cn.getTextWindow().setCursorPosition(i, j);
									System.out.print(" "); 
								}
							}
							cn.getTextWindow().setCursorPosition(54, 8-pasta);
							System.out.println(s.peek());
						}
						else if(op.equalsIgnoreCase("*")) {
							result =firstNumber*secondNumber;
							s.Push(result);
							for (int i = 51; i <58 ; i++) { //clearing stack
								for (int j =7-pasta ; j > 5-pasta; j--) {
									cn.getTextWindow().setCursorPosition(i, j);
									System.out.print(" "); 
								}
							}
							cn.getTextWindow().setCursorPosition(54, 8-pasta);
							System.out.println(s.peek());
							
						}
						
						Thread.sleep(2000);
					}	
	 				
	 				keypr=0;
	 				}
	 				 
	 				keypr=0;
	 				
	 			}
	 			
	        	 }
	 			}
	 			
	        	 
	        	 
	        	 
	         }
	         
	    }
	        
	        
	        
	      
	        
	       
	      
	   }
	   
	   
	
