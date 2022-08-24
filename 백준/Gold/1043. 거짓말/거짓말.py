n, m = map(int, input().split())
cant_lie = set(input().split()[1:]) # 진실을 아는 사람

parties = []
for _ in range(m):
    parties.append(set(input().split()[1:])) # 파티 구성 저장

for _ in range(m):
    for party in parties:
        if party & cant_lie:
            cant_lie = cant_lie.union(party)
            
answer = 0
for party in parties:
    if party & cant_lie:
        continue
    answer += 1

print(answer)