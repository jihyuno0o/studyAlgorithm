def dfs(nodes, comp, visited, now):
    visited[now] = 1
    for i in range(comp+1):
        if nodes[now][i] == 1 and visited[i] == 0:
            dfs(nodes, comp, visited, i)

comp = int(input())
node_n = int(input())
nodes = [[0] * (comp+1) for _ in range(comp+1)]
for _ in range(node_n):
    i, j = map(int, input().split())
    nodes[i][j] = nodes[j][i] = 1
    
visited = [0] * (comp+1)
visited[0] = 1

dfs(nodes, comp, visited, 1)

print(visited.count(1) - 2)