def solution(sequence, k):
    answer = [0, 0]
    total, right = 0, 0
    n = len(sequence)
    length = n
    
    for left in range(n) :
        while total < k and right < n :
            total += sequence[right]
            right += 1
            
        if total == k and (right - 1 - left < length) :
            answer[0], answer[-1] = left, right - 1
            length = right - 1 - left
        total -= sequence[left]
    
    return answer