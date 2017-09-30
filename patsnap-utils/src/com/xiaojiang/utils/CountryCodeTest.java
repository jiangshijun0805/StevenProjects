package com.xiaojiang.utils;

import java.util.Arrays;
import java.util.HashSet;

public class CountryCodeTest {
    public static final String[] countryCode =
        {"AD", "AE", "AF", "AG", "AI", "AL", "AM", "AN", "AO", "AP", "AR", "AT", "AU", "AW", "AZ", "BA", "BB", "BD",
            "BE", "BF", "BG", "BH", "BI", "BJ", "BM", "BN", "BO", "BQ", "BR", "BS", "BT", "BV", "BW", "BX", "BY", "BZ",
            "CA", "CD", "CF", "CG", "CH", "CI", "CK", "CL", "CM", "CN", "CO", "CR", "CU", "CV", "CW", "CY", "CZ", "DE",
            "DJ", "DK", "DM", "DO", "DZ", "EA", "EC", "EE", "EG", "EH", "EM", "EP", "ER", "ES", "ET", "FI", "FJ", "FK",
            "FO", "FR", "GA", "GB", "GC", "GD", "GE", "GG", "GH", "GI", "GL", "GM", "GN", "GQ", "GR", "GS", "GT", "GW",
            "GY", "HK", "HN", "HR", "HT", "HU", "ID", "IE", "IL", "IM", "IN", "IQ", "IR", "IS", "IT", "JE", "JM", "JO",
            "JP", "KE", "KG", "KH", "KI", "KM", "KN", "KP", "KR", "KW", "KY", "KZ", "LA", "LB", "LC", "LI", "LK", "LR",
            "LS", "LT", "LU", "LV", "LY", "MA", "MC", "MD", "ME", "MG", "MK", "ML", "MM", "MN", "MO", "MP", "MR", "MS",
            "MT", "MU", "MV", "MW", "MX", "MY", "MZ", "NA", "NE", "NG", "NI", "NL", "NO", "NP", "NR", "NZ", "OA", "OM",
            "PA", "PE", "PG", "PH", "PK", "PL", "PT", "PW", "PY", "QA", "QZ", "RO", "RS", "RU", "RW", "SA", "SB", "SC",
            "SD", "SE", "SG", "SH", "SI", "SK", "SL", "SM", "SN", "SO", "SR", "ST", "SV", "SX", "SY", "SZ", "TC", "TD",
            "TG", "TH", "TJ", "TL", "TM", "TN", "TR", "TT", "TV", "TW", "TZ", "UA", "UG", "US", "UY", "UZ", "VA", "VC",
            "VE", "VG", "VN", "VU", "IB", "WO", "WS", "XN", "XU", "XV", "YE", "YU", "ZA", "ZM", "ZW"};
    
    public static HashSet<String> countryArray = new HashSet<String>(Arrays.asList(countryCode));
    
    public static void main(String[] args) {
        System.out.println(countryArray.size());
        System.out.println(countryArray);
    }
    
}
