# TIC-TAC-TOE

![image](https://user-images.githubusercontent.com/94545831/169682812-65b02c76-7064-41ba-8326-d70eacc78013.png)


# PROBLEM STATEMENT :
- The player can give inputs thriugh simple switches and the display can be made on a matrix of LEDs.
- The game algorithm should be such that cicuit cananot be beaten and in the worst case the game game ends in a draw.

# INFO :
- A two-player game where players one and two have to fill the grids of 3*3 with X and 0 respectively.
- The winner would be declared when all the grids are filled.
- The project operates in offline mode and the player can play as Multiplayer.
- There are 3 activities in the project which is shown below along with one dialog box. 


|Main Activity|Start Activity| Game Activity|Dialog Box|
| ------- | --- | --- |---|
|![Screenshot (85)](https://user-images.githubusercontent.com/94545831/169682572-9dae95c4-f509-4b8b-ac13-90a2027888c4.png)|![Screenshot (86)](https://user-images.githubusercontent.com/94545831/169682627-53ca92be-0498-4dba-995d-953965ade441.png)|![Screenshot (87)](https://user-images.githubusercontent.com/94545831/169682669-664d2f4a-e07c-45d2-8400-53127960724d.png)|![Screenshot (91)](https://user-images.githubusercontent.com/94545831/169682773-e137362b-0733-4f41-bc9b-66f4074f6fa4.png)

- The key observation is that in order to win Tic-Tac-Toe you must have the entire row or column.
-  Thus, we don't need to keep track of an entire n^2 board. We only need to keep a count for each row and column. 
-  If at any time, a row or column matches the size of the board then that player has won.

# Constraints
- 1 <= moves.length <= 9.
- moves[i].length == 2.
- 0 <= moves[i][j] <= 2.
- Here, are no repeated elements on moves.
