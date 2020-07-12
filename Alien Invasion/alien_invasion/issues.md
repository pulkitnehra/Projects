# Issue no 1
	## Aliens in the game escapes the end of screen and not moving as desired
	## problem in alien.py
		### self.settings = Settings()
		### should be
		### self.settings = ai_game.settings
# Issue 2
	## Scoreboard doesnot set to 0 after new game starts
	### it starts from the same score where it was left
	### fixed in game_stats.py
# Issue 3:
	## Scoreboard not showing high score
	### fixed in alien_invasion.py

# Issu 4:
	## Level not updating
	###