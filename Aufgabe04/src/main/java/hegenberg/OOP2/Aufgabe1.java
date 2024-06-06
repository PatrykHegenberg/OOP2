package hegenberg.OOP2;

import java.util.ArrayList;
import java.util.Iterator;

public class Aufgabe1 {
    public static void main(String[] args) {

        // ArrayList erstellen und Elemente hinzufügen:
        // Erstelle eine leere ArrayList vom Typ String.
        // Füge folgende 5 Strings hinzu.
        // Berlin, Dublin, Amsterdam, Edinburgh, Cairo

        ArrayList<String> aList = new ArrayList<>();
        aList.add("Berlin");
        aList.add("Dublin");
        aList.add("Amsterdam");
        aList.add("Edinburgh");
        aList.add("Cairo");
        System.out.println(aList);

        // Elemente entfernen: (verschiedene Aufrufe von remove(...))
        // Entferne „Cairo“ aus der ArrayList.
        // Füge „Addis Abeba“ hinzu.
        // Lösche das zweite Element
        aList.remove("Cairo");
        System.out.println(aList);
        aList.add("Addis Abeba");
        System.out.println(aList);
        aList.remove(1);
        System.out.println(aList);

        // Elemente abrufen:
        // Gib das erste und das letzte Element der ArrayList aus.
        // Iteriere über die ArrayList und gib jedes Element aus.

        String sFirst = aList.get(0);
        System.out.println(sFirst);
        String sLast = aList.get(aList.size() - 1);
        System.out.println(sLast);

        for (String s : aList)
            System.out.println(s);

        // Lösche alle Elemente, die mit „A“ beginnnen.
        // Variante 1: for(...;...;...)-Schleife: funktioniert, aber zeitaufwändig

        for (int i = 0; i < aList.size(); i++) {
            String s = aList.get(i);
            if (s.charAt(0) == 'A')
                aList.remove(i);
        }
        System.out.println(aList);

        // // Variante 2: for(... : ...)-Schleife: funktioniert nicht, weil keine
        // Änderung möglich
        // for (String s : aList) {
        // if (s.charAt(0) == 'A')
        // aList.remove(s);
        // }
        // System.out.println(aList);
        //
        // // Variante: for-Schleife mit Iteratoren: funktioniert
        // for (Iterator<String> iter = aList.iterator(); iter.hasNext(); ) {
        // String s = iter.next();
        // if (s.charAt(0) == 'A')
        // iter.remove();
        // }
        // System.out.println(aList);

        // ArrayList kombinieren und sortieren:
        // Erstelle eine zweite ArrayList und füge sie zur ersten hinzu.
        // Überprüfe, ob ein bestimmtes Element in der kombinierten ArrayList vorhanden
        // ist.
        // Sortiere die ArrayList alphabetisch.

        ArrayList<String> aList2 = new ArrayList<>();
        aList2.add("Yaounde");
        aList2.add("Zagreb");
        aList2.add("Xalapa");
        aList.addAll(aList2);
        System.out.println(aList);

        System.out.println(aList.contains("Berlin") ? "in der Liste" : "nicht in der Liste");
        System.out.println(aList.contains("Hannover") ? "in der Liste" : "nicht in der Liste");

        aList.sort(null);
        System.out.println(aList);
    }

}
