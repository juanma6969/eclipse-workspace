'''
Created on 27 dic. 2020

@author: JuanManuel
'''
print ("Dime la base de un rectangulo y su altura ")
base=float(input("Introduce la base :"))
altura=float(input("Introduce la altura :"))
#Perimetro
p=((base + altura) * 2)
#Area
altura=(base * altura)
print("El area y el perimetro son  %f cm2 , %f cm  "   %(altura,p))