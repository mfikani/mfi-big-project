package mfi.old_packages.betterProgrammer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WriteOnceMapClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1");
		WriteOnceMap a = new WriteOnceMap();
		HashMap mm = new HashMap();
//		a.putAll(mm);
		
		a.put(1, "miled");
		System.out.println("6");
		a.put(2, 22);
		System.out.println("7");
		a.put(1, "fikani");
		System.out.println("8");
	}
	public static class WriteOnceMap<K, V> extends HashMap<K, V> {
            public V put(K key, V value) {
                if (containsKey(key))
                    throw new IllegalArgumentException(key + " already in map");

                return super.put(key, value);
            }


            public void putAll(Map<? extends K, ? extends V> m) {
                for (K key : m.keySet())
                    if (containsKey(key))
                        throw new IllegalArgumentException(key + " already in map");

                super.putAll(m);
            }
        }
   
	
}
