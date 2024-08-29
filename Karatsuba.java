public class Karatsuba {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Informe 2 números.");
            return;
        }
            
        String res = karatsuba(args[0], args[1]);
        System.out.println(res);
    }

    private static String karatsuba(String a, String b) {
        if (a.length() == 1 && b.length() == 1)
            return multiplica(a, b);

        if (a.length() != b.length()) {
            int tamanhoMax = Math.max(a.length(), b.length());
            a = iguala(tamanhoMax, a);
            b = iguala(tamanhoMax, b);
        }

        int metade = a.length() / 2;

        String[] partesA = cortaString(a, metade);
        String[] partesB = cortaString(b, metade);
    
        String inicio = karatsuba(partesA[0], partesB[0]);
        String fim = karatsuba(partesA[1], partesB[1]);
        String meio = karatsuba(soma(partesA[0], partesA[1]), soma(partesB[0], partesB[1]));

        meio = subtrai(meio, soma(inicio, fim));

        inicio = shift(2 * (a.length() - metade), inicio);
        meio = shift(a.length() - metade, meio);

        return soma(soma(inicio, meio), fim);
    }

    private static String[] cortaString(String s, int metade) {
        String s1 = s.substring(0, metade);
        String s2 = s.substring(metade);

        return new String[] {s1, s2};
    }

    private static String soma(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int posicaoA = a.length() - 1;
        int posicaoB = b.length() - 1;

        while (posicaoA >= 0 || posicaoB >= 0 || carry > 0) {
            int soma = carry;

            if (posicaoA >= 0) soma += a.charAt(posicaoA--) - '0';
            if (posicaoB >= 0) soma += b.charAt(posicaoB--) - '0';

            sb.append(soma % 2);
            carry = soma / 2;
        }

        return sb.reverse().toString();
    }

    private static String subtrai(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int borrow = 0;
        int posicaoA = a.length() - 1;
        int posicaoB = b.length() - 1;

        while (posicaoA >= 0) {
            int diff = (a.charAt(posicaoA--) - '0') - (posicaoB >= 0 ? b.charAt(posicaoB--) - '0' : 0) - borrow;
            if (diff < 0) {
                diff += 2;
                borrow = 1;
            } else {
                borrow = 0;
            }
            sb.append(diff);
        }

        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.setLength(sb.length() - 1);
        }

        return sb.reverse().toString();
    }

    private static String multiplica(String a, String b) {
       return (a.equals("1") && b.equals("1")) ? "1" : "0";
    }

    private static String shift(int qnt, String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i=0; i<qnt; i++) {
            sb.append("0");
        }

        return sb.toString();
    }

    private static String iguala(int qnt, String s) {
        StringBuilder sb = new StringBuilder();

        for (int i=s.length(); i<qnt; i++) {
            sb.append("0");
        }

        sb.append(s);
        return sb.toString();
    }
}