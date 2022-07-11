package lab4;

import com.study.Main;

public class DigThread implements Runnable{

    private final CurJob curJob;

    public DigThread(CurJob curJob) {
        this.curJob = curJob;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            while (curJob.needMore()){
                synchronized (curJob){
                    if (curJob.isPit()) {
                        curJob.wait();
                    }
                    else {
                        curJob.setPit();
                        Main.myPrint(name + ": I'm dig a pit №" + curJob.getDoItAlready());
                        curJob.notifyAll();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}