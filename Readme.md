# Capture the flag minecraft plugin

This is a small capture the flag plugin.

## Commands
For help with the commands see the list below:

# /CTF

## pos1
Sets first position for map creation
<br>

## pos2
Sets second position for map creation
<br>

## create

### map
create a map<br>
parameters: team count, name<br>
requirements: valid first and second pisition, both parameters set<br>
note: team count must be a value between 2 and 4
<br>

### flagspot
create a flagspot <br>
parameters: type, team<br>
requirements: a valid active map, both parameters set<br>
note: there are two types: home, capture<br>
      home:    Position for the flag in the owners base<br>
      capture: Position to put captured flags
<br>

### lootchest
create a lootchest<br>
requirements: a valid active map
<br>

### spawnpoint
create a spawnpoint<br>
parameters: team<br>
requirements: a valid active map<br>
note: When no team is provided the spawnpoint will be for spectators
<br>

## start
start the game
<br>

## participate
participate in currently planned game when it starts
