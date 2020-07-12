class Settings:
	""" Stoe settings for alien invasion game"""
	def __init__(self):
		#Screen Settings
		self.screen_width = 1200
		self.screen_height = 800
		self.bg_color = (230, 230, 230)
		self.ship_speed = 1.5

		# bullet settings
		self.bullet_speed = 1.5
		self.bullet_height = 15	
		self.bullet_width =  3
		self.bullet_color =  (60, 60, 60)

		# Alien Settings
		self.alien_speed = 1.0
		self.fleet_drop_speed = 50

		# 1 means right -1 means left
		self.fleet_direction = 1

		# Ship settings
		self.ship_speed = 1.5
		self.ship_limit = 3

		# Scoring
		self.alien_points = 50

		# how quickly the game speeds up
		self.speedup_scale = 0.4

		# how quickly the alien point values increase
		self.score_scale = 1.1

		# High score never be reset
		self.high_score = 0

		self.initialize_dynamic_settings()

	def initialize_dynamic_settings(self):
			"""Initialize the settings that change in the game"""
			self.ship_speed = 1.5
			self.bullet_speed = 3.0
			self.alien_speed = 1.0

			# reset the fleet direction accordingly
			self.fleet_direction = 1
			self.alien_points = 50

	def increase_speed(self):
			"""Increase the speed of game after each level"""
			self.ship_speed *= self.speedup_scale
			self.bullet_speed *= self.speedup_scale
			self.alien_speed *= self.speedup_scale

			self.alien_points = int(self.alien_points * self.score_scale) 


	




