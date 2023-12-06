package ait.printer;

public class Printer extends Thread {
    private int number;
    private int portionSize;
    private int totalPortions;
    private Thread nextThread;

    public Printer(int number, int portionSize, int totalPortions) {
        this.number = number;
        this.portionSize = portionSize;
        this.totalPortions = totalPortions;
    }

    @Override
    public void run() {
       // try {
            for (int i = 0; i < totalPortions; i++) {
                printPortion(portionSize);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (isInterrupted()) {
                   break;}
                if (nextThread != null) {
                    nextThread.interrupt();
                }
            }
      //  } catch (Exception e) {
        //    e.printStackTrace();
      //  }
    }

    private void printPortion(int portionSize) {
        for (int i = 0; i < portionSize; i++) {
            System.out.print(number);
        }
        System.out.println();
    }

    public void setNextThread(Thread nextThread) {
        this.nextThread = nextThread;
    }
}
