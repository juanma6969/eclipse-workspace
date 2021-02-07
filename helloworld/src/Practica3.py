'''
Created on 27 dic. 2020

@author: JuanManuel
'''
import math
print ("Dime los catetos de un triangulo ")
cO=float(input("Introduce el primer cateto :"))
cT=float(input("Introduce el segundo cateto :"))
#Perimetro
cO=((cT**2)+ ( cO**2))
cT=math.sqrt(cO)
print("La hipotenusa  es   %.2f "   %(cT))