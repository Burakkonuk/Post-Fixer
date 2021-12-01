package Project;

import java.util.Random;

public class Start {
	public static String r1=null; //Returning two digits
	public static String r2=null; //Returning three digits
	public static String r3=null; //Returning four digits
	public static int score=0;
CircularQueue feeder = new CircularQueue(8);
CircularQueue e = new CircularQueue(20);
char[][] Board = new char[10][10];
Random rnd = new Random();
public void queueFeeder() {
int a='0';
while(!feeder.isFull()){
	a=rnd.nextInt(12) + 1;
	if ((int)a<=9) {
		feeder.enqueue((int)a);
	}
	else if ((int)a==10) {
		feeder.enqueue("+");
	}
	else if ((int)a==11) {
		feeder.enqueue("-");
	}
	else if ((int)a==12) {
		feeder.enqueue("/");
	}
	else if ((int)a==13) {
		feeder.enqueue("*");
	}

	}	

}




public void display(CircularQueue a) {
	CircularQueue temp = new CircularQueue(8);	
	int counter = a.size();
	for (int i = 0; i < counter; i++) {
		System.out.println(a.peek());
		temp.enqueue(a.dequeue());
	}
	for (int i = 0; i < counter; i++) {
		a.enqueue(temp.dequeue());
	}
	
	
}


public void board() {
		
	
	
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 10; j++) {
			Board[i][j]='.';
		}
	}
	int a =0;
	int b =0;
	for (int i = 0; i < 40; i++) {
		a=rnd.nextInt(10);
		b=rnd.nextInt(10);
		
		if(Board[a][b]=='.') {
			
			Board[a][b]=feeder.peek().toString().charAt(0);
			feeder.dequeue();
			queueFeeder();
		}
		else
			i--;
			continue;
			
	}
	
	for (int i = 0; i < 10; i++) {
		
		for (int j = 0; j < 10; j++) {
			
			System.out.print(Board[i][j]);
		}
		System.out.println("");
	}
	
		
	}
	public void boardfeeding() {
		int counter =0;
		int a =0;
		int b =0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (Board[i][j]!='.') {
					counter++;
				}
				
			}
		}
		
		for (int i = 0; i < 40-counter; i++) {
			a= rnd.nextInt(10);
			b= rnd.nextInt(10);
			if (Board[a][b]=='.') {
				Board[a][b]=feeder.peek().toString().charAt(0);
				feeder.dequeue();
				if (feeder.isEmpty()) {
					queueFeeder();
				}
			}
		}
		queueFeeder();
		
	}
	public void boardDisplay() {
		 
		for (int i = 0; i < 10; i++) {
			
			for (int j = 0; j < 10; j++) {
				
				System.out.print(Board[i][j]);
			}
			System.out.println("");
		}
	}

	
	
	public char take(int b,int a) {
		
		char number = Board[a][b];
		
		return number;
	}
	public void changeCoordinateToNull(int b ,int a) {
		char temp=' ';
		temp= Board[a][b];
		Board[a][b]='.';
	}
	public void twoConcatenater(int a, int b) {
		String r = null;
		String s=Integer.toString(a-48);
		String l=Integer.toString(b-48);
		r = l + s;
		r1=r;
		System.out.println(r);
				
	}
	
	public void threeConcatenater(int a, int b, int c) {
		String r = null;
		String s=Integer.toString(a-48);
		String l=Integer.toString(b-48);
		String m=Integer.toString(c-48);
		r = m + l + s;
		r2=r;
		System.out.println(r);
	}
	public void fourConcatenater(int a, int b, int c, int d) {
		String r =null;
		String s=Integer.toString(a-48);
		String l=Integer.toString(b-48);
		String m=Integer.toString(c-48);
		String n=Integer.toString(d-48);
		r= n+ m +l +s;
		r3=r;
		System.out.println(r);
		
	}
	public void scoreEvaluater(CircularQueue a) {
		int counter =0;
		boolean flag = true;
		int opc=0; //operator counter
		int vac=0; //value counter
		int check=0;
		int size = a.size();
		for(int i=0;i<size;i++) {
			if (a.peek().toString().equals("+") || a.peek().toString().equals("-") || a.peek().toString().equals("/") || a.peek().toString().equals("*")) {
				opc++;
				a.enqueue(a.dequeue());
			}
			else {
				vac++;
				a.enqueue(a.dequeue());
			}
			
			
		}
		if (vac-1!=opc) {
			if (flag&&counter==0) {
				score =-20;
				flag=false;
			}
			if (flag&&counter>0) {
				score-=20;
				flag=false;
			}
		}
		if (a.peek().toString().equals("+") || a.peek().toString().equals("-") || a.peek().toString().equals("/") || a.peek().toString().equals("*")) {
			if (flag&&counter==0) {
				score =-20;
				flag=false;
			}
			if (flag&&counter>0) {
				score-=20;
				flag=false;
			}
		}
		a.enqueue(a.dequeue());
		if (a.peek().toString().equals("+") || a.peek().toString().equals("-") || a.peek().toString().equals("/") || a.peek().toString().equals("*")) {
			if (flag&&counter==0) {
				score =-20;
				flag=false;
			}
			if (flag&&counter>0) {
				score-=20;
				flag=false;
			}
		}
		
		for (int i = 0; i < size-2; i++) {
			a.enqueue(a.dequeue());
		}
		
		if (!(a.peek().toString().equals("+") || a.peek().toString().equals("-") || a.peek().toString().equals("/") || a.peek().toString().equals("*"))) {
			if (flag&&counter==0) {
				score =-20;
				flag=false;
			}
			if (flag&&counter>0) {
				score-=20;
				flag=false;
			}
		}
		
		a.enqueue(a.dequeue());
		
		
		
		
		
	
		if (flag==false) {
			System.out.println("Penalty Points");
		}
		counter++;
		
	}
	int str_length = 0;
	boolean flag2 = false;
	boolean flag3 = false;
	int score1=0;
	public void expressionScoreCalculation(CircularQueue a) {
		flag3 = false; // ilkinin 2 puan almasını engelliyo 
		flag2 = false;
		int scorefactor = 1;
		int temp=a.size();
		for(int i=0;i<temp;i++) {
			str_length = 0;
			if (!(a.peek().toString().equalsIgnoreCase("/"))
					&& !(a.peek().toString().equalsIgnoreCase("+"))
					&& !(a.peek().toString().equalsIgnoreCase("-"))
					&& !(a.peek().toString().equalsIgnoreCase("*"))) {
				str_length = a.peek().toString().length();

				if (str_length > 1) {
					scorefactor += 2 * (str_length);
				} else if (str_length == 1 && (flag2)) {
					scorefactor += 2;
				} else if (str_length == 1 && !(flag2)) {
					scorefactor += 1;
				}

				flag2 = false;
				a.enqueue(a.dequeue());
			} else if (a.peek().toString().equalsIgnoreCase("/")
					|| a.peek().toString().equalsIgnoreCase("+")
					|| a.peek().toString().equalsIgnoreCase("-")
					|| a.peek().toString().equalsIgnoreCase("*")) {
				if (!(flag2) && flag3) {
					scorefactor += 2;
				} else if (!(flag2)) {
					scorefactor += 1;
				} else if (flag2) {
					scorefactor += 1;
				}
				flag2 = true;
				flag3 = true;
				a.enqueue(a.dequeue());
			}

		}
		score1 = scorefactor * scorefactor;
		score += score1;
	}
	
	







}
