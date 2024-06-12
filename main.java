package io.7zcrack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class main {
  public static void generatePasswords(String[] strings, int length, List<String> result, String currentPassword) {
    if (currentPassword.length() == length) {
      result.add(currentPassword);
      return;
    }

    for (String s : strings) {
      if (!currentPassword.contains(s)) {
        generatePasswords(strings, length, result, currentPassword + s);
      }
    }
  }

  public static List<String> generatePasswords(String[] strings) {
    List<String> result = new ArrayList<>();
    for (int i = 1; i <= 15; i++) {
      generatePasswords(strings, i, result, "");
    }
    return result;
  }

  public static List<String> getUniquePasswords(String[] strings) {
    List<String> passwords = generatePasswords(strings);
    Set<String> uniquePasswords = new HashSet<>(passwords);
    return new ArrayList<>(uniquePasswords);
  }

  public static void main(String[] args) {
    String[] strings = {"xx55", "aa", ".", "bbb", "cccc", "xxx", "2025"};
    List<String> uniquePasswords = getUniquePasswords(strings);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("1.txt"))) {
      for (String password : uniquePasswords) {
        writer.write(password);
        writer.newLine();
      }
    } catch (IOException e) {
      System.err.println("Error writing to file: " + e.getMessage());
    }
  }
}
