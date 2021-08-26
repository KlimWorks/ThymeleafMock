package com.bell.thyme;

import org.example.Delayer;

public class ThymeApplication {

	//прописываем путь к файлу с информацией о задержке
	private static final String delaySourcePath = "C:\\Users\\user013\\Desktop\\DelayProperties.txt";

	public static void main(String[] args) {

		//запуск потока чтения файла с задержкой
		Delayer delayer = new Delayer(delaySourcePath);
		delayer.setDaemon(true);
		delayer.start();

		// запуск спринговой части приложения
		SpringAppAnnotation.startApp();
	}
}
