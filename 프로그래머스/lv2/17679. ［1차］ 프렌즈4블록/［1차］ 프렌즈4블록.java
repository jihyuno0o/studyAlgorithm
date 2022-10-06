class Solution {
   public static int solution(int m, int n, String[] board) {
        int[][] dir = {{0, 1}, {1, 0}, {1, 1}}; // 오른쪽, 아래, 오른쪽아래대각선
        boolean[][] blank = new boolean[m][n]; // 전체상자 빈칸체크
        boolean[][] nowTime = new boolean[m][n]; // 그 한번 터질때 터질거 체크
        char[][] boardMap = new char[m][n];
        for(int i=0; i<m; i++) {
            boardMap[i] = board[i].toCharArray();
        }
        
        int answer = 0; // 초기 블럭
        boolean bomb = true;
        while(bomb) {
            bomb = false;
            for(int i=0; i<m-1; i++) {
                for(int j=0; j<n-1; j++) {
                    if(!blank[i][j]) {
                        boolean smallbox = true;
                        for(int k=0; k<3; k++) { // 2*2 같은지 확인
                            if(blank[i+dir[k][0]][j+dir[k][1]] || boardMap[i][j] != boardMap[i+dir[k][0]][j+dir[k][1]]) {
                            	smallbox = false;
                            	break;
                            }
                        }
                        
                        if(smallbox) { // 같으면
                            bomb = true;
                            nowTime[i][j] = true;
                            for(int k=0; k<3; k++) {
                                nowTime[i+dir[k][0]][j+dir[k][1]] = true;
                            }
                        }
                    }
                }
            }
            
            if(bomb) { // 2*2 같은 블록이 있었으면
                for(int i=0; i<m; i++) {
                    for(int j=0; j<n; j++) {
                        if(nowTime[i][j]) {
                            answer++;
                            nowTime[i][j] = false; // 다시 돌려주고
                            blank[i][j] = true; // 그 자리 비운다
                        }
                    }
                }
                //중력으로 내리기
                for(int i=n-1; i>=0; i--) { 
                    for(int j=m-1; j>0; j--) { //위에서 올라가는데
                        if(blank[j][i]) { // 빈칸 발견
                            for(int k=j-1; k>=0; k--) { // 다시 위로 올라가면서
                                if(!blank[k][i]) { // 빈칸 아닌거 발견하면
                                    boardMap[j][i] = boardMap[k][i]; // 빈칸 아닌거의 글자를 빈칸인 곳으로 옮기고
                                    blank[k][i] = true; // 글자를 바꿨으니까 빈칸으로 처리
                                    blank[j][i] = false; // 글자를 채웠으니까 빈칸 아님으로 처리
                                    break;
                                }
                            }
                        }
                    }
                }
             } // if(bomb) 
        }//while
        
        
        return answer;
    }
}