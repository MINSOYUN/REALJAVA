package chap2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class A_BufferedStream {
	/*
	 * 보조 스트림
	 * - 기반 스트림(Input/OutputStream, Reader/Writer)과 연결되 
	 *   여러가지 편리한 기능을 제공해주는 스트림을 말한다
	 * - 단독으로 외부매체(파일, 네트워크, 키보드, 모니터 등)와
	 *   데이터를 직접 주고받을 수 없다
	 * - 기반 스트림을 먼저 생성하고 보조 스트림을 연결해 주어야 한다
	 * 
	 * 성능 향상 보조 스트림
	 * - 기반 스트림의 속도를 향상시켜주는 기능을 한다
	 * - 기반 스트름에 대한 레퍼런스가 필요하다
	 * - 버퍼라는 공간을 사용해서 속도 향상에 도움을 준다
	 * - 기반 스트림에서 제공하지 않는
	 *   메소드( newLine(), readLine() ) 등을 제공해 준다
	 */
	
	public static void main(String[] args) {
		A_BufferedStream BufferedStreamEx = new A_BufferedStream();
		BufferedStreamEx.fileSaver();
		BufferedStreamEx.fileRead();
		
	}
	
	public void fileRead() {
		// 보조스트림은 단독으로 사용 불가
		// 기반 스트림을 생성자의 매개변수로 넣어주어야 합니다
		try (BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"));){
			String str = "";
			while(true) {
				// 기반 스트림에서 제공하지 않는 메서드
				// 파일에서 한줄을 읽어올 때 사용한다
				// reader은 readLine
				if((str = br.readLine()) != null) {
					System.out.println(str);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void fileSaver() {
		// true: 이어서 작성
		// false: 덮어쓰기 <- 기본값
		try (FileWriter fw = new FileWriter("c_buffer.txt", true);
				// 매개변수로 기반 스트림(fw)을 넣어줍니다
				BufferedWriter bw = new BufferedWriter(fw)){
			// 매개변수에 바로 생성
			// BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt")) 와 같다
			
			bw.write("안녕하세용~!배가 고파용");
			// writer는 newLine
			bw.newLine();
			bw.write("오늘 점심은 순찌!");
			
			bw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // 메서드 끝
}
