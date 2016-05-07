import javafx.util.Pair;

public class PuzzleUtils {
	public static Pair<String, String> solvePuzzle(Puzzle puz){
		
		 return null;
	}
	 
	public Pair<String, Integer> findKey(String index, Puzzle[] puzzles){
		 //Complete Your Code Here
		 return null;
	}
	
	// just adding a function, maybe we need it
	public String NumberToBinary(int number){
		String result ="";
		while(number>2){
			result += number%2;
			number = number/2;
		}
		result += number;
		return result;
	}
	
	// just adding a function, maybe we need it
	public String XorToOneNumber(int number){
		int result = 0;
		while(number>2){
			result += number%2;
			number = number/2;
		}
		result += number;
		
		return "" + (number%2);
	}
}
