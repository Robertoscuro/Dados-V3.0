package Funcionalidad;



import Interfaz.Interfaz;
import java.io.*;
import java.net.*;

public class Conex {

 //  private static String HOST = "localhost";
    private static String HOST= "82.158.41.88";
    private static int PUERTO = 28197;
    Socket socket;
    DataOutputStream mensaje;
    BufferedReader entrada;
    GestorIO g = GestorIO.getGestorIO();

   // public static void main(String args[]) {
    public void run(int x,String Nombre,Interfaz inter){


        try {

            socket = new Socket(HOST, PUERTO);
            mensaje = new DataOutputStream(socket.getOutputStream());
            entrada = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            mensaje.writeUTF(Nombre+" ha sacado "+x);
          String recibido = entrada.readLine();
          inter.mostarMaster(recibido);

            socket.close();

        } catch (UnknownHostException e) {
            System.out.println("El host no existe o no está activo.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }

    }

    public void simple(int y, String n,Interfaz inter) throws IOException {
        try {
            socket = new Socket(HOST, PUERTO);
            BufferedWriter bws;
            BufferedReader br = null;
            OutputStream os;
            os = socket.getOutputStream();
            bws = new BufferedWriter(new OutputStreamWriter(os));
            bws.write(n+" ha sacado " + y);
            bws.newLine();
            bws.flush();
            socket.close();
        } catch (UnknownHostException e) {
            System.out.println("El host no existe o no está activo.");

        }catch (IOException e) {
        System.out.println("Error de entrada/salida.");
    }
    }

    public void ver(Interfaz inter) throws IOException {
        try{
            socket = new Socket(HOST, PUERTO);
        entrada = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        String recibido = entrada.readLine();
        inter.mostarMaster(recibido);

        socket.close();
    } catch (UnknownHostException e) {
        System.out.println("El host no existe o no está activo.");

    }catch (IOException e) {
        System.out.println("Error de entrada/salida.");
    }

    }
}
