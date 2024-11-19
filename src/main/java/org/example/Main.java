package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");
        System.out.print("명령 ) ");
        String cmd = scanner.nextLine();

        System.out.println("입력된 명령어 : %s".formatted(cmd));

        scanner.close();
    }
}
