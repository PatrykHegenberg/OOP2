package hegenberg.OOP2;

import java.util.ArrayList;
import java.util.HashSet;

public class Aufgabe2 {

    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(5);
        set1.add(7);
        set1.add(11);
        set1.add(13);
        set1.add(17);

        System.out.println("set1 = " + set1);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(5);
        set2.add(8);
        set2.add(13);
        set2.add(21);
        System.out.println("set2 = " + set2);

        System.out.println("Vereinigungsmenge: " + getVereinigungsmenge(set1, set2));
        System.out.println("Schnittmenge: " + getSchnittmenge(set1, set2));
        System.out.println("Ist set1 eine Teilmenge von set2: " + isTeilmenge(set1, set2));
        System.out.println("Komplement s1\\s2: " + getKomplement(set1, set2));
        System.out.println("Potenzmenge von s1: " + getPotenzmenge(set1));

    }

    private static HashSet<Integer> getVereinigungsmenge(HashSet<Integer> s1, HashSet<Integer> s2) {
        HashSet<Integer> returnSet = new HashSet<>();
        returnSet.addAll(s1);
        returnSet.addAll(s2);
        return returnSet;
    }

    private static HashSet<Integer> getSchnittmenge(HashSet<Integer> s1, HashSet<Integer> s2) {
        HashSet<Integer> returnSet = new HashSet<>();
        for (Integer i : s1)
            if (s2.contains(i))
                returnSet.add(i);
        for (Integer i : s2)
            if (s1.contains(i))
                returnSet.add(i);
        return returnSet;
    }

    private static boolean isTeilmenge(HashSet<Integer> s1, HashSet<Integer> s2) {
        if (s2.containsAll(s1))
            return true;
        else
            return false;
    }

    private static HashSet<Integer> getKomplement(HashSet<Integer> s1, HashSet<Integer> s2) {
        HashSet<Integer> returnSet = new HashSet<>();
        returnSet.addAll(s1);
        returnSet.removeAll(s2);
        return returnSet;
    }

    private static HashSet<HashSet<Integer>> getPotenzmenge(HashSet<Integer> s1) {
        HashSet<HashSet<Integer>> returnSet = new HashSet<>();

        // k = 1 --> zu jedem Element von s1 die Menge mit diesem Element hinzufügen
        for (Integer i : s1) {
            HashSet<Integer> tempSet = new HashSet<>();
            tempSet.add(i);
            returnSet.add(tempSet);
        }

        // k > 1 --> für alle k>1: füge zu allen k-elementigen Menge die o.g.
        // 1-elementigen Mengen hinzu
        for (int k = 2; k < s1.size(); k++) {
            HashSet<HashSet<Integer>> tempReturnSet = new HashSet<>();
            for (HashSet<Integer> hs : returnSet) {
                if (hs.size() == k - 1) {
                    for (Integer i : s1) {
                        HashSet<Integer> tempSet = new HashSet<>();
                        tempSet.addAll(hs);
                        tempSet.add(i);
                        tempReturnSet.add(tempSet);
                    }
                }
            }
            returnSet.addAll(tempReturnSet);
        }
        return returnSet;
    }

}
