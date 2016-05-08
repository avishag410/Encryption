import javafx.util.Pair;

import java.io.*;

public class Bob {

    public Bob(){
    }

    public Pair<String, String> choosePuzzle(Puzzle[] puzzles){
    	int choose = (int)(Math.random()*puzzles.length);
    	return solvePuzzle(puzzles[choose]);
    }

    public Pair<String, String> solvePuzzle(Puzzle puz){
        return PuzzleUtils.solvePuzzle(puz);
    }
}
