from collections import deque

def solution(p):
    if not p:
        return ""

    value = 0
    num = 0

    for i in p:
        if i == "(":
            value += 1
        else:
            value -= 1

        num += 1

        if value == 0:
            u = p[:num]
            v = p[num:]
            break

    value = 0
    correct = True

    for i in u:
        if i == "(":
            value += 1
        else:
            value -= 1

        if value < 0:
            correct = False
            break

    if correct:
        return u + solution(v)

    answer = "("
    answer += solution(v)
    answer += ")"

    u = u[1:-1]

    for i in u:
        if i == "(":
            answer += ")"
        else:
            answer += "("

    return answer