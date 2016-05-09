import javafx.util.Pair;

import java.io.*;

public class Bob {

<<<<<<< HEAD
	private Puzzle binaryPuzzle,xorPuzzle,currPuzzle;
    public Bob(){
        binaryPuzzle=null; 
    	xorPuzzle=null;
    	currPuzzle=null;
=======
    public Bob(){
>>>>>>> e1dde1deee90ebff4c128f9db2126b20ba0949e0
    }

    public Pair<String, String> choosePuzzle(Puzzle[] puzzles){
    	int choose = (int)(Math.random()*puzzles.length);
    	return solvePuzzle(puzzles[choose]);
    }

    public Pair<String, String> solvePuzzle(Puzzle puz){
<<<<<<< HEAD
        int[] serialNum=puz.getPrivateKey(),key=puz.getRiddle(); //Initialize arrays
        currPuzzle= new Puzzle(mergeSort(serialNum),mergeSort(key));//Sort
        
        
    }
    private String convertToBinary(int num){
    	String ans="";
    	while(num>0){
    		ans+=(num%2);
    		num/=2;
    	}
    	return ans;
    }
    private int[] mergeSort(int[] arr){
    	if(arr.length<2)
    		return arr;
    	else
    		return merge(mergeSort(splitLeft(arr)),mergeSort(splitRight(arr)));
    }
    private int[] splitLeft(int[] arr)
    {
    	int[] ans=new int[arr.length/2];
    	for(int i=0;i<ans.length;i++){
    		ans[i]=arr[i];
    	}
    	return ans;
    }
    private int[] splitRight(int[] arr)
    {
    	int[] ans=new int[arr.length - arr.length/2];
    	for(int i=arr.length/2;i<ans.length;i++){
    		ans[i-arr.length/2]=arr[i];//checkout for ans[i]
    	}
    	return ans;
    }
    private int[] merge(int[] arr1,int[] arr2){
    	int i=0,i1=0,i2=0;
    	int l1=arr1.length,l2=arr2.length;
    	int[] ans=new int[l1+l2];
    	
    	while(i1<1 && i2<l2){
    		if(arr1[i1]<arr2[i2]){
    			ans[i]=arr1[i1];
    			i1=i1+1;
    		}
    		else{
    			ans[i]=arr2[i2];
    			i2=i2+1;
    		}
    		i=i+1;
    	}
    	for(int j=i1;j<l1;j=j+1){
    		ans[i]=arr1[j];
    		i=i+1;
    	}
    	for(int j=i2;j<l2;j++){
    		ans[i]=arr2[j];
    		i=i+1;
    	}
    	return ans;
    }
    
    
 }
    
    
=======
        return PuzzleUtils.solvePuzzle(puz);
    }
}
>>>>>>> e1dde1deee90ebff4c128f9db2126b20ba0949e0
