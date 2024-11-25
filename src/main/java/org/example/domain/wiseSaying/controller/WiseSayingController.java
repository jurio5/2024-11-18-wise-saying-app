package org.example.domain.wiseSaying.controller;

import org.example.WiseSayingSetting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final List<WiseSayingSetting> sayingList;
    Scanner scanner;
    int count = 0;

    public WiseSayingController() {
    sayingList = new ArrayList<>();
    scanner = new Scanner(System.in);
    makeSampleData();
    }

    public void sayingList() {
        if (sayingList.isEmpty()) {
//      if (count == 0) {
            System.out.println("목록이 비어있습니다.");
            return;
        }

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-----------------------");

        for (WiseSayingSetting i : sayingList.reversed()) {
            System.out.println(i.getId() + " / " + i.getAuthor() + " / " + i.getComment());
        }
//            for (int i = list.size()-1; i >= 0; i--) {
//                System.out.println(list.get(i).getId() + " / " + list.get(i).getAuthor() + " / " + list.get(i).getComment());
//            }
    }

    public void deleteSaying(String cmd) {
//        System.out.println("입력된 명령 : " + cmd);
        try {
            String div = cmd.split("=", 2)[1];
            int convert = Integer.parseInt(div);
            boolean removeId = sayingList.removeIf(s -> s.getId() == convert);

            if (removeId) {
                System.out.println(convert + "번 명언이 삭제되었습니다.");
            } else {
                System.out.println(convert + "번 명언은 존재하지 않습니다.");
            }

        } catch (NumberFormatException e) {
            System.out.println("잘못된 형식 입니다. 숫자?id=번호 형식으로 작성해 주세요.");
        }
    }

    private void makeSampleData() {
        addWiseSaying("가나", "다라");
        addWiseSaying("간난", "단란");

    }

    public void addWiseSaying(String author, String comment) {
        int id = ++count;

        sayingList.add(createWiseSaying(id, author, comment));
    }

    public void registerAdd() {
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        System.out.print("명언 : ");
        String comment = scanner.nextLine();

        if (speciaLimited(author) || speciaLimited(comment)) {
            return;
        }

        addWiseSaying(author, comment);
//        sayingList.add(count,createMember(count,author,comment));
//      sayingOptions[count] = createSaying(count,author,comment);
//        count++;
        System.out.println(count + "번 명언이 등록되었습니다.");
    }

    public WiseSayingSetting createWiseSaying(int id, String author, String comment) {

        return new WiseSayingSetting(id, author, comment);
    }

    public boolean speciaLimited(String str) {
        if (str.matches("^[^!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+$")) {
            return false;
        }
        System.out.println("특수문자를 사용할 수 없습니다.");
        return true;
    }

    public void modifySaying(String cmd) {
        try {
            String div = cmd.split("=", 2)[1];
            int convert = Integer.parseInt(div);
            WiseSayingSetting target = null;

            for (WiseSayingSetting s : sayingList) {
                if (s.getId() == convert) {
                    target = s;
                    break;
                }
            }

            if (target == null) {
                System.out.println(convert + "번 명언은 존재하지 않습니다.");
                return;
            }
            System.out.println("명언(기존) : " + target.getAuthor());

            System.out.print("명언 : ");
            String comment = scanner.nextLine();
            target.setComment(comment);

            System.out.println("작가(기존) : " + target.getComment());

            System.out.print("작가 : ");
            String author = scanner.nextLine();
            target.setAuthor(author);

        } catch (NumberFormatException e) {
            System.out.println("잘못된 형식 입니다. 숫자?id=번호 형식으로 작성해 주세요.");
        }
    }

}
