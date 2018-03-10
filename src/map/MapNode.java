package map;

/**
 * @Created with IntelliJ IDEA.
 * @author: ZhangYuSai
 * @Date: 2018/3/9
 * @Time: 17:06
 */
public class MapNode<K,V> {
    private K key;
    private V value;
    private MapNode next;
    private int hash;

    public MapNode(int hash, K key, V value, MapNode<K,V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = hash;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public MapNode getNext() {
        return next;
    }

    public void setNext(MapNode next) {
        this.next = next;
    }

    public boolean hasNext(){
        return this.next != null;
    }
}