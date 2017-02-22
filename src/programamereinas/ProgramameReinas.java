/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programamereinas;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author salcu
 */
public class ProgramameReinas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ent=new Scanner(System.in);
        Pattern pattern=null;
            try{
                pattern  = Pattern.compile("\\d+");
            }catch(PatternSyntaxException e){            
                System.out.println("Error a l'expressió regular: "+e.getDescription()+"\nTorna-ho a provar.");
              
            }
        int dim=Integer.valueOf(ent.next(pattern));
        int reinas=Integer.valueOf(ent.next(pattern));
            
        while (dim!=0 || reinas!=0) {
            boolean atacadas=reinas>dim;
            int[] filas=new int[dim];
            int[] columnas=new int[dim];
            int[] diagDU=new int[2*(dim-1)+1];
            int[] diagUD=new int[2*(dim-1)+1];
            while(reinas-->0){
                int fila=Integer.valueOf(ent.next(pattern))-1;
                int columna=Integer.valueOf(ent.next(pattern))-1;
                if(!atacadas){
                    if(filas[fila]==1 || columnas[columna]==1 || diagUD[fila-columna+dim-1]==1 || diagDU[fila+columna]==1) {
                        atacadas=true;
                        continue;
                    }
                    filas[fila]++;
                    columnas[columna]++;
                    diagUD[fila-columna+dim-1]++;
                    diagDU[fila+columna]++;
                }
            }
            if(atacadas) System.out.println("SI");
            else System.out.println("NO");
            dim=Integer.valueOf(ent.next(pattern));
            reinas=Integer.valueOf(ent.next(pattern));
        }
        ent.close();
    }
    
}
 