import java.awt.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static User[] user = new User[3];
    /*
    배열 객체를 담는 과정
    static User[] user = {
        new User("aa", "1234", "경기", "010-1234-5678", "A씨"),
        new User("bb", "1235", "부산", "010-2345-6789", "B군"),
        new User("cc", "1236", "강원", "010-9875-6432", "C양")
    }
    */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // user 변수 각 정보에 담김
        user[0] = new User("aa", "1234", "경기", "010-1234-5678", "A씨");
        user[1] = new User("bb", "1235", "부산", "010-2345-6789", "B군");
        user[2] = new User("cc", "1236", "강원", "010-9875-6432", "C양");

        while (true) {
            System.out.println("<< 주소록 관리 >>");
            System.out.println("1. 로그인\n" + "2. 종료");
            int seleteNumber = input.nextInt();
            input.nextLine(); // ← 엔터 버퍼 제거


            switch (seleteNumber) {
                case 1:
                    if (user()) {
                        menu();
                    } else { // 입력정보 오류시
                        System.out.println("계정정보가 일치하지 않습니다");
                    }
                    continue; // 오류시 다시 처음 화면으로
                case 2:
                    System.out.println("종료합니다");
                    break;
            }
            break;
        }

    }

    // 로그인 정보 입력
    public static boolean user() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("ID 입력 : ");
            String id = input.nextLine();
            int index = -1;

            for (int i = 0; i < user.length; i++) { // index 0~2 를 얻기위함
                if (id.equals(user[i].getId())) {
                    index = i;
                }
            }

            if (index != -1) { // index 0~2일때 실행
                System.out.println("PW 입력 : ");
                String pw = input.nextLine();
                if (pw.equals(user[index].getPw())) {
                    System.out.println("로그인 성공");
                    return true;
                }
            }

            return false;
        }
    }

    // 로그인 성공시 메뉴정보창
    public static void menu() {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("<< 주소록 관리 >>");
            System.out.println("1. 주소록 검색\n2. 전체 주소록 검색\n3. 내정보 변경\n4. 로그아웃");
            int seleteNumber = input.nextInt();

            switch (seleteNumber) {
                case 1:
                    search();
                    break;
                case 2:
                    searchAll();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    System.out.println("로그아웃");
                    break;
                default:
                    System.out.println("존재하지 않는 선택번호");
            }
            if (seleteNumber == 4) {
                break;
            }
        }
    }

    // 주소록 전체 정보 확인
    public static void searchAll() {
        for (int i = 0; i < user.length; i++) {


            System.out.println(user[i].getId() + "님의 주소 : " + user[i].getAddress());
            System.out.println(user[i].getId() + "님의 전화번호 : " + user[i].getPhone());
            System.out.println(user[i].getId() + "님의 이름 : " + user[i].getName());

            System.out.println();
        }
    }

    // 주소록 검색 정보 확인
    public static void search() {
        Scanner input = new Scanner(System.in);
        System.out.println("검색할 유저의 이름");
        String searchUser = input.nextLine();
        for (int i = 0; i < user.length; i++) {
            if (user[i].getId().equals(searchUser)) {
                System.out.println("======================");
                System.out.println(user[i].getId() + "님의 정보");
                System.out.print("주소 : " + user[i].getAddress() +
                        " | 전화번호 : " + user[i].getPhone() +
                        " | 이름 : " + user[i].getName() + "\n");
                System.out.println("======================");
                break;
            }
        }

    }

    // 정보변경
    public static void edit() {
        Scanner input = new Scanner(System.in);
        System.out.println("비밀번호를 입력해주세요");
        String pw = input.nextLine();

        for (int i = 0; i < user.length; i++) {
            if (user[i].getPw().equals(pw)) {
                // 내가 바꿀 입력 정보 문자열 자료형으로
                System.out.println(user[i].getId() + " 주소 정보 변경");
                String changeAddress = input.nextLine();
                System.out.println(user[i].getId() + " 전화번호 정보 변경");
                String changePhone = input.nextLine();
                System.out.println(user[i].getId() + " 이름 정보 변경");
                String changeName = input.nextLine();
                // 그 정보를 set~ (여기에 넣어준다)
                user[i].setAddress(changeAddress);
                user[i].setPhone(changePhone);
                user[i].setName(changeName);
                System.out.println("정보 변경이 완료 되었습니다");

            }
        }

    }
}
