import json

# Load height lookup
print("start reading height json")
with open("src/main/e100_n15_e105_n10.json") as f:
    heights = json.load(f)

# Build a clean dict: numeric_id -> height
print("fetch successful")
height_map = {}
for key, value in heights.items():
    # Strip "osm" prefix and 3-letter country suffix
    numeric_id = key[3:-3]
    height_map[numeric_id] = value["height"]

# Load polygon GeoJSON
with open("src/main/e100_n15_e105_n10.geojson") as f:
    polygons = json.load(f)

# Merge
matched = 0
for feature in polygons["features"]:
    building_id = feature["properties"]["id"]
    if building_id in height_map:
        feature["properties"]["height"] = height_map[building_id]
        matched += 1

print(f"Total buildings: {len(polygons['features'])}")
print(f"Matched with height: {matched}")

# Save merged GeoJSON
with open("bangkok_buildings.geojson", "w") as f:
    json.dump(polygons, f)