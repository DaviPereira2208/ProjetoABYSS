public class Main {

    public static void main(String[] args) {

        Jogador jogador = new Jogador("Julian Reed", 100);

        Arma pistola = new Arma("Pistola", 25, 6);
        jogador.equiparArma(pistola);

        /*
        // TESTES ANTIGOS DE ARMAS E CRIATURAS

        jogador.atacar();
        jogador.atacar();

        Infectado infectado = new Infectado("Infectado do Setor A");
        infectado.atacar();
        jogador.atacar(infectado);
        IO.println("Vida do infectado: " + infectado.getVida());

        Rasgado rasgado = new Rasgado("Rasgado do Setor B");
        rasgado.atacar();
        jogador.atacar(rasgado);
        IO.println("Vida restante do Rasgado: " + rasgado.getVida());

        Observador observador = new Observador("Observador do Setor C");
        observador.atacar();
        jogador.atacar(observador);
        IO.println("Vida restante do Observador: " + observador.getVida());

        Paciente03 caleb = new Paciente03("Caleb Vance");
        IO.println("=== CHEFE: PACIENTE 03 ===");
        caleb.atacar();
        jogador.atacar(caleb);
        IO.println("Vida restante de Caleb: " + caleb.getVida());

        pistola.recarregar(6);
        jogador.atacar(caleb);
        caleb.atacar(jogador);


        // TESTES ANTIGOS DE KIT MÉDICO E INVENTÁRIO

        KitMedico kit = new KitMedico();
        IO.println("=== USANDO KIT MÉDICO ===");
        kit.usar(jogador);

        KitMedico kitMedico = new KitMedico();
        jogador.getInventario().adicionarItem(kit);
        jogador.getInventario().listarItens();

        IO.println("=== USANDO KIT MÉDICO ===");
        jogador.usarKitMedico(kit);

        IO.println("=== INVENTÁRIO APÓS O USO ===");
        jogador.getInventario().listarItens();

        IO.println("-------------");
        IO.println("=== INVENTÁRIO ANTES DO USO ===");
        jogador.getInventario().listarItens();

        IO.println("=== USANDO O KIT MÉDICO ===");
        jogador.usarItemDoInventario(0);

        IO.println("=== INVENTÁRIO DEPOIS DO USO ===");
        jogador.getInventario().listarItens();

        jogador.getInventario().adicionarItem(new KitMedico());
        jogador.getInventario().adicionarItem(new KitMedico());
        jogador.getInventario().adicionarItem(new KitMedico());

        jogador.getInventario().listarItens();

        IO.println("Total de itens: "
                + jogador.getInventario().getQuantidadeItens());


        // TESTES ANTIGOS DE CARTÕES E PORTAS

        CartaoDeAcesso cartaoTeste =
                new CartaoDeAcesso("Cartão do Setor B", 2);

        cartaoTeste.exibirInformacoes();

        CartaoDeAcesso cartaoNivel1 =
                new CartaoDeAcesso("Cartão do Setor A", 1);

        CartaoDeAcesso cartaoNivel2 =
                new CartaoDeAcesso("Cartão do Setor B", 2);

        Porta portaTeste =
                new Porta("Porta do Laboratório B", 2);

        portaTeste.abrir(cartaoNivel1);
        portaTeste.abrir(cartaoNivel2);

        jogador.getInventario().adicionarItem(cartaoTeste);
        jogador.getInventario().listarItens();

        Porta outraPorta =
                new Porta("Porta do Laboratório B", 2);

        outraPorta.abrir(cartaoTeste);


        // TESTES ANTIGOS DE COLETA DE CARTÕES

        CartaoDeAcesso cartaoEncontrado =
                new CartaoDeAcesso("Cartão do Setor C", 3);

        jogador.coletarItem(cartaoEncontrado);
        jogador.getInventario().listarItens();

        CartaoDeAcesso outroCartao =
                new CartaoDeAcesso("Cartão do Setor C", 3);

        jogador.coletarItem(outroCartao);
        jogador.getInventario().listarItens();


        // TESTE ANTIGO DE UMA SALA ISOLADA

        Sala salaArquivoTeste = new Sala(
                "Arquivo Subterrâneo",
                "Uma sala escura cheia de documentos e equipamentos abandonados."
        );

        salaArquivoTeste.adicionarItem(
                new CartaoDeAcesso("Cartão do Setor C", 3)
        );

        salaArquivoTeste.adicionarItem(new KitMedico());
        salaArquivoTeste.explorar();

        salaArquivoTeste.coletarItem(0, jogador);
        jogador.getInventario().listarItens();
        salaArquivoTeste.explorar();


        // TESTES ANTIGOS DE EXPLORAÇÃO E COMBATE

        Fase faseTeste = new Fase("Setor Subterrâneo");
        faseTeste.listarSalas();
        faseTeste.explorarSala(1);

        jogador.getInventario().listarItens();

        Combate combateTeste =
                new Combate(jogador, new Infectado("Infectado de Teste"));

        combateTeste.iniciar();
        */


        // =====================================
        // CENÁRIO ATUAL DO PROJECT: ABYSS
        // =====================================

        Fase faseSubterranea = new Fase("Setor Subterrâneo");

        Sala recepcao = new Sala(
                "Recepção Abandonada",
                "Uma recepção destruída, com marcas de sangue nas paredes."
        );

        Sala arquivo = new Sala(
                "Arquivo Subterrâneo",
                "Documentos espalhados e equipamentos deixados para trás."
        );

        Infectado infectadoArquivo =
                new Infectado("Infectado do Arquivo");

        arquivo.adicionarCriatura(infectadoArquivo);

        Sala laboratorio = new Sala(
                "Laboratório Restrito",
                "Uma porta reforçada protege o setor de experimentos."
        );

        Sala deposito = new Sala(
                "Depósito de Suprimentos",
                "Prateleiras enferrujadas guardam caixas de medicamentos, munição e materiais de emergência."
        );

        deposito.adicionarItem(new KitMedico());

        deposito.adicionarItem(
                new CartaoDeAcesso("Cartão do Depósito", 1)
        );


        // =====================================
        // FASE E PORTA DO LABORATÓRIO
        // =====================================

        faseSubterranea.adicionarSala(recepcao);
        faseSubterranea.adicionarSala(arquivo);
        faseSubterranea.adicionarSala(laboratorio);
        faseSubterranea.adicionarSala(deposito);

        Porta portaLaboratorio =
                new Porta("Porta do Laboratório Restrito", 2);

        laboratorio.definirPortaAcesso(portaLaboratorio);


        // =====================================
        // CONEXÕES ENTRE AS SALAS
        // =====================================

        recepcao.conectarSala(arquivo);
        arquivo.conectarSala(recepcao);

        arquivo.conectarSala(laboratorio);
        laboratorio.conectarSala(arquivo);

        laboratorio.conectarSala(deposito);
        deposito.conectarSala(laboratorio);


        // =====================================
        // INÍCIO DA EXPLORAÇÃO
        // =====================================

        IO.println("================================");
        IO.println("        PROJECT: ABYSS");
        IO.println("================================");

        Exploracao exploracao =
                new Exploracao(jogador, recepcao);

        exploracao.iniciar();

        IO.println("==============================");
        IO.println(" TESTE DE COMBATE - PROJECT: ABYSS");
        IO.println("==============================");

        Combate combate = new Combate(jogador, infectadoArquivo);
        combate.iniciar();

    }
}
