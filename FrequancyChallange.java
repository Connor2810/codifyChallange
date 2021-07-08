import java.util.stream.Collectors;

import java.io.InputStreamReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FrequancyChallange {
    public static void main(String[] args) {
        try {
            FileInputStream fStream = new FileInputStream(args[0]);

            System.out.println("File recieved");
            BufferedReader br = new BufferedReader(new InputStreamReader(fStream));

            Scanner sc = new Scanner(System.in);
            System.out.println("1. Count lowercase letters" + "\n2. Count uppercase letters"
                    + "\n3. Count all characters" + "\n4. Exit");
            int option = sc.nextInt();

            while (option <= 4) {
                switch (option) {
                    case 1:
                        

                        int lower = 0;

                        try {

                            String line = "";
                            String text = null;
                            while ((line = br.readLine()) != null) {

                                text += line.toString();

                            }

                            line = text.replaceAll("\\s|\\t|\\r|\\n", "");

                            for (int i = 0; i < line.length(); i++) {
                                char ch = line.charAt(i);
                                if (Character.isLowerCase(ch)) {

                                    lower++;

                                } else {
                                    String charString = String.valueOf(ch);
                                    line = line.replace((charString), "");

                                }
                            }
                            System.out.println("Total number of lowercase characters: " + lower);

                            Map<Character, Integer> frequentChars = line.chars().boxed().collect(Collectors
                                    .toMap(k -> Character.valueOf((char) k.intValue()), v -> 1, Integer::sum));

                            List<Map.Entry<Character, Integer>> chars = frequentChars.entrySet().stream()
                                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10)
                                    .collect(Collectors.toList());

                            System.out.println("Top 10 lowercase characters:");
                            chars.forEach(System.out::println);

                            System.exit(0);

                        } catch (IOException e) {
                            System.out.println("error");
                            e.printStackTrace();
                        }
                    case 2:
                        

                        try {

                            String line = "";
                            String text = null;
                            while ((line = br.readLine()) != null) {

                                text += line.toString();

                            }

                            line = text.replaceAll("\\s|\\t|\\r|\\n", "");

                            int upper = 0;

                            for (int i = 0; i < line.length(); i++) {
                                char ch = line.charAt(i);
                                if (Character.isUpperCase(ch)) {

                                    upper++;

                                } else {
                                    String charString = String.valueOf(ch);
                                    line = line.replace((charString), "");
                                    i--;

                                }

                            }
                            
                            System.out.println("Total number of uppercase characters: " + upper);

                            Map<Character, Integer> frequentChars = line.chars().boxed().collect(Collectors
                                    .toMap(k -> Character.valueOf((char) k.intValue()), v -> 1, Integer::sum));

                            List<Map.Entry<Character, Integer>> chars = frequentChars.entrySet().stream()
                                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10)
                                    .collect(Collectors.toList());

                            System.out.println("Top 10 uppercase characters:");
                            chars.forEach(System.out::println);

                            System.exit(0);

                        } catch (IOException e) {
                            System.out.println("error");
                            e.printStackTrace();
                        }

                    case 3:

                        int charCount = 0;

                        try {

                            String line = "";
                            String text = null;
                            while ((line = br.readLine()) != null) {

                                text += line.toString();

                            }

                            line = text.replaceAll("\\s|\\t|\\r|\\n", "");

                            charCount += line.length();

                            System.out.println("Total number of uppercase and lowercase characters: " + charCount);

                            Map<Character, Integer> frequentChars = line.chars().boxed().collect(Collectors
                                    .toMap(k -> Character.valueOf((char) k.intValue()), v -> 1, Integer::sum));

                            List<Map.Entry<Character, Integer>> chars = frequentChars.entrySet().stream()
                                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10)
                                    .collect(Collectors.toList());

                            System.out.println("Top 10 uppercase and lowercase characters:");
                            chars.forEach(System.out::println);

                            System.exit(0);

                        } catch (IOException e) {
                            System.out.println("error");
                            e.printStackTrace();
                        }
                    case 4:
                        System.exit(0);

                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file, make sure the path to the file is correct");
            e.printStackTrace();
        }

    }
}
