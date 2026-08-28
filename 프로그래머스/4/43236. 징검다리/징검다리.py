def solution(distance, rocks, n):
    rocks.sort()
    rocks.append(distance)

    left, right = 1, distance

    while left <= right:
        mid = (left + right) // 2

        removed = 0
        prev = 0

        for rock in rocks:
            # 이전 돌과의 거리가 mid보다 작으면 제거
            if rock - prev < mid:
                removed += 1
            else:
                prev = rock

        # n개 이하로 제거 가능 → 최소 거리 mid 가능
        if removed <= n:
            answer = mid
            left = mid + 1
        else:
            right = mid - 1

    return answer