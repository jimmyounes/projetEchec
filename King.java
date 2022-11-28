import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(int x, int y, Player owner){
		super(x, y, owner);
		owner.setKing(this);
    }
    public List<Move> getAllMoves(Board board){
        List<Move> ListofMove=new ArrayList<> ();
        List<Coordinates> coordinatesallpoints=board.getAllCoordinates ();
        for(int i=0;i<coordinatesallpoints.size ();i++){
            if(isMoveAuthorized (board,coordinatesallpoints.get (i)))ListofMove.add(new Move(board,position,coordinatesallpoints.get (i)));
        }
        return ListofMove;
    }
    //verifier toutes les cases ou le roi peut se deplacer et voir si elles sont vides ou bien une piece adverses
    public boolean isMoveAuthorized(Board board, Coordinates destination){
        if (verifyMove (board,destination,0,1))return true;
        if (verifyMove (board,destination,0,-1))return true;
        if (verifyMove (board,destination,1,1))return true;
        if (verifyMove (board,destination,1,0))return true;
        if (verifyMove (board,destination,-1,1))return true;
        if (verifyMove (board,destination,1,-1))return true;
        if (verifyMove (board,destination,-1,0))return true;
        if (verifyMove (board,destination,-1,-1))return true;
        else return false;


    }

    public boolean verifyMove(Board board, Coordinates destination,int i,int j){
        if(position.getX ()+i==destination.getX () && position.getY ()+j==destination.getY () && position.getX ()+i<8 && position.getY ()+j<8 && position.getX ()+i>=0 && position.getY ()+j>=0 ){
            if(board.isEmptyCell (position.getX ()+i,position.getY ()+j) || !sameColor (board.getPiece (new Coordinates (position.getX ()+i,position.getY ()+j )))) return true;
        }
        return false;

    }
    @Override
    public Type getType() {
	return Type.KING;
    }

    @Override
    public int getValue() {
	return 0;
    }
    
}
