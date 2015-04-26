/**   
 * @Title: HeartBeatTestServer.java 
 * @Package com.underdark.March 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Minsc Wang ys2b7_hotmail_com   
 * @date 2010-3-14 下午02:49:14 
 * @version V0.9.0 
 */
package org.apache.mina.keepAliveFilter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.executor.OrderedThreadPoolExecutor;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * <p>File：HeartBeatTestServer.java</p>
 * <p>Title: mina心跳过滤器测试（服务端）</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-2-5 下午4:05:12</p>
 * <p>Company: 8637.com</p>
 * @author 周光暖
 * @version 1.0
 */
public class HeartBeatTestServer {
	/**
	 * Logger for this class
	 */
	private static final Logger		logger				= Logger.getLogger(HeartBeatTestServer.class);

	private static final int PORT = 8889;
	/** 30秒后超时 */
	private static final int IDELTIMEOUT = 30;
	/** 15秒发送一次心跳包 */
	private static final int HEARTBEATRATE = 15;
	/** 心跳包内容 */
	private static final String HEARTBEATREQUEST = "HEARTBEATREQUEST";
	private static final String HEARTBEATRESPONSE = "HEARTBEATRESPONSE";
	
	private static SocketAcceptor acceptor;
	private static ExecutorService filterExecutor = new OrderedThreadPoolExecutor();
	private static IoHandler handler = new HeartBeatServerHandler();

	public static void main(String[] args) throws IOException {
		acceptor = new NioSocketAcceptor(Runtime.getRuntime().availableProcessors());
		acceptor.setReuseAddress(true);
		acceptor.getSessionConfig().setReadBufferSize(1024);
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,IDELTIMEOUT);
		// Decrease the default receiver buffer size
		((SocketSessionConfig) acceptor.getSessionConfig()).setReceiveBufferSize(1024);

		// 设置过滤器
		acceptor.getFilterChain().addLast("log", new LoggingFilter());
		acceptor.getFilterChain().addLast("threadPool", new ExecutorFilter(filterExecutor));
		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));

		/** 心跳过滤器 */
		KeepAliveMessageFactory heartBeatFactory = new KeepAliveMessageFactoryImpl();
		KeepAliveRequestTimeoutHandler heartBeatHandler = new KeepAliveRequestTimeoutHandlerImpl();
		KeepAliveFilter heartBeat = new KeepAliveFilter(heartBeatFactory, IdleStatus.BOTH_IDLE, heartBeatHandler);
		/** 闲置时，是否回调sessionIdle() */
		heartBeat.setForwardEvent(false);
		/** 心率 */
		heartBeat.setRequestInterval(HEARTBEATRATE);
		acceptor.getFilterChain().addLast("heartbeat", heartBeat);

		/** *********************** */

		acceptor.setHandler(handler);
		acceptor.bind(new InetSocketAddress(PORT));

		logger.info("服务器开启，监听端口：" + PORT);
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
		 * （策略：根据心率发送心跳请求，得不到心跳回复则回调 keepAliveRequestTimedOut()）
		 */
		@Override
		public Object getRequest(IoSession session) {
			logger.info("serivce getRequest（返回预设语句）：" + HEARTBEATREQUEST);
			/** 返回预设语句 */
			return HEARTBEATREQUEST;
		}

		/**
		 * isRequest()==true时回调，返回（预设的）心跳回复
		 */
		@Override
		public Object getResponse(IoSession session, Object request) {
			logger.info("service getResponse（返回预设语句）：" + HEARTBEATRESPONSE);
			/** 返回预设语句 */
			return HEARTBEATRESPONSE;
		}

		/**
		 * 判断请求是否是心跳请求
		 * 如果是心跳请求，则调用 getResponse()方法，获得回复消息，并发送。
		 * 注意：心跳消息，不会触发 messageSent() 和　messageReceived()
		 * 
		 * 如果判断通过，则不继续调用　isResponse() 进行判断
		 */
		@Override
		public boolean isRequest(IoSession session, Object message) {
			if(message.equals(HEARTBEATREQUEST))
			{
				logger.info("service isRequest（是心跳包）： " + message);
				return true;
			}
			logger.info("service isRequest（不是心跳包）： " + message);
			return false;
		}

		/**
		 * 判断请求是否是心跳回复
		 * 注意：心跳消息，不会触发 messageSent() 和　messageReceived()
		 */
		@Override
		public boolean isResponse(IoSession session, Object message) {
			if(message.equals(HEARTBEATRESPONSE)) {
				logger.info("service isResponse（是心跳包）：" + message);
				return true;
			}
			logger.info("service isResponse（不是心跳包）：" + message);
			return false;
		}

	}

	/**
	 * <p>File：HeartBeatTestServer.java</p>
	 * <p>Title: 心跳超时处理器</p>
	 * <p>Description:</p>
	 * <p>Copyright: Copyright (c) 2015 2015-2-5 下午3:15:24</p>
	 * <p>Company: 8637.com</p>
	 * @author 周光暖
	 * @version 1.0
	 */
	private static class KeepAliveRequestTimeoutHandlerImpl implements KeepAliveRequestTimeoutHandler {

		/**
		 * 当发送心跳请求得不到心跳回复时，回调。
		 */
		@Override
		public void keepAliveRequestTimedOut(KeepAliveFilter filter, IoSession session) throws Exception {
			logger.info("service keepAliveRequestTimedOut（心跳超时！）");
		}

	}
}
