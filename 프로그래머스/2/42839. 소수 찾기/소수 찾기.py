def solution(numbers):
    result = set()
    used = [False] * len(numbers)

    def is_prime(num):
        if num < 2:
            return False

        for i in range(2, int(num ** 0.5) + 1):
            if num % i == 0:
                return False

        return True
    

    def dfs(current):
        if current:
            result.add(int(current))

        for i in range(len(numbers)):
            if not used[i]:
                used[i] = True
                dfs(current + numbers[i])
                used[i] = False

    dfs("")
    answer = 0

    for num in result:
        if is_prime(num):
            answer += 1

    return answer