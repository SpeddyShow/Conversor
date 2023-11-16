import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite sua primeira escolha para a conversão de bases:\n");
        int escolha1 = scanner.nextInt();

        System.out.print("Digite sua segunda escolha para a conversão de bases:\n");
        int escolha = scanner.nextInt();

        if (escolha1 != 10 && escolha != 10) {
            System.out.print("Digite um número decimal: ");
            int numeroDecimal = scanner.nextInt();
            System.out.println("O número correspondente é: " + converterBinarioParaDecimal(converterParaBinario(numeroDecimal, escolha), escolha1));
        }
        
        if (escolha1 == 10) {
            System.out.print("Digite um número decimal: ");
            int numeroDecimal = scanner.nextInt();
            System.out.println("O número correspondente é: " + converterParaBinario(numeroDecimal, escolha));
        }
                    
        if (escolha1 == 10 && escolha == 16) {
            System.out.print("Digite um número decimal: ");
            int numeroHexadecimal = scanner.nextInt();
            System.out.println("O número Hexadecimal correspondente é: " + converterParaHexadecimal(numeroHexadecimal));
        }

        if (escolha == 10){
            // Obter o número binário do usuário
            System.out.print("Digite um número binário: ");
            String numeroBinario = scanner.next();

            // Chamar a função para converter e exibir o resultado
            int resultadoDecimal = converterBinarioParaDecimal(numeroBinario, escolha1);
            System.out.println("O equivalente decimal de " + numeroBinario + " é: " + resultadoDecimal);
        }

        if (escolha1 == 16 && escolha == 10) {
                // Obter o número Octagonal do usuário
                System.out.print("Digite um número hexadecimal: ");
                String numeroHexpdecimal = scanner.next();

                int resultadoHexadecimal = hexToDecimal(numeroHexpdecimal);
                System.out.println("O equivalente decimal de " + numeroHexpdecimal + " é: " + resultadoHexadecimal);
        }
        scanner.close();
    }

    private static String converterParaBinario(int numeroDecimal, int BaseTransformacao) {
        if (numeroDecimal == 0) {
            return "0";
        }

        StringBuilder resultado = new StringBuilder();
        while (numeroDecimal > 0) {
            int bit = numeroDecimal % BaseTransformacao;
            resultado.insert(0, bit);
            numeroDecimal /= BaseTransformacao;
        }

        return resultado.toString();
    }

    private static String converterParaHexadecimal(int numeroHexadecimal) {
        if (numeroHexadecimal == 0) {
            return "0";
        }

        StringBuilder resultado = new StringBuilder();
        while (numeroHexadecimal > 0) {
            int resto = numeroHexadecimal % 16;
            char digitoHexadecimal = (resto < 10) ? (char) (resto + '0') : (char) (resto - 10 + 'A');
            resultado.insert(0, digitoHexadecimal);
            numeroHexadecimal /= 16;
        }
        return resultado.toString();
    }
    
    // Função para converter número binário para decimal
    private static int converterBinarioParaDecimal(String binario, int conversor) {
        int resultadoDecimal = 0;
        int tamanho = binario.length();

        // Iterar sobre cada dígito binário
        for (int i = 0; i < tamanho; i++) {
            int digito = Character.getNumericValue(binario.charAt(i));

            // Calcular o valor do dígito multiplicado pela potência de 2 correspondente
            int potencia = tamanho - i - 1;
            resultadoDecimal += digito * Math.pow(conversor, potencia);
        }

        return resultadoDecimal;
    }

    public static int hexToDecimal(String hex) {
        int NumDecimal = 0;
        String hexDigitos = "0123456789ABCDEF";

        // Garante que todas as letras da string hexadecimal estejam em maiúsculas
        hex = hex.toUpperCase();

        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            int digit = hexDigitos.indexOf(hexChar);
            NumDecimal = NumDecimal * 16 + digit;
        }

        return NumDecimal;
    }
}
