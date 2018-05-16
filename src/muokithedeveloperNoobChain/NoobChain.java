package muokithedeveloperNoobChain;
import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class NoobChain
{
    public static ArrayList<Block> blockChain = new ArrayList<Block>();

    public static void main(String[] args)
    {
        //add
        blockChain.add(new Block("Hello this is the 1st block","0"));
        blockChain.add(new Block("Sema, this is the second block",blockChain.get(blockChain.size()-1).hash));
        blockChain.add(new Block("Jambo, this is the third block",blockChain.get(blockChain.size()-1).hash));


        String blockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println(blockChainJson);
    }//end main

    public static Boolean isChainValid()
    {
        Block currentBlock;
        Block previousBlock;

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
        }//end for loop
        return true;
    }//end isChainValid
}//End NoobChain class
