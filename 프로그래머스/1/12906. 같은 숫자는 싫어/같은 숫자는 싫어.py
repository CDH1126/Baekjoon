def solution(arr):
    answer = []
    
    # 연속적으로 나타나는 수자 하나만 남기고 전부 제거
    
    answer.append(arr[0])

    for i in range(len(arr)) :
        
        if (answer[-1] != arr[i]) :
            answer.append(arr[i])
        
    
    return answer