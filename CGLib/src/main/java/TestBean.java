/**
 * @ClassName TestBean
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/6/22 11:58 上午
 * @Return
 */
public class TestBean {
    public static void main(String[] args) {
        Girl girl = new Girl();
        Girl proxy = (Girl)new CGLibFactory(girl).createProxy();
        proxy.eat();
        System.out.println("=======================");
        proxy.bath();
    }
}
