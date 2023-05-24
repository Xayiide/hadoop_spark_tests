# Ejercicio 3
La entrega de la práctica 1 es la misma que la del [ejercicio3](../../ejercicios/ejercicio3).

1. [Enunciado](#enunciado)
2. [Planteamiento](#planteamiento)
3. [Solución](#solución)

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

## Solución
[WordCount.java](WordCount.java) produce un fichero de la forma:  
```  
hola 2
que 4
tal 3
```
[Maximo.java](Maximo.java) toma un fichero de esa forma y produce otro con la palabra más frecuente:  
```
que 4
```
Todo esto se realiza en un HDFS.
Para ello se tendrá que preparar el entorno. Como **root**:
```bash
rm -rf /tmp/hadoop-root/*      # Borrar datos anteriores del HDFS
hadoopc hdfs namenode -format  # Formatear el HDFS (no borra datos)
hadoopc start dfs              # Arrancar HDFS
hadoopc hdfs dfs -mkdir /SPAI  # Crear un directorio SPAI
hadoopc start yarn             # Arrancar MapReduce

# Nos aseguramos de que el fichero quijote.txt está subido
hadoopc hdfs dfs -put /root/quijote.txt /SPAI
```

Comprobamos que todo ha ido correctamente accediendo a estas páginas y abriendo el navegador de ficheros (en la página del HDFS).  
- [HDFS](http://localhost:50070)  
- [MapReduce](http://localhost:8088)  

Seguidamente nos aseguraremos de que en la ruta `/root/workspace/Hadoop_Test/src/` se encuentran los ficheros `WordCount.java` y `Maximo.java`. Para compilarlos haremos lo siguiente: 
```bash
# En /root/workspace/Hadoop_Test/src:
export JAVA_HOME=/usr/java/default
export PATH=$JAVA_HOME/bin:$PATH
export HADOOP_CLASSPATH=$JAVA_HOME/lib/tools.jar

# Compilar WordCount.java
/usr/local/hadoop/bin/hadoop com.sun.tools.javac.Main WordCount.java
jar cf wc.jar WordCount*.class

# Compilar Maximo.java
/usr/local/hadoop/bin/hadoop com.sun.tools.javac.Main Maximo.java
jar cf max.jar Maximo*.class
```

Ahora pasamos a ejecutar:  
```bash
# Ejecutamos WordCount:
hadoopc hadoop jar /root/workspace/Hadoop_Test/src/wc.jar WordCount /SPAI/quijote.txt /SPAI/WordCountOutput

# Ejecutamos Maximo:
hadoopc hadoop jar /root/workspace/Hadoop_Test/src/max.jar Maximo /SPAI/WordCountOutput/part-r-00000 /SPAI/MaximoOutput

# Recogemos el resultado:
hadoopc hdfs dfs -get /SPAI/MaximoOutput /root/MaximoOutput
```

Ahora sólo tenemos que comprobar que el resultado es correcto, haciendo `cat /root/MaximoOutput/part-r-00000`:  
> clave	que	19429  

Que podemos comprobar que es el mismo resultado que da el [ejercicio 3](../../ejercicios/ejercicio3/WordCountPySpark.ipynb).
