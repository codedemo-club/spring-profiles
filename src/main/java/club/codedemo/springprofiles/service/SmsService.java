package club.codedemo.springprofiles.service;

/**
 * 短信服务
 * @author panjie
 */
public interface SmsService {

    /**
     * 发送短信
     * @param phone 接收的手机号
     * @param context 发送的短信文本
     */
    void sentMessage(String phone, String context);
}
