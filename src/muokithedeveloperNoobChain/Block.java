package muokithedeveloperNoobChain;
import java.util.Date;

public class Block
{
    public String hash;
    public String previousHash;
    // simple message for the data
    public String data;

    private long timeStamp;//asnumber of milliseconds since 1/1/1970
    private int nonce;
    //block constructor
    public Block(String data, String previousHash)
    {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();//NB. to be done after setting of the other values
    }//end of Block Constructor

    public String calculateHash()
    {
        String calculatedHash = StringUtil.applySha256(
                previousHash + Long.toString(timeStamp)+Integer.toString(nonce)+ data);
        return calculatedHash;
    }//calculateHash

    public void mineBlock(int difficulty){}//end mineBlock
}//end class BLock
