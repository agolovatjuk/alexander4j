package ru.job4j.crosses;

import java.util.Scanner;

public class Crosses {
    char[][] board;
    int winline = 3;

    public Crosses(int n) {
        board = new char[n][n];
    }

    public Crosses(int n, int w) {
        board = new char[n][n];
        winline = w;
    }

    public boolean putA(int i, int j, char a) {
        try {
            if (board[i][j] == '\u0000') {
                board[i][j] = a;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return checkWinnerA(i, j, a);
    }

    public boolean getA(int i, int j, char a) {
        try {
            return (board[i][j] == a);
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    int getHoriz(int i, int j, char a) {
        int cnt = 0;
        for (int x = j; getA(i, x--, a);) {
            cnt++; }
        for (int x = j; getA(i, ++x, a);) {
            cnt++; }
        return cnt;
    }

    int getVert(int i, int j, char a) {
        int cnt = 0;
        for (int y = i; getA(y--, j, a);) {
            cnt++; }
        for (int y = i; getA(++y, j, a);) {
            cnt++; }
        return cnt;
    }

    int getLine45(int i, int j, char a) {
        int cnt = 0;
        for (int x = j, y = i; getA(y--, x--, a);) {
            cnt++; }
        for (int x = j, y = i; getA(++y, ++x, a);) {
            cnt++; }
        return cnt;
    }

    int getLine135(int i, int j, char a) {
        int cnt = 0;
        for (int x = j, y = i; getA(y++, x--, a);) {
            cnt++; }
        for (int x = j, y = i; getA(--y, ++x, a);) {
            cnt++; }
        return cnt;
    }

    public boolean checkWinnerA(int i, int j, char a) {
        int vert = getVert(i, j, a);
        int horiz = getHoriz(i, j, a);
        int line45 = getLine45(i, j, a);
        int line135 = getLine135(i, j, a);
        if (vert >= winline || horiz >= winline || line45 >= winline || line135 >= winline) {
            return true;
        }
        return false;
    }

    private void display() {
        int p = (int) Math.log10(this.board.length) + 1;
        String fs = "%" + p + "s|";
        String fd = "%0" + p + "d|";
        String t = "_";
        for (int k = 0; k < p - 1; k++) {
            t = t + "_";
        }
        System.out.printf(fs, " ");
        for (int i = 0; i < this.board.length; i++) {
            System.out.printf(fd, i);
        }
        System.out.println();
        for (int i = 0; i < this.board.length; i++) {
            System.out.printf(fd, i);
            for (int j = 0; j < this.board[i].length; j++) {
                if (board[i][j] == '\u0000') {
                    System.out.printf("%s|", t);
                } else {
                    System.out.printf(fs, this.board[i][j]);
                }
            }
            System.out.println();
        }
    }

    public void game(int win) {
        this.winline = win;
        this.game();
    }

    public void game() {
        Scanner scanner = new Scanner(System.in);
        boolean winner = false;
        char symb = '\u0000';
        int p = (int) Math.log10(board.length) + 1;
        while (!winner) {
            display();
            System.out.print("Enter your Symbol, row number, col number [for example: x34] or Ctrl-C to exit:");
            String answer = scanner.nextLine();
            try {
                symb = answer.charAt(0);
                int row = Integer.parseInt(answer.substring(1, p + 1));
                int col = Integer.parseInt(answer.substring(p + 1));
                winner = putA(row, col, symb);
            } catch (NumberFormatException e) {
                System.out.println("Error in enter data, next try...");
            }
        }
        display();
        System.out.printf("%s is winner, good by%n", symb);
    }

    public static void main(String[] args) {

        int n = 8; // board 8x8
        int winner = 3; // 3 is winner
        System.out.print("Enter board size[NxN] N:");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.length() != 0) {
            n = Integer.parseInt(answer);
        }
        Crosses c = new Crosses(n);
        System.out.print("Enter how much symbols per line to win(default 3):");
        answer = scanner.nextLine();
        if (answer.length() != 0) {
            winner = Integer.parseInt(answer);
        }
        c.game(winner);
    }

}
