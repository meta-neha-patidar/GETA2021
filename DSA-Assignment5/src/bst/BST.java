package bst;
import java.util.*;


import org.json.JSONException;
import org.json.JSONObject;
/**
 * 
 * @author neha.patidar
 *
 */
public class BST implements DictionaryInterface{
	Node root;
	static List<Node> sortedList;
	private static boolean isAdded = true;
	private static boolean isDeleted = true;
	
	/**
	 * 
	 * @param jsString
	 * @throws JSONException 
	 */
	BST(String jsString) throws JSONException{
		JSONObject object = new JSONObject(jsString.trim());
		Iterator <String> keys = object.keys();
		root = null;
		
		while(keys.hasNext()){
			String key = keys.next();
			add(key, object.getString(key));
		}
	}
	
	@Override
	public boolean add(String key, String value) {
		// TODO Auto-generated method stub
		root = addKey(root, key, value);
		if (isAdded) {
			return true;
		} else {
			isAdded = true;
			return false;
		}
	}
	@Override
	public boolean delete(String key) {
		// TODO Auto-generated method stub
		root = deleteKey(root, key);
		if (isDeleted) {
			return true;
		} else {
			isDeleted = true;
			return false;
		}
	}
	
	@Override
	public String getValue(String key) {
		// TODO Auto-generated method stub
		Node node = searchKey(root, key);
		String value = null;
		if (null != node) {
			value = node.value;
		}
		return value;
	}
	@Override
	public List<Node> sorted() {
		// TODO Auto-generated method stub
		sortedList = new ArrayList<Node>();
		inorderTraversal(root);
		return sortedList;
	}

	

	@Override
	public List<Node> sorteInBetween(String keyStart, String keyEnd) {
		// TODO Auto-generated method stub
		sortedList = new ArrayList<Node>();
		rangedInorderTraversal(root, keyStart, keyEnd);
		return sortedList;
	}
	/**
	 * 
	 * @param root
	 * @param k1
	 * @param k2
	 */
	private static void rangedInorderTraversal(Node root, String k1, String k2) {
		if (null != root) {
			rangedInorderTraversal(root.left, k1, k2);
			if (root.key.compareToIgnoreCase(k1) >= 0 && root.key.compareToIgnoreCase(k2) <= 0) {
				sortedList.add(root);
			}
			rangedInorderTraversal(root.right, k1, k2);
		}
	}
	/**
	 * 
	 * @param root
	 */
	private static void inorderTraversal(Node root) {
		if (null != root) {
			inorderTraversal(root.left);
			sortedList.add(root);
			inorderTraversal(root.right);
		}
	}
	/**
	 * 
	 * @param root
	 * @param key
	 * @param value
	 * @return
	 */
	private static Node addKey(Node root, String key, String value) {
		if (root == null) {
			root = new Node(key, value);
			return root;
		}

		if (key.compareToIgnoreCase(root.key) < 0) {
			root.left = addKey(root.left, key, value);
		} else if (key.compareToIgnoreCase(root.key) > 0) {
			root.right = addKey(root.right, key, value);
		} else {
			isAdded = false;
		}

		return root;
	}
	/**
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	private static Node deleteKey(Node root, String key) {
		if (null == root) {
			isDeleted = false;
			return root;
		}

		if (key.compareToIgnoreCase(root.key) < 0) {
			root.left = deleteKey(root.left, key);
		} else if (key.compareToIgnoreCase(root.key) > 0) {
			root.right = deleteKey(root.right, key);
		} else {
			if (null == root.left) {
				return root.right;
			} else if (null == root.right) {
				return root.left;
			}

			Node temp = minValue(root.right);
			root.key = temp.key;
			root.value = temp.value;

			root.right = deleteKey(root.right, root.key);
		}

		return root;
	}
	/**
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	private static Node searchKey(Node root, String key) {
		if (null == root || root.key.equals(key)) {
			return root;
		}

		if (root.key.compareToIgnoreCase(key) < 0) {
			return searchKey(root.right, key);
		}

		return searchKey(root.left, key);
	}
	private static Node minValue(Node root) {
		while (null != root.left) {
			root = root.left;
		}
		return root;
	}
}
