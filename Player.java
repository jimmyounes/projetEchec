import java.util.ArrayList;
import java.util.List;

public abstract class Player{
    protected ChessColor color;
    private int score;
    private King king;
    public boolean isCheck;
    public boolean isCheckMate;

    public Player(ChessColor color){
        this.color=color;
isCheckMate=false;
isCheck=false;
score=0;
    }
    

    public ChessColor getColor(){
	return color;
    }

    public int getScore(){
      return score;

    }

    public void addToScore(int value){
        this.score=this.score+value;
    }
    
    public void removeFromScore(int value){
        this.score=this.score-value;
    }

    public abstract Move getMove(Board board);

    public abstract FromTo getFromTo(GameUI ui);

    public Piece getKing(){
	return king;
    }
    
    public void setKing(King king){
        this.king=king;
    }
    
    public boolean isCheckMate(Board board){
	isCheckMate=true;
	return true;
    }

    public void setCheck(){
        isCheck=true;
    }

    public void unSetCheck(){
      isCheck=false;
    }
    
    public List<Move> getAllMoves(Board board) {
        List<Move> ListofMoves=new ArrayList<> ();

       for(int i=0;i<8;i++){
          for(int j=0;j<8;j++){
              if(board.getPiece (i,j)!=null) {
                  if (board.getPiece (i, j).owner.equals (this)) {
                          for (int m=0; m != board.getPiece (i, j).getAllMoves (board).size (); m++) {
                              ListofMoves.add (board.getPiece (i, j).getAllMoves (board).get (m));

                      }
                  }
              }}
       }


       return ListofMoves;
       }



    @Override
    public String toString(){
	return null;
    }
}
