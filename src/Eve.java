/**
 * Created by tomercoh on 16/04/2016.
 */
public class Eve {
	
    public Eve(){
    	
    }

    public Pair<String, Integer> findKey(String index, Puzzle[] puzzles){
    	return PuzzleUtils.findKey(index, puzzles);
    }

    public Pair<String, String> solvePuzzle(Puzzle puz){
    	return PuzzleUtils.solvePuzzle(puz);
    }

}
