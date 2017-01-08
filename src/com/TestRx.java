package com;

import rx.Observable;
import rx.functions.Action1;

class A1 implements Action1<String> {
	@Override
	public void call(String arg0) {
		System.out.println("in action A1:" + arg0);
	}
}

public class TestRx {

	public static void main(String[] args) {
		A1 a = new A1();
		Observable.just("Hello, world!").subscribe(a);
		
		Observable.just("no1","no2").subscribe(a);
		
		Observable.just("Hello, world Lambda!").subscribe((String s)->System.out.println(s));
		
		//transform
		Observable.just("Hello, world!")
	    .map(s -> s.hashCode())
	    .map(i -> Integer.toString(i))
	    .subscribe(s -> System.out.println(s));
		
		Observable.just("hello","world")
		.map(s->s+" dd")
		.subscribe(s->System.out.println(s));
		
		
		query("Hello, world!")
	    .flatMap(urls -> Observable.just(urls))
	    .flatMap(url -> getTitle(url))
	    .filter(title -> title != null)
	    .take(5)
	    .doOnNext(title -> saveTitle(title))
	    .subscribe(title -> System.out.println(title));
	}

	private static Object saveTitle(Object title) {

		System.out.println("save title:"+title.toString());
		return Observable.just(title);
	}

	private static Observable getTitle(Object url) {
		return  Observable.just(url);
	}

	private static Observable query(String string) {
		return Observable.just(string.split(","));
	}

}
