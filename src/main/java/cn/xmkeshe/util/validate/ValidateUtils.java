package cn.xmkeshe.util.validate;

public class ValidateUtils {
    /**
     * <li>判断当前数据是否为空，如果为空返回false，否则返回true</li>
     * @param src 要验证数据
     * @return 验证数据不为空返回true
     */
    public static boolean validateEmpty(String src) {
        if (src == null || "".equals(src)) {
            return false;
        }
        return true;
    }

    /**
     * 判断当前参数是否是数字
     * @param src
     * @return
     */
    public static boolean validateNumber(String src){
        if(src.matches("\\d+")){
            return true;
        }else{
            return false;
        }
    }
}
