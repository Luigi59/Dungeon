package main;

public class Position {
	private int x;
    private int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
        
    public String toString() {
        return "("+this.x+","+this.y+")";
    }
    
    public boolean equals(Object o) {
        if (o instanceof Position) {
            Position lAutre = (Position) o;
            return this.x == lAutre.x && this.y == lAutre.y;
        } 
        else {
            return false;
        }
    }
	    
}
