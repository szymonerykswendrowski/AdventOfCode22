cycles = 0
x = 1
CRT = 0

with open("input.txt") as f:
    for line in f:
        if line.startswith("noop"):
            cycles += 1

            # Ends the current row and begins new one
            if cycles in (41, 81, 121, 161, 201):
                print(" ")
                CRT = 0

            if CRT in (x-1, x, x+1):
                print("#", end="")
                CRT += 1
            else:
                print(".", end="")
                CRT += 1

        elif line.startswith("addx"):
            cycles += 1

            if cycles in (41, 81, 121, 161, 201):
                print(" ")
                CRT = 0

            if CRT in (x-1, x, x+1):
                print("#", end="")
                CRT += 1
            else:
                print(".", end="")
                CRT += 1

            cycles += 1

            if cycles in (41, 81, 121, 161, 201):
                print(" ")
                CRT = 0

            if CRT in (x-1, x, x+1):
                print("#", end="")
                CRT += 1
            else:
                print(".", end="")
                CRT += 1

            n = int(line[5:])
            x += n
