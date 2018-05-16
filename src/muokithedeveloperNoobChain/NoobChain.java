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
}//End NoobChain class
