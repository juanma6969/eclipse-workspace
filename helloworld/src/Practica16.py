'''
Created on 27 dic. 2020

@author: JuanManuel
'''
print("Dos vehiculos")
vO=int(input("Velocidad  v1: "))
vT=int(input("Velocidad  v2: "))
dTo=int(input("Distancia total: "))
vO=dTo/(vO-vT)
vO*=60
print("Lo alcanzara en ",abs(vO),"minutos ")