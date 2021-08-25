package com.bell.thyme;

import org.example.Delayer;

public class ThymeApplication {

	public static void main(String[] args) {

		//запуск потока чтения файла с задержкой
		Delayer delayer = new Delayer();
		delayer.setDaemon(true);
		delayer.start();

		// запуск спринговой части приложения
		SpringAppAnnotation.startApp();
	}
}
