import findspark
findspark.init()
import pyspark
from pyspark import SparkContext

sc  = SparkContext("local[*]", "stdev_example")
rdd = sc.textFile("../../../datos/data_ok.csv")
cuartos = rdd.map(lambda x: float(x.split(" ")[3]))
media   = cuartos.reduce(lambda x, y: x + y)/rdd.count()

lista = cuartos.collect()

suma = 0
for i in lista:
	parc = (i - media) ** 2
	suma += parc

suma /= cuartos.count()
print("Varianza:", str(suma), "[{}]".format(cuartos.variance()))
print("Desviación típica:", str(suma ** 0.5), "[{}]".format(cuartos.stdev()))
