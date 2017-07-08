package tutorial;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>
{

    private Node<T> root = null;

    public void add(T object)
    {
        if(root == null)
            root = new Node<T>(object);
        else{
            Node<T> currentNode = root;
            while(currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            }
            currentNode.getNext(); /* BUG #1: changed "currentNode.setNext(new Node<T>(object));" -->
                                    "currentNode.getNext();" ... Escapes Evo test suite entirely. */
        }
    }

    public T getFirst()
    {
        if(root != null) /* BUG #2: changed "if(root == null)" -->
                          "if(root != null);" ... Causes 3 test errors, but no test failures.*/
            throw new IllegalArgumentException("Empty list");

        return root.getObject();
    }

        public Iterator<T> iterator() {
        return new LinkedListIterator<T>(root);
    }
    
    public T get(int targetPosition)
    {
        int position = 0;
        Node<T> currentNode = root;
        while(currentNode != null) {
            if(position == targetPosition)
            return currentNode.getObject();
            currentNode = currentNode.getNext();
	}
        throw new IllegalArgumentException("No such element");
    }

    public boolean isEmpty()
    {
        return root != null; /*Bug #3: changed "return root != null;" -->
                              "root != null;" ... Causes 3 test failures.*/
    }
}
