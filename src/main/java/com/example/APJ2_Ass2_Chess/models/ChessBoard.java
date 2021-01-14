package com.example.APJ2_Ass2_Chess.models;

import javax.swing.*;
import java.awt.*;

public class ChessBoard {

    JFrame frame;
    JPanel squares[][] = new JPanel[8][8];

    public void board2() {
        frame = new JFrame("Chess on Java by Dariya and Talgat");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(8, 8));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new JPanel();
            }
        }


        squares[0][0].add(new JLabel(new ImageIcon("imges/ladya.jpg")));
        squares[0][1].add(new JLabel(new ImageIcon("imges/kon'.jpg")));
        squares[0][2].add(new JLabel(new ImageIcon("imges/slon.jpg")));
        squares[0][3].add(new JLabel(new ImageIcon("imges/queen.jpg")));
        squares[0][4].add(new JLabel(new ImageIcon("imges/king.jpg")));

        squares[7][0].add(new JLabel(new ImageIcon("rookred.png")));
        squares[7][2].add(new JLabel(new ImageIcon("bishopred.png")));
        squares[7][4].add(new JLabel(new ImageIcon("kingred.png")));
        squares[7][5].add(new JLabel(new ImageIcon("bishopred.png")));
        squares[7][7].add(new JLabel(new ImageIcon("imges/slon.png")));

        for (int i = 0; i < 8; i++) {
            squares[1][i].add(new JLabel(new ImageIcon("imges/peshka.jpg")));
            squares[6][i].add(new JLabel(new ImageIcon("imges/peshka_b.jpg")));
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if ((i + j) % 2 == 0) {
                    squares[i][j].setBackground(Color.black);
                } else {
                    squares[i][j].setBackground(Color.white);
                }
                frame.add(squares[i][j]);
            }
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new ChessBoard().board2();
    }
}
