public class ConnectFour{
	
	public static void main(String[] args){
		
		//Create new board object
		Board b1 = new Board (6,7);
		CFGUI a = new CFGUI(b1, ChipColor.RED, ChipColor.BLUE);
		//Set player tokens for player 1 and player 2
		b1.setPlayerOne('x');
		b1.setPlayerTwo('o');
		//Create Player objects
		
		//Note, the code below works because of the interface Player. All classes that "implement" Player can be
		// typed as Player. Makes switching from Human to AI Players really easy. For a challenge, you might
		// consider:
		//		1. asking the user whether he/she wants to play against a human or a computer
		//		2. implementing multiple AI players (easy, med, hard) that the user can choose to play against
		
		Player p1 = new HumanPlayer(1,6,7);

		Player p2 = new HumanPlayer(1,6,7); //comment this line when testing AIPlayer
	
		//Player p2 = new AIPlayer(2,6,7); //uncomment this line when testing AIPlayer
	

		//Print your empty board
		b1.printBoard();
		
		//WHILE the board is still playable
		//	get a column to play from player 1
		//	play that token on the board
		//  print the board
		//		has anyone won yet?
		    while(b1.canPlay() == true){
		    	if(b1.isFinished() != -1){
		    		break;}
		    	int c= p1.playToken();
		    	b1.play(1, c);
		    	a.redraw();
		    	b1.printBoard();
		    	p2.lastMove(c);
		    	//a.redraw();
		    	if(b1.isFinished() != -1){
		    		break;}
		    	
		    	//int c2 = IO.readInt();
		    	int c2 = p2.playToken();
		    	b1.play(2,c2);
		    	a.redraw();
		    	b1.printBoard();
		    	p1.lastMove(c2);
		    	//a.redraw();
		    	
		    	
		    }
		// do the above for player 2
		
		// Get the status code from the board (isFinished())
		   
		// Print out the results of the game
		// System.out.println("Player "+b1.isFinished() + " won!");
		   a.gameOver(b1.isFinished());
		   //GIO.readBoolean("Do you want to play another round?");
		   if(GIO.readBoolean("Do you want to play another round?") == true){
			   main(args);
		   }
		   a.close(); 
	}
	
	
	
}