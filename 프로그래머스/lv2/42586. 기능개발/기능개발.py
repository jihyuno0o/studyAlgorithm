def solution(progresses, speeds):
    import math
    answer = []
    days = {}
    before = 0
    for progress, speed in zip(progresses, speeds):
        day = int(math.ceil((100-progress) / speed)) # 소수점도 하루로 침
        if before >= day: day = before # 앞의 기능이 완료되지 않으면 뒤 기능이 배포 안됨
        else: before = day
        
        if day in days:
            days[day] = days[day] + 1
        else: days[day] = 1
        
    for k,v in days.items():
        answer.append(v)
    return answer