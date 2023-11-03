package commons;

public interface MobileValidator {
    default boolean checkMobile(String num){
        /*
        * 010 0000 0000
        * 011 000 0000
        * 016 000 0000
        *
        * 01000000000/ 010 0000 0000 010-0000-0000, 010.0000.0000*/
        String mobile = num.replaceAll("\\D", ""); // 대문자들을 공백으로 제거한다. -> \\d같은 경우는 숫자를 대체시킨다는 의미
        String pattern = "^01[016]\\d{3,4}\\d{4}$"; // 휴대폰 번호 패턴


        return mobile.matches(pattern);
    }
}
