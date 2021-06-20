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
}
