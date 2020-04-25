package io.github.mrspock182;

import io.github.mrspock182.constant.TypeEncryption;
import io.github.mrspock182.constant.Unicode;
import io.github.mrspock182.decryption.DecryptionAsymmetric;
import io.github.mrspock182.object.ClientTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DecryptionAsymmetricTest {

    Decryption decryption = new DecryptionAsymmetric(Unicode.UTF8,
            TypeEncryption.RSA, "src/test/java/resources/private.key");

    @Test
    public void testDecryptLong() {
        long value = decryption
                .toLong("X9QF1sCUzmGcJZikym5yyql1yPVIUt3TATucaLKua5hdItVRskAI4B69_f2tRSWBKxYuf16wgzMlA7bgBB0426yUgH-dHBHhNp4n-YxKtlJ37UwOMa7EB1lNpp61xLOZONrzLR2_uzzIboW015yL6MkY2BNDhdWyUykMZFOt0D_3QXMPoUUOue_b30HzqoVMMNiHcV0mWg-5s68xdifQt4EKzz6RuHK51LwiArxoz68YTRrYJMstWgAj277OM0EWgNmwPgdrD8nv6o05wCTpTWdhc-QsFrebpZeUzh7Eh1uywCkAdKXCM5tR876C6I1j2s-HHpqxjzND1cVk_rjxtg==");
        assertEquals(10L, value);
    }

    @Test
    public void testDecryptString() {
        String value = decryption
                .toString("h-OMvP5NP0yIkBo6n_UZznkIXCekP8sXwQTYRHM1nZRz8mseIGmfs6Sm9hX_lbkIbs0rAavuD5fN4XwR2TmERuwTcd63jCJquCkSg9O20UigNikX6-iejzRzTYbSn1b2ve_UpDcRKX-ROqTnXXJdVDfAuB6dr_889mMt4tQvP0RPh84Q4h_HBHJoL1_Rax_uQmXeC7ldEGaBKLNENwKpizJIledp4CSU2uPiSzkBDQP_7INtZqMW-NA9DF6drqytqbDj-ZMH38QCsVrTPjXlPgKANY_HELTIHLYkkqTGXsTOzUWa52p0yikiY4frIaAO82oYupQXD2jJ0IxpM8UGXA==");
        assertEquals("TEST", value);
    }

    @Test
    public void testDecryptInteger() {
        int value = decryption
                .toInteger("B8LZ5SFiK_mhl0U_iak_VMdg08PeXtnev7Pk3Dr0SA3d2cqq7QDr63ftDzW9pqPJ-biSsOZnVnbvz_yvFj61Fp_2qK1XxUVI9J_UGxY3L9ZjTuPNuf2y2HyZyQh1fzPLfpau5kRQCP3chBPdK4z_CtUQAAoL-ULrYQ1DpFr04jvIPc98chnnFkKqUZrlSDPNAlgdHOL6aJ_217l-dEasOcjtDZXApDXvks2lw3LrbdhOADh2UNs8UYMPaCKXkTxcGJYTdZ1I2QDRaUe3Fqfc3RWDFcG2LH-BRJ5JChfDju0zTiltYol2XXxXK2dN6L-tC1OJH7p_RInRT3xq6mRcag==");
        assertEquals(10, value);
    }

    @Test
    public void testDecryptBigDecimal() {
        BigDecimal value = decryption
                .toBigDecimal("L1ZBqjsUno5Oqzgfx_UIyBdol6wbbagp68DYn7xuoRvgXcDc4yb930YBJ_MO2gA282BMedZBO7CNXdC3cRKREqg2qud7Hwfl4_eYfiOf4p_TUsOB0D33ymRwa65xZV27iDES3-pcW0gsvhqT6XxbBi1PilcnodXLxjX994nIVPRHa4jN6XOP3Os-3TNFrM5HwZyVjhFW1v-ScYQjOFa4zwY_EK4wJq7YjT5XzRwZ4KUnKfSvrwRqeWpBhDqTUru3YFsrAYKdaNG8qUU9QxVeYQlqge96pjtkE00xnZYNzubZDn95BGJxKjGQ1VXy7cVYGrC1U6X9QanFCdbp1Zrn2g==");
        assertEquals(BigDecimal.valueOf(10), value);
    }

    @Test
    public void testDecryptBigInteger() {
        BigInteger value = decryption
                .toBigInteger("HasKVsFAlrFMKuvbR2HsdMjlOkrcn0EA19OLG2xjboD4UBJrV2coDZCndm7E-oL2Zs6V71E0Nq8amMlDg1v4uuu-_ataL3cwc_t61kbRZ3ZY0Rb17j99md_X9NTbH8cyed-3eyLOLXdhTp1F_O0HZ9AjpVZToptEZfYzBg-KkgiRUL8wN6KcQhpDiwH80ZU0djrcOzNFag85AC2IwgkG-WxbLgYahHXmtMpP_nNK1C3_mOTeiud0Lz5G8N2p03DOIM1TFFUtVfTpKWo14qmAc4LvobG8o1aNQs0hudO_-CS5QppiuBtXaYwpRAcu_HmzzybM6yhxolqCHX28WPxy0w==");
        assertEquals(BigInteger.valueOf(10), value);
    }

    @Test
    public void testDecryptLocalDate() {
        LocalDate localDate = LocalDate.of(2020, Month.APRIL, 24);
        LocalDate value = decryption
                .toLocalDate("F1w7mY99rCsC-5hXejbgMQeiLh0BwwkOswG7MMEJuch-U6Eo7RP4d5yqLUGuRWDXWjyOMyP28A9FOJGr-MM0jke32j-rpkOvyqH1TyxoVa92uy7ijKEgrmfNFS4YA8S56MD6jxaCXP8I4lPTa40JPyF9RhQunqXlrGjnIDgJMIHx_Z-WilrZ_c8-fqIRgHsemWAn-dThRe5ADcBPs2bZFAsmSlaAOlL1j5zsJyD7mAq4afoohg4vuv9D2hJeZYdKk0BhccjQtnROI3sXa_CDFeOFAuBsPkGjedrl9O-Hr3aX4nDxN7LXH7LWyLsGzoTwaX1XlcNIkfCo_m9B8yqP9w==",
                "yyyy-MM-dd");
        assertEquals(localDate, value);
    }

    @Test
    public void testDecryptLocalDateTime() {
        LocalDateTime value = decryption
                .toLocalDateTime("ZSen5BLT0YEvSNPTrzyz6WL1ZREqqlWNEBifYPNXE2QmMkY_fqeihunts5kXIbnxSG7_t-Tf3HvitIhs0lNC5dHOkbg7nzhTIRrYeTm1fSXqs8ty98TPRmTGMQJE1wu9keocG1wGTPtaQlSSxDgop7dWKkXUfM63_EM5uTpBUXCsH8JDYYutVhcM6Rieeng997WNntoP_d0wGPpQvI9AsIu7b3gUJ4bp4t8ryyVpW9DTQLXVAIiqCjM9YHVgeOudFvZGVe1QyTOodQEivpFiBfO0rU-tiCfnVszdf7gDQ46gAC3P91dVQTUaLnDbuJGfi74VNORKvuVzP_a9uqzVMw==",
                "yyyy-MM-dd HH:mm:ss");
        assertNotNull(value);
    }
    @Test
    public void testDecryptOptional() {
        ClientTest clientTest = new ClientTest();
        clientTest.setName("TEST");
        clientTest.setAddress(Arrays.asList("OptionA", "OptionB"));

        ClientTest value = decryption.toObject("PxilN_e78akTjHmaXNrs592arF-1tL8xPi-zmykxAn46VghJyJl5pT9T9le6UEZTLQ-3mGVJdvvYkZ1-HR0092m3S5x69EcxY0WlGaGJQygrAAb8dYsn9C0Lkq9oZnb_He2Ur7JWkbWUu9OUHaXLnOwkyr4E_HiHzoYQMxkrpzI_hkjKXEPBtQGHhRpys3CimoNwUqEhdYdT4YA-pzmDXz0vd70VymEuwB-KWtec99alxuZAN8f7OaLE0DstFt6ioG_l6IUA_lstIQyHUG4FJbL-sdl1T5bFxOwN_xb9j11YIT_e7fn3_DlhNSVkA1ZOv4qq01sU77mZimeUMr0T8g==",
                ClientTest.class);
        assertEquals(value.getName(), clientTest.getName());
        value.getAddress().forEach(Assert::assertNotNull);
    }


}
