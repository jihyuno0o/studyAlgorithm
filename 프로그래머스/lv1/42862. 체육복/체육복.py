def solution(n, lost, reserve):
    _reserve = list(set(reserve)-set(lost))
    _lost = list(set(lost)-set(reserve))
    #_reserve = [r for r in reserve if r not in lost]
    #_lost = [l for l in lost if l not in reserve]
    for i in _reserve:
        if i-1 in _lost:
            _lost.remove(i-1)
        elif i+1 in _lost:
            _lost.remove(i+1)
    return n-len(_lost)