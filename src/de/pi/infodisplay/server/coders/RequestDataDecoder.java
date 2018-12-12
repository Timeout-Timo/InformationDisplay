package de.pi.infodisplay.server.coders;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import de.pi.infodisplay.shared.packets.InfoDisplayPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

public class RequestDataDecoder extends ReplayingDecoder<RequestData> {
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		RequestData data = new RequestData();
		//Packets
		final List<InfoDisplayPacket> contents = new ArrayList<>();
		//Anzahl der Packets als ersten int schicken
		for(int i = 0; i < in.readInt(); i++) {
			//Dann vor jedem Packet L�nge des Strings schicken
			int strLen = in.readInt();
			//String lesen
			String str = "";
			for(int y = 0; y < strLen; y++) {
				str += in.readChar();
			}
	        contents.add(InfoDisplayPacket.fromString(str));
		}
		data.setContents((InfoDisplayPacket[]) contents.toArray());
	}

}
