def solution(people, limit):
    answer = 0
    
    left = 0
    right = len(people) - 1
    
    # 구명보트 최대 2명, 무게 제한 (입력값)
    
    people.sort()
    
    while left <= right :
        if people[left] + people[right] <= limit :
            answer += 1
            left += 1
            right -= 1
        else :
            answer += 1
            right -= 1
            
        
    return answer