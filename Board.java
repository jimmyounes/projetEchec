import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Board{
    private Piece[][] array;
    
    public Board(String fileName, Player white, Player black){
	int pieceType;
	int col;
	int row;
	String nextWord;
	Player owner;
	
	this.array = new Piece[8][8];
	try {
	    File file = new File(fileName);
    	    if(file.exists()==false) {
		System.err.println("Error: Cannot find file "+ fileName);
		System.exit(1);		
            } 

	    Scanner in = new Scanner(file);
	    while(in.hasNext()) {
		if ((nextWord = in.nextLine()).length()>2) {
		    pieceType = nextWord.charAt(0);
		    col = nextWord.charAt(1)-'0';
		    row = nextWord.charAt(2)-'0';
		    
		    owner = black;
		    if (pieceType >= 'a' && pieceType <= 'z')
    			owner = white;
		    switch(pieceType) {
				case 'q' : case 'Q' :
				{this.addPiece (new Queen(col,row,owner));break;}
				case 'n' : case 'N' :
				{this.addPiece (new Knight(col,row,owner));break;}
				case 'b' : case 'B' :
				{this.addPiece (new Bishop(col,row,owner));break;}
				case 'r' : case 'R' :
				{this.addPiece (new Rook(col,row,owner));break;}
				case 'p' : case 'P' :
				{this.addPiece (new Pawn(col,row,owner));break;}
		    case 'K' : case 'k' :  
    			{ this.addPiece(new King(col, row, owner)); break;}
		    }

	    	}	    	
	    }
	    in.close();
	}
	catch(FileNotFoundException e) {
	    System.err.println("Error file not found : "+e);
	    System.exit(1);	
	}
    }
    
    public List<Coordinates> getAllCoordinates(){
    	List<Coordinates> list=new ArrayList<> ();
    	for(int i=0;i<8;i++){
    		for(int j=0;j<8;j++){
    			list.add(new Coordinates (i,j));
			}
		}
    	return list;
    }
    
    public List<Piece> getPieces(Player player) {
	List<Piece> list=new ArrayList<> ();
    	for (int i=0;i<8;i++){
    		for (int j=0;j<8;j++){
    			if (array[i][j]!=null && array[i][j].owner.equals (player)){
    				list.add(array[i][j]);
				}
			}
		}
    	return list;
    }

    public List<Piece> getPieces() {
    	List<Piece> List=new ArrayList<> ();
    	for (int i=0;i<8;i++){
    		for (int j=0;j<8;j++){
    			if(array[i][j]!=null)List.add(array[i][j]);
			}
		}
    	return List;
    }

    public void addPiece(Piece piece){
    	int i=piece.position.getX ();
    	int y=piece.position.getY ();
    	array[i][y]=piece;
    }

    public Piece getPiece(Coordinates coordinates){
	return array[coordinates.getX ()][coordinates.getY ()];
    }

    public Piece getPiece(int x, int y){
	return array[x][y];
    }

    public void emptyCell(Coordinates coordinates){
    	array[coordinates.getX ()][coordinates.getY ()]=null;
    }
    
    public boolean isEmptyCell(Coordinates coordinates){
	if(array[coordinates.getX ()][coordinates.getY ()]==null)return true;
	else return false;
    }
    
    public boolean isEmptyCell(int x, int y){
	if(array[x][y]==null) return true;
	else return false;
    }
    
    public boolean sameColumnNothingBetween(Coordinates origin, Coordinates destination){
    	int y=origin.getX ();
    	int x=destination.getX ();
    	int direction=1;
    	if (y>x) direction=-1;


    	y=y+direction;
    	 if (direction==1)while (y<x ){
    		if (getPiece (y,origin.getY ())!=null) return false;
    		y=y+direction;
		}
    	 else {
			 while (y>x ){
				 if (getPiece (y,origin.getY ())!=null) return false;
				 y=y+direction;
			 }

		 }
    	return true;
    }
    
    public boolean sameRowNothingBetween(Coordinates origin, Coordinates destination) {
		int y=origin.getY ();
		int x=destination.getY ();
		int direction=1;
		if (y > x) direction=-1;


		y=y + direction;
		if (direction == 1) while (y < x) {
			if (getPiece (origin.getX (), y) != null) return false;
			y=y + direction;
		}
		else {
			while (y > x) {
				if (getPiece (origin.getX (), y) != null) return false;
				y=y + direction;
			}

		}
		return true;
	}

    public boolean sameDiagonalNothingBetween(Coordinates origin, Coordinates destination){
	int x,y,j;
	boolean check=true;

	if(origin.getY ()>destination.getY () && origin.getX ()>destination.getX ()){
		x=origin.getX ();y=origin.getY ();
		x=x-1;y=y-1;
		while (x!=destination.getX () && y!=destination.getY () && check==true && y<8 && y>=0 && x>=0 && x<8){
			if (array[x][y]!=null) check=false;
			y=y-1;x=x-1;
		}}
		if(origin.getY ()<destination.getY () && origin.getX ()>destination.getX () ){
			x=origin.getX ();y=origin.getY ();
			x=x-1;y=y+1;
			while (x!=destination.getX () && y!=destination.getY () && check==true && y<8 && y>=0 && x>=0 && x<8){
				if (array[x][y]!=null) check=false;
				y=y+1;x=x-1;
			}}
		if(origin.getY ()>destination.getY () && origin.getX ()<destination.getX ()){
			x=destination.getX ();y=destination.getY ();
			x=x-1;y=y+1;
			while (x!=origin.getX () && y!=origin.getY () && check==true && y<8 && y>=0 && x>=0 && x<8){
				if (array[x][y]!=null) check=false;
				y=y+1;x=x-1;
			}}
		if(origin.getY ()<destination.getY () && origin.getX ()<destination.getX ()){
			x=origin.getX ();y=origin.getY ();
			x=x+1;y=y+1;
			while (x!=destination.getX () && y!=destination.getY () && check==true && y<8 && y>=0 && x>=0 && x<8){
				if (array[x][y]!=null) check=false;
				y=y+1;x=x+1;
			}}
return check;
    }
}
