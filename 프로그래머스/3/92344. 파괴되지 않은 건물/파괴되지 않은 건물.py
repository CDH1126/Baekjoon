def solution(board, skill):
    answer = 0
    sum = [[0] * (len(board[0]) + 1) for _ in range(len(board) + 1)]
    
    for type, r1, c1, r2, c2, degree in skill :
    
        if type == 2 :
            sum[r1][c1] += degree
            sum[r1][c2 + 1] -= degree
            sum[r2 + 1][c1] -= degree
            sum[r2 + 1][c2 + 1] += degree
        else :
            sum[r1][c1] -= degree
            sum[r1][c2 + 1] += degree
            sum[r2 + 1][c1] += degree
            sum[r2 + 1][c2 + 1] -= degree
            
            
    for i in range(len(sum) - 1) :
        for j in range(len(sum[0]) - 1) :
            sum[i][j+1] += sum[i][j]
            
    for j in range(len(sum[0]) - 1) :
        for i in range(len(sum) - 1) :
            sum[i + 1][j] += sum[i][j]
            
        
    for i in range(len(board)) :
        for j in range(len(board[i])) :
            board[i][j] += sum[i][j]
            if board[i][j] > 0 :
                answer += 1
    
    return answer