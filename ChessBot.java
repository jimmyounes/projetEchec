import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChessBot extends Player {

    public ChessBot(ChessColor color) {
        super (color);

    }

    @Override
    public Move getMove(Board board) {
        return null;
    }

    @Override
    public FromTo getFromTo(GameUI ui) {

        List<Move> MaxpointList=new ArrayList ();
        int max=0;
        for (Move move : getAllMoves (ui.board)) {
            if (move.pieceAtDestination != null ) max=move.pieceAtDestination.getValue ();
        }
        List<Move> listmovefinal=new ArrayList ();
        //si le chessbot n'est pas en echecs on prend le meilleur coup
        if (max != 0 && !ui.isCheck (this)) {
            for (Move move : getAllMoves (ui.board)) {
                if (move.pieceAtDestination != null && move.pieceAtDestination.getValue () == max)
                    listmovefinal.add (move);
            }
            //si la taille elle est egale a 1 on envoie le premier element
            if (listmovefinal.size () == 1)
                return new FromTo (listmovefinal.get (0).pieceAtOrigin.getX (), listmovefinal.get (0).pieceAtOrigin.getY (), listmovefinal.get (0).destination.getX (), listmovefinal.get (0).destination.getY ());
          //sinon on choisit un element aleatoirement
            else {
                int rand;
                Random random=new Random ();
                rand=random.nextInt (listmovefinal.size ());
                return new FromTo (listmovefinal.get (rand).pieceAtOrigin.getX (), listmovefinal.get (rand).pieceAtOrigin.getY (), listmovefinal.get (rand).destination.getX (), listmovefinal.get (rand).destination.getY ());
            }
        }

        else {
            for (Move move :getAllMoves (ui.board)){
             listmovefinal.add(move);
            }
            int rand;
            Random random=new Random ();
            rand=random.nextInt (listmovefinal.size ());
            return new FromTo (listmovefinal.get (rand).pieceAtOrigin.getX (), listmovefinal.get (rand).pieceAtOrigin.getY (), listmovefinal.get (rand).destination.getX (), listmovefinal.get (rand).destination.getY ());
        }



    }
    }

