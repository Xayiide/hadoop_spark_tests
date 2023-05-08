# Ficheros de ejemplo
Sirven de ejemplo para las llamadas de pyspark.

## 1\_map\_reduce:
Se quiere ejemplificar en este ejemplo que es necesario que las funciones que ejecuta el `reduce` deben cumplir la propiedad asociativa y conmutativa o darán resultados diferentes en cada caso, y muchas veces no serán el esperado.  

## 2\_filter:
Se llama a `filter` sobre el RDD *rdd1*. La función devuelve los valores que cumplen con el lambda pasado por parámetro, en este caso los números pares. Luego se suman con un `reduce` como antes. El resultado es 20, que es la suma de los números pares entre el 1 y el 9.  

## 3\_flatMap:
Se llama a `flatMap` sobre el rango de números del 1 al 4 (incluidos ambos). El `flatMap` recibe un lambda que como argumento recibe un número y devuelve el rango de 0 a ese número menos uno. Luego todos los elementos se suman con un `reduce`.  

A partir de este ejemplo todo es "bastante explicativo".

