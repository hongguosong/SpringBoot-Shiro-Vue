package com.heeexy.example.ice;

public class IceThread extends Thread{

    private String[] args;

    public IceThread (String[] args) {
        this.args = args;
    }

    @Override
    public void run() {
        IceServiceEntrance entrance = IceServiceEntrance.getInstance();
        entrance.main("ClientMonitor", args,"config.client");
    }
}
