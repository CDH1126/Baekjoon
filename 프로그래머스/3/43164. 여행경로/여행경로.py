def solution(tickets):
    tickets.sort()  # 알파벳 순으로 먼저 정렬

    used = [False] * len(tickets)  # 각 티켓을 사용했는지 표시
    path = ["ICN"]                 # 여행 경로

    def dfs(now):
        # 모든 티켓을 사용했다면 완성
        if len(path) == len(tickets) + 1:
            return True

        # 모든 티켓을 하나씩 확인
        for i in range(len(tickets)):
            start, end = tickets[i]

            # 지금 공항에서 출발하는 티켓이고,
            # 아직 사용하지 않은 티켓이라면
            if start == now and not used[i]:

                # 티켓 사용
                used[i] = True
                path.append(end)

                # 다음 공항으로 이동
                if dfs(end):
                    return True

                # 여기까지 왔는데 실패했다면 되돌아가기
                used[i] = False
                path.pop()

        return False

    dfs("ICN")
    return path