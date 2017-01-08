package com;

import java.util.Arrays;
import java.util.List;

import rx.Observable;

public class ObservabeOps {

	static List<String> words = Arrays.asList("1","5","2","3","2");
	
	public static void main(String[] args) {
filter();
takeUntil();
	}

	private static void takeUntil() {

		Observable.from(words)
		.takeUntil(s->s.equals("2"))
		.subscribe(s->System.out.println("in take until:"+s));
	}

	private static void filter() {
			Observable.from(words)
			.filter(s->s.equals("2"))
			.subscribe(s->System.out.println("in filter:"+s));
	}

}
