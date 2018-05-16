package muokithedeveloperNoobChain;
import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class NoobChain
{
    public static ArrayList<Block> blockChain = new ArrayList<Block>();
    public static int difficulty = 5;
    public static void main(String[] args)
    {
        //add
        blockChain.add(new Block("Hello this is the 1st block","0"));
        System.out.println("Trying to mine block 1... ");
        blockChain.get(0).mineBlock(difficulty);

        blockChain.add(new Block("Sema, this is the second block",blockChain.get(blockChain.size()-1).hash));
        System.out.println("Trying to mine block 2... ");
        blockChain.get(1).mineBlock(difficulty);

        blockChain.add(new Block("Jambo, this is the third block",blockChain.get(blockChain.size()-1).hash));
        System.out.println("Trying to mine block 1... ");
        blockChain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is valid: "+isChainValid());

        String blockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockChainJson);
    }//end main

    public static Boolean isChainValid()
    {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0','0');

        //loop through blockchain to check hashes
        for(int i=1; i<blockChain.size();i++)
        {
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i-1);
            //compare registered hash and calculated hash
            if(!currentBlock.hash.equals(currentBlock.calculateHash()))
            {
                System.out.println("Current Hashes not equal");
                return false;
            }//end if

            if(!previousBlock.hash.equals(currentBlock.previousHash)){
                System.out.println("Previous Hashes not equal");
                return false;
            }//end if

            //check if hash is solved
            if(!currentBlock.hash.substring(0,difficulty).equals(hashTarget))
            {
                System.out.println("This block hasn't been mined");
                return false;
            }//end if
        }//end for loop
        return true;
    }//end isChainValid
}//End NoobChain class
