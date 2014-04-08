/**
 * 
 */
package com.shoudaw.pqs14_4.connect_four;

import java.awt.Color;

/**
 * @author johnny
 *
 */
public enum GameRole {
  PLAYER1, PLAYER2;
  public static GameRole fromInteger(int x) {
    switch(x) {
      case 0:
        return PLAYER1;
      case 1:
        return PLAYER2;
    }
    return null;
  }
  public static int size(){
    return 2;
  }
  public static Color getColor(GameRole role){
    if (role == PLAYER1){
      return Color.red;
    }else if (role == PLAYER2){
      return Color.green;
    }
    return null;
  }
}
