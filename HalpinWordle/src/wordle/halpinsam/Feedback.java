package wordle.halpinsam;

public class Feedback {

	private Tile[] tiles;
	
	public Feedback(int n) {
		tiles = new Tile[n];
		for (int i=0; i< tiles.length; i++) {
			char letter = '-';
			tiles[i] = new Tile(letter);
		}
	}
/**
 * Sets the feedback of the players guess
 * @param guess
 * @param answer
 */
	public void setFeedback(String guess, String answer ) {
		// modify the tiles... state... 
		for (int i=0; i<answer.length(); i++) {
			if (guess.substring(i,i+1).equals(answer.substring(i, i+1))) {
				tiles[i].setCorrect();
			}
			else if ((answer.indexOf(guess.substring(i,i+1))>0)) {
				tiles[i].setInword();
			}
			else {
				tiles[i].setNotword();
			}
		}
	}
	/**
	 * Gets the tiles state of a certain index
	 * @param i
	 * @return returns the state of the tile
	 */
	public TileState getState(int i) {
		return tiles[i].getState();
	}
	
	
	
}
