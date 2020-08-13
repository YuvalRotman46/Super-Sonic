package actions;

public abstract class Action implements Runnable {

    public Thread actionThread;
    public volatile boolean isActive;

    public Action(){
        actionThread = new Thread(this);
        isActive = false;
    }

    @Override
    public void run() {
        execute();
    }

    protected abstract void execute();

    public void start(){
        isActive = true;
        actionThread.start();
    }

    public void stop(){
        isActive = false;
        actionThread.interrupt();
    }

    public abstract String getActionName();
}
