import pygame
from pygame.sprite import Sprite
class Ship(Sprite):
	"""Displays the ship image"""
	def __init__(self, ai_game):
		super().__init__()
		# initialize the starting point of the object
		self.screen = ai_game.screen
		self.settings = ai_game.settings
		self.screen_rect = ai_game.screen.get_rect()
		# load image (object are treated as rectangles in pygame)
		self.image = pygame.image.load('images/ship.bmp')
		self.rect = self.image.get_rect()
		self.rect.midbottom = self.screen_rect.midbottom
		self.x = float(self.rect.x)
		# to control ship movement 
		self.moving_right = False
		self.moving_left = False
		

	def update(self):
		"""update movement on basisi of movement flag"""
		# al movements are on basis of cordinates axes x & y
		if self.moving_right and self.rect.right < self.screen_rect.right:
			self.x += self.settings.ship_speed
		if self.moving_left and self.rect.left > 0:
			self.x -= self.settings.ship_speed
		self.rect.x = self.x

	
	def center_ship(self):
		""" Center the ship after loss of life """
		self.rect.midbottom = self.screen_rect.midbottom
		self.x = float(self.rect.x)



	def blitme(self):
			"""draw the ship at its current position"""
			self.screen.blit(self.image, self.rect)



"""Additional code for running up and down"""
"""Adjusting the x and y axis cordinates for 2d movement"""
		# self.rect.centerx = self.screen_rect.centerx
		# self.rect.centery = self.screen_rect.centery
		 
		# store decimal value for ship's horizontal and vertical position
		# self.center0 = float(self.rect.centerx)
		# self.center1 = float(self.rect.centery)

		# self.moving_up = False
		# self.moving_down = False


		# if self.moving_up and self.rect.top > 0:
		# 	self.center1 -= self.settings.ship_speed
		# if self.moving_down and self.rect.bottom < self.screen_rect.bottom:
		#  	self.center1 += self.settings.ship_speed
		# # update the rect object value
		# self.rect.centerx = self.center0
		# self.rect.centery = self.center1

		#%%