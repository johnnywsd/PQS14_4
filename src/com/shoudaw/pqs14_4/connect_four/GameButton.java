package com.shoudaw.pqs14_4.connect_four;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameButton extends JButton{

  private static final long serialVersionUID = 6244182340935649415L;
  private GameRole role = null;
  public GameButton(){
    this.setEnabled(false);
  }
  public void setRole(GameRole role){
    this.setEnabled(false);
    this.role = role;
  }
  public GameRole getRole(){
    return this.role;
  }
  
  
}
