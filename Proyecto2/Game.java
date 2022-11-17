package Fundamentos.Proyecto2;

class Game 
{
  
  public void opcion1(String[][] tanque)
  {
    
    for(int i = 0; i < 2; i++)
    {
      for (int j = 0; j < 2; j++)
      {
                 
        if(tanque[i][j] != null)
        {  
          String primero = tanque[i][j].substring(0, 3);
          String tString = tanque[i][j].substring(3,tanque[i][j].length());
          int numero = Integer.parseInt(tString);
          int finalNum = 0;
          
          if(numero > 0)
          {
            finalNum = numero-5;
          }
                  
          if(finalNum ==0)
          {
            tanque[i][j] = null;
            continue;
          }
                    
          tanque[i][j] = primero + String.valueOf(finalNum) ;
          
        }
      }
    }
  }
  
  public void atomica (String[][] tanque)
  {
    int posicionX = (int)(Math.random()*2);
    int posicionY = (int)(Math.random()*2);

    if(tanque[posicionX][posicionY] != null)
    {
    tanque[posicionX][posicionY] = null;
    }
    else
    {
      atomica(tanque);
    }
  }

  public void activator(String[][] tanque)
  {
    String minimo = "";
    int contador = 0;
    int numeroMinimo = 0;
    int posX= 0;
    int posY =0;
    
    for(int i = 0; i < 2; i++)
    {
      for (int j = 0; j < 2; j++)
      {            
        if(tanque[i][j] != null)
        {  
          contador += 1;                            
          String primero = tanque[i][j].substring(0, 3);
          String tString = tanque[i][j].substring(3,tanque[i][j].length());
          int numero = Integer.parseInt(tString);
                  
          if(contador == 1)
          {
            minimo = primero + String.valueOf(numero);
            numeroMinimo = numero;
            posX = i;
            posY = j;
           }
                  
           else if(numero < numeroMinimo )
           {
             minimo = primero + String.valueOf(numero);
             posX = i;
             posY = j;
           }          
         }
       }
     }
    
     String primero = tanque[posX][posY].substring(0, 3);
     String tString = tanque[posX][posY].substring(3,tanque[posX][posY].length());
     int numero = Integer.parseInt(tString)*2;
     tanque[posX][posY] = primero + String.valueOf(numero);
   }

  public String frase ()
  {
    return "No se puede parar un tanque pero puede partirse el corazon del guerrero que lo conduce.";
  }
  
}
