package Task10;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;


    public class Task1 {

        public static List<String> filterByFirstAndLastCharacter(char symbol, List<String> stringList) {
            String symbolNew = Character.toString(symbol);
            return stringList.stream()
                    .filter(Objects::nonNull)
                    .filter(s -> !s.isEmpty() && s.length() > 1 && s.startsWith(symbolNew) && s.endsWith(symbolNew))
                    .collect(Collectors.toList());
        }

        public static void main(String[] args) {
            List<String> stringList = new ArrayList<>();
            stringList.add("Hello");
            stringList.add("qwerty");
            stringList.add("asda");
            stringList.add("asdfa");
            stringList.add("as");
            stringList.add("a");

            List<String> list = filterByFirstAndLastCharacter('a',stringList);
            System.out.println(list);

        }
    }
