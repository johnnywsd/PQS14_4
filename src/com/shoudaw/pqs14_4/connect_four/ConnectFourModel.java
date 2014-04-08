package com.shoudaw.pqs14_4.connect_four;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ConnectFourModel implements ActionListener{
  private static final int WIN_NUM = 4;
  private GameButton[][] board;
  private int m = 0;
  private int n = 0;
  private int counter = 0;
  private Component parent;
  private PlayMode playMode;
  public ConnectFourModel(Component parent, GameButton[][] board,
      PlayMode playMode){
    this.parent = parent;
    this.m = board.length;
    this.n = board[0].length;
    this.board = board;
    for (int i = 0; i < this.m; i++){
      for (int j = 0; j < this.n; j++){
        this.board[i][j].addActionListener(this);
      }
    }
    this.playMode = playMode;
  }
  public ConnectFourModel(Component parent, GameButton[][] board){
    this(parent, board, PlayMode.SINGLE);
  }
  
//  private void stop(){
//    this.counter = 0;
//    for (int i = 0; i < this.m; i++){
//      for (int j = 0; j < this.n; j++){
//        this.board[i][j].stop();
//      }
//    }
//  }
  
  private void reset(){
    this.counter = 0;
    for (int i = 0; i < this.m; i++){
      for (int j = 0; j < this.n; j++){
        this.board[i][j].reset();
        this.board[i][j].setBackground(null);
      }
    }
    this.setAvailable();
  }
  
  public GameRole whoWin(){
    
    //horizontally
    int count = 1;
    for (int i = 0; i < this.m; i++){
      GameRole hold = this.board[i][0].getRole();
      for (int j = 1; j < this.n; j++){
        GameRole curr = this.board[i][j].getRole();
        if (hold == curr && curr != null){
          count ++;
          if (count >= WIN_NUM){
            return hold;
          }
        }else{
          count = 1;
          hold = curr;
        }
      }
    }
    
    //vertically
    count = 1;
    for (int j = 0; j < this.n; j++){
      GameRole hold = this.board[0][j].getRole();
      for (int i = 1; i < this.m; i++){
        GameRole curr = this.board[i][j].getRole();
        if (hold == curr && curr != null){
          count ++;
          if (count >= WIN_NUM){
            return hold;
          }
        }else{
          count = 1;
          hold = curr;
        }
      }
    }
    
    // j - i == a constant
    ArrayList<ArrayList<GameRole>> diagonals1 = 
        new ArrayList<ArrayList<GameRole>>();
    for (int i=0; i < this.m + this.n - 1; i ++){
      diagonals1.add(new ArrayList<GameRole>());
    }
    int offset1 = this.m - 1;
    
    // j + i == a constant
    ArrayList<ArrayList<GameRole>> diagonals2 = 
        new ArrayList<ArrayList<GameRole>>();
    for (int i=0; i < this.m + this.n - 1; i ++){
      diagonals2.add(new ArrayList<GameRole>());
    }
    int offset2 = 0;
    
    for (int i = 0; i < this.m; i++){
      for (int j = 0; j < this.n; j++){
        diagonals1.get(j - i + offset1).add(this.board[i][j].getRole());
        diagonals2.get(j + i + offset2).add(this.board[i][j].getRole());
      }
    }
    
    ArrayList<ArrayList<GameRole>> diagonalsAll = 
        new ArrayList<ArrayList<GameRole>>();
    diagonalsAll.addAll(diagonals1);
    diagonalsAll.addAll(diagonals2);
    
    for(ArrayList<GameRole> array : diagonalsAll){
      GameRole curr = array.get(0);
      count = 0;
      for (GameRole role : array){
        if (role == curr && role != null){
          count++;
          if (count >= WIN_NUM){
            return role;
          }
        }else{
          curr = role;
          count = 1;
        }
      }
    }
    return null;
  }

  public void setAvailable(){
    for(int j = 0; j < this.n; j++){
      int i = this.m - 1;
      if (this.board[i][j].getRole() == null){
        this.board[i][j].setEnabled(true);
      }
    }
    for (int i = 0; i < this.m - 1; i++){
      for (int j = 0; j < this.n; j++){
        if (this.board[i][j].getRole() == null &&
            this.board[i + 1][j].getRole() != null){
          this.board[i][j].setEnabled(true);
        }
      }
    }
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    GameButton btn = (GameButton)e.getSource();
    GameRole role = GameRole.fromInteger(counter);
    counter++;
    counter = counter % GameRole.size();
    btn.setRole(role);
    btn.setBackground(GameRole.getColor(role));
    this.setAvailable();
    GameRole winner = this.whoWin();
    if (winner != null){
      String msg = String.format("Winner is %s", winner.name());
      JOptionPane.showMessageDialog(this.parent, msg);
      this.reset();
    }
  }

  public void changePlayMode(PlayMode playMode) {
    this.playMode = playMode;
    this.reset();

  }
}
