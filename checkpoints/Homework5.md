# Homework 5

### What I planned on doing for this homework deadline:
- Item factory when generating the maze.
- Enemy factory when generating the maze.
- Implement the HealthPack, AccuracyBoost, StrengthPotion, DefenseBoost
- Implement the Dagger, Sword, Club, Bow
- Player backpack
- Fight logic

### What I actually accomplished for this deadline:
- Finished the pause menu
- Room factory which inits an item or enemy in 10% of the rooms on random.
- Implemented item and weapon classes
- Drew my own 32x32 pixel art drawings for half of the weapons and items
- Began on player backpack
- Observers, Listeners and Events to communicate between model and controller
- MazeController listens for a WinEvent and switches to win screen when player reaches the end.
- Player picks-up items when in a room that contains an item or weapon. Adds to player backpack, and removes item from the room / maze
- Modified the way the DFS generates the maze to start from the finish (so as a tree, the player no longer starts at the 'root', but needs to find their way to the root when put in the middle of the tree). This forces more exploration and it's no longer a practically straight path to the finish; more maze-like.

I got almost everything done that I planned to except for any fight logic that happens when the player encounters an enemy. I also didn't give the items full functionality yet (other than rendering / picking up). I will add the functionality once I add a way to fight an enemy, where the player can use an item.

### What I plan to do for the next deadline:
- Finish all pixel art for items and enemies
- Render all graphics
- Create a backpack view
- Show item descriptions when hovering in backpack view
- Show weapon descriptions when hovering in backpack view
- Create fight view
- Get into fight when player crosses by an enemy
- Add weapon behavior when fighting

I don't believe I will get to learning how sprite maps work and adding those into the project, so the game will be "choppy" and there won't be any animations. Following is what it looks like in the maze (and the most basic win screen)

Start screen:
https://prnt.sc/Kojb3LNCrFXR

Before picking up item:
https://prnt.sc/RFD-w8bORvH-

After picking up item:
https://prnt.sc/TJObW6yDONNK

https://prnt.sc/irIKrTxm2LOC
https://prnt.sc/6k1a8F0Fa9th

Pause Menu:
https://prnt.sc/9UTD4ZzFSPG1

Win Screen (in SceneBuilder, you need to finish the maze to trigger it)
https://prnt.sc/Wq_kKuedft5t
