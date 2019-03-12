import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MessageFromServer
{
    public static void init()
    {
        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(SomeRandomGameClient.serverSocket.getInputStream()));
            String fromServer;
            while (true)
            {
                fromServer = in.readLine();
                System.out.println(fromServer);
                    if (fromServer.contains("Server: kthxbye"))
                        System.exit(0);
            }
        }catch(IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
