package controllers;

import lombok.Data;

@Data
public class RequestLogin {
    private String userId;
    private String userPw;
    private boolean saveId;
}
