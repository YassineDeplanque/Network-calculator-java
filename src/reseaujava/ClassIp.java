package reseaujava;
 
public class ClassIp {
 
	public static int octetA;
	public static int octetB;
	public static int octetC;
	public static int octetD;
	public static int cidr;
 
	public static boolean verifierOctet(int octet) {
    	return octet >= 0 && octet <= 255;
	}
 
	public static boolean verifierCidr(int cidr) {
    	return cidr >= 0 && cidr <= 32;
	}
 
	public static String calculeMasque() {
    	int masque = 0xFFFFFFFF << (32 - cidr);
    	int masqueA = (masque >> 24) & 0xFF;
    	int masqueB = (masque >> 16) & 0xFF;
    	int masqueC = (masque >> 8) & 0xFF;
    	int masqueD = masque & 0xFF;
 
    	return masqueA + "." + masqueB + "." + masqueC + "." + masqueD;
	}
 
	public static String calculeAdresseReseau() {
    	int masque = 0xFFFFFFFF << (32 - cidr);
    	int masqueA = (masque >> 24) & 0xFF;
    	int masqueB = (masque >> 16) & 0xFF;
    	int masqueC = (masque >> 8) & 0xFF;
    	int masqueD = masque & 0xFF;
 
    	int reseauA = octetA & masqueA;
    	int reseauB = octetB & masqueB;
    	int reseauC = octetC & masqueC;
    	int reseauD = octetD & masqueD;
 
    	return reseauA + "." + reseauB + "." + reseauC + "." + reseauD;
	}
 
 	public static String calculBroadcast() {
    	int masque = 0xFFFFFFFF << (32 - cidr);
    	int masqueA = (masque >> 24) & 0xFF;
    	int masqueB = (masque >> 16) & 0xFF;
    	int masqueC = (masque >> 8) & 0xFF;
    	int masqueD = masque & 0xFF;
 
    	int broadcastA = (octetA & masqueA) | (~masqueA & 0xFF);
    	int broadcastB = (octetB & masqueB) | (~masqueB & 0xFF);
    	int broadcastC = (octetC & masqueC) | (~masqueC & 0xFF);
    	int broadcastD = (octetD & masqueD) | (~masqueD & 0xFF);
 
    	return broadcastA + "." + broadcastB + "." + broadcastC + "." + broadcastD;
	}
 
 	public static String calculeAdresseMin() {
	int masque = 0xFFFFFFFF << (32 - cidr);
	int masqueA = (masque >> 24) & 0xFF;
	int masqueB = (masque >> 16) & 0xFF;
	int masqueC = (masque >> 8) & 0xFF;
	int masqueD = masque & 0xFF;
 
	int minA = (octetA & masqueA);
	int minB = (octetB & masqueB);
	int minC = (octetC & masqueC);
	int minD = (octetD & masqueD) + 1;
 
	return minA + "." + minB + "." + minC + "." + minD;
}
 
 	public static String calculeAdresseMax() {
	int masque = 0xFFFFFFFF << (32 - cidr);
	int masqueA = (masque >> 24) & 0xFF;
	int masqueB = (masque >> 16) & 0xFF;
	int masqueC = (masque >> 8) & 0xFF;
	int masqueD = masque & 0xFF;
 
	int maxA = (octetA & masqueA) | (~masqueA & 0xFF);
	int maxB = (octetB & masqueB) | (~masqueB & 0xFF);
	int maxC = (octetC & masqueC) | (~masqueC & 0xFF);
	int maxD = ((octetD & masqueD) | (~masqueD & 0xFF)) - 1;
 
	return maxA + "." + maxB + "." + maxC + "." + maxD;
}
 
 
 
	public static boolean decoupe(String ip) {
    	String[] ipParts = ip.split("/");
    	String[] octets = ipParts[0].split("\\.");
 
    	if (octets.length != 4) {
        	System.out.println("Erreur : L'adresse IP est invalide.");
        	return false;
    	}
 
    	octetA = Integer.parseInt(octets[0]);
    	octetB = Integer.parseInt(octets[1]);
    	octetC = Integer.parseInt(octets[2]);
    	octetD = Integer.parseInt(octets[3]);
 
    	if (!verifierOctet(octetA) || !verifierOctet(octetB) || !verifierOctet(octetC) || !verifierOctet(octetD)) {
        	System.out.println("Erreur : L'adresse IP est invalide.");
        	return false;
    	}
 
    	cidr = Integer.parseInt(ipParts[1]);
    	if (!verifierCidr(cidr)) {
        	System.out.println("Erreur : Le CIDR est invalide.");
        	return false;
    	}
    	return true;
}
}