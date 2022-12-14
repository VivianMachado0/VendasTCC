
package util;

/**
 *
 * @author Vivian Machado
 *Converter a virgular de uma string para ponto
 * @param pString
 * @return double
 */
public class Formatador {
   public double converterVirgulaParaPonto(String pString){
       String retorno = new String();
       int tamanhoString = pString.length();
       for(int i = 0; i < tamanhoString; i++){
           if(pString.charAt(i) == ','){
               retorno += '.';
           }else{
               retorno += pString.charAt(i);
           }
       }
       return Double.parseDouble(retorno);
   } 
}
