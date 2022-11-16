import com.sun.source.doctree.SeeTree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String s = "HeHlo";

        // normal program
        for (Character c : s.toCharArray()) {
            if (s.indexOf(c) == s.lastIndexOf(c))
            {
                System.out.println(c);
                break;
            }
        }

        // using hashMap
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i=0; i<s.length(); i++)
        {
            Character ch;
            ch = s.charAt(i);
            if (map.containsKey(ch))
            {
                map.put(ch, map.get(ch)+1);
            }
            else {
                map.put(ch,1);
            }
        }
        for (Map.Entry<Character,Integer> en: map.entrySet()) {
            if (en.getValue() == 1)
            {
                System.out.println(en.getKey());
                break;
            }
        }


        // counting the no of vowels present in the string
        String str = "hello my name is shivam chaubey";
        String[] arr = str.split(" ");
        LinkedHashMap<String, Long> collect = Arrays.stream(arr).collect(Collectors.toMap(st -> st, st1 -> st1.chars().filter(c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u').count(),(a,b)->a , LinkedHashMap::new));
        collect.entrySet().stream().forEach(System.out::println);
    }
}