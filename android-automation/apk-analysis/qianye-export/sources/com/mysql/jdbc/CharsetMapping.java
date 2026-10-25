package com.mysql.jdbc;

import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.tencent.smtt.sdk.TbsListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class CharsetMapping {
    public static final Map<String, MysqlCharset> CHARSET_NAME_TO_CHARSET;
    public static final Map<String, Integer> CHARSET_NAME_TO_COLLATION_INDEX;
    public static final MysqlCharset[] COLLATION_INDEX_TO_CHARSET;
    public static final String[] COLLATION_INDEX_TO_COLLATION_NAME;
    public static final String COLLATION_NOT_DEFINED = "none";
    private static final Map<String, String> ERROR_MESSAGE_FILE_TO_MYSQL_CHARSET;
    private static final Set<String> ESCAPE_ENCODINGS;
    private static final Map<String, List<MysqlCharset>> JAVA_ENCODING_UC_TO_MYSQL_CHARSET;
    public static final int MAP_SIZE = 2048;
    private static final Set<String> MULTIBYTE_ENCODINGS;
    private static final String MYSQL_4_0_CHARSET_NAME_cp1251cias = "cp1251cias";
    private static final String MYSQL_4_0_CHARSET_NAME_cp1251csas = "cp1251csas";
    private static final String MYSQL_4_0_CHARSET_NAME_croat = "croat";
    private static final String MYSQL_4_0_CHARSET_NAME_czech = "czech";
    private static final String MYSQL_4_0_CHARSET_NAME_danish = "danish";
    private static final String MYSQL_4_0_CHARSET_NAME_dos = "dos";
    private static final String MYSQL_4_0_CHARSET_NAME_estonia = "estonia";
    private static final String MYSQL_4_0_CHARSET_NAME_euc_kr = "euc_kr";
    private static final String MYSQL_4_0_CHARSET_NAME_german1 = "german1";
    private static final String MYSQL_4_0_CHARSET_NAME_hungarian = "hungarian";
    private static final String MYSQL_4_0_CHARSET_NAME_koi8_ru = "koi8_ru";
    private static final String MYSQL_4_0_CHARSET_NAME_koi8_ukr = "koi8_ukr";
    private static final String MYSQL_4_0_CHARSET_NAME_latin1_de = "latin1_de";
    private static final String MYSQL_4_0_CHARSET_NAME_latvian = "latvian";
    private static final String MYSQL_4_0_CHARSET_NAME_latvian1 = "latvian1";
    private static final String MYSQL_4_0_CHARSET_NAME_usa7 = "usa7";
    private static final String MYSQL_4_0_CHARSET_NAME_win1250 = "win1250";
    private static final String MYSQL_4_0_CHARSET_NAME_win1251 = "win1251";
    private static final String MYSQL_4_0_CHARSET_NAME_win1251ukr = "win1251ukr";
    private static final String MYSQL_CHARSET_NAME_armscii8 = "armscii8";
    private static final String MYSQL_CHARSET_NAME_ascii = "ascii";
    private static final String MYSQL_CHARSET_NAME_big5 = "big5";
    private static final String MYSQL_CHARSET_NAME_binary = "binary";
    private static final String MYSQL_CHARSET_NAME_cp1250 = "cp1250";
    private static final String MYSQL_CHARSET_NAME_cp1251 = "cp1251";
    private static final String MYSQL_CHARSET_NAME_cp1256 = "cp1256";
    private static final String MYSQL_CHARSET_NAME_cp1257 = "cp1257";
    private static final String MYSQL_CHARSET_NAME_cp850 = "cp850";
    private static final String MYSQL_CHARSET_NAME_cp852 = "cp852";
    private static final String MYSQL_CHARSET_NAME_cp866 = "cp866";
    private static final String MYSQL_CHARSET_NAME_cp932 = "cp932";
    private static final String MYSQL_CHARSET_NAME_dec8 = "dec8";
    private static final String MYSQL_CHARSET_NAME_eucjpms = "eucjpms";
    private static final String MYSQL_CHARSET_NAME_euckr = "euckr";
    private static final String MYSQL_CHARSET_NAME_gb18030 = "gb18030";
    private static final String MYSQL_CHARSET_NAME_gb2312 = "gb2312";
    private static final String MYSQL_CHARSET_NAME_gbk = "gbk";
    private static final String MYSQL_CHARSET_NAME_geostd8 = "geostd8";
    private static final String MYSQL_CHARSET_NAME_greek = "greek";
    private static final String MYSQL_CHARSET_NAME_hebrew = "hebrew";
    private static final String MYSQL_CHARSET_NAME_hp8 = "hp8";
    private static final String MYSQL_CHARSET_NAME_keybcs2 = "keybcs2";
    private static final String MYSQL_CHARSET_NAME_koi8r = "koi8r";
    private static final String MYSQL_CHARSET_NAME_koi8u = "koi8u";
    private static final String MYSQL_CHARSET_NAME_latin1 = "latin1";
    private static final String MYSQL_CHARSET_NAME_latin2 = "latin2";
    private static final String MYSQL_CHARSET_NAME_latin5 = "latin5";
    private static final String MYSQL_CHARSET_NAME_latin7 = "latin7";
    private static final String MYSQL_CHARSET_NAME_macce = "macce";
    private static final String MYSQL_CHARSET_NAME_macroman = "macroman";
    private static final String MYSQL_CHARSET_NAME_sjis = "sjis";
    private static final String MYSQL_CHARSET_NAME_swe7 = "swe7";
    private static final String MYSQL_CHARSET_NAME_tis620 = "tis620";
    private static final String MYSQL_CHARSET_NAME_ucs2 = "ucs2";
    private static final String MYSQL_CHARSET_NAME_ujis = "ujis";
    private static final String MYSQL_CHARSET_NAME_utf16 = "utf16";
    private static final String MYSQL_CHARSET_NAME_utf16le = "utf16le";
    private static final String MYSQL_CHARSET_NAME_utf32 = "utf32";
    private static final String MYSQL_CHARSET_NAME_utf8 = "utf8";
    private static final String MYSQL_CHARSET_NAME_utf8mb4 = "utf8mb4";
    public static final int MYSQL_COLLATION_INDEX_binary = 63;
    public static final int MYSQL_COLLATION_INDEX_utf8 = 33;
    public static final String NOT_USED = "latin1";
    public static final Set<Integer> UTF8MB4_INDEXES;
    private static int numberOfEncodingsConfigured;

    static {
        List arrayList;
        String str = MYSQL_CHARSET_NAME_greek;
        String str2 = MYSQL_CHARSET_NAME_latin7;
        String str3 = MYSQL_CHARSET_NAME_cp1250;
        MysqlCharset[] mysqlCharsetArr = {new MysqlCharset(MYSQL_4_0_CHARSET_NAME_usa7, 1, 0, new String[]{"US-ASCII"}, 4, 0), new MysqlCharset(MYSQL_CHARSET_NAME_ascii, 1, 0, new String[]{"US-ASCII", "ASCII"}), new MysqlCharset(MYSQL_CHARSET_NAME_big5, 2, 0, new String[]{"Big5"}), new MysqlCharset(MYSQL_CHARSET_NAME_gbk, 2, 0, new String[]{"GBK"}), new MysqlCharset(MYSQL_CHARSET_NAME_sjis, 2, 0, new String[]{"SHIFT_JIS", "Cp943", "WINDOWS-31J"}), new MysqlCharset(MYSQL_CHARSET_NAME_cp932, 2, 1, new String[]{"WINDOWS-31J"}), new MysqlCharset(MYSQL_CHARSET_NAME_gb2312, 2, 0, new String[]{"GB2312"}), new MysqlCharset(MYSQL_CHARSET_NAME_ujis, 3, 0, new String[]{"EUC_JP"}), new MysqlCharset(MYSQL_CHARSET_NAME_eucjpms, 3, 0, new String[]{"EUC_JP_Solaris"}, 5, 0, 3), new MysqlCharset(MYSQL_CHARSET_NAME_gb18030, 4, 0, new String[]{"GB18030"}, 5, 7, 4), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_euc_kr, 2, 0, new String[]{"EUC_KR"}, 4, 0), new MysqlCharset(MYSQL_CHARSET_NAME_euckr, 2, 0, new String[]{"EUC-KR"}), new MysqlCharset("latin1", 1, 1, new String[]{"Cp1252", "ISO8859_1"}), new MysqlCharset(MYSQL_CHARSET_NAME_swe7, 1, 0, new String[]{"Cp1252"}), new MysqlCharset(MYSQL_CHARSET_NAME_hp8, 1, 0, new String[]{"Cp1252"}), new MysqlCharset(MYSQL_CHARSET_NAME_dec8, 1, 0, new String[]{"Cp1252"}), new MysqlCharset(MYSQL_CHARSET_NAME_armscii8, 1, 0, new String[]{"Cp1252"}), new MysqlCharset(MYSQL_CHARSET_NAME_geostd8, 1, 0, new String[]{"Cp1252"}), new MysqlCharset(MYSQL_CHARSET_NAME_latin2, 1, 0, new String[]{"ISO8859_2"}), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_czech, 1, 0, new String[]{"ISO8859_2"}, 4, 0), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_hungarian, 1, 0, new String[]{"ISO8859_2"}, 4, 0), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_croat, 1, 0, new String[]{"ISO8859_2"}, 4, 0), new MysqlCharset(MYSQL_CHARSET_NAME_greek, 1, 0, new String[]{"ISO8859_7", MYSQL_CHARSET_NAME_greek}), new MysqlCharset(MYSQL_CHARSET_NAME_latin7, 1, 0, new String[]{"ISO-8859-13"}), new MysqlCharset(MYSQL_CHARSET_NAME_hebrew, 1, 0, new String[]{"ISO8859_8"}), new MysqlCharset(MYSQL_CHARSET_NAME_latin5, 1, 0, new String[]{"ISO8859_9"}), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_latvian, 1, 0, new String[]{"ISO8859_13"}, 4, 0), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_latvian1, 1, 0, new String[]{"ISO8859_13"}, 4, 0), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_estonia, 1, 1, new String[]{"ISO8859_13"}, 4, 0), new MysqlCharset(MYSQL_CHARSET_NAME_cp850, 1, 0, new String[]{"Cp850", "Cp437"}), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_dos, 1, 0, new String[]{"Cp850", "Cp437"}, 4, 0), new MysqlCharset(MYSQL_CHARSET_NAME_cp852, 1, 0, new String[]{"Cp852"}), new MysqlCharset(MYSQL_CHARSET_NAME_keybcs2, 1, 0, new String[]{"Cp852"}), new MysqlCharset(MYSQL_CHARSET_NAME_cp866, 1, 0, new String[]{"Cp866"}), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_koi8_ru, 1, 0, new String[]{"KOI8_R"}, 4, 0), new MysqlCharset(MYSQL_CHARSET_NAME_koi8r, 1, 1, new String[]{"KOI8_R"}), new MysqlCharset(MYSQL_CHARSET_NAME_koi8u, 1, 0, new String[]{"KOI8_R"}), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_koi8_ukr, 1, 0, new String[]{"KOI8_R"}, 4, 0), new MysqlCharset(MYSQL_CHARSET_NAME_tis620, 1, 0, new String[]{"TIS620"}), new MysqlCharset(MYSQL_CHARSET_NAME_cp1250, 1, 0, new String[]{"Cp1250"}), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_win1250, 1, 0, new String[]{"Cp1250"}, 4, 0), new MysqlCharset(MYSQL_CHARSET_NAME_cp1251, 1, 1, new String[]{"Cp1251"}), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_win1251, 1, 0, new String[]{"Cp1251"}, 4, 0), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_cp1251cias, 1, 0, new String[]{"Cp1251"}, 4, 0), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_cp1251csas, 1, 0, new String[]{"Cp1251"}, 4, 0), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_win1251ukr, 1, 0, new String[]{"Cp1251"}, 4, 0), new MysqlCharset(MYSQL_CHARSET_NAME_cp1256, 1, 0, new String[]{"Cp1256"}), new MysqlCharset(MYSQL_CHARSET_NAME_cp1257, 1, 0, new String[]{"Cp1257"}), new MysqlCharset(MYSQL_CHARSET_NAME_macroman, 1, 0, new String[]{"MacRoman"}), new MysqlCharset(MYSQL_CHARSET_NAME_macce, 1, 0, new String[]{"MacCentralEurope"}), new MysqlCharset(MYSQL_CHARSET_NAME_utf8, 3, 1, new String[]{"UTF-8"}), new MysqlCharset(MYSQL_CHARSET_NAME_utf8mb4, 4, 0, new String[]{"UTF-8"}), new MysqlCharset(MYSQL_CHARSET_NAME_ucs2, 2, 0, new String[]{"UnicodeBig"}), new MysqlCharset(MYSQL_CHARSET_NAME_binary, 1, 1, new String[]{"ISO8859_1"}), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_latin1_de, 1, 0, new String[]{"ISO8859_1"}, 4, 0), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_german1, 1, 0, new String[]{"ISO8859_1"}, 4, 0), new MysqlCharset(MYSQL_4_0_CHARSET_NAME_danish, 1, 0, new String[]{"ISO8859_1"}, 4, 0), new MysqlCharset(MYSQL_CHARSET_NAME_utf16, 4, 0, new String[]{"UTF-16"}), new MysqlCharset(MYSQL_CHARSET_NAME_utf16le, 4, 0, new String[]{"UTF-16LE"}), new MysqlCharset(MYSQL_CHARSET_NAME_utf32, 4, 0, new String[]{"UTF-32"})};
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        int i = 0;
        for (int i2 = 60; i < i2; i2 = 60) {
            String str4 = mysqlCharsetArr[i].charsetName;
            String str5 = str3;
            map.put(str4, mysqlCharsetArr[i]);
            String str6 = str;
            numberOfEncodingsConfigured += mysqlCharsetArr[i].javaEncodingsUc.size();
            Iterator<String> it = mysqlCharsetArr[i].javaEncodingsUc.iterator();
            while (it.hasNext()) {
                String next = it.next();
                List list = (List) map2.get(next);
                Iterator<String> it2 = it;
                if (list == null) {
                    arrayList = new ArrayList();
                    map2.put(next, arrayList);
                } else {
                    arrayList = list;
                }
                String str7 = str2;
                arrayList.add(mysqlCharsetArr[i]);
                if (mysqlCharsetArr[i].mblen > 1) {
                    hashSet.add(next);
                }
                str2 = str7;
                it = it2;
            }
            String str8 = str2;
            if (str4.equals(MYSQL_CHARSET_NAME_big5) || str4.equals(MYSQL_CHARSET_NAME_gbk) || str4.equals(MYSQL_CHARSET_NAME_sjis)) {
                hashSet2.addAll(mysqlCharsetArr[i].javaEncodingsUc);
            }
            i++;
            str3 = str5;
            str = str6;
            str2 = str8;
        }
        String str9 = str2;
        String str10 = str3;
        String str11 = str;
        CHARSET_NAME_TO_CHARSET = Collections.unmodifiableMap(map);
        JAVA_ENCODING_UC_TO_MYSQL_CHARSET = Collections.unmodifiableMap(map2);
        MULTIBYTE_ENCODINGS = Collections.unmodifiableSet(hashSet);
        ESCAPE_ENCODINGS = Collections.unmodifiableSet(hashSet2);
        Collation[] collationArr = new Collation[2048];
        collationArr[1] = new Collation(1, "big5_chinese_ci", 1, MYSQL_CHARSET_NAME_big5);
        collationArr[2] = new Collation(2, "latin2_czech_cs", 0, MYSQL_CHARSET_NAME_latin2);
        collationArr[3] = new Collation(3, "dec8_swedish_ci", 0, MYSQL_CHARSET_NAME_dec8);
        collationArr[4] = new Collation(4, "cp850_general_ci", 1, MYSQL_CHARSET_NAME_cp850);
        collationArr[5] = new Collation(5, "latin1_german1_ci", 1, "latin1");
        collationArr[6] = new Collation(6, "hp8_english_ci", 0, MYSQL_CHARSET_NAME_hp8);
        collationArr[7] = new Collation(7, "koi8r_general_ci", 0, MYSQL_CHARSET_NAME_koi8r);
        collationArr[8] = new Collation(8, "latin1_swedish_ci", 0, "latin1");
        collationArr[9] = new Collation(9, "latin2_general_ci", 1, MYSQL_CHARSET_NAME_latin2);
        collationArr[10] = new Collation(10, "swe7_swedish_ci", 0, MYSQL_CHARSET_NAME_swe7);
        collationArr[11] = new Collation(11, "ascii_general_ci", 0, MYSQL_CHARSET_NAME_ascii);
        collationArr[12] = new Collation(12, "ujis_japanese_ci", 0, MYSQL_CHARSET_NAME_ujis);
        collationArr[13] = new Collation(13, "sjis_japanese_ci", 0, MYSQL_CHARSET_NAME_sjis);
        collationArr[14] = new Collation(14, "cp1251_bulgarian_ci", 0, MYSQL_CHARSET_NAME_cp1251);
        collationArr[15] = new Collation(15, "latin1_danish_ci", 0, "latin1");
        collationArr[16] = new Collation(16, "hebrew_general_ci", 0, MYSQL_CHARSET_NAME_hebrew);
        collationArr[17] = new Collation(17, "latin1_german1_ci", 0, MYSQL_4_0_CHARSET_NAME_win1251);
        collationArr[18] = new Collation(18, "tis620_thai_ci", 0, MYSQL_CHARSET_NAME_tis620);
        collationArr[19] = new Collation(19, "euckr_korean_ci", 0, MYSQL_CHARSET_NAME_euckr);
        collationArr[20] = new Collation(20, "latin7_estonian_cs", 0, str9);
        collationArr[21] = new Collation(21, "latin2_hungarian_ci", 0, MYSQL_CHARSET_NAME_latin2);
        collationArr[22] = new Collation(22, "koi8u_general_ci", 0, MYSQL_CHARSET_NAME_koi8u);
        collationArr[23] = new Collation(23, "cp1251_ukrainian_ci", 0, MYSQL_CHARSET_NAME_cp1251);
        collationArr[24] = new Collation(24, "gb2312_chinese_ci", 0, MYSQL_CHARSET_NAME_gb2312);
        collationArr[25] = new Collation(25, "greek_general_ci", 0, str11);
        collationArr[26] = new Collation(26, "cp1250_general_ci", 1, str10);
        collationArr[27] = new Collation(27, "latin2_croatian_ci", 0, MYSQL_CHARSET_NAME_latin2);
        collationArr[28] = new Collation(28, "gbk_chinese_ci", 1, MYSQL_CHARSET_NAME_gbk);
        collationArr[29] = new Collation(29, "cp1257_lithuanian_ci", 0, MYSQL_CHARSET_NAME_cp1257);
        collationArr[30] = new Collation(30, "latin5_turkish_ci", 1, MYSQL_CHARSET_NAME_latin5);
        collationArr[31] = new Collation(31, "latin1_german2_ci", 0, "latin1");
        collationArr[32] = new Collation(32, "armscii8_general_ci", 0, MYSQL_CHARSET_NAME_armscii8);
        collationArr[33] = new Collation(33, "utf8_general_ci", 1, MYSQL_CHARSET_NAME_utf8);
        collationArr[34] = new Collation(34, "cp1250_czech_cs", 0, str10);
        collationArr[35] = new Collation(35, "ucs2_general_ci", 1, MYSQL_CHARSET_NAME_ucs2);
        collationArr[36] = new Collation(36, "cp866_general_ci", 1, MYSQL_CHARSET_NAME_cp866);
        collationArr[37] = new Collation(37, "keybcs2_general_ci", 1, MYSQL_CHARSET_NAME_keybcs2);
        collationArr[38] = new Collation(38, "macce_general_ci", 1, MYSQL_CHARSET_NAME_macce);
        collationArr[39] = new Collation(39, "macroman_general_ci", 1, MYSQL_CHARSET_NAME_macroman);
        collationArr[40] = new Collation(40, "cp852_general_ci", 1, MYSQL_CHARSET_NAME_cp852);
        collationArr[41] = new Collation(41, "latin7_general_ci", 1, str9);
        collationArr[42] = new Collation(42, "latin7_general_cs", 0, str9);
        collationArr[43] = new Collation(43, "macce_bin", 0, MYSQL_CHARSET_NAME_macce);
        collationArr[44] = new Collation(44, "cp1250_croatian_ci", 0, str10);
        collationArr[45] = new Collation(45, "utf8mb4_general_ci", 1, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[46] = new Collation(46, "utf8mb4_bin", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[47] = new Collation(47, "latin1_bin", 0, "latin1");
        collationArr[48] = new Collation(48, "latin1_general_ci", 0, "latin1");
        collationArr[49] = new Collation(49, "latin1_general_cs", 0, "latin1");
        collationArr[50] = new Collation(50, "cp1251_bin", 0, MYSQL_CHARSET_NAME_cp1251);
        collationArr[51] = new Collation(51, "cp1251_general_ci", 1, MYSQL_CHARSET_NAME_cp1251);
        collationArr[52] = new Collation(52, "cp1251_general_cs", 0, MYSQL_CHARSET_NAME_cp1251);
        collationArr[53] = new Collation(53, "macroman_bin", 0, MYSQL_CHARSET_NAME_macroman);
        collationArr[54] = new Collation(54, "utf16_general_ci", 1, MYSQL_CHARSET_NAME_utf16);
        collationArr[55] = new Collation(55, "utf16_bin", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[56] = new Collation(56, "utf16le_general_ci", 1, MYSQL_CHARSET_NAME_utf16le);
        collationArr[57] = new Collation(57, "cp1256_general_ci", 1, MYSQL_CHARSET_NAME_cp1256);
        collationArr[58] = new Collation(58, "cp1257_bin", 0, MYSQL_CHARSET_NAME_cp1257);
        collationArr[59] = new Collation(59, "cp1257_general_ci", 1, MYSQL_CHARSET_NAME_cp1257);
        collationArr[60] = new Collation(60, "utf32_general_ci", 1, MYSQL_CHARSET_NAME_utf32);
        collationArr[61] = new Collation(61, "utf32_bin", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[62] = new Collation(62, "utf16le_bin", 0, MYSQL_CHARSET_NAME_utf16le);
        collationArr[63] = new Collation(63, MYSQL_CHARSET_NAME_binary, 1, MYSQL_CHARSET_NAME_binary);
        collationArr[64] = new Collation(64, "armscii8_bin", 0, MYSQL_CHARSET_NAME_armscii8);
        collationArr[65] = new Collation(65, "ascii_bin", 0, MYSQL_CHARSET_NAME_ascii);
        collationArr[66] = new Collation(66, "cp1250_bin", 0, str10);
        collationArr[67] = new Collation(67, "cp1256_bin", 0, MYSQL_CHARSET_NAME_cp1256);
        collationArr[68] = new Collation(68, "cp866_bin", 0, MYSQL_CHARSET_NAME_cp866);
        collationArr[69] = new Collation(69, "dec8_bin", 0, MYSQL_CHARSET_NAME_dec8);
        collationArr[70] = new Collation(70, "greek_bin", 0, str11);
        collationArr[71] = new Collation(71, "hebrew_bin", 0, MYSQL_CHARSET_NAME_hebrew);
        collationArr[72] = new Collation(72, "hp8_bin", 0, MYSQL_CHARSET_NAME_hp8);
        collationArr[73] = new Collation(73, "keybcs2_bin", 0, MYSQL_CHARSET_NAME_keybcs2);
        collationArr[74] = new Collation(74, "koi8r_bin", 0, MYSQL_CHARSET_NAME_koi8r);
        collationArr[75] = new Collation(75, "koi8u_bin", 0, MYSQL_CHARSET_NAME_koi8u);
        collationArr[76] = new Collation(76, "utf8_tolower_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[77] = new Collation(77, "latin2_bin", 0, MYSQL_CHARSET_NAME_latin2);
        collationArr[78] = new Collation(78, "latin5_bin", 0, MYSQL_CHARSET_NAME_latin5);
        collationArr[79] = new Collation(79, "latin7_bin", 0, str9);
        collationArr[80] = new Collation(80, "cp850_bin", 0, MYSQL_CHARSET_NAME_cp850);
        collationArr[81] = new Collation(81, "cp852_bin", 0, MYSQL_CHARSET_NAME_cp852);
        collationArr[82] = new Collation(82, "swe7_bin", 0, MYSQL_CHARSET_NAME_swe7);
        collationArr[83] = new Collation(83, "utf8_bin", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[84] = new Collation(84, "big5_bin", 0, MYSQL_CHARSET_NAME_big5);
        collationArr[85] = new Collation(85, "euckr_bin", 0, MYSQL_CHARSET_NAME_euckr);
        collationArr[86] = new Collation(86, "gb2312_bin", 0, MYSQL_CHARSET_NAME_gb2312);
        collationArr[87] = new Collation(87, "gbk_bin", 0, MYSQL_CHARSET_NAME_gbk);
        collationArr[88] = new Collation(88, "sjis_bin", 0, MYSQL_CHARSET_NAME_sjis);
        collationArr[89] = new Collation(89, "tis620_bin", 0, MYSQL_CHARSET_NAME_tis620);
        collationArr[90] = new Collation(90, "ucs2_bin", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[91] = new Collation(91, "ujis_bin", 0, MYSQL_CHARSET_NAME_ujis);
        collationArr[92] = new Collation(92, "geostd8_general_ci", 0, MYSQL_CHARSET_NAME_geostd8);
        collationArr[93] = new Collation(93, "geostd8_bin", 0, MYSQL_CHARSET_NAME_geostd8);
        collationArr[94] = new Collation(94, "latin1_spanish_ci", 0, "latin1");
        collationArr[95] = new Collation(95, "cp932_japanese_ci", 1, MYSQL_CHARSET_NAME_cp932);
        collationArr[96] = new Collation(96, "cp932_bin", 0, MYSQL_CHARSET_NAME_cp932);
        collationArr[97] = new Collation(97, "eucjpms_japanese_ci", 1, MYSQL_CHARSET_NAME_eucjpms);
        collationArr[98] = new Collation(98, "eucjpms_bin", 0, MYSQL_CHARSET_NAME_eucjpms);
        collationArr[99] = new Collation(99, "cp1250_polish_ci", 0, str10);
        collationArr[101] = new Collation(101, "utf16_unicode_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[102] = new Collation(102, "utf16_icelandic_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[103] = new Collation(103, "utf16_latvian_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[104] = new Collation(104, "utf16_romanian_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[105] = new Collation(105, "utf16_slovenian_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[106] = new Collation(106, "utf16_polish_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[107] = new Collation(107, "utf16_estonian_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[108] = new Collation(108, "utf16_spanish_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[109] = new Collation(109, "utf16_swedish_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[110] = new Collation(110, "utf16_turkish_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[111] = new Collation(111, "utf16_czech_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[112] = new Collation(112, "utf16_danish_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[113] = new Collation(113, "utf16_lithuanian_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[114] = new Collation(114, "utf16_slovak_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[115] = new Collation(115, "utf16_spanish2_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[116] = new Collation(116, "utf16_roman_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[117] = new Collation(117, "utf16_persian_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[118] = new Collation(118, "utf16_esperanto_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[119] = new Collation(119, "utf16_hungarian_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[120] = new Collation(120, "utf16_sinhala_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[121] = new Collation(121, "utf16_german2_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[122] = new Collation(122, "utf16_croatian_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[123] = new Collation(123, "utf16_unicode_520_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[124] = new Collation(124, "utf16_vietnamese_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[128] = new Collation(128, "ucs2_unicode_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[129] = new Collation(129, "ucs2_icelandic_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[130] = new Collation(130, "ucs2_latvian_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[131] = new Collation(131, "ucs2_romanian_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[132] = new Collation(132, "ucs2_slovenian_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[133] = new Collation(133, "ucs2_polish_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[134] = new Collation(134, "ucs2_estonian_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[135] = new Collation(135, "ucs2_spanish_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[136] = new Collation(136, "ucs2_swedish_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[137] = new Collation(137, "ucs2_turkish_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[138] = new Collation(138, "ucs2_czech_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[139] = new Collation(139, "ucs2_danish_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[140] = new Collation(140, "ucs2_lithuanian_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[141] = new Collation(141, "ucs2_slovak_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[142] = new Collation(142, "ucs2_spanish2_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[143] = new Collation(Imgproc.COLOR_COLORCVT_MAX, "ucs2_roman_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[144] = new Collation(144, "ucs2_persian_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[145] = new Collation(145, "ucs2_esperanto_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[146] = new Collation(146, "ucs2_hungarian_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[147] = new Collation(147, "ucs2_sinhala_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[148] = new Collation(148, "ucs2_german2_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[149] = new Collation(149, "ucs2_croatian_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[150] = new Collation(TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO, "ucs2_unicode_520_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[151] = new Collation(TbsListener.ErrorCode.NEEDDOWNLOAD_STATIC_INSTALLING, "ucs2_vietnamese_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[159] = new Collation(159, "ucs2_general_mysql500_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[160] = new Collation(160, "utf32_unicode_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[161] = new Collation(161, "utf32_icelandic_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[162] = new Collation(162, "utf32_latvian_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[163] = new Collation(163, "utf32_romanian_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[164] = new Collation(164, "utf32_slovenian_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[165] = new Collation(165, "utf32_polish_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[166] = new Collation(166, "utf32_estonian_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[167] = new Collation(167, "utf32_spanish_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[168] = new Collation(168, "utf32_swedish_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[169] = new Collation(169, "utf32_turkish_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[170] = new Collation(170, "utf32_czech_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[171] = new Collation(171, "utf32_danish_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[172] = new Collation(172, "utf32_lithuanian_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[173] = new Collation(173, "utf32_slovak_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[174] = new Collation(174, "utf32_spanish2_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[175] = new Collation(HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, "utf32_roman_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[176] = new Collation(176, "utf32_persian_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[177] = new Collation(TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, "utf32_esperanto_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[178] = new Collation(TbsListener.ErrorCode.APP_SET_MIN_CORE_VER, "utf32_hungarian_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[179] = new Collation(179, "utf32_sinhala_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[180] = new Collation(BaseTransientBottomBar.ANIMATION_FADE_DURATION, "utf32_german2_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[181] = new Collation(181, "utf32_croatian_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[182] = new Collation(182, "utf32_unicode_520_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[183] = new Collation(183, "utf32_vietnamese_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[192] = new Collation(192, "utf8_unicode_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[193] = new Collation(193, "utf8_icelandic_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[194] = new Collation(194, "utf8_latvian_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[195] = new Collation(195, "utf8_romanian_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[196] = new Collation(196, "utf8_slovenian_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[197] = new Collation(197, "utf8_polish_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[198] = new Collation(198, "utf8_estonian_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[199] = new Collation(199, "utf8_spanish_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[200] = new Collation(200, "utf8_swedish_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[201] = new Collation(TbsListener.ErrorCode.EXCEED_UNZIP_RETRY_NUM, "utf8_turkish_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[202] = new Collation(TbsListener.ErrorCode.APK_PATH_ERROR, "utf8_czech_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[203] = new Collation(TbsListener.ErrorCode.APK_VERSION_ERROR, "utf8_danish_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[204] = new Collation(TbsListener.ErrorCode.APK_INVALID, "utf8_lithuanian_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[205] = new Collation(TbsListener.ErrorCode.UNZIP_DIR_ERROR, "utf8_slovak_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[206] = new Collation(TbsListener.ErrorCode.UNZIP_IO_ERROR, "utf8_spanish2_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[207] = new Collation(TbsListener.ErrorCode.UNZIP_OTHER_ERROR, "utf8_roman_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[208] = new Collation(TbsListener.ErrorCode.EXCEED_DEXOPT_RETRY_NUM, "utf8_persian_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[209] = new Collation(TbsListener.ErrorCode.DEXOPT_EXCEPTION, "utf8_esperanto_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[210] = new Collation(TbsListener.ErrorCode.ROM_NOT_ENOUGH, "utf8_hungarian_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[211] = new Collation(TbsListener.ErrorCode.EXCEED_COPY_RETRY_NUM, "utf8_sinhala_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[212] = new Collation(TbsListener.ErrorCode.COPY_FAIL, "utf8_german2_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[213] = new Collation(TbsListener.ErrorCode.COPY_SRCDIR_ERROR, "utf8_croatian_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[214] = new Collation(TbsListener.ErrorCode.COPY_TMPDIR_ERROR, "utf8_unicode_520_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[215] = new Collation(TbsListener.ErrorCode.COPY_EXCEPTION, "utf8_vietnamese_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[223] = new Collation(TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, "utf8_general_mysql500_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[224] = new Collation(TbsListener.ErrorCode.EXCEED_INCR_UPDATE, "utf8mb4_unicode_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[225] = new Collation(225, "utf8mb4_icelandic_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[226] = new Collation(TbsListener.ErrorCode.DEXOAT_EXCEPTION, "utf8mb4_latvian_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[227] = new Collation(TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL, "utf8mb4_romanian_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[228] = new Collation(TbsListener.ErrorCode.INCR_ERROR_DETAIL, "utf8mb4_slovenian_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[229] = new Collation(TbsListener.ErrorCode.INSTALL_FROM_UNZIP, "utf8mb4_polish_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[230] = new Collation(TbsListener.ErrorCode.RENAME_SUCCESS, "utf8mb4_estonian_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[231] = new Collation(TbsListener.ErrorCode.RENAME_FAIL, "utf8mb4_spanish_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[232] = new Collation(TbsListener.ErrorCode.INSTALL_SUCCESS_AND_RELEASE_LOCK, "utf8mb4_swedish_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[233] = new Collation(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, "utf8mb4_turkish_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[234] = new Collation(TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS, "utf8mb4_czech_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[235] = new Collation(TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL, "utf8mb4_danish_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[236] = new Collation(TbsListener.ErrorCode.TPATCH_INSTALL_SUCCESS, "utf8mb4_lithuanian_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[237] = new Collation(TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS, "utf8mb4_slovak_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[238] = new Collation(TbsListener.ErrorCode.TPATCH_FAIL, "utf8mb4_spanish2_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[239] = new Collation(TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, "utf8mb4_roman_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[240] = new Collation(TbsListener.ErrorCode.TPATCH_VERSION_FAILED, "utf8mb4_persian_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[241] = new Collation(TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, "utf8mb4_esperanto_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[242] = new Collation(TbsListener.ErrorCode.TPATCH_ENABLE_EXCEPTION, "utf8mb4_hungarian_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[243] = new Collation(243, "utf8mb4_sinhala_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[244] = new Collation(244, "utf8mb4_german2_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[245] = new Collation(MysqlDefs.FIELD_TYPE_JSON, "utf8mb4_croatian_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[246] = new Collation(MysqlDefs.FIELD_TYPE_NEW_DECIMAL, "utf8mb4_unicode_520_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[247] = new Collation(MysqlDefs.FIELD_TYPE_ENUM, "utf8mb4_vietnamese_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[248] = new Collation(MysqlDefs.FIELD_TYPE_SET, "gb18030_chinese_ci", 1, MYSQL_CHARSET_NAME_gb18030);
        collationArr[249] = new Collation(MysqlDefs.FIELD_TYPE_TINY_BLOB, "gb18030_bin", 0, MYSQL_CHARSET_NAME_gb18030);
        collationArr[250] = new Collation(250, "gb18030_unicode_520_ci", 0, MYSQL_CHARSET_NAME_gb18030);
        collationArr[255] = new Collation(255, "utf8mb4_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[256] = new Collation(256, "utf8mb4_de_pb_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[257] = new Collation(Imgcodecs.IMWRITE_TIFF_XDPI, "utf8mb4_is_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[258] = new Collation(Imgcodecs.IMWRITE_TIFF_YDPI, "utf8mb4_lv_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[259] = new Collation(Imgcodecs.IMWRITE_TIFF_COMPRESSION, "utf8mb4_ro_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[260] = new Collation(260, "utf8mb4_sl_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[261] = new Collation(261, "utf8mb4_pl_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[262] = new Collation(262, "utf8mb4_et_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[263] = new Collation(263, "utf8mb4_es_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[264] = new Collation(264, "utf8mb4_sv_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[265] = new Collation(265, "utf8mb4_tr_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[266] = new Collation(266, "utf8mb4_cs_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[267] = new Collation(267, "utf8mb4_da_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[268] = new Collation(268, "utf8mb4_lt_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[269] = new Collation(269, "utf8mb4_sk_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[270] = new Collation(270, "utf8mb4_es_trad_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[271] = new Collation(271, "utf8mb4_la_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[273] = new Collation(273, "utf8mb4_eo_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[274] = new Collation(274, "utf8mb4_hu_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[275] = new Collation(275, "utf8mb4_hr_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[277] = new Collation(277, "utf8mb4_vi_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[278] = new Collation(278, "utf8mb4_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[279] = new Collation(279, "utf8mb4_de_pb_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[280] = new Collation(280, "utf8mb4_is_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[281] = new Collation(281, "utf8mb4_lv_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[282] = new Collation(282, "utf8mb4_ro_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[283] = new Collation(283, "utf8mb4_sl_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[284] = new Collation(284, "utf8mb4_pl_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[285] = new Collation(285, "utf8mb4_et_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[286] = new Collation(286, "utf8mb4_es_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[287] = new Collation(287, "utf8mb4_sv_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[288] = new Collation(288, "utf8mb4_tr_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[289] = new Collation(289, "utf8mb4_cs_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[290] = new Collation(290, "utf8mb4_da_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[291] = new Collation(291, "utf8mb4_lt_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[292] = new Collation(292, "utf8mb4_sk_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[293] = new Collation(293, "utf8mb4_es_trad_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[294] = new Collation(294, "utf8mb4_la_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[296] = new Collation(296, "utf8mb4_eo_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[297] = new Collation(297, "utf8mb4_hu_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[298] = new Collation(MysqlErrorNumbers.ER_ERROR_MESSAGES, "utf8mb4_hr_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[300] = new Collation(300, "utf8mb4_vi_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[303] = new Collation(303, "utf8mb4_ja_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[304] = new Collation(Videoio.CAP_PROP_PVAPI_BINNINGX, "utf8mb4_ja_0900_as_cs_ks", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[305] = new Collation(Videoio.CAP_PROP_PVAPI_BINNINGY, "utf8mb4_0900_as_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[306] = new Collation(306, "utf8mb4_ru_0900_ai_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[307] = new Collation(307, "utf8mb4_ru_0900_as_cs", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[326] = new Collation(TbsListener.ErrorCode.ERROR_CPU_NOT_SUPPORT, "utf8mb4_test_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[327] = new Collation(TbsListener.ErrorCode.ERROR_CORE_LOAD_CRASH_PROTECT, "utf16_test_ci", 0, MYSQL_CHARSET_NAME_utf16);
        collationArr[328] = new Collation(328, "utf8mb4_test_400_ci", 0, MYSQL_CHARSET_NAME_utf8mb4);
        collationArr[336] = new Collation(336, "utf8_bengali_standard_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[337] = new Collation(337, "utf8_bengali_traditional_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[352] = new Collation(352, "utf8_phone_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[353] = new Collation(353, "utf8_test_ci", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[354] = new Collation(354, "utf8_5624_1", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[355] = new Collation(355, "utf8_5624_2", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[356] = new Collation(356, "utf8_5624_3", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[357] = new Collation(357, "utf8_5624_4", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[358] = new Collation(358, "ucs2_test_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[359] = new Collation(359, "ucs2_vn_ci", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[360] = new Collation(360, "ucs2_5624_1", 0, MYSQL_CHARSET_NAME_ucs2);
        collationArr[368] = new Collation(368, "utf8_5624_5", 0, MYSQL_CHARSET_NAME_utf8);
        collationArr[391] = new Collation(391, "utf32_test_ci", 0, MYSQL_CHARSET_NAME_utf32);
        collationArr[2047] = new Collation(2047, "utf8_maxuserid_ci", 0, MYSQL_CHARSET_NAME_utf8);
        COLLATION_INDEX_TO_COLLATION_NAME = new String[2048];
        COLLATION_INDEX_TO_CHARSET = new MysqlCharset[2048];
        TreeMap treeMap = new TreeMap();
        TreeMap treeMap2 = new TreeMap();
        HashSet hashSet3 = new HashSet();
        Collation collation = new Collation(0, COLLATION_NOT_DEFINED, 0, "latin1");
        for (int i3 = 1; i3 < 2048; i3++) {
            Collation collation2 = collationArr[i3] != null ? collationArr[i3] : collation;
            COLLATION_INDEX_TO_COLLATION_NAME[i3] = collation2.collationName;
            MysqlCharset[] mysqlCharsetArr2 = COLLATION_INDEX_TO_CHARSET;
            MysqlCharset mysqlCharset = collation2.mysqlCharset;
            mysqlCharsetArr2[i3] = mysqlCharset;
            String str12 = mysqlCharset.charsetName;
            if (!treeMap.containsKey(str12) || ((Integer) treeMap2.get(str12)).intValue() < collation2.priority) {
                treeMap.put(str12, Integer.valueOf(i3));
                treeMap2.put(str12, Integer.valueOf(collation2.priority));
            }
            if (str12.equals(MYSQL_CHARSET_NAME_utf8mb4)) {
                hashSet3.add(Integer.valueOf(i3));
            }
        }
        CHARSET_NAME_TO_COLLATION_INDEX = Collections.unmodifiableMap(treeMap);
        UTF8MB4_INDEXES = Collections.unmodifiableSet(hashSet3);
        HashMap map3 = new HashMap();
        map3.put(MYSQL_4_0_CHARSET_NAME_czech, MYSQL_CHARSET_NAME_latin2);
        map3.put(MYSQL_4_0_CHARSET_NAME_danish, "latin1");
        map3.put("dutch", "latin1");
        map3.put("english", "latin1");
        map3.put("estonian", str9);
        map3.put("french", "latin1");
        map3.put("german", "latin1");
        map3.put(str11, str11);
        map3.put(MYSQL_4_0_CHARSET_NAME_hungarian, MYSQL_CHARSET_NAME_latin2);
        map3.put("italian", "latin1");
        map3.put("japanese", MYSQL_CHARSET_NAME_ujis);
        map3.put("japanese-sjis", MYSQL_CHARSET_NAME_sjis);
        map3.put("korean", MYSQL_CHARSET_NAME_euckr);
        map3.put("norwegian", "latin1");
        map3.put("norwegian-ny", "latin1");
        map3.put("polish", MYSQL_CHARSET_NAME_latin2);
        map3.put("portuguese", "latin1");
        map3.put("romanian", MYSQL_CHARSET_NAME_latin2);
        map3.put("russian", MYSQL_CHARSET_NAME_koi8r);
        map3.put("serbian", str10);
        map3.put("slovak", MYSQL_CHARSET_NAME_latin2);
        map3.put("spanish", "latin1");
        map3.put("swedish", "latin1");
        map3.put("ukrainian", MYSQL_CHARSET_NAME_koi8u);
        ERROR_MESSAGE_FILE_TO_MYSQL_CHARSET = Collections.unmodifiableMap(map3);
    }

    public static final String getCharacterEncodingForErrorMessages(ConnectionImpl connectionImpl) throws SQLException {
        String javaEncodingForMysqlCharset;
        String javaEncodingForMysqlCharset2;
        if (connectionImpl.versionMeetsMinimum(5, 5, 0)) {
            String serverVariable = connectionImpl.getServerVariable(ConnectionImpl.JDBC_LOCAL_CHARACTER_SET_RESULTS);
            return (serverVariable == null || (javaEncodingForMysqlCharset2 = getJavaEncodingForMysqlCharset(serverVariable)) == null) ? "UTF-8" : javaEncodingForMysqlCharset2;
        }
        String serverVariable2 = connectionImpl.getServerVariable("language");
        if (serverVariable2 != null && serverVariable2.length() != 0) {
            int length = serverVariable2.length();
            if (serverVariable2.endsWith("/") || serverVariable2.endsWith("\\")) {
                length--;
            }
            int i = length - 1;
            int iLastIndexOf = serverVariable2.lastIndexOf(47, i);
            if (iLastIndexOf == -1) {
                iLastIndexOf = serverVariable2.lastIndexOf(92, i);
            }
            int i2 = iLastIndexOf != -1 ? iLastIndexOf : 0;
            if (i2 != length && length >= i2) {
                String str = ERROR_MESSAGE_FILE_TO_MYSQL_CHARSET.get(serverVariable2.substring(i2 + 1, length));
                return (str == null || (javaEncodingForMysqlCharset = getJavaEncodingForMysqlCharset(str)) == null) ? "Cp1252" : javaEncodingForMysqlCharset;
            }
        }
        return "Cp1252";
    }

    public static int getCollationIndexForJavaEncoding(String str, java.sql.Connection connection) throws SQLException {
        Integer num;
        String mysqlCharsetForJavaEncoding = getMysqlCharsetForJavaEncoding(str, (Connection) connection);
        if (mysqlCharsetForJavaEncoding == null || (num = CHARSET_NAME_TO_COLLATION_INDEX.get(mysqlCharsetForJavaEncoding)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public static String getJavaEncodingForCollationIndex(Integer num, String str) {
        if (num == null || num.intValue() <= 0 || num.intValue() >= 2048) {
            return null;
        }
        return COLLATION_INDEX_TO_CHARSET[num.intValue()].getMatchingJavaEncoding(str);
    }

    public static String getJavaEncodingForMysqlCharset(String str, String str2) {
        MysqlCharset mysqlCharset = CHARSET_NAME_TO_CHARSET.get(str);
        return mysqlCharset != null ? mysqlCharset.getMatchingJavaEncoding(str2) : str2;
    }

    public static int getMblen(String str) {
        MysqlCharset mysqlCharset;
        if (str == null || (mysqlCharset = CHARSET_NAME_TO_CHARSET.get(str)) == null) {
            return 0;
        }
        return mysqlCharset.mblen;
    }

    public static final String getMysqlCharsetForJavaEncoding(String str, Connection connection) throws SQLException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        try {
            List<MysqlCharset> list = JAVA_ENCODING_UC_TO_MYSQL_CHARSET.get(str.toUpperCase(Locale.ENGLISH));
            if (list != null) {
                MysqlCharset mysqlCharset = null;
                for (MysqlCharset mysqlCharset2 : list) {
                    if (connection == null) {
                        return mysqlCharset2.charsetName;
                    }
                    if (mysqlCharset == null || (i = mysqlCharset.major) < (i2 = mysqlCharset2.major) || (i3 = mysqlCharset.minor) < (i4 = mysqlCharset2.minor) || (i5 = mysqlCharset.subminor) < (i6 = mysqlCharset2.subminor) || (mysqlCharset.priority < mysqlCharset2.priority && i == i2 && i3 == i4 && i5 == i6)) {
                        if (mysqlCharset2.isOkayForVersion(connection)) {
                            mysqlCharset = mysqlCharset2;
                        }
                    }
                }
                if (mysqlCharset != null) {
                    return mysqlCharset.charsetName;
                }
            }
            return null;
        } catch (RuntimeException e) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, (ExceptionInterceptor) null);
            sQLExceptionCreateSQLException.initCause(e);
            throw sQLExceptionCreateSQLException;
        } catch (SQLException e2) {
            throw e2;
        }
    }

    public static String getMysqlCharsetNameForCollationIndex(Integer num) {
        if (num == null || num.intValue() <= 0 || num.intValue() >= 2048) {
            return null;
        }
        return COLLATION_INDEX_TO_CHARSET[num.intValue()].charsetName;
    }

    public static final int getNumberOfCharsetsConfigured() {
        return numberOfEncodingsConfigured;
    }

    public static final boolean isMultibyteCharset(String str) {
        return MULTIBYTE_ENCODINGS.contains(str.toUpperCase(Locale.ENGLISH));
    }

    public static final boolean requiresEscapeEasternUnicode(String str) {
        return ESCAPE_ENCODINGS.contains(str.toUpperCase(Locale.ENGLISH));
    }

    public static String getJavaEncodingForMysqlCharset(String str) {
        return getJavaEncodingForMysqlCharset(str, null);
    }

    public static String getJavaEncodingForCollationIndex(Integer num) {
        return getJavaEncodingForCollationIndex(num, null);
    }
}
