package practise;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class filehandling {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        List<String> customerNames = readNamesFromFile(inputFile);
        if (customerNames.isEmpty()) {
            System.out.println("file do not exist");
            return;
        }
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<String> greetedNames = Collections.synchronizedList(new ArrayList<>());
        for (String name : customerNames) {
            executor.submit(new GreetingTask(name, greetedNames));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.err.println("Processing interrupted: " + e.getMessage());
        }
        writeNamesToFile(outputFile, greetedNames);
        System.out.println("data has been written to output file " + outputFile);
    }
    private static List<String> readNamesFromFile(String fileName) {
        List<String> names = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                names.add(line.trim());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + fileName);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return names;
    }
    private static void writeNamesToFile(String fileName, List<String> names) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String name : names) {
                writer.write(name + System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    static class GreetingTask implements Runnable {
        private final String name;
        private final List<String> greetedNames;

        public GreetingTask(String name, List<String> greetedNames) {
            this.name = name;
            this.greetedNames = greetedNames;
        }
        @Override
        public void run() {
            try {
                String greeting = "Hello, " + name + "!";
                greetedNames.add(greeting);
                System.out.println(Thread.currentThread().getName() + " processed: " + greeting);
            } catch (Exception e) {
                System.err.println("Error processing name: " + name + " - " + e.getMessage());
            }
        }
    }
}
