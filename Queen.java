import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    public Queen(int x, int y, Player owner) {
        super (x, y, owner);
    }
   public List<Move> getAllMoves(Board board){
       List<Move> ListofAllmoves =new ArrayList<> ();
       List<Coordinates> allpoints=board.getAllCoordinates ();
       for(int i=0;i<allpoints.size ();i++){
           if(isMoveAuthorized (board,allpoints.get (i))){
               ListofAllmoves.add (new Move(board,position,allpoints.get (i)));

           }
       }
return ListofAllmoves;


    }
//la dame est une fusion entre la tour et le fou donc on fait aussi une fusion de mouvements entre les deux
    @Override
    public boolean isMoveAuthorized(Board board, Coordinates destination) {
        Bishop bishop =new Bishop (position.getX (),position.getY (),owner);
        Rook rook=new Rook(position.getX (),position.getY (),owner);
    if((bishop.isMoveAuthorized (board,destination) || rook.isMoveAuthorized (board, destination))  ) return true;
    return false;
    }

    @Override
    public Type getType() {
        return Type.QUEEN;
    }

    @Override
    public int getValue() {
        return 9;
    }
}
