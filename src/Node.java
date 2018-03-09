import java.util.HashMap;

/**
 * @Created with IntelliJ IDEA.
 * @author: ZhangYuSai
 * @Date: 2018/3/9
 * @Time: 17:06
 */
public class Node<K,V> {
    private K key;
    private V item;
    private Node next;
    private int hash;

    public Node(int hash,K key, V item, Node<K,V> next) {
        this.key = key;
        this.item = item;
        this.next = next;
        this.hash = hash;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getItem() {
        return item;
    }

    public void setItem(V item) {
        this.item = item;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean hasNext(){
        return this.next != null;
    }
}