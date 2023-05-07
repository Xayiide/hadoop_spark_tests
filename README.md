# Instrucciones para arrancar Spark con Jupyter
1. Activación  
`conda activate py37`  
`jupyter notebook &`

2. Crear solamente el *python3 kernel*. NO usar *Apache Toree*  

3. Para poder usar las primitivas de Spark, añadir estas líneas en la primera celda del notebook:
```python
import findspark
findspark.init()
import pyspark
from pyspark import SparkContext
```


### Para fijar el número de núcleos:
`sc = SparkContext("local[N]")", "Name of the program")`
> Donde N Es el número de núcleos.

### Para usar todos los núcleos:
`sc = SparkContext("local[*]")", "Name of the program")`


### Probar la siguiente fase
```python
rdd1 = sc.parallelize([1, 2, 3, 4, 5, 8])
res  = rdd1.reduce(lambda x, y: x + y)
print("result:", res)
```
> result: 23


### Para parar el SparkContext:
`sc.stop()`
