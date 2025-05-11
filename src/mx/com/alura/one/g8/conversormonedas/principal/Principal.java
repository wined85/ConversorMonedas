package mx.com.alura.one.g8.conversormonedas.principal;

import mx.com.alura.one.g8.conversormonedas.dto.ResponseJsonConversor;
import mx.com.alura.one.g8.conversormonedas.utilidades.OperacionesConversor;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Principal {

    public static void main(String[] args) {
        Scanner lecturaTeclado = null;
        String textoEnttrada = null;
        try{
            lecturaTeclado = new Scanner(System.in);
            final Set<String> codigosAceptados = OperacionesConversor.getCodigosValidos();

            String codigoMoneda = null;
            String busquedaCodigoMoneda = null;
            String jsonResponse = null;
            ResponseJsonConversor responseJsonConversor = null;
            Map<String, Double> valoresMonedas = null;
            double monedasAcambio = 0.0d;
            double valorMonedaBase = 0.0d;
            double valorMonedaAcambio = 0.0d;
            double pesosConvertidos = 0.0d;
            boolean monedasAcambioCorrectas = false;
            int opcion = 0;
            while( opcion != 7 ) {
                final String menu = OperacionesConversor.getMenu();
                System.out.println(menu);
                opcion = lecturaTeclado.nextInt();
                switch (opcion) {
                    case 1 :
                        codigoMoneda = "USD";
                        busquedaCodigoMoneda = "ARS";
                        jsonResponse = OperacionesConversor.getJsonResponseConversor(codigoMoneda);
                        responseJsonConversor = OperacionesConversor.getJsonConversor(jsonResponse);
                        valoresMonedas = responseJsonConversor.conversion_rates();
                        OperacionesConversor.setMostrarMensajeMonedas();
                        monedasAcambio = lecturaTeclado.nextDouble();

                        monedasAcambioCorrectas = OperacionesConversor.getValidaMonedaAcambio(monedasAcambio);
                        if (monedasAcambioCorrectas) {
                            valorMonedaBase = (double) valoresMonedas.get(codigoMoneda);
                            valorMonedaAcambio = (double) valoresMonedas.get(busquedaCodigoMoneda);
                            pesosConvertidos= OperacionesConversor.setConvertirMoneda(valorMonedaBase, monedasAcambio, valorMonedaAcambio);
                            OperacionesConversor.setMensajeREspuestaConversion(monedasAcambio, codigoMoneda, pesosConvertidos, busquedaCodigoMoneda);
                        } else {
                            OperacionesConversor.setMostrarMensajeErrorMonedas();
                        }
                        break;
                    case 2:
                        codigoMoneda = "ARS";
                        busquedaCodigoMoneda = "USD";
                        jsonResponse = OperacionesConversor.getJsonResponseConversor(codigoMoneda);
                        responseJsonConversor = OperacionesConversor.getJsonConversor(jsonResponse);
                        valoresMonedas = responseJsonConversor.conversion_rates();
                        OperacionesConversor.setMostrarMensajeMonedas();
                        monedasAcambio = lecturaTeclado.nextDouble();
                        monedasAcambioCorrectas = OperacionesConversor.getValidaMonedaAcambio(monedasAcambio);
                        if (monedasAcambioCorrectas) {
                            valorMonedaBase = (double) valoresMonedas.get(codigoMoneda);
                            valorMonedaAcambio = (double) valoresMonedas.get(busquedaCodigoMoneda);
                            pesosConvertidos= OperacionesConversor.setConvertirMoneda(valorMonedaBase, monedasAcambio, valorMonedaAcambio);
                            OperacionesConversor.setMensajeREspuestaConversion(monedasAcambio, codigoMoneda, pesosConvertidos, busquedaCodigoMoneda);
                        } else {
                            OperacionesConversor.setMostrarMensajeErrorMonedas();
                        }
                        break;
                    case 3:
                        codigoMoneda = "USD";
                        busquedaCodigoMoneda = "BRL";
                        jsonResponse = OperacionesConversor.getJsonResponseConversor(codigoMoneda);
                        responseJsonConversor = OperacionesConversor.getJsonConversor(jsonResponse);
                        valoresMonedas = responseJsonConversor.conversion_rates();
                        OperacionesConversor.setMostrarMensajeMonedas();
                        monedasAcambio = lecturaTeclado.nextDouble();
                        monedasAcambioCorrectas = OperacionesConversor.getValidaMonedaAcambio(monedasAcambio);
                        if (monedasAcambioCorrectas) {
                            valorMonedaBase = (double) valoresMonedas.get(codigoMoneda);
                            valorMonedaAcambio = (double) valoresMonedas.get(busquedaCodigoMoneda);
                            pesosConvertidos= OperacionesConversor.setConvertirMoneda(valorMonedaBase, monedasAcambio, valorMonedaAcambio);
                            OperacionesConversor.setMensajeREspuestaConversion(monedasAcambio, codigoMoneda, pesosConvertidos, busquedaCodigoMoneda);
                        } else {
                            OperacionesConversor.setMostrarMensajeErrorMonedas();
                        }
                        break;
                    case 4:
                        codigoMoneda = "BRL";
                        busquedaCodigoMoneda = "USD";
                        jsonResponse = OperacionesConversor.getJsonResponseConversor(codigoMoneda);
                        responseJsonConversor = OperacionesConversor.getJsonConversor(jsonResponse);
                        valoresMonedas = responseJsonConversor.conversion_rates();
                        OperacionesConversor.setMostrarMensajeMonedas();
                        monedasAcambio = lecturaTeclado.nextDouble();
                        monedasAcambioCorrectas = OperacionesConversor.getValidaMonedaAcambio(monedasAcambio);
                        if (monedasAcambioCorrectas) {
                            valorMonedaBase = (double) valoresMonedas.get(codigoMoneda);
                            valorMonedaAcambio = (double) valoresMonedas.get(busquedaCodigoMoneda);
                            pesosConvertidos= OperacionesConversor.setConvertirMoneda(valorMonedaBase, monedasAcambio, valorMonedaAcambio);
                            OperacionesConversor.setMensajeREspuestaConversion(monedasAcambio, codigoMoneda, pesosConvertidos, busquedaCodigoMoneda);
                        } else {
                            OperacionesConversor.setMostrarMensajeErrorMonedas();
                        }
                        break;
                    case 5:
                        codigoMoneda = "USD";
                        busquedaCodigoMoneda = "COP";
                        jsonResponse = OperacionesConversor.getJsonResponseConversor(codigoMoneda);
                        responseJsonConversor = OperacionesConversor.getJsonConversor(jsonResponse);
                        valoresMonedas = responseJsonConversor.conversion_rates();
                        OperacionesConversor.setMostrarMensajeMonedas();
                        monedasAcambio = lecturaTeclado.nextDouble();
                        monedasAcambioCorrectas = OperacionesConversor.getValidaMonedaAcambio(monedasAcambio);
                        if (monedasAcambioCorrectas) {
                            valorMonedaBase = (double) valoresMonedas.get(codigoMoneda);
                            valorMonedaAcambio = (double) valoresMonedas.get(busquedaCodigoMoneda);
                            pesosConvertidos= OperacionesConversor.setConvertirMoneda(valorMonedaBase, monedasAcambio, valorMonedaAcambio);
                            OperacionesConversor.setMensajeREspuestaConversion(monedasAcambio, codigoMoneda, pesosConvertidos, busquedaCodigoMoneda);
                        } else {
                            OperacionesConversor.setMostrarMensajeErrorMonedas();
                        }
                        break;
                    case 6:
                        codigoMoneda = "COP";
                        busquedaCodigoMoneda = "USD";
                        jsonResponse = OperacionesConversor.getJsonResponseConversor(codigoMoneda);
                        responseJsonConversor = OperacionesConversor.getJsonConversor(jsonResponse);
                        valoresMonedas = responseJsonConversor.conversion_rates();
                        OperacionesConversor.setMostrarMensajeMonedas();
                        monedasAcambio = lecturaTeclado.nextDouble();
                        monedasAcambioCorrectas = OperacionesConversor.getValidaMonedaAcambio(monedasAcambio);
                        if (monedasAcambioCorrectas) {
                            valorMonedaBase = (double) valoresMonedas.get(codigoMoneda);
                            valorMonedaAcambio = (double) valoresMonedas.get(busquedaCodigoMoneda);
                            pesosConvertidos= OperacionesConversor.setConvertirMoneda(valorMonedaBase, monedasAcambio, valorMonedaAcambio);
                            OperacionesConversor.setMensajeREspuestaConversion(monedasAcambio, codigoMoneda, pesosConvertidos, busquedaCodigoMoneda);
                        } else {
                            OperacionesConversor.setMostrarMensajeErrorMonedas();
                        }
                        break;
                    case 7:
                        System.out.println("Gracias por utilizar el conversor de monedas");
                        break;
                    default:
                        System.out.println("Opcion desconocida");
                        System.out.println();
                }
            }

//            System.out.println();
//            System.out.println(jsonResponse);
//            System.out.println();
//            System.out.println(responseJsonConversor.conversion_rates());
//            System.out.println();

            /*
            mensjeSolicitudCodigo();
            while( (textoEnttrada = lecturaTeclado.nextLine()) != null && !textoEnttrada.isEmpty()) {
                boolean cadenaCorrecta = codigosAceptados.contains(textoEnttrada);
                if (cadenaCorrecta) {
                    break;
                } else {
                    System.out.println("Codigo incorrecto");
                    clearConsole();
                    mensjeSolicitudCodigo();
                }
            }
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static final void mensjeSolicitudCodigo() {
        System.out.println("Ingrese un codigo de busqueda para conversion de monedas");
    }

}
