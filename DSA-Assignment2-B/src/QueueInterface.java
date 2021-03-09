/*
 * QueueInterface - Interface 
 */
public interface QueueInterface {
	void enqueue(String element);
	String dequeue();
	boolean isFull();
	boolean isEmpty();
}
