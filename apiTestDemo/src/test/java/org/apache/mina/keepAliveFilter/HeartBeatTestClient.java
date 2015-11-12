package org.apache.mina.keepAliveFilter;

import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * <p>File：HeartBeatTestClient.java</p>
 * <p>Title: mina心跳过滤器测试（客户端）</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-5 下午4:04:29</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class HeartBeatTestClient {
	
	/**
	 * Logger for this class
	 */
	private static final Logger			logger				= Logger.getLogger(HeartBeatTestClient.class);
	

	private static final int PORT = 8889;
	/** 30秒后超时 */
	private static final int IDELTIMEOUT = 30;
	/** 15秒发送一次心跳包 */
	private static final int HEARTBEATRATE = 15;
	/** 心跳包内容 */
	private static final String HEARTBEATREQUEST = "HEARTBEATREQUEST";
	private static final String HEARTBEATRESPONSE = "HEARTBEATRESPONSE";
	
	private static final String IPADDRESS = "192.168.1.125";

	private static NioSocketConnector connector;
	private static IoHandler handler = new HeartBeatClientHandler();

	public static void main(String[] args) {
		connector = new NioSocketConnector();
		connector.getFilterChain().addLast("log", new LoggingFilter());
		connector.getFilterChain().addLast("code", new ProtocolCodecFilter(new TextLineCodecFactory()));
		connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, IDELTIMEOUT);
		
		/** 心跳过滤器 */
		KeepAliveMessageFactory heartBeatFactory = new KeepAliveMessageFactoryImpl();
		KeepAliveRequestTimeoutHandler heartBeatHandler = new KeepAliveRequestTimeoutHandlerImpl();
		KeepAliveFilter heartBeat = new KeepAliveFilter(heartBeatFactory, IdleStatus.BOTH_IDLE, heartBeatHandler);
		/** 闲置时，是否回调sessionIdle() */
		heartBeat.setForwardEvent(false);
		/** 心率 */
		heartBeat.setRequestInterval(HEARTBEATRATE);
		connector.getSessionConfig().setKeepAlive(true);
		connector.getFilterChain().addLast("heartbeat", heartBeat);

		/** *********** */
		connector.setHandler(handler);
		connector.connect(new InetSocketAddress(IPADDRESS, PORT));
		logger.info("客户端已连接上！");
	}

	/***
	 * @ClassName: KeepAliveMessageFactoryImpl
	 * @Description: 内部类，实现心跳工厂
	 * @author Minsc Wang ys2b7_hotmail_com
	 * @date 2011-3-7 下午04:09:02
	 * 
	 */
	private static class KeepAliveMessageFactoryImpl implements KeepAliveMessageFactory {

		/**
		 * 根据心率回调该接口，发送心跳请求
		 * （策略：客户端不发送心跳请求，只接收服务端心跳请求并回复）
		 */
		public Object getRequest(IoSession session) {
			logger.info("client getRequest：null");
			return null;
		}

		/**
		 * isRequest()==true时回调，返回（预设的）心跳回复
		 */
		public Object getResponse(IoSession session, Object request) {
			logger.info("client getResponse（返回预设语句）：" + HEARTBEATRESPONSE);
			/** 返回预设语句 */
			return HEARTBEATRESPONSE;
		}

		/**
		 * 判断请求是否是心跳请求
		 * 注意：心跳消息，不会触发 messageSent() 和　messageReceived()
		 * 
		 * 如果判断通过，则不继续调用　isResponse() 进行判断
		 */
		public boolean isRequest(IoSession session, Object message) {
			if(message.equals(HEARTBEATREQUEST)) {
				logger.info("client isRequest（是心跳包）: " + message);
				return true;
			}
				logger.info("client isRequest（不是心跳包）: " + message);
			return false;
		}

		/**
		 * 判断请求是否是心跳回复
		 * 注意：心跳消息，不会触发 messageSent() 和　messageReceived()
		 */
		public boolean isResponse(IoSession session, Object message) {
			if(message.equals(HEARTBEATRESPONSE)) {
				logger.info("client isResponse（是心跳包）: " + message);
				return true;
			}
			logger.info("client isResponse（不是心跳包）: " + message);
			return false;
		}

	}

	/**
	 * <p>File：HeartBeatTestClient.java</p>
	 * <p>Title: 心跳超时处理器</p>
	 * <p>Description:</p>
	 * <p>Copyright: Copyright (c) 2015 2015-2-5 下午3:16:01</p>
	 * <p>Company: 8637.com</p>
	 * @author 周光暖
	 * @version 1.0
	 */
	private static class KeepAliveRequestTimeoutHandlerImpl implements KeepAliveRequestTimeoutHandler {

		/**
		 * 当发送心跳请求得不到心跳回复时，回调。
		 */
		public void keepAliveRequestTimedOut(KeepAliveFilter filter, IoSession session) throws Exception {
			logger.info("client keepAliveRequestTimedOut（心跳超时！）");
		}

	}
}
