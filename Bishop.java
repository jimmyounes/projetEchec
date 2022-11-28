import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {


    public Bishop(int x, int y, Player owner) {
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
        List<Coordinates> pointsdiagonal=getpointsdiagonal (board);
        boolean verify=false;int i=0;
        //verifier si le point de la destination appartient a la diagonale de l'origine
       if(pointsdiagonal.contains (destination)) {
           if (board.sameDiagonalNothingBetween (position, destination) &&
                   ((board.isEmptyCell (destination) || !sameColor (board.getPiece (destination)))))
                   return true;

       }
        return false;

    }
    // avoir tous les points de la diagonale de la position du fou
    public List<Coordinates> getpointsdiagonal(Board board){
        List<Coordinates> Listpointsdiagonal=new ArrayList<> ();
      addpointleftlowdiagonal (Listpointsdiagonal,board);
      addpointLeftTopdiagonal (Listpointsdiagonal,board);
      addpointrightlowdiagonal (Listpointsdiagonal,board);
      addpointrightTopdiagonal (Listpointsdiagonal,board);
      return Listpointsdiagonal;
    }

    @Override
    public Type getType() {
        return Type.BISHOP;
    }

    @Override
    public int getValue() {
        return 3;
    }
public void addpointrightlowdiagonal(List<Coordinates> list,Board board){
        int i=position.getX ();
        int y=position.getY ();

        while(i<8 && y<8 && i>=0 && y>=0){

            i=i+1;
            y=y+1;
         if(i<8 && y<8 && i>=0 && y>=0)   list.add(new Coordinates (i,y));

    }

}

    public void addpointleftlowdiagonal(List<Coordinates> list,Board board){
        int i=position.getX ();
        int y=position.getY ();

        while(i<8 && y<8 && i>=0 && y>=0){

            i=i+1;
            y=y-1;
            if(i<8 && y<8 && i>=0 && y>=0)    list.add(new Coordinates (i,y));
        }
    }
    public void addpointrightTopdiagonal(List<Coordinates> list,Board board){
        int i=position.getX ();
        int y=position.getY ();

        while(i<8 && y<8 && i>=0 && y>=0){

            i=i-1;
            y=y+1;
            if(i<8 && y<8 && i>=0 && y>=0)   list.add(new Coordinates (i,y));
        }

    }
    public void addpointLeftTopdiagonal(List<Coordinates> list,Board board){
        int i=position.getX ();
        int y=position.getY ();

        while(i<8 && y<8 && i>=0 && y>=0){

            i=i-1;
            y=y-1;
            if(i<8 && y<8 && i>=0 && y>=0)   list.add(new Coordinates (i,y));
        }
    }
}
