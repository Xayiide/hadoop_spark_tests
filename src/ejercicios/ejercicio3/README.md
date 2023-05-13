# Ejercicio 3
## Enunciado
A partir de un fichero de entrada, devolver otro con una línea donde aparezca la palabra más frecuente y sus apariciones.
Ejemplo de fichero de entrada:
```
hola 2
que  4
tal  3
```
Fichero de salida correspondiente:
```
que 4
```

## Planteamiento
Partimos de un programa que a partir de un fichero de texto genérico, produce el tipo de fichero de entrada que buscamos (*WordCount.java*). Es decir, que a partir del siguiente fichero:
```
hola hola que que que que tal tal tal
```
*WordCount.java* nos producirá el siguiente fichero de salida:
```
hola 2
que  4
tal  3
```
El primer paso será replicar el comportamiento de *WordCount.java* en PySpark (con los cuadernos de Jupyter) para asegurarnos de que entendemos cómo se hace.
1. El comportamiento de *WordCount.java* queda replicado en [WordCountPySpark.ipynb](WordCountPySpark.ipynb).

El segundo paso es hacer los cambios pertinentes en *WordCount.java* para implementar este funcionamiento.  
2. Queda replicado en [TODO: hay que hacer esto].
