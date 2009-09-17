package tetris;

public class Block {
	private final char c;
	
	// tän vois hanskata paremmin
	// sijainti boardilla
	public int x;
	public int y;
	// displacement tetrominoen sisällä suhteessa tetron keskustaan
	public int dispX;
	public int dispY;
	
	public Block(char c) {
		this.c = c;
		this.dispX = 0;
		this.dispY = 0;
	}
	
	public Block(char c, int dispX, int dispY) {
		this.c = c;
		this.dispX = dispX;
		this.dispY = dispY;
	}
	
	public String toString() {
		return Character.toString(this.c);
	}	
	
	public char toChar() {
		return this.c;
	}
}