
package TCP;


import java.io.*;
import java.net.*;


public class ClientTCP {
    public static void main(String[] args)throws Exception{
        String phrase ,phraseModifiee;
        try {
            //creer le flux d'entrer 
            while(true){
            BufferedReader entreeDepuisUtilisateur =new BufferedReader(new InputStreamReader(System.in));
            
            //creer socket client et la connection du Serveur
            
            Socket socketClient=new Socket("localhost",Integer.parseInt("123"));
            
            //creer le flux de Sortie attache a la Socket
            DataOutputStream sortieVersServeur=new DataOutputStream(socketClient.getOutputStream());        
            //creer le flux d'entreer attache a la socket
            BufferedReader entreeDepuisServeur=new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            phrase= entreeDepuisUtilisateur.readLine();
            //envoyer la chaine au Serveur
            
            sortieVersServeur.writeBytes(phrase+'\n');
            //lire chaine depuis serveur
            
            phraseModifiee=entreeDepuisServeur.readLine();
            
            System.out.println("reponse Serveur :"+phraseModifiee);
            
           socketClient.close();
       }
        }catch (IOException e) {
            System.out.println(e);
        }
    }
  }