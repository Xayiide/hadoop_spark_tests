# Inicialización:
1. Entrar como root
2. Borrar datos anteriores del HDFS:  
`rm -rf /tmp/hadoop-root/*`
3. Formatear el HDFS (no borra datos):  
`hadoopc hdfs namenode -format`
4. Arrancar el HDFS:
`hadoopc start dfs`
5. Crea el directorio `/test` en el HDFS:  
`hadoopc hdfs dfs -mkdir /test`
6. Sube un fichero:  
`hadoopc hdfs dfs -put /etc/hadoop/hadoop-env.sh /test`
7. Descarga ese fichero:  
`hadoopc hdfs dfs -get /test/hadoop-env.sh /root/hadoop-env-2.sh`
8. Se puede comprobar que son el mismo fichero:  
`diff hadoop-env-2.sh /etc/hadoop/hadoop-env.sh`
9. Arrancamos MapReduce:  
`hadoopc start yarn`

Para comprobar que todo ha ido correctamente, accedemos a las siguientes páginas:
1. [HDFS](http://localhost:50070)
2. [MapReduce](http://localhost:8088)



