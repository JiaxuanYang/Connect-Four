public class HumanPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	private int playerIDs;
	private int rows;
	private int cols;
	Board b;
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public HumanPlayer(int playerID, int row, int col){
		this.playerIDs = playerID;
		this.rows = row;
		this.cols = col;
		b = new Board (row,col);
		
	}
	
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {
		int ID = 1;
		if(playerIDs == 1 ){
			ID = 2;
		}else{
			if(playerIDs == 2){
				ID = 1;}
	}
		
				this.b.play(ID,c);	
		
	}
	
	//returns column of where to play a token
	public int playToken(){
		int column;
		do{
			//System.out.println("Enter column numbers: ");
			column = GIO.readInt("Enter column numbers: ");
			
			//b.play(playerIDs,column);
		}while(this.b.play(playerIDs,column) == false);
		
		
		return column;
	}
	
	//get this player's id
	public int getPlayerID(){
		return playerIDs;
	}
	
	//resets the state of the player in preparation for a new game
	public void reset(){
		b = new Board(rows,cols);
}
}
