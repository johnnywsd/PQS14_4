package com.shoudaw.pqs14_4.connect_four;

import javax.swing.JButton;

public class GameButton extends JButton {

  private static final long serialVersionUID = 6244182340935649415L;
  private GameRole role = null;
  public void setRole(GameRole role){
    this.setEnabled(false);
    this.role = role;
  }
  public GameRole getRole(){
    return this.role;
  }
}
