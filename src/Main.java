import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String[][] user = new String[3][5];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 유저 정보
        user[0][0] = "aa";
        user[0][1] = "1234";
        user[0][2] = "경기";
        user[0][3] = "010-1234-5678";
        user[0][4] = "A씨";

        user[1][0] = "bb";
        user[1][1] = "1235";
        user[1][2] = "부산";
        user[1][3] = "010-2345-6789";
        user[1][4] = "B군";

        user[2][0] = "cc";
        user[2][1] = "1236";
        user[2][2] = "강원";
        user[2][3] = "010-9875-6432";
        user[2][4] = "C양";


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
                if (id.equals(user[i][0])) {
                    index = i;
                }
            }

            if (index != -1) { // index 0~2일때 실행
                System.out.println("PW 입력 : ");
                String pw = input.nextLine();
                if (pw.equals(user[index][1])) {
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
                    System.out.println("전체 주소록 검색");
                    break;
                case 3:
                    System.out.println("내정보 변경");
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
    // 주소록 검색 정보 확인
    public static void search() {
        for (int i = 0; i < user.length; i++) {
            for (int j = 0; j < user[i].length - 2; j++){
                String userAddress = user[i][2];
                String userPhone = user[i][3];
                String userName = user[i][4];

                System.out.println( user[i][0] + "님의 주소 : " + userAddress );
                System.out.println( user[i][0] + "님의 전화번호 : " + userPhone );
                System.out.println( user[i][0] + "님의 이름 : " + userName );
            }
            System.out.println();
        }
    }
}
