package com.shoudaw.pqs14_4.connect_four;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;


public class ConnectFourModelTest {

  @Test
  public void whoWinTest1(){
    int M = 6;
    int N = 7;
    GameButton[][] board = new GameButton[M][N];
    for(int i=0; i < M; i++){
      for(int j=0; j< N; j++){
        board[i][j] = new GameButton();
      }
    }
    board[5][0].setRole(GameRole.PLAYER2);
    board[5][1].setRole(GameRole.PLAYER2);
    board[5][2].setRole(GameRole.PLAYER1);
    board[5][3].setRole(GameRole.PLAYER1);
    board[5][4].setRole(GameRole.PLAYER1);
    board[5][5].setRole(GameRole.PLAYER1);
    board[5][6].setRole(GameRole.PLAYER2);
    ConnectFourModel cfm = new ConnectFourModel(null, board);
    GameRole res = cfm.whoWin();
    assertEquals(GameRole.PLAYER1, res);
  }
  
  @Test
  public void whoWinTest2(){
    int M = 6;
    int N = 7;
    GameButton[][] board = new GameButton[M][N];
    for(int i=0; i < M; i++){
      for(int j=0; j< N; j++){
        board[i][j] = new GameButton();
      }
    }
    board[0][0].setRole(GameRole.PLAYER2);
    board[1][0].setRole(GameRole.PLAYER2);
    board[2][0].setRole(GameRole.PLAYER1);
    board[3][0].setRole(GameRole.PLAYER1);
    board[4][0].setRole(GameRole.PLAYER1);
    board[5][0].setRole(GameRole.PLAYER1);
    ConnectFourModel cfm = new ConnectFourModel(null, board);
    GameRole res = cfm.whoWin();
    assertEquals(GameRole.PLAYER1, res);
  }
  
  @Test
  public void whoWinTest3(){
    int M = 6;
    int N = 7;
    GameButton[][] board = new GameButton[M][N];
    for(int i=0; i < M; i++){
      for(int j=0; j< N; j++){
        board[i][j] = new GameButton();
      }
    }
    board[0][0].setRole(GameRole.PLAYER2);
    board[1][1].setRole(GameRole.PLAYER2);
    board[2][2].setRole(GameRole.PLAYER1);
    board[3][3].setRole(GameRole.PLAYER1);
    board[4][4].setRole(GameRole.PLAYER1);
    board[5][5].setRole(GameRole.PLAYER1);
    ConnectFourModel cfm = new ConnectFourModel(null, board);
    GameRole res = cfm.whoWin();
    assertEquals(GameRole.PLAYER1, res);
  }
  
  @Test
  public void whoWinTest4(){
    int M = 6;
    int N = 7;
    GameButton[][] board = new GameButton[M][N];
    for(int i=0; i < M; i++){
      for(int j=0; j< N; j++){
        board[i][j] = new GameButton();
      }
    }
    board[0][5].setRole(GameRole.PLAYER2);
    board[1][4].setRole(GameRole.PLAYER2);
    board[2][3].setRole(GameRole.PLAYER1);
    board[3][2].setRole(GameRole.PLAYER1);
    board[4][1].setRole(GameRole.PLAYER1);
    board[5][0].setRole(GameRole.PLAYER1);
    ConnectFourModel cfm = new ConnectFourModel(null, board);
    GameRole res = cfm.whoWin();
    assertEquals(GameRole.PLAYER1, res);
  }

}
