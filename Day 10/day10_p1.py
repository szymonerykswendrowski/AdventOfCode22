cycles = 0
x = 1
signal_strength = 0

with open("input.txt") as f:
    for line in f:
        if line.startswith("noop"):
            cycles += 1
            if cycles in (20, 60, 100, 140, 180, 220):
                signal_strength += cycles * x

        elif line.startswith("addx"):
            cycles += 1
            if cycles in (20, 60, 100, 140, 180, 220):
                signal_strength += cycles * x

            cycles += 1
            if cycles in (20, 60, 100, 140, 180, 220):
                signal_strength += cycles * x

            n = int(line[5:]) # Input contains the values after the 4th character
            x += n

print("The total signal strength is:", signal_strength)