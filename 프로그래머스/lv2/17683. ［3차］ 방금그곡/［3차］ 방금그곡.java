import java.util.*;

class Music implements Comparable<Music>{
	int time;
	int number;
	String title;
	String melody;
	
	
	public Music(int time, int number, String title, String melody) {
		this.time = time;
		this.number = number;
		this.title = title;
		this.melody = melody;
	}
    
    @Override
	public String toString() {
		return "Music [time=" + time + ", number=" + number + ", title=" + title + ", melody=" + melody + "]";
	}

	@Override
	public int compareTo(Music o) {
		if (this.time < o.time) { // 시간에 대해 내림차순
			return 1;
		}
		else if (this.time == o.time) { // 같으면
			return this.number < o.number ? -1 : 1; // 등록순서에 대해 오름차순
		}
		else {
			return -1;
		}
	}
	
}

class Solution {
    public String solution(String m, String[] musicinfos) {
    	m = m.replaceAll("A#", "H").replaceAll("C#", "I").replaceAll("D#", "J").replaceAll("F#", "K").replaceAll("G#", "L"); // # 처리
        System.out.println(m);
        StringTokenizer stk;
		List<Music> musicList = new ArrayList<>();
		for(int i=0; i<musicinfos.length; i++) {
			stk = new StringTokenizer(musicinfos[i], ",");
			int time = playTime(stk.nextToken(), stk.nextToken());
			String title = stk.nextToken();
			String melody = stk.nextToken();
			melody = melody.replaceAll("A#", "H").replaceAll("C#", "I").replaceAll("D#", "J").replaceAll("F#", "K").replaceAll("G#", "L"); // # 처리
			while(melody.length() <= time) { // 시간보다 멜로디가 짧으면 그냥 늘려줌
				melody = melody.concat(melody);
			}
			melody = melody.substring(0, time+1); // 시간만큼 잘라주고
            Music music = new Music(time, i, title, melody);
            // System.out.println(music.toString());
			if(melody.contains(m)) { // 포함하고있으면
				musicList.add(music);
			}
		}
		Collections.sort(musicList);//정렬
		
		if(musicList.size() == 0) {
			return "(None)";
		}
		
		return musicList.get(0).title;
    }
    
   public static int playTime(String start, String end) {
	   int time = 0;
	   int startH = Integer.parseInt(start.substring(0, 2)); // 시간
	   int startM = Integer.parseInt(start.substring(3)); // 분
	   int endH = Integer.parseInt(end.substring(0, 2));
	   int endM = Integer.parseInt(end.substring(3));
	   
	   time += (endH - startH) * 60; // 시간*60
	   time += (endM - startM);
	   
	   return time;
   }
}