import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a mensgem...");
        String mensagem = scanner.nextLine();
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("10.74.241.66"); // Endereço do servidor
            byte[] sendData = mensagem.getBytes();
            while (true) {

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
                socket.send(sendPacket);
                // Recebe a resposta
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(sendPacket);

                String resposta = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Resposta do servidor: " + resposta);

                socket.close();
            }
        } catch (Exception e) {
        }
    }
}
