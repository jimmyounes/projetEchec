public class Coordinates{
    private int x;
    private int y;
    
    public Coordinates(int x, int y){
        this.x=x;
        this.y=y;

    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }

    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }

    @Override
    public String toString(){
	return "X:"+x+" Y:"+y;
    }

    @Override
    public boolean equals(Object o) {
	if(o instanceof Coordinates){
	    if(((Coordinates) o).getX ()==this.x && ((Coordinates) o).getY ()==this.y)return true;

    }
	return false;
    }
}
