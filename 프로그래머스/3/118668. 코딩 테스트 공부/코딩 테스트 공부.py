def solution(alp, cop, problems):
    
    # alp(알고력) 와 cop(코딩력) 의 최대값을 구함
    max_alp = max(x[0] for x in problems)
    max_cop = max(x[1] for x in problems)
    
    alp = min(alp, max_alp)
    cop = min(cop, max_cop)
    
    INF = float('inf')
    
    dp = [
        [INF] * (max_cop + 1)
        for _ in range(max_alp + 1)
    ]
    
    dp[alp][cop] = 0
    
    for a in range(alp, max_alp + 1) :
        for c in range(cop, max_cop + 1) :
            
            if dp[a][c] == INF :
                continue
            
            # 알고력
            if a < max_alp :    
                dp[a+1][c] = min(
                                dp[a + 1][c],
                                dp[a][c] + 1
                                )
            # 코딩력
            if c < max_cop :
                dp[a][c + 1] = min(
                                    dp[a][c + 1],
                                    dp[a][c] + 1
                                  )
            
            # 문제 풀기
# problems -   알고력,   코딩력,    알고력 증가값, 코딩력 증가값, 푸는데 드는 시간
            for alp_req, cop_req, alp_rwd, cop_rwd, cost in problems :
                if a >= alp_req and c >= cop_req :
                    next_a = min(max_alp, a + alp_rwd)
                    next_c = min(max_cop, c + cop_rwd)
                    
                    dp[next_a][next_c] = min(
                                             dp[next_a][next_c],
                                             dp[a][c] + cost
                                            )
    return dp[max_alp][max_cop]
            
    