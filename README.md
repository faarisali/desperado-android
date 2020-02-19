# desperado-android
This app is wild-west themed and has 3 distinct levels.

Setup
====================
Ensure that you have Android Studio, Android API 29 SDK, and a compatible phone or Android Virtual Device installed. I used the Pixel 3 with API 28 as my AVD (Android Virtual Device).

To setup the project, go to Android Studio and on the welcome page, click Check out project from Version Control and paste this project's Git URL into the given prompt.

Then, it will ask you if you would like to create an Android Studio project. Select Yes.
Click next until it asks you if you want to overwrite a module file. Select Overwrite.
Then select the project SDK as Android API 29 Platform.
Click next, and then Finish.

Then Android Studio will open a new project. Near the top left, go to File > Open, then in the pop up, go to, [directory that you cloned the project into] > phase2 > Game, and under the Game directory, double click on build.grade
You should then see another window launched by Android Studio.

This should commence the building the process. After building, click run with your choice of device as the app installation target. Again, I use the Pixel 3 AVD running with API 28.

Game Instructions
====================
Level One:
	Tap the coins to gain gold and points. Do not tap bombs, otherwise you will be penalized.

Hidden feature:
	there is a set of dynamite sticks in the level, tap on that to clear bombs.

Level Two: 
	Player is a horse in this level. Avoid incoming cacti by tapping to jump over them.

Hidden feature:
	if the user has selected the clown costume as their preferred costume, the points displayed will be rainbow colored, and the player gets additional maximum height for each jump.

Level Three:
	Player is faced with sheriff in a shootout! Tap on one of the bottom three crates to hide behind. The sheriff will fire one of the crates, if you're behind it you get shot and lose a life.
	Also, tap one of the top three crates to take aim and try to guess where the sheriff is to win the game.
	Tap the go button when ready, and a round of shooting will occur.

Hidden feature:
	Tapping the sun reveals the sheriff's locaiton.
