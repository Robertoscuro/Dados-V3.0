package Funcionalidad;

import Interfaz.Interfaz;
import java.io.IOException;

public class Menu {
    Dados dado;
    GestorIO gestorIO;
    Conex con = new Conex();

    public Menu() {
        dado = new Dados();
        gestorIO = GestorIO.getGestorIO();

    }

    public int Opciones(int op) {
        int x;
        switch (op) {
            case 4:
                x = dado.Dado4();
                break;
            case 6:
                x = dado.Dado6();
                break;
            case 10:
                x = dado.Dado10();
                break;
            case 12:
                x = dado.Dado12();
                break;
            case 20:
                x = dado.Dado20();
                break;
            case 30:
                x = dado.Dado30();
                break;
            case 100:
                x = dado.Dado100();
                break;
            case 8:
                x=dado.Dado8();
                break;
            default:
                x = 0;
                break;


        }
        return x;
    }
    private void mandarTirada ( int y, String n,Interfaz inter){
        con.run(y, n,inter);
    }
    public void iniciar(int op,int dado,String n, Interfaz inter) throws InterruptedException, IOException {
        int x, y;
        x=dado;
  
          
            if (op == 1) {
                
              
                y = this.Opciones(x);
                inter.mostrarMiresultado(y);
                this.mandarTirada(y, n,inter);
            } else if (op == 2) {
               
               
                y = this.Opciones(x);
                inter.mostrarMiresultado(y);
                this.mandarTiradaSimple(y,n,inter);
                 

            } else if (op == 3) {
                con.ver(inter);
            } else if (op == 4) {
              
                y = this.Opciones(x);
                inter.mostrarMiresultado(y);
                
            } else {
                return;
            }
 

        }



    

    private void mandarTiradaSimple(int y,String n,Interfaz inter) throws IOException {
        con.simple(y,n,inter);
    }
}

