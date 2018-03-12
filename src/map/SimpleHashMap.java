package map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @Created with IntelliJ IDEA.
 * @author: ZhangYuSai
 * @Date: 2018/3/9
 * @Time: 17:00
 */
public class SimpleHashMap<K,V> implements Map<K,V> {
    public MapNode<K,V>[] nodes;
    private final int length=3;
    private int size;
    public SimpleHashMap() {

    }

    @Override
    public int size() {
        return nodes.length;
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public boolean containsKey(Object key) {
        int hash = key.hashCode();
        int index =  hash % (length);
        MapNode<K,V> node = nodes[index];
        while (true){
            if(node == null){
                return false;
            }
            if(node.getHash() == hash){
                return true;
            }
            node = node.getNext();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        int hash = key.hashCode();
        int index =  hash % (length);
        MapNode<K,V> node = nodes[index];
        while (true){
            if(node == null){
                return null;
            }
            if(node.getHash() == hash){
                return node.getValue();
            }
            node = node.getNext();
        }
    }

    @Override
    public V put(K key, V value) {
        int hash = key.hashCode();
        int index =  hash % (length);
        MapNode<K,V> newNode = new MapNode<>(hash,key,value,null);
        if(nodes ==null){
            this.nodes = (MapNode<K,V>[])new MapNode[length];
        }
        if(nodes[index] ==null){
            nodes[index] = newNode;
            size++;
        }else{
            MapNode<K,V> last= nodes[index];
            while (true){
                if(newNode.getHash() == last.getHash()){
                    nodes[index] = newNode;
                    break;
                }
                if(last.hasNext()){
                    last = last.getNext();
                }else{
                    last.setNext(newNode);
                    size++;
                    break;
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
        smap.put(String.valueOf(1),"A");
        smap.put(String.valueOf(1),"123");
        smap.put(String.valueOf(2),"231");
        smap.put(String.valueOf(2),"A23");
        smap.put(String.valueOf(3),"A2");
        smap.put(String.valueOf(4),"A2");
        smap.put(String.valueOf(5),"A1");
        smap.put(String.valueOf(6),"A2");
        System.out.println(smap.get("3"));
        System.out.println(smap.get("1"));
        System.out.println(smap.get("6"));
        System.out.println(smap.containsKey("6"));
    }

}