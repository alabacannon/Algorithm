'''
4 5 1
1 2
1 3
1 4
2 4
3 4
'''

import sys
from collections import deque

'''
주의사항
두 정점 사이에 간선이 여러개일 수 있음
'''

input = sys.stdin.readline

n, m, v = map(int, input().split())
graph = [[] for _ in range(n+1)]
for i in range(m):
    a, b = map(int, input().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(len(graph)):
    graph[i].sort()


def dfs(v, graph, visited):
    visited[v] = True
    print(v, end=' ')
    for i in graph[v]:
        if not visited[i]:
            dfs(i, graph, visited)


def bfs(v, graph, visited):
    queue = deque([v])
    visited[v] = True
    while queue:
        v = queue.popleft()
        print(v, end=" ")
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


visited = [False] * (n+1)
dfs(v, graph, visited)
print("\n",end='')
visited = [False] * (n+1)
bfs(v, graph, visited)



