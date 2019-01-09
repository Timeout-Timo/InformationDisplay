package de.pi.infodisplay.shared.handler;

/**
 * Die Klasse PacketHandler ist ein Konstrukt, dass den Decoder und Encoder
 * verallgemeinert als ein Objekt darstellen soll.
 * 
 * @author PI A
 *
 */
public class PacketHandler {
	
	/**
	 * Dieses Field ist das private Field f�r Decoder.
	 * Der Decoder soll die Packets, die reinkommen, decodieren,
	 * Quasi lesbar f�r den Java-Compiler machen.
	 * 
	 * Hier wird lediglich das Decoder-Field deklariert,
	 * welches im PacketHandler-Constructor initialisiert wird.
	 */
	private PacketDecoder decoder;
	
	/**
	 * Dieses Field ist das private Field f�r den Encoder.
	 * Der Encoder ist das Gegenst�ck vom Decoder und codiert die Packete zu
	 * einem ByteBuf, der dann �ber Netty versendet werden kann.
	 * 
	 * Auch hier wird lediglich das Encoder-Field deklariert,
	 * welches im PacketHandler initialisiert wird.
	 */
	private PacketEncoder encoder;
	
	/**
	 * Dieses Field ist der Standardkonstruktor dieser Klasse.
	 * Hier werden die oben genannten Fields initialisiert.
	 */
	public PacketHandler() {
		// Initialisierung Decoder
		this.decoder = new PacketDecoder();
		// Intialisierung Encoder
		this.encoder = new PacketEncoder();
	}
	
	/**
	 * Diese Methode gibt die Referenz des Decoders f�r dieses Objekt zur�ck.
	 * Dadurch ist es m�glich, auf den Decoder aus externer Sichtweise zuzugreifen.
	 * 
	 * @return den Decoder als PacketDecoder
	 */
	public PacketDecoder getDecoder() {
		return decoder;
	}
	
	/**
	 * Diese Methode gibt die Referenz des Encoders f�r dieses Objekt zur�ck.
	 * Dadurch ist es m�glich, auf den Encoder aus externer Sichtweise zuzugreifen.
	 * 
	 * @return den Encoder als PacketEncoder
	 */
	public PacketEncoder getEncoder() {
		return encoder;
	}
}
