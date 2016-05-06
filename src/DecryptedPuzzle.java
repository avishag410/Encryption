
public class DecryptedPuzzle implements Comparable<DecryptedPuzzle> {
	String serialNumber;
	int[] privateKey;
	
	public DecryptedPuzzle(String serialNumber, int[] privateKey){
		this.serialNumber = serialNumber;
		this.privateKey = privateKey;
	}
	
	public String getSerialNumber(){
		return this.serialNumber;
	}
	
	public int[] getPrivateKey(){
		return this.privateKey;
	}
	
	@Override
	public int compareTo(DecryptedPuzzle decrypted) {
		if(decrypted == null)
			throw new NullPointerException("the object is null");
		return serialNumber.compareTo(decrypted.serialNumber);
	}

}
