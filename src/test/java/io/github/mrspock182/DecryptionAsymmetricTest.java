package io.github.mrspock182;

import io.github.mrspock182.constant.TypeEncryption;
import io.github.mrspock182.constant.Unicode;
import io.github.mrspock182.decryption.DecryptionAsymmetric;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertNotNull;

public class DecryptionAsymmetricTest {

    Decryption decryption = new DecryptionAsymmetric(Unicode.UTF8,
            TypeEncryption.RSA, "src/test/java/resources/private.key");

    @Test
    public void testDecryptLong() {
        Long value = decryption
                .toLong("X9QF1sCUzmGcJZikym5yyql1yPVIUt3TATucaLKua5hdItVRskAI4B69_f2tRSWBKxYuf16wgzMlA7bgBB0426yUgH-dHBHhNp4n-YxKtlJ37UwOMa7EB1lNpp61xLOZONrzLR2_uzzIboW015yL6MkY2BNDhdWyUykMZFOt0D_3QXMPoUUOue_b30HzqoVMMNiHcV0mWg-5s68xdifQt4EKzz6RuHK51LwiArxoz68YTRrYJMstWgAj277OM0EWgNmwPgdrD8nv6o05wCTpTWdhc-QsFrebpZeUzh7Eh1uywCkAdKXCM5tR876C6I1j2s-HHpqxjzND1cVk_rjxtg==");
        assertNotNull(value);
    }

    @Test
    public void testDecryptString() {
        String value = decryption
                .toString("QMjMKxSnSi2ZRF5buk_HaZ0Q1d1Y3t9p1wQKJeGxQwSH2ZCvn7UAIvgwow77MWgfiRF_f28QW_qIk2V7ymsLuGg_S21jlzVsmn6vNNEofkZWbELW7QHlHEuD9OvQQ05pQUf4S1rQvpgUWrxm3HzAyIXOytuPT5zS5V7H9_OBJE8PQ8U4lClZKtcGS2odSbyHHpsIcFxGs44H8v9w_qLUSJje0uaYi8BWMQHiNtA82eoONNea7AaUIV90ayGq9YiN9TjBzhnL_rNMMz-nPSaR61lKU4ZKQylpDk2VxMLJxEkNtOHGJ6dD3i8SiM_UoEsW-OYeEaTHbT--OkQl-7TQpQ==");
        assertNotNull(value);
    }

    @Test
    public void testDecryptInteger() {
        Integer value = decryption
                .toInteger("B8LZ5SFiK_mhl0U_iak_VMdg08PeXtnev7Pk3Dr0SA3d2cqq7QDr63ftDzW9pqPJ-biSsOZnVnbvz_yvFj61Fp_2qK1XxUVI9J_UGxY3L9ZjTuPNuf2y2HyZyQh1fzPLfpau5kRQCP3chBPdK4z_CtUQAAoL-ULrYQ1DpFr04jvIPc98chnnFkKqUZrlSDPNAlgdHOL6aJ_217l-dEasOcjtDZXApDXvks2lw3LrbdhOADh2UNs8UYMPaCKXkTxcGJYTdZ1I2QDRaUe3Fqfc3RWDFcG2LH-BRJ5JChfDju0zTiltYol2XXxXK2dN6L-tC1OJH7p_RInRT3xq6mRcag==");
        assertNotNull(value);
    }

    @Test
    public void testDecryptBigDecimal() {
        BigDecimal value = decryption
                .toBigDecimal("L1ZBqjsUno5Oqzgfx_UIyBdol6wbbagp68DYn7xuoRvgXcDc4yb930YBJ_MO2gA282BMedZBO7CNXdC3cRKREqg2qud7Hwfl4_eYfiOf4p_TUsOB0D33ymRwa65xZV27iDES3-pcW0gsvhqT6XxbBi1PilcnodXLxjX994nIVPRHa4jN6XOP3Os-3TNFrM5HwZyVjhFW1v-ScYQjOFa4zwY_EK4wJq7YjT5XzRwZ4KUnKfSvrwRqeWpBhDqTUru3YFsrAYKdaNG8qUU9QxVeYQlqge96pjtkE00xnZYNzubZDn95BGJxKjGQ1VXy7cVYGrC1U6X9QanFCdbp1Zrn2g==");
        assertNotNull(value);
    }

    @Test
    public void testDecryptBigInteger() {
        BigInteger value = decryption
                .toBigInteger("HasKVsFAlrFMKuvbR2HsdMjlOkrcn0EA19OLG2xjboD4UBJrV2coDZCndm7E-oL2Zs6V71E0Nq8amMlDg1v4uuu-_ataL3cwc_t61kbRZ3ZY0Rb17j99md_X9NTbH8cyed-3eyLOLXdhTp1F_O0HZ9AjpVZToptEZfYzBg-KkgiRUL8wN6KcQhpDiwH80ZU0djrcOzNFag85AC2IwgkG-WxbLgYahHXmtMpP_nNK1C3_mOTeiud0Lz5G8N2p03DOIM1TFFUtVfTpKWo14qmAc4LvobG8o1aNQs0hudO_-CS5QppiuBtXaYwpRAcu_HmzzybM6yhxolqCHX28WPxy0w==");
        assertNotNull(value);
    }

    @Test
    public void testDecryptLocalDate() {
        LocalDate value = decryption
                .toLocalDate("YIQvPvXUX42J2bQNWoKZ4gU3VKy2-P8ITjIk7qORzOMUsZ6wOhD24bLP5vhersEBOl-QeZTTbJ7uucOPTPu09dCjEVTqG9PFSVxFwEoHUBMok02VlVlTtLUSlc5kdIAMMHvkJviMTjUSAcwrxBwKxxCaPOnnK0I6QFadgiOStf4TTfyu94WiV0YwbN_wTOjjlyfNFpNVIHYqJ2qIrrU-PMeXIHgKA0uTqvk5u4HOrLaeWCtzJCWlTLsOUUvbeJpglxVNJ3TEsRrDCYtwhQWyad0pFgRop5q6iCIXipciwNNsLkigqSVpcbQo-gxdvk4rbSNIse3oFcMGGCSKPkVDRw==",
                "yyyy-MM-dd");
        assertNotNull(value);
    }

    @Test
    public void testDecryptLocalDateTime() {
        LocalDateTime value = decryption
                .toLocalDateTime("h5kf_RACBWxioqB8S4zgu63ppi28SDD6ZduszJWnc1XxVIHPW5HYXOYCGY-Qtc4vw1q_lgzi6j5l1AgF2xtCbqpxWD0zkPMoF9ncqbS9qN7191IUHok1zgfASQ40NoXmSgV1aJglhJvtA_VGH-B9t4Lqdl6q8Pn0xdukW_ofm45i9RgZnPgVgPfkT8MAhGWmRBLgDBb7yLM8QdHi48ntGfkI-1FgJCbBIIRcO409I7F8JvcnYlpTxSR4ibBiK3Kk7WrzjV0GLpv7ZQkI7tGk0bp4JftnFLtSSOIJwdc7_IAQtRNtinsLxE09ppFTPee9xpVxU2UglBeS1p0d7MkWNw==",
                "yyyy-MM-dd HH:mm:ss");
        assertNotNull(value);
    }

}
