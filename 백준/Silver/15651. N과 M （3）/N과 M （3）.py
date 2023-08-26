a, b = map(int, input().split())

l = []
x = 1


def example():
    global x

    if len(l) == b:
        print(' '.join(map(str, l)))
        return

    for i in range(1, a+1):
        l.append(i)
        example()
        l.pop()


example()
