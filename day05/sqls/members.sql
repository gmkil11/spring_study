CREATE TABLE MEMBER (
                        USER_NO NUMBER(10) PRIMARY KEY,
                        USER_ID VARCHAR2(40) NOT NULL UNIQUE,
                        USER_PW VARCHAR2(65) NOT NULL,
                        USER_NM VARCHAR2(40) NOT NULL,
                        EMAIL VARCHAR2(100) NOT NULL,
                        MOBILE VARCHAR2(11),
                        REG_DT DATE DEFAULT SYSDATE,
                        MOD_DT DATE
);

CREATE SEQUENCE SEQ_MEMBER;