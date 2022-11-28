public class Human extends Player{

    ChessUI ui;
    public Human(ChessUI ui, ChessColor color){
        super(color);
        this.ui = ui;
    }



    @Override
    public Move getMove(Board board) {
        return new Move(board,ui.waitForPlayerMove ());

    }

    @Override
    public FromTo getFromTo(GameUI game) {
        return ui.waitForPlayerMove();
    }
    
}
