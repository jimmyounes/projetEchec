import java.io.*;
import java.util.Scanner;

public class TestChess{

	public static void main(String[] args) {
	    
	    boolean result;

	    /* Test du mouvement de la tour */

		System.out.println("TEST  des mouvements de la Tour ");
		System.out.print("test 1 (Tour) : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt",new Coordinates(0,0), new Coordinates(0,1));
		if(!result) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 2 (Tour) : ");
		result = testAuthorizedMove("boardConfigurationFiles/Testpiece.txt",new Coordinates(0,4), new Coordinates(0,6));
		if(result) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 3 (Tour) : ");
		result = testAuthorizedMove("boardConfigurationFiles/Testpiece.txt",new Coordinates(0,4), new Coordinates(7,4));
		if(result) System.out.println("pass"); else System.out.println("fail");

/*Test du mouvement du calavier */
		System.out.println("Test du movement du cavalier");
		System.out.print("test 1(cavalier) : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt",new Coordinates(1,0), new Coordinates(0,2));
		if(result) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 2(cavalier) : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt",new Coordinates(1,0), new Coordinates(2,2));
		if(result) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 2(cavalier) : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt",new Coordinates(1,0), new Coordinates(2,2));
		if(result) System.out.println("pass"); else System.out.println("fail");

// Test du mouvement du fou
		System.out.println("Test du movement du fou");
		System.out.print("test 1(fou) : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt",new Coordinates(2,0), new Coordinates(1,1));
		if(!result) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 2(fou) : ");
		result = testAuthorizedMove("boardConfigurationFiles/Testpiece.txt",new Coordinates(6,5), new Coordinates(2,1));
		if(!result) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 3(fou) : ");
		result = testAuthorizedMove("boardConfigurationFiles/Testpiece.txt",new Coordinates(6,5), new Coordinates(3,2));
		if(result) System.out.println("pass"); else System.out.println("fail");
// test du mouvement du Roi
		System.out.println("Test du movement du Roi");

		System.out.print("test 1(Roi) : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt",new Coordinates(3,0), new Coordinates(3,1));
		if(!result) System.out.println("pass"); else System.out.println("fail");
		System.out.print("test 2(Roi) : ");
		result = testAuthorizedMove("boardConfigurationFiles/KingsOnly.txt",new Coordinates(3,0), new Coordinates(3,1));
		if(result) System.out.println("pass"); else System.out.println("fail");
		System.out.print("test 3(Roi) : ");
		result = testAuthorizedMove("boardConfigurationFiles/kingsOnly.txt",new Coordinates(3,0), new Coordinates(2,1));
		if(result) System.out.println("pass"); else System.out.println("fail");


// test du mouvement du la Queen
		System.out.println("Test du movement de la queen ");
		System.out.print("test 1(queen ) : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt",new Coordinates(4,0), new Coordinates(4,1));
		if(!result) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 2(queen ) : ");
		result = testAuthorizedMove("boardConfigurationFiles/Testpiece.txt",new Coordinates(2,4), new Coordinates(0,4));
		if(result) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 3(queen ) : ");
		result = testAuthorizedMove("boardConfigurationFiles/Testpiece.txt",new Coordinates(2,4), new Coordinates(0,6));
		if(!result) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 4(queen ) : ");
		result = testAuthorizedMove("boardConfigurationFiles/Testpiece.txt",new Coordinates(2,4), new Coordinates(5,1));
		if(result) System.out.println("pass"); else System.out.println("fail");


	    /* Test de déplacements autorisés selon les regles de pièces */
		System.out.println("authorized moves");
	    System.out.print("test 1 : ");
	    result = testAuthorizedMove("boardConfigurationFiles/Testpiece.txt",new Coordinates(0,4), new Coordinates(2,4));
	    if(result) System.out.println("pass"); else System.out.println("fail");
	    
	    System.out.print("test 2 : ");
	    result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt", new Coordinates(0,1), new Coordinates(0,4));
	    if(!result) System.out.println("pass"); else System.out.println("fail");
	    
	    
	    //  Test de déplacements jouables sur l'échiquier actuel, selon les regles du jeu
	    System.out.println("playable moves");
	    System.out.print("test 1 : ");
	    result = testPlayableMove("boardConfigurationFiles/FullBoard.txt",new Coordinates(0,1),new Coordinates(0,2));

	    if(result ) System.out.println("pass"); else System.out.println("fail");

	    System.out.print("test 2 : ");
	    result = testPlayableMove("boardConfigurationFiles/FullBoard.txt",new Coordinates(0,1),new Coordinates(0,3));
	    if(result ) System.out.println("pass"); else System.out.println("fail");
	    
	    /*  Tests de la mise en echec */

	System.out.println("test mise en echecs  ");
	System.out.print("test1(mise en echecs) ");
	result =testwhiteIsCheck  ("boardConfigurationFiles/FullBoard.txt");
	if (!result) System.out.println("pass "); else System.out.print ("fail ");

	//test de la mise en checs du fichier Testpiece
		System.out.print("test2(mise en echecs) ");
		result =testwhiteIsCheck  ("boardConfigurationFiles/Testpiece.txt");
		if (result) System.out.println("pass "); else System.out.print ("fail ");



	    /*  Tests de la Echec et mat "isCheckMate()" */
	 System.out.println("Test mise en echec et mate ");
	  System.out.print ("test1 (echecs et mat)");
	    result=testWhiteIsCheckMate ("boardConfigurationFiles/FullBoard.txt");
		if (!result) System.out.println("pass"); else System.out.println ("fail ");

		System.out.print("test2 (checs et mat)");;
		result=testWhiteIsCheckMate ("boardConfigurationFiles/Testpiece.txt");
		if (!result) System.out.println("pass"); else System.out.println ("fail ");

		System.out.print("test3 (checs et mat)");;
		result=testWhiteIsCheckMate ("boardConfigurationFiles/echecetmat.txt");
		if (result) System.out.println("pass"); else System.out.println ("fail ");






	    /*  Tests pours le calcul des points en fin de partie */

	//
	//	testgetallmoves ("boardConfigurationFiles/Testpiece.txt");
    }


    
    public static boolean testAuthorizedMove(String filename, Coordinates origin, Coordinates destination) {    			
	ChessUI ui = new ChessUI();
	Board testBoard = new Board(filename, new Human(ui, ChessColor.WHITE), new Human(ui, ChessColor.BLACK));
	Piece testPiece = testBoard.getPiece(origin);

	if(testPiece == null) {
	    System.out.println("No Piece at :"+origin); 
	    return false;
	}

	return testPiece.isMoveAuthorized(testBoard, destination);
    }



	public static boolean testPlayableMove(String fileName, Coordinates origin, Coordinates destination) {
	ChessUI ui = new ChessUI();
	GameUI g = new GameUI(ui, fileName, new Human(ui, ChessColor.WHITE), new Human(ui, ChessColor.BLACK));
	
	Piece testPiece = g.getBoard().getPiece(origin);
	if(testPiece == null) {
	    System.out.println("No Piece at :"+origin); 
	    return false;
	}

	return g.isMovePlayable(new Move(g.getBoard(), origin, destination));
    }

    public static boolean testwhiteIsCheck(String fileName) {
	ChessUI ui = new ChessUI();
	Player playerwhite=new Human(ui, ChessColor.WHITE);
	Player playerBlack=new Human(ui, ChessColor.BLACK);
	GameUI g = new GameUI(ui, fileName,playerwhite,playerBlack);

	return g.isCheck(playerwhite);
    }
public static boolean testblackIscheck(String fileName){
	ChessUI ui = new ChessUI();
	Player playerwhite=new Human(ui, ChessColor.WHITE);
	Player playerBlack=new Human(ui, ChessColor.BLACK);
	GameUI g = new GameUI(ui, fileName,playerwhite,playerBlack);
System.out.println (playerwhite.getAllMoves (g.board));
	return g.isCheck(playerBlack);
}
    public static boolean testWhiteIsCheckMate(String fileName) {
	ChessUI ui = new ChessUI();
		Player playerwhite=new Human(ui, ChessColor.WHITE);
		Player playerBlack=new Human(ui, ChessColor.BLACK);
		GameUI g = new GameUI(ui, fileName,playerwhite,playerBlack);
	return g.isCheck(playerwhite) && g.isCheckMate(playerwhite);
    }

	public static boolean testBlackIsCheckMate(String fileName) {
		ChessUI ui = new ChessUI();
		Player playerwhite=new Human(ui, ChessColor.WHITE);
		Player playerBlack=new Human(ui, ChessColor.BLACK);
		GameUI g = new GameUI(ui, fileName,playerwhite,playerBlack);
		return g.isCheck(playerBlack) && g.isCheckMate(playerBlack);
	}
	public static void testgetallmoves(String fileName){
		ChessUI ui = new ChessUI();
		Player playerwhite=new Human(ui, ChessColor.WHITE);
		Player playerBlack=new Human(ui, ChessColor.BLACK);
		GameUI g = new GameUI(ui, fileName,playerwhite,playerBlack);
		for(Move move : playerwhite.getAllMoves (g.board)){
			System.out.println (move);
		}
	}
}

