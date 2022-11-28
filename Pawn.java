import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn(int x, int y, Player owner) {
        super (x, y, owner);
    }
@Override
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
        int i=position.getX (); int j=destination.getX (); int direction;
        int y=position.getY (); int k=destination.getY (); int direction2;
        //si le pawn est a l'etat initiale il peut se deplacer de deux cases
        if(owner.color==ChessColor.WHITE){
            if(position.equals (new Coordinates (0,1)) ||position.equals (new Coordinates (1,1))||position.equals (new Coordinates (2,1))||position.equals (new Coordinates (3,1))||position.equals (new Coordinates (4,1))||position.equals (new Coordinates (5,1))||position.equals (new Coordinates (6,1)) || position.equals (new Coordinates (7,1))){
                if(destination.getX ()==position.getX () && destination.getY ()==position.getY ()+2 && board.isEmptyCell (destination.getX () ,destination.getY ())) return true;
            }
        }
        if (owner.color==ChessColor.BLACK){
            if(position.equals (new Coordinates (0,6)) ||position.equals (new Coordinates (1,6))||position.equals (new Coordinates (2,6))||position.equals (new Coordinates (3,6))||position.equals (new Coordinates (4,6))||position.equals (new Coordinates (5,6))||position.equals (new Coordinates (6,6)) || position.equals (new Coordinates (7,6))){
                if(destination.getX ()==position.getX () && destination.getY ()==position.getY ()-2 && board.isEmptyCell (destination.getX () ,destination.getY () )) return true;
            }

        }
        //tous les mouvement que le pion peut se deplacer a l'état normal
        if(owner.color==ChessColor.WHITE){ direction=1;direction2=-1; }
        else{ direction=-1; direction2=1;}

        if ( y+direction<8 && y+direction>=0 && i==j && y+direction==k &&   board.isEmptyCell (i , y+direction) == true)
           return true;
        if (i+direction<8 && y+direction<8 &&  i+direction==j && y+direction==k &&  y+direction>=0 && i+direction>=0 &&   board.isEmptyCell (i +direction, y +direction ) == false) {
            if (sameColor (board.getPiece (i +direction, y+direction)) == false)
                return true;
        }
        if (  i+direction2==j && y+direction==k && i+direction2<8 && y+direction<8 && y+direction>=0 && i+direction2>=0  &&   board.isEmptyCell (i +direction2, y + direction) == false) {
            if (sameColor (board.getPiece (i +direction2, y +direction)) == false)
                return true;
        }
     return false;

    }

    @Override
    public Type getType() {
        return Type.PAWN;
    }

    @Override
    public int getValue() {
        return 1;
    }
}
