package muokithedeveloperNoobChain;
import java.security.MessageDigest;

public class StringUtil
{
   //applies sha256 to a string and return the result
    public static String applySha256(String input)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            //Applies sha256 to our input
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();//this will contain hash as hexdecimal
            for (int i = 0; i < hash.length; i++)
            {
                String hex = Integer.toHexString(0XFF & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }//end for
            return hexString.toString();
        }//end try
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }//end catch
    }//end method applySha256
}//end class StringUtil
