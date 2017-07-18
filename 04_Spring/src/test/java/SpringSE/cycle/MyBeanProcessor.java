package SpringSE.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanProcessor implements BeanPostProcessor {
	
	/*
	 * 将Bean实例传递给Bean后置处理器的 postProcessBeforeInitialization方法
	 * 该方法要返回一个处理后的Bean
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("postProcessBefore:"+bean+"\t"+beanName);
		return bean;
	}

	/*
	 * 将Bean实例传递给Bean后置处理器的 postProcessAfterInitialization 方法
	 * 该方法要返回一个处理后的Bean
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("postProcessAfter:"+bean+"\t"+beanName);
		return bean;
	}

	
}
