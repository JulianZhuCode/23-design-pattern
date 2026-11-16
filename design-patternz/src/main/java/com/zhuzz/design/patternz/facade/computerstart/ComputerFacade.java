package com.zhuzz.design.patternz.facade.computerstart;

/**
 * 外观：统一封装开机/关机的多个子系统操作
 * Facade: wraps subsystem operations for boot and shutdown
 */
public class ComputerFacade {
    private Power power;
    private Cpu cpu;
    private Memory memory;
    private Disk disk;

    public ComputerFacade() {
        power = new Power();
        cpu = new Cpu();
        memory = new Memory();
        disk = new Disk();
    }

    public void start() {
        System.out.println("Booting the computer...");
        power.on();
        cpu.start();
        memory.load();
        disk.read();
    }

    public void shutdown() {
        System.out.println("Shutting down the computer...");
        disk.stop();
        memory.clear();
        cpu.shutdown();
        power.off();
    }
}