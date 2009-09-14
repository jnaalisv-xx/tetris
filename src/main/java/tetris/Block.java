package tetris;

public class Block {
	private final char c;
	
	public Block(char c) {
		this.c = c;
	}
	
	public String toString() {
		return Character.toString(this.c);
	}
}