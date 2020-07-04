import pygame
from pygame.sprite import Sprite

class Bullet(Sprite):
	"""manage the bullets fired from the ship"""
	def __init__(self, ai_game):
		super().__init__()
		self.screen = ai_game.screen
		self.settings = ai_game.settings
		self.bullet_color = self.settings.bullet_color

		# create an initial position for the bullet object 
		self.rect = pygame.Rect(0,0, self.settings.bullet_width, self.settings.bullet_height)		
		#adjust the bullet to appear top of the ship
		self.rect.midtop = ai_game.ship.rect.midtop

		self.y = float(self.rect.y)

	def update(self):
		"""Move the bullets up the screen"""
		#changing the y co-ordinate to move the bullet upwards 
		self.y -= self.settings.bullet_speed
		# update the position of the rectangle object of each bullet
		self.rect.y = self.y
		 
	def draw_bullet(self):
		pygame.draw.rect(self.screen, self.bullet_color, self.rect)




