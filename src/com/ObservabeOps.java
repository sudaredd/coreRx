package com;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;

public class ObservabeOps {

	static List<String> words = Arrays.asList("1","5","2","3","2");
	
	public static void main(String[] args) {
		filter();
		takeUntil();
		concat();
		merge();
		zip();
	}

	private static void zip() {
		Observable<Integer> one = Observable.from(Arrays.asList(1,2,3));
		Observable<String> two = Observable.from(Arrays.asList("one","two"));
		
		
		Observable.zip(one, two,(t1,t2)->t1+t2)
		.subscribe(s->System.out.println("in zip:"+s));
		

		
	}

	private static void merge() {

				 
		Observable<String> one = Observable.from(new String[]{"1","2","3"});
		Observable<String> two = Observable.from(new String[]{"4","5"});
		one.mergeWith(two)
		.subscribe(s->System.out.println("in merge:"+s));
	}

	private static String currentThread() {
		// TODO Auto-generated method stub
		return Thread.currentThread().getName();
	}

	private static void concat() {
		Observable<String> one = Observable.from(new String[]{"1","2","3"});
		Observable<String> two = Observable.from(new String[]{"4","5"});
		one.concatWith(two)
		.subscribe(s->System.out.println("in concat:"+s));
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
