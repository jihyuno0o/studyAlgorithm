
class Solution {
    static int result;
    static boolean[] binary;
	static int treeLen;
    
    public int[] solution(long[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            String b = Long.toBinaryString(numbers[i]);

            int length = b.length();
            int exp = 1;
            do {
                treeLen = (int) Math.pow(2, exp++) - 1;
            } while (treeLen < length);

            binary = new boolean[treeLen];
            int idx = treeLen - length;
            for(int j=0; j<length; j++) {
                binary[idx++] = b.charAt(j) == '1';
            }

            result = 1;
            possible(0, treeLen-1); // s, e
            answer[i] = result;
        }
        return answer;

    }

    public static void possible(int s, int e) {
        int mid = (s+e)/2;
        if(!binary[mid]) { //루트가 0이면 자식노드들에서 1이나오면 안됨
            if(!checkChild(s, e)) {
                result = 0;
                return;
            }
        }

        // 내가 마지막 노드가 아니면 재귀
        if(s!=e) {
            possible(s, mid-1); // 왼쪽
            possible(mid+1, e); // 오른쪽
        }

    }

    public static boolean checkChild(int s, int e) {
        for (int i=s; i<=e; i++) {
            if(binary[i]) return false;
        }
        return true;
    }
}

