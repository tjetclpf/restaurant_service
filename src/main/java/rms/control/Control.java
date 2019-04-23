package rms.control;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import rms.biz.foodBiz;
import rms.biz.workBiz;
import rms.biz.impl.workBizImpl;

//负责接收客户端连接 创建线程
public class Control { 
	//创建服务器套接字对象
	private ServerSocket server;
	public static final int PORT=9999;
	//创建线程池变量
	private ExecutorService es;
	//创建被代理的对象
	private workBiz sb;
	//构造方法
	public Control() {
		try {
			System.out.println("服务器正在开启中.....");
			//创建服务器
			this. server=new ServerSocket (PORT);
			Thread.sleep(1000);
			System.out.println("服务器已经开启中.....");
			es=Executors.newCachedThreadPool();
			this.sb=new workBizImpl();
		}catch (IOException e){
			e.printStackTrace();
		}catch (InterruptedException e) { 
			e.printStackTrace();
		}
	}

	//自定义方法-项目流程方法
	public void start(){ 
		//创建while循环为死循环 服务器一旦开启不关闭
		while(true){
			//等待客户端连接
			try {
				Socket client = this.server.accept();
				System.out.println("用户"+client.getInetAddress().getHostAddress()+"已连接");
				//创建线程对象
				ControlThread ct=new ControlThread(client,sb);
				//需要将线程对象交给线程池管理
				es.submit(ct);
				//返回当前处于活跃状态的线程数量
				int activeCount=((ThreadPoolExecutor)es).getActiveCount();
				System.out.println("当前在线活跃用户："+activeCount);
			}catch (IOException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}









