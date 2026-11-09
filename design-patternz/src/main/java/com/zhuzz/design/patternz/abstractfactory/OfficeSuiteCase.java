package com.zhuzz.design.patternz.abstractfactory;

/**
 * 抽象工厂模式 - 办公套件案例
 *
 * @author zhuzz
 * 2023/8/29 17:21
 */
public class OfficeSuiteCase {
    public static void main(String[] args) {
        SoftwareFactory windowsFactory = new WindowsFactory();
        OperatingSystem windowsOS = windowsFactory.createOperatingSystem();
        WordProcessor windowsWord = windowsFactory.createWordProcessor();
        Spreadsheet windowsSheet = windowsFactory.createSpreadsheet();

        windowsOS.run();
        windowsWord.editDocument();
        windowsSheet.calculate();

        System.out.println("----------");

        SoftwareFactory linuxFactory = new LinuxFactory();
        OperatingSystem linuxOS = linuxFactory.createOperatingSystem();
        WordProcessor linuxWord = linuxFactory.createWordProcessor();
        Spreadsheet linuxSheet = linuxFactory.createSpreadsheet();

        linuxOS.run();
        linuxWord.editDocument();
        linuxSheet.calculate();
    }

    // ========== 抽象产品 ==========

    interface OperatingSystem {
        void run();
    }

    interface WordProcessor {
        void editDocument();
    }

    interface Spreadsheet {
        void calculate();
    }

    // ========== Windows 产品族 ==========

    static class WindowsOS implements OperatingSystem {
        @Override
        public void run() {
            System.out.println("Running Windows OS");
        }
    }

    static class Word implements WordProcessor {
        @Override
        public void editDocument() {
            System.out.println("Editing document with Microsoft Word");
        }
    }

    static class Excel implements Spreadsheet {
        @Override
        public void calculate() {
            System.out.println("Calculating with Microsoft Excel");
        }
    }

    // ========== Linux 产品族 ==========

    static class LinuxOS implements OperatingSystem {
        @Override
        public void run() {
            System.out.println("Running Linux OS");
        }
    }

    static class LibreWriter implements WordProcessor {
        @Override
        public void editDocument() {
            System.out.println("Editing document with LibreOffice Writer");
        }
    }

    static class LibreCalc implements Spreadsheet {
        @Override
        public void calculate() {
            System.out.println("Calculating with LibreOffice Calc");
        }
    }

    // ========== 抽象工厂 ==========

    interface SoftwareFactory {
        OperatingSystem createOperatingSystem();
        WordProcessor createWordProcessor();
        Spreadsheet createSpreadsheet();
    }

    // ========== 具体工厂 ==========

    static class WindowsFactory implements SoftwareFactory {
        @Override
        public OperatingSystem createOperatingSystem() {
            return new WindowsOS();
        }

        @Override
        public WordProcessor createWordProcessor() {
            return new Word();
        }

        @Override
        public Spreadsheet createSpreadsheet() {
            return new Excel();
        }
    }

    static class LinuxFactory implements SoftwareFactory {
        @Override
        public OperatingSystem createOperatingSystem() {
            return new LinuxOS();
        }

        @Override
        public WordProcessor createWordProcessor() {
            return new LibreWriter();
        }

        @Override
        public Spreadsheet createSpreadsheet() {
            return new LibreCalc();
        }
    }
}