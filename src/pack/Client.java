/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

/**
 *
 * Mathieu Latour
 */




public class Client {
    
    public static int nbTotalDeClient = 0;
    
    public static double DEFAULT_ID = 00000;
    public static char DEFAULT_CONTRACT = 'X';
    
    private double ClientID;
    private char ContractType;
    
 public Client(){
    
    DefaultClient();
    nbTotalDeClient ++;
}    
    
    
    
public void DefaultClient(){

    
    ClientID = DEFAULT_ID;
    ContractType =DEFAULT_CONTRACT;    
}


    
private void setClientID(double ClientID){
    this.ClientID = ClientID;
}

private void setContract(char ContractType){
    this.ContractType = ContractType;
}      
    
public double getClientID(){
    return ClientID;
}

public char getContract(){
    return ContractType;
}

}
