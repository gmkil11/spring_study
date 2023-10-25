package exam04.models.member;

import exam02.commons.Validator;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // lombok의 생성자 에노테이션을 만들고 멤버 변수에 final을 붙일시 자동으로 의존성이 추가된다.
public class JoinService {


    private final Validator<Member> validator;


    private final MemberDao memberDao;





    public void join(Member member) {
        validator.check(member);

        memberDao.register(member);

    }


}