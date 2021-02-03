/**
 * creates a generic circular linked list
 * @author ahuvacheifetz
 */
public class GCLL<T> {

    private Node first = null;    //<editor-fold defaultstate="collapsed" desc="Node">

    private class Node<T> {

        private T info;
        private Node<T> next;

        private Node(T info) {
            this.info = info;
            next = null;
        }

        private Node getNext(Node n) {
            return n.next;
        }
    }//</editor-fold>

    /**
     * this adds an element to the generic circular linked list
     */
    public void add(T element) {
        Node node = new Node(element);
        if (first == null) {
            first = node;
            first.next = first;
        } else {
            node.next = first.next;
            first.next = node;
        }
    }

    /**
     * checks if an element exists in the list, if not found it returns null
     */
    public boolean find(T element) {
        boolean retVal = false;
        Node curr = first;
        if (curr != null) {
            do {
                curr = curr.next;
                if (curr.info.equals(element)) {
                    retVal = true;
                    break;
                }
            } while (curr != first);

        }
        return retVal;
    }

    /**
     * returns the first element in the list
     **/
    public T getFirst() {
        T element = null;
        if (first != null) {
            element = (T) first.info;
        }
        return element;
    }

    /**
     * removes the specified element of the list
     **/
    public boolean remove(T element) {
        boolean retVal = false;

        if (first != null) {
            if (first == first.next) {
                if (first.info == element) {
                    first = null;
                    retVal = true;
                }
            } else {
                if (first.info == element) {
                    first = first.next;
                    Node last = getElementAt(getLength() - 2);
                    last.next = first;
                    retVal = true;
                } else {
                    Node<T> prev = first;
                    Node<T> curr = first.next;

                    while (curr != first) {
                        if (curr.info == element) {
                            prev.next = curr.next;
                            retVal = true;
                            break;
                        } else {
                            curr = curr.next;
                            prev = prev.next;
                        }
                    }
                }
            }
        }
        return retVal;
    }

    /**
     * takes you to the element at index of count and makes it head
     */
    public void advance(int count) {
        if (count > 0) {
            for (int move = 0; move < count; ++move) {
                first = first.next;
            }
        }
    }

    /**
     * returns the string of the list
     */
    @Override
    public String toString() {
        String rV = "first->";
        if (first != null) {
            Node<T> curr = first;
            while (curr.next != first) {
                rV += ("|" + curr.info.toString() + "|->");
                curr = curr.next;
            }
            rV += ("|" + curr.info.toString() + "|->");
            if (curr == first) {  // remove the last arrow
                rV = rV.substring(0, rV.length() - 2);
            } else { // add the first element again
                curr = curr.next;
                rV += ("|" + curr.info.toString() + "|");
            }
        }
        return rV;
    }

    /**
     * returns the length of the list
     */
    public int getLength() {
        if (first == null)
            return 0;

        int len = 1;
        Node curr = first.next;
        while (curr != first) {
            ++len;
            curr = curr.next;
        }
        return len;
    }

    /**
     * returns the element at the specified index
     */
    public Node<T> getElementAt(int index) {
        Node current = first;
        int count = 0;
        while (current != null) {
            if (count == index)
                return current;
            count++;
            current = current.next;
        }
        return null;
    }
}
