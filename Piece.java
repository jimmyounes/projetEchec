import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Piece{
    protected Coordinates position;
    protected Player owner;

    
    public Piece(int x, int y, Player owner){
        position=new Coordinates (x,y);
      this.owner=owner;
    }

    public enum Type {
        KING,
        QUEEN,
        ROOK,
        BISHOP,
        KNIGHT,
        PAWN
    }

    public void setPosition(Coordinates destination){
    position.setX (destination.getX ());
    position.setY (destination.getY ());
    }
    
    public Player getOwner(){
	return owner;
    }

    public ChessColor getColor(){
	return owner.color;
    }

    public Coordinates getPosition(){
	return position;
    }

    public int getX(){
	return position.getX ();
    }
    
    public int getY(){
	return position.getY ();
    }

    public List<Move> getAllMoves(Board board) {
	return null;
    }

    public boolean sameColor(Piece piece){
	if (piece.owner.getColor ()==owner.getColor ())return true;
	else return false;
    }

    public abstract boolean isMoveAuthorized(Board board, Coordinates destination);

    public abstract Type getType();
    public abstract int getValue();
    

}
