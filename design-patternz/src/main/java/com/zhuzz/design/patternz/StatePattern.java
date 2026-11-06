package com.zhuzz.design.patternz;

/**
 * 状态模式
 *
 * @author zhuzz
 * 2023/8/29 17:56
 */
public class StatePattern {

    public static void main(String[] args) {
        Elevator elevator = new Elevator();

        elevator.openDoors(); // 当前状态：开门
        elevator.move();      // 当前状态：开门，无法移动
        elevator.closeDoors(); // 当前状态：关门
        elevator.move();       // 当前状态：移动中
        elevator.stop();       // 当前状态：停止
        elevator.openDoors();  // 当前状态：开门
    }

    interface ElevatorState {
        void openDoors();

        void closeDoors();

        void move();

        void stop();
    }

    static class OpenState implements ElevatorState {
        @Override
        public void openDoors() {
            System.out.println("Doors are already open.");
        }

        @Override
        public void closeDoors() {
            System.out.println("Closing doors.");
        }

        @Override
        public void move() {
            System.out.println("Cannot move while doors are open.");
        }

        @Override
        public void stop() {
            System.out.println("Stopping while doors are open.");
        }
    }

    static class CloseState implements ElevatorState {
        @Override
        public void openDoors() {
            System.out.println("Opening doors.");
        }

        @Override
        public void closeDoors() {
            System.out.println("Doors are already closed.");
        }

        @Override
        public void move() {
            System.out.println("Start moving.");
        }

        @Override
        public void stop() {
            System.out.println("Already stopped.");
        }
    }

    static class MovingState implements ElevatorState {
        @Override
        public void openDoors() {
            System.out.println("Cannot open doors while moving.");
        }

        @Override
        public void closeDoors() {
            System.out.println("Doors are already closed.");
        }

        @Override
        public void move() {
            System.out.println("Already moving.");
        }

        @Override
        public void stop() {
            System.out.println("Stopping.");
        }
    }

    static class Elevator {
        private ElevatorState state;

        public Elevator() {
            state = new CloseState(); // 初始状态为关门状态
        }

        public void setState(ElevatorState state) {
            this.state = state;
        }

        public void openDoors() {
            state.openDoors();
            if (!(state instanceof OpenState)) {
                setState(new OpenState());
            }
        }

        public void closeDoors() {
            state.closeDoors();
            if (!(state instanceof CloseState)) {
                setState(new CloseState());
            }
        }

        public void move() {
            state.move();
            if (state instanceof CloseState) {
                setState(new MovingState());
            }
        }

        public void stop() {
            state.stop();
            if (state instanceof MovingState) {
                setState(new CloseState());
            }
        }
    }


}