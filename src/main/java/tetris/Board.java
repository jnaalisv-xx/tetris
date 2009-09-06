package tetris;

public class Board {

    private final int rows;
    private final int columns;
    private boolean hasFallingBlock;
    private int fallingBlockX;
    private int fallingBlockY;
    private Block[][] blocks;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.hasFallingBlock = false;
        this.blocks = new Block[this.rows][this.columns];
    }
    
    public boolean hasFalling() {
    	return this.hasFallingBlock;
    }
    
    public void drop(Block block) {
    	if (this.hasFallingBlock)
    		throw new IllegalStateException("already falling");
    	
    	this.hasFallingBlock = true;
    	this.fallingBlockX = this.columns / 2;
    	this.fallingBlockY = 0;
    	this.blocks[this.fallingBlockY][this.fallingBlockX] = block;
    }
    
    public void tick() {
    	// jos meillä on tippuva blokki
    	if (this.hasFallingBlock) {
    		
    		// jos alhaalla on tilaa
	    	if (this.fallingBlockY < this.rows -1 && 
	    			blocks[this.fallingBlockY+1][this.fallingBlockX] == null) {
	    		
	    		// uusi sijainti riviä alempana
	    		int newFallingBlockY = this.fallingBlockY+1;
	    		
	    		// tiputetaan blokki uuteen sijaintiin
	    		this.blocks[newFallingBlockY][this.fallingBlockX] = 
	    			this.blocks[this.fallingBlockY][this.fallingBlockX];
	    		
	    		// nollataan vanha paikka
	    		this.blocks[this.fallingBlockY][this.fallingBlockX] = null;
	    		
	    		this.fallingBlockY = newFallingBlockY;
	    		
	    	}
	    	else {
	    		// ei ollut tilaa, ei liikutetan palikkaa, asetetaan lippu
	    		// jotta meillä ei ole putoavia palikoita
	    		this.hasFallingBlock = false;
	    	}
    	}
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
            	if (this.blocks[row][col] == null)
            		s += ".";
            	else
            		s += this.blocks[row][col].toString();

            }
            s += "\n";
        }
        return s;
    }
}

class Block {
	private final char c;
	
	public Block(char c) {
		this.c = c;
	}
	
	public String toString() {
		return Character.toString(this.c);
	}
}
