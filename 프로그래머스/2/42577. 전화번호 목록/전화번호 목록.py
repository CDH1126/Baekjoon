def solution(phone_book):
    # 1. 전화번호를 사전순으로 정렬
    phone_book.sort()

    # 2. 앞 번호와 바로 다음 번호만 비교
    for i in range(len(phone_book) - 1):
        # 다음 번호가 현재 번호로 시작하면
        if phone_book[i + 1].startswith(phone_book[i]):
            return False

    # 3. 끝까지 없으면 True
    return True