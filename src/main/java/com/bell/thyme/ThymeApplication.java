package com.bell.thyme;

public class ThymeApplication {

	public static void main(String[] args) {

	 SpringAppAnnotation.startApp();
		// запускает спринговую часть приложения,хотя приложение
		//и без него отлично стартует и корректно работает с аннотацией @SpringBootApplication
		//но для понимания работы лучше заменить эту аннотацию ее эквивалентами,
		//тогда спринговая часть не будет запускаться без вызова из main (сама по себе)
	}

}
