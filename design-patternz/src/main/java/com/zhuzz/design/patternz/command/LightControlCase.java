package com.zhuzz.design.patternz.command;

/**
 * 命令模式 - 电灯遥控案例
 *
 * @author zhuzz
 * 2023/8/29 17:47
 */
public class LightControlCase {

    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(livingRoomLightOn);
        remote.pressButton(); // 打开电灯
        remote.pressUndoButton(); // 撤销：关闭电灯

        remote.setCommand(livingRoomLightOff);
        remote.pressButton(); // 关闭电灯
        remote.pressUndoButton(); // 撤销：打开电灯
    }

    interface Command {
        void execute();
        void undo();
    }

    static class LightOnCommand implements Command {
        private final Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOn();
        }

        @Override
        public void undo() {
            light.turnOff();
        }
    }

    static class LightOffCommand implements Command {
        private final Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOff();
        }

        @Override
        public void undo() {
            light.turnOn();
        }
    }

    static class Light {
        void turnOn() {
            System.out.println("Light is on");
        }

        void turnOff() {
            System.out.println("Light is off");
        }
    }

    static class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }

        public void pressUndoButton() {
            command.undo();
        }
    }

}