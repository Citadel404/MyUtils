package stringutils;

import java.lang.reflect.Type;
import java.net.Proxy;

/**
 * Author: 973969022@qq.com
 * Date: 2024/7/17 14:36
 */
public class StringClassify {
    /**
     * 根据输入的字符串识别其类型并返回相应的对象。
     * 该方法尝试将输入的字符串识别为整数、浮点数、科学计数法表示的浮点数或特定格式的字符串。
     *
     * @param str 待识别的字符串
     * @return 识别后的对象，可能是Integer、Double或原字符串；如果无法识别，则返回null。
     */
    public Object identify(String str) {
        // 尝试将字符串识别为整数
        if (str.matches("[0-9]+")) {
            return Integer.parseInt(str);
        } else if (str.matches("[0-9]+\\.[0-9]+")) {
            // 尝试将字符串识别为浮点数（不包括科学计数法）
            return Double.parseDouble(str);
        } else if (str.matches("[0-9]+\\.[0-9]+[eE][0-9]+")) {
            // 尝试将字符串识别为科学计数法表示的浮点数
            return Double.parseDouble(str);
        } else if (str.matches("[a-z]+\\.[0-9]")) {
            // 如果字符串不符合数字的任何格式，但符合特定的字母数字格式，返回原字符串
            return str;
        }
        // 如果字符串不符合任何已定义的模式，则返回null表示无法识别
        return null;
    }

    public static void main(String[] args) {
        StringClassify stringClassify = new StringClassify();
        System.out.println(stringClassify.identify("123"));
        System.out.println(stringClassify.identify("123.456"));
        System.out.println(stringClassify.identify("123.456e-3"));
        System.out.println(stringClassify.identify("123.456e-3"));
    }
}
