package bst;
import java.util.*;
/**
 * 
 * @author neha.patidar
 *
 */
public interface DictionaryInterface {

	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	boolean add(String key, String value);
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	boolean delete(String key);
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	String getValue(String key);
	/**
	 * 
	 * @return
	 */
	List<Node> sorted();
	/**
	 * 
	 * @param keyStart
	 * @param keyEnd
	 * @return
	 */
	List<Node> sorteInBetween(String keyStart, String keyEnd);
}
