package assignment2.queue;

/*
 * @author Neha Patidar
 * @since 06-03-2021 
 */
public interface QueueInterface <E>{
	/*
	 * @param element 
	 */
	void enqueue(E element);
	/*
	 * @return <E>
	 */
	E dequeue();
	/*
	 * @return true if queue is full, otherwise false
	 */
	boolean isFull();
	/*
	 * @return true if queue if Empty , otherwise false
	 */
	boolean isEmpty();
}

