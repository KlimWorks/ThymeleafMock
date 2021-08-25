package com.bell.thyme;

import com.bell.thyme.config.Delayer;

public class ThymeApplication {

	public static void main(String[] args) {

		Delayer delayer = new Delayer();
		delayer.setDaemon(true);
		delayer.start();

		// запускает спринговую часть приложения
		SpringAppAnnotation.startApp();
	}

}
