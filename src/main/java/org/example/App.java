package org.example;

import org.example.domain.wiseSaying.controller.WiseSayingController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner;
    //    private final ArrayList<WiseSayingSetting> sayingList;
//    private final List<WiseSayingSetting> sayingList;
    // SayingOption[] sayingOptions = new SayingOption[100];
    int count = 0;

    private final WiseSayingController wiseSayingController;

    App() {
        scanner = new Scanner(System.in);
//        sayingList = new ArrayList<>();
        wiseSayingController = new WiseSayingController();
    }

    public void run() {

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령 ) ");
            String cmd = scanner.nextLine();

            if (cmd.startsWith("삭제?id=")) {
                wiseSayingController.deleteSaying(cmd);
                continue;
            }

            if (cmd.startsWith("수정?id=")) {
                wiseSayingController.modifySaying(cmd);
                continue;
            }

            switch (cmd) {
                case "등록":
                    wiseSayingController.registerAdd();
                    break;
                case "목록":
                    wiseSayingController.sayingList();
                    break;
                case "종료":
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 명령입니다.");
                    break;
            }
        }
    }
}
