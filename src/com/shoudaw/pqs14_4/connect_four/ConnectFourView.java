package com.shoudaw.pqs14_4.connect_four;

import javax.swing.JFrame;

public class ConnectFourView {
  private static final int M = 6;
  private static final int N = 7;
  private JFrame frame = new JFrame();
  private GameButton[][] board = new GameButton[M][N];
  public ConnectFourView(){
    for (int i = 0; i < M; i++){
      for (int j = 0; j < N; j++){
        board[i][j] = new GameButton();
      }
    }
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
