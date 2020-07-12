import pygame
from pygame.sprite import Sprite
from settings import Settings

class Alien(Sprite):
	"""Initializes the starting position of alien"""
	def __init__(self, ai_game):
		super().__init__()
		self.screen = ai_game.screen
		self.settings = ai_game.settings
		# load the image 
		self.image = pygame.image.load('images/alien.bmp')
		self.rect = self.image.get_rect()

		# initialise the starting position of alien object
		self.rect.x = self.rect.width
		self.rect.y = self.rect.height

		# store the horizontal position
		self.x = float(self.rect.x)


	def check_edges(self):
		"""Check whether an alien is at edge or not"""
		screen_rect = self.screen.get_rect()

		# check for right edge and left edge movement
		if self.rect.right >= screen_rect.right:
			return True
		elif self.rect.left <= 0:
			return True

	def update(self):
		"""Controls the alien speed moving in either direction"""
		self.x += (self.settings.alien_speed * self.settings.fleet_direction)
		self.rect.x = self.x 

	def blitme(self):
		self.screen.blit(self.image, self.rect)

        
	



