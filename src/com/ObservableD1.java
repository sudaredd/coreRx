package com;

import java.util.Arrays;
import java.util.List;

import rx.Observable;

public class ObservableD1 {

	static List<String> words = Arrays.asList(
			 "the",
			 "quick",
			 "brown",
			 "fox",
			 "jumped",
			 "over",
			 "the",
			 "lazy",
			 "dog"
			);
	
	public static void zipWith() {
		Observable.from(words)
		 .zipWith(Observable.range(1, Integer.MAX_VALUE), 
		    (string, count)->String.format("%2d. %s", count, string))
		 .subscribe(System.out::println);
	}
	
	public static void printWords() {
		Observable.just(words)
		.subscribe(w->System.out.println("words:"+w));
		
		Observable.from(words)
		.subscribe(w->System.out.println("word:"+w));
	}
	public static void howdy() {
		Observable.just("howdy")
		.subscribe(System.out::println);
		
		Observable.just("Hello", "World")
        .subscribe(System.out::println);
		System.out.println();
	}
	
	public static void main(String[] args) {

		howdy();
		
		printWords();
		
		zipWith();
	}

}
