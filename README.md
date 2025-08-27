# ReseauJava

ReseauJava is a simple Java tool for performing subnet calculations on IPv4 addresses using CIDR notation. It allows you to input an IP address and CIDR (e.g. `192.168.1.10/24`) and outputs the following network information:

- Subnet mask
- Network address
- Broadcast address
- Minimum host address
- Maximum host address

## Features

- **Input validation** for both IP address and CIDR
- Computes all essential subnet parameters
- Output is easy to read and suitable for educational purposes

## Usage

### Prerequisites

- Java 8 or higher

### Compilation

```bash
javac reseaujava/ClassIp.java reseaujava/ReseauJava.java
```

### Running

Provide the IP address and CIDR as an argument:

```bash
java reseaujava.ReseauJava 192.168.1.10/24
```

### Example Output

```
Pour l'adresse IP 192.168.1.10/24 nous avons :
Masque de sous-réseau : 255.255.255.0
Adresse réseau : 192.168.1.0
Adresse de broadcast : 192.168.1.255
Adresse minimale : 192.168.1.1
Adresse maximale : 192.168.1.254
```

If you do not provide any argument:

```
Aucune adresse IP n'a été fournie.
```

If you provide an invalid address or CIDR:

```
Erreur : L'adresse IP est invalide.
Erreur : Le CIDR est invalide.
```

## Code Structure

- `ReseauJava.java`: Entry point, handles arguments and output
- `ClassIp.java`: Static methods and fields for subnet calculations

## How It Works

1. **Argument Parsing:**  
   The program expects one argument in the format `IP/CIDR`, e.g. `10.0.0.1/8`.
2. **Validation:**  
   Ensures the IP and CIDR are within valid ranges.
3. **Calculation:**  
   Uses bitwise operations to calculate subnet mask, network address, broadcast address, and min/max usable addresses.
4. **Display:**  
   Outputs the results to the console.
