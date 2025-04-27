# wordle-app
 
# intro
My family, friends and I look forward to playing the wordle everyday. I in particular enjoy the simplicity yet challenege of the game. This is a wordle app, designed to function just like the NYT game.

The original version of this app was developed as curriculum for the Java bootcamp I taught in the summer of 2024. The version we built in class is very primitive, and does not enforce all of the rules of the real worlde game, nor does it allow for a single player game. 

With the brief time between my spring and summer courses, whilst playing the wordle archive, I decided to fully implement this wordle app to avoid paying a monthly subscription to the NYT app for the wordle archive.

This most recent spring semester I took an intorduction to software testing course, where we learned the fundamentals of testing software. I was really interested by TDD, and honestly slightly skeptical as to whether it would be efficient. Here, I'm going to begin implementing the new features using TDD.

# actionable items
Here is a list of the functionality as implemented in the Java bootcamp:
- accepts a word from first player
- asks second player to type guesses
- maximum 6 guesses
- handles words of maximum 5 character
- handles words only with word characters
- play again option
- DOES NOT verify word meets requirements

Here is a list of the additional features I will implement to make the game fully functional:
- handle words must be exactly 5 characters
- handles only real words
- single player option where it picks a random word (and in play again option)
- clear console when playing again

# nitty gritty (prior to changes)
Below is the logic of how the game runs in the ORIGINAL version
- scanner prompts player 1 to enter a word, it is saved in variable answer

