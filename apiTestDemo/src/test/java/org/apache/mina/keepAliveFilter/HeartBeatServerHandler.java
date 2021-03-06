/**   
 * @Title: HeartBeatServerHandler.java 
 * @Package com.underdark.March 
 * @Description:  
 * @author Minsc Wang ys2b7_hotmail_com   
 * @date 2010-3-14 下午02:50:40 
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
 * @Description: 心跳测试服务器消息处理
 * @author Minsc Wang ys2b7_hotmail_com
 * @date 2011-3-7 下午02:49:14
 * 
 */
public class HeartBeatServerHandler extends IoHandlerAdapter {

	private static final Logger LOG = LoggerFactory
			.getLogger(HeartBeatServerHandler.class);

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		LOG.info("service exceptionCaught");
		cause.printStackTrace();
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		LOG.info("service messageReceived:  " + (String) message);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		LOG.info("service messageSent:  " + (String) message);
		super.messageSent(session, message);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		LOG.info("service sessionClosed");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		LOG.info("service sessionIdle" + status.toString());
	}
}
