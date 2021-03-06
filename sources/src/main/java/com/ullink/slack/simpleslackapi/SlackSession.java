package com.ullink.slack.simpleslackapi;

import com.ullink.slack.simpleslackapi.impl.SlackChatConfiguration;
import com.ullink.slack.simpleslackapi.listeners.*;
import com.ullink.slack.simpleslackapi.replies.*;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface SlackSession {

    Collection<SlackChannel> getChannels();

    Collection<SlackUser> getUsers();

    Collection<SlackBot> getBots();

    SlackChannel findChannelByName(String channelName);

    SlackChannel findChannelById(String channelId);

    SlackUser findUserById(String userId);

    SlackUser findUserByUserName(String userName);

    SlackUser findUserByEmail(String userMail);

    SlackPersona sessionPersona();

    SlackMessageHandle<EmojiSlackReply> listEmoji();

    void refetchUsers();

    @Deprecated
    SlackBot findBotById(String botId);
    

    SlackMessageHandle<ParsedSlackReply> inviteUser(String email, String firstName, boolean setActive);

    void connect() throws IOException;

    void disconnect() throws IOException;

    SlackMessageHandle<SlackMessageReply> deleteMessage(String timeStamp, SlackChannel channel);

    SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, SlackPreparedMessage preparedMessage, SlackChatConfiguration chatConfiguration);

    SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, SlackPreparedMessage preparedMessage);

    SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message, SlackAttachment attachment, SlackChatConfiguration chatConfiguration, boolean unfurl);

    SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message, SlackAttachment attachment, SlackChatConfiguration chatConfiguration);

    SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message, SlackAttachment attachment, boolean unfurl);

    SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message, SlackAttachment attachment);

    SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message, boolean unfurl);

    SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message);

    SlackMessageHandle<SlackMessageReply> sendFile(SlackChannel channel, byte [] data, String fileName);

    SlackMessageHandle<SlackMessageReply> sendMessageToUser(SlackUser user, String message, SlackAttachment attachment);
    
    SlackMessageHandle<SlackMessageReply> sendMessageToUser(String userName, String message, SlackAttachment attachment);
    
    SlackMessageHandle<SlackMessageReply> updateMessage(String timeStamp, SlackChannel channel, String message);

    SlackMessageHandle<SlackMessageReply> sendMessageOverWebSocket(SlackChannel channel, String message);

    SlackMessageHandle<SlackMessageReply> addReactionToMessage(SlackChannel channel, String messageTimeStamp, String emojiCode);

    SlackMessageHandle<SlackChannelReply> joinChannel(String channelName);

    SlackMessageHandle<SlackChannelReply> leaveChannel(SlackChannel channel);
    
    SlackMessageHandle<SlackChannelReply> inviteToChannel(SlackChannel channel, SlackUser user);
    
    SlackMessageHandle<ParsedSlackReply> archiveChannel(SlackChannel channel);

    SlackMessageHandle<SlackChannelReply> openDirectMessageChannel(SlackUser user);

    SlackMessageHandle<SlackChannelReply> openMultipartyDirectMessageChannel(SlackUser... users);

    SlackMessageHandle<SlackMessageReply> sendTyping(SlackChannel channel);

    SlackPersona.SlackPresence getPresence(SlackPersona persona);

    void setPresence(SlackPersona.SlackPresence presence);

    SlackMessageHandle<GenericSlackReply> postGenericSlackCommand(Map<String, String> params, String command);

    void addchannelArchivedListener(SlackChannelArchivedListener listener);

    void removeChannelArchivedListener(SlackChannelArchivedListener listener);

    void addchannelCreatedListener(SlackChannelCreatedListener listener);

    void removeChannelCreatedListener(SlackChannelCreatedListener listener);

    void addchannelDeletedListener(SlackChannelDeletedListener listener);

    void removeChannelDeletedListener(SlackChannelDeletedListener listener);

    void addChannelRenamedListener(SlackChannelRenamedListener listener);

    void removeChannelRenamedListener(SlackChannelRenamedListener listener);

    void addChannelUnarchivedListener(SlackChannelUnarchivedListener listener);

    void removeChannelUnarchivedListener(SlackChannelUnarchivedListener listener);

    void addMessageDeletedListener(SlackMessageDeletedListener listener);

    void removeMessageDeletedListener(SlackMessageDeletedListener listener);

    void addMessagePostedListener(SlackMessagePostedListener listener);

    void removeMessagePostedListener(SlackMessagePostedListener listener);

    void addMessageUpdatedListener(SlackMessageUpdatedListener listener);

    void removeMessageUpdatedListener(SlackMessageUpdatedListener listener);

    void addGroupJoinedListener(SlackGroupJoinedListener listener);

    void removeGroupJoinedListener(SlackGroupJoinedListener listener);


    /*
     * Subscribe to events related to the actions to the slack
     * server. At this time a set of status information is exchanged that
     * is useful to implementing bots.
     * 
     * For example, the current user that is connecting.
     * knowing your own user id will help you stop answering your own
     * questions.
     */
    void addSlackConnectedListener(SlackConnectedListener listner);
    
    void removeSlackConnectedListener(SlackConnectedListener listener);

    void addSlackDisconnectedListener(SlackDisconnectedListener listener);

    void removeSlackDisconnectedListener(SlackDisconnectedListener listener);

    /**
     * 
     * @return true if actions is open
     */
    boolean isConnected();
    
    void addReactionAddedListener(ReactionAddedListener listener);
    
    void removeReactionAddedListener(ReactionAddedListener listener);
    
    void addReactionRemovedListener(ReactionRemovedListener listener);
    
    void removeReactionRemovedListener(ReactionRemovedListener listener);

    void addSlackUserChangeListener(SlackUserChangeListener listener);

    void removeSlackUserChangeListener(SlackUserChangeListener listener);

    void addPinAddedListener(PinAddedListener listener);

    void removePinAddedListener(PinAddedListener listener);

    void addPinRemovedListener(PinRemovedListener listener);
  
    void removePinRemovedListener(PinRemovedListener listener);

    long getHeartbeat();

    void setHeartbeat(long heartbeat, TimeUnit unit);
}
