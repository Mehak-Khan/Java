/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.ics4u.u2;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

/**
 *
 * @author 1khanmeh3
 */
public class Game2040 extends javax.swing.JFrame {

    private static final Color[] COLOUR_BG = {
        new Color(205, 193, 180), // 0
        new Color(238, 228, 218), // 2
        new Color(237, 224, 200), // 4
        new Color(242, 177, 121), // 8
        new Color(245, 149, 99), // 16
        new Color(245, 149, 99), // 32
        new Color(246, 94, 59), // 64
        new Color(246, 94, 59), // 128
        new Color(237, 204, 97) // 256
    };

    private static final Color[] COLOUR_FONT = {
        new Color(205, 193, 180), // 0
        new Color(119, 110, 101), // 2
        new Color(119, 110, 101), // 4
        new Color(249, 246, 242), // 8
        new Color(249, 246, 242), // 16
        new Color(249, 246, 242), // 32
        new Color(249, 246, 242), // 64
        new Color(249, 246, 242), // 128
        new Color(249, 246, 242) // 256
    };

    private int[][] data;
    private JLabel[][] jLabels;
    private int score;

    /**
     * Creates new form Game2040
     */
    public Game2040() {
        initComponents();
        //SQUARE VALUES
        this.data = new int[4][4];

        //SQUARE LABELS
        this.jLabels = new JLabel[4][4];

        //ROW 0
        jLabels[0][0] = jLabel00;
        jLabels[0][1] = jLabel01;
        jLabels[0][2] = jLabel02;
        jLabels[0][3] = jLabel03;

        //ROW 1
        jLabels[1][0] = jLabel10;
        jLabels[1][1] = jLabel11;
        jLabels[1][2] = jLabel12;
        jLabels[1][3] = jLabel13;

        //ROW 2
        jLabels[2][0] = jLabel20;
        jLabels[2][1] = jLabel21;
        jLabels[2][2] = jLabel22;
        jLabels[2][3] = jLabel23;

        //ROW 3
        jLabels[3][0] = jLabel30;
        jLabels[3][1] = jLabel31;
        jLabels[3][2] = jLabel32;
        jLabels[3][3] = jLabel33;
        placeRandomTwo();
        updateGameBoard();
    }

    public void updateGameBoard() {
        jLabelGameOver.setVisible(false);
        int colourIndex = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                colourIndex = 0;
                if (this.data[i][j] != 0) {
                    this.jLabels[i][j].setText("" + this.data[i][j]);
                    colourIndex = (int) (Math.log(data[i][j]) / Math.log(2));
                } else {
                    this.jLabels[i][j].setText("");
                }
                this.jLabels[i][j].setForeground(COLOUR_FONT[colourIndex]);
                this.jLabels[i][j].setBackground(COLOUR_BG[colourIndex]);
                this.jLabelScore.setText("" + score);
            }
        }
    }

    public void placeRandomTwo() {
        for (int i = 0; i < 2;) {
            int row = (int) (Math.random() * data.length);
            int column = (int) (Math.random() * data.length);
            //System.out.println(column);   
            if (data[row][column] == 0) {
                data[row][column] = 2;
                i++;
            }
        }
    }

    public void placeOneRandomTwo() {
        for (int i = 0; i < 1;) {
            int row = (int) (Math.random() * data.length);
            int column = (int) (Math.random() * data.length);
            //System.out.println(column);   
            if (data[row][column] == 0) {
                data[row][column] = 2;
                i++;
            }
        }
    }

    public boolean shiftLeft() {
        boolean moved = false;
        for (int i = 0; i < data.length; i++) {
            for (int pass = 0; pass < data[i].length - 1; pass++) {
                for (int k = 1; k < data[i].length; k++) {
                    if (this.data[i][k - 1] == 0) {
                        this.data[i][k - 1] = this.data[i][k];
                        this.data[i][k] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    public boolean mergeLeft() {
        boolean moved = false;
        for (int i = 0; i < data.length; i++) {
            // for (int pass = 0; pass < data[i].length-1; pass++) {
            for (int k = 1; k < data[i].length; k++) {
                if (this.data[i][k - 1] == this.data[i][k]) {
                    this.data[i][k - 1] = 2 * this.data[i][k - 1];
                    this.data[i][k] = 0;
                    score += this.data[i][k - 1];
                    moved = true;
                }
            }

        }
        return moved;
    }

    public boolean shiftRight() {
        boolean moved = false;
        for (int i = 0; i < data.length; i++) {
            for (int pass = 0; pass < data[i].length - 1; pass++) {
                for (int k = data[i].length - 1; k > 0; k--) {
                    if (this.data[i][k] == 0) {
                        this.data[i][k] = this.data[i][k - 1];
                        this.data[i][k - 1] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    public boolean shiftDown() {
        boolean moved = false;
        for (int i = 1; i < data.length; i++) {
            for (int pass = 0; pass < data[i].length - 1; pass++) {
                for (int k = data[i].length - 1; k > -1; k--) {
                    if (this.data[i][k] == 0) {
                        this.data[i][k] = this.data[i - 1][k];
                        this.data[i - 1][k] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    public boolean shiftUp() {
        boolean moved = false;
        for (int k = 0; k < data.length; k++) {
            for (int pass = 0; pass < data[k].length - 1; pass++) {
                for (int i = 1; i < data.length; i++) {
                    if (this.data[i - 1][k] == 0) {
                        this.data[i - 1][k] = this.data[i][k];
                        this.data[i][k] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    public boolean mergeRight() {
        boolean moved = false;
        for (int i = 0; i < data.length; i++) {
            // for (int pass = 0; pass < data[i].length-1; pass++) {
            for (int k = data[i].length - 1; k > 0; k--) {
                if (this.data[i][k] == this.data[i][k - 1]) {
                    this.data[i][k] = 2 * this.data[i][k];
                    this.data[i][k - 1] = 0;
                    score += this.data[i][k];
                    moved = true;
                }
            }

        }
        return moved;
    }

    public boolean mergeDown() {
        boolean moved = false;
        for (int i = 1; i < data.length; i++) {
            // for (int pass = 0; pass < data[i].length-1; pass++) {
            for (int k = data[i].length - 1; k > -1; k--) {
                if (this.data[i][k] == this.data[i - 1][k]) {
                    this.data[i][k] = 2 * this.data[i][k];
                    this.data[i - 1][k] = 0;
                    score += this.data[i][k];
                    moved = true;
                }
            }

        }
        return moved;
    }

    public boolean mergeUp() {
        boolean moved = false;
        for (int i = 1; i < data.length; i++) {
            // for (int pass = 0; pass < data[i].length-1; pass++) {
            for (int k = 0; k < data[i].length; k++) {
                if (this.data[i - 1][k] == this.data[i][k]) {
                    this.data[i - 1][k] = 2 * this.data[i - 1][k];
                    this.data[i][k] = 0;
                    score += this.data[i - 1][k];
                    moved = true;
                }
            }

        }
        return moved;
    }

    public boolean gameOver() {
        boolean gameOver = true;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                //CHECK IF GAMEBOARD IS NOT EMPTY
                if (data[i][j] == 0) {
                    gameOver = false;
                }
            }
        }
        if (gameOver) {
                for (int k = 1; k < data.length-1; k++) {
                    for (int l = 1; l < data[k].length-1; l++) {
                        if (data[k][l] == data[k + 1][l]
                                || data[k][l] == data[k - 1][l]
                                || data[k][l] == data[k][l + 1]
                                || data[k][l] == data[k][l - 1]) {
                            gameOver = false;
                        }

                    }

                }
        }

                return gameOver;
            }

            /**
             * This method is called from within the constructor to initialize
             * the form. WARNING: Do NOT modify this code. The content of this
             * method is always regenerated by the Form Editor.
             */
            @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTop = new javax.swing.JPanel();
        jLabelScore = new javax.swing.JLabel();
        jLabelScoreName = new javax.swing.JLabel();
        jButtonNewGame = new javax.swing.JButton();
        jPanelMiddle = new javax.swing.JPanel();
        jLabelGameOver = new javax.swing.JLabel();
        jPanelBottom = new javax.swing.JPanel();
        jLabel00 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel01 = new javax.swing.JLabel();
        jLabel02 = new javax.swing.JLabel();
        jLabel03 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanelTop.setBackground(new java.awt.Color(255, 204, 204));

        jLabelScore.setBackground(new java.awt.Color(204, 204, 204));
        jLabelScore.setText("0");

        jLabelScoreName.setText("Score");

        jButtonNewGame.setText("New Game");
        jButtonNewGame.setFocusable(false);
        jButtonNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTopLayout = new javax.swing.GroupLayout(jPanelTop);
        jPanelTop.setLayout(jPanelTopLayout);
        jPanelTopLayout.setHorizontalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTopLayout.createSequentialGroup()
                        .addComponent(jLabelScoreName)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelScore, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonNewGame, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanelTopLayout.setVerticalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addGroup(jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelScore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelScoreName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNewGame)
                .addGap(0, 48, Short.MAX_VALUE))
        );

        jPanelMiddle.setBackground(new java.awt.Color(204, 204, 255));

        jLabelGameOver.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabelGameOver.setText("GAME OVER");

        javax.swing.GroupLayout jPanelMiddleLayout = new javax.swing.GroupLayout(jPanelMiddle);
        jPanelMiddle.setLayout(jPanelMiddleLayout);
        jPanelMiddleLayout.setHorizontalGroup(
            jPanelMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMiddleLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabelGameOver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        jPanelMiddleLayout.setVerticalGroup(
            jPanelMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMiddleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelGameOver, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanelBottom.setBackground(new java.awt.Color(204, 204, 204));

        jLabel00.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        jLabel00.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel00.setText("0,0");
        jLabel00.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel00.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel00.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel00.setOpaque(true);
        jLabel00.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel10.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("0,0");
        jLabel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel10.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel10.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel10.setOpaque(true);
        jLabel10.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel20.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("0,0");
        jLabel20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel20.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel20.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel20.setOpaque(true);
        jLabel20.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel30.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("0,0");
        jLabel30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel30.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel30.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel30.setOpaque(true);
        jLabel30.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel31.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("0,0");
        jLabel31.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel31.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel31.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel31.setOpaque(true);
        jLabel31.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel21.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("0,0");
        jLabel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel21.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel21.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel21.setOpaque(true);
        jLabel21.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel11.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("0,0");
        jLabel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel11.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel11.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel11.setOpaque(true);
        jLabel11.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel01.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        jLabel01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel01.setText("0,0");
        jLabel01.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel01.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel01.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel01.setOpaque(true);
        jLabel01.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel02.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        jLabel02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel02.setText("0,0");
        jLabel02.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel02.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel02.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel02.setOpaque(true);
        jLabel02.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel03.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        jLabel03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel03.setText("0,0");
        jLabel03.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel03.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel03.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel03.setOpaque(true);
        jLabel03.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel12.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("0,0");
        jLabel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel12.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel12.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel12.setOpaque(true);
        jLabel12.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel13.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("0,0");
        jLabel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel13.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel13.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel13.setOpaque(true);
        jLabel13.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel22.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("0,0");
        jLabel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel22.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel22.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel22.setOpaque(true);
        jLabel22.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel23.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("0,0");
        jLabel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel23.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel23.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel23.setOpaque(true);
        jLabel23.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel32.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("0,0");
        jLabel32.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel32.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel32.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel32.setOpaque(true);
        jLabel32.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel33.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("0,0");
        jLabel33.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel33.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel33.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel33.setOpaque(true);
        jLabel33.setPreferredSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout jPanelBottomLayout = new javax.swing.GroupLayout(jPanelBottom);
        jPanelBottom.setLayout(jPanelBottomLayout);
        jPanelBottomLayout.setHorizontalGroup(
            jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel00, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBottomLayout.setVerticalGroup(
            jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBottomLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanelBottomLayout.createSequentialGroup()
                            .addComponent(jLabel03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelBottomLayout.createSequentialGroup()
                            .addComponent(jLabel02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanelBottomLayout.createSequentialGroup()
                            .addComponent(jLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelBottomLayout.createSequentialGroup()
                            .addComponent(jLabel00, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelMiddle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanelMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanelBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        //setFocusable(true);
        System.out.print("KEY PRESSED: ");
        boolean moved = false;
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("UP");
                moved = shiftUp() || moved;
                moved = mergeUp() || moved;
                moved = shiftUp() || moved;
                updateGameBoard();
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("DOWN");
                moved = shiftDown() || moved;
                moved = mergeDown() || moved;
                moved = shiftDown() || moved;
                updateGameBoard();

                break;
            case KeyEvent.VK_LEFT:
                System.out.println("LEFT");
                moved = shiftLeft() || moved;
                moved = mergeLeft() || moved;
                moved = shiftLeft() || moved;
                updateGameBoard();
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("RIGHT");
                moved = shiftRight() || moved;
                moved = mergeRight() || moved;
                moved = shiftRight() || moved;
                updateGameBoard();
                break;

        }
        if (moved) {
            placeOneRandomTwo();
            updateGameBoard();
        }
        if (gameOver()) {
            System.out.println("game over");
            jLabelGameOver.setVisible(true);
        }
    }//GEN-LAST:event_formKeyPressed

    private void jButtonNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewGameActionPerformed
        //setFocusable(false);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
           data[i][j] = 0;     
            }
        }
        placeRandomTwo();
        updateGameBoard();
        //setFocusable(false);
    }//GEN-LAST:event_jButtonNewGameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game2040.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game2040.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game2040.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game2040.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game2040().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNewGame;
    private javax.swing.JLabel jLabel00;
    private javax.swing.JLabel jLabel01;
    private javax.swing.JLabel jLabel02;
    private javax.swing.JLabel jLabel03;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabelGameOver;
    private javax.swing.JLabel jLabelScore;
    private javax.swing.JLabel jLabelScoreName;
    private javax.swing.JPanel jPanelBottom;
    private javax.swing.JPanel jPanelMiddle;
    private javax.swing.JPanel jPanelTop;
    // End of variables declaration//GEN-END:variables
}
