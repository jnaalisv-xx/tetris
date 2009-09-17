package tetris;

public class Block {
	private final char c;
	public int x;
	public int y;
	
	public Block(char c) {
		this.c = c;
	}
	
	public String toString() {
		return Character.toString(this.c);
	}	
	
	public char toChar() {
		return this.c;
	}
}