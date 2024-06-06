package hegenberg.OOP2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Apriori {

    private static final String SEPERATOR = ";";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Eingabedatei einlesen
        File inputFile = new File(args[0]);
        FileReader fileReader = new FileReader(inputFile);
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            // Handle file-related exceptions
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        fileReader.close();

        // Datensatz erstellen
        List<List<String>> dataset = new ArrayList<>();
        for (String currentLine : lines) {
            List<String> items = new ArrayList<>();
            for (String item : currentLine.split(SEPERATOR)) {
                items.add(item);
            }
            dataset.add(items);
        }

        // A-priori-Algorithmus ausführen
        List<List<String>> frequentItemsets = apriori(dataset, 0);

        // Ausgabedatei erstellen
        File outputFile = new File(args[1]);
        FileWriter fileWriter = new FileWriter(outputFile);
        for (List<String> itemset : frequentItemsets) {
            fileWriter.write(itemset.toString() + "\n");
            System.out.println(itemset.toString()); // Add console output
        }
        fileWriter.close();
    }

    private static List<List<String>> apriori(List<List<String>> dataset, int minSupport) {
        // Unterstützungstabelle erstellen
        Map<List<String>, Integer> supportMap = new HashMap<>();
        for (List<String> itemset : dataset) {
            for (int i = 0; i < itemset.size(); i++) {
                List<String> subset = new ArrayList<>(itemset);
                subset.remove(itemset.get(i));
                supportMap.put(subset, supportMap.getOrDefault(subset, 0) + 1);
            }
        }

        // Frequente Itemsets der Länge 1 finden
        List<List<String>> frequentItemsets1 = new ArrayList<>();
        for (Map.Entry<List<String>, Integer> entry : supportMap.entrySet()) {
            if (entry.getValue() >= minSupport) {
                frequentItemsets1.add(entry.getKey());
            }
        }

        // Frequente Itemsets der Länge > 1 finden
        List<List<String>> frequentItemsets2 = new ArrayList<>();
        for (List<String> itemset1 : frequentItemsets1) {
            for (List<String> itemset2 : frequentItemsets1) {
                if (itemset1.size() + 1 == itemset2.size()) {
                    boolean isSubset = true;
                    for (String item : itemset2) {
                        if (!itemset1.contains(item)) {
                            isSubset = false;
                            break;
                        }
                    }

                    if (isSubset) {
                        int support = supportMap.get(itemset1) + supportMap.get(itemset2);
                        if (support >= minSupport) {
                            if (frequentItemsets2.isEmpty()) {
                                frequentItemsets2.add(itemset2);
                            } else {
                                throw new IllegalStateException(
                                        "Frequent itemsets with length > 1 should not be empty");
                            }
                        }
                    }
                }
            }
        }

        // Frequente Itemsets rekursiv finden
        return frequentItemsets2;
    }
}
