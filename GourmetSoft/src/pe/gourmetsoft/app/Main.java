package pe.gourmetsoft.app;

import pe.gourmetsoft.model.Pedido;
import pe.gourmetsoft.pattern.adapter.PedidosYaAdapter;
import pe.gourmetsoft.pattern.adapter.RappiAdapter;
import pe.gourmetsoft.pattern.facade.PedidoFacade;
import pe.gourmetsoft.pattern.singleton.ControlCaja;
import pe.gourmetsoft.service.CajaService;
import pe.gourmetsoft.service.CajaServiceImpl;
import pe.gourmetsoft.service.PedidoService;
import pe.gourmetsoft.service.impl.PedidoServiceImpl;
import pe.gourmetsoft.pattern.strategy.*;
import pe.gourmetsoft.pattern.observer.*;
import pe.gourmetsoft.pattern.factory.*;
import pe.gourmetsoft.pattern.composite.*;
import pe.gourmetsoft.pattern.decorator.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   SISTEMA GOURMETSOFT - INICIO DEL SISTEMA");
        System.out.println("========================================\n");

        // --- MÓDULO 1: CONTROL DE CAJA (Singleton) ---
        System.out.println("--- [Módulo 1] Control de Caja ---");
        ControlCaja cajaUnica = ControlCaja.getInstancia();
        CajaService servicioCaja = new CajaServiceImpl(cajaUnica);
        
        System.out.println("Estado inicial: " + servicioCaja.consultarEstado());
        
        try {
            servicioCaja.abrirCaja("CAJA-001", "Omar Pineda");
            System.out.println("Después de abrir: " + servicioCaja.consultarEstado());
            System.out.println("¿Es instancia única?: " + (cajaUnica == ControlCaja.getInstancia()));
        } catch (IllegalStateException e) {
            System.out.println("Advertencia: " + e.getMessage());
        }
        
        // --- MÓDULO 4: ADICIONALES Y TOPPINGS (Decorator) ---
        System.out.println("\n--- [Módulo 4] Personalización de Platos (Decorator) ---");
        // 1. Creamos un plato base
        IPlatoBase platoBase = new PlatoBaseRestaurante("Lomo Saltado Tradicional", 28.00);
        
        // 2. Aplicamos decoradores dinámicamente en tiempo de ejecución
        IPlatoBase platoPersonalizado = new AdicionalQuesoDecorator(platoBase);
        platoPersonalizado = new AdicionalSalsaEspecialDecorator(platoPersonalizado);
        
        System.out.println("Plato Base: " + platoBase.getDescripcion() + " | S/. " + platoBase.getPrecio());
        System.out.println("Plato Final: " + platoPersonalizado.getDescripcion());
        System.out.println("Costo total con adicionales: S/. " + platoPersonalizado.getPrecio());

        // --- MÓDULO 3: CARTA Y MENÚS EN ÁRBOL (Composite) ---
        System.out.println("\n--- [Módulo 3] Estructuración de la Carta (Composite) ---");
        CategoriaCarta cartaPrincipal = new CategoriaCarta("Carta Principal GourmetSoft");
        
        // Subcategoría de Platos de Fondo (añadimos nuestro plato decorado y uno simple)
        CategoriaCarta catPlatosFondo = new CategoriaCarta("Platos de Fondo");
        catPlatosFondo.agregar(new PlatoSimple(platoPersonalizado.getDescripcion(), platoPersonalizado.getPrecio()));
        catPlatosFondo.agregar(new PlatoSimple("Ají de Gallina", 24.00));
        
        // Subcategoría de Bebidas
        CategoriaCarta catBebidas = new CategoriaCarta("Bebidas y Refrescos");
        catBebidas.agregar(new PlatoSimple("Chicha Morada 1L", 12.00));
        catBebidas.agregar(new PlatoSimple("Inka Kola 1L", 8.00));

        // Construimos el árbol de la carta
        cartaPrincipal.agregar(catPlatosFondo);
        cartaPrincipal.agregar(catBebidas);

        // Mostramos toda la estructura de la carta gastronómica de forma recursiva
        cartaPrincipal.mostrarDetalle("");
        System.out.println("-> Costo total acumulado de la categoría Platos de Fondo: S/. " + catPlatosFondo.obtenerPrecio());

        // --- MÓDULO 2: EMISIÓN DE COMPROBANTES Y COMANDAS (Abstract Factory) ---
        System.out.println("\n--- [Módulo 2] Generación de Comprobantes (Abstract Factory) ---");
        // Simulamos la creación de documentos para un pedido por Canal Delivery
        PedidoAbstractFactory factoryDelivery = new DeliveryPedidoFactory();
        System.out.println("Generando documentos para canal [DELIVERY]:");
        factoryDelivery.crearComprobante().emitirComprobante();
        factoryDelivery.crearComandaCocina().imprimirComanda();

        // Simulamos la creación de documentos para un pedido por Canal Salón
        PedidoAbstractFactory factorySalon = new SalonPedidoFactory();
        System.out.println("\nGenerando documentos para canal [SALÓN PRESENCIAL]:");
        factorySalon.crearComprobante().emitirComprobante();
        factorySalon.crearComandaCocina().imprimirComanda();
        
        // --- MÓDULO 5: FACADE Y ADAPTERS ---
        System.out.println("\n--- [Módulo 5] Fachada de Pedidos e Integración Delivery ---");
        
        // 1. Instanciar servicios y fachada
        PedidoService pedidoService = new PedidoServiceImpl();
        PedidoFacade facade = new PedidoFacade(servicioCaja, pedidoService);
        
        // 2. Registrar las plataformas externas (Adapters)
        facade.registrarPlataforma(new RappiAdapter());
        facade.registrarPlataforma(new PedidosYaAdapter());

        // 3. Prueba: Pedido Presencial (Salón)
        System.out.println("\n>> Registrando pedido en Salón...");
        Pedido pedidoSalon = facade.registrarPedidoSalon("Mesa 4", "Lomo Saltado", 45.00);
        System.out.println("Resultado: " + pedidoSalon);

        // 4. Prueba: Pedido desde Rappi (Usa Adapter)
        System.out.println("\n>> Recibiendo pedido externo de Rappi...");
        // Simulamos el JSON que enviaría Rappi
        String jsonRappi = "{\"id_ext\":\"R-999\", \"cliente\":\"Juan Perez\", \"total\":85.50}";
        Pedido pedidoRappi = facade.recibirPedidoExterno("Rappi", jsonRappi);
        System.out.println("Resultado: " + pedidoRappi);

        // 5. Prueba: Pedido desde PedidosYa (Usa Adapter)
        System.out.println("\n>> Recibiendo pedido externo de PedidosYa...");
        String jsonPYA = "{\"id_ext\":\"PY-123\", \"cliente\":\"Maria Lopez\", \"total\":62.90}";
        Pedido pedidoPYA = facade.recibirPedidoExterno("PedidosYa", jsonPYA);
        System.out.println("Resultado: " + pedidoPYA);

        // 6. Consulta final
        System.out.println("\n>> Consultando pedido guardado (ID: " + pedidoSalon.getId() + ")...");
        System.out.println("Detalle: " + facade.consultarPedido(pedidoSalon.getId()));
        
        // --- MÓDULO 6: STRATEGY --------------------------------------------------------------
        System.out.println("\n--- [Módulo 6] Strategy ---");

        CalculadoraCobro calculadora =
                new CalculadoraCobro(new PagoEfectivo());

        System.out.println("Pago en efectivo: S/ "
                + calculadora.calcular(100));

        calculadora.setEstrategia(new PagoTarjeta());

        System.out.println("Pago con tarjeta: S/ "
                + calculadora.calcular(100));

        calculadora.setEstrategia(new DescuentoCorporativo());

        System.out.println("Descuento corporativo: S/ "
                + calculadora.calcular(100));

        calculadora.setEstrategia(new PropinaSugerida());

        System.out.printf("Con propina sugerida: S/ %.2f%n",
        calculadora.calcular(100));


        // --- MÓDULO 6: OBSERVER ----------------------------------------------
        System.out.println("\n--- [Módulo 6] Observer ---");

        NotificadorPedidos notificador = new NotificadorPedidos();

        notificador.agregarObservador(new MonitorCocina());
        notificador.agregarObservador(new MonitorBar());

        // Simular la llegada de un pedido
        notificador.notificar(pedidoSalon, "NUEVO PEDIDO");

        // Simular un cambio de estado
        pedidoSalon.setEstado("DESPACHADO");

        notificador.notificar(pedidoSalon, "PEDIDO DESPACHADO");

        System.out.println("\n========================================");
        System.out.println("   PROCESO FINALIZADO CORRECTAMENTE");
        System.out.println("========================================");
        
        
    }
}