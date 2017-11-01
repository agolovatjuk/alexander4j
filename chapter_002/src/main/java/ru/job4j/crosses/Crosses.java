package ru.job4j.crosses;

public class Crosses {
    int win;
    char[][] board;

    public Crosses(int n) {
        board = new char[n][n];
        win = 3;
    }

    public Crosses(int n, int w) {
        board = new char[n][n];
        win = w;
    }

    public boolean putA(int i, int j, char a) {
        if (board[i][j] == '\u0000') {
            board[i][j] = a;
        }
        if (checkWinA(i, j, a)) {
            return true;
        }
        return false;
    }

    public boolean getA(int i, int j, char a) {
        try {
            if (board[i][j] == a) {
                return true;
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    int getHoriz(int i, int j, char a) {
        int cnt = 0;
        int x = j;
        while (getA(i, x--, a)) {
            cnt++;
        }
        x = j;
        while (getA(i, ++x, a)) {
            cnt++;
        }
        return cnt;
    }

    int getVert(int i, int j, char a) {
        int cnt = 0;
        int y = i;
        while (getA(y--, j, a)) {
            cnt++;
        }
        y = i;
        while (getA(++y, j, a)) {
            cnt++;
        }
        return cnt;
    }

    int getLine45(int i, int j, char a) {
        int cnt = 0;
        int x = j;
        int y = i;
        while (getA(y--, x--, a)) {
            cnt++;
        }
        x = j;
        y = i;
        while (getA(++y, ++x, a)) {
            cnt++;
        }
        return cnt;
    }

    int getLine135(int i, int j, char a) {
        int cnt = 0;
        int x = j;
        int y = i;
        while (getA(y++, x--, a)) {
            cnt++;
        }
        x = j;
        y = i;
        while (getA(--y, ++x, a)) {
            cnt++;
        }
        return cnt;
    }

    public boolean checkWinA(int i, int j, char a) {
        int vert = getVert(i, j, a);
        int horiz = getHoriz(i, j, a);
        int line45 = getLine45(i, j, a);
        int line135 = getLine135(i, j, a);
        if (vert >= win || horiz >= win || line45 >= win || line135 >= win) {
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

    public static void main(String[] args) {
        int n = 10; // board 10x10
        boolean w;
        Crosses c = new Crosses(n);
        w = c.putA(1, 2, 'Y');
        w = c.putA(1, 4, 'X');
        w = c.putA(1, 3, 'Y');
        w = c.putA(2, 4, 'X');
        c.display();
        if (!w) {
            System.out.println(String.format("X is not Winner"));
        }
        w = c.putA(1, 1, 'Y');
        if (w) {
            System.out.println(String.format("Y is Winner"));
        }
        w = c.putA(3, 4, 'X');
        if (w) {
            System.out.println(String.format("X is Winner now"));
        }

        w = c.putA(6, 3, 'Z');
        w = c.putA(7, 4, 'Z');
        w = c.putA(5, 2, 'Z');
        if (w) {
            System.out.println(String.format("Z is Winner now"));
        }
        c.display();
    }

}
