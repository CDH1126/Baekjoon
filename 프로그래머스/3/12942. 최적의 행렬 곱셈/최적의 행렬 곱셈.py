def solution(matrix_sizes):
    length = len(matrix_sizes)
    
    dp = [[0] * length for _ in range(length)]
    
    for n in range(2, length + 1) :
        for i in range(length - n + 1) :
            j = i + n - 1
            
            dp[i][j] = float('inf')
            
            # k를 기준으로 분할
            for k in range(i, j) :
                cost = (
                        dp[i][k]
                        + dp[k + 1][j]
                        + (matrix_sizes[i][0]
                            * matrix_sizes[k][1]
                            * matrix_sizes[j][1]
                          )
                        )
                    
                dp[i][j] = min(dp[i][j], cost)
                    
    return dp[0][length - 1]

