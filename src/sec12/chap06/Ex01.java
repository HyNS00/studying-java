package sec12.chap06;

import java.net.MalformedURLException;
import java.net.URL;

public class Ex01 {
    // java.net 패키지
    // URL클래스 -> 인터넷상 자원을 나타내는 클래스
    // URLConnection -> URL에 연결하여 데이터를 읽고 쓸 수 있도록 함
    public static void main(String[] args) throws MalformedURLException {
        URL url1 = new URL("https://showcases.yalco.kr/java/index.html");

        URL url2 = new URL("https://showcases.yalco.kr");
        URL url3 = new URL(url2, "/java/index.html");

        String url1Str = url1.toExternalForm();
        String url3Str = url3.toExternalForm();
        boolean sameUrl = url1.equals(url3);

        // URL의 인스턴스 메소드
        String content = url1.toExternalForm();
        String file = url1.getFile();
        String path = url1.getPath();
        String host = url1.getHost();
        long port = url1.getPort();
        long defPort = url1.getDefaultPort();
    }
}
