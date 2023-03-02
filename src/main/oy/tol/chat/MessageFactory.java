package oy.tol.chat;

import java.util.UUID;

import org.json.JSONObject;

public class MessageFactory {

	private MessageFactory() {
		// Empty
	}

	public static Message fromJSON(JSONObject jsonObject) {
		Message message = null;
		int msgType = jsonObject.getInt("type");
		switch (msgType) {
			case Message.CHAT_MESSAGE: {
				String id = jsonObject.getString("id");
				UUID theID = UUID.fromString(id);
				String userName = jsonObject.getString("user");
				String msg = jsonObject.getString("message");
				Long date = jsonObject.getLong("sent");
				message = new ChatMessage(theID, date, userName, msg);
				if (jsonObject.has("inReplyTo")) {
					String replyID =jsonObject.getString("inReplyTo");
					((ChatMessage)message).setAsReplyTo(UUID.fromString(replyID));
				}
				break; 
			}

			case Message.JOIN_CHANNEL: {
				String channel = jsonObject.getString("channel");
				String topic = jsonObject.getString("message");
				message = new JoinMessage(channel, topic);
				break; 
			}

			case Message.STATUS_MESSAGE: { 
				String msg = jsonObject.getString("message");
				message = new StatusMessage(msg);
				break; 
			}

			case Message.ERROR_MESSAGE: { 
				String msg = jsonObject.getString("message");
				message = new ErrorMessage(msg);
				break; 
			}
		}
		return message;
	}

}