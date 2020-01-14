package redis_20200114;

import redis_20200114.bean.BeanSimple;
import redis_20200114.bean.BeanWithBase;
import redis_20200114.bean.BeanWithConstructor;
import redis_20200114.bean.BeanWithStatic;
import redis_20200114.serials.SerializeUtils;

public class RedisSerial {
	RedisLo redislo = new RedisLo();
	
	BeanSimple beansimple;
	BeanWithBase beanwithbase;
	BeanWithConstructor beanwithconstructor;
	BeanWithStatic beanwithstatic;
	
	RedisSerial() {
		redislo.connect();
	}
	
	public void beanInit() {
		beansimple = new BeanSimple();
		beansimple.setPrivateInt(1);
		beansimple.setPrivateString("No.1");
		
		beanwithbase = new BeanWithBase();
		beanwithbase.setPrivateInt(2);
		beanwithbase.setPrivateString("No.2");
		beanwithbase.setPrivateIntSon(22);
		beanwithbase.setPrivateStringSon("No.22");
		
		beanwithconstructor = new BeanWithConstructor(2020, "0114");
		
		beanwithstatic = new BeanWithStatic();
		BeanWithStatic.privateStaticInt = 4;
		BeanWithStatic.privateStaticString = "No.4";
		beanwithstatic.setPrivateInt(4);
		beanwithstatic.setPrivateString("No.4");
	}
	
	public void beanDestory() {
		beansimple = null;
		beanwithbase = null;
		beanwithconstructor = null;
		beanwithstatic = null;
	}
	
	public void printBean() {
		System.out.println(beansimple);
		System.out.println(beanwithbase);
		System.out.println(beanwithconstructor);
		System.out.println(beanwithstatic);
	}
	
	public void serialBeanAndSet() {
		redislo.set(BeanSimple.class.getName(), SerializeUtils.serialize(beansimple));
		redislo.set(BeanWithBase.class.getName(), SerializeUtils.serialize(beanwithbase));
		redislo.set(BeanWithConstructor.class.getName(), SerializeUtils.serialize(beanwithconstructor));
		redislo.set(BeanWithStatic.class.getName(), SerializeUtils.serialize(beanwithstatic));
	}
	
	public void deserialBeanAndGet() {
		beansimple = (BeanSimple) SerializeUtils.deSerialize(redislo.get(BeanSimple.class.getName().getBytes()));
		beanwithbase = (BeanWithBase) SerializeUtils.deSerialize(redislo.get(BeanWithBase.class.getName().getBytes()));
		beanwithconstructor = (BeanWithConstructor) SerializeUtils.deSerialize(redislo.get(BeanWithConstructor.class.getName().getBytes()));
		beanwithstatic = (BeanWithStatic) SerializeUtils.deSerialize(redislo.get(BeanWithStatic.class.getName().getBytes()));
	}
	
	public static void main(String []args) {

		RedisSerial redisserial = new RedisSerial();
		
		System.out.println("Before......");
		redisserial.beanInit();
		redisserial.printBean();
		redisserial.serialBeanAndSet();
		
		redisserial.beanDestory();
		System.out.println("Setted......");
		redisserial.printBean();
		
		System.out.println("Getted......");
		redisserial.deserialBeanAndGet();
		redisserial.printBean();
	}
}
