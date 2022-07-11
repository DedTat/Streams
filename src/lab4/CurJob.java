package lab4;

import com.study.Main;

public class CurJob {

    private int doItAlready = 1;
    private int doItTo;
    private boolean Pit = false;
    private boolean Tree = false;
    private boolean Rope = false;

    public CurJob(int timesdoit) {
        doItTo = timesdoit;
    }

    public int getDoItAlready() {
        return doItAlready;
    }

    public boolean isPit() {
        return Pit;
    }

    public void setPit() {
        Pit = true;
    }

    public boolean isTree() {
        return Tree;
    }

    public void setTree() {
        Tree = true;
    }

    public boolean isRope() {
        return Rope;
    }

    public void setRope() {
        Rope = true;
    }

    public void goNext(){
        doItAlready++;
        Pit = false;
        Tree = false;
        Rope = false;
        Main.myPrint("We go next place.");
    }

    public boolean needMore() {
        return doItAlready <= doItTo;
    }
}
