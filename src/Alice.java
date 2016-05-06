import javafx.util.Pair;


public class Alice {

    private Puzzle [] puzzlesArray;
    //Add Fields if needed

    public Alice(){
    	
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
    	//cast lots each number in the arrays
    	for (int j=0 ; j<k ; j++){
    		puzzlesArray[j]= new Puzzle(RandomAnArray(puzzlesArray[j].getRiddle()),RandomAnArray(puzzlesArray[j].getPrivateKey()));
    	
    	}
    	
    }

    public Pair<String, Integer> findKey(String sIndex){
        //Complete Your Code Here
    }

    public int[] RandomAnArray(int[] arr){
    	int N=arr.length; 
    	int randomIndx,tmp;
    	
    	// random a number in range [(i-1)N^3,iN^3) for each cell
    	for (int i=0;i<N;i++){
    		arr[i]=(int)(Math.random()*(N^3)+((i-1)*N^3));
    	}
    	// shuffle
    	for(int i=0;i<N;i++){
    		randomIndx=(int)Math.random()*N +i;
    		
    		tmp=arr[randomIndx];
    		arr[randomIndx]=arr[i];
    		arr[i]=tmp;
 
    	}
    	return arr;
    }


}
