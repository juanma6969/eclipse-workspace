'''
Created on 27 dic. 2020

@author: JuanManuel
'''
print ("Distancia")
pO=float(input("Introduce el punto x 1:"))
pT=float(input("Introduce el punto x 2:"))
pO=pO-pT
pOt=float(input("Introduce el punto y 1:"))
pT=float(input("Introduce el punto y 2:"))
pT=pOt-pT
print("La distancia en el eje X ",abs(pO),"cm")
print("La distancia en el eje Y ",abs(pT),"cm")