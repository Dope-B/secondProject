package basic_one;



public class basic {
	public static void main(String[] args) {	
		
		int num3=0B0011;
		System.out.println(num3);
		Game game=new Game("-대영찡의 모험2-", 851, 500);// 프레인 틀 생성, 크기 851*500
		game.start();//게임(스레드) 시작
	}
}
