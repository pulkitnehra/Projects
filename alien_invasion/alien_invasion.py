import pygame
import sys
from settings import Settings
from ship import Ship
from bullets import Bullet
class AlienInvasion:
	"""Describes the basic functionality and behaviour of game"""
	def __init__(self):
		"""Initialize game and create resources 
		i.e background settings etc
		"""
		pygame.init()
		# import settings from settings.py file
		self.settings = Settings()

		# import the bullet properties and store them in a group
		self.bullet = pygame.sprite.Group()
		# fix the number of bullets allowed at a particular moment
		self.bullets_allowed = 5
		#Creates the game window and assigns a name to it
		self.screen = pygame.display.set_mode((0,0),pygame.FULLSCREEN)
		self.settings.screen_width = self.screen.get_rect().width
		self.settings.screen_height = self.screen.get_rect().height
		# title text for the window
		pygame.display.set_caption("Alien Invasion")

		# imports the ship objects and it's attributes
		self.ship = Ship(self,self.screen)
		


	def run_game(self):
		"""starts the main game"""
		while True:
			self._check_events()
			self.ship.update()
			self.bullet.update()
			self._update_bullets()
			self._update_screen()

	def _check_events(self):
			# watch for keyboard or mouse events
		for event in pygame.event.get():
			if event.type == pygame.QUIT:
				sys.exit()

			# check for key press
			elif event.type == pygame.KEYDOWN:
				self._check_keydown_events(event)

			elif event.type == pygame.KEYUP:
				self._check_keyup_events(event)

	def _check_keydown_events(self, event):
		# check for key press
		if event.key == pygame.K_RIGHT:
			self.ship.moving_right = True
		elif event.key == pygame.K_LEFT:
		 	self.ship.moving_left = True

		# press q to quit	
		elif event.key == pygame.K_q:
			sys.exit()
		elif event.key == pygame.K_SPACE:
			self._fire_bullets()

	def _check_keyup_events(self, event):
		# check for key release
		if event.key == pygame.K_RIGHT:
			self.ship.moving_right = False
		elif event.key == pygame.K_LEFT:
			self.ship.moving_left = False
	
	def _fire_bullets(self):
		"""appends each new bullet and limits the no to fire each time"""
		if len(self.bullet) < self.bullets_allowed:
			new_bullet = Bullet(self)
			# sprites has the add() method
			self.bullet.add(new_bullet)

	def _update_bullets(self):
		# deleting the old bullets
			for bullet in self.bullet.copy():
				if bullet.rect.bottom <= 0:
					self.bullet.remove(bullet)
			# print(len(self.bullet))


	def _update_screen(self):
		# fill the surface with the background color
		self.screen.fill(self.settings.bg_color)

		# Draw the ship on the main surface
		self.ship.blitme()

		# draw all fired bullets on the screen
		for bullet in self.bullet.sprites():
			bullet.draw_bullet()

		# make the recent screen visible at the end		
		pygame.display.flip()





if __name__ == '__main__':
	ai = AlienInvasion()
	ai.run_game()




"""Additional code for running up and down"""
	# elif event.key == pygame.K_UP:
		# 	self.ship.moving_up = True
		# elif event.key == pygame.K_DOWN:
		# 	self.ship.moving_down = True


# elif event.key == pygame.K_UP:
		# 	self.ship.moving_up = False
		# elif event.key == pygame.K_DOWN:
		# 	self.ship.moving_down = False
