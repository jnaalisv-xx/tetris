package tetris;

public class Board {

    private final int rows;
    private final int columns;
    private boolean hasFallingBlock;
    private Block fallingBlock;
    private Block[][] blocks;
    private boolean hasFallingTetrominoe;
    private Tetrominoe fallingTetrominoe;
    
    private final int DONT_MOVE_X = 0;
    private final int DONT_MOVE_Y = 0;    
    private final int MOVE_DOWN = 1;
    private final int MOVE_LEFT = -1;
    private final int MOVE_RIGHT = 1;

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
    
	public void drop(Tetrominoe shape) {
    	if (this.hasFallingBlock || this.hasFallingTetrominoe)
    		throw new IllegalStateException("There is a block/shape already falling");
    	
    	// seurataan tetrominoen keskippistett�
    	this.hasFallingTetrominoe = true;
    	this.fallingTetrominoe = shape;
    	this.fallingTetrominoe.x = this.columns / 2;
    	this.fallingTetrominoe.y = this.fallingTetrominoe.getDistanceFromCenter();
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
    	
    	if (this.hasFallingTetrominoe) {
    		
    		// yritetään liikuttaa tetrominoeta yhden verran alas
    		if (!tryToMoveTetrominoe(MOVE_DOWN,DONT_MOVE_X)) {
    			// Tetrominoen liikuttaminen ei onnistunut, joten pysäytetään se
    			
    			this.hasFallingTetrominoe = false;
    			copyTetrominoeToBoard(this.blocks, this.fallingTetrominoe);
    			this.fallingTetrominoe = null;    			
    		}
    	}
    }

	private boolean tryToMoveTetrominoe(int yDisplacement, int xDisplacement) {
		int newTetrominoeY = this.fallingTetrominoe.y + yDisplacement;
		int newTetrominoeX = this.fallingTetrominoe.x + xDisplacement; 		
		
		for (Block block : this.fallingTetrominoe.getBlocks()) { 
			int newBlockY = newTetrominoeY+block.dispY;
			int newBlockX = newTetrominoeX + block.dispX;
			if (newBlockY > this.rows -1) {   			
				return false; // ulkona alhaalla
			}
				
			if (newBlockX < 0 || newBlockX > columns -1)
				return false; // ulkona jommalla kummalla laidalla
			
			if (this.blocks[newBlockY][newBlockX] != null)
				return false;
		}
		
		// ei havaittu törmäystä, siirretään palikkaa		
		this.fallingTetrominoe.y = newTetrominoeY;
		this.fallingTetrominoe.x = newTetrominoeX;
		return true;
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

	public boolean moveLeft() {
    	if (this.hasFallingTetrominoe) {
    		
    		// yritetään liikuttaa tetrominoeta yhden verran vasemalle
    		if (!tryToMoveTetrominoe(DONT_MOVE_Y,MOVE_LEFT)) {
    			// Tetrominoen liikuttaminen ei onnistunut, joten pysäytetään se
    			
//    			this.hasFallingTetrominoe = false;
//    			copyTetrominoeToBoard(this.blocks, this.fallingTetrominoe);
//    			this.fallingTetrominoe = null;    			
    			return false;
    		}
    		return true;
    	}
    	return false;
	}

	public boolean moveRight() {
    	if (this.hasFallingTetrominoe) {
    		
    		// yritetään liikuttaa tetrominoeta yhden verran oikealle
    		if (!tryToMoveTetrominoe(DONT_MOVE_Y,MOVE_RIGHT)) {
    			// Tetrominoen liikuttaminen ei onnistunut, joten pysäytetään se
    			
//    			this.hasFallingTetrominoe = false;
//    			copyTetrominoeToBoard(this.blocks, this.fallingTetrominoe);
//    			this.fallingTetrominoe = null;    			
    			return false;
    		}
    		return true;
    	}
    	return false;
	}

	public void moveDown() {
    	if (this.hasFallingTetrominoe) {
    		// yritetään liikuttaa tetrominoeta yhden verran oikealle
    		if (!tryToMoveTetrominoe(MOVE_DOWN,DONT_MOVE_X)) {
    			// Tetrominoen liikuttaminen ei onnistunut, joten pysäytetään se
    			
//    			this.hasFallingTetrominoe = false;
//    			copyTetrominoeToBoard(this.blocks, this.fallingTetrominoe);
//    			this.fallingTetrominoe = null;    			
    		}
    	}		
	}


}


