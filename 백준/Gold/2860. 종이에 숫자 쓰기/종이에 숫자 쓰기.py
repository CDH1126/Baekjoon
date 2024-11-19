import sys
input = sys.stdin.readline

def gcd(a, b): #유클리드 호제법
    if a < b:
        a, b = b, a
    r = a % b
    if not r:
        return b
    return gcd(b, r)

n = int(''.join(input().split('.'))) #입력받은 수 소숫점 제거한 정수로 저장. ex) 1.56 >> 156
m = 10 ** (len(str(n)) - 1) #n과 같은 자릿수의 10의 거듭제곱 수 저장. ex) n = 156이라면, m = 100
r = gcd(n, m) #n과 m의 최대공약수
n //= r #약분
m //= r # "
ans = [0 for _ in range(5)] #1 ~ 5의 사용 수를 저장 할 list
five = (n - m) // 4 #넣을 수 있는 만큼 5로 채우기. 
#3.20이라면, n = 16, m = 5. 5를 하나씩 쓸 때마다 m은 1씩, n은 5씩 감소하고, n이 m보다 작아지면 안 되므로, 5는 최대 (n - m) // 4개 사용할 수 있다.
ans[4] += five #5 사용 횟수 저장
n -= five * 5 #n과 m에서 5의 합계, 5 사용 횟수 감소
m -= five
if n != m: #n과 m이 다르다면
    ans[n - m] += 1 #차이나는 만큼의 수를 하나 사용하고
    ans[0] += m - 1 #나머지는 1로 채운다.
    #ex) n = 102, m = 100이면 1을 99번, 3을 1번 사용.
else: #n과 m이 같다면
    ans[0] += m #모두 1로 채운다
print(*ans)