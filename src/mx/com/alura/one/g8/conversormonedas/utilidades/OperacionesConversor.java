package mx.com.alura.one.g8.conversormonedas.utilidades;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import mx.com.alura.one.g8.conversormonedas.dto.CodigoTipoModea;
import mx.com.alura.one.g8.conversormonedas.dto.ResponseJsonConversor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperacionesConversor {

    private static final String pathBaseUrl = "https://v6.exchangerate-api.com/v6/3bf336ec446c8ba7d39d2f50/latest/";

    private static final Pattern patronCodigos = Pattern.compile("^[A-Z]{3}$");

    public static final boolean getValidaCodigo(final String codigo) {
        boolean correcto = false;
        Matcher matN = patronCodigos.matcher(codigo);
        correcto = matN.find() ? true : false;
        return correcto;
    }


    public static final String getMenu(){
        String menu = """
                *******************************************************
                
                Sea Bienvenido al Conversor de Moneda
                
                1) Dólar =>> Peso Argentino
                2) Peso Argentino =>> Dólar
                3) Dólar =>> Real Brasileño
                4) Real Brasileño =>> Dólar 
                5) Dólar =>> Peso Colombiano
                6) Peso Colombiano =>> Dólar 
                7) Salir
                
                Elija una opcion valida
                
                *******************************************************
                """;

        return menu;
    }

    public static final Double setConvertirMoneda(final Double monedaBase, final Double monedasAcambio, final Double valorCambioMoneda) {
        Double convertido = 0.0D;
        Double temporal = 0.0D;
        temporal = (monedasAcambio * valorCambioMoneda) / monedaBase;
        //Math.round(mivalor * 100.0) / 100.0;
        convertido = (double) Math.round( (temporal * 100.00) / 100.00);
        return convertido;
    }

    public static final void setMostrarMensajeMonedas(){
        System.out.println("Ingrese el valor que desea convertir ");
    }

    public static final boolean getValidaMonedaAcambio(double monedasAcambio ) {
        boolean monedasAcambioRnt = false;
        monedasAcambioRnt = monedasAcambio <= 0.0 ? false : true;
        return monedasAcambioRnt;
    }

    public static final void setMostrarMensajeErrorMonedas(){
        System.out.println("No se pueden convertir las monedas ingresadas ");
        System.out.println();
    }

    public static final void setMensajeREspuestaConversion(final double monedasAcambio, final String codigoMoneda, final double pesosConvertidos, final String busquedaCodigoMoneda) {
        System.out.println("El valor " + monedasAcambio + " [" + codigoMoneda + "]" + " corresponde al valor final de =>>>> " + pesosConvertidos + " [" + busquedaCodigoMoneda + "]");
        System.out.println();
    }

    public static final Set<CodigoTipoModea> getCodigosMonedas() {
        Set<CodigoTipoModea> codigos = null;

        codigos = new HashSet<>();

        CodigoTipoModea codigo1 = new CodigoTipoModea("AED",	"UAE Dirham",					"United Arab Emirates");
        CodigoTipoModea codigo2 = new CodigoTipoModea("AFN",	"Afghan Afghani",				"Afghanistan");
        CodigoTipoModea codigo3 = new CodigoTipoModea("ALL",	"Albanian Lek",					"Albania");
        CodigoTipoModea codigo4 = new CodigoTipoModea("AMD",	"Armenian Dram",				"Armenia");
        CodigoTipoModea codigo5 = new CodigoTipoModea("ANG",	"Netherlands", 					"Antillian Guilder	Netherlands Antilles");
        CodigoTipoModea codigo6 = new CodigoTipoModea("AOA",	"Angolan Kwanza",				"Angola");
        CodigoTipoModea codigo7 = new CodigoTipoModea("ARS",	"Argentine Peso",				"Argentina");
        CodigoTipoModea codigo8 = new CodigoTipoModea("AUD",	"Australian Dollar",			"Australia");
        CodigoTipoModea codigo9 = new CodigoTipoModea("AWG",	"Aruban Florin",				"Aruba");
        CodigoTipoModea codigo10 = new CodigoTipoModea("AZN",	"Azerbaijani Manat",			"Azerbaijan");
        CodigoTipoModea codigo11 = new CodigoTipoModea("BAM",	"Bosnia and Herzegovina Mark", 	"Bosnia and Herzegovina");
        CodigoTipoModea codigo12 = new CodigoTipoModea("BBD",	"Barbados Dollar",				"Barbados");
        CodigoTipoModea codigo13 = new CodigoTipoModea("BDT",	"Bangladeshi Taka",				"Bangladesh");
        CodigoTipoModea codigo14 = new CodigoTipoModea("BGN",	"Bulgarian Lev",				"Bulgaria");
        CodigoTipoModea codigo15 = new CodigoTipoModea("BHD",	"Bahraini Dinar",				"Bahrain");
        CodigoTipoModea codigo16 = new CodigoTipoModea("BIF",	"Burundian Franc",				"Burundi");
        CodigoTipoModea codigo17 = new CodigoTipoModea("BMD",	"Bermudian Dollar",				"Bermuda");
        CodigoTipoModea codigo18 = new CodigoTipoModea("BND",	"Brunei Dollar",				"Brunei");
        CodigoTipoModea codigo19 = new CodigoTipoModea("BOB",	"Bolivian Boliviano",			"Bolivia");
        CodigoTipoModea codigo20 = new CodigoTipoModea("BRL",	"Brazilian Real",				"Brazil");
        CodigoTipoModea codigo21 = new CodigoTipoModea("BSD",	"Bahamian Dollar",				"Bahamas");
        CodigoTipoModea codigo22 = new CodigoTipoModea("BTN",	"Bhutanese Ngultrum",			"Bhutan");
        CodigoTipoModea codigo23 = new CodigoTipoModea("BWP",	"Botswana Pula",				"Botswana");
        CodigoTipoModea codigo24 = new CodigoTipoModea("BYN",	"Belarusian Ruble",				"Belarus");
        CodigoTipoModea codigo25 = new CodigoTipoModea("BZD",	"Belize Dollar",				"Belize");
        CodigoTipoModea codigo26 = new CodigoTipoModea("CAD",	"Canadian Dollar",				"Canada");
        CodigoTipoModea codigo27 = new CodigoTipoModea("CDF",	"Congolese Franc",				"Democratic Republic of the Congo");
        CodigoTipoModea codigo28 = new CodigoTipoModea("CHF",	"Swiss Franc",					"Switzerland");
        CodigoTipoModea codigo29 = new CodigoTipoModea("CLP",	"Chilean Peso",					"Chile");
        CodigoTipoModea codigo30 = new CodigoTipoModea("CNY",	"Chinese Renminbi",				"China");
        CodigoTipoModea codigo31 = new CodigoTipoModea("COP",	"Colombian Peso",				"Colombia");
        CodigoTipoModea codigo32 = new CodigoTipoModea("CRC",	"Costa Rican Colon",			"Costa Rica");
        CodigoTipoModea codigo33 = new CodigoTipoModea("CUP",	"Cuban Peso",					"Cuba");
        CodigoTipoModea codigo34 = new CodigoTipoModea("CVE",	"Cape Verdean Escudo",			"Cape Verde");
        CodigoTipoModea codigo35 = new CodigoTipoModea("CZK",	"Czech Koruna",					"Czech Republic");
        CodigoTipoModea codigo36 = new CodigoTipoModea("DJF",	"Djiboutian Franc",				"Djibouti");
        CodigoTipoModea codigo37 = new CodigoTipoModea("DKK",	"Danish Krone",					"Denmark");
        CodigoTipoModea codigo38 = new CodigoTipoModea("DOP",	"Dominican Peso",				"Dominican Republic");
        CodigoTipoModea codigo39 = new CodigoTipoModea("DZD",	"Algerian Dinar",				"Algeria");
        CodigoTipoModea codigo40 = new CodigoTipoModea("EGP",	"Egyptian Pound",				"Egypt");
        CodigoTipoModea codigo41 = new CodigoTipoModea("ERN",	"Eritrean Nakfa",				"Eritrea");
        CodigoTipoModea codigo42 = new CodigoTipoModea("ETB",	"Ethiopian Birr",				"Ethiopia");
        CodigoTipoModea codigo43 = new CodigoTipoModea("EUR",	"Euro",							"European Union");
        CodigoTipoModea codigo44 = new CodigoTipoModea("FJD",	"Fiji Dollar",					"Fiji");
        CodigoTipoModea codigo45 = new CodigoTipoModea("FKP",	"Falkland Islands Pound",		"Falkland Islands");
        CodigoTipoModea codigo46 = new CodigoTipoModea("FOK",	"Faroese Króna",				"Faroe Islands");
        CodigoTipoModea codigo47 = new CodigoTipoModea("GBP",	"Pound Sterling",				"United Kingdom");
        CodigoTipoModea codigo48 = new CodigoTipoModea("GEL",	"Georgian Lari",				"Georgia");
        CodigoTipoModea codigo49 = new CodigoTipoModea("GGP",	"Guernsey Pound",				"Guernsey");
        CodigoTipoModea codigo50 = new CodigoTipoModea("GHS",	"Ghanaian Cedi",				"Ghana");
        CodigoTipoModea codigo51 = new CodigoTipoModea("GIP",	"Gibraltar Pound",				"Gibraltar");
        CodigoTipoModea codigo52 = new CodigoTipoModea("GMD",	"Gambian Dalasi",				"The Gambia");
        CodigoTipoModea codigo53 = new CodigoTipoModea("GNF",	"Guinean Franc",				"Guinea");
        CodigoTipoModea codigo54 = new CodigoTipoModea("GTQ",	"Guatemalan Quetzal",			"Guatemala");
        CodigoTipoModea codigo55 = new CodigoTipoModea("GYD",	"Guyanese Dollar",				"Guyana");
        CodigoTipoModea codigo56 = new CodigoTipoModea("HKD",	"Hong Kong Dollar",				"Hong Kong");
        CodigoTipoModea codigo57 = new CodigoTipoModea("HNL",	"Honduran Lempira",				"Honduras");
        CodigoTipoModea codigo58 = new CodigoTipoModea("HRK",	"Croatian Kuna",				"Croatia");
        CodigoTipoModea codigo59 = new CodigoTipoModea("HTG",	"Haitian Gourde",				"Haiti");
        CodigoTipoModea codigo60 = new CodigoTipoModea("HUF",	"Hungarian Forint",				"Hungary");
        CodigoTipoModea codigo61 = new CodigoTipoModea("IDR",	"Indonesian Rupiah",			"Indonesia");
        CodigoTipoModea codigo62 = new CodigoTipoModea("ILS",	"Israeli New Shekel",			"Israel");
        CodigoTipoModea codigo63 = new CodigoTipoModea("IMP",	"Manx Pound",					"Isle of Man");
        CodigoTipoModea codigo64 = new CodigoTipoModea("INR",	"Indian Rupee",					"India");
        CodigoTipoModea codigo65 = new CodigoTipoModea("IQD",	"Iraqi Dinar",					"Iraq");
        CodigoTipoModea codigo66 = new CodigoTipoModea("IRR",	"Iranian Rial",					"Iran");
        CodigoTipoModea codigo67 = new CodigoTipoModea("ISK",	"Icelandic Króna",				"Iceland");
        CodigoTipoModea codigo68 = new CodigoTipoModea("JEP",	"Jersey Pound",					"Jersey");
        CodigoTipoModea codigo69 = new CodigoTipoModea("JMD",	"Jamaican Dollar",				"Jamaica");
        CodigoTipoModea codigo70 = new CodigoTipoModea("JOD",	"Jordanian Dinar",				"Jordan");
        CodigoTipoModea codigo71 = new CodigoTipoModea("JPY",	"Japanese Yen",					"Japan");
        CodigoTipoModea codigo72 = new CodigoTipoModea("KES",	"Kenyan Shilling",				"Kenya");
        CodigoTipoModea codigo73 = new CodigoTipoModea("KGS",	"Kyrgyzstani Som",				"Kyrgyzstan");
        CodigoTipoModea codigo74 = new CodigoTipoModea("KHR",	"Cambodian Riel",				"Cambodia");
        CodigoTipoModea codigo75 = new CodigoTipoModea("KID",	"Kiribati Dollar",				"Kiribati");
        CodigoTipoModea codigo76 = new CodigoTipoModea("KMF",	"Comorian Franc",				"Comoros");
        CodigoTipoModea codigo77 = new CodigoTipoModea("KRW",	"South Korean Won",				"South Korea");
        CodigoTipoModea codigo78 = new CodigoTipoModea("KWD",	"Kuwaiti Dinar",				"Kuwait");
        CodigoTipoModea codigo79 = new CodigoTipoModea("KYD",	"Cayman Islands Dollar",		"Cayman Islands");
        CodigoTipoModea codigo80 = new CodigoTipoModea("KZT",	"Kazakhstani Tenge",			"Kazakhstan");
        CodigoTipoModea codigo81 = new CodigoTipoModea("LAK",	"Lao Kip",						"Laos");
        CodigoTipoModea codigo82 = new CodigoTipoModea("LBP",	"Lebanese Pound",				"Lebanon");
        CodigoTipoModea codigo83 = new CodigoTipoModea("LKR",	"Sri Lanka Rupee",				"Sri Lanka");
        CodigoTipoModea codigo84 = new CodigoTipoModea("LRD",	"Liberian Dollar",				"Liberia");
        CodigoTipoModea codigo85 = new CodigoTipoModea("LSL",	"Lesotho Loti",					"Lesotho");
        CodigoTipoModea codigo86 = new CodigoTipoModea("LYD",	"Libyan Dinar",					"Libya");
        CodigoTipoModea codigo87 = new CodigoTipoModea("MAD",	"Moroccan Dirham",				"Morocco");
        CodigoTipoModea codigo88 = new CodigoTipoModea("MDL",	"Moldovan Leu",					"Moldova");
        CodigoTipoModea codigo89 = new CodigoTipoModea("MGA",	"Malagasy Ariary",				"Madagascar");
        CodigoTipoModea codigo90 = new CodigoTipoModea("MKD",	"Macedonian Denar",				"North Macedonia");
        CodigoTipoModea codigo91 = new CodigoTipoModea("MMK",	"Burmese Kyat",					"Myanmar");
        CodigoTipoModea codigo92 = new CodigoTipoModea("MNT",	"Mongolian Tögrög",				"Mongolia");
        CodigoTipoModea codigo93 = new CodigoTipoModea("MOP",	"Macanese Pataca",				"Macau");
        CodigoTipoModea codigo94 = new CodigoTipoModea("MRU",	"Mauritanian Ouguiya",			"Mauritania");
        CodigoTipoModea codigo95 = new CodigoTipoModea("MUR",	"Mauritian Rupee",				"Mauritius");
        CodigoTipoModea codigo96 = new CodigoTipoModea("MVR",	"Maldivian Rufiyaa",			"Maldives");
        CodigoTipoModea codigo97 = new CodigoTipoModea("MWK",	"Malawian Kwacha",				"Malawi");
        CodigoTipoModea codigo98 = new CodigoTipoModea("MXN",	"Mexican Peso",					"Mexico");
        CodigoTipoModea codigo99 = new CodigoTipoModea("MYR",	"Malaysian Ringgit",			"Malaysia");
        CodigoTipoModea codigo100 = new CodigoTipoModea("MZN",	"Mozambican Metical",			"Mozambique");
        CodigoTipoModea codigo101 = new CodigoTipoModea("NAD",	"Namibian Dollar",				"Namibia");
        CodigoTipoModea codigo102 = new CodigoTipoModea("NGN",	"Nigerian Naira",				"Nigeria");
        CodigoTipoModea codigo103 = new CodigoTipoModea("NIO",	"Nicaraguan Córdoba",			"Nicaragua");
        CodigoTipoModea codigo104 = new CodigoTipoModea("NOK",	"Norwegian Krone",				"Norway");
        CodigoTipoModea codigo105 = new CodigoTipoModea("NPR",	"Nepalese Rupee",				"Nepal");
        CodigoTipoModea codigo106 = new CodigoTipoModea("NZD",	"New Zealand Dollar",			"New Zealand");
        CodigoTipoModea codigo107 = new CodigoTipoModea("OMR",	"Omani Rial",					"Oman");
        CodigoTipoModea codigo108 = new CodigoTipoModea("PAB",	"Panamanian Balboa",			"Panama");
        CodigoTipoModea codigo109 = new CodigoTipoModea("PEN",	"Peruvian Sol",					"Peru");
        CodigoTipoModea codigo110 = new CodigoTipoModea("PGK",	"Papua New Guinean Kina",		"Papua New Guinea");
        CodigoTipoModea codigo111 = new CodigoTipoModea("PHP",	"Philippine Peso",				"Philippines");
        CodigoTipoModea codigo112 = new CodigoTipoModea("PKR",	"Pakistani Rupee",				"Pakistan");
        CodigoTipoModea codigo113 = new CodigoTipoModea("PLN",	"Polish Złoty",					"Poland");
        CodigoTipoModea codigo114 = new CodigoTipoModea("PYG",	"Paraguayan Guaraní",			"Paraguay");
        CodigoTipoModea codigo115 = new CodigoTipoModea("QAR",	"Qatari Riyal",					"Qatar");
        CodigoTipoModea codigo116 = new CodigoTipoModea("RON",	"Romanian Leu",					"Romania");
        CodigoTipoModea codigo117 = new CodigoTipoModea("RSD",	"Serbian Dinar",				"Serbia");
        CodigoTipoModea codigo118 = new CodigoTipoModea("RUB",	"Russian Ruble",				"Russia");
        CodigoTipoModea codigo119 = new CodigoTipoModea("RWF",	"Rwandan Franc",				"Rwanda");
        CodigoTipoModea codigo120 = new CodigoTipoModea("SAR",	"Saudi Riyal",					"Saudi Arabia");
        CodigoTipoModea codigo121 = new CodigoTipoModea("SBD",	"Solomon Islands Dollar",		"Solomon Islands");
        CodigoTipoModea codigo122 = new CodigoTipoModea("SCR",	"Seychellois Rupee",			"Seychelles");
        CodigoTipoModea codigo123 = new CodigoTipoModea("SDG",	"Sudanese Pound",				"Sudan");
        CodigoTipoModea codigo124 = new CodigoTipoModea("SEK",	"Swedish Krona",				"Sweden");
        CodigoTipoModea codigo125 = new CodigoTipoModea("SGD",	"Singapore Dollar",				"Singapore");
        CodigoTipoModea codigo126 = new CodigoTipoModea("SHP",	"Saint Helena Pound",			"Saint Helena");
        CodigoTipoModea codigo127 = new CodigoTipoModea("SLE",	"Sierra Leonean Leone",			"Sierra Leone");
        CodigoTipoModea codigo128 = new CodigoTipoModea("SOS",	"Somali Shilling",				"Somalia");
        CodigoTipoModea codigo129 = new CodigoTipoModea("SRD",	"Surinamese Dollar",			"Suriname");
        CodigoTipoModea codigo130 = new CodigoTipoModea("SSP",	"South Sudanese Pound",			"South Sudan");
        CodigoTipoModea codigo131 = new CodigoTipoModea("STN",	"São Tomé and Príncipe Dobra",	"São Tomé and Príncipe");
        CodigoTipoModea codigo132 = new CodigoTipoModea("SYP",	"Syrian Pound",					"Syria");
        CodigoTipoModea codigo133 = new CodigoTipoModea("SZL",	"Eswatini Lilangeni",			"Eswatini");
        CodigoTipoModea codigo134 = new CodigoTipoModea("THB",	"Thai Baht",					"Thailand");
        CodigoTipoModea codigo135 = new CodigoTipoModea("TJS",	"Tajikistani Somoni",			"Tajikistan");
        CodigoTipoModea codigo136 = new CodigoTipoModea("TMT",	"Turkmenistan Manat",			"Turkmenistan");
        CodigoTipoModea codigo137 = new CodigoTipoModea("TND",	"Tunisian Dinar",				"Tunisia");
        CodigoTipoModea codigo138 = new CodigoTipoModea("TOP",	"Tongan Paʻanga",				"Tonga");
        CodigoTipoModea codigo139 = new CodigoTipoModea("TRY",	"Turkish Lira",					"Turkey");
        CodigoTipoModea codigo140 = new CodigoTipoModea("TTD",	"Trinidad and Tobago Dollar",	"Trinidad and Tobago");
        CodigoTipoModea codigo141 = new CodigoTipoModea("TVD",	"Tuvaluan Dollar",				"Tuvalu");
        CodigoTipoModea codigo142 = new CodigoTipoModea("TWD",	"New Taiwan Dollar",			"Taiwan");
        CodigoTipoModea codigo143 = new CodigoTipoModea("TZS",	"Tanzanian Shilling",			"Tanzania");
        CodigoTipoModea codigo144 = new CodigoTipoModea("UAH",	"Ukrainian Hryvnia",			"Ukraine");
        CodigoTipoModea codigo145 = new CodigoTipoModea("UGX",	"Ugandan Shilling",				"Uganda");
        CodigoTipoModea codigo146 = new CodigoTipoModea("USD",	"United States Dollar",			"United States");
        CodigoTipoModea codigo147 = new CodigoTipoModea("UYU",	"Uruguayan Peso",				"Uruguay");
        CodigoTipoModea codigo148 = new CodigoTipoModea("UZS",	"Uzbekistani So'm",				"Uzbekistan");
        CodigoTipoModea codigo149 = new CodigoTipoModea("VES",	"Venezuelan Bolívar Soberano",	"Venezuela");
        CodigoTipoModea codigo150 = new CodigoTipoModea("VND",	"Vietnamese Đồng",				"Vietnam");
        CodigoTipoModea codigo151 = new CodigoTipoModea("VUV",	"Vanuatu Vatu",					"Vanuatu");
        CodigoTipoModea codigo152 = new CodigoTipoModea("WST",	"Samoan Tālā",					"Samoa");
        CodigoTipoModea codigo153 = new CodigoTipoModea("XAF",	"Central African CFA Franc",	"CEMAC");
        CodigoTipoModea codigo154 = new CodigoTipoModea("XCD",	"East Caribbean Dollar",		"Organisation of Eastern Caribbean States");
        CodigoTipoModea codigo155 = new CodigoTipoModea("XDR",	"Special Drawing Rights",		"International Monetary Fund");
        CodigoTipoModea codigo156 = new CodigoTipoModea("XOF",	"West African CFA franc",		"CFA");
        CodigoTipoModea codigo157 = new CodigoTipoModea("XPF",	"CFP Franc",					"Collectivités d'Outre-Mer");
        CodigoTipoModea codigo158 = new CodigoTipoModea("YER",	"Yemeni Rial",					"Yemen");
        CodigoTipoModea codigo159 = new CodigoTipoModea("ZAR",	"South African Rand",			"South Africa");
        CodigoTipoModea codigo160 = new CodigoTipoModea("ZMW",	"Zambian Kwacha",				"Zambia");
        CodigoTipoModea codigo161 = new CodigoTipoModea("ZWL",	"Zimbabwean Dollar",			"Zimbabwe");

        codigos.add(codigo1);
        codigos.add(codigo2);
        codigos.add(codigo3);
        codigos.add(codigo4);
        codigos.add(codigo5);
        codigos.add(codigo6);
        codigos.add(codigo7);
        codigos.add(codigo8);
        codigos.add(codigo9);
        codigos.add(codigo10);
        codigos.add(codigo11);
        codigos.add(codigo12);
        codigos.add(codigo13);
        codigos.add(codigo14);
        codigos.add(codigo15);
        codigos.add(codigo16);
        codigos.add(codigo17);
        codigos.add(codigo18);
        codigos.add(codigo19);
        codigos.add(codigo20);
        codigos.add(codigo21);
        codigos.add(codigo22);
        codigos.add(codigo23);
        codigos.add(codigo24);
        codigos.add(codigo25);
        codigos.add(codigo26);
        codigos.add(codigo27);
        codigos.add(codigo28);
        codigos.add(codigo29);
        codigos.add(codigo30);
        codigos.add(codigo31);
        codigos.add(codigo32);
        codigos.add(codigo33);
        codigos.add(codigo34);
        codigos.add(codigo35);
        codigos.add(codigo36);
        codigos.add(codigo37);
        codigos.add(codigo38);
        codigos.add(codigo39);
        codigos.add(codigo40);
        codigos.add(codigo41);
        codigos.add(codigo42);
        codigos.add(codigo43);
        codigos.add(codigo44);
        codigos.add(codigo45);
        codigos.add(codigo46);
        codigos.add(codigo47);
        codigos.add(codigo48);
        codigos.add(codigo49);
        codigos.add(codigo50);
        codigos.add(codigo51);
        codigos.add(codigo52);
        codigos.add(codigo53);
        codigos.add(codigo54);
        codigos.add(codigo55);
        codigos.add(codigo56);
        codigos.add(codigo57);
        codigos.add(codigo58);
        codigos.add(codigo59);
        codigos.add(codigo60);
        codigos.add(codigo61);
        codigos.add(codigo62);
        codigos.add(codigo63);
        codigos.add(codigo64);
        codigos.add(codigo65);
        codigos.add(codigo66);
        codigos.add(codigo67);
        codigos.add(codigo68);
        codigos.add(codigo69);
        codigos.add(codigo70);
        codigos.add(codigo71);
        codigos.add(codigo72);
        codigos.add(codigo73);
        codigos.add(codigo74);
        codigos.add(codigo75);
        codigos.add(codigo76);
        codigos.add(codigo77);
        codigos.add(codigo78);
        codigos.add(codigo79);
        codigos.add(codigo80);
        codigos.add(codigo81);
        codigos.add(codigo82);
        codigos.add(codigo83);
        codigos.add(codigo84);
        codigos.add(codigo85);
        codigos.add(codigo86);
        codigos.add(codigo87);
        codigos.add(codigo88);
        codigos.add(codigo89);
        codigos.add(codigo90);
        codigos.add(codigo91);
        codigos.add(codigo92);
        codigos.add(codigo93);
        codigos.add(codigo94);
        codigos.add(codigo95);
        codigos.add(codigo96);
        codigos.add(codigo97);
        codigos.add(codigo98);
        codigos.add(codigo99);
        codigos.add(codigo100);
        codigos.add(codigo101);
        codigos.add(codigo102);
        codigos.add(codigo103);
        codigos.add(codigo104);
        codigos.add(codigo105);
        codigos.add(codigo106);
        codigos.add(codigo107);
        codigos.add(codigo108);
        codigos.add(codigo109);
        codigos.add(codigo110);
        codigos.add(codigo111);
        codigos.add(codigo112);
        codigos.add(codigo113);
        codigos.add(codigo114);
        codigos.add(codigo115);
        codigos.add(codigo116);
        codigos.add(codigo117);
        codigos.add(codigo118);
        codigos.add(codigo119);
        codigos.add(codigo120);
        codigos.add(codigo121);
        codigos.add(codigo122);
        codigos.add(codigo123);
        codigos.add(codigo124);
        codigos.add(codigo125);
        codigos.add(codigo126);
        codigos.add(codigo127);
        codigos.add(codigo128);
        codigos.add(codigo129);
        codigos.add(codigo130);
        codigos.add(codigo131);
        codigos.add(codigo132);
        codigos.add(codigo133);
        codigos.add(codigo134);
        codigos.add(codigo135);
        codigos.add(codigo136);
        codigos.add(codigo137);
        codigos.add(codigo138);
        codigos.add(codigo139);
        codigos.add(codigo140);
        codigos.add(codigo141);
        codigos.add(codigo142);
        codigos.add(codigo143);
        codigos.add(codigo144);
        codigos.add(codigo145);
        codigos.add(codigo146);
        codigos.add(codigo147);
        codigos.add(codigo148);
        codigos.add(codigo149);
        codigos.add(codigo150);
        codigos.add(codigo151);
        codigos.add(codigo152);
        codigos.add(codigo153);
        codigos.add(codigo154);
        codigos.add(codigo155);
        codigos.add(codigo156);
        codigos.add(codigo157);
        codigos.add(codigo158);
        codigos.add(codigo159);
        codigos.add(codigo160);
        codigos.add(codigo161);

        return codigos;
    }

    public static final Set<String> getCodigosValidos() {
        Set<String> codigos = null;

        codigos = new HashSet<>();

        codigos.add("AED");
        codigos.add("AFN");
        codigos.add("ALL");
        codigos.add("AMD");
        codigos.add("ANG");
        codigos.add("AOA");
        codigos.add("ARS");
        codigos.add("AUD");
        codigos.add("AWG");
        codigos.add("AZN");
        codigos.add("BAM");
        codigos.add("BBD");
        codigos.add("BDT");
        codigos.add("BGN");
        codigos.add("BHD");
        codigos.add("BIF");
        codigos.add("BMD");
        codigos.add("BND");
        codigos.add("BOB");
        codigos.add("BRL");
        codigos.add("BSD");
        codigos.add("BTN");
        codigos.add("BWP");
        codigos.add("BYN");
        codigos.add("BZD");
        codigos.add("CAD");
        codigos.add("CDF");
        codigos.add("CHF");
        codigos.add("CLP");
        codigos.add("CNY");
        codigos.add("COP");
        codigos.add("CRC");
        codigos.add("CUP");
        codigos.add("CVE");
        codigos.add("CZK");
        codigos.add("DJF");
        codigos.add("DKK");
        codigos.add("DOP");
        codigos.add("DZD");
        codigos.add("EGP");
        codigos.add("ERN");
        codigos.add("ETB");
        codigos.add("EUR");
        codigos.add("FJD");
        codigos.add("FKP");
        codigos.add("FOK");
        codigos.add("GBP");
        codigos.add("GEL");
        codigos.add("GGP");
        codigos.add("GHS");
        codigos.add("GIP");
        codigos.add("GMD");
        codigos.add("GNF");
        codigos.add("GTQ");
        codigos.add("GYD");
        codigos.add("HKD");
        codigos.add("HNL");
        codigos.add("HRK");
        codigos.add("HTG");
        codigos.add("HUF");
        codigos.add("IDR");
        codigos.add("ILS");
        codigos.add("IMP");
        codigos.add("INR");
        codigos.add("IQD");
        codigos.add("IRR");
        codigos.add("ISK");
        codigos.add("JEP");
        codigos.add("JMD");
        codigos.add("JOD");
        codigos.add("JPY");
        codigos.add("KES");
        codigos.add("KGS");
        codigos.add("KHR");
        codigos.add("KID");
        codigos.add("KMF");
        codigos.add("KRW");
        codigos.add("KWD");
        codigos.add("KYD");
        codigos.add("KZT");
        codigos.add("LAK");
        codigos.add("LBP");
        codigos.add("LKR");
        codigos.add("LRD");
        codigos.add("LSL");
        codigos.add("LYD");
        codigos.add("MAD");
        codigos.add("MDL");
        codigos.add("MGA");
        codigos.add("MKD");
        codigos.add("MMK");
        codigos.add("MNT");
        codigos.add("MOP");
        codigos.add("MRU");
        codigos.add("MUR");
        codigos.add("MVR");
        codigos.add("MWK");
        codigos.add("MXN");
        codigos.add("MYR");
        codigos.add("MZN");
        codigos.add("NAD");
        codigos.add("NGN");
        codigos.add("NIO");
        codigos.add("NOK");
        codigos.add("NPR");
        codigos.add("NZD");
        codigos.add("OMR");
        codigos.add("PAB");
        codigos.add("PEN");
        codigos.add("PGK");
        codigos.add("PHP");
        codigos.add("PKR");
        codigos.add("PLN");
        codigos.add("PYG");
        codigos.add("QAR");
        codigos.add("RON");
        codigos.add("RSD");
        codigos.add("RUB");
        codigos.add("RWF");
        codigos.add("SAR");
        codigos.add("SBD");
        codigos.add("SCR");
        codigos.add("SDG");
        codigos.add("SEK");
        codigos.add("SGD");
        codigos.add("SHP");
        codigos.add("SLE");
        codigos.add("SOS");
        codigos.add("SRD");
        codigos.add("SSP");
        codigos.add("STN");
        codigos.add("SYP");
        codigos.add("SZL");
        codigos.add("THB");
        codigos.add("TJS");
        codigos.add("TMT");
        codigos.add("TND");
        codigos.add("TOP");
        codigos.add("TRY");
        codigos.add("TTD");
        codigos.add("TVD");
        codigos.add("TWD");
        codigos.add("TZS");
        codigos.add("UAH");
        codigos.add("UGX");
        codigos.add("USD");
        codigos.add("UYU");
        codigos.add("UZS");
        codigos.add("VES");
        codigos.add("VND");
        codigos.add("VUV");
        codigos.add("WST");
        codigos.add("XAF");
        codigos.add("XCD");
        codigos.add("XDR");
        codigos.add("XOF");
        codigos.add("XPF");
        codigos.add("YER");
        codigos.add("ZAR");
        codigos.add("ZMW");
        codigos.add("ZWL");

        return codigos;
    }

    public static final String getJsonResponseConversor(final String codigoMoneda){
        String responseString = null;
        String url = new String(pathBaseUrl).concat(codigoMoneda);
        try {
            URI uri = URI.create(url);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();
            HttpResponse<String> response = null;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (!Objects.isNull(response)){
                responseString = response.body();
            }
        } catch (IOException | InterruptedException | IllegalArgumentException e) {
            System.out.println("Error de comunicacion con el API");
        }
        return responseString;
    }


    public static final ResponseJsonConversor getJsonConversor(final String jsonResponse) {
        ResponseJsonConversor responseJsonConversor = null;
        if (Objects.isNull(jsonResponse)) {
            return null;
        }
        try {
            Gson gson = null;
            gson = new Gson();
            responseJsonConversor = gson.fromJson(jsonResponse, ResponseJsonConversor.class);
        } catch (JsonParseException jpe) {
            System.out.println("Error al convertir String a clase JAVA");
        }
        return responseJsonConversor;
    }
}
