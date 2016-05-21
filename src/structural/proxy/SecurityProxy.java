package structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SecurityProxy implements InvocationHandler {
	
	private Object obj;
	
	private SecurityProxy(Object obj) {
		this.obj = obj;
	}
	
	public static Object newInstance(Object obj) {
		return java.lang.reflect.Proxy.newProxyInstance
				(
					obj.getClass().getClassLoader(), 
					obj.getClass().getInterfaces(),
					new SecurityProxy(obj)
				);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		
		try {
			if(method.getName().equals("postToTimeline")) {
				throw new IllegalAccessException("Post To Timeline Not permitted");
//				System.out.println("Post To Timeline Not permitted");
			} else {
				result = method.invoke(obj, args);
			}
		} catch(InvocationTargetException e) {
			throw e.getTargetException();
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		} catch(Exception e) {
			throw new RuntimeException("Unexpected Invocation Exception occured !");
		}
		
		return result;
	}
	
}
