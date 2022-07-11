package lab4;

import com.study.Main;

public class TieUpThread implements Runnable{
    private final CurJob curJob;

    public TieUpThread(CurJob curJob) {
        this.curJob = curJob;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            while (curJob.needMore()){
                synchronized (curJob){
                    if (!curJob.isPit() || !curJob.isTree() ) {
                        curJob.wait();
                    }
                    else {
                        curJob.setRope();
                        Main.myPrint(name + ": I'm tie up tree №" + curJob.getDoItAlready());
                        curJob.goNext();
                        curJob.notifyAll();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}