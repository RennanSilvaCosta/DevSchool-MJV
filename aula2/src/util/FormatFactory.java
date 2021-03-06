package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormatFactory {

    public static String formataCpfCnpj(String cpfCnpj) {
        StringBuilder stringBuilder = new StringBuilder();

        if (cpfCnpj.length() == Constantes.TAMANHO_CNPJ) {
            stringBuilder.append(cpfCnpj, 0, 2).append(".");
            stringBuilder.append(cpfCnpj, 2, 5).append(".");
            stringBuilder.append(cpfCnpj, 5, 8).append("/");
            stringBuilder.append(cpfCnpj, 8, 12).append("-");
            stringBuilder.append(cpfCnpj, 12, 14);

            return stringBuilder.toString();

        } else if (cpfCnpj.length() == Constantes.TAMANHO_CPF) {
            stringBuilder.append(cpfCnpj, 0, 3).append(".");
            stringBuilder.append(cpfCnpj, 3, 6).append(".");
            stringBuilder.append(cpfCnpj, 6, 9).append("-");
            stringBuilder.append(cpfCnpj, 9, 11);

            return stringBuilder.toString();
        }
        return cpfCnpj;
    }

    public static String formataData(LocalDateTime data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        return formatter.format(data);
    }

    public static String formataTelefone(Long telefone) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");

        String telString = String.valueOf(telefone);

        if (telString.length() == Constantes.TAMANHO_TELEFONE_FIXO) {
            stringBuilder.append(telString, 0, 2).append(") ");
            stringBuilder.append(telString, 2, 6).append("-");
            stringBuilder.append(telString, 6, 10);

            return stringBuilder.toString();

        } else if (telString.length() == Constantes.TAMANHO_CELULAR) {
            stringBuilder.append(telString, 0, 2).append(") ");
            stringBuilder.append(telString, 2, 3).append(" ");
            stringBuilder.append(telString, 3, 7).append("-");
            stringBuilder.append(telString, 7, 11);

            return stringBuilder.toString();
        }
        return telString;
    }

    public static String formataIE(long ie) {
        StringBuilder stringBuilder = new StringBuilder();

        String ieString = String.valueOf(ie);
        stringBuilder.append(ieString, 0, 3).append(".");
        stringBuilder.append(ieString, 3, 6).append(".");
        stringBuilder.append(ieString, 6, 9);

        return stringBuilder.toString();
    }

    public static String formataIM(long im) {
        StringBuilder stringBuilder = new StringBuilder();

        String imString = String.valueOf(im);
        stringBuilder.append(imString, 0, 3).append(".");
        stringBuilder.append(imString, 3, 6).append(".");
        stringBuilder.append(imString, 6, 9);

        return stringBuilder.toString();
    }
}
