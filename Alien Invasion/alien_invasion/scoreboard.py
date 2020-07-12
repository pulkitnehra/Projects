import pygame.font
from pygame.sprite import Group
from ship import Ship
class ScoreBoard:
	"""Stores the scoring info"""
	def __init__(self, ai_game):
		"""initialise the scoring info"""
		self.ai_game = ai_game
		self.screen = ai_game.screen
		self.screen_rect = self.screen.get_rect()
		self.settings = ai_game.settings
		self.stats = ai_game.stats
		# font settings for score
		self.text_color = (30, 30, 30)
		self.font = pygame.font.SysFont(None, 48)

		# prepare the initial score
		self.prep_score()
		self.prep_high_score()
		self.prep_level()
		self.prep_ships()

	def prep_score(self):
		"""Turn score into a rendered image"""
		score_str = str(self.stats.score)
		rounded_score = round(self.stats.score, -1)
		score_str = "{:,}".format(rounded_score)
		self.score_img = self.font.render(score_str, True, self.text_color, self.settings.bg_color)
		# Display score at top right
		self.score_rect = self.score_img.get_rect()
		self.score_rect.right = self.screen_rect.right - 20
		self.score_rect.top = 20


	def check_high_scores(self):
		"""Check for high scores"""
		if self.stats.score > self.stats.high_score:
			self.stats.high_score = self.stats.score
			self.prep_high_score()

	def prep_level(self):
		"""turn level into a rendered image"""
		level_str = str(self.stats.level)
		self.level_img = self.font.render(level_str, True, self.text_color, self.settings.bg_color)

		# position the image
		self.level_rect = self.level_img.get_rect()
		self.level_rect.right = self.score_rect.right
		self.level_rect.top = self.score_rect.bottom + 10


	def prep_ships(self):
		"""Show how many ships are left"""
		self.ships =Group()
		for ship_number in range(self.stats.ships_left):
			ship = Ship(self.ai_game)
			ship.rect.x = 10 + ship_number * ship.rect.width
			ship.rect.y = 10
			self.ships.add(ship)

	
	def prep_high_score(self):
		"""Turn high score into a rendered image"""
		high_score = round(self.stats.high_score, -1)
		high_score_str = "{:,}".format(high_score)
		self.high_score_image = self.font.render(high_score_str, True, self.text_color,  self.settings.bg_color)  
		self.high_score_rect = self.high_score_image.get_rect()
		self.high_score_rect.centerx = self.screen_rect.centerx
		self.high_score_rect.top = self.score_rect.top

	def show_score(self):
		"""Draw the score onto the screen"""
		# draw the high and current scores                                                            
		self.screen.blit(self.score_img, self.score_rect)
		self.screen.blit(self.high_score_image, self.high_score_rect)
		self.screen.blit(self.level_img, self.level_rect)
		self.ships.draw(self.screen)
