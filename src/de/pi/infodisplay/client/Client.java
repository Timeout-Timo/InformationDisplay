package de.pi.infodisplay.client;

import de.pi.infodisplay.client.netty.NettyClient;

/**
 * Diese Klasse soll den Client darstellen.
 * @author PI A
 *
 */
public class Client {
	
	/**
	 * Das ist das Field für den NettyClient. Der NettyClient
	 * ist für die Verbindung zum Server und das Netzwerk verantwortlich.
	 * Hierüber werden alle Packets gesendet und empfangen.
	 * 
	 * Hier wird das Field nur deklariert. Die Initialisierung findet im Constructor statt.
	 */
	private NettyClient netty;
	
	private Console console;
	
	/**
	 * Das ist der Constructor für die Clientklasse.
	 * Hier werden alle Werte mit den richtigen Werten initialisiert.
	 * Dabei werden die richtigen Werte aus dem Parametern benutzt.
	 * Sie werden nicht auf Richtogkeit überprüft.
	 * 
	 * @param host Die IPv4-Adresse des Servers
	 * @param port Der Port des Servers
	 */
	public Client(String host, int port) {
		// Initialisierung NettyClient
		this.netty = new NettyClient(this, host, port);
		new Thread(netty).start();
		// Initialisierung GUI-Interface
		this.console = new Console("InformationDisplay", this);
	}
	
	/**
	 * Diese Methode gibt den NettyClient zurück.
	 * 
	 * Hierbei ist der NettyClient der Teil des Clients, der sich um die Netzwerkprotokolle
	 * und die Packets kümmert.
	 * Zudem kümmert sich der NettyClient auch um das Encoden / Decoden der Packets.
	 * @return Den NettyClient des Clients.
	 */
	public NettyClient getNettyClient() {
		return netty;
	}
	
	public Console getTerminal() {
		return console;
	}
}
