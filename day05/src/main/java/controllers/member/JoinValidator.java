package controllers.member;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class JoinValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestJoin.class); // 검증하고자하는 클래스 넣어서 한정하기
    }

    @Override
    public void validate(Object target, Errors errors) { // 커맨드 객체로 검사하면 된다.


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPw", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmUserPw", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userNm", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");



        /*RequestJoin form = (RequestJoin) target; // 오브젝트형인 타켓을 형변환을 통해 사용
        // 필수항목 검증(userId, userPw, confirmUserPw, userNm, email)
        String userId = form.getUserId();
        String userPw = form.getUserPw();
        String confirmUserPw = form.getConfirmUserPw();
        String userNm = form.getUserNm();
        String email = form.getEmail();
        boolean agree = form.isAgree();

        if (userId == null || userId.isBlank()){
            errors.rejectValue("userId", "Required", "아이디를 입력해주세요");
            // field란 userId, userNm 과 같은 것들
        }

        if (userPw == null || userPw.isBlank()){
            errors.rejectValue("userPw", "Required", "비밀번호를 입력해주세요");
        }

        if (confirmUserPw == null || confirmUserPw.isBlank()){
            errors.rejectValue("confirmUserPw", "Required", "비밀번호 확인을 입력해주세요");
        }

        if (userNm == null || userNm.isBlank()){
            errors.rejectValue("userNm", "Required", "회원명을 입력해주세요");
        }

        if (email == null || email.isBlank()){
            errors.rejectValue("email", "Required", "이메일을 입력해주세요" );
        }

        if (agree == false){
            errors.rejectValue("agree", "Required", "약관동의에 체크하세요");
        }*/
    }
}
