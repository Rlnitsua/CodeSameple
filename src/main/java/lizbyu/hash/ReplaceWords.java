package lizbyu.hash;

import lizbyu.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplaceWords {
    private static final String TAG = "ReplaceWords";

    public String replaceWords(List<String> dict, String sentence) {
        dict = reduplicate(dict);

        String[] sentenceItems = sentence.split(" ");
        for (int i = 0; i < sentenceItems.length; i++) {
            sentenceItems[i] = replace(sentenceItems[i], dict);
        }

        return createSentence(sentenceItems);
    }

    private List<String> reduplicate(List<String> dict) {
        List<String> newDict = new ArrayList<>(dict);
        for (int i = 0; i < dict.size(); i++) {
            for (int j = 0; j < dict.size(); j++) {
                if (i != j && dict.get(i).length() > dict.get(j).length()
                        && dict.get(i).startsWith(dict.get(j))) {
                    newDict.remove(dict.get(i));
                }
            }
        }
        return newDict;
    }

    private String replace(String sentenceItem, List<String> dict) {
        for (String dictItem : dict) {
            if (sentenceItem.startsWith(dictItem)) {
                return dictItem;
            }
        }
        return sentenceItem;
    }

    private String createSentence(String[] sentenceItems) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sentenceItems.length; i++) {
            sb.append(sentenceItems[i]);
            if (i != sentenceItems.length - 1) {
                sb.append(" ");
            }
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"e", "k", "c", "harqp", "h", "gsafc", "vn", "lqp", "soy", "mr", "x", "iitgm", "sb", "oo", "spj", "gwmly", "iu", "z", "f", "ha", "vds", "v", "vpx", "fir", "t", "xo", "apifm", "tlznm", "kkv", "nxyud", "j", "qp", "omn", "zoxp", "mutu", "i", "nxth", "dwuer", "sadl", "pv", "w", "mding", "mubem", "xsmwc", "vl", "farov", "twfmq", "ljhmr", "q", "bbzs", "kd", "kwc", "a", "buq", "sm", "yi", "nypa", "xwz", "si", "amqx", "iy", "eb", "qvgt", "twy", "rf", "dc", "utt", "mxjfu", "hm", "trz", "lzh", "lref", "qbx", "fmemr", "gil", "go", "qggh", "uud", "trnhf", "gels", "dfdq", "qzkx", "qxw"};
        List<String> dict = Arrays.asList(arr);
        String sentence = "ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp";
        LogUtils.d(TAG, new ReplaceWords().replaceWords(dict, sentence));
    }
}
