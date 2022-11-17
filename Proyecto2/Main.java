package Fundamentos.Proyecto2;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int disparos = 0;
    Scanner lectura = new Scanner (System.in);       
    Game metodosJuego = new Game();
    String[][] tanque = new String[2][2];
    int cant = (int)(Math.random()*4+1);
        
    int contCant =  0;
    
    for (int k = 0; k< 2; k++)
    {
      for (int i = 0; i < 2; i++)
      {
        if(contCant == cant)
        {
          break;
        }
        
        int opcion = (int)(Math.random()*2+1);

        if (opcion == 1)
        {
          TanqueNormal normal = new TanqueNormal(10);
          tanque[k][i] = "BN-"+String.valueOf(normal.getSalud());
        }
        else if (opcion == 2)
        {
          TanqueNormal alien = new TanqueNormal(20);
          tanque[k][i] = "BA-"+String.valueOf(alien.getSalud());
        }
        
        contCant += 1;
              
      }
    }
    
        System.out.println("\nLa salud inicial de los tanques es:  \n");
        imprimir(tanque);
    
    while(true)
    {
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("1. Restar salud al tanque seleccionado");
      System.out.println("2. Lanzar una bomba atomica");
      System.out.println("3. Encuentra el primer elemento minimo y lo duplica");
      System.out.println("4. Muestra la frase de la abuela");
      System.out.println("5. Muestra la cantidad de disparos realizados durante el juego");
      System.out.println("...Recuerda que siempre se imprime la salud de los tanques disponibles \n");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("Ingrese su opcion...");
      
      int opcion = lectura.nextInt();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      
      if(opcion == 1)
      {
        System.out.println("...Disparando a los tanques...");
        metodosJuego.opcion1(tanque);
        disparos += 1;
      }
      else if(opcion ==2)
      {
        System.out.println("...Bombardeando un tanque...");
        metodosJuego.atomica(tanque);
      }
      else if(opcion == 3)
      {
        System.out.println("...Duplicando el elemento minimo...");
        metodosJuego.activator(tanque);
      }
      else if(opcion  == 4)
      {
        System.out.println("La frase de la abuela es:\n "+metodosJuego.frase());
      }
      else if(opcion == 5)
      {
        System.out.println("El total de disparos realizados en el juego es :\n" + disparos);
      }
    
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("La salud de los tanque es: \n");
    
      if(imprimir(tanque)==4)
      {
        break;
      }
    
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              
    }
  }

  public static int imprimir(String[][] tanque)
  {
    
    int contador=0;
    System.out.println("-------------");

    for(int i = 0; i < 2; i++)
    {
      for (int j = 0; j < 2; j++)
      {
        if(tanque[i][j] == null)
        {          
           System.out.print("|     |");
           contador += 1;
        }
        else
        {
          System.out.print("|"+ tanque[i][j] + "|");
        }
             
      }
      
      System.out.println();
      System.out.println("-------------");
              
    }
    return contador;
  }
  
}
