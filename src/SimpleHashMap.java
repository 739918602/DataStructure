import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Created with IntelliJ IDEA.
 * @author: ZhangYuSai
 * @Date: 2018/3/9
 * @Time: 17:00
 */
public class SimpleHashMap<K,V> implements Map<K,V> {
    private Node<K,V>[] nodes;
    private final int length=10;
    private int size;
    public SimpleHashMap() {

    }

    @Override
    public int size() {
        return nodes.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hash = key.hashCode();
        int index =  hash % (length-1);
        Node<K,V> currentNode = nodes[index];//TODO NULLPoint
        Node<K,V> newNode = new Node<>(hash,key,value,null);
        if(nodes ==null){
            this.nodes = (Node<K,V>[])new Node[length];
        }
        if(currentNode ==null){
            currentNode = newNode;
        }else{
            for (;currentNode.hasNext();currentNode = currentNode.getNext()){
                if(hash == currentNode.getHash()){
                    currentNode = newNode;
                    break;
                }else{
                    if(!currentNode.hasNext()){
                        currentNode.setNext(newNode);
                        size ++;
                        break;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    public static void main(String[] args) {
        SimpleHashMap<String,Object> smap = new SimpleHashMap<>();
        smap.put("123",1);
        System.out.println(smap.size);
    }

}