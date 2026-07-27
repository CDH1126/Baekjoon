from collections import deque

def solution(prog, speeds):
    cnt = 0
    answer = []
    prog = deque(prog)
    speeds = deque(speeds)
    
    while prog :
        for i in range(len(prog)) :
            prog[i] += speeds[i]
        
        while prog and prog[0] >= 100 :
            cnt += 1
            prog.popleft()
            speeds.popleft()
            
        if cnt :
            answer.append(cnt)
            cnt = 0
        
    return answer