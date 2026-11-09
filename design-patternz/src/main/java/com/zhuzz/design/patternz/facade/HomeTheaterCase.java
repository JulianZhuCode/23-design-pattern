package com.zhuzz.design.patternz.facade;

/**
 * 外观模式 - 家庭影院案例
 *
 * @author zhuzz
 * 2023/8/29 17:40
 */
public class HomeTheaterCase {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        // 准备观影
        homeTheater.watchMovie();

        // 结束观影
        homeTheater.endMovie();
    }


    static class StereoSystem {
        public void turnOn() {
            System.out.println("Stereo System is turned on");
        }

        public void turnOff() {
            System.out.println("Stereo System is turned off");
        }
    }


    static class Projector {
        public void turnOn() {
            System.out.println("Projector is turned on");
        }

        public void turnOff() {
            System.out.println("Projector is turned off");
        }
    }

    static class LightsControl {
        public void turnOn() {
            System.out.println("Lights are turned on");
        }

        public void turnOff() {
            System.out.println("Lights are turned off");
        }
    }

    static class HomeTheaterFacade {
        private StereoSystem stereo;
        private Projector projector;
        private LightsControl lights;

        public HomeTheaterFacade() {
            stereo = new StereoSystem();
            projector = new Projector();
            lights = new LightsControl();
        }

        public void watchMovie() {
            System.out.println("Getting ready to watch a movie...");
            lights.turnOff();
            projector.turnOn();
            stereo.turnOn();
        }

        public void endMovie() {
            System.out.println("Ending the movie...");
            stereo.turnOff();
            projector.turnOff();
            lights.turnOn();
        }
    }

}