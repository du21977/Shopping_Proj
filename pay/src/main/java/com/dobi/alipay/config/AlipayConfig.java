package com.dobi.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class AlipayConfig {

    // ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092300577761";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDgr34nZFYebxJFzZ3cEtaYcmXAGhsuSL9CjNeLf+w78ZqWLeft6FuCb1GiPHAaCwUCp6ODL37gJcu7FTP4lC7n942TfL++n07n7oe1y/fyb4cJMUN2++B7YGBOaWa8t0V21ZoFYlJ195lohl3RqeqmXqDo/Nuc7bYZ3cqHCwR23Vs7muNx/E/TtZbgnSZvut69O/23DT7I+KV012g2yFL4eRKksEws2rqWILBAwDtAroqe3Fj3LfGStPu4N6pPFMTfr99ADHPzHowdEAXoxpukKaUT4KtPsPS2wI6th9l7TGqkHTUY4qPdlNYUJyZT3s6UXCuEsliZX1l3BOJ1RjONAgMBAAECggEBAJlazpUeY7U0BFnGZLd/2B6G/jHm36RwnLJUpQ2ey2OCnQth28pC7KqTRjmgXLc5zDqqpuz0LvnYcjyH1UgWBAnpqiT/YXQ/EcE1ykToKZy8SIOarzx34Bj1h+YdBLVLtcrNMen42OWRkJCKHWDsQ684KUW8yDxM9xyiiAgyGeLyHV20ARQe9+wy+Tj+6ZpN4+3Y62LQsAbg5vUOM4oO9mlkzOC1gyAKlZCMpj59P75Akg7nJIReYZXInLOvXeWHMaurzsdNohsXcfIIgTBiz9wLaTVt48O9euNKMqRoslEENm6Y0YC8FIpr0vR6TxtOUkn1+ipPd1gYMIAOpUh5T+ECgYEA8IW0Qw+N0JG5ulh5TH/PyVS45H8OlTFnq+B6r6b4CEBBDPd45KdxVZSzFMbC6lF1gNZXdEtGHcLRTD6dIcP7yjj+NW9LqkQieQ0GBfBm04DOfXTRVP+GWeMoLMlKemz51mSK74Zleu6ZsxOAi/0KRP+GCl9o+4Y5W0jvlneNt2kCgYEA7yTl9sBHXL8aVC3aBRgF4LqGZj9ZOchGqVGrhNczYnliOn4BHDsHvOINimF96Duy5IdmiRffWJTR9U58RCuJ193uPWKL9J6rsXydeii2IWnf46G+VM9iQiMQ0075Pr62EpezMMKGeEUeBz/fU7CQ5IgCa3nC+z8jij1y6dJzWoUCgYEA3iZwF1xfXJusEowzBNAsJ8VjvFAKNQxbt6lvR5uNDXnjW0mbVH2/NQ9R1Ee8sdWpFOVkAxqfWU+eJrDSSuSMQ/wd91ajaVDjEjFQNd4T6xfWIJPr4HjeK1meurb0Xl0W6MkWdiMIyeFk/rxth16gxJfJwvzapy4S/dhAyhYEQ7kCgYBzNa6IOsfmebageVqAe7tRMetP1RMSUFcieVMNc3Ow7FOTZGL6i8HFkI3/bcpvmFst18FhKJwUG9YuvPoHCYal9agx8IkGd2612hgv4u8jl9Mh4ilEyIhI3oXblz9iqBQlTuooAn8v7/Rwf6gCtJyJTLEFwCpcSmW/0qzK0vV51QKBgQCL46wZ2H7B7n899CzMC7OZZcywgZCP9RZ25o9bNHown4HL2D7lCrCtYvtejCJ19C7x+pVZOFZjA8lhUsKu+YnkwN1Hv/IinuckvqAeB9xbdUtn0u6gUZSZFB+IgjcXVlZy4OTrk3cO+Ko4d/z25JcbUXbib1ePisv48shnDZm4tQ==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
    // 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";

    // 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String notify_url = "http://du.tunnel.qydev.com/notify_url.jsp";
    public static String notify_url = "http://du.tunnel.qydev.com/alibaba/callBack/notifyUrl";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String return_url = "http://du.tunnel.qydev.com/return_url.jsp";
    public static String return_url = "http://du.tunnel.qydev.com/alibaba/callBack/returnUrl";
//        public static String return_url = "http://du.tunnel.qydev.com/register";

    // 签名方式
    public static String sign_type = "RSA";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";

    // ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord
     *            要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
