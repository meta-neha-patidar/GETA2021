
public class StackImplement implements StackInterface{
	int topIndex = -1;
	int size;
	String [] stackArray;
	/*
	 * @param size- size of stack
	 */
	StackImplement(int size){
		this.size = size;
		stackArray = new String[size];
	}
	
	/*
	 * (non-Javadoc)
	 * @see Stack#isEmpty()
	 */
	public boolean isEmpty(){
		return topIndex == -1;
	}
	/*
	 * (non-Javadoc)
	 * @see StackInterface#isFull()
	 */
	public boolean isFull(){
		return topIndex == (size - 1);
	}
	public String peek(){
		if(! isEmpty()) return stackArray[topIndex];
		 return "";
	}
	/*
	 * (non-Javadoc)
	 * @see StackInterface#push(int)
	 */
	public void push(String item){
		if(! isFull()){
			topIndex++;
			stackArray[topIndex] = item;
		}else{
			System.out.println("Stack Overflow");
		}
	}
	/*
	 * (non-Javadoc)
	 * @see StackInterface#pop()
	 */
	public String pop(){
		if(topIndex == -1){
//			System.out.println("Stack UnderFlow");
			return "-1";
		}
		String temp = stackArray[topIndex];
		topIndex --;
		return temp;
	}
}

