package utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import world.World;

public class Utils {

	public static String loadFileAsString(String path) {
		StringBuilder builder=new StringBuilder();
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(World.class.getClassLoader().getResourceAsStream(path)));//경로에 있는 파일을 br에 저장
			String line;
			while((line=br.readLine())!=null) {//line에 br을 통해 읽은 자료를 저장
				builder.append(line+"\n");//builder에 추가
			}
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return builder.toString();//builder를 String형태로 반환
	}
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);//String을 int 형태로 변환 후 반환
		}catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
}
