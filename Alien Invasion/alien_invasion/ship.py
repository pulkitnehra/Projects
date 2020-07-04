import pygame
class Ship:
	"""Displays the ship image"""
	def __init__(self, ai_game):
		# initialize the starting point of the object
		self.screen = ai_game.screen
		
		self.screen_rect = ai_game.screen.get_rect()

		# load image (object are treated as rectangles in pygame)
		self.image = pygame.image.load('images/ship.bmp')
		self.rect = self.image.get_rect()

		# place the ship at the midbottom
		self.rect.midbottom = self.screen_rect.midbottom
		self.settings = ai_game.settings 
		# store decimal value for ship's horizontal position
		self.x = float(self.rect.x)


		# to control ship movement 
		self.moving_right = False
		self.moving_left = False

	def update(self):
		"""update movement on basisi of movement flag"""
		# al movements are on basis of cordinates axes x & y
		if self.moving_right and self.rect.right < self.screen_rect.right:
			self.rect.x += self.settings.ship_speed
		if self.moving_left and self.rect.left > 0:
			self.rect.x -= self.settings.ship_speed

		# update the rect object value
		# self.rect.x = self.x 

	def blitme(self):
			"""draw the ship at its current position"""
			self.screen.blit(self.image, self.rect)



