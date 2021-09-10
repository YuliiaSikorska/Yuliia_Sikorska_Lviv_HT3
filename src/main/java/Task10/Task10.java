package Task10;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

    public class Task10 {
        public static List<Character> getSortedLastLettersInUpperCase(List<String> stringList) {
            return stringList.stream()
                    .filter(Objects::nonNull)
                    .sorted((o1, o2) -> {
                        if (o1.length() < o2.length()){
                            return 1;
                        } else {
                            return String.valueOf(o1.charAt(o1.length() - 1)).compareTo(String.valueOf(o2.charAt(o2.length() - 1)));
                        }
                    })
                    .map(s -> Character.toUpperCase(s.charAt(s.length() - 1)))
                    .collect(Collectors.toList());
        }
    }

