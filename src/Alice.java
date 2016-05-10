import javafx.util.Pair;


public class Alice {

    private Puzzle [] puzzlesArray;
    private AVLTree AliceTree;
    private DecryptedPuzzle[] AlicePuzzles;

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
    	AlicePuzzles=new DecryptedPuzzle[k];
    	int j;
    	
    	//create each number in the arrays
    	for ( j=0 ; j<k ; j++){
    		puzzlesArray[j]= new Puzzle(RandomAnArray(puzzlesArray[j].getRiddle()),RandomAnArray(puzzlesArray[j].getPrivateKey()));
    	}
    	//InitAlicePuzzles
    	InitAlicePuzzles();
    	//Insertion to avltree.Each node contains DecryptedPuzzle
    	for(j=0;j<AlicePuzzles.length;j++){
    		AliceTree.insert(AlicePuzzles[j]);
    	}
    	
    	
    }
    public Pair<String, Integer> findKey(String sIndex){
    	Pair<int[],Integer> arrayAns=AliceTree.getPrivateKey(sIndex);
    	int[] key=arrayAns.getKey();
    	
    	return new Pair<String,Integer> (ConvertArraytoString(key),arrayAns.getValue());
    }

    private void InitAlicePuzzles(){
    	//convert from puzzleArray to DecryptedPuzzle
    	for(int i=0;i<AlicePuzzles.length;i++){
    		AlicePuzzles[i].serialNumber=ConvertArraytoString(puzzlesArray[i].getRiddle());
    		AlicePuzzles[i].privateKey=puzzlesArray[i].getPrivateKey();
    	}
    }
    
    private String ConvertArraytoString(int[] arr){
    	String ans="";
    	for(int i=0;i<arr.length;i++){
    		ans=ans+arr[i];
    	}
    	return ans;
    }
    private int[] RandomAnArray(int[] arr){
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
