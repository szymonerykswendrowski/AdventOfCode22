N = 9
diagram_end = 8

with open("input.txt") as file:
    parts = file.read()[:-1].split("\n\n")  # Split input into 2 parts, the diagram and the steps
    diagram = parts[0].split("\n")
    steps = parts[1].split("\n")
    stacks = [[] for _ in range(N)]

    for i in range(diagram_end):
        line = diagram[i]
        crates = line[1::4]  # Values in crates are separated by 4 characters
        for j in range(len(crates)):
            if crates[j] != " ":
                stacks[j].append(crates[j])

# Reverse the stacks
stacks = [stack[::-1] for stack in stacks]
print(stacks)

# Move crates around
for line in steps:
    print(line)
    inputs = line.split(" ")
    distance, source, destination = map(int, [inputs[1], inputs[3], inputs[5]])
    # Need to subtract 1 from these as in input the index starts at 1
    source -= 1
    destination -= 1

    stacks[destination].extend(stacks[source][-distance:])  # Move stacks together into new destination
    stacks[source] = stacks[source][:-distance]  # Delete stacks that have been moved

# Fetch the tops of the stacks
tops = [stack[-1] for stack in stacks]
print("".join(tops))


