package tetris;

public class Block {
	private final char c;
	public int x;
	public int y;
	public int dispX;
	public int dispY;
	
	public Block(char c) {
		this.c = c;
		this.dispX = 0;
		this.dispY = 0;
	}
	
	public Block(char c, int x, int y) {
		this.c = c;
		this.dispX = x;
		this.dispY = y;
	}
	
	public String toString() {
		return Character.toString(this.c);
	}	
	
	public char toChar() {
		return this.c;
	}
}