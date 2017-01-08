package com;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

public class PublishSubjectOps {

	public static void main(String[] args) {

		pubsub();
	}

	private static void pubsub() {

		List<String> l = IntStream.range(1, 10).mapToObj(i->""+i).collect(Collectors.toList());
		
		PublishSubject<String> publishSubject = PublishSubject.create();
		
		publishSubject.subscribe(s->System.out.println("subsciber1:"+s+ currentThread()));
		publishSubject.subscribe(s->System.out.println("subsciber2:"+s+ currentThread()));
		
		publishSubject.onNext("item1:"+System.nanoTime());
		publishSubject.onNext("item2:"+System.nanoTime());
		
		Observable.from(l).observeOn(Schedulers.io()).subscribe(publishSubject);
		
	}

	private static String currentThread() {
		// TODO Auto-generated method stub
		return " ,"+Thread.currentThread().getName();
	}

}
