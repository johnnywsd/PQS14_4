package com.shoudaw.pqs14_4.connect_four;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ConnectFourView implements ActionListener{
  private static final int M = 6;
  private static final int N = 7;
  private JFrame frame = new JFrame();
  private JPanel boardPanel = new JPanel();
  private GameButton[][] board = new GameButton[M][N];
  private ConnectFourModel model;
  private JRadioButton singlePlayRadioBtn= new JRadioButton("Single Play");
  private JRadioButton doublePlayRadioBtn= new JRadioButton("Double Play");
  private ButtonGroup playModeBtnGroup = new ButtonGroup();
  private JPanel playModePanel = new JPanel();
  private Container mainPanel;
  public ConnectFourView(){
    singlePlayRadioBtn.addActionListener(this);
    doublePlayRadioBtn.addActionListener(this);
    playModeBtnGroup.add(singlePlayRadioBtn);
    playModeBtnGroup.add(doublePlayRadioBtn);
    playModePanel.add(singlePlayRadioBtn);
    playModePanel.add(doublePlayRadioBtn);
    singlePlayRadioBtn.setSelected(true);
    playModePanel.setLayout(new FlowLayout());
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
    
    mainPanel = frame.getContentPane();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    mainPanel.add(playModePanel);
    playModePanel.setPreferredSize(new Dimension(300, 50));
    playModePanel.setMaximumSize(new Dimension(300, 50));
    mainPanel.add(boardPanel);
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    JRadioButton source = (JRadioButton) e.getSource();
    if (source == this.singlePlayRadioBtn){
      model.changePlayMode(PlayMode.SINGLE);
    }else if (source == this.doublePlayRadioBtn){
      model.changePlayMode(PlayMode.DOUBLE);
    }
    
  }
}
