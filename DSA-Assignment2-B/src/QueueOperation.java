/*
 * 
 */
public class QueueOperation implements QueueInterface{
	int size, front, rear;
	String queue[];
	/*
	 * @param size- size of queue
	 */
	QueueOperation(int size){
		this.size = size;
		queue = new String[size];
		front = rear = -1;
	}
	/*
	 * (non-Javadoc)
	 * @see QueueInterface#isEmpty()
	 */
	public boolean isEmpty(){
		return front == -1;
	}
	/*
	 * (non-Javadoc)
	 * @see QueueInterface#isFull()
	 */
	public boolean isFull(){
		return (rear % size == front) && front != -1;
	}
	/*
	 * (non-Javadoc)
	 * @see QueueInterface#enqueue()
	 */
	
	public void enqueue(String element){
		if (isFull()){
			System.out.println("Queue is full");
			return;
		}
		if(rear == -1){
			front = rear = 0;
		}
		queue[rear] = element;
		rear = (rear + 1) % size;
	}
	/*
	 * (non-Javadoc)
	 * @see QueueInterface#dequeue()
	 */
	public String dequeue(){
		String element = "";
		if (isEmpty()){
			return "queue is empty";
		}
		element = queue[front];
		front = (front + 1) % size;
		if (front == rear){
			front = -1;
			rear = -1;
		}
		return element;
	}
}
