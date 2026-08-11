class Solution {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0;
        int oCount = 0;

        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') xCount++;
                if (c == 'O') oCount++;
            }
        }

        if (xCount < oCount || xCount > oCount + 1) {
            return false;
        }

        boolean xWins = wins(board, 'X');
        boolean oWins = wins(board, 'O');

        if (xWins && oWins) {
            return false;
        }

        if (xWins && xCount != oCount + 1) {
            return false;
        }

        
        if (oWins && xCount != oCount) {
            return false;
        }

        return true;
    }

    private boolean wins(String[] board, char player) {

    
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player &&
                board[i].charAt(1) == player &&
                board[i].charAt(2) == player) {
                return true;
            }
        }

    
        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == player &&
                board[1].charAt(j) == player &&
                board[2].charAt(j) == player) {
                return true;
            }
        }

        // Diagonal
        if (board[0].charAt(0) == player &&
            board[1].charAt(1) == player &&
            board[2].charAt(2) == player) {
            return true;
        }

        
        if (board[0].charAt(2) == player &&
            board[1].charAt(1) == player &&
            board[2].charAt(0) == player) {
            return true;
        }

        return false;
    }
}
    
