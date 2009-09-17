package tetris;

public class Board {

    private final int rows;
    private final int columns;
    private boolean hasFallingBlock;
    private Block fallingBlock;
    private Block[][] blocks;
    private boolean hasFallingTetrominoe;
    private Tetrominoe fallingTetrominoe;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.hasFallingBlock = false;
        this.hasFallingTetrominoe = false;
        this.blocks = new Block[this.rows][this.columns];
    }
    
    public boolean hasFalling() {
    	return this.hasFallingBlock || this.hasFallingTetrominoe;
    }
    
    public void drop(Block block) {
    	if (this.hasFallingBlock || this.hasFallingTetrominoe)
    		throw new IllegalStateException("There is a block/shape already falling");
    	
    	this.hasFallingBlock = true;
    	this.fallingBlock = block;
    	this.fallingBlock.x = this.columns / 2;
    	this.fallingBlock.y = 0;
    }
    
    public void tick() {
    	if (this.hasFallingBlock) {
    		
    		
    		// jos alhaalla on tilaa
	    	if (this.fallingBlock.y < this.rows -1 && 
	    			blocks[this.fallingBlock.y+1][this.fallingBlock.x] == null) {
	    		
	    		this.fallingBlock.y = this.fallingBlock.y + 1;
	    			    		
	    		// tiputetaan blokki uuteen sijaintiin
	    		this.blocks[fallingBlock.y][this.fallingBlock.x] = 
	    			this.blocks[this.fallingBlock.y-1][this.fallingBlock.x];
	    		
	    		// nollataan vanha paikka
	    		this.blocks[this.fallingBlock.y-1][this.fallingBlock.x] = null;
	    		
	    	}
	    	else {
	    		this.hasFallingBlock = false;
	    		copyBlockToBoard(this.blocks, this.fallingBlock);
	    		this.fallingBlock = null;   		
	    	}
    	}
    }

	private void copyBlockToBoard(Block[][] blocks, Block block) {
		blocks[block.y][block.x] = block;
	}

    public String toString() {
    	
    	Block[][] blocksToBePrinted = cloneBoard(this.blocks);
    		  	
    	if (this.hasFallingBlock)
    		copyBlockToBoard(blocksToBePrinted, this.fallingBlock);

    	if (this.hasFallingTetrominoe)
    		copyTetrominoeToBoard(blocksToBePrinted, this.fallingTetrominoe);
    	
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
            	if (blocksToBePrinted[row][col] == null)
            		sb.append(".");
            	else
            		sb.append(blocksToBePrinted[row][col].toChar());

            }
            sb.append("\n");
        } 
        return sb.toString();
    }

	private void copyTetrominoeToBoard(Block[][] blocksToBePrinted, Tetrominoe fallingTetrominoe) {
		for(Block block : fallingTetrominoe.getBlocks()) {
			block.x = fallingTetrominoe.x + block.dispX;
			block.y = fallingTetrominoe.y + block.dispY;			
			copyBlockToBoard(blocksToBePrinted, block);
		}
	}

	private Block[][] cloneBoard(Block[][] blocks) {
		Block[][] clone = 
			new Block[blocks.length][blocks[0].length];
    	
    	for(int row = 0; row < blocks.length; row++) 
    		System.arraycopy(blocks[row], 0, clone[row], 0, blocks[row].length);
    	return clone;
	}
}


