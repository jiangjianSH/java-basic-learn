package com.jiangjian.study.java.designpattern.structural.facade;

public class ComputerFacade {
    private static final long BOOT_ADDRESS = 0;
    private static final long BOOT_SECTOR = 1;
    private static final int SECTOR_SIZE = 512;

    private CPU cpu;
    private HardDrive drive;
    private Memory memory;

    public ComputerFacade() {
        cpu = new CPU();
        drive = new HardDrive();
        memory = new Memory();
    }

    public void start() {
        cpu.freeze();
        memory.load(BOOT_ADDRESS, drive.read(BOOT_SECTOR, SECTOR_SIZE));
        cpu.jump(BOOT_ADDRESS);
        cpu.execute();
    }

    public static void main(String[] args) {
        new ComputerFacade().start();
    }
}
