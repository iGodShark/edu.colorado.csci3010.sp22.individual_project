# Homework 4

### What I planned on doing for this homework deadline:
- Implement player movement throughout the maze
- Get a mini map going that renders as you visit each room in the maze.
- Pause menu that shows the blown-up version of the mini map.
- Enemy logic, which includes generation, and their fight logic.
- Fight logic for the player, giving options to attack or use an item.
- Game over and winning screen with option to play again.
- Plan what items will do what, and get an Item factory setup.

### What I actually accomplished for this deadline:
- I got the player movement finished (while it's choppy)
- I found a way to limit player vision when going through the maze.
- I implemented the mini map in the top right corner which fills itself in as rooms are visited.
- I worked on the outline of a UML class diagram and planned what weapons and items to include. Decided to get rid of special items. Screenshot of diagram: https://prnt.sc/0kxIZ_FB01kX
    - I didn't plan on making a UML class diagram, but as I began working and re-organizing my project structure, I finally figured a UML class diagram would be helpful as I wasted lots of time re-organizing.
- Started pause menu (not finished, so not included in latest commit)

I didn't get a lot of what I wanted to get done partly due to wasting time on re-organizing my project structure so many times. I initially tried to create an abstract controller class and put an FXMLLoader in the controller, but I was getting some nasty IO-related exceptions, so I moved all loaders into my Main class. Apart from wasted time, I didn't spend enough time on this project for this deadline. I tried to put in more work earlier on, but I was dismotivated as I didn't have it organized enough and didn't know where to start or what to work on. This led me to putting it off for so long and doing all of the work mentioned above within the past week.

### What I plan to do for the next deadline:
- Item factory when generating the maze.
- Enemy factory when generating the maze.
- Implement the HealthPack, AccuracyBoost, StrengthPotion, DefenseBoost
- Implement the Dagger, Sword, Club, Bow
- Player backpack
- Fight logic

I initially planned to do all of the graphics for this deadline, but I don't believe I will get to it (partly because I would need to do research on sprite animations in JavaFx). I will now only do that if I have time even though it would look 10 times better. Following are some screenshots of what the maze looks like:

https://prnt.sc/d8NsAfWv_ZYf

https://prnt.sc/96guaKnnVg7E
