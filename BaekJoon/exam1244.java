import java.util.Scanner;

public class exam1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] lights = new int[n];
		for (int i = 0; i < n; i++) {
			lights[i] = sc.nextInt();
		}

		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int s = sc.nextInt();
			int num = sc.nextInt();
			if(s==1)
				lights = boy(lights, num);
			else
				lights = girl(lights, num);
		}
		
		for(int i=1; i<=lights.length; i++) {
			System.out.print(lights[i-1]+" ");
			if(i%20 == 0) {
				System.out.println();
			}
		}

	}

	public static int turn_light(int light) {
		if (light == 0)
			light = 1;
		else
			light = 0;
		return light;
	}
	
	public static int[] boy(int[] lights, int num) {
		for(int i=1; i<lights.length/num+1; i++) {
			lights[i*num-1] = turn_light(lights[i*num-1]);
		}
		return lights;
	}
	
	public static int[] girl(int[] lights, int num) {
		num -= 1;
		lights[num] = turn_light(lights[num]);
		int i = 1;
		while(true) {
			if(num-i >= 0 && num+i<=lights.length-1) {
				if(lights[num-i] == lights[num+i]) {
					lights[num-i] = turn_light(lights[num-i]);
					lights[num+i] = turn_light(lights[num+i]);
					i++;
				} else {
					return lights;
				}
			} else {
				return lights;
			}
		}
	}
}
