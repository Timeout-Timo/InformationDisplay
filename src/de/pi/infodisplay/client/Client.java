package de.pi.infodisplay.client;

import de.pi.infodisplay.client.netty.NettyClient;

/**
 * Diese Klasse soll den Client darstellen.
 * @author PI A
 *
 */
public class Client {
	
	/**
	 * Das ist das Field f�r den NettyClient. Der NettyClient
	 * ist f�r die Verbindung zum Server und das Netzwerk verantwortlich.
	 * Hier�ber werden alle Packets gesendet und empfangen.
	 * 
	 * Hier wird das Field nur deklariert. Die Initialisierung findet im Constructor statt.
	 */
	private NettyClient netty;
	
	/**
	 * Das ist der Constructor f�r die Clientklasse.
	 * Hier werden alle Werte mit den richtigen Werten initialisiert.
	 * Dabei werden die richtigen Werte aus dem Parametern benutzt.
	 * Sie werden nicht auf Richtogkeit �berpr�ft.
	 * 
	 * @param host Die IPv4-Adresse des Servers
	 * @param port Der Port des Servers
	 */
	public Client(String host, int port) {
		// Initialisierung NettyClient
		netty = new NettyClient(host, port);
	}
	
	/**
	 * Diese Methode gibt den NettyClient zur�ck.
	 * 
	 * Hierbei ist der NettyClient der Teil des Clients, der sich um die Netzwerkprotokolle
	 * und die Packets k�mmert.
	 * Zudem k�mmert sich der NettyClient auch um das Encoden / Decoden der Packets.
	 * @return Den NettyClient des Clients.
	 */
	public NettyClient getNettyClient() {
		return netty;
	}
}
