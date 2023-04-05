# Java로 구현한 미니게임
#### 제작기간: 2018.03.27~2018.06.10
#### 사용 기술: Canvas

<p align="center">
<img width="25%" src="https://user-images.githubusercontent.com/33209821/229503957-5c72176e-d983-463d-96b4-1d572de28855.png"/>
<img width="30%" src="https://user-images.githubusercontent.com/33209821/229503948-1c62847a-7eaf-4242-b1cd-141ff52ba87b.png"/>
	<br/>
<img width="30%" src="https://user-images.githubusercontent.com/33209821/229503959-b2883897-362d-4311-8267-dfed4bc4e86c.png"/>
<img width="30%" src="https://user-images.githubusercontent.com/33209821/229503962-3e76d66a-4f9b-4804-9ba3-4daf4687e74c.png"/>
<img width="30%" src="https://user-images.githubusercontent.com/33209821/229503964-129547d2-9ff8-4d7d-b1f0-25346ba0b711.png"/>
</p>
<br/>

#### 설명
 - 메인함수는 basic에 위치
 ```C++
 public static void main(String[] args) {	
    Game game=new Game("-대영찡의 모험2-", 851, 500);// 프레임 틀 생성, 크기 851*500
    game.start();//게임(스레드) 시작
 }
``` 
- 게임 시작 시 스레드 생성
- 이미지 출력 시 삼중 버퍼를 생성하고 60fps로 실행한다. tick()은 연산, render는 이미지 출력을 담당한다.
- 모든 객체의 tick과 render State에서 관리된다.
- 캐릭터 선택창에서 된 캐릭터만 애니메이션이 출력된다.(State 폴더 내 MenuState에 구현)

```C++

window.getCanvas().createBufferStrategy(3);// 삼중 버퍼 생성(render 함수)
.
.
.
now=System.nanoTime();//현 시간 저장
delta+=(now-lastTime)/timePerTick;//소요시간 갱신
lastTime=now;// 시간 갱신
if(delta>=1) {// 틱당 소요시간이 1이 넘으면(경과시간이 틱당 소요시간과 일치 따라서 실행 가능) tick과 render 실행 후  delta 1감소
	tick(); // 연산
	render();// 이미지 출력
	delta--;
}
```

- 플레이어는 Entity를 상속받는다.
- 애니메이션 및 플레이어 리소스 정리는 gfx폴더에 정리 되어있다. 이미지 반전 함수는 utils 폴더에 있다.

```C++
public Animation(int speed, BufferedImage[] frames) {
		this.speed=speed;
		this.frames=frames;// 이미지 배열을 입력으로 받고 tick 함수로 일정 시간마다 이미지배열의 인덱스를 바꿈으로 애니메이션 구
		index=0;
		timer=0;
		lastTime=System.currentTimeMillis();
	}
  
  public void tick() {
		timer+=System.currentTimeMillis()-lastTime;
		lastTime=System.currentTimeMillis();
		if(timer>speed) {index++;timer=0;}//timer가 speed보다 높다면 인덱스번호 증가
		if(index>=frames.length) {index=0;}//프레임이 한바퀴를 돈다면 인덱스 번호를 0으로 저장
		}

```
- 타일 출력은 플레이어의 위치와 화면 크기에 맞게 최적으로 출력된다. 이는 world 폴더에 정리되어있다.
- 각 맵은 txt파일로 저장되어 있고 world파일에 구현되어있다. txt파일은 res폴더에 있다. (1-> )

```C++

	private void loadWorld(String path) {
		String file=Utils.loadFileAsString(path);// file 저장
		String[] tokens=file.split("\\s+");// 토큰으로 나눔
		width=Utils.parseInt(tokens[0]);//1번째 토큰은 가로
		height=Utils.parseInt(tokens[1]);//2번째 토큰은 세로
		spawnX=Utils.parseInt(tokens[2]);
		spawnY=Utils.parseInt(tokens[3]);
		tiles=new int[width][height];//가로, 세로에 따라 타일 배열 생성
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				tiles[x][y]=Utils.parseInt(tokens[(x+y*width)+4]);// 토큰 배열과 타일 id에 따라 타일 저장
			}
		}
	}

// 맵.txt 예시
// 10 10 -> 가로 세로 타일 갯수
// 300 200 -> 사용x
// 111 -> 1:이동 불가능 벽/ 0: 이동 가능 땅
// 101
// 111
```

- 몬스터 ai는 Ene_Creature를 상속받는다. 또한 Ene_Creature는 Entity를 상속 받는다.
- 몬스터 이동 시 벽과 만난다면 이동을 제한한다.

```C++
int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH; // 몇번째 타일에 위치했는지 판별
if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)// 해당 타일이 벽인지 판별
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;// 벽이 아니라면 움직
}
else {
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;// 벽이라면 위치를 고정
}

```
- 플레이어는 Creature를 상속받는다. 또한 Creature는 Entity를 상속 받는다.
- 플레이어는 현재 출력 애니메이션에 따라 상태가 제한된다.
- 플레이어 점프는 다음과 같이 구현하였다.

```C++
public void jump() {
		if(isJump) {//점프 함수
			r_Y=y+(height/2);//실제 y값
			deltaJ= -Math.pow(powerJ-7,2)+60;//이차함수 사용
			v_Y=r_Y+deltaJ;//출력용 y값
			powerJ+=0.32;//deltaJ의 독립변수
			if(v_Y<=r_Y) {r_Y=y;powerJ=0;deltaJ=0;isJump=false;}//땅에 닿을 시	
		}
	}

```
- 특정 캐릭터는 점프 시 공격이 가능하다.(각 캐릭터는 Creature폴더에 정리)
- 공격 시 특정 인덱스 번호에 따라 히트박스가 갱신되거나 소리가 출력된다.
- 몬스터와 플레이어는 피격 시 이팩트가 출력된다. 이는 Entity에 구현되어있고 tick과 render함수가 독립적으로 실행된다.
- 몬스터는 각각 탐지 범위를 사각형으로 가지고 플레이어가 탐지범위 안으로 들어올 시 플레이어 기준 특정 위치로 이동한다. 만약 몬스터가 플레이어 위치로 이동한다면 몬스터의 공격모션에 따라 어색한 연출이 됨(ex) 공격범위는 넓은데 굳이 가까이서 때리는 몬스터) 

```C++
protected int attackTerm=0;// 플레이어에서부터 떨어져있는 몬스터 움직임 기준점
```

- 플레이어가 탐지범위 밖에 있을 시 일정 시간마다 랜덤으로 이동 방향을 부여 받는다.
- 맵 이동과 맵을 구성하는 몬스터나 나무 등 리소스는  world폴더 내 World_check에 구현되어있다.
- 맵에 존재하는 몬스터나 리소스는 Entity manager에서 관리한다.(Entities 폴더 내)
- y축 좌표에 따른 출력 순서 조정은 다음과 같이 이루어진다.(EntityManager에 정리)

```C++

private Comparator<Entity> renderSorter=new Comparator<Entity>() {
		public int compare(Entity a, Entity b) {
			if(a.getY()+a.getHeight()<b.getY()+b.getHeight()) {return -1;}
			return 1;}};// compare 정의
.
.
.
objects.sort(renderSorter); //정렬
```
#### 피드백
- 최적화가 전혀 안 되어 있어 cpu 점유율이 비정상적으로 높게 나온다. 
- 코드 재사용률이 아직 낮다.
- 원인 모를 이유로 게임이 멈추는 경우가 발생한다.

#### 리소스 출처
https://www.spriters-resource.com/mobile/finalfantasybraveexvius/

#### 참고 영상

[![Video Label](http://img.youtube.com/vi/dEKs-3GhVKQ/0.jpg)](https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1&ab_channel=CodeNMore)
