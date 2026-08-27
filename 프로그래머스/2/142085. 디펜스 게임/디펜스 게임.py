import heapq

def solution(n, k, enemy):
    answer = 0
    heap = []
    
    is_ok = False
    
    for e in enemy :
        n -= e
        heapq.heappush(heap, -e) # 음수 저장하고, 꺼낼 때 가장 작은 값을 양수로 전환     
        
        if n < 0 :
            if k >= 1 :
                k -= 1
                n += -heapq.heappop(heap)
            else :
                return answer
        
        answer += 1
    
    return answer