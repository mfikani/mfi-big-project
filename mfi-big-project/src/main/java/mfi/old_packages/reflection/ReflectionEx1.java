package mfi.old_packages.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionEx1 {
	
	public Object invokeMethod( Object target, String methodName, Object[] params, Class<?>[] paramsTyle){
		Class<?> myClass = target.getClass();
		Object returnObj = null;
		System.out.println("invokeMethod start ");
		for(Method m : myClass.getDeclaredMethods()){
			System.out.println(" looping of the ");
			if(methodName.equals(m.getName())){
				if(Modifier.isPrivate(m.getModifiers())){
					m.setAccessible(true);
				}
				
				try{
					returnObj = m.invoke(target, params);
					
				}catch(IllegalAccessException e){
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return returnObj;
	}
	public static void main(String[] args){
		System.out.println("Reflection >>>>  invoking method of a class : START");
		ReflectionEx1 r = new ReflectionEx1();
		System.out.println("-- calling the method : ReflectionEx1/invokeMethod");
		Object result =  r.invokeMethod(new Milz(),"sayHiMilz", new Object[]{"Good"}, new Class[]{String.class});
		System.out.println(result);
	}
}

class Milz{
	private String sayHiMilz(String value){
		System.out.println("Class "+this.getClass().getName()+": method: sayHiMilz Invoked");
		return "I am Milzzzz "+value;
	}
}
