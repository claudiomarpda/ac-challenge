# ac-challenge

## Challenge

There are three boxes, and only one of them contains the long-awaited Apple Watch, which you can win if you guess which one it is.
 
The boxes are shuffled, and as soon as you choose one of them, the program will show you a different one - which will be empty (the program knows where the reward is!). As a player, it is up to you to change your initial choice. Do you keep your original guess or change the box you chose?
 
Your task is to write a program that simulates the above-mentioned problem and a function that proves which would be the best choice, change your guess or not!
 
And go further - what would you change if it were fifty boxes?


## Solution

The solution is like a game where the user is asked for inputs and the program responds to them.
The default number of boxes is 3, which uses the range (1, 3). A custom range is also accepted when running the program with CLI arguments, i.e, (1, 50).

Compiled with Java 17.0.1.
Run with:
```
javac Main.java
java Main 1 50
```


