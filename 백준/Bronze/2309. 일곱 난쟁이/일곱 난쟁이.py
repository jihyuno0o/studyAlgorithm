nanjangs = []
for _ in range(9):
    nanjangs.append(int(input()))
    
from itertools import combinations
for c in combinations(nanjangs, 7):
    if sum(c) == 100:
        for n in sorted(c):
            print(n)
        break