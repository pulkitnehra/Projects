from settings import Settings
class GameStats:
	"""Tracks the in-game statistics"""
	def __init__(self, ai_game):
		self.settings = ai_game.settings
		self.reset_status()

		# set the game in inactive state for play button functionality
		self.game_active = False
		self.high_score = 0

	def reset_status(self):
		"""Initialize the statistics"""
		# Issue 2 fixed
		self.ships_left = self.settings.ship_limit
		self.score = 0
		self.level = 1