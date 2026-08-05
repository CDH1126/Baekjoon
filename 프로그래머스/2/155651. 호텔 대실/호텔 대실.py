def solution(book_time) :
    start = []
    end = []

    for start_time, end_time in book_time :
        start_h, start_m = map(int, start_time.split(':'))
        end_h, end_m = map(int, end_time.split(':'))

        start.append(start_h * 60 + start_m)
        end.append(end_h * 60 + end_m + 10)

    start.sort()
    end.sort()

    start_id = 0
    end_id = 0

    room = 0
    answer = 0
    n = len(book_time)

    while start_id < n :
        if start[start_id] < end[end_id] :
            room += 1
            answer = max(answer, room)
            start_id += 1
            
        else :
            room -= 1
            end_id += 1

    return answer