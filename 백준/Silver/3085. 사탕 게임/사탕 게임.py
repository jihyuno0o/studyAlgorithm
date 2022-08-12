def max_count(N):
    row_cnt, max_cnt = 1, 1
    # 오른쪽으로 먼저 체크
    for i in range(N):
        for j in range(N-1):
            if candys[i][j] == candys[i][j+1]:
                row_cnt += 1
            else:
                row_cnt = 1
            max_cnt = max(row_cnt, max_cnt)
            if max_cnt == N:
                return N
        row_cnt = 1
    
    col_cnt = 1
    # 아래로
    for j in range(N):
        for i in range(N-1):
            if candys[i][j] == candys[i+1][j]:
                col_cnt += 1
            else:
                col_cnt = 1
            max_cnt = max(col_cnt, max_cnt)
            if max_cnt == N:
                return N
        col_cnt = 1
    return max_cnt

def solution(N, candys):
    answer = 0
    pos = [[-1,0],[1,0],[0,-1],[0,1]]
    for i in range(N):
        for j in range(N):
            # 상하좌우 바꿔보기
            for k in range(4):
                nx, ny = i + pos[k][0], j + pos[k][1]

                if nx<0 or nx>=N or ny<0 or ny>=N:
                    continue
                if candys[i][j] != candys[nx][ny]:
                    candys[nx][ny], candys[i][j] = candys[i][j], candys[nx][ny]
                    answer = max(answer, max_count(N))
                    if answer == N:
                        return N
                    # 제자리로 돌려놓기
                    candys[i][j], candys[nx][ny] = candys[nx][ny], candys[i][j]
    return answer

N = int(input())
candys = [list(input()) for _ in range(N)]

print(solution(N, candys))