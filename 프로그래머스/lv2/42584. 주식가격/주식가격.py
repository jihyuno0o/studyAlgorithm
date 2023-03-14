def solution(prices):
    answer = []
    L = len(prices)
    for i in range(L-1):
        time = L - i -1
        for j in range(i+1, L):
            if prices[j] < prices[i]:
                time = j - i
                break
        answer.append(time)
    answer.append(0)
    return answer