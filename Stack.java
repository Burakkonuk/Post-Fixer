package Project;

public class Stack {
	private int top ;
	private Object[] elements;
	private Object[] stack;
	
	
	Stack(int capacity){
		
		elements= new Object[capacity];
		top=-1;
	}
	void Push(Object data){
		if(isFull())
		System.out.println("Stack Overflow");
		else {
		top++;
		elements[top]=data;
		}
	}
	
	Object Pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		else {
		Object tempData=elements[top];
		elements[top]=null;
		top--;
		
		return tempData;
		}
	}
	int size() {
		return top+1;
		
	}
	boolean isFull() {
		
		if(elements.length==(top+1)) {
			
			return true;
		
		}
		else 
			return false;
	}
	
	boolean isEmpty() {
		
		if(top==-1)
			return true;
		else 
			return false;
		
	}
	
	Object peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		else {
		return elements[top];
		}
	}
}
