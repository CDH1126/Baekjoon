def solution(my_string):
    answer = ''
    
    for i in range(len(my_string)) : 
        if my_string[i] in "aeiou" :
            continue
        answer += my_string[i]
    
    return answer