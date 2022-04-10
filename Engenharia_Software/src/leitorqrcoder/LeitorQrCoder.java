package leitorqrcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author Bruno Batista
 */

public class LeitorQrCoder {
  
    public static void main(String[] args) {
        List<String> invalido = new ArrayList<>();
        List<String> valido = new ArrayList<>();
        List<String> centroOeste = new ArrayList<>();// 201 até 299
        List<String> nordeste = new ArrayList<>();// 300 até 399
        List<String> norte = new ArrayList<>();// 400 até 499
        List<String> sudeste = new ArrayList<>();// 001 até 099
        List<String> sul = new ArrayList<>();// 100 até 199
        List<String> pacoteOriginSul = new ArrayList<>();
        List<String> pacoteValidCentroOeste = new ArrayList<>();
        List<String> pacoteValidNordeste = new ArrayList<>();
        List<String> pacoteValidNorte = new ArrayList<>();
        List<String> pacoteValidSudeste = new ArrayList<>();
        List<String> pacoteValidSul = new ArrayList<>();
        List<String> centroOesteJoias = new ArrayList<>();
        List<String> centroOesteLivros = new ArrayList<>();
        List<String> centroOesteEletronicos = new ArrayList<>();
        List<String> centroOesteBebidas = new ArrayList<>();
        List<String> centroOesteBrinquedos = new ArrayList<>();
        List<String> nordesteJoias = new ArrayList<>();
        List<String> nordesteLivros = new ArrayList<>();
        List<String> nordesteEletronicos = new ArrayList<>();
        List<String> nordesteBebidas = new ArrayList<>();
        List<String> nordesteBrinquedos = new ArrayList<>();
        List<String> norteJoias = new ArrayList<>();
        List<String> norteLivros = new ArrayList<>();
        List<String> norteEletronicos = new ArrayList<>();
        List<String> norteBebidas = new ArrayList<>();
        List<String> norteBrinquedos = new ArrayList<>();
        List<String> sudesteJoias = new ArrayList<>();
        List<String> sudesteLivros = new ArrayList<>();
        List<String> sudesteEletronicos = new ArrayList<>();
        List<String> sudesteBebidas = new ArrayList<>();
        List<String> sudesteBrinquedos = new ArrayList<>();
        List<String> sulJoias = new ArrayList<>();
        List<String> sulLivros = new ArrayList<>();
        List<String> sulEletronicos = new ArrayList<>();
        List<String> sulBebidas = new ArrayList<>();
        List<String> sulBrinquedos = new ArrayList<>();
        List<String> despachoRotaNorte = new ArrayList<>();
        Stack<String> ordemCargaRotaNorte = new Stack<>();
        Stack<String> ordemCargaRotaNorteJoias = new Stack<>();
        List<String> listaVendedoresPorPacote = new ArrayList<>();
        Map<String, Integer> cont = new TreeMap<>();
        
        /*
        Instanciei uma nova lista de strings, agrupando por trincas e a cada trinca adicionado um "." separador, para que
        fosse possível fazer um split(). Com isso irei obter uma nova lista onde os códigos irá está divididos por trincas.
        Assim, poderei percorrer cada indice e comparar os valores.
        Poderia ter feito um algoritmo para para percorrer o codigo de barras e a cada trinca adicionar um ".", mas por questões
        de práticidade e rápidez, preferir ja intanciar manualmente.
        */
        List<String> list = new ArrayList<>();
        list.add(0, "288.355.555.123.888");
        list.add(1, "335.333.555.584.333");
        list.add(2, "223.343.555.124.001");
        list.add(3, "002.111.555.874.555");
        list.add(4, "111.188.555.654.777");
        list.add(5, "111.333.555.123.333");
        list.add(6, "432.055.555.123.888");
        list.add(7, "079.333.555.584.333");
        list.add(8, "155.333.555.124.001");
        list.add(9, "333.188.555.584.333");
        list.add(10, "555.288.555.123.001");
        list.add(11, "111.388.555.123.555");
        list.add(12, "288.000.555.367.333");
        list.add(13, "066.311.555.874.001");
        list.add(14, "110.333.555.123.555");
        list.add(15, "333.488.555.584.333");
        list.add(16, "455.448.555.123.001");
        list.add(17, "022.388.555.123.555");
        list.add(18, "432.044.555.845.333");
        list.add(19, "034.311.555.874.001");
        
        // IDENTIFICAR OS PACOTES VALIDOS E INVALIDOS
        for(int i=0; i < list.size(); i++){
            String isValid = list.get(i);
            isValid = isValid.substring(12,15);
            if(isValid.equals("367")){
                invalido.add( list.get(i));
            }else{
                valido.add(list.get(i));
            }
        }
        
        // SABER A REGIÃO DE DESTINO DE CADA PACOTE, E SALVANDO EM UM lIST, PARA PODER FAZER A CONTAGEM DE PACOTES
        // POR REGIÃO
        for(int i=0; i < list.size(); i++){
            String whichRegion = list.get(i);
            whichRegion = whichRegion.substring(4,7);
            int codeRegion = Integer.parseInt(whichRegion);
            if((codeRegion >= 201 && codeRegion <= 299)){
                centroOeste.add(list.get(i));
            }
            else if(codeRegion >= 300 && codeRegion <= 399){
                nordeste.add(list.get(i));
            }
            else if(codeRegion >= 400 && codeRegion <= 499){
                norte.add(list.get(i));
            }
            else if(codeRegion >= 001 && codeRegion <= 99){
                sudeste.add(list.get(i));
            }
            else if(codeRegion >= 100 && codeRegion <= 199){
                sul.add(list.get(i));
            }
        }
        
        // IDENTIFICAR PACOTE DE ORIGEM NA REGIÃO SUL E QUE CONTEM BRINQUEDOS EM SEU CONTEÚDO
        for(int i=0; i < list.size(); i++){
            String originRegion = list.get(i);
            String brinquedo = list.get(i);
            originRegion = originRegion.substring(0,3);
            brinquedo = brinquedo.substring(16,19);
            int codRegionOrigin = Integer.parseInt(originRegion);
            int codBrinquedo = Integer.parseInt(brinquedo);
            if((codRegionOrigin >= 100 && codRegionOrigin <= 199) && (codBrinquedo == 888)){
                pacoteOriginSul.add(list.get(i));
            }
        }
        
        // AGRUPAR PACOTES POR REGIÃO, CONSIDERANDO APENAS OS PACOTES VALIDOS
        for(int i=0; i < valido.size(); i++){
            String whichRegion = valido.get(i);
            whichRegion = whichRegion.substring(4,7);
            int codeRegion = Integer.parseInt(whichRegion);
            if((codeRegion >= 201 && codeRegion <= 299)){
                pacoteValidCentroOeste.add(valido.get(i));
            }
            else if(codeRegion >= 300 && codeRegion <= 399){
                pacoteValidNordeste.add(valido.get(i));
            }
            else if(codeRegion >= 400 && codeRegion <= 499){
                pacoteValidNorte.add(valido.get(i));
            }
            else if(codeRegion >= 001 && codeRegion <= 99){
                pacoteValidSudeste.add(valido.get(i));
            }
            else{
                pacoteValidSul.add(valido.get(i));
            }
        }
        
        // GERAR RELATORIO DE ACORDO COM DESTINO E TIPO DE PRODUTO
        // E QUE SEJAM VÁLIDOS
        for(int i=0; i < valido.size(); i++){
            String codRegion = valido.get(i);
            String codProduto = valido.get(i);
            codRegion = codRegion.substring(4,7);
            codProduto = codProduto.substring(16,19);
            int region = Integer.parseInt(codRegion);
            int produto = Integer.parseInt(codProduto);
            if((region >=201 && region <= 299) && produto == 001){
                centroOesteJoias.add(valido.get(i));
            }
            else if((region >=201 && region <= 299) && produto == 111){
                centroOesteLivros.add(valido.get(i));
            }
            else if((region >=201 && region <= 299) && produto == 333){
                centroOesteEletronicos.add(valido.get(i));
            }
            else if((region >=201 && region <= 299) && produto == 555){
                centroOesteBebidas.add(valido.get(i));
            }
            else if((region >=201 && region <= 299) && produto == 888){
                centroOesteBrinquedos.add(valido.get(i));
            }
            else if((region >=300 && region <= 399) && produto == 001){
                nordesteJoias.add(valido.get(i));
            }
            else if((region >=300 && region <= 399) && produto == 111){
                nordesteLivros.add(valido.get(i));
            }
            else if((region >=300 && region <= 399) && produto == 333){
                nordesteEletronicos.add(valido.get(i));
            }
            else if((region >=300 && region <= 399) && produto == 555){
                nordesteBebidas.add(valido.get(i));
            }
            else if((region >=300 && region <= 399) && produto == 888){
                nordesteBrinquedos.add(valido.get(i));
            }
            else if((region >=400 && region <= 499) && produto == 001){
                norteJoias.add(valido.get(i));
            }
            else if((region >=400 && region <= 499) && produto == 111){
                norteLivros.add(valido.get(i));
            }
            else if((region >=400 && region <= 499) && produto == 333){
                norteEletronicos.add(valido.get(i));
            }
            else if((region >=400 && region <= 499) && produto == 555){
                norteBebidas.add(valido.get(i));
            }
            else if((region >=400 && region <= 499) && produto == 888){
                norteBrinquedos.add(valido.get(i));
            }
            else if((region >=001 && region <= 99) && produto == 001){
                sudesteJoias.add(valido.get(i));
            }
            else if((region >=001 && region <= 99) && produto == 111){
                sudesteLivros.add(valido.get(i));
            }
            else if((region >=001 && region <= 99) && produto == 333){
                sudesteEletronicos.add(valido.get(i));
            }
            else if((region >=001 && region <= 99) && produto == 555){
                sudesteBebidas.add(valido.get(i));
            }
            else if((region >=001 && region <= 99) && produto == 888){
                sudesteBrinquedos.add(valido.get(i));
            }
            else if((region >=100 && region <= 199) && produto == 001){
                sulJoias.add(valido.get(i));
            }
            else if((region >=100 && region <= 199) && produto == 111){
                sulLivros.add(valido.get(i));
            }
            else if((region >=100 && region <= 199) && produto == 333){
                sulEletronicos.add(valido.get(i));
            }
            else if((region >=100 && region <= 199) && produto == 555){
                sulBebidas.add(valido.get(i));
            }
            else if((region >=100 && region <= 199) && produto == 888){
                sulBrinquedos.add(valido.get(i));
            }
        }
        
        // PACOTES A SEREM DESPACHADOS NO CAMINHÃO, COM DESTINO AO NORTE
        for(int i=0; i < valido.size(); i++){
            String codigoRegion = valido.get(i);
            codigoRegion = codigoRegion.substring(4,7);
            int codRegion = Integer.parseInt(codigoRegion);
            if(codRegion >= 201 && codRegion <= 499){
                despachoRotaNorte.add(valido.get(i));
            }
        }
        
        // ORDEM DE CARGA PARA O NORTE NO CAMINHÃO, PARA DESCARREGAR OS PACOTES DA REGIÃO CENTRO-OESTE PRIMEIRO
        // PARA ISSO, UTILIZEI O CONCEITO DE PILHA, ONDE O ULTIMO A ENTRAR SERÁ O PRIMEIRO A SAIR. ASSIM, COLOCAMOS
        // OS PACOTES DO NORTE PRIMEIRO, JÁ QUE SERÁ A ULTIMA ENTREGA, DEPOIS OS DO NORDESTE JÁ QUE SERÁ A PENAULTIMA ENTREGA E,
        // POR FIM, ADICIONAMOS OS PACOTES DO CENTRO-OESTE POR ULTIMO, JÁ QUE ELES SERÃO A PRIMEIRA ENTREGA.
        for(int i=0; i < valido.size(); i++){
            String codigoRegion = valido.get(i);
            codigoRegion = codigoRegion.substring(4,7);
            int codRegion = Integer.parseInt(codigoRegion);
            if(codRegion >= 400 && codRegion <= 499){
                ordemCargaRotaNorte.push(valido.get(i));
            }
        }
        for(int i=0; i < valido.size(); i++){
            String codigoRegion = valido.get(i);
            codigoRegion = codigoRegion.substring(4,7);
            int codRegion = Integer.parseInt(codigoRegion);
            if(codRegion >= 300 && codRegion <= 399){
                ordemCargaRotaNorte.push(valido.get(i));
            }
        }
        for(int i=0; i < valido.size(); i++){
            String codigoRegion = valido.get(i);
            codigoRegion = codigoRegion.substring(4,7);
            int codRegion = Integer.parseInt(codigoRegion);
            if(codRegion >= 201 && codRegion <= 299){
                ordemCargaRotaNorte.push(valido.get(i));
            }
        }
        
        // ORDEM DE CARGA PARA O NORTE NO CAMINHÃO, PARA DESCARREGAR OS PACOTES DA REGIÃO CENTRO-OESTE PRIMEIRO.
        // E CONSIDERANDO QUE CADA REGIÃO DEVE DESCARREGAR OS PACOTES QUE CONTÉM JOIAS, PRIMEIRO.
        // UTILIZEI OS CONCEITOS DE PILHA COMO NA QUESTÃO ANTERIOR, ADICIONANDO PRIMEIRO OS PACOTES QUE CONTEM JOIAS DA REFERIDA REGIÃO E DEPOIS OS DEMAIS PACOTES.
        // EX: REGIÃO CENTRO-OESTE: ADICIONA OS PACOTES DA REGIÃO CENTRO-OESTE QUE NÃO CONTEM JOIAS E DEPOIS ADICIONA OS QUE CONTEM JOIAS. e ASSIM FAZ O MESMO PARA AS OUTRAS REGIÕES
        for(int i=0; i < valido.size(); i++){
            String codigoRegion = valido.get(i);
            String codigoProduto = valido.get(i);
            codigoRegion = codigoRegion.substring(4,7);
            codigoProduto = codigoProduto.substring(16,19);
            int codRegion = Integer.parseInt(codigoRegion);
            int codProduto = Integer.parseInt(codigoProduto);
            if((codRegion >= 400 && codRegion <= 499) && codProduto != 001){
                ordemCargaRotaNorteJoias.push(valido.get(i));
            }
        }
        for(int i=0; i < valido.size(); i++){
            String codigoRegion = valido.get(i);
            String codigoProduto = valido.get(i);
            codigoRegion = codigoRegion.substring(4,7);
            codigoProduto = codigoProduto.substring(16,19);
            int codRegion = Integer.parseInt(codigoRegion);
            int codProduto = Integer.parseInt(codigoProduto);
            if((codRegion >= 400 && codRegion <= 499) && codProduto == 001){
                ordemCargaRotaNorteJoias.push(valido.get(i));
            }
        }
        for(int i=0; i < valido.size(); i++){
            String codigoRegion = valido.get(i);
            String codigoProduto = valido.get(i);
            codigoRegion = codigoRegion.substring(4,7);
            codigoProduto = codigoProduto.substring(16,19);
            int codRegion = Integer.parseInt(codigoRegion);
            int codProduto = Integer.parseInt(codigoProduto);
            if((codRegion >= 300 && codRegion <= 399) && codProduto != 001){
                ordemCargaRotaNorteJoias.push(valido.get(i));
            }
        }
        for(int i=0; i < valido.size(); i++){
            String codigoRegion = valido.get(i);
            String codigoProduto = valido.get(i);
            codigoRegion = codigoRegion.substring(4,7);
            codigoProduto = codigoProduto.substring(16,19);
            int codRegion = Integer.parseInt(codigoRegion);
            int codProduto = Integer.parseInt(codigoProduto);
            if((codRegion >= 300 && codRegion <= 399) && codProduto == 001){
                ordemCargaRotaNorteJoias.push(valido.get(i));
            }
        }
        for(int i=0; i < valido.size(); i++){
            String codigoRegion = valido.get(i);
            String codigoProduto = valido.get(i);
            codigoRegion = codigoRegion.substring(4,7);
            codigoProduto = codigoProduto.substring(16,19);
            int codRegion = Integer.parseInt(codigoRegion);
            int codProduto = Integer.parseInt(codigoProduto);
            if((codRegion >= 201 && codRegion <= 299) && codProduto != 001){
                ordemCargaRotaNorteJoias.push(valido.get(i));
            }
        }
        for(int i=0; i < valido.size(); i++){
            String codigoRegion = valido.get(i);
            String codigoProduto = valido.get(i);
            codigoRegion = codigoRegion.substring(4,7);
            codigoProduto = codigoProduto.substring(16,19);
            int codRegion = Integer.parseInt(codigoRegion);
            int codProduto = Integer.parseInt(codigoProduto);
            if((codRegion >= 201 && codRegion <= 299) && codProduto == 001){
                ordemCargaRotaNorteJoias.push(valido.get(i));
            }
        }
        
        // PEGANDO OS VENDEDORESS DE CADA PACOTE E ARMAZENANDO EM UMA LIST. PARA DEPOIS VERIFICAR QUANTAS VEZES CADA ELEMENTO(VENDEDOR) SE REPETE NA LISTA
        // E ASSIM OBTER A QUANTIDADE DE CADA ELEMENTO.
        for(int i=0; i < valido.size(); i++){
            String codVendedor = valido.get(i);
            codVendedor = codVendedor.substring(12,15);
            listaVendedoresPorPacote.add(codVendedor);
        }
        
        for (String nome : listaVendedoresPorPacote) {
		if (!cont.containsKey(nome))
			cont.put(nome, 0);
		cont.put(nome, cont.get(nome) + 1);
	}
        
        System.out.println("======Questão 1======");
        System.out.println("Centro-Oeste: " + centroOeste.size() + " pacotes");
        System.out.println("Nordeste: " + nordeste.size() + " pacotes");
        System.out.println("Norte: " + norte.size() + " pacotes");
        System.out.println("Sudeste: " + sudeste.size() + " pacotes");
        System.out.println("Sul: " + sul.size() + " pacotes");
        
        System.out.println("======Questão 2=======");
        System.out.println("======Validos=====");
        valido.forEach(x -> System.out.println(x));
        System.out.println("======Invalidos=====");
        invalido.forEach(x -> System.out.println(x));
        
        System.out.println("======Questão 3=======");
        pacoteOriginSul.forEach(x -> System.out.println(x));
        
        System.out.println("======Questão 4=======");
        System.out.println("===Centro-Oeste===");
        pacoteValidCentroOeste.forEach(x -> System.out.println(x));
        System.out.println("===Nordeste===");
        pacoteValidNordeste.forEach(x -> System.out.println(x));
        System.out.println("===Norte===");
        pacoteValidNorte.forEach(x -> System.out.println(x));
        System.out.println("===Sudeste===");
        pacoteValidSudeste.forEach(x -> System.out.println(x));
        System.out.println("===Sul===");
        pacoteValidSul.forEach(x -> System.out.println(x));
        
        System.out.println("======Questão 5======");
        for (Map.Entry<String, Integer> entry : cont.entrySet()) {
		System.out.printf("%s => %d%n","Vendedor: "+ entry.getKey(), entry.getValue());
	}
        
        System.out.println("======Questão 6=======");
        System.out.println("========Relatório de acordo com destino e produto=========");
        System.out.println("===Centro-Oeste e Joias===");
        centroOesteJoias.forEach(x -> System.out.println(x));
        System.out.println("===Centro-Oeste e Livros===");
        centroOesteLivros.forEach(x -> System.out.println(x));
        System.out.println("===Centro-Oeste e Eletronicos===");
        centroOesteEletronicos.forEach(x ->  System.out.println(x));
        System.out.println("===Centro-Oeste e Bebiddas===");
        centroOesteBebidas.forEach(x -> System.out.println(x));
        System.out.println("===Centro-Oeste e Brinquedos===");
        centroOesteBrinquedos.forEach(x -> System.out.println(x));
        System.out.println("===Nordeste e Joias===");
        nordesteJoias.forEach(x -> System.out.println(x));
        System.out.println("===Nordeste e Livros===");
        nordesteLivros.forEach(x -> System.out.println(x));
        System.out.println("===Nordeste e Eletronicos===");
        nordesteEletronicos.forEach(x -> System.out.println(x));
        System.out.println("===Nordeste e Bebidas===");
        nordesteBebidas.forEach(x -> System.out.println(x));
        System.out.println("===Nordeste e Brinquedos===");
        nordesteBrinquedos.forEach(x -> System.out.println(x));
        System.out.println("===Norte e Joias===");
        norteJoias.forEach(x -> System.out.println(x));
        System.out.println("===Norte e Livros===");
        norteLivros.forEach(x -> System.out.println(x));
        System.out.println("===Norte e Eletronicos===");
        norteEletronicos.forEach(x -> System.out.println(x));
        System.out.println("===Norte e Bebidas===");
        norteBebidas.forEach(x -> System.out.println(x));
        System.out.println("===Norte e Brinquedos===");
        norteBrinquedos.forEach(x -> System.out.println(x));
        System.out.println("===Sudeste e Joias===");
        sudesteJoias.forEach(x -> System.out.println(x));
        System.out.println("===Sudeste e Livros===");
        sudesteLivros.forEach(x -> System.out.println(x));
        System.out.println("===Sudeste e Eletronicos===");
        sudesteEletronicos.forEach(x -> System.out.println(x));
        System.out.println("===Sudeste e Bebidas===");
        sudesteBebidas.forEach(x -> System.out.println(x));
        System.out.println("===Sudeste e Brinquedos===");
        sudesteBrinquedos.forEach(x -> System.out.println(x));
        System.out.println("===Sul e Joias===");
        sulJoias.forEach(x -> System.out.println(x));
        System.out.println("===Sul e Livros===");
        sulLivros.forEach(x -> System.out.println(x));
        System.out.println("===Sul e Eletronicos===");
        sulEletronicos.forEach(x -> System.out.println(x));
        System.out.println("===Sul e Bebidas===");
        sulBebidas.forEach(x -> System.out.println(x));
        System.out.println("===Sul e Brinquedos===");
        sulBrinquedos.forEach(x -> System.out.println(x));
        
        System.out.println("======Questão 7======");
        despachoRotaNorte.forEach(x -> System.out.println(x));
        
        System.out.println("======Questão 8=======");
        ordemCargaRotaNorte.forEach(x -> System.out.println(x));
        
        System.out.println("======Questão 9=======");
        ordemCargaRotaNorteJoias.forEach(x -> System.out.println(x));
        
        System.out.println("======Questão 10=======");
        invalido.forEach(x -> System.out.println(x));
    } 
}