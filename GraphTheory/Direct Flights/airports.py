def main():
  airports, direct_flights = input().split()
  airport_dict = {}
  for _ in range(int(airports)):
    new_key = input()
    airport_dict.setdefault(new_key, [])  
    
  for _ in range(int(direct_flights)):
    air1, air2 = input().split()
    airport_dict[air1].append(air2)
    airport_dict[air2].append(air1)

  for key in sorted(airport_dict.keys()):
    print(f"{key}: {' '.join(sorted(airport_dict[key]))}")

main()