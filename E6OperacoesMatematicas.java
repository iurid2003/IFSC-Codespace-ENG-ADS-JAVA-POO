import java.util.Scanner;

public class E6OperacoesMatematicas {
    public static void main(String[] args) {
        System.out.println("--- Vamos Jogar o Jogo da Forca ---");
        String palavra;
        Scanner scanf = new Scanner(System.in);
        char letra;
        int pos_letra;
        String[] dicas = new String[3]; // Corrigido para 3 dicas
        int num_dicas = 2;
        // Solicita a palavra e as dicas
        System.out.print("Digite a palavra que o próximo jogador tem que achar: ");
        palavra = scanf.nextLine();

        System.out.print("Digite a dica 1 para o seu companheiro: ");
        dicas[0] = scanf.nextLine();

        System.out.print("Digite a dica 2 para o seu companheiro: ");
        dicas[1] = scanf.nextLine();

        System.out.print("Digite a dica 3 para o seu companheiro: ");
        dicas[2] = scanf.nextLine();

        int tamanho_palavra = palavra.length();
        char[] nova_palavra = new char[tamanho_palavra]; // Corrigido para char
        for (int j = 0; j < tamanho_palavra; j++) {
            nova_palavra[j] = '_'; // Inicializa com '_'
        }

        int tentativas = 6; // Número de tentativas
        boolean acertou = false;

        while (tentativas > 0 && !acertou) {
            System.out.println("Palavra: " + String.valueOf(nova_palavra));
            System.out.println("Tentativas restantes: " + tentativas);
            System.out.print("Digite uma letra: ");
            letra = scanf.next().charAt(0);

            if (palavra.indexOf(letra) != -1) {
                // Atualiza a nova_palavra com a letra correta
                for (int i = 0; i < tamanho_palavra; i++) {
                    if (palavra.charAt(i) == letra) {
                        nova_palavra[i] = letra;
                    }
                }
                System.out.println("A palavra tem a letra que você digitou.");
            } else {
                tentativas--;
                System.out.println("A letra não está na palavra.");
                if(num_dicas != -1 ){
                 System.out.println("Dica : " + dicas[num_dicas]);
                 num_dicas--;
                }else{
                   System.out.println("Nao tem mais dicas");
                }
                
            }

            // Verifica se a palavra foi completamente descoberta
            acertou = String.valueOf(nova_palavra).equals(palavra);
        }

        if (acertou) {
            System.out.println("Parabéns! Você adivinhou a palavra: " + palavra);
        } else {
            System.out.println("Você perdeu! A palavra era: " + palavra);
        }

        // Exibe as dicas
        System.out.println("Dicas:");
        for (String dica : dicas) {
            System.out.println("- " + dica);
        }

        // Fecha o scanner
        scanf.close();
    }
}
