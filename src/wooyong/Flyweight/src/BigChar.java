import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {
    //문자의 이름
    private char charname;
    //큰 문자를 표현하는 문자열('#' ',' '\n' 으로 이루어진 열)
    private String fontdata;

    //생성자
    public BigChar(char charname) {
        this.charname = charname;
        try {
            String filename = "big" + charname + ".txt";
            StringBuilder sb = new StringBuilder();
            for (String line: Files.readAllLines(Path.of(filename))) {
                sb.append(line);
                sb.append('\n');
            }
            this.fontdata = sb.toString();
        } catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }
    //큰 문자를 표시한다
    public void print() {
        System.out.print(fontdata);
    }
}
//	실제로 글자 하나에 대한 큰 글자 표현(.txt에서 읽어옴).
//  파일 예: "big1.txt", "big0.txt"에 있는 아스키 그림을 읽어서 저장.
//  print() 호출 시 아스키 아트 형태로 출력됨.