/**   
 * @Title: HeartBeatClientHandler.java 
 * @Package com.underdark.March 
 * @Description:  
 * @author Minsc Wang ys2b7_hotmail_com   
 * @date 2010-3-14 下午03:21:13 
 * @version V0.9.0 
 */
package org.apache.mina.keepAliveFilter;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: HeartBeatServerHandler
 * @Description: 心跳测试客户端消息处理
 * @author Minsc Wang ys2b7_hotmail_com
 * @date 2011-3-7 下午02:49:14
 * 
 */
public class HeartBeatClientHandler extends IoHandlerAdapter {

	private static final Logger LOG = LoggerFactory
			.getLogger(HeartBeatClientHandler.class);

	private static final String START = "心跳消息测试开始";

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		LOG.info("client exceptionCaught");
		cause.printStackTrace();
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		LOG.info("client messageReceived:  " + (String) message);
		super.messageReceived(session, message);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		LOG.info("client messageSent:  " + (String) message);
		super.messageSent(session, message);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		LOG.info("client sessionClosed");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		LOG.info("client sessionIdle" + status.toString());
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		LOG.info("client sessionOpened");
		LOG.info("leaf:  " + START);
		session.write(START);
	}
}
