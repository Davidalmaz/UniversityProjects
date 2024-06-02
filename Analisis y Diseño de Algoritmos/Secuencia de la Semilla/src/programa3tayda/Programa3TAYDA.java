package programa3tayda;

import java.util.Scanner;

public class Programa3TAYDA 
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        //S -> Semilla de la secuencia
        //L -> Largo Máximo
        //LoF -> Variable para retornar el último valor o el largo alcanzado
        //P -> Cantidad de valores pares
        //I -> Cantidad de valores impares
        //N -> Largo Máximo de seguidillas ascenso-descenso
        
        int S,s,L,l=1,LoF=0,lof=0,P=0,I=0,N=0,cont=0,n=0,aux,aux2,x=0;
        System.out.println("Ingrese el valor de la semilla 'S': ");
        S=sc.nextInt();
        s=S;
        System.out.println("Ingrese el valor del largo máximo 'L': ");
        L=sc.nextInt();
        System.out.println(S);
        aux=S;aux2=aux;
        while(cont!=L)
        {
          if(n>=N){
              N=n;
          }
           if(S!=1 && L!= l)
           {
               if(S%2==0)
               {
                   aux2=aux;aux=S; 
                   S/=2;
                   if(x==0){
                   if(S<aux && aux>aux2)
                       n++;
                   else
                       n=0;}
                   System.out.println(S);
                   cont++;LoF++;P++;l++;                
               }
               else
               { 
                   aux2=aux;aux=S;
                   S=(S*3)+1; 
                   if(S>aux && aux<aux2)
                       n++;
                   else
                       n=0;
                   System.out.println(S);
                   cont++;LoF++;I++;l++;
               }
           }
           else
           {
               LoF++;I++;
               break;
           }
               
        }
        System.out.println("La secuencia ( S, L, LoF, P, I, N) es:");
        if(S==1)
        {
           System.out.println("S= "+s+" L= "+L+" LoF= "+LoF+" P= "+P+" I= "+I+" N= "+N/2); 
        }
        else
            System.out.println("S= "+s+" L= "+L+" LoF= "+S+" P= "+P+" I= "+I+" N= "+N/2);
    }   
}
