import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.lang.Thread.sleep;


public class GameUI {
    public Board board;
    private Player white;
    private Player black;
    private Player currentPlayer;
    private ChessUI ui;
    private Stack<Move> history;

    public GameUI(ChessUI ui, String boardConfigFileName, Player white, Player black) {
        this.board=new Board (boardConfigFileName, white, black);
        this.white=white;
        this.black=black;
        this.currentPlayer=white;
        this.ui=ui;
        this.history=new Stack<Move> ();

        for (Piece p : board.getPieces ())
            this.ui.placePiece (p.getType (), p.getColor (), p.getPosition ());
    }

    public Board getBoard() {
        return board;
    }

    public boolean undo() {
        if (this.history.empty ()) return false;
        Move move=this.history.pop ();
        board.emptyCell (move.destination);
        ui.removePiece (move.destination);
        if (move.pieceAtDestination != null) {
            move.pieceAtDestination.setPosition (move.destination);
            board.addPiece (move.pieceAtDestination);
            ui.placePiece (move.pieceAtDestination.getType (), move.pieceAtDestination.getColor (), move.pieceAtDestination.getPosition ());
        }
        board.emptyCell (move.origin);
        ui.removePiece (move.origin);
        move.pieceAtOrigin.setPosition (move.origin);
        board.addPiece (move.pieceAtOrigin);
        ui.placePiece (move.pieceAtOrigin.getType (), move.pieceAtOrigin.getColor (), move.pieceAtOrigin.getPosition ());

        currentPlayer=move.pieceAtOrigin.getOwner ();
        if (move.pieceAtDestination != null)
            currentPlayer.removeFromScore (move.pieceAtDestination.getValue ());
        return true;



    }

    public boolean isMovePlayable(Move gameMove) {

        if (gameMove.pieceAtOrigin == null) return false;

        if (gameMove.pieceAtOrigin.isMoveAuthorized (board, gameMove.destination) &&
                currentPlayer.equals (gameMove.pieceAtOrigin.owner) &&
                !moveIscheck (currentPlayer, gameMove)

                &&
                !(gameMove.pieceAtDestination != null &&
                        gameMove.pieceAtDestination.getType ().equals (Piece.Type.KING))) {
            return true;

        } else return false;


    }


    public void applyMove(Move move) {

        history.push (move);
        board.emptyCell (move.origin);
        board.emptyCell (move.destination);
        ui.removePiece (move.destination);
        ui.removePiece (move.origin);
     move.pieceAtOrigin.setPosition (move.destination);
        board.addPiece (move.pieceAtOrigin);
        ui.placePiece (move.pieceAtOrigin.getType (), move.pieceAtOrigin.owner.getColor (), move.destination);


    }

    public void switchPlayers() {
        if (currentPlayer.equals (white)) currentPlayer=black;
        else if (currentPlayer.equals (black)) currentPlayer=white;
    }

    public Player getOpponent(Player player) {
        if (player.color == ChessColor.WHITE) return black;
        else return white;

    }

    public Piece threateningpieceforprey(Piece prey) {
        Player player=getOpponent (prey.owner);
        List<Move> list=player.getAllMoves (board);

        for (int i=0; i < list.size (); i++) {
            if (list.get (i).destination.equals (prey.position)) return list.get (i).pieceAtOrigin;
        }
        return null;
    }

    public boolean isPrey(Piece prey) {
        // a partir de tous les  mouvements de l'adversaire voir si la piece est une proie
        Player player=getOpponent (prey.owner);
        List<Move> list=player.getAllMoves (board);


        for (int i=0; i < list.size (); i++) {

            if (list.get (i).pieceAtDestination != null && list.get (i).pieceAtDestination.equals (prey)) return true;

        }


        return false;
    }

    public boolean isCheck(Player player) {
        return (isPrey (player.getKing ()));
    }

    public boolean isCheckMate(Player player) {

        if (!isCheck (player)) return false;

List<Move> allMoves =player.getAllMoves (board);
Move move;
            for (int i=0;i<allMoves.size ();i++) {
                System.out.println (allMoves.get (i));
                move=allMoves.get (i);
                if (isMovePlayable (move)) {
                    return false;
                    }

                }
            return true;
            }



    public Player determineWinner(int hit) {
        if (white.getScore () > black.getScore () && hit > 48) {
            System.out.println ("la partie est fini, les " + white.getColor () + " on gagné avec un score de " + white.getScore () + " contre " + black.getScore ());
            return white;
        }
        if (white.getScore () < black.getScore () && hit > 48) {
            System.out.println ("la partie est fini, les " + black.getColor () + " on gagné avec un score de " + black.getScore () + " contre " + white.getScore ());
            return black;
        }
        if (black.isCheckMate) {
            System.out.println ("FIN DE LA PARTIE :\n les " + white.getColor () + " on gagné par echec et mat");
            return white;
        }
        if (white.isCheckMate) {
            System.out.println ("FIN DE LA PARTIE :\n les " + black.getColor () + " on gagné par echec et mat");
            return black;
        }
        return null;
    }

    public boolean moveIscheck(Player player, Move move) {

        applyMove (move);
        if (isCheck (player)) {

            undo ();
            return true;
        }
        undo ();
        return false;
    }

    public void play() throws InterruptedException {

        int numberofhit=0;
        while (numberofhit < 50  ) {
            Move move=new Move (board, currentPlayer.getFromTo (this));

            if (isMovePlayable (move)) {
                applyMove (move);
                if (move.pieceAtDestination!=null)currentPlayer.addToScore (move.pieceAtDestination.getValue ());
                numberofhit=numberofhit + 1;
                switchPlayers ();

            }


        }
        System.out.println ("fin de la partie ");
        determineWinner (numberofhit);
    }
}
