import pygame
import sys
from settings import Settings
from ship import Ship
class AlienInvasion:
	"""Describes the basic functionality and behaviour of game"""
	def __init__(self):
		"""Initialize game and create resources 
		i.e background settings etc
		"""
		pygame.init()
		# import settings from settings.py file
		self.settings = Settings()
		
		#Creates the game window and assigns a name to it
		self.screen = pygame.display.set_mode((self.settings.screen_width, self.settings.screen_height))
		pygame.display.set_caption("Alien Invasion")

		# imports the ship objects and it's attributes
		self.ship = Ship(self)
		


	def run_game(self):
		"""starts the main game"""
		while True:
			self._check_events()
			self.ship.update()
			self._update_screen()

	def _check_events(self):
			# watch for keyboard or mouse events
			for event in pygame.event.get():
				if event.type == pygame.QUIT:
					sys.exit()

			# check for key press
				elif event.type == pygame.KEYDOWN:
					if event.key == pygame.K_RIGHT:
						self.ship.moving_right = True
					elif event.key == pygame.K_LEFT:
						self.ship.moving_left = True

			# check for key release
				elif event.type == pygame.KEYUP:
					if event.key == pygame.K_RIGHT:
						self.ship.moving_right = False
					elif event.key == pygame.K_LEFT:
						self.ship.moving_left = False


	def _update_screen(self):
			# fill the surface with the background color
			self.screen.fill(self.settings.bg_color)

			# Draw the ship on the main surface
			self.ship.blitme()

			# make the recent screen visible at the end		
			pygame.display.flip()





if __name__ == '__main__':
	ai = AlienInvasion()
	ai.run_game()


