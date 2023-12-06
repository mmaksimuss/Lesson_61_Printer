package ait.task;

import ait.printer.Printer;

public class PrinterAppl {
    public static void main(String[] args) {
        int numberOfThreads = 4;
        int portionSize = 10;
        int totalPortions = 100;

        Printer[] printers = new Printer[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            printers[i] = new Printer(i + 1 , portionSize, totalPortions);
        }
        for (int i = 0; i < numberOfThreads - 1; i++) {
            printers[i].setNextThread(printers[i + 1]);
        }
        printers[numberOfThreads - 1].setNextThread(printers[0]);
        for (Printer printerThread : printers) {
            printerThread.start();
        }
        printers[0].interrupt();
    }
}