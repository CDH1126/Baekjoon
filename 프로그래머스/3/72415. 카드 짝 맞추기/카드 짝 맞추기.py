from collections import deque


def solution(board, r, c):
    positions = [[] for _ in range(7)]

    for i in range(4):
        for j in range(4):
            if board[i][j]:
                positions[board[i][j]].append((i, j))

    cards = []
    for num in range(1, 7):
        if positions[num]:
            cards.append(num)

    card_count = len(cards)
    answer = 999999

    def move(r, c, dr, dc, ctrl):
        nr, nc = r, c

        if not ctrl:
            nr += dr
            nc += dc

            if 0 <= nr < 4 and 0 <= nc < 4:
                return nr, nc

            return r, c

        while True:
            nr += dr
            nc += dc

            if not (0 <= nr < 4 and 0 <= nc < 4):
                return nr - dr, nc - dc

            if board[nr][nc] != 0:
                return nr, nc

    def distance(start, target):
        sr, sc = start
        tr, tc = target

        queue = deque([(sr, sc, 0)])
        visited = [[False] * 4 for _ in range(4)]
        visited[sr][sc] = True

        while queue:
            r, c, dist = queue.popleft()

            if (r, c) == (tr, tc):
                return dist

            for dr, dc in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                nr, nc = move(r, c, dr, dc, False)

                if not visited[nr][nc]:
                    visited[nr][nc] = True
                    queue.append((nr, nc, dist + 1))

                nr, nc = move(r, c, dr, dc, True)

                if not visited[nr][nc]:
                    visited[nr][nc] = True
                    queue.append((nr, nc, dist + 1))

        return 0

    def dfs(r, c, removed, cost):
        nonlocal answer

        if cost >= answer:
            return

        if len(removed) == card_count:
            answer = min(answer, cost)
            return

        for card in cards:
            if card in removed:
                continue

            a, b = positions[card]

            d1 = distance((r, c), a)
            d2 = distance(a, b)

            board[a[0]][a[1]] = 0
            board[b[0]][b[1]] = 0

            dfs(
                b[0],
                b[1],
                removed | {card},
                cost + d1 + d2 + 2
            )

            board[a[0]][a[1]] = card
            board[b[0]][b[1]] = card

            d1 = distance((r, c), b)
            d2 = distance(b, a)

            board[a[0]][a[1]] = 0
            board[b[0]][b[1]] = 0

            dfs(
                a[0],
                a[1],
                removed | {card},
                cost + d1 + d2 + 2
            )

            board[a[0]][a[1]] = card
            board[b[0]][b[1]] = card

    dfs(r, c, set(), 0)

    return answer