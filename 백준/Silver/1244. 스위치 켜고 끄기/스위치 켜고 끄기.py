def turn_light(light): #켜고 끄기
    if light == 0:
        light = 1
    else:
        light = 0
    return light

def boy(switch, num): # num의 배수 켜고 끄기
    for i in range(1, len(switch)//num+1):
        switch[i*num-1] = turn_light(switch[i*num-1])
    return switch

def girl(switch, num): #num을 중심으로 대칭되면 켜고 끄기
    num -= 1
    switch[num] = turn_light(switch[num])
    i = 1
    while True:
        if num-i >=0 and num+i <= len(switch)-1:
            if switch[num+i] == switch[num-i]:
                switch[num+i], switch[num-i] = turn_light(switch[num+i]), turn_light(switch[num-i])
                i += 1
            else:
                return switch
        else:
            return switch


n = int(input())
switch = list(map(int, input().split()))

student_n = int(input())
for i in range(student_n):
    s, num = map(int, input().split())
    if s == 1:
        boy(switch, num)
    else:
        girl(switch, num)

for i in range(0, n, 20):
    print(*switch[i:i+20])