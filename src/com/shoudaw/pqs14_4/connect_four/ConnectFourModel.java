package com.shoudaw.pqs14_4.connect_four;

import java.util.ArrayList;

public class ConnectFourModel {
  private static final int WIN_NUM = 4;
  private GameButton[][] board;
  private int m = 0;
  private int n = 0;
  public ConnectFourModel(GameButton[][] board){
    this.m = board.length;
    this.n = board[0].length;
    this.board = board;
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
}
