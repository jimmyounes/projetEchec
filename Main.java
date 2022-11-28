public class  Main{
    public static void main(String[] args) throws InterruptedException {
    	ChessUI ui = new ChessUI();
	GameUI g = new GameUI(ui, "boardConfigurationFiles/FullBoard.txt ", new Human(ui, ChessColor.WHITE), new ChessBot (ChessColor.BLACK));

	g.play ();

	}

}
