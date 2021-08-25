package com.bell.thyme.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Delayer extends Thread {

    public long delayFromProperties;
    private long frequency;
    public static long actualDelay;

    @Override
    public void run() {
        while(Delayer.currentThread().isAlive())   {
            init();
            frequencyDelayed();
        }
    }

    public void init() {

        File delayProperties = new File("C:\\Users\\user013\\Desktop\\DelayProperties.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(delayProperties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parameters = line.split(",");
            delayFromProperties = Long.parseLong(parameters[1]);
            frequency = Long.parseLong(parameters[2]);
        }
        scanner.close();
        actualDelay = delayFromProperties;
    }

    public void frequencyDelayed() {
        synchronized (Thread.currentThread()) {
            try {
                Thread.currentThread().wait(frequency);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static long getActualDelay(){
        return actualDelay;
    }
}
