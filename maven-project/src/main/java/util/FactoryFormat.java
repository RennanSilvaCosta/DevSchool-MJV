package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FactoryFormat {

    static final int TAMANHO_TELEFONE_FIXO = 10;
    static final int TAMANHO_CELULAR = 11;
    static final int TAMANHO_CPF = 11;

    public static String formataCpf(String cpf) {
        StringBuilder stringBuilder = new StringBuilder();
        if (cpf.length() == TAMANHO_CPF) {
            stringBuilder.append(cpf, 0, 3).append(".");
            stringBuilder.append(cpf, 3, 6).append(".");
            stringBuilder.append(cpf, 6, 9).append("-");
            stringBuilder.append(cpf, 9, 11);

            return stringBuilder.toString();
        }
        return cpf;
    }

    public static String formataData(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        return formatter.format(data);
    }

    public static String formataData(LocalDateTime data, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(LocalDateTime.now());
    }

    public static String formataTelefone(String telefone) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");

        if (telefone.length() == TAMANHO_TELEFONE_FIXO) {
            stringBuilder.append(telefone, 0, 2).append(") ");
            stringBuilder.append(telefone, 2, 6).append("-");
            stringBuilder.append(telefone, 6, 10);

            return stringBuilder.toString();

        } else if (telefone.length() == TAMANHO_CELULAR) {
            stringBuilder.append(telefone, 0, 2).append(") ");
            stringBuilder.append(telefone, 2, 3).append(" ");
            stringBuilder.append(telefone, 3, 7).append("-");
            stringBuilder.append(telefone, 7, 11);

            return stringBuilder.toString();
        }
        return telefone;
    }

}
