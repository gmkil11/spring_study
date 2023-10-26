package exam05;

public class Message2 {
    public void send(String message){
        System.out.println("["+ message + "]를 전달했습니다.");
    }

    public void init(){
        System.out.println("init!!!");
    }

    public void close(){
        System.out.println("close!!!");
    }
}
