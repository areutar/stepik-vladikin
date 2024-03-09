package module6._621.symmetricDifference;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(0, 1, 2));
        Set<Integer> set2 = new HashSet<>(Set.of(1, 2, 3));
        System.out.println(symmetricDifference(set1, set2));
    }

    public static <T> Set<T> symmetricDifference(
            Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set1MinusSet2 = difference(set1, set2);
        Set<T> set2MinusSet1 = difference(set2, set1);
        set1MinusSet2.addAll(set2MinusSet1);
        return set1MinusSet2;
    }

    public static <T> Set<T> difference(
            Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> resulSet = new HashSet<>();
        for (T t : set1) {
            if (!set2.contains(t)) {
                resulSet.add(t);
            }
        }
        return resulSet;
    }
}
