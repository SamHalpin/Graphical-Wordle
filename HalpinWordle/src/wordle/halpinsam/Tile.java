package wordle.halpinsam;

public class Tile {
	private char letter;
	private TileState state;
	
	public Tile(char new_letter) {
		letter = new_letter;
		state = TileState.NOTINWORD;
	}
	/**
	 * gets the tile State
	 * @return state
	 */
	public TileState getState() {
		return state;
	}
	/**
	 * sets the tile state to correct
	 */
	public void setCorrect() {
		state = TileState.CORRECT;
	}
	/**
	 * sets the tile state to in word
	 */
	public void setInword() {
		state = TileState.INWORD;
	}
	/**
	 * sets the tile state to not in word
	 */
	public void setNotword() {
		state = TileState.NOTINWORD;
	}
	
	
	
	
}
