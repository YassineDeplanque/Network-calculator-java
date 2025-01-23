package reseaujava;
 
public class ReseauJava {
 
	public static void main(String[] args) {
    	if (args.length > 0) {
        	ClassIp ip = new ClassIp();
        	boolean result = ip.decoupe(args[0]);
 
        	if (result) {
            	System.out.println("Pour l'adresse IP " + ClassIp.octetA + "." + ClassIp.octetB + "." + ClassIp.octetC + "." + ClassIp.octetD + "/" + ClassIp.cidr + " nous avons :");
            	System.out.println("Masque de sous-réseau : " + ClassIp.calculeMasque());
            	System.out.println("Adresse réseau : " + ClassIp.calculeAdresseReseau());
            	System.out.println("Adresse de broadcast : " + ClassIp.calculBroadcast());
            	System.out.println("Adresse minimale : " + ClassIp.calculeAdresseMin());
            	System.out.println("Adresse maximale : " + ClassIp.calculeAdresseMax());
 
        	} else {
//            	System.out.println("Valeur invalide.");
        	}
    	} else {
        	System.out.println("Aucune adresse IP n'a été fournie.");
    	}
	}
}