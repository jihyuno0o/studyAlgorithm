T = int(input())
for t in range(1, T+1):
    n = int(input()) # 알파벳숫자쌍 개수
    doc = ""
    for i in range(n):
        alpha, num = input().split()
        doc += alpha*int(num)
    print(f'#{t}')
    n = 0
    while n < len(doc):
        print(doc[0+n:10+n])
        n += 10