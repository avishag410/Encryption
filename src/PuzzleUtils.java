import javafx.util.Pair;

public class PuzzleUtils {
	public static Pair<String, String> solvePuzzle(Puzzle puz){
		int[] riddleSorted = MergeSort(puz.getRiddle());
		String riddleAns = "";
		for(int iRiddle = 0; iRiddle < riddleSorted.length; iRiddle++){
			riddleAns += XorToOneNumber(riddleSorted[iRiddle]);
		}
		
		int[] keySorted = MergeSort(puz.getPrivateKey());
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
	
	public static int[] MergeSort(int[] arrayToSort){
		if(arrayToSort.length <= 1)
			return arrayToSort;
		int[] left = MergeSort(SplitArray(arrayToSort, 0, arrayToSort.length/2));
		int[] right = MergeSort(SplitArray(arrayToSort, left.length, arrayToSort.length-1));
		
		int[] merged = new int[left.length + right.length];
		int index = 0;
		int iLeft = 0;
		int iRight = 0;
		
		while(iLeft < left.length && iRight < right.length){
			if(left[iLeft] < right[iRight]){
				merged[index] = left[iLeft];
				iLeft++;
			}
			else{
				merged[index] = right[iRight];
				iRight++;
			}
			index++;
		}
		
		while(iLeft < left.length){
			merged[index] = left[iLeft];
			iLeft++;
			index++;
		}
	
		while(iRight < right.length){
			merged[index] = right[iRight];
			iRight++;
			index++;
		}
		
		return merged;
	}
	
	public static int[] SplitArray(int[] array, int start, int end){
		
		int[] result = new int[Math.abs(end - start)];
		int i = start;
		for(int index = 0; index < result.length; index++){
			result[index] = array[i];
			i++;
		}
		return result;
	}
	
	// just adding a function, maybe we need it
	public static String NumberToBinary(int number){
		String result ="";
		while(number>2){
			result += number%2;
			number = number/2;
		}
		result += number;
		return result;
	}
	
	// just adding a function, maybe we need it 
	public static String XorToOneNumber(int number){
		int result = 0;
		while(number>2){
			result += number%2;
			number = number/2;
		}
		result += number;
		
		return "" + (number%2);
	}
}
