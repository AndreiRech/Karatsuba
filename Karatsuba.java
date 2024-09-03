public class Karatsuba {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Informe 2 números.");
            return;
        }
            
        String res = karatsuba(args[0], args[1]);

        if (res.startsWith("0") && res.length() > 1) 
            res = removeInuteis(res);

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

        int tamanhoMax = Math.max(a.length(), b.length());
        if (a.length() != b.length()) {
            a = iguala(tamanhoMax, a);
            b = iguala(tamanhoMax, b);
        }
        
        char carry = '0';
        for(int i=tamanhoMax-1; i>=0; i--) {
            char valorA = a.charAt(i);
            char valorB = b.charAt(i);

            if(valorA == '0' && valorB == '0') {
                sb.append( (carry == '0') ? '0' : '1' );
                carry = '0';
            } else if (valorA == '1' && valorB == '1') {
                sb.append( (carry == '0') ? '0' : '1' );
                carry = '1';
            } else {
                sb.append( (carry == '0') ? '1' : '0');
                carry = (carry == '0') ? '0' : '1'; 
            }
        }

        if (carry == '1') sb.append(carry);

        return sb.reverse().toString();
    }

    private static String subtrai(String a, String b) {
        if (a.length() != b.length()) {
            int tamanhoMax = Math.max(a.length(), b.length());
            a = iguala(tamanhoMax, a);
            b = iguala(tamanhoMax, b);
        }
        
        String complemento = complemento(b);
        complemento = soma(complemento, "1");

        String resultado = soma(a, complemento);

        if (resultado.length() > a.length()) {
            resultado = resultado.substring(1);
        }

        return resultado;
    }

    private static String multiplica(String a, String b) {
       return (a.equals("1") && b.equals("1")) ? "1" : "0";
    }

    private static String complemento(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            char x = (s.charAt(i) == '0') ? '1' : '0';
            sb.append(x);
        }

        return sb.toString();
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

    private static String removeInuteis(String s) {
        StringBuilder sb = new StringBuilder(s);

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}