package com.me;

import java.util.ArrayList;

public class Aapoc {

    public static void main(String[] args) {
	//testEncryption();
	//testKiosk();
        testDateParse();
    }
    private static void testDateParse() {

    }

    private static void testEncryption() {
        final String secretKey = "dublin-sn0w-sh0ck-reach-cl0ck";

//        String originalString = "Ike";
//        String encryptedString = AES.encrypt(originalString, secretKey) ;
//        String encryptedString = "nW7P+U0sGjVF5Vuj0t43uatEcIYF8b4hdh47x9aC3XvxiZu7qn7AGfeRWL4sDUUWxXk9XHSzTh4uiVmybTkzFR/b272x3DBciS9e+66nizeg0rGenbH+k+6i/G73+c39CN69XwVbyU0zc/k25n7ZWQ7BPc5Qw2UnIVTUoFaSVb5sEsMKtAMyMOpGwRTktYMrj4ZIKcaKjucX/2VkwmzEvvGEe9ekhQCynJc21sg9Ni3FSZz85UKe8xH+kuLZSad5S9ksMio3accMjnqiW9EYKDTHEdVHCT0WzqjCCMP/e+k31VD76cbhGzGM33T/mDae+bJQqEHKwYUcgV0suXvbfeW2cxbH3GosXen6p/SvisqZ7ZBk760CPs7A6cljNEpgG4oBWAaGjvv33to6xDVXTr6CrBebpA5PfqGZL0ycpZpAuHJWMvF/3f5beRiAqxh8e3MFsV9T1Rb1lhWDwHBtd2veH2+Y3SSOe5P/W7h2ciLlmyr1CSH+slbfTZR2hYWAOsaVN9B7iBsdttfaWUq2v0yJh5ed8KToABxEh9CTVQdiYKGkqmzC+5KUy8U+L1bphUsk/z06/vtk9Qu1IJ27wdQysJrvDkjt8eUOP+VUGYlkf/AZIDjdyeoYOuyD+lXPb+EVgzRukTQyXgKhClW0R7vyjPc9URnN12KpHFxDarDhj67oNcQ/HdIIq0gtcCXM/MWu0sjGWuE8Ao5We0o1MQ==";
//        String decryptedString = AES.decrypt(encryptedString, secretKey) ;

//        System.out.println(originalString);
//        System.out.println(encryptedString);
//        System.out.println(decryptedString);

        //encryptedString = Encryptor.encrypt(originalString) ;
        //String encryptedString = "nW7P+U0sGjVF5Vuj0t43uatEcIYF8b4hdh47x9aC3XvxiZu7qn7AGfeRWL4sDUUWxXk9XHSzTh4uiVmybTkzFR/b272x3DBciS9e+66nizeg0rGenbH+k+6i/G73+c39CN69XwVbyU0zc/k25n7ZWQ7BPc5Qw2UnIVTUoFaSVb5sEsMKtAMyMOpGwRTktYMrj4ZIKcaKjucX/2VkwmzEvvGEe9ekhQCynJc21sg9Ni3FSZz85UKe8xH+kuLZSad5S9ksMio3accMjnqiW9EYKDTHEdVHCT0WzqjCCMP/e+k31VD76cbhGzGM33T/mDae+bJQqEHKwYUcgV0suXvbfeW2cxbH3GosXen6p/SvisqZ7ZBk760CPs7A6cljNEpgG4oBWAaGjvv33to6xDVXTr6CrBebpA5PfqGZL0ycpZpAuHJWMvF/3f5beRiAqxh8e3MFsV9T1Rb1lhWDwHBtd2veH2+Y3SSOe5P/W7h2ciLlmyr1CSH+slbfTZR2hYWAOsaVN9B7iBsdttfaWUq2v0yJh5ed8KToABxEh9CTVQdiYKGkqmzC+5KUy8U+L1bphUsk/z06/vtk9Qu1IJ27wdQysJrvDkjt8eUOP+VUGYlkf/AZIDjdyeoYOuyD+lXPb+EVgzRukTQyXgKhClW0R7vyjPc9URnN12KpHFxDarDhj67oNcQ/HdIIq0gtcCXM/MWu0sjGWuE8Ao5We0o1MQ==";

        //String encryptedString = Encryptor.encrypt(BARCLAY_DECRYPTED_REQUEST);
        String encryptedString = "wN3WnxzdtW8X7Pv/mrZEQcOFP8Jj4033BeLprY1R8vcZ5pJqf4/UP48LkTQrXXmjDOG7mm3e2Yxk1XTn7qNCaErmWNavKzk1SbokYBnfKdN8jN+ccLOHy2/DRUjwbVuWeQITGih2goMEjqanlucWRS+ydO/DFWqLGQ2FsAR+74lvk+wgUNKivl35e5tJytmgW5QTChk/qgY6TeXboCVWGCmG644AHTjlULBPOTSEQ3OcgZgPJA7/XEYASmUanH9OqXnV7LcX5DimEoK6CG8DPHsBl011EAJtcXwTw1TXTJxMLrSqwTMdKSZ5ZgFKuGFVqIw+DbbcapWJsPJMzE504b6RCsXGX2U3ZJcW85aMdm0iWOcAMUVAmFanv7vrFK9eoRcpAJS5OEpqE51m4ypAs8bYz8IGoK8/Ksi06I8EA/uhsRHFl15YY3FRaH0uZCkp6kiMVfvGigUTTuMO3w7W8LNwz8gnJvCyCk6P7fACj0DUOXZIO1+VijyZqGWDPN9Tg7ggEmMW2s1vkzkl1TyQlAc4yaTAXNhm15xE5OMk5oVZ6GsjQNcSp/jOJvTO4bMKVv2TQ0NqPg1ZVGYMJlupnK5rN76VUj6TBHRrlitCaUTa3F6OwRa/nkYbszZkQTSpP/XSfblwrxHOskiIDdh8AFBCht6UhQt/e4BDwq357bo=";
        //String decryptedString = com.me.Encryptor.decrypt(encryptedString);

        //System.out.println(BARCLAY_DECRYPTED_REQUEST.equals(decryptedString));
        //System.out.println(BARCLAY_DECRYPTED_REQUEST );
       // System.out.println(decryptedString);
    }
    private static void testKiosk() {
        String[] kiosks =  { "AASSDJFK1T406", "AASSDHDQ1T506","AASSDPHL1T555","AASSDPHL1T562", "AASSDPHL1T562","AASSDPHL1T555","AABDDDD","XAASSDPHL1T555","aassdPHL1T555"};

        for (int i=0; i< kiosks.length; i++)
         System.out.println (kiosks[i] + " eligibility is " + isKioskEligible(kiosks[i]));
    }
    private static boolean isKioskEligible(String kioskId) {
        return kioskId.startsWith("AASSD");
    }
}
