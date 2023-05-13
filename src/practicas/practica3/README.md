# Práctica 3
Tenemos que calcular medias y varianzas de un fichero de datos utilizando funciones map/reduce de Spark. Las funciones permitidas son:
 - textFile
 - map, flatmap
 - reduce, reduceByKey
 - filter
 - count

Se puede verificar que la solución propuesta es correcta usando las funciones `rdd.mean()` y `rdd.stdev()`.  

Hay 3 versiones que tenemos que realizar:  
 1. Calcular la media y varianza para la columna 4.
 2. Utilizar operaciones de vectorización de Python y arrays de Numpy, utilizar la misma estructura de código de la versión 1 para calcular las medias y varianzas de todas las columnas.
 3. Transformar cada celda en un elemento *(j, v)* donde *j* es la columna de la celda y *v* es el valor de la celda del RDD. Resolver el problema con esta nueva estructura del conjunto de datos.


