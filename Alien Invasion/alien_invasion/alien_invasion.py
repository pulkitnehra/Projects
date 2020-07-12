import pygame
import sys
from time import sleep
from settings import Settings
from ship import Ship
from bullets import Bullet
from alien import Alien
from game_stats import GameStats
from button import Button
from scoreboard import ScoreBoard


class AlienInvasion:
	"""Describes the basic functionality and behaviour of game"""
	def __init__(self):
		"""Initialize game and create resources 
		i.e background settings etc
		"""
		pygame.init()
		# import settings from settings.py file
		self.settings = Settings()


		self.stats = GameStats(self)
		# import the bullet properties and store them in a group
		self.bullet = pygame.sprite.Group()
		# fix the number of bullets allowed at a particular moment
		self.bullets_allowed = 5
		#Creates the fullscreen game window 
		self.screen = pygame.display.set_mode((0,0),pygame.FULLSCREEN)
		self.settings.screen_width = self.screen.get_rect().width
		self.settings.screen_height = self.screen.get_rect().height
		
		# initialise the score settings
		self.sb = ScoreBoard(self)

		# title text for the window
		pygame.display.set_caption("Alien Invasion")

		# imports the ship objects and it's attribuai_game, msgtes
		self.ship = Ship(self)
		#imports the alien and it's arrtibutes
		self.aliens = pygame.sprite.Group()
		# create a fleet
		self._create_fleet()

		# make the play button
		self.play_button = Button(self,"Play")


	"""Mina running function"""

	def run_game(self):
		"""s  90tarts the main game"""
		while True:
			# if there are no ships left the game freezes
			self._check_events()

			if self.stats.game_active:
				self.ship.update()
				self.bullet.update()
				self._update_bullets()
				self._update_aliens()

			self._update_screen()

	
	"""Event handler functions"""

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

			# check for mouse events on play button
			elif event.type == pygame.MOUSEBUTTONDOWN:
				mouse_pos = pygame.mouse.get_pos()
				self._check_play_events(mouse_pos)


	def  _check_play_events(self, mouse_pos):
		"""Starts a new game if users click play"""
		button_clicked = self.play_button.rect.collidepoint(mouse_pos)
		if button_clicked and not self.stats.game_active:
			
			# if the mouse click overlaps the button rect
			pygame.mouse.set_visible(False)
			self.stats.reset_status()
			self.stats.game_active = True
			self.sb.prep_score()
			self.sb.prep_level()
			self.sb.prep_ships() 
			# reset the game stats
			self.settings.initialize_dynamic_settings()

			# get rid of remaining aliens
			self.bullet.empty()
			self.aliens.empty()

			# create new fleet and center the ship
			self._create_fleet()
			self.ship.center_ship()




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


	"""Bullet attributes"""
	
	
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
		# check for bullet collision
		#if true get rid of bullet and alien
		#groupcollide checks for overlap betwen the bullet and alien object
		self._check_bullet_collisions()

	def _check_bullet_collisions(self):
		collisions = pygame.sprite.groupcollide(self.bullet, self.aliens,True,True)
		if collisions:
			# add points and display to the scoreboard
			for aliens in collisions.values():
				self.stats.score += self.settings.alien_points * len(aliens)
			self.sb.prep_score()
			# Issue 3 fixed 
			self.sb.check_high_scores()


		if not self.aliens:
			# destroy existing bullets and create new fleet
			self.bullet.empty()
			self._create_fleet()
			self.settings.increase_speed()

			# Increase the level
			self.stats.level += 1
			self.sb.prep_level()



	"""Alien atrributes"""

	def _create_fleet(self):
		"""Creates an alien fleet"""
		alien = Alien(self)
		alien_width, alien_height = alien.rect.size
		# space required by each alien object
		available_space = self.settings.screen_width - (2 * alien_width)
		# total no of aliens in space available
		number_of_aliens = available_space // (2 * alien_width)

		# find the no of rows of alien that fit on the screen
		ship_height = self.ship.rect.height
		available_space_y = (self.settings.screen_height - (3*alien_height)-ship_height)
		number_of_rows = available_space_y //(2 * alien_height)

		for row_number in range(number_of_rows):
			for alien_no in range(number_of_aliens+1):
			 			self._create_alien(alien_no, row_number)

	def _create_alien(self, alien_no, row_number):
		"""create ana alien and place it on the screen"""
			# create a row of aliens
		alien = Alien(self)
		alien_width, alien_height = alien.rect.size
		alien.x =  alien_width + (2 * alien_width * alien_no)
		# traversing like in a matrix using the co-ordinates
		alien.rect.x = alien.x
		alien.rect.y = alien.rect.height + 2 * alien.rect.height * row_number 
		self.aliens.add(alien)

	def _check_fleet_edges(self):
		"""Checks if the fleet encopntered an edge on either side"""
		for alien in self.aliens.sprites():
			if alien.check_edges():
				self._change_fleet_direction()
				break

	def _change_fleet_direction(self):
		"""Change direction when encounter an edge"""
		for alien in self.aliens.sprites():
			alien.rect.y += self.settings.fleet_drop_speed
		# after that the fleet direction is changed
		self.settings.fleet_direction *= -1

	def _check_alien_bottom(self):
		""" Check for alien object reaching bottom """
		screen_rect = self.screen.get_rect()

		for alien in self.aliens.sprites():
			if alien.rect.bottom >= screen_rect.bottom:
				self.ship_hit()
				break

	def ship_hit(self):
		"""Detect the collision """
		# decrement lives of  ship left
		if self.stats.ships_left > 0:
			self.stats.ships_left -= 1
			self.sb.prep_ships()
			# get rid of remaining aliens and bullets
			self.aliens.empty()
			self.bullet.empty()

			# Create a new fleet and center the ship
			self._create_fleet()
			self.ship.center_ship()
			
			# Pause
			sleep(0.5)
		else:
			self.stats.game_active = False
			pygame.mouse.set_visible(True)

	def _update_aliens(self):
		"""
		Check if an alien is at edge
		update the position of alien fleet"""
		self._check_fleet_edges()
		self.aliens.update()

		# check for ship collision
		if pygame.sprite.spritecollideany(self.ship, self.aliens):
			self.ship_hit()

		# look for aliens hitting the botom of screen
		self._check_alien_bottom()

	def _update_screen(self):
		# fill the surface with the background color
		self.screen.fill(self.settings.bg_color)

		# Draw the ship on the main surface
		self.ship.blitme()

		# draw all fired bullets on the screen
		for bullet in self.bullet.sprites():
			bullet.draw_bullet()
		self.aliens.draw(self.screen)

		# draw the score btn
		self.sb.show_score()

		# draw the play button if the game is inactive
		if not self.stats.game_active:
			self.play_button.draw_button()

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
