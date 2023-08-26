a, b = map(int, input().split())

l = []
x = 1


def example():
    global x

    if len(l) == b:
        print(' '.join(map(str, l)))
        return

    for i in range(1, a+1):
        if i in l:
            continue
        if i < x:
            continue
        l.append(i)
        x = i
        example()
        x = 1
        l.pop()


example()
