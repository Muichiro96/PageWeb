package Page;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class interfaces {



    public void afficherInterfaces(){

        try {
            for (Enumeration<NetworkInterface> nom=NetworkInterface.getNetworkInterfaces(); nom.hasMoreElements();)
                System.out.println(nom.nextElement());
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

    }

    public void localInterface(){
        try{
        InetAddress ip = InetAddress.getLocalHost();
        String monip = ip.getHostAddress();
        System.out.println(monip);
        NetworkInterface intera;
        intera=NetworkInterface.getByInetAddress(ip);
        System.out.println(intera);
            } catch (UnknownHostException | SocketException e) {
                throw new RuntimeException(e);
            }
    }
    public static void main(String []args) {
        interfaces a=new interfaces();
            a.afficherInterfaces();
            a.localInterface();
    }


}
