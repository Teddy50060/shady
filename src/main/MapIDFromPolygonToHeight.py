import ijson

with open("bangkok_ids.txt") as f:  # no "rb" needed for text
    ids = set(line.strip() for line in f)

heights = {}
with open("e100_n15_e105_n10.json", "rb") as f:
    for key, value in ijson.kvitems(f,''):
        id = key[3:-3]
        if(id in ids):
            heights[id] = value["height"]

import csv
with open("bangkok_heights.csv", "w") as f:
    writer = csv.writer(f)
    writer.writerow(["id", "height"])  # header
    for id, height in heights.items():
        writer.writerow([id, height])

