package lab4;

import com.study.Main;

public class PlantThread implements Runnable{
    private final CurJob curJob;

    public PlantThread(CurJob curJob) {
        this.curJob = curJob;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            while (curJob.needMore()){
                synchronized (curJob){
                    if (!curJob.isPit() || curJob.isTree() ) {
                        curJob.wait();
                    }
                    else {
                        curJob.setTree();
                        Main.myPrint(name + ": I'm plant tree №" + curJob.getDoItAlready());
                        curJob.notifyAll();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}