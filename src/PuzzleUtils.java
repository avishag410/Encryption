import javafx.util.Pair;

public class PuzzleUtils {
	public static Pair<String, String> solvePuzzle(Puzzle puz){
		int[] riddleSorted = SortPuzzleArray(puz.getRiddle());
		String riddleAns = "";
		for(int iRiddle = 0; iRiddle < riddleSorted.length; iRiddle++){
			riddleAns += XorToOneNumber(riddleSorted[iRiddle]);
		}
		
		int[] keySorted = SortPuzzleArray(puz.getPrivateKey());
		String keyAns = "";
		for(int iKey = 0; iKey < keySorted.length; iKey++){
			keyAns += XorToOneNumber(keySorted[iKey]);
		}
		
		return new Pair<String, String>(riddleAns, keyAns);
	}
	 
	public static Pair<String, Integer> findKey(String index, Puzzle[] puzzles){
		boolean isFound = false;
		Pair<String, Integer> ans = null;
		for(int iPuzzle = 0; iPuzzle < puzzles.length && !isFound; iPuzzle++){
			Pair<String, String> solved = solvePuzzle(puzzles[iPuzzle]);
			if(solved.getKey().compareTo(index) == 0){
				isFound = true;
				ans = new Pair<String, Integer>(solved.getValue(), iPuzzle);
			}
		}
		
		
		return ans;
	}
	
	public static int[] SortPuzzleArray(int[] array){
		int[] result = new int[array.length];
		for(int iArray = 0; iArray< array.length; iArray++){
			int index = (int)(array[iArray]/Math.pow(array.length, 3));
			result[index] = array[iArray];
		}
		return result;
	}
	
	public static String XorToOneNumber(int number){
		int result = 0;
		while(number>2){
			result += number%2;
			number = number/2;
		}
		result += number;
		
		return "" + (result%2);
	}
}
