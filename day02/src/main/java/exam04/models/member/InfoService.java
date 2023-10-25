package exam04.models.member;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // lombok 의 생성자 애너테이션을 사용하고,멤버 변수에 @NonNull 애너테이션을 사용하면 @AutoWired 를 사용하지 않아도 된다.
public class InfoService {

    @NonNull
    private MemberDao memberDao;



    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");

    @Autowired
    public void setDateTimeFormatter(@Nullable DateTimeFormatter formatter){

        this.formatter = formatter;
    }

    public void print() {
        List<Member> members = memberDao.gets();
        members.stream().map(this::toConvert).forEach(System.out::println);

    }

    private Member toConvert (Member member){
        if(formatter == null) {
            return member;
        }

        String regDtStr = formatter.format(member.getRegDt());
        member.setRegDtStr(regDtStr);

        return  member;
    }


}
