def solution(numbers, hand):
    
    position = {
                    1: (0, 0), 2: (0, 1), 3: (0, 2),
                    4: (1, 0), 5: (1, 1), 6: (1, 2),
                    7: (2, 0), 8: (2, 1), 9: (2, 2),
                    0: (3, 1)
                }
    def distance(a, b):
        return abs(position[a][0] - position[b][0]) + abs(position[a][1] - position[b][1])
    
    answer = ''
    h = "R" if hand == "right" else "L"
    
    left = 7
    right = 9
    
    position["*"] = (3, 0)
    position["#"] = (3, 2)

    left = "*"
    right = "#"
    
    
    for i in range(len(numbers)) :
        
        if numbers[i] in [1, 4, 7] :
            answer += "L"
            left = numbers[i]
        elif numbers[i] in [3, 6, 9] :
            answer += "R"
            right = numbers[i]
        elif numbers[i] in [2, 5, 8, 0] :
            
            if distance(numbers[i], left) == distance(numbers[i], right):
                answer += h
                if h == "L":
                    left = numbers[i]
                else:
                    right = numbers[i]

            elif distance(numbers[i], left) < distance(numbers[i], right):
                answer += "L"
                left = numbers[i]

            else:
                answer += "R"
                right = numbers[i]
            
    
    return answer