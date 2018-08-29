
public class Board{
	
	public char[][] board;
	private char player1;
	private char player2;
	private int rows;
	private int cols;
	
	Board() {	
	board = new char[6][7];
	for(int i = 0; i < 6; i++){
		for(int j = 0; j < 7; j++){
			board[i][j] = ' ';} 
		}
	}
	Board(int row, int col) {
		if(row < 0 || col < 0){
		row = 6;
		col = 7;}
	this.board = new char [row][col];
	for(int i = 0; i < row; i++){
		for(int j = 0; j < col; j++){
			board[i][j] = ' ';}
		}
	}
	public int getNumRows(){
		this.rows = board.length;
		return rows;
		}
	public int getNumCols(){
		this.cols = board[0].length;
		return cols;
		}
	
	public char getPlayerOne(){	
		return player1;
	} 
	public char getPlayerTwo(){	
		return player2;
	} 

	public void setPlayerOne(char o){	
		player1 = o;
	} 
	public void setPlayerTwo(char t){	
		player2 = t;
	} 

	public char getToken(int row, int col){	
		if(row >= this.board.length || col >= this.board[0].length || row < 0 || col < 0){
			return '\0';
		}
		char location = board[row][col];
			return location;
	}
	
	public boolean canPlay() {	
		if(isFull()==true){
		return false;}else
		return true;
	} 

	public boolean play(int p, int c) {	
		
		if((p !=1 && p != 2) || c < 0 || c >= board[0].length){
			return false;}
		if(p==1){
			for(int i = board.length-1; i >= 0; i--){
				if(board[i][c] == ' '){
					board[i][c] = player1;
					return true;
				}
			}
		}
		if(p==2){
			for(int i = board.length-1; i >= 0; i--){
				if(board[i][c] == ' '){
					board[i][c] = player2;
					return true;
				}
			}
		}
		return false;
	} 

	public int isFinished() {	
		if(checkHorizontal() != -1){
			return checkHorizontal();
		}else
			if(checkVertical() != -1){
				return checkVertical();
			}else
				if(checkDiagnolLeft() != -1){
					return checkDiagnolLeft();
				}else
					if(checkDiagnolRight() != -1){
						return checkDiagnolRight();
					}else
		if((checkHorizontal() == -1 && checkVertical() == -1 && checkDiagnolLeft() == -1 && checkDiagnolRight() == -1) && isFull() == true){
			return 0;}
		
		return -1;
	} 
	
	public int checkHorizontal(){
		
				int count = 0;
				for (int i = 0; i < board.length; i++){
					count = 0;
					for (int j = 0; j < board[i].length-1; j++){
						if(board[i][j]==board[i][j+1]){
							count++;
							if(count>=3){
								if(board[i][j] == player1){
									return 1;
								}else{
									if(board[i][j]== player2){
										return 2;
									}
								}
							}
						}else{
							count = 0;
						}
					}
				}
				return -1;
	}
	
	public int checkVertical(){
		for(int i = 0; i < board[0].length; i++){
			int count = 0;
			for(int j = 0; j < board.length-1 ; j++){
				if(board[j][i]==board[j+1][i]){
					count++;
					if(count>=3){
						if(board[j][i] == player1){
							return 1;
						}else{
							if(board[j][i]== player2){
								return 2;
							}
						}
					}
				}else{
					count = 0;
				}
			}
		}
		return -1;
	}
	
	public int checkDiagnolLeft(){
		int count = 0;
		
		for (int i = 0; i < board.length-3; i++) {
			count = 0;
			for (int j = i,k = 0; j < board.length-1 && k < board[0].length-1 ; j++, k++) {
				if(board[j][k] == board[j+1][k+1]){
					count++;
					if(count >= 3){
						if(board[j][k] == player1){
							return 1;
						}else{
							if(board[j][k] == player2){
								return 2;
							}
						}
					}
				}else{
					count = 0;
				}}	
			
		}
	
		for (int i = 0; i < board.length-3; i++) {
			count = 0;
			for (int j = i,k = board[i].length-1; j < board.length-1 && k > 0; j++, k--) {
				if(board[j][k] == board[j+1][k-1]){
					count++;
					if(count >= 3){
						if(board[j][k] == player1){
							return 1;
						}else{
							if(board[j][k] == player2){
								return 2;
							}
						}
					}
				}else{
					count = 0;
				}}	
			
		}
		
		
		
		return -1;
	}
	
	public int checkDiagnolRight(){
		int count = 0;
		
		for (int x = 1; x < board[0].length-3;x++) {
			count = 0;
			for (int y = 0, z = x; y < board.length-1 && z < board[0].length-1; z++,y++) {
				if(board[y][z] == board[y+1][z+1]){
					count++;
					if(count >= 3){
						if(board[y][z] == player1){
							return 1;
						}else{
							if(board[y][z] == player2){
								return 2;
							}
						}
					}
				}else{
					count = 0;
				}}
				
		}
		
		for (int x = board.length-2; x < board[0].length-3;x++) {
			count = 0;
			for (int y = 0, z = x; y < board.length-1 && z > 0; y++,z--) {
				if(board[y][z] == board[y+1][z-1]){
					count++;
					if(count >= 3){
						if(board[y][z] == player1){
							return 1;
						}else{
							if(board[y][z] == player2){
								return 2;
							}
						}
					}
				}else{
					count = 0;
				}}
				
		}
		
		return -1;
	}
	
	public boolean isFull(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j] == ' '){
					return false;}
				}
			}
		return true;
	}
	
	public void printBoard() {
        for (int row = 0; row < board.length; ++row) {
            System.out.print("| ");
            for (int col = 0; col < board[0].length; ++col)
                System.out.print(this.board[row][col] + "| ");
            System.out.println();
        }

        // Print bottom line
        for (int col = 0; col < board[0].length; ++col)
            System.out.print("---");
        System.out.println();
    }
}
