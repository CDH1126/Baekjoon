def solution(tickets):
    
    tickets.sort()
    
    use = [False] * len(tickets)
    path = ["ICN"]
    
    def dfs(now) :
        # 모든 티켓을 사용했을 경우 종료
        if len(path) == len(tickets) + 1 :
            return True
    
        # 모든 티켓 확인
        for i in range(len(tickets)) :
            start, end = tickets[i]

            if start == now and not use[i] :

                use[i] = True
                path.append(end)

                if dfs(end) :
                    return True

                use[i] = False
                path.pop()

        return False
    
    dfs("ICN")
    return path