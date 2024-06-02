
package Programa2TAYDA;


public class Letras {
    char[] baldosas;
    Letras(String baldosa){
        this.baldosas=baldosa.toCharArray();
        mayus();
    }
    private void mayus(){
        for(int i=0;i<baldosas.length;i++){
            if(baldosas[i]=='b'){
                baldosas[i]='B';
            }
            if(baldosas[i]=='n'){
                baldosas[i]='N';
            }
            if(baldosas[i]=='g'){
                baldosas[i]='G';
            }
            if(baldosas[i]=='r'){
                baldosas[i]='R';
            }
        }
    }
    public char [] verificar(){
        boolean flagB=false,flagG=false,flagN=false;
        if(baldosas[0]=='R'){
            switch(baldosas[1]){
                case 'B':
                    baldosas[0]='N';
                    break;
                case 'G':
                    baldosas[0]='B';
                    break;
                case 'N':
                    baldosas[0]='G';
                    break;
                case 'R':
                    baldosas[0]='B';
                    break;
                    
            }
        }
        
        for(int i=1;i<baldosas.length-1;i++){
            
            if(baldosas[i]=='R'){
                if(i==baldosas.length-2){
                    switch(baldosas[i-1]){
                        case 'B':
                            flagB=true;
                            break;
                        case 'G':
                            flagG=true;
                            break;
                        case 'N':
                            flagN=true;
                            break;
                        }
                    switch(baldosas[i+1]){
                        case 'B':
                            flagB=true;
                            break;
                        case 'G':
                            flagG=true;
                            break;
                        case 'N':
                            flagN=true;
                            break;
                        }
                    if(flagN){
                        baldosas[i]='B';
                    }
                    if(flagG){
                        baldosas[i]='N';
                    }
                    if(flagB){
                        baldosas[i]='G';
                    }
                    if(flagN&&flagG){
                        baldosas[i]='B';
                    }
                    if(flagN&&flagB){
                        baldosas[i]='G';
                    }
                    if(flagG&&flagB){
                        baldosas[i]='N';
                    }
                    break;
                }else{
                    switch(baldosas[i+1]){
                        case 'B':
                            flagB=true;
                            break;
                        case 'G':
                            flagG=true;
                            break;
                        case 'N':
                            flagN=true;
                            break;
                        }
                    switch(baldosas[i-1]){
                        case 'B':
                            flagB=true;
                            break;
                        case 'G':
                            flagG=true;
                            break;
                        case 'N':
                            flagN=true;
                            break;
                        }
                    if(flagN){
                        baldosas[i]='B';
                    }
                    if(flagG){
                        baldosas[i]='N';
                    }
                    if(flagB){
                        baldosas[i]='G';
                    }
                    if(flagN&&flagG){
                        baldosas[i]='B';
                    }
                    if(flagN&&flagB){
                        baldosas[i]='G';
                    }
                    if(flagG&&flagB){
                        baldosas[i]='N';
                    }
                    
            }
            flagB=false;flagG=false;flagN=false; 
            
            }
        }
        
        if(baldosas[baldosas.length-1]=='R'){
            switch(baldosas[baldosas.length-2]){
                case 'B':
                    baldosas[baldosas.length-1]='G';
                    break;
                case 'G':
                    baldosas[baldosas.length-1]='N';
                    break;
                case 'N':
                    baldosas[baldosas.length-1]='B';
                    break;
            }
        }
        
        return baldosas;
    }
    
}
