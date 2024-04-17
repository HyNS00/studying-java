package Yalco.sec12.chap07;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    //  💡 내 컴퓨터를 의미하는 IP주소
    //  - 일반적으로 localhost로 매핑
    public static final String SERVER_IP = "127.0.0.1";

    // 포트번호 설정
    public static final int PORT_NO = 1234;

    public static void main(String[] args) {
        try(
                //  💡 ServerSocket
                //  - 클라이언트(들)로부터 요청을 받기 위한 소켓
                //  - 연결을 받아 Socket 인스턴스 반환
                ServerSocket serverSkt = new ServerSocket(PORT_NO);
                ){
            while(true)// 서버는 항상 열려있어야한다.{
                try(
                        //  💡 Socket : 클라이언트로부터 요청이 오면 반환되는 소켓
                        Socket clientSkt = serverSkt.accept();
                        //accept() 메서드는 클라이언트로부터의 연결 요청을 기다리고, 클라이언트가 연결되면 해당 클라이언트와 통신하기 위한 소켓을 반환
                        // 클라이언트로부터 받을 스트림
                        InputStream is = clientSkt.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);
                        StringWriter sw = new StringWriter();
                        PrintWriter piw = new PrintWriter(sw);

                        //  💡 클라이언트에게 보낼 스트림
                        OutputStream os = clientSkt.getOutputStream();
                        // 두 번째 인자 : autoflush
                        //  - 값이 프린트 될 때마다 바로 스트림으로 출력할지 여부
                        PrintWriter pow = new PrintWriter(os,true);
                        ){
                    String line;
                    int lineCount = 1;
                    while((line = br.readLine()) != null){
                        piw.printf(
                                "%3d : %s%n".formatted(lineCount++, line)
                        );
                        // 클라이언트에게 되돌려줄 메세지
                        pow.printf("✅ 수신: %s... 등 %d자%n".formatted(
                                line.substring(
                                        0, Math.min(3, line.length())

                                ), line.length()
                        ));
                    }
                    System.out.println(sw);
                    System.out.println("이게뭔지 체크");
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
