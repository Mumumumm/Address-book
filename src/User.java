public class User {
    private String id;
    private String pw;
    private String address;
    private String phone;
    private String name;

    // 생성자 클래스랑 같은 이름
    // user에 들어갈 생성자 정보를 한번에 다 담기
    public User(String nId, String nPw, String nAddress, String nPhone, String nName) {
        this.id = nId;
        this.pw = nPw;
        this.address = nAddress;
        this.phone = nPhone;
        this.name = nName;
    }

    //읽기접근자 ID
    public String getId() {
        return this.id;
    }

    //쓰기접근자 ID
    public void setId(String nId) {
        this.id = nId;
    }

    // PW 읽기 쓰기
    public String getPw() {
        return this.pw;
    }

    public void setPw(String nPW) {
        this.pw = nPW;
    }

    // Address 읽기 쓰기
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String nAddress) {
        this.address = nAddress;
    }

    // Phone 읽기 쓰기
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String nPhone) {
        this.phone = nPhone;
    }

    // Name 읽기 쓰기
    public String getName() {
        return this.name;
    }

    public void setName(String nName) {
        this.name = nName;
    }

    // 읽기 접근자 (Getter)
    // → private 멤버 변수를 main 클래스(또는 외부 클래스)에서 읽을 수 있게 해주는 메서드
    // → return 문으로 private 변수 값을 반환한다
    // → 외부에서 값을 가져올 수 있지만, 값을 변경할 수는 없다 (읽기 전용)
    // getter 메서드는 한 번에 하나의 값만 반환할 수 있다 (return 하나만 가능)

    // 쓰기 접근자 (Setter)
    // → private 멤버 변수의 값을 외부에서 변경할 수 있게 해주는 메서드
    // → set메서드의 매개변수로 자료형과 변수명을 지정하고
    // → 외부 클래스(main 등)에서 그에 맞는 값을 전달하여 변수 값을 변경한다
    // → Scanner로 입력을 받아도 되고, 직접 값을 넣어도 된다
}
