# ProgAvanzadaTP1

IMPORTANTE – Aclaraciones
El trabajo practico (código fuente) deberá de ser copiado a la carpeta drive compartida.
Se tendrá en cuenta para la evaluación de lo realizado, buenas prácticas del diseño, que 
cumpla con todas las características de POO, comentarios del código y adecuada 
legibilidad.
Temas evaluados: 
-> Clases de utilidad (String, Math y Fechas).
-> Enumeradores.
-> Colecciones.
-> Manejo de Excepciones.
-> API Stream.
-> Properties.
-> Uso de archivos planos (String).


Práctica:
Construir la clase Construcciones, la cual no podrá instanciarse, con los siguientes datos 
miembro: 
∙ double superficiePorM2 
∙ String direccion 
∙ double precioPorM2 
y el siguiente comportamiento: 
∙ constructor, que deberá tomar como parámetros obligatorios valores para los tres datos 
miembro y los inicializará con dichos valores 
∙ una función para mostrar y otra para actualizar los datos miembros (individuales para cada 
uno de ellos) 
∙ mostrarCaracteristicas, que deberá mostrar los datos miembro 
Construir una clase Edificios que heredará de Construcciones y, además, tendrá los siguientes 
datos miembro: 
∙ int pisos 
∙ int unidades 
y el siguiente comportamiento: 
∙ constructor, que deberá tomar como parámetros obligatorios valores para los tres datos de la 
clase base y los dos propios y los inicializará con dichos valores 
∙ una función para mostrar y otra para actualizar los datos miembros propios (individuales para 
cada uno de ellos) 
∙ mostrarCaracteristicas, que deberá mostrar los datos miembro de la clase base (utilizando la 
función de la clase base) y los datos miembro propios dando formato y titulando cada dato. 
Además se mostrara el precio del edificio. 
Construir una clase Casas que heredará de Construcciones y, además, tendrá los siguientes 
datos miembro: 
∙ int ambientes 
∙ Orientacion orientacion 
y el siguiente comportamiento: 
∙ constructor, que deberá tomar como parámetros obligatorios valores para los tres datos de la 
clase base y los dos propios y los inicializará con dichos valores 
∙ una función para mostrar y otra para actualizar los datos miembros propios (individuales para 
cada uno de ellos) 
∙ mostrarCaracteristicas, que deberá mostrar los datos miembro de la clase base (utilizando la 
función de la clase base) y los datos miembro propios dando formato y titulando cada dato. 
Además se mostrará el precio de la casa. 
Construir una aplicación de consola que al menos se distribuyan las clases que considere
necesario crear en los siguientes paquetes negocio, persistencia y presentación. El programa 
deberá: 
∙ Poder ingresar nuevas construcciones sin perder las ya ingresadas con anterioridad.
∙ Generar una lista de construcciones, a partir de archivo de texto que considere necesario 
generar. 
∙ Imprimir en pantalla los datos de dichas construcciones. 
∙ Mostrar por pantalla las construcciones que se encuentren entre un rango de precio. 
∙ A las construcciones obtenidas del punto anterior, se debe de volver a calcular el precio 
sumándole el IVA (21%). 
∙ La lista de construcciones generada, deberán de persistirse en un archivo con el siguiente 
nombre construc_ddMMyyyy.txt.
Queda a libre criterio la selección de donde aplicar cada uno de los temas evaluados en el TP, 
pero si o si deben de estar todos los mismos aplicados
