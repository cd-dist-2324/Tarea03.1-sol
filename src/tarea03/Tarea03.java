package tarea03;

public class Tarea03 {

    public final static int ARRAY_LENGTH = 3;
    protected final static String MSG_NULL = "El array no puede ser null";
    protected final static String MSG_LENGTH_ERROR = "El array debe tener " + ARRAY_LENGTH + " elementos";

    /**
     * Obtiene el máximo de los números almacenados en el array numeros
     * @param numeros array de ARRAY_LENGTH elementos enteros
     * @return el máximo de los números almacenados en el array numeros
     * @throws Exception si numeros es null o si no tiene la longitud indicada por la constante ARRAY_LENGTH
     */
    public int encontrarMax(int[] numeros) throws Exception{
        if(numeros==null)
        throw new Exception(MSG_NULL);

        if(numeros.length!=ARRAY_LENGTH){
            throw new Exception(MSG_LENGTH_ERROR);
        }

        int max = numeros[0];
        //partimos del primer elemento

        for(int i=1; i< numeros.length; i++){
            int current = numeros[i];
            if(current> max){
                max = current;
            }
        }
        return max;
    }
    
}
