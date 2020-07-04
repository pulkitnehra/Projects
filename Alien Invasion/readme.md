# This project is made using python pygame library


## Events associated in main file
### KEY_DOWN
  detects the key press on the surface of the screen
### KEY_UP
  detects the key release
### Stopping the ship at the edge
  #### self.rect.right < self.screen_rect.right
      checks that the current position is less than the end of the main screen to the rhs
  #### self.rect.left < 0
       checks that ship position at the lhs is less than 0
  
   
