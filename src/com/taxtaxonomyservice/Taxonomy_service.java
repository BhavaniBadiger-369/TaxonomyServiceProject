package com.taxtaxonomyservice;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class Taxonomy_service {

	public LinkedHashMap<String, Integer> commonWordsFrequency = new LinkedHashMap<>();

	public void textToArray(String text) {
		String words[] = text.split("\\s+");

		for (int i = 0; i < words.length; i++) {

			words[i].replaceAll("[^a-zA-Z]", "").toLowerCase();

			if (!words[i].isEmpty()) {

				commonWordsFrequency.put(words[i], commonWordsFrequency.getOrDefault(words[i], 0) + 1);

			}

		}
	}

	public LinkedHashMap<String, Integer> getWordsFrequency() {
		return commonWordsFrequency;
	}

	public static void main(String[] args) {

		Taxonomy_service TaxonomyService = new Taxonomy_service();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a input Text");

		String input = scan.nextLine();

		TaxonomyService.textToArray(input);

		LinkedHashMap<String, Integer> result = TaxonomyService.getWordsFrequency();

		Set<String> set = result.keySet();
		System.out.println();

		System.out.println("Most common used words and their frequency");
		System.out.println();

		for (String key : set) {
			System.out.println(key + " : " + result.get(key));
		}

	}
}
