//obtenido del libro
public class Association<K, V> implements MapEntry<K, V> {

    protected K theKey;
    protected V theValue;

    public Association(K key, V value) {
        theKey = key;
        theValue = value;
    }

    public boolean equals(Association<K, V> other) {
        Association<K, V> otherAssoc = other;
        return getKey().equals(otherAssoc.getKey());
    }

    public int hashCode() {
        return getKey().hashCode();
    }

    public V getValue() {
        return theValue;
    }

    public K getKey() {
        return theKey;
    }

    public V setValue(V value) {
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Palabra(key): " + getKey() + "\n\nTraducciones(Value): \n" + getValue() + "\n");
        return s.toString();
    }

}
