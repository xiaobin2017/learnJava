package com.pagoda.jzOver.day01;

/**
 * 单例设计模式
 * 懒汉式和饿汉式区别：懒汉式是延时加载，需要的时候就加载，线程不安全
 * 				     饿汉式是初始化就加载，先创建
 * @author dell1
 *
 */
public class Test01 {
	/**
	 * 饿汉式 线程安全
	 */
	public static class Singleton {
		private final static Singleton singleton = new Singleton();

		private Singleton() {

		}

		public static Singleton getInstance() {
			return singleton;
		}
	}

	/**
	 * 懒汉式 线程不安全
	 */

	public static class Singleton2 {
		private static Singleton2 SINGLETON2 = null;

		private Singleton2() {
		}

		public static Singleton2 getInstance() {
			if (SINGLETON2 == null) {
				SINGLETON2 = new Singleton2();
			}
			return SINGLETON2;
		}
	}

	/**
	 * 懒汉式，线程安全，加同步代码，多线程下不高效
	 */
	public static class Singleton3 {
		private static Singleton3 Singleton3 = null;

		private Singleton3() {
		}

		public static synchronized Singleton3 getInstance() {
			if (Singleton3 == null) {
				Singleton3 = new Singleton3();
			}
			return Singleton3;
		}
	}

	/**
	 * 懒汉式，线程安全 使用静态代码块
	 */
	public static class Singleton4 {
		private static Singleton4 SINGLETON4 = null;

		static {
			SINGLETON4 = new Singleton4();
		}

		private Singleton4() {
		}

		public static Singleton4 getInstance() {
			return SINGLETON4;
		}
	}

	/**
	 * 单例模式，使用静态内部类，线程安全【推荐】
	 */
	public static class Singleton5 {

		public final static class SingleHolder {

			private static final Singleton5 SINGLETON5 = new Singleton5();
		}

		private Singleton5() {
		}

		public static Singleton5 getInstance() {
			return SingleHolder.SINGLETON5;
		}

	}

	/**
	 * 静态内部类 使用枚举 线程安全
	 */

	/**
	 * 双重校验锁
	 */
	public static class Singleton7 {

		private static volatile Singleton7 SINGLETON5 = null;

		private Singleton7() {
		}

		public static Singleton7 getInstance() {
			if (SINGLETON5 == null) {
				synchronized (Singleton7.class) {
					if (SINGLETON5 == null) {
						SINGLETON5 = new Singleton7();
					}
				}
			}
			return SINGLETON5;
		}

	}

}
