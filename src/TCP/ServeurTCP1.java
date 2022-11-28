package TCP;


import java.net.*;
import java.io.*;


public class ServeurTCP1 {
    public static void main(String[] args) throws Exception{
        String phraseClient,phraseMajuscule;
        try {
            //creer un socket decoute
            ServerSocket socketEcoute =new ServerSocket(Integer.parseInt("123"));
            
            while(true){
                //attendre connexion client
                Socket socketConnexion=socketEcoute.accept();
                //creer flux d entrer attache a la socket
                BufferedReader entreeDepuisClient=new BufferedReader(new InputStreamReader(socketConnexion.getInputStream()));
                
                //creer flux de sortie attache a la socket
                
                DataOutputStream sortieVersClient = new DataOutputStream(socketConnexion.getOutputStream());
                //lire la chaine depuis la socket
                
                phraseClient=entreeDepuisClient.readLine();
                phraseMajuscule=inverse(phraseClient)+'\n';
               
                System.out.println("Connection from :"+socketConnexion.getInetAddress()+"Message Client:"+phraseClient);
                
                //ecrire au client
                
                sortieVersClient.writeBytes(phraseMajuscule);
                
            }//fin boucle attendre une  nouvelle connexion
        } 
        catch (Exception e) {
            System.out.println(e);
        }

    /**
     *
     * @return
     */
 
    }
    public static String inverse(String mot){
        String mot2="";
        int i;
        for(i=mot.length()-1;i>=0;i--){
            mot2+=mot.charAt(i);
        }
        return mot2;
        
        }
    public static String calcul(String cal2){
        String calcul2="";
        int index=0;
        String len1="";
        String len2="";
        for(int i=0;i<cal2.length();i++){
            if(cal2.charAt(i)=='*' || cal2.charAt(i)=='+' || cal2.charAt(i)=='-' || cal2.charAt(i)=='/'){
                index=i;
                break;
            }
            len1+=cal2.charAt(i);   // 
        }
        for(int j=index+1 ;j<cal2.length();j++){
            len2+=cal2.charAt(j);//
        }
        int l1=Integer.parseInt(len1);
        int l2=Integer.parseInt(len2);
        int res=0;
        switch (cal2.charAt(index)) {
            case '+':
                res=l1+l2;
                break;
            case '*':
                res=l1*l2;
                break;
            case '-':
                res=l1-l2;
                break;
            case '/':
                res=l1+l2;
                break;
            default:
                break;
        }
        String res2=String.valueOf(res);
 
        return res2;
    }
    public static String euroAr(String vola){
         int vola2=Integer.parseInt(vola);
         int res=vola2*4000;
         String res2=String.valueOf(res);
         
        return res2;
    }
        
        
        
    }
    

