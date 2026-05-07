package oy.tol.chatclient;

import oy.tol.chat.Message;

public interface ChatClientDataProvider {
	String getServer();
	int getPort();
	String getNick();
	void handleReceived(Message message);
	void connectionClosed();
}
