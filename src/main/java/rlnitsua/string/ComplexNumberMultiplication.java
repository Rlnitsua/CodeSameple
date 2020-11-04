package rlnitsua.string;

import rlnitsua.utils.log.LogUtils;

public class ComplexNumberMultiplication {
    private static final String TAG = "ComplexNumberMultiplication";

    public String complexNumberMultiply(String a, String b) {
        ComplexNumber n1 = getComplexNumber(a);
        ComplexNumber n2 = getComplexNumber(b);
        int n1R = n1.getRealPart();
        int n1I = n1.getImagPart();
        int n2R = n2.getRealPart();
        int n2I = n2.getImagPart();
        return (n1R * n2R - n1I * n2I) + "+" + (n1R * n2I + n1I * n2R) + "i";
    }

    public ComplexNumber getComplexNumber(String s) {
        ComplexNumber complexNumber = this.new ComplexNumber();
        boolean isImagePartNegative = s.contains("[+-]");
        String[] splitArr = isImagePartNegative ? s.split("[+-]") : s.split("[+]");
        complexNumber.setRealPart(splitArr[0]);
        String imagePart = splitArr[1].split("i")[0];
        complexNumber.setImagPart(isImagePartNegative ? "-" + imagePart : imagePart);
        return complexNumber;
    }

    class ComplexNumber {
        int realPart;
        int imagPart;

        public int getRealPart() {
            return realPart;
        }

        public void setRealPart(String realPart) {
            this.realPart = Integer.valueOf(realPart);
        }

        public int getImagPart() {
            return imagPart;
        }

        public void setImagPart(String imagPart) {
            this.imagPart = Integer.valueOf(imagPart);
        }
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "1+1i".split("[+]")[0]);
        LogUtils.d(TAG, new ComplexNumberMultiplication().complexNumberMultiply("1+1i", "1+1i"));
        LogUtils.d(TAG, new ComplexNumberMultiplication().complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
