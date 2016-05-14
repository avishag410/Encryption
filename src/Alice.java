import javafx.util.Pair;


public class Alice {

    private Puzzle [] puzzlesArray;
    private AVLTree AliceTree;

    public Alice(){
    	AliceTree=new AVLTree();
    }

    public Puzzle[] getPuzzlesCopy(){
        Puzzle[] puzzlesCopy = new Puzzle[puzzlesArray.length];
        for(int i = 0; i < puzzlesArray.length; i++){
            puzzlesCopy[i] = new Puzzle(puzzlesArray[i]);
        }
        return puzzlesCopy;
    }

    public void createPuzzles(int n, int k){
    	puzzlesArray=new Puzzle[k];
    	
    	int index = 0;
    	while(index < k){
    		// Get random values for the arrays
    		int[] riddle = RandomAnArray(n);
    		int[] privateKey = RandomAnArray(n);
    		
    		// solve the riddle in order to save it on the tree
    		String riddleString = PuzzleUtils.SolveArray(riddle);
    		DecryptedPuzzle decrypted = new DecryptedPuzzle(riddleString, privateKey);
    		
    		// search if the riddle number already exists
    		if(!AliceTree.search(decrypted)){
    			// insert only if the riddle number is new
    			AliceTree.insert(decrypted);
    			// shuffle the arrays
    			int[] shuffRiddle = ShuffleArray(riddle);
    			int[] shuffPrivateKey = ShuffleArray(privateKey);
    			//Save the puzzles
    			Puzzle puzz = new Puzzle(shuffPrivateKey, shuffRiddle);
    			puzzlesArray[index] = puzz;
    			index++;
    		}
    	}
    }
    public Pair<String, Integer> findKey(String sIndex){
    	// Search the private key
    	Pair<int[],Integer> arrayAns = AliceTree.getPrivateKey(sIndex);
    	int[] key=arrayAns.getKey();
    	
    	// solve the array
    	String solvedKey = PuzzleUtils.SolveArray(key);
    	
    	return new Pair<String,Integer> (solvedKey, arrayAns.getValue());
    }
    
    private int[] ShuffleArray(int[] arr){
    	int[] shuffled = new int[arr.length];
    	// copy the sorted array in order to shuffle it
    	for(int i=0; i<arr.length; i++){
    		shuffled[i] = arr[i];
    	}
    	
    	// shuffle
    	int max = arr.length -1;
    	for(int i=0;i< arr.length ;i++){
    		int min = i;
    		// get a random number between index and length -1
    		int randomIndx=(int)(Math.random() * (max - min)) + min;
    		int temp = shuffled[randomIndx];
    		
    		// swap the values
    		shuffled[randomIndx]=shuffled[i];
    		shuffled[i]=temp;
    	}
    	
    	return arr;
    }
    	
    private int[] RandomAnArray(int N){
    	int[] arr = new int[N];
    	
    	// random a number in range [(i-1)N^3,iN^3) for each cell
    	for (int i=1;i<=N;i++){
    		int max = i*((int)Math.pow(N, 3));
    		int min = (i-1)*((int)Math.pow(N, 3));
    		arr[i-1]=(int)(Math.random() * (max - min)) + min;
    	}
    	return arr;
    }


}
