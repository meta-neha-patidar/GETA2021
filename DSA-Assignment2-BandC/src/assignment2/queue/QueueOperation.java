package assignment2.queue;

/*
 * 
 */
public class QueueOperation<E> implements QueueInterface<E>{
	private int size, front, rear;
	private Object queue[];
	/*
	 * @param size- size of queue
	 */
	public QueueOperation(int size){
		this.size = size;
		this.queue = new Object[size];
		this.front = this.rear = -1;
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
		return ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1)));
			
	}
	/*
	 * (non-Javadoc)
	 * @see QueueInterface#enqueue()
	 */
	
	public void enqueue(Object element){
		if (isFull()){
			System.out.println("Queue is full");
			return;
		}
		if(isEmpty()){
			front = rear = 0;
		}else if(rear == size - 1 && front != 0){
			rear = 0;
		}else{
			rear++;
		}
		queue[rear] = (E) element;
	}
	/*
	 * (non-Javadoc)
	 * @see QueueInterface#dequeue()
	 */
	public E dequeue(){
		if (isEmpty()){
			return null;
		}
		E element = (E) queue[front];
		if (front == rear){
			front = -1;
			rear = -1;
		}else
			front = (front + 1) % size;
		
		return (E)element;
	}
}

