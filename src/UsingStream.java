import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsingStream {
    public static void main(String[] args) {
        String s = "HeHlo";
        HashMap<Character, Integer> map = new LinkedHashMap<>();

        System.out.println("First non-repeated character of the string : ");
        for (Character ch : s.toCharArray())
        {
            map.put(ch,map.containsKey(ch)?map.get(ch)+1:1);
        }
        Character key = map.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey();
        System.out.println(key);


        // second method
        System.out.println("Second method : ");
        Character character = s.chars().mapToObj(ch -> Character.toLowerCase(Character.valueOf((char) ch)))
                .collect(Collectors.groupingBy(n -> n, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1)
                .map(e -> e.getKey()).findFirst().get();
        System.out.println(character);



        // finding first repeated character
        System.out.println("finding first repeated character : ");

        Character character2 = s.chars().mapToObj(str -> Character.toLowerCase(Character.valueOf((char) str)))
                .collect(Collectors.groupingBy(character1 -> character1, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() > 1)
                .map(y -> y.getKey()).findFirst().get();
        System.out.println(character2);
    }
}
