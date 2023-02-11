import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Outline {

  private interface TwoStringPredicate {
    boolean compare(String s1, String s2);
  }

  private interface TwoElementPredicate<T> {
    T compare(T t1, T t2);
  }

  public static Integer eChecker(String s1, String s2) {
    if (s1.contains("e") || s1.contains("E") && (!s2.contains("e") && !s2.contains("E"))) {
      return -1;
    } else if (s2.contains("e") || s2.contains("E")) {
      return 1;
    } else {
      return 0;
    }
  };

  public static boolean betterString(String s1, String s2, TwoStringPredicate twoString) {
    return twoString.compare(s1, s2);
  }

  public static <T> T betterElement(T s1, T s2, TwoElementPredicate<T> twoElement) {
    return twoElement.compare(s1, s2);
  }

  static List<String> allMatches(List<String> listIn, Predicate<String> pred) {
    List<String> listOut = new ArrayList<>();
    listIn.forEach(n -> {
      if (pred.test(n)) {
        listOut.add(n);
      }
    });
    return listOut;
  }

  static List<String> transformedString(List<String> listIn, Function<String, String> func) {
    List<String> listOut = new ArrayList<>();
    for (String s : listIn) {
      listOut.add(func.apply(s));
    }
    return listOut;
  }

  static <T> List<T> genericAllMatches (List<T> listIn, Predicate<T> pred) {
    List<T> listOut = new ArrayList<>();
    for (T n : listIn) {
      if (pred.test(n)) {
        listOut.add(n);
      }
    }
    return listOut;
  }

  static <T> List<T> transformedList(List<T> listIn, Function<T, T> func) {
    List<T> listOut = new ArrayList<>();
    for (T n : listIn) {
      listOut.add(func.apply(n));
    }
    return listOut;
  }

  public static void main(String... args) { // varargs alternative to String[]
    Integer[] intArray = {1,7,3,4,8,2};
    System.out.println(Arrays.asList(intArray));
    // Arrays.sort(intArray,.......)

    String[] strArray = {"aaaa", "a", "aaa", "baaaa", "ae"};
    Arrays.sort(strArray, (a, b) -> a.length() - b.length());
    System.out.println(Arrays.asList(strArray));
    Arrays.sort(strArray, (a, b) -> b.length() - a.length());
    System.out.println(Arrays.asList(strArray));
    Arrays.sort(strArray, (a, b) -> a.charAt(0) == b.charAt(0) ? 0 : a.charAt(0) < b.charAt(0) ? -1 : 1);
    System.out.println(Arrays.asList(strArray));
    Arrays.sort(strArray,Outline::eChecker);
    System.out.println(Arrays.asList(strArray));

    System.out.println(betterString("test11", "test2", (s1, s2) -> s1.length() > s2.length()));

    System.out.println(betterElement("test11", "test2", (s1, s2) -> s1.length() > s2.length() ? s1 : s2));



  } 
}
