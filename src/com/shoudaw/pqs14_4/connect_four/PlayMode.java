/**
 * 
 */
package com.shoudaw.pqs14_4.connect_four;

/**
 * @author johnny
 *
 */
public enum PlayMode {
  SINGLE, DOUBLE;
  public static PlayMode fromInteger(int x) {
    switch(x) {
      case 0:
        return SINGLE;
      case 1:
        return DOUBLE;
    }
    return null;
  }
  public static int size(){
    return 2;
  }
  
}
