package oy.tol.chat;

import org.json.JSONObject;

public class JoinMessage extends Message {

	private String channel;
	private String nick;

	public JoinMessage(String channel, String nick) {
		super(Message.JOIN_CHANNEL);
		this.channel = channel;
		this.nick = nick;
	}

	public String getChannel() {
		return channel;
	}

	public String getNick() {
		return nick;
	}

	@Override
	public String toJSON() {
		JSONObject object = new JSONObject();
		object.put("type", getType());
		object.put("channel", channel);
		object.put("nick", nick);
		return object.toString();
	}
	
}
