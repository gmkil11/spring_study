package controllers.member;

import lombok.Data;

@Data
public class RequestJoin {
    private String userId;
    private String userPw;
    private String confirmUserPw;
    private String email;
    private String userNm;
    private String mobil;
    private boolean agree;
}
