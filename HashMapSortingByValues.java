import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by kohas02 on 6/30/18.
 */
public class HashMapSortingByValues {

    public static void main(String args[]){
        HashMap hmap = new HashMap();
        hmap.put(5, "A");
        hmap.put(11, "C");
        hmap.put(4, "Z");
        hmap.put(77, "Y");
        hmap.put(9, "P");
        hmap.put(66, "Q");
        hmap.put(0, "R");

        System.out.println("b4 sorting by values ");
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.print(entry.getKey()+" : "+entry.getValue());
            System.out.println("");
        }

        Map sortedMap = sortedByValues(hmap);
        Set sortedSet = sortedMap.entrySet();
        Iterator sortedIterator = sortedSet.iterator();
        System.out.println("after sorting by values ");
        while(sortedIterator.hasNext()){
            Map.Entry entry = (Map.Entry) sortedIterator.next();
            System.out.print( entry.getKey() +" : "+ entry.getValue());
            System.out.println("");
        }
    }

    private static HashMap sortedByValues(HashMap map){
        List list = new ArrayList(map.entrySet());
        Comparator comp = ( o1, o2 ) -> ((Map.Entry<Integer,String>)o2).getValue().compareTo(((Map.Entry<Integer,String>) o1).getValue());

        Collections.sort(list,comp);
//        Collections.sort(list,( o1, o2) ->
//
//        {
//        System.out.println("astha");
//            return ((Map.Entry<Integer,String>)o1).getValue().compareTo(((Map.Entry<Integer,String>) o2).getValue());
//        });
//        Collections.sort(list, new Comparator<Map.Entry<Integer,String>>() {
//            @Override
//            public int compare(Map.Entry<Integer,String> o1, Map.Entry<Integer,String> o2) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });

//        Collections.sort(list, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return ((Comparable) ((Map.Entry)(o1)).getValue()).compareTo(((Map.Entry)(o2)).getValue());
//            }
//        });

        HashMap sortedMap = new LinkedHashMap();
        for(Iterator iterator=list.iterator();iterator.hasNext();){
            Map.Entry entry = (Map.Entry) iterator.next();
            sortedMap.put(entry.getKey(),entry.getValue() );
        }
        return sortedMap;

    }


}
