package rms.control;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class ControlThread implements Runnable {
	private Socket client;
	//创建一个被代理的对象
	private Object o;
	public ControlThread(Socket client,Object o) {
		super();
		this.client = client;
		this.o=o;
	}

	@Override
	public void run(){
		//获取输入流用户接收客户端代理发送的方法名称参数类型参数列表
		try {
			ObjectInputStream ois=new ObjectInputStream(client.getInputStream());
			//获取方法名称
			String methodName = ois.readUTF();
			//获取方法参数列表
			Class<?>[] methodTypes=(Class<?>[]) ois.readObject();
			//获取方法参数列表
			Object[] methodParams=(Object[]) ois.readObject();
			//获取方法对象
			Method method = o.getClass().getMethod(methodName, methodTypes);
			//执行该方法返回结果
			Object result =method.invoke(o, methodParams);
			//创建输出流
			ObjectOutputStream oos=new ObjectOutputStream(client.getOutputStream());
			//将结果发送给客户端
			oos.writeObject(result);
			oos.flush();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) { 
			e.printStackTrace();
		}catch (NoSuchMethodException e) { 
			e.printStackTrace();
		}catch (SecurityException e) {
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}catch (InvocationTargetException e) { 
			e.printStackTrace();
		}
	}

}
