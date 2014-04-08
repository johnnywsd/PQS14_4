package com.shoudaw.pqs14_4.connect_four;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConnectFourView {
  private static final int M = 6;
  private static final int N = 7;
  private JFrame frame = new JFrame();
  private JPanel boardPanel = new JPanel();
  private GameButton[][] board = new GameButton[M][N];
  private ConnectFourModel model;
  public ConnectFourView(){
    
    GridLayout gridLayout = new GridLayout(M, N);
    boardPanel.setLayout(gridLayout);
    for (int i = 0; i < M; i++){
      for (int j = 0; j < N; j++){
        board[i][j] = new GameButton();
        boardPanel.add(board[i][j]);
      }
    }
    model = new ConnectFourModel(frame, board);
    model.setAvailable();
    
    
    frame.add(boardPanel);
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
