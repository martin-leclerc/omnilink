package net.homeip.mleclerc.omnilink.message;

import net.homeip.mleclerc.omnilink.CommunicationException;
import net.homeip.mleclerc.omnilink.enumeration.ProtocolTypeEnum;
import net.homeip.mleclerc.omnilink.enumeration.SystemTypeEnum;
import net.homeip.mleclerc.omnilink.messagebase.AcknowledgeReplyMessage;
import net.homeip.mleclerc.omnilink.messagebase.ProtocolTypeHelper;
import net.homeip.mleclerc.omnilink.messagebase.ReplyMessage;
import net.homeip.mleclerc.omnilink.messagebase.RequestMessage;

@SuppressWarnings("serial")
public class AcknowledgeCommand extends RequestMessage {
    public AcknowledgeCommand() {
    }
    
    public void initialize(SystemTypeEnum model, ProtocolTypeEnum protocolType) throws CommunicationException {
    	if (ProtocolTypeHelper.isOmniLinkII(protocolType)) {
    		throw new CommunicationException("Command not supported");
    	} else {
    		super.initialize(model, protocolType, 0x05, 0x01);
    	}
    }

    protected ReplyMessage createReplyMessage() {
        return new AcknowledgeReplyMessage();
    }
}
