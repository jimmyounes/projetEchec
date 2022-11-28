import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook(int x, int y, Player owner) {
        super (x, y, owner);
    }

    public List<Move> getAllMoves(Board board) {
        List<Move> ListofMove=new ArrayList<> ();
        List<Coordinates> coordinatesallpoints=board.getAllCoordinates ();
        for(int i=0;i<coordinatesallpoints.size ();i++){
            if(isMoveAuthorized (board,coordinatesallpoints.get (i)))ListofMove.add(new Move(board,position,coordinatesallpoints.get (i)));
        }
        return ListofMove;
    }

    @Override
    public boolean isMoveAuthorized(Board board, Coordinates destination) {
     if(position.getX ()==destination.getX ()){
         if(board.sameRowNothingBetween (position,destination) &&  board.isEmptyCell (destination)) return true;

         if(board.sameRowNothingBetween (position,destination)  && !sameColor (board.getPiece (destination) ))return true;
     }
     if(position.getY ()==destination.getY ()){
         if(board.sameColumnNothingBetween (position,destination) && board.isEmptyCell (destination)){return true;}
         if(  board.sameColumnNothingBetween (position,destination)  && !sameColor (board.getPiece (destination))) return true;
     }
    return false;
    }

    @Override
    public Type getType() {
        return Type.ROOK;
    }

    @Override
    public int getValue() {
        return 5;
    }



}