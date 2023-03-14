import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<size; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = i-stack.pop();
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            answer[stack.peek()] = size - 1 - stack.pop();
        }
        
        return answer;
    }
}