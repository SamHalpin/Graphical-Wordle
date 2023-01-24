package wordle.halpinsam;

public class Tile {
	private char letter;
	private TileState state;
	
	public Tile(char new_letter) {
		letter = new_letter;
		state = TileState.NOTINWORD;
	}
	public TileState getState() {
		return state;
	}
	public void setCorrect() {
		state = TileState.CORRECT;
	}
	public void setInword() {
		state = TileState.INWORD;
	}
	public void setNotword() {
		state = TileState.NOTINWORD;
	}
	
	
	
	
}
