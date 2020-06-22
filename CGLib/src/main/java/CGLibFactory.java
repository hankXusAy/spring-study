import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CGLibFactory
 * @Description CGLib动态代理
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/6/22 11:59 上午
 * @Return
 */
public class CGLibFactory implements MethodInterceptor {
    private Object target;

    public CGLibFactory() {
    }

    public CGLibFactory(Object target) {
        this.target = target;
    }

    public Object createProxy(){
        //增强器
        Enhancer enhancer = new Enhancer();
        //创建子类,作为代理类
        enhancer.setSuperclass(Girl.class);
        //设置回调类
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("前");
        method.invoke(target,args);
        System.out.println("后");
        return null;
    }
}
