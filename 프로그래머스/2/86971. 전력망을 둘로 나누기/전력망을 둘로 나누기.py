def solution(n, wires): # 송전탑 개수, 전선 정보
    
    answer = n
    
    for left, right in wires :
        graph = [ [] for _ in range(n+1) ]
        
        for a, b in wires :
            if a == left and b == right :
                continue
            
            graph[a].append(b)
            graph[b].append(a)
            
        visited = [False] * (n + 1)

        def dfs(node) :
            visited[node] = True
            count = 1

            for next_node in graph[node] :
                if not visited[next_node] :
                    count += dfs(next_node)

            return count

        left_count = dfs(1)
        right_count = n - left_count

        diffrence = abs(left_count - right_count)
        answer = min(answer, diffrence)

    return answer

    