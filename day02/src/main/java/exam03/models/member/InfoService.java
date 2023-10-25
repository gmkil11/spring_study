package exam03.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class InfoService {
    @Autowired
    private MemberDao memberDao;


    @Autowired
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");

    @Autowired
    public void setDateTimeFormatter(@Nullable DateTimeFormatter formatter){
        System.out.println("유입?");
        System.out.println(formatter);
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
